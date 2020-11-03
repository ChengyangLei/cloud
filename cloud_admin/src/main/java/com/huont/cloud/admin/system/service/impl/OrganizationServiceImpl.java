package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.common.util.ConvertUtils;
import com.huont.cloud.admin.system.dao.OrganizationMapper;
import com.huont.cloud.admin.system.entity.Organization;
import com.huont.cloud.admin.system.entity.vo.OrganizationVo;
import com.huont.cloud.admin.system.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 * 组织机构的基本信息，包括水行政主管部门、水利事业单位、乡镇水利管理单位，以及为水利提供服务的企业、社会团体等单位的基本信息 服务实现类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-17
 */
@Service(value = "organizationServiceImpl")
@Transactional
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService {

    private Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

//    @Resource(name = "orgCounServiceImpl")
//    private OrgCounService orgCounService;
//
//    @Resource(name = "orgPubwaServiceImpl")
//    private OrgPubwaService orgPubwaService;
//
//    @Resource(name = "orgTwmoServiceImpl")
//    private OrgTwmoService orgTwmoService;

    @Autowired
    private OrganizationMapper organizationMapper;

//    @Autowired
//    private DictionaryCache dictionaryCache;


    @Override
    public Result saveOrganization(Organization organization) {
        //1、保存组织机构信息
        this.save(organization);
        //2、保存扩展信息
//        if (ORG_TYPE_1.equals(organization.getType())) {
//            OrgCoun orgCoun = organization.getOrgCoun();
//            orgCoun.setOrgCd(organization.getCode());
//            orgCoun.setId(organization.getId());
//            orgCoun.setCreateTime(LocalDateTime.now());
//            orgCoun.setDescription(organization.getDescription());
//            orgCounService.save(orgCoun);
//        } else if (ORG_TYPE_2.equals(organization.getType())) {
//            OrgPubwa orgPubwa = organization.getOrgPubwa();
//            orgPubwa.setId(organization.getId());
//            orgPubwa.setOrgCd(organization.getCode());
//            orgPubwa.setCreateTime(LocalDateTime.now());
//            orgPubwa.setDescription(organization.getDescription());
//            orgPubwaService.save(orgPubwa);
//        } else if (ORG_TYPE_5.equals(organization.getType())) {
//            OrgTwmo orgTwmo = organization.getOrgTwmo();
//            orgTwmo.setId(organization.getId());
//            orgTwmo.setOrgCd(organization.getCode());
//            orgTwmo.setDescription(organization.getDescription());
//            orgTwmo.setCreateTime(LocalDateTime.now());
//            orgTwmoService.save(orgTwmo);
//        }
        return Result.getSuccessInstance();
    }

    @Override
    public Result updateOrganization(Organization organization) {
        //1、更新组织机构信息
        this.updateById(organization);
        //2、更新扩展信息
//        orgCounService.removeById(organization.getId());
//        orgPubwaService.removeById(organization.getId());
//        if (ORG_TYPE_1.equals(organization.getType())) {
//            OrgCoun orgCoun = organization.getOrgCoun();
//            orgTwmoService.removeById(organization.getId());
//            orgCoun.setOrgCd(organization.getCode());
//            orgCoun.setId(organization.getId());
//            orgCoun.setDescription(organization.getDescription());
//            orgCoun.setCreateTime(LocalDateTime.now());
//            orgCounService.save(orgCoun);
//        } else if (ORG_TYPE_2.equals(organization.getType())) {
//            OrgPubwa orgPubwa = organization.getOrgPubwa();
//            orgPubwa.setId(organization.getId());
//            orgPubwa.setOrgCd(organization.getCode());
//            orgPubwa.setDescription(organization.getDescription());
//            orgPubwa.setCreateTime(LocalDateTime.now());
//            orgPubwaService.save(orgPubwa);
//        } else if (ORG_TYPE_5.equals(organization.getType())) {
//            OrgTwmo orgTwmo = organization.getOrgTwmo();
//            orgTwmo.setId(organization.getId());
//            orgTwmo.setOrgCd(organization.getCode());
//            orgTwmo.setCreateTime(LocalDateTime.now());
//            orgTwmo.setDescription(organization.getDescription());
//            orgTwmoService.save(orgTwmo);
//        }
        return Result.getSuccessInstance();
    }

    /**
     * 直接屋里删除
     *
     * @param organizationVo
     * @return
     */
    @Override
    public Result deleteOrganization(OrganizationVo organizationVo) {
        Collection<Organization> organizations = this.queryOrganizationRecursion(Arrays.asList(organizationVo.getId()));
        List<String> ids = ConvertUtils.convertElementPropertyToList(organizations, "id");
        ids.add(organizationVo.getId());
        this.removeByIds(ids);
//        orgCounService.removeByIds(ids);
//        orgPubwaService.removeByIds(ids);
//        orgTwmoService.removeByIds(ids);
        return Result.getSuccessInstance();
    }

    @Override
    public Collection<Organization> queryOrganizationRecursion(Collection<String> ids) {
        Collection<Organization> childrenIds = this.queryOrganizationByPid(ids);
        Collection<Organization> allIds = new ArrayList<>(childrenIds);
        if (childrenIds != null && childrenIds.size() > 0) {
            Collection<Organization> grandIds = queryOrganizationRecursion(ConvertUtils.convertElementPropertyToList(childrenIds, "id"));
            if (grandIds != null && grandIds.size() > 0) {
                allIds.addAll(grandIds);
            }
            return allIds;
        }
        return allIds;
    }


    @Override
    public Result queryChildOrganizationByParentId(OrganizationVo organizationVo) {
        Page page = new Page();
        if (StringUtils.hasLength(organizationVo.getCurrent())) {
            page.setCurrent(Long.valueOf(organizationVo.getCurrent()));
        }
        if (StringUtils.hasLength(organizationVo.getSize())) {
            page.setSize(Long.valueOf(organizationVo.getSize()));
        }
        Map querM = new HashMap();
        if (StringUtils.hasLength(organizationVo.getPid())) {
            querM.put("pid", organizationVo.getPid());
        }
        if (StringUtils.hasLength(organizationVo.getWord())) {
            querM.put("word", organizationVo.getWord());
        }
        IPage<List<Map<String, Object>>> ipage = organizationMapper.queryOrganizationByParentId(page, querM);
        return ConvertUtils.convertIpage2Result(ipage);
    }

    @Override
    public Result queryChildOrganization(OrganizationVo organizationVo) {
        Result result = queryChildOrganizationByParentId(organizationVo);
        if (result.getData() != null && result.getData().size() > 0) {
            List<Map<String, Object>> records = (List<Map<String, Object>>) result.getData().get(ConvertUtils.DATA_LIST);
            return Result.getSuccessInstance().put("childOrgs", records);
        }
        return Result.getSuccessInstance();
    }

    @Override
    public Result queryOrganizationDetailsById(OrganizationVo organizationVo) {
        //1、查询详情
        Organization organization = this.getById(organizationVo.getId());
//        //2、查询扩展信息
//        if (ORG_TYPE_1.equals(organization.getType())) {
//            OrgCoun orgCoun = this.orgCounService.getById(organizationVo.getId());
//            organization.setOrgCoun(orgCoun);
//        } else if (ORG_TYPE_2.equals(organization.getType())) {
//            OrgPubwa orgPubwa = this.orgPubwaService.getById(organizationVo.getId());
//            organization.setOrgPubwa(orgPubwa);
//        } else if (ORG_TYPE_5.equals(organization.getType())) {
//            OrgTwmo orgTwmo = this.orgTwmoService.getById(organizationVo.getId());
//            organization.setOrgTwmo(orgTwmo);
//        }
        return Result.getSuccessInstance().put("ORGANIZATION_DETAILS", organization);
    }


    private Collection<Organization> queryOrganizationByPid(Collection<String> pids) {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.in("PID", pids);
        queryWrapper.eq("STATUS", DataProperty.Status.VALID.getVal());
        queryWrapper.eq("DEL_FLAG", DataProperty.DelFlag.NO_DEL.getVal());
        queryWrapper.orderByAsc("ORDER_INDEX");
        List<Organization> divisions = this.list(queryWrapper);
        return divisions;
    }

}
