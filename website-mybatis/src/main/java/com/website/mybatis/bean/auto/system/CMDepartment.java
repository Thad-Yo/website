package com.website.mybatis.bean.auto.system;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;
import java.math.BigDecimal;

public class CMDepartment extends BaseBean implements Serializable {
    private Integer id;

    private String departmentCd;

    private String departmentName;

    private String departmentCode;

    private String departmentLeaderId;

    private String departmentLeaderName;

    private String departmentType;

    private Integer departmentLevel;

    private String departmentPCd;

    private String departmentRegtime;

    private Integer departmentWorkstation;

    private BigDecimal departmentArea;

    private String provinceId;

    private String province;

    private String cityId;

    private String city;

    private String districtId;

    private String district;

    private String completeAddress;

    private String notes;

    private String status;

    private Integer sortKey;

    private String smsUserId;

    private String smsPassword;

    private String smsUrl;

    private String delFlag;

    private String createGroupCd;

    private String createUserCd;

    private String createDate;

    private String updateGroupCd;

    private String updateUserCd;

    private String updateDate;

    private String reportCompanyName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentCd() {
        return departmentCd;
    }

    public void setDepartmentCd(String departmentCd) {
        this.departmentCd = departmentCd == null ? null : departmentCd.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode == null ? null : departmentCode.trim();
    }

    public String getDepartmentLeaderId() {
        return departmentLeaderId;
    }

    public void setDepartmentLeaderId(String departmentLeaderId) {
        this.departmentLeaderId = departmentLeaderId == null ? null : departmentLeaderId.trim();
    }

    public String getDepartmentLeaderName() {
        return departmentLeaderName;
    }

    public void setDepartmentLeaderName(String departmentLeaderName) {
        this.departmentLeaderName = departmentLeaderName == null ? null : departmentLeaderName.trim();
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType == null ? null : departmentType.trim();
    }

    public Integer getDepartmentLevel() {
        return departmentLevel;
    }

    public void setDepartmentLevel(Integer departmentLevel) {
        this.departmentLevel = departmentLevel;
    }

    public String getDepartmentPCd() {
        return departmentPCd;
    }

    public void setDepartmentPCd(String departmentPCd) {
        this.departmentPCd = departmentPCd == null ? null : departmentPCd.trim();
    }

    public String getDepartmentRegtime() {
        return departmentRegtime;
    }

    public void setDepartmentRegtime(String departmentRegtime) {
        this.departmentRegtime = departmentRegtime == null ? null : departmentRegtime.trim();
    }

    public Integer getDepartmentWorkstation() {
        return departmentWorkstation;
    }

    public void setDepartmentWorkstation(Integer departmentWorkstation) {
        this.departmentWorkstation = departmentWorkstation;
    }

    public BigDecimal getDepartmentArea() {
        return departmentArea;
    }

    public void setDepartmentArea(BigDecimal departmentArea) {
        this.departmentArea = departmentArea;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress == null ? null : completeAddress.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getSortKey() {
        return sortKey;
    }

    public void setSortKey(Integer sortKey) {
        this.sortKey = sortKey;
    }

    public String getSmsUserId() {
        return smsUserId;
    }

    public void setSmsUserId(String smsUserId) {
        this.smsUserId = smsUserId == null ? null : smsUserId.trim();
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword == null ? null : smsPassword.trim();
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl == null ? null : smsUrl.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateGroupCd() {
        return createGroupCd;
    }

    public void setCreateGroupCd(String createGroupCd) {
        this.createGroupCd = createGroupCd == null ? null : createGroupCd.trim();
    }

    public String getCreateUserCd() {
        return createUserCd;
    }

    public void setCreateUserCd(String createUserCd) {
        this.createUserCd = createUserCd == null ? null : createUserCd.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUpdateGroupCd() {
        return updateGroupCd;
    }

    public void setUpdateGroupCd(String updateGroupCd) {
        this.updateGroupCd = updateGroupCd == null ? null : updateGroupCd.trim();
    }

    public String getUpdateUserCd() {
        return updateUserCd;
    }

    public void setUpdateUserCd(String updateUserCd) {
        this.updateUserCd = updateUserCd == null ? null : updateUserCd.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }

    public String getReportCompanyName() {
        return reportCompanyName;
    }

    public void setReportCompanyName(String reportCompanyName) {
        this.reportCompanyName = reportCompanyName == null ? null : reportCompanyName.trim();
    }
}