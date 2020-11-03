package com.huont.cloud.admin.system.controller;


import com.huont.cloud.admin.common.conf.Result;
import com.huont.cloud.admin.system.entity.Dictionary;
import com.huont.cloud.admin.system.entity.vo.DictionaryVo;
import com.huont.cloud.admin.system.service.DictionaryService;
import com.huont.cloud.admin.config.UserInfoServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 用于记录系统的基本数据信息 前端控制器
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-21
 */
@RestController
@RequestMapping("/system/dictionary")
public class DictionaryCtrl {

    private Logger logger = LoggerFactory.getLogger(DictionaryCtrl.class);

    @Resource(name = "dictionaryServiceImpl")
    private DictionaryService dictionaryService;


    @RequestMapping("index")
    public Dictionary index() {
        return dictionaryService.getById("xxxx");
    }

    @RequestMapping("addDictionary")
    public Result addDictionary(@RequestBody Dictionary dictionary, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return dictionaryService.saveDictionary(setDictionaryInfo(dictionary, userInfoServiceI, "ADD"));
    }

    @RequestMapping("updateDictionary")
    public Result updateDictionary(@RequestBody Dictionary dictionary, @AuthenticationPrincipal UserInfoServiceI userInfoServiceI) {
        return dictionaryService.updateDictionary(setDictionaryInfo(dictionary, userInfoServiceI, null));
    }

    @RequestMapping("queryDictionaryById")
    public Result queryDictionaryById(@RequestBody DictionaryVo dictionaryVo) {
        return dictionaryService.queryDictionaryById(dictionaryVo);
    }

    @RequestMapping("queryDictionayPaging")
    public Result queryDictionayPaging(@RequestBody DictionaryVo dictionaryVo) {
        return dictionaryService.queryDictionary4Paging(dictionaryVo);
    }

    @RequestMapping("queryDictionaryTree")
    public Result queryDictionaryTree(@RequestBody DictionaryVo dictionaryVo) {
        return dictionaryService.queryDictionaryTree(dictionaryVo);
    }

    @RequestMapping("deleteDictionary")
    public Result deleteDictionary(@RequestBody DictionaryVo dictionaryVo) {
        return dictionaryService.deleteDictionary(dictionaryVo);
    }

    @RequestMapping("queryDictionay4Sel")
    public Result queryDictionay4Sel(@RequestBody DictionaryVo dictionaryVo) {
        return dictionaryService.queryDictionay4Sel(dictionaryVo);
    }



    private Dictionary setDictionaryInfo(Dictionary dictionary,UserInfoServiceI userInfoServiceI, String type) {
        Assert.isTrue(dictionary != null, "字典不能为空");
        if ("ADD".equals(type)) {
            dictionary.setCreator(userInfoServiceI.getId());
            dictionary.setCreateTime(LocalDateTime.now());
        }
        dictionary.setLastUpdator(userInfoServiceI.getId());
        dictionary.setDelFlag("0");
        dictionary.setLastUpdateTime(LocalDateTime.now());
        return dictionary;
    }


}
