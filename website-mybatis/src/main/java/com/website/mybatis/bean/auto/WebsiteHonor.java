package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteHonor extends BaseBean implements Serializable {
    private String id;

    private String imgAddressEng;

    private String imgAddress;

    private String honorNumberEng;

    private String honorNumber;

    private String honorNameEng;

    private String honorName;

    private String honorStateEng;

    private String honorState;

    private String createTime;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private String honorDetailsEng;

    private String honorDetails;

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

    public String getHonorNumberEng() {
        return honorNumberEng;
    }

    public void setHonorNumberEng(String honorNumberEng) {
        this.honorNumberEng = honorNumberEng == null ? null : honorNumberEng.trim();
    }

    public String getHonorNumber() {
        return honorNumber;
    }

    public void setHonorNumber(String honorNumber) {
        this.honorNumber = honorNumber == null ? null : honorNumber.trim();
    }

    public String getHonorNameEng() {
        return honorNameEng;
    }

    public void setHonorNameEng(String honorNameEng) {
        this.honorNameEng = honorNameEng == null ? null : honorNameEng.trim();
    }

    public String getHonorName() {
        return honorName;
    }

    public void setHonorName(String honorName) {
        this.honorName = honorName == null ? null : honorName.trim();
    }

    public String getHonorStateEng() {
        return honorStateEng;
    }

    public void setHonorStateEng(String honorStateEng) {
        this.honorStateEng = honorStateEng == null ? null : honorStateEng.trim();
    }

    public String getHonorState() {
        return honorState;
    }

    public void setHonorState(String honorState) {
        this.honorState = honorState == null ? null : honorState.trim();
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

    public String getHonorDetailsEng() {
        return honorDetailsEng;
    }

    public void setHonorDetailsEng(String honorDetailsEng) {
        this.honorDetailsEng = honorDetailsEng == null ? null : honorDetailsEng.trim();
    }

    public String getHonorDetails() {
        return honorDetails;
    }

    public void setHonorDetails(String honorDetails) {
        this.honorDetails = honorDetails == null ? null : honorDetails.trim();
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