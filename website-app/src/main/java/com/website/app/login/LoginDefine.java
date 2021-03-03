package com.website.app.login;

import com.website.app.base.BaseDefine;

public class LoginDefine implements BaseDefine {

	/** CONTROLLOR @value值 */
	public static final String CONTROLLOR_VALUE = "loginController";

	/** CONTROLLOR @RequestMapping值 */
	public static final String CONTROLLOR_REQUEST_MAPPING = "/login";

	/** 用户登录 @RequestMapping值 */
	public static final String LOGIN_ACTION = "loginAction";

	/** 退出登录 @RequestMapping值 */
	public static final String LOGIN_OUT_ACTION = "loginOutAction";

	/** 校验登录状态 @RequestMapping值 */
	public static final String LOGIN_STATUS_ACTION = "loginStatusAction";

}
