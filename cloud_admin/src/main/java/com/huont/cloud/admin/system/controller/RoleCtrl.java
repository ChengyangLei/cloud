package com.huont.cloud.admin.system.controller;


import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.config.UserInfoServiceI;
import com.huont.cloud.admin.system.entity.vo.RoleVo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.huont.cloud.admin.system.service.RoleService;
import com.huont.cloud.admin.system.entity.Role;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色 控制器
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@RestController
@RequestMapping("/system/role")
public class RoleCtrl {

    private Logger logger = LoggerFactory.getLogger(RoleCtrl.class);

    @Resource(name = "roleServiceImpl")
    private RoleService roleService;

    @RequestMapping("index")
    public Role index() {
        return roleService.getById("xxxx");
    }


    @RequestMapping("addRole")
    public Result addRole(@RequestBody Role role, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return roleService.saveRole(setRoleInfo(role, userInfoServiceI, "ADD"));
    }

    @RequestMapping("updateRole")
    public Result updateRole(@RequestBody Role role, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return roleService.updateRole(setRoleInfo(role, userInfoServiceI, null));
    }

    @RequestMapping("queryRoleById")
    public Result queryRoleById(@RequestBody RoleVo roleVo) {
        return roleService.queryRoleDetailsByUserId(roleVo);
    }

    @RequestMapping("queryRole4Paging")
    public Result queryRole4Paging(@RequestBody RoleVo roleVo) {
        return roleService.queryRole4Paging(roleVo);
    }


    @RequestMapping("deleteRole")
    public Result deleteRole(@RequestBody RoleVo roleVo) {
        return roleService.deleteRole(roleVo);
    }

    private Role setRoleInfo(Role role, UserInfoServiceI userInfoServiceI, String type) {
        Assert.isTrue(role != null, "部门不能为空");
        if ("ADD".equals(type)) {
            role.setCreator(userInfoServiceI.getId());
            role.setCreateTime(LocalDateTime.now());
        }
        role.setLastUpdator(userInfoServiceI.getId());
        role.setLastUpdateTime(LocalDateTime.now());
        role.setDelFlag(DataProperty.DelFlag.NO_DEL.getVal());
        return role;
    }


}
