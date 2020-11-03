package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
@TableName("H_SYS_USER_DEP_R")
public class UserDepR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 是否为主部门1：是；0：否
     */
    private String isMajor;

    /**
     * 部门ID
     */
    private String deptId;

    public UserDepR() {
    }

    public UserDepR(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsMajor() {
        return isMajor;
    }

    public void setIsMajor(String isMajor) {
        this.isMajor = isMajor;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "UserDepR{" +
                "userId=" + userId +
                ", isMajor=" + isMajor +
                ", deptId=" + deptId +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDepR)) return false;
        UserDepR userDepR = (UserDepR) o;
        return userId.equals(userDepR.userId) &&
                isMajor.equals(userDepR.isMajor) &&
                deptId.equals(userDepR.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, isMajor, deptId);
    }
}
