package com.huont.cloud.admin.system.utils;

import com.huont.cloud.admin.system.service.DictionaryService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用于缓存数据字典
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-21
 */
@Component
public class DictionaryCache implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(DictionaryCache.class);

    @Resource(name = "dictionaryServiceImpl")
    private DictionaryService dictionaryService;

    /**
     * 用最底层叶子节点的父节点编码和最底层叶结点的value值拼串后作为key,用最底层叶子结点的value属性作为value;
     */
    private Map<String, String> leafMap = new HashMap<>();

    /**
     * 用最底层叶子节点的父节点编码做key，该父节点的所有直接子节点集合value;
     */
    private Map<String, Map<String, String>> leafSelMap = new HashMap<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("初始化DictionaryCache...");
        initMap();
    }

    private void initMap() {
        Map<String, Object> map = dictionaryService.queryDictionaryCache();
        this.leafMap = MapUtils.getMap(map, "LEAF_MAP");
        logger.info("所有的叶子节点--->" + leafMap);
        this.leafSelMap = MapUtils.getMap(map, "LEAF_SEL");
        logger.info("所有可用的可选项--->" + leafSelMap);
    }

    /**
     * 根据叶子结点字典项的val获取对应的name
     *
     * @param val
     * @return
     */
    public String getNameByVal(String val) {
        return MapUtils.getString(leafMap, val, "");
    }

    /**
     * 根据父PCODE获取直接子节点
     *
     * @param pCode
     * @return
     */
    public Map<String, Object> getSelByParenCode(String... pCode) {
        Map<String, Object> rtMap = new HashMap<>();
        if (pCode.length > 0) {
            for (String curCode : pCode) {
                if (StringUtils.hasLength(curCode)) {
                    rtMap.put(curCode, MapUtils.getMap(leafSelMap, curCode));
                }
            }
        }
        return rtMap;
    }
}
