package com.huont.cloud.admin.system.entity.vo;

/**
 * @author leichengyang
 * @title: BaseVo
 * @projectName integration_platform
 * @description: TODO
 * @date 2019/5/2115:22
 */
public class BaseVo {

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 每页显示条数
     */
    private String size;

    /**
     * 当前页
     */
    private String current;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }
}
