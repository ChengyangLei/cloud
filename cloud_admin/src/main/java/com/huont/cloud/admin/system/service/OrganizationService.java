package com.huont.cloud.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.Organization;
import com.huont.cloud.admin.system.entity.vo.OrganizationVo;

import java.util.Collection;

/**
 * <p>
 * 组织机构的基本信息，包括水行政主管部门、水利事业单位、乡镇水利管理单位，以及为水利提供服务的企业、社会团体等单位的基本信息 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-17
 */
public interface OrganizationService extends IService<Organization> {
    /**
     * 国家机关
     */
    String ORG_TYPE_1 = "1";
    /**
     * 事业单位
     */
    String ORG_TYPE_2 = "2";
    /**
     * 乡镇水利管理单位
     */
    String ORG_TYPE_5 = "5";

    /**
     * 保存组织机构
     *
     * @param organization
     * @return
     */
    Result saveOrganization(Organization organization);

    /**
     * 更新组织机构
     *
     * @param organization
     * @return
     */
    Result updateOrganization(Organization organization);

    /**
     * 删除组织机构
     *
     * @param organizationVo
     * @return
     */
    Result deleteOrganization(OrganizationVo organizationVo);

    /**
     * 递归查询给定的组织机构的子节点ID
     *
     * @return
     */
    Collection<Organization> queryOrganizationRecursion(Collection<String> ids);

    /**
     * 根据指定父ID查询其直接子节点(不包括当前节点)
     *
     * @param organizationVo
     * @return
     */
    Result queryChildOrganizationByParentId(OrganizationVo organizationVo);

    /**
     * 查询组织机构树
     *
     * @param organizationVo
     * @return
     */
    Result queryChildOrganization(OrganizationVo organizationVo);

    /**
     * 查询组织机构详情
     *
     * @param organizationVo
     * @return
     */
    Result queryOrganizationDetailsById(OrganizationVo organizationVo);


}
