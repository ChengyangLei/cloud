package com.huont.cloud.admin.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huont.cloud.admin.system.entity.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用于记录系统的基本数据信息 Mapper 接口
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-21
 */
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    /**
     * 查询数据字典中最底层的叶子节点的父节点信息
     *
     * @return
     */
    Collection<Map> queryBottomLeafParentInfo();

    /**
     * 查询数据字典详情
     * @param queryM
     * @return
     */
    Map queryDictionayInfoById(Map<String, Object> queryM);

    /**
     * 查询数据字典分页
     * @param page
     * @param queryM
     * @return
     */
    IPage<List<Map<String, Object>>> queryDictionary4Paging(Page page, @Param("queryM") Map<String, Object> queryM);

}
