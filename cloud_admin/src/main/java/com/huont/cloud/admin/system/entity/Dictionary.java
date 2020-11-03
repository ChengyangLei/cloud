package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用于记录系统的基本数据信息
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-21
 */
@TableName("H_SYS_DICTIONARY")
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 数据项code
     */
    private String code;

    /**
     * 数据项名称
     */
    private String name;

    /**
     * 数据项顺序
     */
    private Double orderIndex;

    /**
     * 状态(0-未启用;已启用)
     */
    private String status = "1";

    /**
     * 父数据项
     */
    private String pid;

    /**
     * 说明
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 修改者
     */
    private String lastUpdator;

    /**
     * 删除标识(0-未删除;1-已删除)
     */
    private String delFlag = "0";

    /**
     * 数据项值
     */
    private String value;

    /**
     * 树形结构层次
     */
    private Double lev;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Double orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdator() {
        return lastUpdator;
    }

    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getLev() {
        return lev;
    }

    public void setLev(Double lev) {
        this.lev = lev;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                ", orderIndex=" + orderIndex +
                ", status=" + status +
                ", pid=" + pid +
                ", description=" + description +
                ", createTime=" + createTime +
                ", creator=" + creator +
                ", lastUpdateTime=" + lastUpdateTime +
                ", lastUpdator=" + lastUpdator +
                ", delFlag=" + delFlag +
                ", value=" + value +
                ", lev=" + lev +
                "}";
    }
}
