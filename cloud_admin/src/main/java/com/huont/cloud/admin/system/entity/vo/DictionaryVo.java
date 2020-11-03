package com.huont.cloud.admin.system.entity.vo;

/**
 * @author leichengyang
 * @title: DictionaryVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/3011:34
 */
public class DictionaryVo  extends BaseVo  {

    private String id;

    private String word;

    private String codes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }
}
