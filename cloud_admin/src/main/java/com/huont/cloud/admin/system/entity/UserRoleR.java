package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 * 记录用户对应的角色信息
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
@TableName("H_SYS_USER_ROLE_R")
public class UserRoleR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 是否为主角色1：是；0：不是
     */
    private String isMajor;

    public UserRoleR(String userId) {
        this.userId = userId;
    }

    public UserRoleR() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getIsMajor() {
        return isMajor;
    }

    public void setIsMajor(String isMajor) {
        this.isMajor = isMajor;
    }

    @Override
    public String toString() {
        return "UserRoleR{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", isMajor=" + isMajor +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleR)) return false;
        UserRoleR userRoleR = (UserRoleR) o;
        return userId.equals(userRoleR.userId) &&
                roleId.equals(userRoleR.roleId) &&
                isMajor.equals(userRoleR.isMajor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId, isMajor);
    }
}
