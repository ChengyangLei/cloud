package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 记录系统资源信息(权限)
 * </p>
 *
 * @author leichengyang
 * @since 2020-11-03
 */
@TableName("H_SYS_RESOURCE")
public class HResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 资源编码
     */
    private String code;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型(0-系统;1-模块；2-功能模块;3-菜单;4-功能项)
     */
    private String type;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 父资源ID
     */
    private String pid;

    /**
     * 资源顺序
     */
    private BigDecimal orderIndex;

    /**
     * 资源备注
     */
    private String description;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 资源打开类型(0-当前页面打开;1-弹出方式打开;2-其他方式)
     */
    private String viewType;

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
     * 删除标识(0-没有删除;1-已经删除)
     */
    private String delFlag;

    /**
     * 树形结构层次
     */
    private BigDecimal lev;

    /**
     * 账号启用状态(0-禁用 1-启用)
     */
    private BigDecimal status;

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    public BigDecimal getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(BigDecimal orderIndex) {
        this.orderIndex = orderIndex;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
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
    public BigDecimal getLev() {
        return lev;
    }

    public void setLev(BigDecimal lev) {
        this.lev = lev;
    }
    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
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
        return "Resource{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", type=" + type +
        ", url=" + url +
        ", pid=" + pid +
        ", orderIndex=" + orderIndex +
        ", description=" + description +
        ", icon=" + icon +
        ", viewType=" + viewType +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", lastUpdateTime=" + lastUpdateTime +
        ", lastUpdator=" + lastUpdator +
        ", delFlag=" + delFlag +
        ", lev=" + lev +
        ", status=" + status +
        ", extAttrText1=" + extAttrText1 +
        ", extAttrText2=" + extAttrText2 +
        ", extAttrSel1=" + extAttrSel1 +
        ", extAttrSel2=" + extAttrSel2 +
        "}";
    }
}
