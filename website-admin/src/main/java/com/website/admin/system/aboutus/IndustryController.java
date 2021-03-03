package com.website.admin.system.aboutus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteIndustry;
import com.website.mybatis.bean.auto.WebsiteIndustryExample;
import com.website.mybatis.bean.auto.WebsiteIndustryExample.Criteria;
import com.website.mybatis.bean.auto.WebsiteIndustryWithBLOBs;
import com.website.mybatis.bean.ext.ExtWebsiteIndustryWithBLOBsModel;
import com.website.service.industry.IndustryService;

@Controller
@RequestMapping("/system/aboutus/industryController")
public class IndustryController {
	@Autowired
	private IndustryService industryService;
	/**
	 * @param request
	 * @param attr
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "init")
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/system/aboutUs/industry/industry_list");
        return modelAndView;
    }
	/**
	 * 查询
	 * @param request
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "searchAction")
    public JSONObject searchAction(HttpServletRequest request,WebsiteIndustry form) {
        // 创建分页
        return this.createPage(request, form);
    }
	/**
     * 创建分页机能
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteIndustry form) {
        JSONObject object = new JSONObject();
        List<WebsiteIndustryWithBLOBs> recordList = new ArrayList<>();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));
        // 取得内容
        WebsiteIndustryExample example = new WebsiteIndustryExample();
        if(StringUtils.isNotBlank(form.getHasEn())){
        	Criteria Criteria = example.createCriteria();
        	Criteria.andHasEnEqualTo(form.getHasEn());
        }
        example.setOrderByClause("industry_name_zh,industry_name_en,update_date");
        recordList = industryService.selectByExampleWithBLOBs(example);
        if (recordList != null) {
            PageInfo paginator = new PageInfo(recordList);
            object.put("rows", paginator.getList());
            object.put("total", paginator.getTotal());
        }
        return object;
    }
    /**
     * 保存
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("saveAction")
    public ServiceResult<JSONObject> saveAction(HttpServletRequest request, ExtWebsiteIndustryWithBLOBsModel form){
    	ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
    	String isEn = request.getParameter("isEn");
    	setZhOrEn(isEn,form,form);
    	res = industryService.saveWebsiteIndustry(form);
    	return res;
    }
    /**
     * 打开新增或编辑页，是同一个jsp
     * @param request
     * @return
     */
    @RequestMapping(value = "infoAction")
    public ModelAndView addInfo(HttpServletRequest request) {
    	String id = request.getParameter("id");
    	String isEn = request.getParameter("isEn");// 2代表是新增英文，1代表编辑英文，其他代表中文
    	ExtWebsiteIndustryWithBLOBsModel record = new ExtWebsiteIndustryWithBLOBsModel();
    	ModelAndView modelAndView = new ModelAndView("/system/aboutUs/industry/industry_info");
    	if(null == id || "".equals(id) || "undefined".equals(id)){//新增
    		modelAndView.addObject("isEn", "0");//新增页面默认为中文
    	}else{//编辑
    		WebsiteIndustryWithBLOBs websiteIndustry = industryService.selectByPrimaryKey(id);
    		BeanUtils.copyProperties(websiteIndustry, record);
    		if("1".equals(isEn)){
    			record.setImgUrl(websiteIndustry.getImgUrlEn());
    			record.setIndustryInfo(websiteIndustry.getIndustryInfoEn());
    			record.setIndustryName(websiteIndustry.getIndustryNameEn());
    		}else if("2".equals(isEn)){
    			record.setImgUrl("");
    			record.setIndustryInfo("");
    			record.setIndustryName("");
    		}else{
    			record.setImgUrl(websiteIndustry.getImgUrlZh());
    			record.setIndustryInfo(websiteIndustry.getIndustryInfoZh());
    			record.setIndustryName(websiteIndustry.getIndustryNameZh());
    		}
    		modelAndView.addObject("record", record);
    		modelAndView.addObject("isEn", isEn);
    	}
    	return modelAndView;
    }
    /**
     * 删除
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("deleteAction")
    public ServiceResult<JSONObject> deleteAction(HttpServletRequest request,String id){
    	ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
    	res = industryService.deleteByPrimaryKey(id);
    	return res;
    }
    /**
     * 给中文或英文字段赋值 Model1赋给Model2
     * @param isEn
     * @param Model1
     * @param Model2
     */
    private void setZhOrEn(String isEn,ExtWebsiteIndustryWithBLOBsModel Model1, ExtWebsiteIndustryWithBLOBsModel Model2){
    	if("1".equals(isEn) || "2".equals(isEn)){
    		Model2.setImgUrlEn(Model1.getImgUrl());
    		Model2.setIndustryInfoEn(Model1.getIndustryInfo());
    		Model2.setIndustryNameEn(Model1.getIndustryName());
    		Model2.setHasEn("1");
    	}else{
    		Model2.setImgUrlZh(Model1.getImgUrl());
    		Model2.setIndustryInfoZh(Model1.getIndustryInfo());
    		Model2.setIndustryNameZh(Model1.getIndustryName());
    		Model2.setHasEn("0");
    	}
    }
}
