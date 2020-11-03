package com.huont.cloud.admin.system.entity.vo;

/**
 * @author leichengyang
 * @title: UserJobRVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/2815:15
 */
public class UserJobRVo {

    private String userId;

    public UserJobRVo(String userId) {
        this.userId = userId;
    }

    public UserJobRVo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
