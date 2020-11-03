package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 组织机构的基本信息，包括水行政主管部门、水利事业单位、乡镇水利管理单位，以及为水利提供服务的企业、社会团体等单位的基本信息
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-17
 */
@TableName("H_SYS_ORGANIZATION")
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 组织机构代码
     */
    private String code;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 父ID只管理机构的ID
     */
    private String pid;

    /**
     * 行政层级代码ID(数据交换时转换为行政区划代码)
     */
    private String divisionId;

    /**
     * 机构简称
     */
    private String shortName;

    /**
     * 机构类型
     */
    private String type;

    /**
     * 法人代表
     */
    private String corporation;

    /**
     * 机构规格
     */
    private String specialfication;

    /**
     * 隶属关系
     */
    private String belong;

    /**
     * 状态(0-未启用 1-启用)
     */
    private String status;

    /**
     * 顺序号
     */
    private Double orderIndex;

    /**
     * 网站
     */
    private String url;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String zip;

    /**
     * 办公室电话
     */
    private String telephone;

    /**
     * 传真号码
     */
    private String fax;

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
     * 国家机关
     */
//    @TableField(exist = false)
//    private OrgCoun orgCoun;

    /**
     * 事业单位
     */
//    @TableField(exist = false)
//    private OrgPubwa orgPubwa;

    /**
     * 乡镇水利单位
     */
//    @TableField(exist = false)
//    private OrgTwmo orgTwmo;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getSpecialfication() {
        return specialfication;
    }

    public void setSpecialfication(String specialfication) {
        this.specialfication = specialfication;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Double orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

//    public OrgCoun getOrgCoun() {
//        return orgCoun;
//    }
//
//    public void setOrgCoun(OrgCoun orgCoun) {
//        this.orgCoun = orgCoun;
//    }
//
//    public OrgPubwa getOrgPubwa() {
//        return orgPubwa;
//    }
//
//    public void setOrgPubwa(OrgPubwa orgPubwa) {
//        this.orgPubwa = orgPubwa;
//    }
//
//    public OrgTwmo getOrgTwmo() {
//        return orgTwmo;
//    }
//
//    public void setOrgTwmo(OrgTwmo orgTwmo) {
//        this.orgTwmo = orgTwmo;
//    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", pid='" + pid + '\'' +
                ", divisionId='" + divisionId + '\'' +
                ", shortName='" + shortName + '\'' +
                ", type='" + type + '\'' +
                ", corporation='" + corporation + '\'' +
                ", specialfication='" + specialfication + '\'' +
                ", belong='" + belong + '\'' +
                ", status='" + status + '\'' +
                ", orderIndex=" + orderIndex +
                ", url='" + url + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", lastUpdator='" + lastUpdator + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", delFlag='" + delFlag + '\'' +
                ", lev=" + lev +
//                ", orgCoun=" + orgCoun +
//                ", orgPubwa=" + orgPubwa +
//                ", orgTwmo=" + orgTwmo +
                '}';
    }
}
