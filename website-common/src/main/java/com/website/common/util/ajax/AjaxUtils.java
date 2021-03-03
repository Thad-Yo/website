package com.website.common.util.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;

public class AjaxUtils {
	private static Logger logger = LoggerFactory.getLogger(AjaxUtils.class);

	public static final String FLG_SUCCESS = "0";

	public static final String FLG_ERROE = "1";

	/**
	 * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	 *
	 * @param response
	 * @param data
	 */
	public static void renderData(HttpServletResponse response, String data) {
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.print(data);
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		} finally {
			if (null != printWriter) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	/**
	 * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	 *
	 * @param response
	 * @param data
	 */
	public static void renderDataObject(HttpServletResponse response, Object data) {
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.print(data);
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		} finally {
			if (null != printWriter) {
				printWriter.flush();
				printWriter.close();
			}
		}
	}

	/**
	 * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	 *
	 * @param response
	 * @param data
	 */
	public static String isSuccess(String data) {
		JSONObject successObj = new JSONObject();
		successObj.put("success", data);
		return successObj.toJSONString();
	}

	/**
	 * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	 *
	 * @param response
	 * @param data
	 */
	public static String isExists(boolean flag) {
		JSONObject successObj = new JSONObject();
		successObj.put("isExists", flag);
		return successObj.toJSONString();
	}

	/**
	 * 字符串转换成JSONArray
	 *
	 * @param str
	 * @return
	 */
	public static JSONArray parseArray(String str) {
		if (StringUtils.isNullOrEmpty(str)) {
			return null;
		}
		if (str.contains(",")) {
			return JSONArray.parseArray(str);
		}
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(str.replaceAll("\\[|\\]", ""));
		return jsonArray;
	}
}
