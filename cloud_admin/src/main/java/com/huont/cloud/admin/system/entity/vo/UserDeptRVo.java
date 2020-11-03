package com.huont.cloud.admin.system.entity.vo;

/**
 * @author leichengyang
 * @title: UserDeptRVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/2815:14
 */
public class UserDeptRVo {

    private String userId;

    public UserDeptRVo(String userId) {
        this.userId = userId;
    }

    public UserDeptRVo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
