package com.huont.cloud.admin.system.entity.vo;


/**
 * @author leichengyang
 * @title: OrganizationVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/1711:38
 */
public class OrganizationVo extends BaseVo {

    private String id;

    private String pid;

    /**
     * 模糊查询关键字
     */
    private String word;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
