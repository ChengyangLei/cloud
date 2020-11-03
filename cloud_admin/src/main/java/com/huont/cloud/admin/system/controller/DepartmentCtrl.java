package com.huont.cloud.admin.system.controller;


import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.Department;
import com.huont.cloud.admin.system.entity.vo.DepartmentVo;
import com.huont.cloud.admin.system.service.DepartmentService;
import com.huont.cloud.admin.config.UserInfoServiceI;
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
 * 描述系统的部门信息 前端控制器
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-22
 */
@RestController
@RequestMapping("/system/department")
public class DepartmentCtrl {

    private Logger logger = LoggerFactory.getLogger(DepartmentCtrl.class);

    @Resource(name = "departmentServiceImpl")
    private DepartmentService departmentService;

    @RequestMapping("index")
    public Department index() {
        return departmentService.getById("xxxx");
    }

    @RequestMapping("addDepartment")
    public Result addDepartment(@RequestBody Department department, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return departmentService.saveDepartment(setDepartmentInfo(department, userInfoServiceI, "ADD"));
    }

    @RequestMapping("updateDepartment")
    public Result updateDepartment(@RequestBody Department department, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return departmentService.updateDepartment(setDepartmentInfo(department, userInfoServiceI, null));
    }

    @RequestMapping("queryDepartmentById")
    public Result queryDepartmentById(@RequestBody DepartmentVo departmentVo) {
        return departmentService.queryDepartmentById(departmentVo);
    }

    @RequestMapping("queryOrgDepmentTree")
    public Result queryOrgDepmentTree(@RequestBody DepartmentVo departmentVo) {
        return departmentService.queryOrgDepTree(departmentVo);
    }

    @RequestMapping("queryDepartmentTree")
    public Result queryDepartmentTree(@RequestBody DepartmentVo departmentVo) {
        return departmentService.queryDepTree(departmentVo);
    }

    @RequestMapping("deleteDepartment")
    public Result deleteDepartment(@RequestBody DepartmentVo departmentVo) {
        return departmentService.deleteDepartment(departmentVo);
    }

    private Department setDepartmentInfo(Department department, UserInfoServiceI userInfoServiceI, String type) {
        Assert.isTrue(department != null, "部门不能为空");
        if ("ADD".equals(type)) {
            department.setCreator(userInfoServiceI.getId());
            department.setCreateTime(LocalDateTime.now());
        }
        department.setLastUpdator(userInfoServiceI.getId());
        department.setDelFlag("0");
        department.setLastUpdateTime(LocalDateTime.now());
        return department;
    }

}
