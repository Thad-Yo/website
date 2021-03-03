package com.website.mybatis.bean.ext.system;

import com.website.mybatis.bean.BaseBean;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMDepartmentUser;
import com.website.mybatis.bean.auto.system.CMUserCustom;

import java.io.Serializable;
import java.util.List;

public class ExtUserModel extends BaseBean implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String userId;

    private String userName;

    private String companyName;

    private String realName;

    private String password;

    private String des3;

    private String mobileNumber;

    private String extensionNumber;

    private String address;

    private String emailAddress;

    private String userFlag;

    private String notes;

    private String oldUserNo;

    private String userNo;

    private String position;

    private String sex;

    private String joinDate;

    private String birthday;

    private String idNo;

    private String delFlag;

    private String createGroupCd;

    private String createUserCd;

    private String createDate;

    private String updateGroupCd;

    private String updateUserCd;

    private String updateDate;

    private String roleId;

    private String role;

    private String roleName;

    private String departmentId;

    private String departmentCd;

    private String departmentName;

    private String departmentPCd;

    private String status;

    private Integer sortKey;

    private String userType;

    private String userSortKey;

    private String userIcon;

    private List<String> listDepartmentCd;

    private String userFlagName;

    private String province;

    private String city;

    private String customType;

    private List<CMUserCustom> userCustomList;
    
    private List<CMDepartmentUser> userDepartmentList;

    public List<CMUserCustom> getUserCustomList() {
        return userCustomList;
    }

    public void setUserCustomList(List<CMUserCustom> userCustomList) {
        this.userCustomList = userCustomList;
    }

    public List<CMDepartmentUser> getUserDepartmentList() {
		return userDepartmentList;
	}

	public void setUserDepartmentList(List<CMDepartmentUser> userDepartmentList) {
		this.userDepartmentList = userDepartmentList;
	}

	public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserFlagName() {
        return userFlagName;
    }

    public void setUserFlagName(String userFlagName) {
        this.userFlagName = userFlagName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserSortKey() {
        return userSortKey;
    }

    public void setUserSortKey(String userSortKey) {
        this.userSortKey = userSortKey;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCd() {
        return departmentCd;
    }

    public void setDepartmentCd(String departmentCd) {
        this.departmentCd = departmentCd;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public List<String> getListDepartmentCd() {
        return listDepartmentCd;
    }

    public void setListDepartmentCd(List<String> listDepartmentCd) {
        this.listDepartmentCd = listDepartmentCd;
    }

    public String getDepartmentPCd() {
        return departmentPCd;
    }

    public void setDepartmentPCd(String departmentPCd) {
        this.departmentPCd = departmentPCd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortKey() {
        return sortKey;
    }

    public void setSortKey(Integer sortKey) {
        this.sortKey = sortKey;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDes3() {
        return des3;
    }

    public void setDes3(String des3) {
        this.des3 = des3;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateGroupCd() {
        return createGroupCd;
    }

    public void setCreateGroupCd(String createGroupCd) {
        this.createGroupCd = createGroupCd;
    }

    public String getCreateUserCd() {
        return createUserCd;
    }

    public void setCreateUserCd(String createUserCd) {
        this.createUserCd = createUserCd;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateGroupCd() {
        return updateGroupCd;
    }

    public void setUpdateGroupCd(String updateGroupCd) {
        this.updateGroupCd = updateGroupCd;
    }

    public String getUpdateUserCd() {
        return updateUserCd;
    }

    public void setUpdateUserCd(String updateUserCd) {
        this.updateUserCd = updateUserCd;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getOldUserNo() {
        return oldUserNo;
    }

    public void setOldUserNo(String oldUserNo) {
        this.oldUserNo = oldUserNo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
