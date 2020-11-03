package com.huont.cloud.admin.system.controller;


import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.Organization;
import com.huont.cloud.admin.system.entity.vo.OrganizationVo;
import com.huont.cloud.admin.config.UserInfoServiceI;
import com.huont.cloud.admin.system.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 组织机构的基本信息，包括水行政主管部门、水利事业单位、乡镇水利管理单位，以及为水利提供服务的企业、社会团体等单位的基本信息 前端控制器
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-17
 */
@RestController
@RequestMapping("/system/organization")
public class OrganizationCtrl {

    private Logger logger = LoggerFactory.getLogger(OrganizationCtrl.class);

    @Resource(name = "organizationServiceImpl")
    private OrganizationService organizationService;

    @RequestMapping("index")
    public Organization index() {
        return organizationService.getById("xxxx");
    }

    @RequestMapping("addOrganization")
    public Result addOrganization(@RequestBody Organization organization, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return organizationService.saveOrganization(setOrganizationInfo(organization, userInfoServiceI, "ADD"));
    }

    @RequestMapping("queryOrganizationById")
    public Result queryOrganizationById(@RequestBody OrganizationVo organizationVo) {
        return organizationService.queryOrganizationDetailsById(organizationVo);
    }

    @RequestMapping("QueryOrganization4Paging")
    public Result queryOrganization4Paging(@RequestBody OrganizationVo organizationVo) {
        return organizationService.queryChildOrganizationByParentId(organizationVo);
    }

    @RequestMapping("queryOrganizationTree")
    public Result queryOrganizationTree(@RequestBody OrganizationVo organizationVo) {
        //强制设置第一页、每页显示1000
        organizationVo.setSize("1000");
        organizationVo.setCurrent("1");
        return organizationService.queryChildOrganization(organizationVo);
    }

    @RequestMapping("updateOrganization")
    public Result updateOrganization(@RequestBody Organization organization, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return organizationService.updateOrganization(setOrganizationInfo(organization, userInfoServiceI, null));
    }

    @RequestMapping("deleteOrganization")
    public Result deleteOrganization(@RequestBody OrganizationVo organizationVo) {
        return organizationService.deleteOrganization(organizationVo);
    }

    private Organization setOrganizationInfo(Organization organization, UserInfoServiceI userInfoServiceI, String type) {
        Assert.isTrue(organization != null, "行政区划不能为空");
        if ("ADD".equals(type)) {
            organization.setCreateTime(LocalDateTime.now());
            organization.setCreator(userInfoServiceI.getId());
        }
        organization.setDelFlag("0");
        organization.setLastUpdator(userInfoServiceI.getId());
        organization.setLastUpdateTime(LocalDateTime.now());
        return organization;
    }

}
