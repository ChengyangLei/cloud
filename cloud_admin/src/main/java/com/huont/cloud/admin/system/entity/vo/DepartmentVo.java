package com.huont.cloud.admin.system.entity.vo;

/**
 * @author leichengyang
 * @title: DepartmentVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/2214:03
 */
public class DepartmentVo {

    /**
     * 部门ID
     */
    private String id;

    /**
     * 部门父节点ID
     */
    private String pid;

    /**
     * 查询类型
     * ORG -> 点击的组织结构属性
     * DEV -> 点击的部门属性
     */
    private String type;

    /**
     * 部门ID
     */
    private String devId;

    /**
     * 组织机构ID
     */
    private String orgId;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
