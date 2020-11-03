package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 描述系统的部门信息
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-22
 */
@TableName("H_SYS_DEPARTMENT")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 部门代码(组织机构代码+自定义码)
     */
    private String code;

    /**
     * 父ID(数据交换时需转换为上级部门代码)
     */
    private String pid;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门级别
     */
    private String grad;

    /**
     * 所属机构ID（数据交换时需转换为所属机构代码）
     */
    private String organizationId;

    /**
     * 部门职责
     */
    private String resp;

    /**
     * 顺序号
     */
    private Double orderIndex;

    /**
     * 状态(0-未启用 1-启用)
     */
    private String status;

    /**
     * 备注
     */
    private String description;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改者
     */
    private String lastUpdator;

    /**
     * 修改时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 删除标识
     */
    private String delFlag;

    /**
     * 树形结构层次
     */
    private Double lev;

    /**
     * 文本扩展属性1
     */
    @TableField(value = "EXT_ATTR_TEXT_1")
    private String extAttrText1;

    /**
     * 文本扩展属性2
     */
    @TableField(value = "EXT_ATTR_TEXT_2")
    private String extAttrText2;

    /**
     * 下拉框扩展属性1
     */
    @TableField(value = "EXT_ATTR_SEL_1")
    private String extAttrSel1;

    /**
     * 下拉框扩展属性2
     */
    @TableField(value = "EXT_ATTR_SEL_2")
    private String extAttrSel2;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdator() {
        return lastUpdator;
    }

    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Double getLev() {
        return lev;
    }

    public void setLev(Double lev) {
        this.lev = lev;
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
        return "Department{" +
                "id=" + id +
                ", code=" + code +
                ", pid=" + pid +
                ", name=" + name +
                ", grad=" + grad +
                ", organizationId=" + organizationId +
                ", resp=" + resp +
                ", orderIndex=" + orderIndex +
                ", status=" + status +
                ", description=" + description +
                ", creator=" + creator +
                ", createTime=" + createTime +
                ", lastUpdator=" + lastUpdator +
                ", lastUpdateTime=" + lastUpdateTime +
                ", delFlag=" + delFlag +
                ", lev=" + lev +
                ", extAttrText1=" + extAttrText1 +
                ", extAttrText2=" + extAttrText2 +
                ", extAttrSel1=" + extAttrSel1 +
                ", extAttrSel2=" + extAttrSel2 +
                "}";
    }
}
