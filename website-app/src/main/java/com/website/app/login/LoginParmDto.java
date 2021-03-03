/*
 * Copyright(c) 2012-2017 JD Pharma.Ltd. All Rights Reserved.
 * 
 */
package com.website.app.login;

import lombok.Data;

import com.website.app.base.BaseRequestDto;

/**
 * 此处为类说明
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 * @see 上午10:52:31
 */
@Data
public class LoginParmDto extends BaseRequestDto {

	/**
	 * 此处为属性说明
	 */
	private static final long serialVersionUID = -8719818952446069031L;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

}
