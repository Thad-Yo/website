package com.website.common.util.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.website.common.util.constants.ConstantsUtil;

/**
 * <p>
 * 共通错误文件
 * </p>
 *
 * @author gration
 * @version 1.0.0
 */
public class ValidatorErrors {
	private static final String PREFIX = "ValidatorErrors-";

	/**
	 * 添加错误信息
	 *
	 * @param mav
	 * @param key
	 */
	@SuppressWarnings("unchecked")
	public static void add(Map<String, Object> mav, String itemName, String key, String message) {
		if (mav == null) {
			mav = new HashMap<String, Object>();
		}
		if (StringUtils.isNotBlank(itemName) && StringUtils.isNotBlank(key)) {
			Object obj = mav.get(PREFIX + itemName);
			List<KeyValueBean> list = null;
			if (obj == null) {
				list = new ArrayList<KeyValueBean>();
			} else {
				list = (List<KeyValueBean>) obj;
			}
			list.add(new KeyValueBean(key, message));

			mav.put(PREFIX + itemName, list);

			mav.put(ConstantsUtil.FORM_HAS_ERROR, ConstantsUtil.FORM_HAS_ERROR);
		}
	}

	/**
	 * 判断错误信息是否为空
	 *
	 * @param mav
	 * @param key
	 */
	public static boolean isEmpty(Map<String, Object> mav) {
		if (mav == null) {
			return true;
		}

		for (String key : mav.keySet()) {
			if (StringUtils.isNotBlank(key) && key.startsWith(PREFIX)) {
				return false;
			}
		}

		return true;
	}
}
