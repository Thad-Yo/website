package com.website.web.shiro;

import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;


public class ShiroUtil {

	/**
	 * 更新权限
	 */
	public static void updateAuth() {
		LoginUserInfo user = SessionUtils.getLoginUserInfo();
		if (user != null) {
		}
	}
}
