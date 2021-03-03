package com.website.mybatis.bean.ext.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.website.mybatis.bean.auto.system.CMMenu;

public class ExtMenuModel extends CMMenu implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String username;

    private String permission;

    private String userCd;

    private List<ExtMenuModel> menuTreeClild = new ArrayList<ExtMenuModel>();

    public List<ExtMenuModel> getMenuTreeClild() {
        return menuTreeClild;
    }

    public void setMenuTreeClild(List<ExtMenuModel> menuTreeClild) {
        this.menuTreeClild = menuTreeClild;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUserCd() {
        return userCd;
    }

    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }

}