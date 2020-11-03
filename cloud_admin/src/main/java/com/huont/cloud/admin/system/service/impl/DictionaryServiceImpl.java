package com.huont.cloud.admin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huont.cloud.admin.common.conf.DataProperty;
import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.common.util.ConvertUtils;
import com.huont.cloud.admin.system.dao.DictionaryMapper;
import com.huont.cloud.admin.system.entity.vo.DictionaryVo;
import com.huont.cloud.admin.system.service.DictionaryService;
import com.huont.cloud.admin.system.utils.DictionaryCache;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import com.huont.cloud.admin.system.entity.Dictionary;

import java.util.*;


/**
 * <p>
 * 用于记录系统的基本数据信息 服务实现类
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-21
 */
@Service(value = "dictionaryServiceImpl")
@Transactional
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    private Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Autowired
    private DictionaryCache dictionaryCache;

    @Override
    public Map<String, Object> queryDictionaryCache() {
        Map<String, Object> rtMap = new HashMap();

        Map<String, String> leafMap = new HashMap();
        rtMap.put("LEAF_MAP", leafMap);

        Map<String, Map<String, String>> leafSelMap = new HashMap();
        rtMap.put("LEAF_SEL", leafSelMap);

        //1、查询所有的字典信息
        Collection<Dictionary> dictionaries = this.list();
        //2、查询最底层的叶子节点的父节点信息
        Collection<Map> leafParent = this.dictionaryMapper.queryBottomLeafParentInfo();
        //2、用最底层叶子节点的父节点编码和最底层叶结点的value值拼串后作为key,用最底层叶子结点的value属性作为value;
        if (dictionaries != null && dictionaries.size() > 0) {
            Iterator<Map> iterLeaf = leafParent.iterator();
            while (iterLeaf.hasNext()) {
                Map curLeafPa = iterLeaf.next();
                String code = MapUtils.getString(curLeafPa, "CODE", "");
                String pid = MapUtils.getString(curLeafPa, "ID", "");

                Map<String, String> selMap = new HashMap<>();

                Iterator<Dictionary> iterDic = dictionaries.iterator();
                while (iterDic.hasNext()) {
                    Dictionary dic = iterDic.next();
                    if (pid.equals(dic.getPid())) {
                        leafMap.put(code + "&" + dic.getValue(), dic.getName());
                        selMap.put(dic.getName(), dic.getValue());
                    }
                }
                leafSelMap.put(code, selMap);
            }
        }
        return rtMap;
    }

    @Override
    public Result saveDictionary(Dictionary dictionary) {
        this.save(dictionary);
        return Result.getSuccessInstance();
    }

    @Override
    public Result updateDictionary(Dictionary dictionary) {
        //强制将PID设置为null，不允许在更新时更新该字段
        dictionary.setPid(null);
        this.updateById(dictionary);
        return Result.getSuccessInstance();
    }

    @Override
    public Result queryDictionaryById(DictionaryVo dictionaryVo) {
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("id", dictionaryVo.getId());
        Map dictionary = this.dictionaryMapper.queryDictionayInfoById(queryM);
        return Result.getSuccessInstance().put("dictionaryDetails", dictionary);
    }

    @Override
    public Collection<Dictionary> queryDictionaryRecursion(Collection<String> ids) {
        Collection<Dictionary> childrenIds = this.queryDictionaryByPid(ids);
        Collection<Dictionary> allIds = new ArrayList<>(childrenIds);
        if (childrenIds != null && childrenIds.size() > 0) {
            Collection<Dictionary> grandIds = queryDictionaryRecursion(ConvertUtils.convertElementPropertyToList(childrenIds, "id"));
            if (grandIds != null && grandIds.size() > 0) {
                allIds.addAll(grandIds);
            }
            return allIds;
        }
        return allIds;
    }

    @Override
    public Result queryDictionary4Paging(DictionaryVo dictionaryVo) {
        Page page = new Page();
        if (StringUtils.hasLength(dictionaryVo.getCurrent())) {
            page.setCurrent(Long.valueOf(dictionaryVo.getCurrent()));
        }
        if (StringUtils.hasLength(dictionaryVo.getSize())) {
            page.setSize(Long.valueOf(dictionaryVo.getSize()));
        }

        List<String> pids = null;
        if (StringUtils.hasLength(dictionaryVo.getId()) && !"-1".equals(dictionaryVo.getId())) {
            Collection<Dictionary> childDics = this.queryDictionaryRecursion(Arrays.asList(dictionaryVo.getId()));
            pids = ConvertUtils.convertElementPropertyToList(childDics, "pid");
            this.removeDuplicate(pids);
        }
        Map<String, Object> queryM = new HashMap<>();
        queryM.put("ids", pids);
        queryM.put("word", dictionaryVo.getWord());

        IPage<List<Map<String, Object>>> dics = this.dictionaryMapper.queryDictionary4Paging(page, queryM);
        return ConvertUtils.convertIpage2Result(dics);
    }

    @Override
    public Result deleteDictionary(DictionaryVo dictionaryVo) {
        Collection<Dictionary> dics = this.queryDictionaryRecursion(Arrays.asList(dictionaryVo.getId()));
        Collection<String> ids = ConvertUtils.convertElementPropertyToList(dics, "id");
        ids.add(dictionaryVo.getId());
        this.removeByIds(ids);
        return Result.getSuccessInstance();
    }

    @Override
    public Result queryDictionaryTree(DictionaryVo dictionaryVo) {
        Collection<Dictionary> childDics = this.queryDictionaryByPid(Arrays.asList(dictionaryVo.getId()));
        Collection<String> ids = ConvertUtils.convertElementPropertyToList(childDics, "id");
        Collection<Dictionary> grandDics = this.queryDictionaryByPid(ids);
        return Result.getSuccessInstance().put("childNodes", findParentNode(childDics, grandDics));
    }

    @Override
    public Result queryDictionay4Sel(DictionaryVo dictionaryVo) {
        Map<String, Object> selMap = dictionaryCache.getSelByParenCode(dictionaryVo.getCodes().split(","));
        if(selMap == null || selMap.size() == 0) {
            return Result.getSuccessInstance();
        }
        return Result.getSuccessInstance().put("sel", selMap);
    }

    private Collection<Map> findParentNode(Collection<Dictionary> childD, Collection<Dictionary> grandD) {
        if (childD == null || childD.size() == 0) {
            return null;
        }
        Collection<Map> nodes = new ArrayList<>();
        Iterator<Dictionary> iterator = childD.iterator();
        if (grandD == null || grandD.size() == 0) {
            while (iterator.hasNext()) {
                Dictionary curDic = iterator.next();
                Map curM = new HashMap();
                curM.put("id", curDic.getId());
                curM.put("name", curDic.getName());
                curM.put("pid", curDic.getPid());
                curM.put("parent", false);
                nodes.add(curM);
            }
        } else {
            while (iterator.hasNext()) {
                boolean isParent = false;
                Dictionary curDic = iterator.next();
                Iterator<Dictionary> iterator4Grand = grandD.iterator();
                while (iterator4Grand.hasNext()) {
                    Dictionary grandDic = iterator4Grand.next();
                    if (curDic.getId().equals(grandDic.getPid())) {
                        isParent = true;
                        break;
                    }
                }
                Map curM = new HashMap();
                curM.put("id", curDic.getId());
                curM.put("name", curDic.getName());
                curM.put("pid", curDic.getPid());
                curM.put("parent", isParent);
                nodes.add(curM);
            }
        }
        return nodes;
    }

    private void removeDuplicate(List<String> src) {
        Assert.isTrue(src != null, "入参src不能为空");
        Set<String> ds = new HashSet<>(src);
        src.clear();
        src.addAll(ds);
    }

    /**
     * pids
     *
     * @param pids
     * @return
     */
    private Collection<Dictionary> queryDictionaryByPid(Collection<String> pids) {
        QueryWrapper queryWrapper = Wrappers.query();
        queryWrapper.in("PID", pids);
        queryWrapper.eq("STATUS", DataProperty.Status.VALID.getVal());
        queryWrapper.eq("DEL_FLAG", DataProperty.DelFlag.NO_DEL.getVal());
        queryWrapper.orderByAsc("ORDER_INDEX");
        List<Dictionary> dictionaries = this.list(queryWrapper);
        return dictionaries;
    }


}
