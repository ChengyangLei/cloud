package com.huont.cloud.admin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 记录系统的用户信息包括账号信息，用户相关信息,登录登出等
 * </p>
 *
 * @author leichengyang
 * @since 2019-05-27
 */
@TableName("H_SYS_USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String cardId;

    /**
     * 性别(下拉)
     */
    private String sex;

    /**
     * 职务级别(下拉)
     */
    private String dutyLevel;

    /**
     * 技术职称(手动填写)
     */
    private String techTitle;

    /**
     * 学历(下拉)
     */
    private String degree;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 出生年月
     */
    private LocalDate birthday;

    /**
     * 开始工作时间
     */
    private LocalDate startWorkdate;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 所学专业
     */
    private String studyMajor;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 出生地
     */
    private String bornPlace;

    /**
     * 政治面貌
     */
    private String politicalStatus;

    /**
     * 用户民族
     */
    private String nationality;

    /**
     * 顺序号
     */
    private Double orderIndex;

    /**
     * 备注
     */
    private String description;

    /**
     * 账号启用状态(0-禁用 1-启用)
     */
    private Double status = 1d;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登出时间
     */
    private LocalDateTime logoutTime;

    /**
     * 登录状态(0-退出状态1-登录状态)
     */
    private String lineStatus;

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
    private LocalDateTime lastUpdateTime = LocalDateTime.now();

    /**
     * 删除标识(0-未删除;1-已删除)
     */
    private String delFlag = "0";
    ;

    /**
     * 类型（是否管理员0-非管理员 1-管理员）
     */
    private String type;

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

    /**
     * 账号失效时间
     */
    private LocalDate expiryDate;

    /**
     * 用户所在的部门id，多个部门用英文逗号“,”隔开；
     * 排在最前面的部门ID是用户所在的主部门，如"123,456,789"则123是用户的主部门
     */
    @TableField(exist = false)
    private String deptIds;

    /**
     * 用户拥有的角色id，多个角色用英文逗号“,”隔开；
     * 排在最前面的角色ID是用户所在的主角色，如"123,456,789"则123是用户主要角色
     */
    @TableField(exist = false)
    private String roleIds;

    /**
     * 用户所拥有的岗位id，多个岗位用英文逗号“,”隔开；
     * 排在最前面的角色ID是用户所在的岗位，如"123,456,789"则123是用户主要岗位
     */
    @TableField(exist = false)
    private String jobIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDutyLevel() {
        return dutyLevel;
    }

    public void setDutyLevel(String dutyLevel) {
        this.dutyLevel = dutyLevel;
    }

    public String getTechTitle() {
        return techTitle;
    }

    public void setTechTitle(String techTitle) {
        this.techTitle = techTitle;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStartWorkdate() {
        return startWorkdate;
    }

    public void setStartWorkdate(LocalDate startWorkdate) {
        this.startWorkdate = startWorkdate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudyMajor() {
        return studyMajor;
    }

    public void setStudyMajor(String studyMajor) {
        this.studyMajor = studyMajor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Double orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getJobIds() {
        return jobIds;
    }

    public void setJobIds(String jobIds) {
        this.jobIds = jobIds;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", sex='" + sex + '\'' +
                ", dutyLevel='" + dutyLevel + '\'' +
                ", techTitle='" + techTitle + '\'' +
                ", degree='" + degree + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", startWorkdate=" + startWorkdate +
                ", school='" + school + '\'' +
                ", studyMajor='" + studyMajor + '\'' +
                ", address='" + address + '\'' +
                ", bornPlace='" + bornPlace + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", nationality='" + nationality + '\'' +
                ", orderIndex=" + orderIndex +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", lineStatus='" + lineStatus + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", lastUpdator='" + lastUpdator + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", delFlag='" + delFlag + '\'' +
                ", type='" + type + '\'' +
                ", extAttrText1='" + extAttrText1 + '\'' +
                ", extAttrText2='" + extAttrText2 + '\'' +
                ", extAttrSel1='" + extAttrSel1 + '\'' +
                ", extAttrSel2='" + extAttrSel2 + '\'' +
                ", expiryDate=" + expiryDate +
                ", deptIds='" + deptIds + '\'' +
                ", roleIds='" + roleIds + '\'' +
                ", jobIds='" + jobIds + '\'' +
                '}';
    }
}
