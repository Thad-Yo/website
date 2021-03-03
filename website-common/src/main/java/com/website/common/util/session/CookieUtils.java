/**
 * Description:（类功能描述-必填） 需要在每个方法前添加业务描述，方便业务业务行为的BI工作
 * Copyright: Copyright (Gration Corporation)2015
 * Company: Gration Corporation
 *
 * @author: b
 * @version: 1.0
 * Created at: 2015年12月31日 下午4:38:56
 * Modification History:
 * Modified by :
 */

package com.website.common.util.session;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    /**
     * 保存cookie
     *
     * @param name
     * @param value
     * @param response
     */
    public static void setCookie(String name, String value, HttpServletResponse response) {
        setCookie(name, value, -1, response);
    }

    /**
     * 保存cookie
     *
     * @param name
     * @param value
     * @param time
     * @param response
     */
    public static void setCookie(String name, String value, int time, HttpServletResponse response) {
        Cookie c = new Cookie(name, value);
        c.setMaxAge(time);
        response.addCookie(c);
    }

    /**
     * 判断cookie是否存在
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static boolean hasCookie(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据名字获取cookie
     *
     * @param request
     * @param name    cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
