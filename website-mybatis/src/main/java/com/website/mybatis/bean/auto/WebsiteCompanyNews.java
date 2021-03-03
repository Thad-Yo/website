package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteCompanyNews extends BaseBean implements Serializable {
    private String id;

    private String cnid;

    private String newsTitle;

    private String publishTime;

    private String type;

    private String isTop;

    private String summary;

    private String mainContent;

    private String coverPageUrl;

    private String cnEnFlag;

    private String hasEnFlag;

    private String delFlag;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private String content;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCnid() {
        return cnid;
    }

    public void setCnid(String cnid) {
        this.cnid = cnid == null ? null : cnid.trim();
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop == null ? null : isTop.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent == null ? null : mainContent.trim();
    }

    public String getCoverPageUrl() {
        return coverPageUrl;
    }

    public void setCoverPageUrl(String coverPageUrl) {
        this.coverPageUrl = coverPageUrl == null ? null : coverPageUrl.trim();
    }

    public String getCnEnFlag() {
        return cnEnFlag;
    }

    public void setCnEnFlag(String cnEnFlag) {
        this.cnEnFlag = cnEnFlag == null ? null : cnEnFlag.trim();
    }

    public String getHasEnFlag() {
        return hasEnFlag;
    }

    public void setHasEnFlag(String hasEnFlag) {
        this.hasEnFlag = hasEnFlag == null ? null : hasEnFlag.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}