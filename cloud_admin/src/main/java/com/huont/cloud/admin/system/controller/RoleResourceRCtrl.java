package com.huont.cloud.admin.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.huont.cloud.admin.system.service.RoleResourceRService;
import com.huont.cloud.admin.system.entity.RoleResourceR;

import javax.annotation.Resource;

/**
 * <p>
 * 控制器
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@RestController
@RequestMapping("/cloud_admin/roleResourceR")
public class RoleResourceRCtrl {

    private Logger logger = LoggerFactory.getLogger(RoleResourceRCtrl.class);

    @Resource(name = "roleResourceRServiceImpl")
    private RoleResourceRService roleResourceRService;

    @RequestMapping("index")
    public RoleResourceR index() {
        return roleResourceRService.getById("xxxx");
    }


}
