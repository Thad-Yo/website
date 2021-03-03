package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteOurStaff extends BaseBean implements Serializable {
    private String id;

    private String cnid;

    private String cnEnFlag;

    private String hasEnFlag;

    private String imgDesc;

    private String imgUrl;

    private String imgLessUrl;

    private Integer sortNumber;

    private String imgType;

    private String typeCode;

    private String imgTypeName;

    private String imgTypeEnName;

    private String delFlag;

    private String createTime;

    private String createUser;

    private String updateTime;

    private String updateUser;

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

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc == null ? null : imgDesc.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgLessUrl() {
        return imgLessUrl;
    }

    public void setImgLessUrl(String imgLessUrl) {
        this.imgLessUrl = imgLessUrl == null ? null : imgLessUrl.trim();
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType == null ? null : imgType.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getImgTypeName() {
        return imgTypeName;
    }

    public void setImgTypeName(String imgTypeName) {
        this.imgTypeName = imgTypeName == null ? null : imgTypeName.trim();
    }

    public String getImgTypeEnName() {
        return imgTypeEnName;
    }

    public void setImgTypeEnName(String imgTypeEnName) {
        this.imgTypeEnName = imgTypeEnName == null ? null : imgTypeEnName.trim();
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
}