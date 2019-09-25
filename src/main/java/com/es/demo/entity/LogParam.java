package com.es.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ldw
 * @date 2019/9/23 11:19
 */
public class LogParam {
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private String moduleType;
    private String userName;

    public Date getBeginTime() {
        return beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getModuleType() {
        return moduleType;
    }

    public String getUserName() {
        return userName;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LogParam(Date beginTime, Date endTime, String moduleType, String userName) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.moduleType = moduleType;
        this.userName = userName;
    }

    public LogParam() {
    }
}
