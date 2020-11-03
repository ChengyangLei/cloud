package com.huont.cloud.admin.system.service;

import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.HResource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.system.entity.vo.ResourceVo;

/**
 * <p>
 * 记录系统资源信息(权限) 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
public interface ResourceService extends IService<HResource> {

    Result saveResource(HResource add);

    Result updateResource(HResource setResourceInfo);

    Result queryResourceDetailsByResourceId(ResourceVo resourceVo);

    Result queryResource4Paging(ResourceVo resourceVo);

    Result deleteResource(ResourceVo resourceVo);
}
