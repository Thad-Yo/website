package com.website.common.util.validator;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by ZN on 2016/10/31.
 */
public class ValidatorAjaxCheckResult {
    /**
     * @param cnt
     * @param message
     * @return
     */
    public static String getAjaxCheckResult(int cnt, String message) {
        JSONObject ret = new JSONObject();
        if (cnt > 0) {
            ret.put("info", message);
        }
        // 没有错误时,返回y
        if (!ret.containsKey("info")) {
            ret.put("status", "y");
        }
        return ret.toString();
    }
    
    /**
     * @param cnt
     * @param message
     * @return
     */
    public static String getAjaxCheckResultYear(int cnt, String message) {
        JSONObject ret = new JSONObject();
        if (cnt > 1) {
            ret.put("info", message);
        }
        // 没有错误时,返回y
        if (!ret.containsKey("info")) {
            ret.put("status", "y");
        }
        return ret.toString();
    }
}
