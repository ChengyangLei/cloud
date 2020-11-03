package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huont.cloud.admin.system.entity.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 组织机构的基本信息，包括水行政主管部门、水利事业单位、乡镇水利管理单位，以及为水利提供服务的企业、社会团体等单位的基本信息 Mapper 接口
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-17
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

    IPage<List<Map<String, Object>>> queryOrganizationByParentId(Page page, @Param("queryM") Map<String, String> queryM);

    Collection<Map> queryOrganization4Tree(Map queryM);

}
