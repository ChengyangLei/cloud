package com.huont.cloud.admin.system.service;

import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.system.entity.vo.RoleVo;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
public interface RoleService extends IService<Role> {

    Result saveRole(Role role);

    Result updateRole(Role role);

    Result queryRoleDetailsByUserId(RoleVo roleVo);

    Result queryRole4Paging(RoleVo roleVo);

    Result deleteRole(RoleVo roleVo);
}
