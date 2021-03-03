package com.website.web.system.aboutUs;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.cache.RedisUtils;
import com.website.common.util.date.DateUtils;
import com.website.common.util.date.EnumDateStyle;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.auto.WebsiteScope;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.ext.ExtCTAttachment;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.service.contactUs.WebsiteFeedbackService;
import com.website.service.pro.AboutUsService;
import com.website.web.base.BaseController;
import com.website.web.base.BaseDefine;

import com.website.web.system.language.AreaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 13:48
 * @Description:
 */
@Controller
@RequestMapping(value = "/system/aboutUs")
public class AboutUsController extends BaseController {
	@Autowired
	private WebsiteFeedbackService websiteFeedbackService;
	@Autowired
	private AboutUsService aboutUsService;

	/**
	 * 订单查询画面初始化
	 *
	 * @return
	 */
	@RequestMapping("init")
	public ModelAndView init(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/aboutUs");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
		String flag = AreaUtil.getLanguageFlag(request);


		String cnEnFlag = "0";
		if(StringUtils.isNotBlank(flag)){
			cnEnFlag = flag;
		}
		WebsiteIntroduce websiteIntroduce = new WebsiteIntroduce();
		List<WebsiteScope> websiteScopeList = new ArrayList<>();
		List<CTAttachment> cTAttachmentList = new ArrayList<>();
		List<WebsiteDev> websiteDevList = new ArrayList<>();
		List<WebsiteHonor> websiteHonorList = new ArrayList<>();
		List<Integer> yearList = new ArrayList<>();
		List<Integer> honoryearList = new ArrayList<>();
		LinkedHashMap<String,List<WebsiteDev>> map = new LinkedHashMap<>();
		LinkedHashMap<String,List<WebsiteHonor>> websiteHonorMap = new LinkedHashMap<>();
		// 查询企业介绍
		List<WebsiteIntroduce> websiteIntroduceList = this.aboutUsService.selectWebsiteIntroduceList();

		if (websiteIntroduceList != null && websiteIntroduceList.size() > 0) {
			websiteIntroduce = websiteIntroduceList.get(0);
		}
		if(!"0".equals(cnEnFlag)){
			websiteIntroduce.setIntroduce(websiteIntroduce.getIntroduceEng());
		}
		modelAndView.addObject("websiteIntroduce", websiteIntroduce);

		// 查询集团规模变化列表
		websiteScopeList = this.aboutUsService.selectWebsiteScopeList();
		modelAndView.addObject("websiteScopeList", websiteScopeList);

		// 查询合作伙伴图片列表
		cTAttachmentList = this.aboutUsService.selectPartnersPic();
		
		int attSize = cTAttachmentList.size()/2;
        int battSize = cTAttachmentList.size()%2;
        if(battSize>0){
            attSize=attSize+1;
        }
		
		List attList = new ArrayList();
        for(int i = 0;i < attSize;i++){
            ExtCTAttachment ct = new ExtCTAttachment();
            List<CTAttachment> list = new ArrayList<>();
            for(int j = 0;j<cTAttachmentList.size();j++){
                if(i*2<=j && j<(i+1)*2){
                    list.add(cTAttachmentList.get(j));
                }
            }
            ct.setCtAttachmentList(list);
            attList.add(ct);
        }
		modelAndView.addObject("attachmentRecord", attList);

		// 查询发展历程列表
		websiteDevList = this.aboutUsService.selectWebsiteDevList();
		if (websiteDevList.size() > 0) {
			for (WebsiteDev websiteDev : websiteDevList) {
				if((!"0".equals(cnEnFlag)&&"1".equals(websiteDev.getHasEng()))||"0".equals(cnEnFlag)){
					String devDate = "";
					if(!"0".equals(cnEnFlag)){
						devDate = websiteDev.getDevDateEng();
						String date = DateUtils.integerToString(Integer.valueOf(devDate),
								EnumDateStyle.YYYY_MM_DD);
						websiteDev.setDevDateEng(date);
						yearList.add(DateUtils.getYear(date));
					}else{
						devDate = websiteDev.getDevDate();
						String date = DateUtils.integerToString(Integer.valueOf(devDate),
								EnumDateStyle.YYYY_MM_DD);
						websiteDev.setDevDate(date);
						yearList.add(DateUtils.getYear(date));

					}

				}
			}
		}
		yearList = this.removeDuplicate(yearList);
		Collections.sort(yearList);
		if(yearList.size() >0){
			for (Integer year : yearList) {
				List<WebsiteDev> list = new ArrayList<>();
				for (WebsiteDev websiteDev : websiteDevList) {
					if((!"0".equals(cnEnFlag)&&"1".equals(websiteDev.getHasEng()))||"0".equals(cnEnFlag)){
						String devDate = "";
						if(!"0".equals(cnEnFlag)){
							devDate = websiteDev.getDevDateEng();
							websiteDev.setDevDate(websiteDev.getDevDateEng());
							websiteDev.setDevText(websiteDev.getDevTextEng());
							websiteDev.setDevTitle(websiteDev.getDevTitleEng());
							websiteDev.setImgAddress(websiteDev.getImgAddressEng());
						}else{
							devDate = websiteDev.getDevDate();
						}
						Integer years = Integer.valueOf(devDate.substring(0, 4));
						if(years.intValue() == year.intValue()){
							list.add(websiteDev);
						}
					}

				}
				map.put(year + String.valueOf(list.size()), list);
			}
		}
		modelAndView.addObject("mapList", map);
		
		//查询荣誉资质列表
		websiteHonorList = this.aboutUsService.selectWebsiteHonorList();
		if (websiteHonorList.size() > 0) {
			for (WebsiteHonor websiteHonor : websiteHonorList) {
				if(!"0".equals(cnEnFlag)){
					websiteHonor.setImgAddress(websiteHonor.getImgAddressEng());
					websiteHonor.setHonorNumber(websiteHonor.getHonorNumberEng());
					websiteHonor.setHonorName(websiteHonor.getHonorNameEng());
					websiteHonor.setHonorState(websiteHonor.getHonorStateEng());
					websiteHonor.setHonorDetails(websiteHonor.getHonorDetailsEng());
				}
				if(StringUtils.isNotBlank(websiteHonor.getHonorNumber())){
					String date = DateUtils.integerToString(Integer.valueOf(websiteHonor.getHonorNumber()),
							EnumDateStyle.YYYY_MM_DD);
					honoryearList.add(DateUtils.getYear(date));
					websiteHonor.setHonorNumber(date);
				}
			}
		}
		honoryearList = this.removeDuplicate(honoryearList);
		Collections.sort(honoryearList);
		if(honoryearList.size() >0){
			for (Integer year : honoryearList) {
				List<WebsiteHonor> list = new ArrayList<>();
				for (WebsiteHonor websiteHonor : websiteHonorList) {
					if(StringUtils.isNotBlank(websiteHonor.getHonorNumber())){
						Integer years = Integer.valueOf(websiteHonor.getHonorNumber().substring(0, 4));
						if(years.intValue() == year.intValue()){
							list.add(websiteHonor);
						}
					}
				}
				websiteHonorMap.put(String.valueOf(year), list);
			}
		}
		modelAndView.addObject("websiteHonorMap", websiteHonorMap);
		return modelAndView;
	}

