package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.common.util.ConvertUtils;
import com.huont.cloud.admin.system.dao.DepartmentMapper;
import com.huont.cloud.admin.system.dao.OrganizationMapper;
import com.huont.cloud.admin.system.entity.Department;
import com.huont.cloud.admin.system.entity.vo.DepartmentVo;
import com.huont.cloud.admin.system.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 描述系统的部门信息 服务实现类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-22
 */
@Service(value = "departmentServiceImpl")
@Transactional
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Result saveDepartment(Department department) {
        this.save(department);
        return Result.getSuccessInstance();
    }

    @Override
    public Result updateDepartment(Department department) {
        this.updateById(department);
        return Result.getSuccessInstance();
    }

    @Override
    public Result deleteDepartment(DepartmentVo departmentVo) {
        Collection<Department> departments = this.queryDepartmentRecursion(Arrays.asList(departmentVo.getId()));
        List<String> ids = ConvertUtils.convertElementPropertyToList(departments, "id");
        ids.add(departmentVo.getId());
        this.removeByIds(ids);
        return Result.getSuccessInstance();
    }

    @Override
    public Result queryDepartmentById(DepartmentVo departmentVo) {
        Department department = this.getById(departmentVo.getId());
        return Result.getSuccessInstance().put("departmentDetails", department);
    }

    @Override
    public Result queryDepartmentByPid(DepartmentVo departmentVo) {
        return Result.getSuccessInstance().put("childDepartments", this.queryDepartmentByPid(Arrays.asList(departmentVo.getPid())));
    }

    @Override
    public Collection<Department> queryDepartmentRecursion(Collection<String> pids) {
        Collection<Department> childrenIds = this.queryDepartmentByPid(pids);
        Collection<Department> allIds = new ArrayList<>(childrenIds);
        if (childrenIds != null && childrenIds.size() > 0) {
            Collection<Department> grandIds = queryDepartmentRecursion(ConvertUtils.convertElementPropertyToList(childrenIds, "id"));
            if (grandIds != null && grandIds.size() > 0) {
                allIds.addAll(grandIds);
            }
            return allIds;
        }
        return allIds;
    }

    @Override
    public Result queryOrgDepTree(DepartmentVo departmentVo) {
        Collection<Map> nodes = new ArrayList<>();
        if ("ORG".equals(departmentVo.getType())) {
            //组织机构部门混合树
            Map queryM = new HashMap();
            queryM.put("orgId", departmentVo.getOrgId());
            //查询组织机构数据
            Collection<Map> organizations = organizationMapper.queryOrganization4Tree(queryM);
            if (!DepartmentService.ROOT_ID.equals(departmentVo.getOrgId())) {
                //当orgId != -1时，查询部门数据
                queryM.put("devId", "-1");
                Collection<Map> departments = this.departmentMapper.queryDepartment4Tree(queryM);
                nodes.addAll(departments);
            }
            nodes.addAll(organizations);
        } else if ("DEV".equals(departmentVo.getType())) {
            //查询部门时，只需要传递父节点ID，无需组织机构ID
            Map queryM = new HashMap();
            queryM.put("devId", departmentVo.getDevId());
            //部门树
            Collection<Map> departments = this.departmentMapper.queryDepartment4Tree(queryM);
            nodes.addAll(departments);
        }
        return Result.getSuccessInstance().put("childNodes", nodes);
    }

    @Override
    public Result queryDepTree(DepartmentVo departmentVo) {
        Map queryM = new HashMap();
        queryM.put("devId", departmentVo.getDevId());
        Collection<Map> departments = this.departmentMapper.queryDepartment4Tree(queryM);
        return Result.getSuccessInstance().put("childNodes", departments);
    }

    private Collection<Department> queryDepartmentByPid(Collection<String> pids) {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.orderByAsc("ORDER_INDEX");
        queryWrapper.in("PID", pids);
        queryWrapper.eq("DEL_FLAG", DataProperty.DelFlag.NO_DEL.getVal());
        queryWrapper.eq("STATUS", DataProperty.Status.VALID.getVal());
        List<Department> departments = this.list(queryWrapper);
        return departments;
    }

}
