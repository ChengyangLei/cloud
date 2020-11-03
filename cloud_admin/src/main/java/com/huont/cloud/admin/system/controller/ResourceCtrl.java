package com.huont.cloud.admin.system.controller;


import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.config.UserInfoServiceI;
import com.huont.cloud.admin.system.entity.HResource;
import com.huont.cloud.admin.system.entity.User;
import com.huont.cloud.admin.system.entity.vo.ResourceVo;
import com.huont.cloud.admin.system.entity.vo.UserVo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.huont.cloud.admin.system.service.ResourceService;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 记录系统资源信息(权限) 控制器
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@RestController
@RequestMapping("/system/resource")
public class ResourceCtrl {

    private Logger logger = LoggerFactory.getLogger(ResourceCtrl.class);

    @Resource(name = "resourceServiceImpl")
    private ResourceService resourceService;


    @RequestMapping("addResource")
    public Result addResource(@RequestBody HResource resource, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return resourceService.saveResource(setResourceInfo(resource, userInfoServiceI, "ADD"));
    }

    @RequestMapping("updateResource")
    public Result updateResource(@RequestBody HResource resource, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return resourceService.updateResource(setResourceInfo(resource, userInfoServiceI, null));
    }

    @RequestMapping("queryResourceById")
    public Result queryResourceById(@RequestBody ResourceVo ResourceVo) {
        return resourceService.queryResourceDetailsByResourceId(ResourceVo);
    }

    @RequestMapping("queryResource4Paging")
    public Result queryResource4Paging(@RequestBody ResourceVo ResourceVo) {
        return resourceService.queryResource4Paging(ResourceVo);
    }

    @RequestMapping("deleteResource")
    public Result deleteResource(@RequestBody ResourceVo ResourceVo) {
        return resourceService.deleteResource(ResourceVo);
    }

    private HResource setResourceInfo(HResource resource, UserInfoServiceI userInfoServiceI, String type) {
        Assert.isTrue(resource != null, "部门不能为空");
        if ("ADD".equals(type)) {
            resource.setCreator(userInfoServiceI.getId());
            resource.setCreateTime(LocalDateTime.now());
        }
        resource.setLastUpdator(userInfoServiceI.getId());
        resource.setLastUpdateTime(LocalDateTime.now());
        resource.setDelFlag(DataProperty.DelFlag.NO_DEL.getVal());
        return resource;
    }





}
