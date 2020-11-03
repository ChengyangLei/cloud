package com.huont.cloud.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.Department;
import com.huont.cloud.admin.system.entity.vo.DepartmentVo;

import java.util.Collection;

/**
 * <p>
 * 描述系统的部门信息 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-22
 */
public interface DepartmentService extends IService<Department> {

    String ROOT_ID = "-1";

    /**
     * 保存部门
     *
     * @param department
     * @return
     */
    Result saveDepartment(Department department);

    /**
     * 更新部门
     *
     * @param department
     * @return
     */
    Result updateDepartment(Department department);

    /**
     * 删除部门
     *
     * @param departmentVo
     * @return
     */
    Result deleteDepartment(DepartmentVo departmentVo);

    /**
     * 根据ID查询部门详情
     *
     * @param departmentVo
     * @return
     */
    Result queryDepartmentById(DepartmentVo departmentVo);

    /**
     * 根据父ID查询直接子节点
     *
     * @param departmentVo
     * @return
     */
    Result queryDepartmentByPid(DepartmentVo departmentVo);

    /**
     * 递归查询指定父节点ID的所有子节点
     *
     * @param pids
     * @return
     */
    Collection<Department> queryDepartmentRecursion(Collection<String> pids);

    /**
     * 查询组织机构部门混合树
     *
     * @param departmentVo
     * @return
     */
    Result queryOrgDepTree(DepartmentVo departmentVo);

    /**
     * 查询部门树(没有组织机构)
     *
     * @param departmentVo
     * @return
     */
    Result queryDepTree(DepartmentVo departmentVo);

}
