/**
 * Copyright 2015-2016 the author is GOGTZ group.
 * System Name锛欸OGTZ寮?鍙戞鏋?
 * http://www.gogtz.com
 * 娉ㄦ剰锛? 鏈唴瀹逛粎闄愪簬GOGTZ灏忕粍鍐呴儴浣跨敤锛岀姝㈣浆鍙?
 */
package com.website.app.login;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.website.app.base.BaseController;
import com.website.app.base.BaseRequestDto;
import com.website.app.base.BaseResultBean;
import com.website.app.constants.ConstantsUtil;
import com.website.app.util.SecretUtil;
import com.website.app.util.TokenValue;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.cache.RedisUtils;
import com.website.common.util.security.AES;
import com.website.common.util.security.CRC;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.LoginService;

/**
 * 
 * app用户登录控制器
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 * @see 上午10:49:48
 */
@Controller(value = LoginDefine.CONTROLLOR_VALUE)
@RequestMapping(value = LoginDefine.CONTROLLOR_REQUEST_MAPPING)
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;

	PropertyFilter propertyFilter = new PropertyFilter() {

		@Override
		public boolean apply(Object arg0, String name, Object value) {
			if (name.equalsIgnoreCase("limitStart")) {
				return false;
			}
			if (name.equalsIgnoreCase("limitEnd")) {
				return false;
			}
			return true;
		}
	};

	/**
	 * 用户登录
	 *
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = LoginDefine.LOGIN_ACTION)
	public String loginAction(@ModelAttribute LoginParmDto loginParmDto) {
		String username = loginParmDto.getUsername();
		String password = loginParmDto.getPassword();
		BaseResultBean resultBean = new BaseResultBean();
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
			resultBean.setMsg("请输入用户名和密码！");
		} else {
			username = AES.decrypt(username, ConstantsUtil.APP_KEY);
			password = AES.decrypt(password, ConstantsUtil.APP_KEY);
			// 查询用户信息
			CMUser user = new CMUser();
			user.setUserName(username);
			user.setPassword(password);
			ServiceResult<CMUser> serviceResult = loginService.getCMUser(user);
			user = serviceResult.getResult();
			if (null == user) {// 用户查询失败，没有查询到相关用户
				resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
				resultBean.setMsg("用户名或密码错误！");
			} else {// 用户查询成功
			    //根据用户ID获取用户的角色列表
			    List<String> roleCdList = (loginService.getUserRole(user.getUserId())).getResult();
			    if(roleCdList!=null && roleCdList.size()>0){
			        for(int i=0; i<roleCdList.size(); i++){
			            String role = roleCdList.get(i);
			            if(role.equals(ConstantsUtil.ROLE_ADMIN)){
			                 // 校验sign是否正确
		                    if (CRC.generate(username + password).equals(loginParmDto.getSign())) {// sign校验成功
		                        // 生成用户token及16位加密key并保存
		                        String encrypt = SecretUtil.getRandomCode(16);
		                        String token = SecretUtil.createToken(user, encrypt);
		                        // 开始封装返回数据对象
		                        CMUser cmUser = new CMUser();
		                        JSONObject jsonObject = encapsulateResultUser(token, encrypt, user, cmUser);
		                        // 开始封装返回结果
		                        resultBean.setCode(ConstantsUtil.APP_RESULT_SUCCESS_VALUE);
		                        resultBean.setMsg("登录成功");
		                        resultBean.setData(jsonObject);
		                    } else {// sign校验失败
		                        resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
		                        resultBean.setMsg("参数异常，请重新登录！");
		                    }
		                    break;
			            }else{
			                resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
                            resultBean.setMsg("用户名或密码错误！");
			            }
			        }
			    }else{
			        resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
	                resultBean.setMsg("用户名或密码错误！");
			    }
			}
		}
		return JSON.toJSONString(resultBean, propertyFilter);
	}

	/**
	 * 
	 * 用户退出
	 * 
	 * @author renxingchen
	 * @param sign
	 * @param token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = LoginDefine.LOGIN_OUT_ACTION)
	public String loginOutAction(@ModelAttribute BaseRequestDto baseRequestDto) {
		BaseResultBean resultBean = new BaseResultBean();
		String token = baseRequestDto.getToken();
		String sign = baseRequestDto.getSign();
		if (CRC.generate(token).equals(sign)) {
			// 删除token
			RedisUtils.del(token);
			resultBean.setCode(ConstantsUtil.APP_RESULT_SUCCESS_VALUE);
			resultBean.setMsg("退出成功");
		} else {
			resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_VALUE);
			resultBean.setMsg("退出失败");
		}
		return resultBean.toString();
	}

	/**
	 * 
	 * 验证用户登录状态
	 * 
	 * @author renxingchen
	 * @param token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = LoginDefine.LOGIN_STATUS_ACTION)
	public String loginStatusAction(String token) {
		BaseResultBean resultBean = new BaseResultBean();
		if (StringUtils.isNotBlank(token)) {
			token = AES.decrypt(token, ConstantsUtil.APP_KEY);
			String tokenValue = RedisUtils.get(token);
			if (StringUtils.isNotBlank(tokenValue)) {// 说明用户登录状态有效
				// 获取token值
				TokenValue value = JSON.parseObject(tokenValue, TokenValue.class);
				String encrypt = value.getEncrypt();
				CMUser tokenUser = value.getUserInfo();
				// 开始封装返回数据
				CMUser cmUser = new CMUser();
				JSONObject jsonObject = encapsulateResultUser(token, encrypt, tokenUser, cmUser);
				// 开始封装返回结果
				resultBean.setCode(ConstantsUtil.APP_RESULT_SUCCESS_VALUE);
				resultBean.setMsg("用户令牌有效");
				resultBean.setData(jsonObject);
			} else {// 说明用户登录状态失效
				resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_TOKEN_VALUE);
				resultBean.setMsg("用户令牌失效");
			}
		} else {
			resultBean.setCode(ConstantsUtil.APP_RESULT_FINAL_TOKEN_VALUE);
			resultBean.setMsg("用户令牌失效");
		}
		return JSON.toJSONString(resultBean, propertyFilter);
	}

	/**
	 * 
	 * 封装返回的用户信息
	 * 
	 * @author renxingchen
	 * @param token
	 * @param encrypt
	 * @param tokenUser
	 * @param cmUser
	 * @return
	 */
	private JSONObject encapsulateResultUser(String token, String encrypt, CMUser cmUser, CMUser resultUser) {
		resultUser.setUserId(cmUser.getUserId());
		resultUser.setRealName(cmUser.getRealName());
		resultUser.setUserName(cmUser.getUserName());
		resultUser.setMobileNumber(cmUser.getMobileNumber());
		resultUser.setIsAgreeAgreement(cmUser.getIsAgreeAgreement());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user", resultUser);
		jsonObject.put("encrypt", encrypt);
		jsonObject.put("token", token);
		return jsonObject;
	}

}
