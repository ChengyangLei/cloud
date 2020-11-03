package com.huont.cloud.admin.system.entity.vo;

/**
 * @author leichengyang
 * @title: UserVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/2814:44
 */
public class UserVo extends BaseVo {

    private String id;

    private String orgId;

    private String devId;

    private String word;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}


