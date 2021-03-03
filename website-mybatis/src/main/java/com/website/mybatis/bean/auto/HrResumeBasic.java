package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class HrResumeBasic extends BaseBean implements Serializable {
    private Long id;

    private Long resumeNumber;

    private String companyId;

    private Long interviewerId;

    private String getType;

    private String applyPosition;

    private Short resumeChannelId;

    private String applyDate;

    private String isOn;

    private String careerYear;

    private String currentSalary;

    private String expectSalary;

    private String expectFulltime;

    private String expectWorkplace;

    private String expectIndustry;

    private String expectJob;

    private String nameCn;

    private String gender;

    private String birthDate;

    private String marriage;

    private String phoneMobile;

    private String emailPerson;

    private String addressDetail;

    private String registerAddressDetail;

    private String photoPath;

    private String certificateDetail;

    private String interest;

    private String applyLetterContent;

    private String attachmentName;

    private String attachmentPath;

    private String resumeStatus;

    private String delFlag;

    private String createTime;

    private String createUserId;

    private String createUserName;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private String specialOfferStatus;

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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public Long getInterviewerId() {
        return interviewerId;
    }

    public void setInterviewerId(Long interviewerId) {
        this.interviewerId = interviewerId;
    }

    public String getGetType() {
        return getType;
    }

    public void setGetType(String getType) {
        this.getType = getType == null ? null : getType.trim();
    }

    public String getApplyPosition() {
        return applyPosition;
    }

    public void setApplyPosition(String applyPosition) {
        this.applyPosition = applyPosition == null ? null : applyPosition.trim();
    }

    public Short getResumeChannelId() {
        return resumeChannelId;
    }

    public void setResumeChannelId(Short resumeChannelId) {
        this.resumeChannelId = resumeChannelId;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate == null ? null : applyDate.trim();
    }

    public String getIsOn() {
        return isOn;
    }

    public void setIsOn(String isOn) {
        this.isOn = isOn == null ? null : isOn.trim();
    }

    public String getCareerYear() {
        return careerYear;
    }

    public void setCareerYear(String careerYear) {
        this.careerYear = careerYear == null ? null : careerYear.trim();
    }

    public String getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary == null ? null : currentSalary.trim();
    }

    public String getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(String expectSalary) {
        this.expectSalary = expectSalary == null ? null : expectSalary.trim();
    }

    public String getExpectFulltime() {
        return expectFulltime;
    }

    public void setExpectFulltime(String expectFulltime) {
        this.expectFulltime = expectFulltime == null ? null : expectFulltime.trim();
    }

    public String getExpectWorkplace() {
        return expectWorkplace;
    }

    public void setExpectWorkplace(String expectWorkplace) {
        this.expectWorkplace = expectWorkplace == null ? null : expectWorkplace.trim();
    }

    public String getExpectIndustry() {
        return expectIndustry;
    }

    public void setExpectIndustry(String expectIndustry) {
        this.expectIndustry = expectIndustry == null ? null : expectIndustry.trim();
    }

    public String getExpectJob() {
        return expectJob;
    }

    public void setExpectJob(String expectJob) {
        this.expectJob = expectJob == null ? null : expectJob.trim();
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate == null ? null : birthDate.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile == null ? null : phoneMobile.trim();
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public void setEmailPerson(String emailPerson) {
        this.emailPerson = emailPerson == null ? null : emailPerson.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getRegisterAddressDetail() {
        return registerAddressDetail;
    }

    public void setRegisterAddressDetail(String registerAddressDetail) {
        this.registerAddressDetail = registerAddressDetail == null ? null : registerAddressDetail.trim();
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    public String getCertificateDetail() {
        return certificateDetail;
    }

    public void setCertificateDetail(String certificateDetail) {
        this.certificateDetail = certificateDetail == null ? null : certificateDetail.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getApplyLetterContent() {
        return applyLetterContent;
    }

    public void setApplyLetterContent(String applyLetterContent) {
        this.applyLetterContent = applyLetterContent == null ? null : applyLetterContent.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath == null ? null : attachmentPath.trim();
    }

    public String getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(String resumeStatus) {
        this.resumeStatus = resumeStatus == null ? null : resumeStatus.trim();
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

    public String getSpecialOfferStatus() {
        return specialOfferStatus;
    }

    public void setSpecialOfferStatus(String specialOfferStatus) {
        this.specialOfferStatus = specialOfferStatus == null ? null : specialOfferStatus.trim();
    }
}