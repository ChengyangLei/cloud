package com.huont.cloud.admin.system.controller;


import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.User;
import com.huont.cloud.admin.system.entity.vo.UserVo;
import com.huont.cloud.admin.config.UserInfoServiceI;
import com.huont.cloud.admin.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 记录系统的用户信息包括账号信息，用户相关信息,登录登出等 前端控制器
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/system/user")
public class UserCtrl {

    private Logger logger = LoggerFactory.getLogger(UserCtrl.class);

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping("index")
    public User index() {
        return userService.getById("xxxx");
    }

    @RequestMapping("addUser")
    public Result addUser(@RequestBody User user, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return userService.saveUser(setUserInfo(user, userInfoServiceI, "ADD"));
    }

    @RequestMapping("updateUser")
    public Result updateUser(@RequestBody User user, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return userService.updateUser(setUserInfo(user, userInfoServiceI, null));
    }

    @RequestMapping("queryUserById")
    public Result queryUserById(@RequestBody UserVo userVo) {
        return userService.queryUserDetailsByUserId(userVo);
    }

    @RequestMapping("queryUser4Paging")
    public Result queryUser4Paging(@RequestBody UserVo userVo) {
        return userService.queryUser4Paging(userVo);
    }

    @RequestMapping("deleteUser")
    public Result deleteUser(@RequestBody UserVo userVo) {
        return userService.deleteUser(userVo);
    }

    private User setUserInfo(User user, UserInfoServiceI userInfoServiceI, String type) {
        Assert.isTrue(user != null, "部门不能为空");
        if ("ADD".equals(type)) {
            user.setCreator(userInfoServiceI.getId());
            user.setCreateTime(LocalDateTime.now());
            if(user.getExpiryDate() == null) {
                user.setExpiryDate(LocalDate.of(9999,01,01));
            }
        }
        user.setLastUpdator(userInfoServiceI.getId());
        user.setLastUpdateTime(LocalDateTime.now());
        user.setDelFlag(DataProperty.DelFlag.NO_DEL.getVal());
        return user;
    }

}
