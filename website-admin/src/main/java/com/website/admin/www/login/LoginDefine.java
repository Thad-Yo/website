package com.website.admin.www.login;

import com.website.admin.base.BaseDefine;

public class LoginDefine implements BaseDefine {

	/** CONTROLLOR @value值 */
	public static final String CONTROLLOR_VALUE = "loginController";

	/** CONTROLLOR @RequestMapping值 */
	public static final String CONTROLLOR_REQUEST_MAPPING = "/www/login";

	/** 登录画面 路径 */
	public static final String LOGIN_PATH = "/www/login/login";

	/** 登录成功跳转画面 路径 */
	public static final String LOGIN_SUCCESS_REDIRECT_VIEW = "/system/desktop/init";

	/** 迁移到详细画面 @RequestMapping值 */
	public static final String LOGIN_ACTION = "loginAction";

	/** 退出 */
	public static final String LOGIN_OUT = "loginOut";

	/** 生成图片验证码 */
	public static final String REGIST_RANDOMCODE = "registRandomcode";

	/** 验证图片验证码 */
	public static final String REGIST_CHECK_RANDOMCODE = "registCheckRandomcode";

	/**  验证@RequestMapping值 */
	public static final String REG_CHECK_ACTION = "regCheckAction";

}
