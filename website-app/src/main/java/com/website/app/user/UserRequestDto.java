/*
 * Copyright(c) 2012-2017 JD Pharma.Ltd. All Rights Reserved.
 * 
 */
package com.website.app.user;

import lombok.Data;

import com.website.app.base.BaseRequestDto;

/**
 * 此处为类说明
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月20日
 * @see 上午10:00:24
 */
@Data
public class UserRequestDto extends BaseRequestDto {

	/**
	 * 此处为属性说明
	 */
	private static final long serialVersionUID = -1594216431187612963L;

	private String password;

	private String newPassword;

}
