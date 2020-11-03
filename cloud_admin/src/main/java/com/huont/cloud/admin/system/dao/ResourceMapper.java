package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huont.cloud.admin.system.entity.HResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 记录系统资源信息(权限) Mapper 接口
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
public interface ResourceMapper extends BaseMapper<HResource> {

    IPage<List<Map<String, Object>>> queryUserPaging(Page page, @Param("queryM") Map<String, Object> queryM);
}
