package com.website.web.system.language;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.cache.RedisUtils;
import com.website.web.base.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 13:48
 * @Description:
 */
@Controller
@RequestMapping(value="/system/language")
public class LanguageController extends BaseController {
    /**
     * 更换
     *
     * @param request
     * @return
     */
    @RequestMapping("init")
    public ServiceResult<String> init(HttpServletRequest request, @RequestParam String redisFlag) {
        ServiceResult<String> serviceStr = new ServiceResult<>();
        String hostIp = this.getIpAddr(request);
        //String hostAddr = request.getRemoteAddr();
        

//        java.util.Map<String,String> map1 = System.getenv();  
//        System.out.println("================="+map1.get("USERNAME"));//获取用户名  
//        System.out.println("================="+map1.get("COMPUTERNAME"));//获取计算机名  
//        System.out.println("================="+map1.get("USERDOMAIN"));//获取计算机域名  
//        

        if(StringUtils.isNotBlank(redisFlag)){
            RedisUtils.set(hostIp,redisFlag,60);
        }
        
        /*String flag = RedisUtils.get(hostIp);
        String cnEnFlag = "";
        if(StringUtils.isBlank(flag)){
        	RedisUtils.set(hostIp,cnEnFlag);
        }
        else if("0".equals(flag)){
            cnEnFlag="1";
            RedisUtils.set(hostIp,cnEnFlag);
        }
        else if("1".equals(flag)){
            cnEnFlag="0";
            RedisUtils.set(hostIp,cnEnFlag);
        }*/
        
        serviceStr.setResult(redisFlag);
        serviceStr.setSuccess(true);
        return serviceStr;
    }
 
    /**
     * 获取当前客户对应的中英文选项
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getLanguage", method = RequestMethod.POST)
    public String getLanguage(HttpServletRequest request) {
    	String hostIp = this.getIpAddr(request);
    	String flag = RedisUtils.get(hostIp);
        
        if(StringUtils.isBlank(flag)){
        	flag = "0";
        }
        return flag;
    }
    
}
