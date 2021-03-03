package com.website.app.user;

import com.website.app.base.BaseDefine;

public class UserDefine implements BaseDefine {

	/** CONTROLLOR @value值 */
	public static final String CONTROLLOR_VALUE = "userController";

	/** CONTROLLOR @RequestMapping值 */
	public static final String CONTROLLOR_REQUEST_MAPPING = "/user";

	/** 修改用户密码 @RequestMapping值 */
	public static final String CHANGE_PASSWORD_ACTION = "changePasswordAction";

	/** 同意用户协议 @RequestMapping值 */
	public static final String AGREE_USER_AGREEMENT_ACTION = "agreeUserAgreementAction";

}
