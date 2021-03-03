package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;

import java.io.Serializable;

public class HrResumeTrain extends BaseBean implements Serializable {
    private Long id;

    private Long resumeNumber;

    private String startDate;

    private String endDate;

    private String trainCompany;

    private String trainCourse;

    private String trainAddress;

    private String trainCertificate;

    private String trainDesc;

    private String delFlag;

    private String createTime;

    private String createUserId;

    private String createUserName;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResumeNumber() {
        return resumeNumber;
    }

    public void setResumeNumber(Long resumeNumber) {
        this.resumeNumber = resumeNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getTrainCompany() {
        return trainCompany;
    }

    public void setTrainCompany(String trainCompany) {
        this.trainCompany = trainCompany == null ? null : trainCompany.trim();
    }

    public String getTrainCourse() {
        return trainCourse;
    }

    public void setTrainCourse(String trainCourse) {
        this.trainCourse = trainCourse == null ? null : trainCourse.trim();
    }

    public String getTrainAddress() {
        return trainAddress;
    }

    public void setTrainAddress(String trainAddress) {
        this.trainAddress = trainAddress == null ? null : trainAddress.trim();
    }

    public String getTrainCertificate() {
        return trainCertificate;
    }

    public void setTrainCertificate(String trainCertificate) {
        this.trainCertificate = trainCertificate == null ? null : trainCertificate.trim();
    }

    public String getTrainDesc() {
        return trainDesc;
    }

    public void setTrainDesc(String trainDesc) {
        this.trainDesc = trainDesc == null ? null : trainDesc.trim();
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
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
}