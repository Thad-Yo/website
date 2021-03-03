/*
 * Copyright(c) 2012-2017 JD Pharma.Ltd. All Rights Reserved.
 * 
 */
package com.website.app.base;

import java.io.Serializable;

import lombok.Data;

/**
 * 接收请求参数基类
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 * @see 上午10:37:44
 */
@Data
public class BaseRequestDto implements Serializable {

	/**
	 * 此处为属性说明
	 */
	private static final long serialVersionUID = 5089870253682532996L;

	/**
	 * 应用ID
	 */
	private String appid;

	/**
	 * 应用ID
	 */
	private String version;

	/**
	 * 应用平台
	 */
	private String platform;

	/**
	 * 网络类型
	 */
	private String netType;

	/**
	 * 校验值
	 */
	private String sign;

	/**
	 * 用户token
	 */
	private String token;

}
