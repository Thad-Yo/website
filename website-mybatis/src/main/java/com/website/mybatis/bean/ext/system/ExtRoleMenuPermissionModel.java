package com.website.mybatis.bean.ext.system;

import java.io.Serializable;
import java.util.List;

public class ExtRoleMenuPermissionModel implements Serializable {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  private String menuId;

  private String parentMenuId;

  private String menuName;

  private String menuIcon;

  private String flag;

  private String roleId;

  public List<ExtRoleMenuPermissionModel> menuTreeClild;

  public List<ExtRoleMenuPermissionModel> getMenuTreeClild() {
    return menuTreeClild;
  }

  public void setMenuTreeClild(List<ExtRoleMenuPermissionModel> menuTreeClild) {
    this.menuTreeClild = menuTreeClild;
  }

  public String getMenuId() {
    return menuId;
  }

  public void setMenuId(String menuId) {
    this.menuId = menuId;
  }

  public String getParentMenuId() {
    return parentMenuId;
  }

  public void setParentMenuId(String parentMenuId) {
    this.parentMenuId = parentMenuId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }
}