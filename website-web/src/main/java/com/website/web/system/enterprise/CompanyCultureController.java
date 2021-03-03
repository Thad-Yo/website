package com.website.web.system.enterprise;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.common.collect.Lists;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.mybatis.bean.auto.WebsiteCommunity;
import com.website.mybatis.bean.auto.WebsiteOurStaff;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyCultureModel;
import com.website.service.culture.ComunityService;
import com.website.service.culture.OurstaffTypeService;
import com.website.service.culture.WebsiteOurStaffService;
import com.website.web.system.language.AreaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.website.common.util.cache.RedisUtils;
import com.website.web.base.BaseController;

/**
 * @Auther: mxy
 * @Date: 2018/11/30 09:31
 * @Description:
 */
@Controller
@RequestMapping(value = "/system/companyCulture")
public class CompanyCultureController extends BaseController{
	@Autowired
	private WebsiteOurStaffService websiteOurStaffService;
	@Autowired
	private ComunityService comunityService;
	/**
	 * 初始化联信文化
	 *
	 * @return
	 */
	@RequestMapping("init")
	public ModelAndView init(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/companyCulture");
		String hostIp = this.getIpAddr(request);
		String flag = AreaUtil.getLanguageFlag(request);

		String cnEnFlag = "0";
		if(StringUtils.isNotBlank(flag)){
			cnEnFlag = flag;
		}
		WebsiteOurStaff ourStaffCondition =  new WebsiteOurStaff();
		ourStaffCondition.setTypeCode(ConstantsUtil.CULTURE_STAFF);
		ourStaffCondition.setCnEnFlag(cnEnFlag);
		List<WebsiteOurStaff> ourStaffResult = this.websiteOurStaffService.findOurStaffList(ourStaffCondition).getResult();
		ArrayList<ExtWebsiteCompanyCultureModel> ourStaffList = Lists.newArrayList();
		String ourStaffType = "";
		int ourStaffNum = 1;
		for (WebsiteOurStaff temp : ourStaffResult) {
			if (!ourStaffType.equals(temp.getImgType())) {
				ourStaffType=temp.getImgType();
				ExtWebsiteCompanyCultureModel ourStaff = new ExtWebsiteCompanyCultureModel();
				ourStaff.setId("0" + ourStaffNum++);
				ourStaff.setTitleCN(temp.getImgTypeName());
				ourStaff.setTitleEN(temp.getImgTypeEnName());
				ourStaffList.add(ourStaff);
			}
			ExtWebsiteCompanyCultureModel img = new ExtWebsiteCompanyCultureModel();
			img.setSrc(temp.getImgUrl());
			img.setTitle(temp.getImgDesc());
			img.setHref("#");
			ourStaffList.get(ourStaffList.size() - 1).addChild(img);
		}

		WebsiteCommunity communityCondition =  new WebsiteCommunity();
		communityCondition.setCnEnFlag(cnEnFlag);
		List<WebsiteCommunity> communityResult = this.comunityService.findComunityList(communityCondition).getResult();
		ArrayList<ExtWebsiteCompanyCultureModel> communityList = Lists.newArrayList();
		for (WebsiteCommunity temp : communityResult) {
			ExtWebsiteCompanyCultureModel community = new ExtWebsiteCompanyCultureModel();
			community.setSrc(temp.getImgUrl());
			community.setSubSrc(temp.getImgLessUrl());
			community.setTitle(temp.getTitle());
			community.setText(temp.getImgDesc());
            communityList.add(community);
		}
		WebsiteOurStaff artCondition =  new WebsiteOurStaff();
		artCondition.setTypeCode(ConstantsUtil.CULTURE_ART);
		artCondition.setCnEnFlag(cnEnFlag);
		List<WebsiteOurStaff> artResult = this.websiteOurStaffService.findOurStaffList(artCondition).getResult();
        ArrayList<ExtWebsiteCompanyCultureModel> artList = Lists.newArrayList();
		String artType = "";
		for (WebsiteOurStaff temp : artResult) {
			if (!artType.equals(temp.getImgType())) {
				artType=temp.getImgType();
				ExtWebsiteCompanyCultureModel artItem = new ExtWebsiteCompanyCultureModel();
				artItem.setId(artType);
				artItem.setTitleCN(temp.getImgTypeName());
				artItem.setTitleEN(temp.getImgTypeEnName());
				artList.add(artItem);
			}
			ExtWebsiteCompanyCultureModel img = new ExtWebsiteCompanyCultureModel();
			img.setSrc(temp.getImgUrl());
			img.setSubSrc(temp.getImgLessUrl());
			img.setHref("#");
			artList.get(artList.size() - 1).addChild(img);
		}
		modelAndView.addObject("ourStaffList", ourStaffList);
		modelAndView.addObject("communityList", communityList);
		modelAndView.addObject("artList", artList);
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
