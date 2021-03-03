/*
 * Copyright(c) 2012-2017 JD Pharma.Ltd. All Rights Reserved.
 * 
 */
package com.website.app.util;

import com.website.mybatis.bean.auto.system.CMUser;

import lombok.Data;

/**
 * token值，由用户信息及16位加密码组成
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 * @see 下午12:31:31
 */
@Data
public class TokenValue {

	public TokenValue() {
		super();
	}

	public TokenValue(CMUser userInfo, String encrypt) {
		super();
		this.userInfo = userInfo;
		this.encrypt = encrypt;
	}

	private CMUser userInfo;

	private String encrypt;

}
