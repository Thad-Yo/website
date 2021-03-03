/*
 * Copyright(c) 2012-2017 JD Pharma.Ltd. All Rights Reserved.
 * 
 */
package com.website.app.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import lombok.Data;

/**
 * app应用返回对象基类
 *
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月17日
 */
@Data
public class BaseResultBean implements Serializable {

	/**
	 * 此处为属性说明
	 */
	private static final long serialVersionUID = -5098817149269432750L;

	public BaseResultBean() {
		super();
	}

	public BaseResultBean(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 响应码
	 */
	private String code;

	/**
	 * 响应信息
	 */
	private String msg;

	/**
	 * 响应数据体
	 */
	private Object data = "";

	public String toString() {
		return JSON.toJSONString(this);
	}
	public String toString(PropertyFilter propertyFilter) {
		return JSON.toJSONString(this, propertyFilter);
	}
}
