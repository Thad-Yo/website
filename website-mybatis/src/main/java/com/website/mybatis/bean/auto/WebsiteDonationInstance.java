package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteDonationInstance extends BaseBean implements Serializable {
    private String id;

    private String cnid;

    private String newsTitle;

    private String donationTime;

    private String cnEnFlag;

    private String hasEnFlag;

    private String coverPageUrl;

    private String isTop;

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

    public String getDonationTime() {
        return donationTime;
    }

    public void setDonationTime(String donationTime) {
        this.donationTime = donationTime == null ? null : donationTime.trim();
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

    public String getCoverPageUrl() {
        return coverPageUrl;
    }

    public void setCoverPageUrl(String coverPageUrl) {
        this.coverPageUrl = coverPageUrl == null ? null : coverPageUrl.trim();
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop == null ? null : isTop.trim();
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