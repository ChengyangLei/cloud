package com.huont.cloud.admin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.Dictionary;
import com.huont.cloud.admin.system.entity.vo.DictionaryVo;

import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * 用于记录系统的基本数据信息 服务类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-21
 */
public interface DictionaryService extends IService<Dictionary> {

    /**
     * 查询最底层的字典信息
     *
     * @return
     */
    Map<String, Object> queryDictionaryCache();

    /**
     * 保存字典项
     * @param dictionary
     * @return
     */
    Result saveDictionary(Dictionary dictionary);

    /**
     * 更新字典项
     * @param dictionary
     * @return
     */
    Result updateDictionary(Dictionary dictionary);

    /**
     * 根据给定的ID查询字典项详情
     * @param dictionaryVo
     * @return
     */
    Result queryDictionaryById(DictionaryVo dictionaryVo);

    /**
     * 递归查询指定ID的所有子节点
     * @param ids
     * @return
     */
    Collection<Dictionary> queryDictionaryRecursion(Collection<String> ids);

    /**
     * 查询字典的分页数据
     * @param dictionaryVo
     * @return
     */
    Result queryDictionary4Paging(DictionaryVo dictionaryVo);

    /**
     * 删除数据字典
     * @param dictionaryVo
     * @return
     */
    Result deleteDictionary(DictionaryVo dictionaryVo);

    /**
     * 查询数据字典树
     * @param dictionaryVo
     * @return
     */
    Result queryDictionaryTree(DictionaryVo dictionaryVo);

    /**
     * 根据编码查询该编码下的所有子节点(只支持最底层的叶子节点的父节点code)
     * @param dictionaryVo
     * @return
     */
    Result queryDictionay4Sel(DictionaryVo dictionaryVo);

}
