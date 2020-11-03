package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@TableName("H_SYS_ROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色使用状态(0-禁用;1-启用)
     */
    private String status;

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
     * 删除标志
     */
    private String delFlag;

    /**
     * 临时标识(0-非临时角色,1-临时角色)
     */
    private String tempFlag;

    /**
     * 临时角色截止日期
     */
    private LocalDateTime endTime;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色类别（1-三元管理员 2-三元安全员 3-三元审计员 4-非三元管理人员）
     */
    private String type;

    /**
     * 角色组信息
     */
    private String roleGroup;

    /**
     * 扩展文本属性1
     */
    private String extAttrText1;

    /**
     * 扩展文本属性2
     */
    private String extAttrText2;

    /**
     * 扩展下拉框1
     */
    private String extAttrSel1;

    /**
     * 扩展下拉框2
     */
    private String extAttrSel2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public String getTempFlag() {
        return tempFlag;
    }

    public void setTempFlag(String tempFlag) {
        this.tempFlag = tempFlag;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }
    public String getExtAttrText1() {
        return extAttrText1;
    }

    public void setExtAttrText1(String extAttrText1) {
        this.extAttrText1 = extAttrText1;
    }
    public String getExtAttrText2() {
        return extAttrText2;
    }

    public void setExtAttrText2(String extAttrText2) {
        this.extAttrText2 = extAttrText2;
    }
    public String getExtAttrSel1() {
        return extAttrSel1;
    }

    public void setExtAttrSel1(String extAttrSel1) {
        this.extAttrSel1 = extAttrSel1;
    }
    public String getExtAttrSel2() {
        return extAttrSel2;
    }

    public void setExtAttrSel2(String extAttrSel2) {
        this.extAttrSel2 = extAttrSel2;
    }

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", name=" + name +
        ", status=" + status +
        ", description=" + description +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", lastUpdateTime=" + lastUpdateTime +
        ", lastUpdator=" + lastUpdator +
        ", delFlag=" + delFlag +
        ", tempFlag=" + tempFlag +
        ", endTime=" + endTime +
        ", code=" + code +
        ", type=" + type +
        ", roleGroup=" + roleGroup +
        ", extAttrText1=" + extAttrText1 +
        ", extAttrText2=" + extAttrText2 +
        ", extAttrSel1=" + extAttrSel1 +
        ", extAttrSel2=" + extAttrSel2 +
        "}";
    }
}
