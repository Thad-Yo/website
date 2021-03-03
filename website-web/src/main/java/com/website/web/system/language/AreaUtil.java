package com.website.web.system.language;

import com.alibaba.fastjson.JSONObject;
import com.website.common.util.cache.RedisUtils;
import com.website.common.util.http.HttpDeal;
import com.website.common.util.properties.PropertyUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hzm
 * @Date: 2019/5/29 10:08
 * @Description:
 */
public class AreaUtil {
    private static String ipKey = PropertyUtil.getSystemResourcesPropertieValue("ip.key");
    private static String ipUrl = PropertyUtil.getSystemResourcesPropertieValue("ip.server");

    public static String getLanguageFlag(HttpServletRequest request){

        String hostIp = request.getHeader("x-forwarded-for");
        System.out.println("***************x-forwarded-for:"+hostIp);
        if(StringUtils.isBlank(hostIp) || "unknown".equalsIgnoreCase(hostIp)){
            hostIp = request.getHeader("Proxy-Client-IP");
            System.out.println("P***************roxy-Client-IP:"+hostIp);
        }
        if(StringUtils.isBlank(hostIp) || "unknown".equalsIgnoreCase(hostIp)){
            hostIp = request.getHeader("WL-Proxy-Client-IP");
            System.out.println("***************WL-Proxy-Client-IP:"+hostIp);
        }
        if(StringUtils.isBlank(hostIp) || "unknown".equalsIgnoreCase(hostIp)){
            hostIp = request.getRemoteAddr();
            System.out.println("***************RemoteAddr:"+hostIp);
        }
        //0中文1英文
        String languageFlag ="";
        String content = "";

        if(StringUtils.isNotBlank(hostIp)) {
            String redisFlag = RedisUtils.get(hostIp);
            if(StringUtils.isNotEmpty(redisFlag)){
                languageFlag = redisFlag;
            }else{
                try{
                    Map<String, String> params = new HashMap<>();
                    params.put("ip", hostIp);
                    params.put("key", ipKey);
                    content = HttpDeal.post(ipUrl, params);
                    JSONObject jsStr = JSONObject.parseObject(content);
                    String responseCode = jsStr.get("resultcode").toString();
                    if ("200".equals(responseCode)) {
                        String country = JSONObject.parseObject(jsStr.get("result").toString()).get("Country").toString();
                        if ("".equals(country) ||"中国".equals(country) || "127.0.0.1".equals(hostIp)) {
                            languageFlag = "0";
                        } else {
                            languageFlag = "1";
                        }
                    } else {
                        languageFlag = "0";
                    }
                }catch (Exception e){
                    languageFlag = "0";
                }
            }
        }
        RedisUtils.set(hostIp,languageFlag,60*60*24);
        return languageFlag;
    }
}
