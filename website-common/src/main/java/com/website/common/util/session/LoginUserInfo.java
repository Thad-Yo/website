package com.website.common.util.session;

import java.io.Serializable;

public class LoginUserInfo implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    private String departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 登录用户编号
     */
    private String userId;

    /*
     * 登录用户的账户
     */
    private String userName;

    /*
     * 登录用户的真实姓名
     */
    private String realName;

    /*
     * 用户类型 01：邀约员 02：外访员 03：邀约员 04：部门经理
     */
    private String userFlag;

    /*
     * 登录用户的在该公众账号下的OpenID
     */
    private String openId;
    
    /*
     * 手机号
     */
    private String mobile;
    
    /*
     * 分机号
     */
    private String extension;

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    
}
