package com.huont.cloud.admin.system.entity.vo;

/**
 * @author leichengyang
 * @title: UserRoleRVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/2815:15
 */
public class UserRoleRVo {

    private String userId;

    public UserRoleRVo(String userId) {
        this.userId = userId;
    }

    public UserRoleRVo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
