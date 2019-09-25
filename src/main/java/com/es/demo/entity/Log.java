package com.es.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @author ldw
 * @date 2019/9/18 18:57
 */
@Document(indexName = "his", type = "log", shards = 5, replicas = 1)
public class Log {
    @Id
    private String id;
    @Field(type = FieldType.Date)
    private Date logTime;
    @Field(type = FieldType.Text)
    private String moduleType;
    @Field(type = FieldType.Keyword)
    private String operateType;
    @Field(type = FieldType.Keyword)
    private String operateResult;
    @Field(type = FieldType.Text)
    private String userName;
    @Field(type = FieldType.Keyword)
    private String userIp;
    @Field(type = FieldType.Keyword)
    private String operateUrl;
    @Field(type = FieldType.Keyword)
    private String description;
    @Field(type = FieldType.Keyword)
    private String resourceId;
    @Field(type = FieldType.Keyword)
    private String resourceType;
    @Field(type = FieldType.Keyword)
    private String keyword;

    public void setId(String id) {
        this.id = id;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public void setOperateResult(String operateResult) {
        this.operateResult = operateResult;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getId() {
        return id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public String getModuleType() {
        return moduleType;
    }

    public String getOperateType() {
        return operateType;
    }

    public String getOperateResult() {
        return operateResult;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public String getOperateUrl() {
        return operateUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getKeyword() {
        return keyword;
    }

    public Log(String id, Date logTime, String moduleType, String operateType, String operateResult, String userName, String userIp, String operateUrl, String description, String resourceId, String resourceType, String keyword) {
        this.id = id;
        this.logTime = logTime;
        this.moduleType = moduleType;
        this.operateType = operateType;
        this.operateResult = operateResult;
        this.userName = userName;
        this.userIp = userIp;
        this.operateUrl = operateUrl;
        this.description = description;
        this.resourceId = resourceId;
        this.resourceType = resourceType;
        this.keyword = keyword;
    }

    public Log() {
    }
}
