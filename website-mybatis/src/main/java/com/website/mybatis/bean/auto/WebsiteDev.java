package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteDev extends BaseBean implements Serializable {
    private String id;

    private String imgAddressEng;

    private String imgAddress;

    private String devNumber;

    private String devDateEng;

    private String devDate;

    private String devTitleEng;

    private String devTitle;

    private String devTextEng;

    private String devText;

    private String createTime;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private String deleteFlag;

    private String hasEng;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImgAddressEng() {
        return imgAddressEng;
    }

    public void setImgAddressEng(String imgAddressEng) {
        this.imgAddressEng = imgAddressEng == null ? null : imgAddressEng.trim();
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress == null ? null : imgAddress.trim();
    }

    public String getDevNumber() {
        return devNumber;
    }

    public void setDevNumber(String devNumber) {
        this.devNumber = devNumber == null ? null : devNumber.trim();
    }

    public String getDevDateEng() {
        return devDateEng;
    }

    public void setDevDateEng(String devDateEng) {
        this.devDateEng = devDateEng == null ? null : devDateEng.trim();
    }

    public String getDevDate() {
        return devDate;
    }

    public void setDevDate(String devDate) {
        this.devDate = devDate == null ? null : devDate.trim();
    }

    public String getDevTitleEng() {
        return devTitleEng;
    }

    public void setDevTitleEng(String devTitleEng) {
        this.devTitleEng = devTitleEng == null ? null : devTitleEng.trim();
    }

    public String getDevTitle() {
        return devTitle;
    }

    public void setDevTitle(String devTitle) {
        this.devTitle = devTitle == null ? null : devTitle.trim();
    }

    public String getDevTextEng() {
        return devTextEng;
    }

    public void setDevTextEng(String devTextEng) {
        this.devTextEng = devTextEng == null ? null : devTextEng.trim();
    }

    public String getDevText() {
        return devText;
    }

    public void setDevText(String devText) {
        this.devText = devText == null ? null : devText.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getHasEng() {
        return hasEng;
    }

    public void setHasEng(String hasEng) {
        this.hasEng = hasEng == null ? null : hasEng.trim();
    }
}