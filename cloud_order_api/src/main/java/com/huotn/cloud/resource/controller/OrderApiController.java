package com.huotn.cloud.resource.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.order.controller
 * @date:2020-08-19
 */
@RestController
@RequestMapping("/orders")
public class OrderApiController {


    @PostMapping
    public Object create(@RequestBody Map<String,Object> map, @RequestHeader String username){  //RequestHeader 从网关授权设置的header中取
        System.out.println("user is  "+username);
        return username;
    }

}
