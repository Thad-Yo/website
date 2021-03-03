package com.website.mybatis.bean.ext.system;

import java.io.Serializable;

import com.website.mybatis.bean.auto.system.CMRoleMenuPermission;

public class ExtPermissionModel extends CMRoleMenuPermission implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String userId;

    private String menuCtrl;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMenuCtrl() {
        return menuCtrl;
    }

    public void setMenuCtrl(String menuCtrl) {
        this.menuCtrl = menuCtrl;
    }

}