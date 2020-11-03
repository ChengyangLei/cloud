package com.huotn.cloud.resource.controller;

import com.huotn.cloud.resource.config.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.order.controller
 * @date:2020-08-19
 */
@RestController
@RequestMapping("/orders")
public class OrderApiController_v2 {


    @RequestMapping("/create")
    @PostMapping
    public Object create(@RequestBody Map<String,Object> map, @AuthenticationPrincipal User user){
        System.out.println("user is  "+user.getId());
        return user;
    }

}
