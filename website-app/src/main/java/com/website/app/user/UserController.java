/**
 * Copyright 2015-2016 the author is GOGTZ group.
 * System Name锛欸OGTZ寮?鍙戞鏋?
 * http://www.gogtz.com
 * 娉ㄦ剰锛? 鏈唴瀹逛粎闄愪簬GOGTZ灏忕粍鍐呴儴浣跨敤锛岀姝㈣浆鍙?
 */
package com.website.app.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.website.app.base.BaseController;
import com.website.app.base.BaseResultBean;
import com.website.app.constants.ConstantsUtil;
import com.website.app.util.SecretUtil;
import com.website.common.util.security.AES;
import com.website.common.util.security.CRC;
import com.website.common.util.security.MD5Util;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.user.CMUserService;

/**
 * 
 * app用户登录控制器
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 * @see 上午10:49:48
 */
@Controller(value = UserDefine.CONTROLLOR_VALUE)
@RequestMapping(value = UserDefine.CONTROLLOR_REQUEST_MAPPING)
public class UserController extends BaseController {

	@Autowired
	private CMUserService cmUserService;

	/**
	 * 
	 * 修改用户密码
	 * 
	 * @author renxingchen
	 * @param userRequestDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = UserDefine.CHANGE_PASSWORD_ACTION)
	public String changePasswordAction(@ModelAttribute UserRequestDto userRequestDto) {
		BaseResultBean resultBean = new BaseResultBean();
		String password = userRequestDto.getPassword();
		String newPassword = userRequestDto.getNewPassword();
		String token = userRequestDto.getToken();
		if (StringUtils.isNoneBlank(password) && StringUtils.isNotBlank(newPassword)) {
			String enctypt = SecretUtil.getEncrypt(token);// 获取用户私有秘钥
			// 解密
			password = AES.decrypt(password, enctypt);
			newPassword = AES.decrypt(newPassword, enctypt);
			// 校验sign是否正确
			if (CRC.generate(password + newPassword).equals(userRequestDto.getSign())) {
				// 根据原始密码查询用户
				CMUser tokenUser = SecretUtil.getTokenUser(token);
				CMUser user = cmUserService.getCMUserByUnpw(tokenUser.getUserName(), MD5Util.string2MD5(password));
				if (null != user) {
					// 校验新密码规则
					newPassword = newPassword.replace(" ", "");
					if (newPassword.length() < 6 || newPassword.length() > 20) {// 校验不通过
						resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
						resultBean.setMsg("密码长度为6-20位");
					} else {// 校验通过
						// 修改密码
						CMUser updateCmUser = new CMUser();
						updateCmUser.setUserId(tokenUser.getUserId());
						updateCmUser.setPassword(MD5Util.string2MD5(newPassword));
						if (cmUserService.updateCMUserByPrimaryKeySelective(updateCmUser) > 0) {// 修改密码成功
							resultBean.setCode(ConstantsUtil.APP_RESULT_SUCCESS_VALUE);
							resultBean.setMsg("修改密码成功");
						} else {// 修改密码失败
							resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
							resultBean.setMsg("修改密码失败");
						}
					}
				} else {
					resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
					resultBean.setMsg("修改密码失败");
				}
			} else {
				resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
				resultBean.setMsg("参数异常");
			}
		} else {
			resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
			resultBean.setMsg("参数异常");
		}
		return resultBean.toString();
	}

	/**
	 * 
	 * 同意用户协议
	 * 
	 * @author renxingchen
	 * @param token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = UserDefine.AGREE_USER_AGREEMENT_ACTION)
	public String agreeUserAgreementAction(String token) {
		BaseResultBean resultBean = new BaseResultBean();
		CMUser tokenUser = SecretUtil.getTokenUser(token);
		CMUser updateUser = new CMUser();
		updateUser.setUserId(tokenUser.getUserId());
		updateUser.setIsAgreeAgreement("0");
		if (cmUserService.updateCMUserByPrimaryKeySelective(updateUser) > 0) {
			resultBean.setCode(ConstantsUtil.APP_RESULT_SUCCESS_VALUE);
			resultBean.setMsg("同意用户协议成功");
		} else {
			resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
			resultBean.setMsg("同意用户协议失败");
		}
		return resultBean.toString();
	}

}
