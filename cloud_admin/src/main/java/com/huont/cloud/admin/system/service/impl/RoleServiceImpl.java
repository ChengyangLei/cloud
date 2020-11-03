package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.common.util.ConvertUtils;
import com.huont.cloud.admin.system.entity.HResource;
import com.huont.cloud.admin.system.entity.Role;
import com.huont.cloud.admin.system.dao.RoleMapper;
import com.huont.cloud.admin.system.entity.vo.RoleVo;
import com.huont.cloud.admin.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
    * 角色 服务实现类
    * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@Service(value = "roleServiceImpl")
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public Result saveRole(Role role) {
        //1、保存资源菜单
        this.saveOrUpdate(role);
        return Result.getSuccessInstance();
    }

    @Override
    public Result updateRole(Role role) {
        //2、保存用户信息
        this.updateById(role);
        return Result.getSuccessInstance();
    }

    @Override
    public Result queryRoleDetailsByUserId(RoleVo roleVo) {
        //1、查询基本信息
        QueryWrapper<Role> queryWrapper = new QueryWrapper();
        queryWrapper.eq("STATUS", DataProperty.Status.VALID.getVal());
        queryWrapper.eq("DEL_FLAG", DataProperty.DelFlag.NO_DEL.getVal());
        queryWrapper.eq("ID", roleVo.getId());
        Role role = this.getOne(queryWrapper);
        return Result.getSuccessInstance().put("role", role);
    }

    @Override
    public Result queryRole4Paging(RoleVo roleVo) {
        Collection<String> divIds;
        Page page = new Page();
        if (StringUtils.hasLength(roleVo.getCurrent())) {
            page.setCurrent(Long.valueOf(roleVo.getCurrent()));
        }
        if (StringUtils.hasLength(roleVo.getSize())) {
            page.setSize(Long.valueOf(roleVo.getSize()));
        }
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("word", roleVo.getWord());
        IPage<List<Map<String, Object>>> userL = this.getBaseMapper().queryUserPaging(page, queryM);
        return ConvertUtils.convertIpage2Result(userL);
    }

    @Override
    public Result deleteRole(RoleVo roleVo) {
        this.removeById(roleVo.getId());
        return Result.getSuccessInstance();
    }
}
