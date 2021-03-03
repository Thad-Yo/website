package com.website.mybatis.bean.auto.system;

import java.io.Serializable;

public class CMRoleMenuPermission implements Serializable {
    private String id;

    private String roleId;

    private String menuId;

    private String permission;

    private String delFlag;

    private String createGroupCd;

    private String createUserCd;

    private String createDate;

    private String updateGroupCd;

    private String updateUserCd;

    private String updateDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
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
}