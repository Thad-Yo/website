package com.website.web.system.enterprise;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.website.web.system.language.AreaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.website.common.util.cache.RedisUtils;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.service.pro.AboutUsService;
import com.website.web.base.BaseController;

/**
 * @Auther: mxy
 * @Date: 2018/11/30 09:31
 * @Description:
 */
@Controller
@RequestMapping(value = "/system/companyIntroduce")
public class CompanyIntroduceController extends BaseController{
	
	@Autowired
	private AboutUsService aboutUsService;
	/**
	 * 初始化企业介绍
	 *
	 * @return
	 */
	@RequestMapping("init")
	public ModelAndView init(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/companyIntroduce");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
		String flag = AreaUtil.getLanguageFlag(request);

		String cnEnFlag = "0";
		if(StringUtils.isNotBlank(flag)){
			cnEnFlag = flag;
		}
		WebsiteIntroduce websiteIntroduce = new WebsiteIntroduce();
		// 查询企业介绍
		List<WebsiteIntroduce> websiteIntroduceList = this.aboutUsService.selectWebsiteIntroduceList();

		if (websiteIntroduceList != null && websiteIntroduceList.size() > 0) {
			websiteIntroduce = websiteIntroduceList.get(0);
		}
		if(!"0".equals(cnEnFlag)){
			websiteIntroduce.setIntroduce(websiteIntroduce.getIntroduceEng());
		}
		modelAndView.addObject("websiteIntroduce", websiteIntroduce);
		return modelAndView;
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
