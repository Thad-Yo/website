package com.website.common.util.properties;

import org.apache.commons.lang.StringUtils;

public class MessageUtil {

	/**
	 * 根据消息的KEY获取消息的具体内容
	 *
	 * @param messageKey
	 * @param params
	 * @return
	 */
	public static String getMessage(String messageKey) {
		return getMessage(messageKey, StringUtils.EMPTY);
	}

	/**
	 * 根据消息的KEY获取消息的具体内容
	 *
	 * @param messageKey
	 * @param params
	 * @return
	 */
	public static String getMessage(String messageKey, String... params) {
		String message = PropertyUtil.getMessageResourcesPropertieValue(messageKey);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				message = message.replace("{" + i + "}", params[i]);
			}
		}
		return message;
	}
}
