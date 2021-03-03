package com.website.admin.system.bancgroundManagement;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseController;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.common.util.file.FileUtils;
import com.website.common.util.paginator.Paginator;
import com.website.common.util.properties.PropertyUtil;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteFiliale;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.mybatis.mapper.auto.WebsiteFilialeMapper;
import com.website.mybatis.mapper.auto.WebsiteIntroduceMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteIntroduceMapper;
import com.website.service.pro.AboutUsService;
import com.website.service.pro.FilialeService;
import com.website.service.pro.HomePageService;
import com.website.service.pro.HonorService;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.geom.Area;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author xzx
 * @version V1.0  
 * @date Tue Jul 12 16:47:53 CST 2016
 */
@Controller
@RequestMapping(value = "/system/backgroundManageMent/filialeController")
public class FilialeController extends BaseController {

    @Autowired
    private FilialeService filialeService;
    @Autowired
	protected WebsiteFilialeMapper websiteFilialeMapper;


    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "init")
    public ModelAndView init(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteFiliale form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/aboutUs/filiale_list");
    	return modelAndView;
    }
    /**
     * 新增编辑界面
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "addInfo")
    public ModelAndView addInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteFiliale form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/aboutUs/filiale_edit");
    	// 地区列表
        ServiceResult<List<Area>> selectResult = filialeService.getProvince();
        modelAndView.addObject("provinceList", selectResult.getResult());
    	return modelAndView;
    }
    /**
     * 编辑界面
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "editInfo")
    public ModelAndView editInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteFiliale form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/aboutUs/filiale_edit");
    	WebsiteFiliale dev = this.filialeService.getConfigBanner(form);
    	// 地区列表
        ServiceResult<List<Area>> selectResult = filialeService.getProvince();
        modelAndView.addObject("provinceList", selectResult.getResult());
    	modelAndView.addObject("row", dev);
    	return modelAndView;
    }

    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "searchAction")
    public JSONObject searchAction(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteFiliale form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteFiliale form) {
        JSONObject object = new JSONObject();
        List<WebsiteFiliale> recordList = new ArrayList<>();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));

        // 取得内容
        ServiceResult<List<WebsiteFiliale>> recordResult = this.filialeService.getRecordList(form);

        if (recordResult != null) {
        	List<WebsiteFiliale> aaa = recordResult.getResult();
			PageInfo paginator = new PageInfo(aaa);
            object.put("rows", paginator.getList());
            object.put("total", paginator.getTotal());
        }


        return object;
    }

    /**
     * 保存   编辑   分公司信息
     */
    @ResponseBody
    @RequestMapping(value = "saveAction")
    public ServiceResult<JSONObject> saveAction(HttpServletRequest request, WebsiteFiliale form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	
    	ServiceResult<WebsiteFiliale> recordResult = this.filialeService.updateNew(form);
    		
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
   /**
     * 删除banner
     */
    @ResponseBody
    @RequestMapping(value = "deleteAction")
    public ServiceResult<JSONObject> deleteAction(HttpServletRequest request, WebsiteFiliale form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	ServiceResult<WebsiteFiliale> recordResult = this.filialeService.deleteAction(form);
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
    
    
    
    
    
    
    
    
    
    
    

}