	/**
	 * 画面初始化
	 *
	 * @param request
	 * @param form
	 * @return
	 */
	@ResponseBody
	@RequestMapping("searchAction")
	public JSONObject searchAction(HttpServletRequest request,
			@ModelAttribute(BaseDefine.FORM) ExtWebsiteFeedbackModel form) {
		// 创建分页
		return this.createPage(request, form);
	}

	/**
	 * 创建分页机能
	 *
	 * @param request
	 * @param form
	 */
	private JSONObject createPage(HttpServletRequest request, ExtWebsiteFeedbackModel form) {

		JSONObject object = new JSONObject();
		// 翻页
		HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
		PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));

		ServiceResult<List<ExtWebsiteFeedbackModel>> result = this.websiteFeedbackService.findFeedbackList(form);

		if (result != null) {
			List<ExtWebsiteFeedbackModel> recordList = result.getResult();
			PageInfo paginator = new PageInfo(recordList);// 默认8页数据
			object.put("rows", paginator.getList());
			object.put("total", paginator.getTotal());
		}

		return object;
	}

	/**
	 * 去除集合重复数据
	 * 
	 * @param list
	 * @return
	 */
	public static List removeDuplicate(List list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).equals(list.get(i))) {
					list.remove(j);
				}
			}
		}
		return list;
	}
	/**
     * 荣誉资质详情页(含有id更新，不含有id添加)
     *
     * @param request
     * @param yearInput
     * @return
     */
    @RequestMapping("websiteHonorDetail")
    public ModelAndView info(HttpServletRequest request,@RequestParam String yearInput) {
        ModelAndView modelAndView = new ModelAndView("aboutUsHonor");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
		String flag = RedisUtils.get(hostIp);
		String cnEnFlag = "0";
		if(StringUtils.isNotBlank(flag)){
			cnEnFlag = flag;
		}

        List<WebsiteHonor> websiteHonorList = new ArrayList<>();
		List<Integer> honoryearList = new ArrayList<>();
		LinkedHashMap<String,List<WebsiteHonor>> websiteHonorMap = new LinkedHashMap<>();
      //查询荣誉资质列表
      		websiteHonorList = this.aboutUsService.selectWebsiteHonorList();
      		if (websiteHonorList.size() > 0) {
      			for (WebsiteHonor websiteHonor : websiteHonorList) {
					if(!"0".equals(cnEnFlag)){
						websiteHonor.setImgAddress(websiteHonor.getImgAddressEng());
						websiteHonor.setHonorNumber(websiteHonor.getHonorNumberEng());
						websiteHonor.setHonorName(websiteHonor.getHonorNameEng());
						websiteHonor.setHonorState(websiteHonor.getHonorStateEng());
						websiteHonor.setHonorDetails(websiteHonor.getHonorDetailsEng());
					}
					if(StringUtils.isNotBlank(websiteHonor.getHonorNumber())){
						String date = DateUtils.integerToString(Integer.valueOf(websiteHonor.getHonorNumber()),
								EnumDateStyle.YYYY_MM_DD);
						honoryearList.add(DateUtils.getYear(date));
						websiteHonor.setHonorNumber(date);
					}
      				
      			}
      		}
      		honoryearList = this.removeDuplicate(honoryearList);
      		Collections.sort(honoryearList);
      		if(honoryearList.size() >0){
      			for (Integer year : honoryearList) {
      				List<WebsiteHonor> list = new ArrayList<>();
      				for (WebsiteHonor websiteHonor : websiteHonorList) {
						if(StringUtils.isNotBlank(websiteHonor.getHonorNumber())){
							Integer years = Integer.valueOf(websiteHonor.getHonorNumber().substring(0, 4));
							if(years.intValue() == year.intValue()){
								list.add(websiteHonor);
							}
						}
      				}
      				websiteHonorMap.put(String.valueOf(year), list);
      			}
      		}
      		modelAndView.addObject("websiteHonorMap", websiteHonorMap);
      		modelAndView.addObject("year", yearInput);
        return modelAndView;
    }
	public static void main(String[] args) {
		String str = "2018-05-12";
		
		String substring = str.substring(5, 7);
		String string = str.substring(8,10);
		System.out.println(substring);
		System.out.println(string);
		
//		System.out.println(DateUtils.getYear(DateUtils.integerToString(Integer.valueOf(str), EnumDateStyle.YYYY_MM_DD)));
//		String date = DateUtils.DateToString(DateUtils.StringToDate(str, EnumDateStyle.YYYY_MM_DD),
//				EnumDateStyle.YYYY_MM_DD);
//		System.out.println(date);
	}
}
