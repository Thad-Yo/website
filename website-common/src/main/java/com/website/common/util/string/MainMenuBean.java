package com.website.common.util.string;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainMenuBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String menuPuuid;

	private String menuUuid;

	private String menuName;

	private String menuUrl;

	private String menuIcon;

	private String menuSort;

	private String menuCtrl;

	private List<MainMenuBean> menuTreeClild = new ArrayList<MainMenuBean>();

	private String username;

	private String permission;

	private String userCd;

	public String getUserCd() {
		return userCd;
	}

	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}

	public String getMenuPuuid() {
		return menuPuuid;
	}

	public void setMenuPuuid(String menuPuuid) {
		this.menuPuuid = menuPuuid;
	}

	public String getMenuUuid() {
		return menuUuid;
	}

	public void setMenuUuid(String menuUuid) {
		this.menuUuid = menuUuid;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(String menuSort) {
		this.menuSort = menuSort;
	}

	public String getMenuCtrl() {
		return menuCtrl;
	}

	public void setMenuCtrl(String menuCtrl) {
		this.menuCtrl = menuCtrl;
	}

	public List<MainMenuBean> getMenuTreeClild() {
		return menuTreeClild;
	}

	public void setMenuTreeClild(List<MainMenuBean> menuTreeClild) {
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
}