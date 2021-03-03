package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteProduct extends BaseBean implements Serializable {
    private String id;

    private String cnid;

    private String title;

    private String cnEnFlag;

    private String hasEnFlag;

    private String delFlag;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private Integer sortNumber;

    private String productType;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }
}