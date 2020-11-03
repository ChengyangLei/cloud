package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.common.util.ConvertUtils;
import com.huont.cloud.admin.common.util.MD5Util;
import com.huont.cloud.admin.system.dao.UserMapper;
import com.huont.cloud.admin.system.entity.*;
import com.huont.cloud.admin.system.entity.vo.UserDeptRVo;
import com.huont.cloud.admin.system.entity.vo.UserJobRVo;
import com.huont.cloud.admin.system.entity.vo.UserRoleRVo;
import com.huont.cloud.admin.system.entity.vo.UserVo;
import com.huont.cloud.admin.system.service.*;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 记录系统的用户信息包括账号信息，用户相关信息,登录登出等 服务实现类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
@Service(value = "userServiceImpl")
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource(name = "userDepRServiceImpl")
    private UserDepRService userDepRService;

    @Resource(name = "userRoleRServiceImpl")
    private UserRoleRService userRoleRService;

    @Resource(name = "userJobRServiceImpl")
    private UserJobRService userJobRService;

    @Resource(name = "organizationServiceImpl")
    private OrganizationService organizationService;

    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;

    @Override
    public Result saveUser(User user) {
        //1、保存用户信息
        user.setPassword(MD5Util.md5Encode(user.getPassword()));
        this.saveOrUpdate(user);
        //2、保存用户所属部门信息
        this.userDepRService.saveUserDeptR(getUerDeptR(user));
        //3、保存用户角色信息
        this.userRoleRService.saveUserRoleR(getUserRoleR(user));
        //4、保存用户岗位信息
        this.userJobRService.saveUserJobR(getUserJobR(user));
        return Result.getSuccessInstance();
    }

    @Override
    public Result updateUser(User user) {
        //1、删除部门、角色、岗位信息
        this.deleteRelationData(user);
        //2、保存用户信息
        this.saveUser(user);
        return Result.getSuccessInstance();
    }

    @Override
    public Result deleteUser(UserVo userVo) {
        this.removeById(userVo.getId());
        this.deleteRelationData(userVo);
        return Result.getSuccessInstance();
    }

    @Override
    public Result queryUserDetailsByUserId(UserVo userVo) {
        //1、查询基本信息
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("STATUS", DataProperty.Status.VALID.getVal());
        queryWrapper.eq("DEL_FLAG", DataProperty.DelFlag.NO_DEL.getVal());
        queryWrapper.eq("ID", userVo.getId());
        User user = this.getOne(queryWrapper);
        Collection<Map> depts = null, roles = null, jobs = null;
        if (user != null) {
            //2、查询部门、角色、岗位信息
            depts = this.userDepRService.queryUserDeptByUserId(new UserDeptRVo(userVo.getId()));
            roles = this.userRoleRService.queryUserRoleByUserId(new UserRoleRVo(userVo.getId()));
            jobs = this.userJobRService.queryUserJobByUserId(new UserJobRVo(user.getId()));
        }
        return Result.getSuccessInstance().put("userInfo", user).put("depts", depts).put("roles", roles).put("jobs", jobs);
    }

    @Override
    public Result queryUser4Paging(UserVo userVo) {
        Collection<String> divIds;
        Page page = new Page();
        if (StringUtils.hasLength(userVo.getCurrent())) {
            page.setCurrent(Long.valueOf(userVo.getCurrent()));
        }
        if (StringUtils.hasLength(userVo.getSize())) {
            page.setSize(Long.valueOf(userVo.getSize()));
        }
        divIds = getDivIds(userVo);
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("word", userVo.getWord());
        queryM.put("devIds", divIds);
        IPage<List<Map<String, Object>>> userL = this.getBaseMapper().queryUserPaging(page, queryM);
        buildDepRoleJob4User(userL);
        return ConvertUtils.convertIpage2Result(userL);
    }

    /**
     * 为用户列表构建部门、角色、岗位信息
     *
     * @param userL
     */
    private void buildDepRoleJob4User(IPage<List<Map<String, Object>>> userL) {
        if (!CollectionUtils.isEmpty(userL.getRecords())) {
            //处理用户的部门信息、角色信息、岗位信息
            Collection<String> userIds = ConvertUtils.convertElementPropertyToList(userL.getRecords(), "ID");
            logger.info(userIds.toString());
            //查询部门信息、角色信息、岗位信息
            Collection<Map> userDepM = this.userDepRService.queryUserDeptByUserIds(userIds);
            Collection<Map> userRolM = this.userRoleRService.queryUserRoleByUserIds(userIds);
            Collection<Map> userJobM = this.userJobRService.queryUserJobByUserIds(userIds);
            List ul = userL.getRecords();
            Iterator iter = ul.iterator();
            while (iter.hasNext()) {
                Map userI = (Map) iter.next();
                String userId = MapUtils.getString(userI, "ID");
                String userDepts = ConvertUtils.convertElementPropertyToString(ConvertUtils.convertElementWithValToList(userDepM, "USER_ID", userId), "NAME", ",");
                String userRols = ConvertUtils.convertElementPropertyToString(ConvertUtils.convertElementWithValToList(userRolM, "USER_ID", userId), "NAME", ",");
                String userJobs = ConvertUtils.convertElementPropertyToString(ConvertUtils.convertElementWithValToList(userJobM, "USER_ID", userId), "NAME", ",");
                userI.put("USER_DEPT_INFO", userDepts);
                userI.put("USER_ROLE_INFO", userRols);
                userI.put("USER_JOB_INFO", userDepts);
            }
        }
    }

    /**
     * 获取部门ID集合
     *
     * @param userVo
     * @return
     */
    private Collection<String> getDivIds(UserVo userVo) {
        Collection<String> divIds = null;
        if (StringUtils.hasLength(userVo.getOrgId()) && !"-1".equals(userVo.getOrgId())) {
            //查询指定组织机构的所有子节点
            Collection<String> orgIds4Query = new ArrayList<>();
            orgIds4Query.add(userVo.getOrgId());
            Collection<Organization> childOrgs = organizationService.queryOrganizationRecursion(orgIds4Query);
            List orgIds = ConvertUtils.convertElementPropertyToList(childOrgs, "id");
            orgIds.add(userVo.getOrgId());
            //查询指定组织机构下的所有部门节点
            QueryWrapper<Department> wrapper = new QueryWrapper();
            wrapper.in("ORGANIZATION_ID", orgIds);
            List<Department> deptsUnderOga = departmentService.list(wrapper);
            if (!CollectionUtils.isEmpty(deptsUnderOga)) {
                divIds = ConvertUtils.convertElementPropertyToList(deptsUnderOga, "id");
            }
        } else if (StringUtils.hasLength(userVo.getDevId()) && !"-1".equals(userVo.getOrgId())) {
            //查询指定部门的所有子节点
            Collection<String> divIds4Query = new ArrayList<>();
            divIds4Query.add(userVo.getDevId());
            Collection<Department> childDivs = departmentService.queryDepartmentRecursion(divIds4Query);
            divIds = ConvertUtils.convertElementPropertyToList(childDivs, "id");
            divIds.add(userVo.getDevId());
        }
        return divIds;
    }

    private Result deleteRelationData(User user) {
        if (StringUtils.hasLength(user.getDeptIds())) {
            userDepRService.deleteUserDeptRByUserId(new UserDeptRVo(user.getId()));
        }
        if (StringUtils.hasLength(user.getRoleIds())) {
            userRoleRService.deleteUserRoleRByUserId(new UserRoleRVo(user.getId()));
        }
        if (StringUtils.hasLength(user.getJobIds())) {
            userJobRService.deleteUserJobRByUserId(new UserJobRVo(user.getId()));
        }
        return Result.getSuccessInstance();
    }

    private Result deleteRelationData(UserVo userVo) {
        userDepRService.deleteUserDeptRByUserId(new UserDeptRVo(userVo.getId()));
        userRoleRService.deleteUserRoleRByUserId(new UserRoleRVo(userVo.getId()));
        userJobRService.deleteUserJobRByUserId(new UserJobRVo(userVo.getId()));
        return Result.getSuccessInstance();
    }

    private Set<UserDepR> getUerDeptR(User user) {
        Set<UserDepR> set4UserDeptR = new HashSet<>();
        if (StringUtils.hasLength(user.getDeptIds())) {
            Set<String> set4DeptIds = StringUtils.commaDelimitedListToSet(user.getDeptIds());
            Iterator<String> iterator = set4DeptIds.iterator();
            int flag = 0;
            while (iterator.hasNext()) {
                UserDepR userDepR = new UserDepR();
                userDepR.setUserId(user.getId());
                userDepR.setDeptId(iterator.next());
                //1：主部门；0：非主部门
                userDepR.setIsMajor(flag++ == 0 ? "1" : "0");
                set4UserDeptR.add(userDepR);
            }
            return set4UserDeptR;
        }
        return set4UserDeptR;
    }

    private Set<UserRoleR> getUserRoleR(User user) {
        Set<UserRoleR> set4UserRoleR = new HashSet<>();
        if (StringUtils.hasLength(user.getRoleIds())) {
            Set<String> set4RoleIds = StringUtils.commaDelimitedListToSet(user.getRoleIds());
            Iterator<String> iterator = set4RoleIds.iterator();
            int flag = 0;
            while (iterator.hasNext()) {
                UserRoleR userRoleR = new UserRoleR();
                userRoleR.setUserId(user.getId());
                userRoleR.setRoleId(iterator.next());
                //1：主部门；0：非主部门
                userRoleR.setIsMajor(flag++ == 0 ? "1" : "0");
                set4UserRoleR.add(userRoleR);
            }
            return set4UserRoleR;
        }
        return set4UserRoleR;
    }

    private Set<UserJobR> getUserJobR(User user) {
        Set<UserJobR> set4JobRoleR = new HashSet<>();
        if (StringUtils.hasLength(user.getJobIds())) {
            Set<String> set4JobIes = StringUtils.commaDelimitedListToSet(user.getJobIds());
            Iterator<String> iterator = set4JobIes.iterator();
            int flag = 0;
            while (iterator.hasNext()) {
                UserJobR userJobR = new UserJobR();
                userJobR.setUserId(user.getId());
                userJobR.setJobId(iterator.next());
                //1：主部门；0：非主部门
                userJobR.setIsMajor(flag++ == 0 ? "1" : "0");
                set4JobRoleR.add(userJobR);
            }
            return set4JobRoleR;
        }
        return set4JobRoleR;
    }

}
