package com.huotn.cloud.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:leichengyang
 * @desc:com.huotn.cloud.api.controller
 * @date:2020-08-12
 */

@RestController
public class ApiController {


    @RequestMapping("/getApi")
    public Object getApi(){
        return "{'id':'1','name':'ww'}";
    }
}
