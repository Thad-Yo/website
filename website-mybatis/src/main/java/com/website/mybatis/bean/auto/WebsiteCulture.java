package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteCulture extends BaseBean implements Serializable {
    private String id;

    private String cnid;

    private String cnEnFlag;

    private String hasEnFlag;

    private String imgUrl;

    private String parentImgId;

    private String imgType;

    private String delFlag;

    private String createTime;

    private String createUser;

    private String updateTime;

    private String updateUser;

    private String imgDesc;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getParentImgId() {
        return parentImgId;
    }

    public void setParentImgId(String parentImgId) {
        this.parentImgId = parentImgId == null ? null : parentImgId.trim();
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType == null ? null : imgType.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc == null ? null : imgDesc.trim();
    }
}