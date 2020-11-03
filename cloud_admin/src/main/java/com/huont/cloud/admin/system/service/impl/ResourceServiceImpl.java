package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.common.util.ConvertUtils;
import com.huont.cloud.admin.common.util.MD5Util;
import com.huont.cloud.admin.system.entity.HResource;
import com.huont.cloud.admin.system.dao.ResourceMapper;
import com.huont.cloud.admin.system.entity.User;
import com.huont.cloud.admin.system.entity.vo.ResourceVo;
import com.huont.cloud.admin.system.entity.vo.UserDeptRVo;
import com.huont.cloud.admin.system.entity.vo.UserJobRVo;
import com.huont.cloud.admin.system.entity.vo.UserRoleRVo;
import com.huont.cloud.admin.system.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.system.service.RoleResourceRService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
    * 记录系统资源信息(权限) 服务实现类
    * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@Service(value = "resourceServiceImpl")
@Transactional
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, HResource> implements ResourceService {

    private Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);


    @Override
    public Result saveResource(HResource resource) {
        //1、保存资源菜单
        this.saveOrUpdate(resource);
        return Result.getSuccessInstance();
    }

    @Override
    public Result updateResource(HResource resource) {
        //2、保存用户信息
        this.updateById(resource);
        return Result.getSuccessInstance();
    }

    @Override
    public Result queryResourceDetailsByResourceId(ResourceVo resourceVo) {
        //1、查询基本信息
        QueryWrapper<HResource> queryWrapper = new QueryWrapper();
        queryWrapper.eq("STATUS", DataProperty.Status.VALID.getVal());
        queryWrapper.eq("DEL_FLAG", DataProperty.DelFlag.NO_DEL.getVal());
        queryWrapper.eq("ID", resourceVo.getId());
        HResource resource = this.getOne(queryWrapper);
        return Result.getSuccessInstance().put("resource", resource);
    }

    @Override
    public Result queryResource4Paging(ResourceVo resourceVo) {
        Collection<String> divIds;
        Page page = new Page();
        if (StringUtils.hasLength(resourceVo.getCurrent())) {
            page.setCurrent(Long.valueOf(resourceVo.getCurrent()));
        }
        if (StringUtils.hasLength(resourceVo.getSize())) {
            page.setSize(Long.valueOf(resourceVo.getSize()));
        }
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("word", resourceVo.getWord());
        IPage<List<Map<String, Object>>> userL = this.getBaseMapper().queryUserPaging(page, queryM);
        return ConvertUtils.convertIpage2Result(userL);
    }

    @Override
    public Result deleteResource(ResourceVo resourceVo) {
        this.removeById(resourceVo.getId());
        return Result.getSuccessInstance();
    }
}
