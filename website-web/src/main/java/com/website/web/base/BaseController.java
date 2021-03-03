package com.website.web.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.string.GetterUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class BaseController {


    /**
     * 初始化数据绑定
     * <ol><li>将所有传递进来的String进行HTML编码，防止XSS攻击</li>
     * <li>将字段中Date类型转换为String类型</li></ol>
     * <p>@InitBinder 和 WebDataBinder 可以参考：https://segmentfault.com/a/1190000007013461</p>
     *
     * @param binder WebDataBinder
     */
    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                //setValue(null == text ? null : StringEscapeUtils.escapeHtml4(text.trim()));
                setValue(null == text ? null : text);
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return null != value ? value.toString() : StringUtils.EMPTY;
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateFormat.stringToDate(text));
            }
        });
        // Integer 类型转换
        binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (StringUtils.isEmpty(text)) {
                    setValue(null);
                } else {
                    setValue(text);
                }
            }
        });
    }

    /**
     * 取得年度列表
     *
     * @param selectedYear
     */
    public JSONArray getYearList(String selectedYear) {
        int year = DateUtils.getYear(new Date());

        JSONArray listYear = new JSONArray();
        JSONObject object = new JSONObject();
        for (int i = year - 10; i < year + 10; i++) {
            object = new JSONObject();
            object.put("year", i);
            object.put("selected", GetterUtil.getInteger(selectedYear) == i);
            listYear.add(object);
        }
        return listYear;
    }
    
    /**
     * 获取客户端真实IP
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request){
    	String ip = request.getHeader("x-forwarded-for");
    	System.out.println("***************x-forwarded-for:"+ip);
    	if(StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)){
    		ip = request.getHeader("Proxy-Client-IP");
        	System.out.println("P***************roxy-Client-IP:"+ip);
    	}
    	if(StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)){
    		ip = request.getHeader("WL-Proxy-Client-IP");
        	System.out.println("***************WL-Proxy-Client-IP:"+ip);
    	}
    	if(StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)){
    		ip = request.getRemoteAddr();
        	System.out.println("***************RemoteAddr:"+ip);
    	}
    	return ip;
    }
    
}
