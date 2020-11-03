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
@TableName("H_SYS_USER_JOB_R")
public class UserJobR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 岗位ID
     */
    private String jobId;

    /**
     * 是否为主角色1：是；0：不是
     */
    private String isMajor;

    public UserJobR(String userId) {
        this.userId = userId;
    }

    public UserJobR() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getIsMajor() {
        return isMajor;
    }

    public void setIsMajor(String isMajor) {
        this.isMajor = isMajor;
    }

    @Override
    public String toString() {
        return "UserJobR{" +
                "userId=" + userId +
                ", jobId=" + jobId +
                ", isMajor=" + isMajor +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserJobR)) return false;
        UserJobR userJobR = (UserJobR) o;
        return userId.equals(userJobR.userId) &&
                jobId.equals(userJobR.jobId) &&
                isMajor.equals(userJobR.isMajor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, jobId, isMajor);
    }
}
