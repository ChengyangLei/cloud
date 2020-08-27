package com.huotn.cloud.resource.controller;

import com.huotn.cloud.resource.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.api.controller
 * @date:2020-08-13
 */
@RequestMapping("user")
@RestController
public class UserController {


    @GetMapping("/{id}")
    public User get(@PathVariable Long id, HttpServletRequest request){
        User user = (User) request.getAttribute("user");
        if (user==null || !user.getId().equals(id)){
            throw new RuntimeException("身份认证信息异常，获取用户信息失败");
        }
        return user;
    }
}
