package com.huotn.cloud.resource.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.order.controller
 * @date:2020-08-19
 */
//@RestController
//@RequestMapping("/orders")
public class OrderApiController_v1 {


//    @RequestMapping("/create")
//    @PostMapping
    public Object create(@RequestBody Map<String,Object> map, @AuthenticationPrincipal String username){
        System.out.println("user is  "+username);
        return username;
    }

}