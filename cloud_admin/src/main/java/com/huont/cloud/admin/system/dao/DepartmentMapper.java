package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huont.cloud.admin.system.entity.Department;

import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * 描述系统的部门信息 Mapper 接口
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-22
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 根据条件查询部门信息
     *
     * @param queryM
     * @return
     */
    Collection<Map> queryDepartment4Tree(Map queryM);

}
