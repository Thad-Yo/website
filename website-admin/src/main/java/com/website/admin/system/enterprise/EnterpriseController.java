package com.website.admin.system.enterprise;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateFormat;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel;
import com.website.service.enterprise.WebsiteCompanyNewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 联信动态-公司新闻
 * @Auther: hzm
 * @Date: 2018/5/29 11:21
 * @Description:
 */
@Controller
@RequestMapping(value="/system/enterprise")
public class EnterpriseController {
    @Autowired
    WebsiteCompanyNewsService websiteCompanyNewsService;

    /**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(
            @ModelAttribute(BaseDefine.FORM) WebsiteCompanyNews form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/companynews/companynews_list");
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
                                   @ModelAttribute(BaseDefine.FORM) ExtWebsiteCompanyNewsModel form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, ExtWebsiteCompanyNewsModel form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));

        ServiceResult<List<ExtWebsiteCompanyNewsModel>> result = this.websiteCompanyNewsService
                .findCompanyNewsList(form);

        if (result != null) {
            List<ExtWebsiteCompanyNewsModel> recordList = result.getResult();
            PageInfo paginator = new PageInfo(recordList);// 默认8页数据
            object.put("rows", paginator.getList());
            object.put("total", paginator.getTotal());
        }

        return object;
    }

    /**
     * 画面迁移(含有id更新，不含有id添加)
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("infoAction")
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteCompanyNews form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/companynews/companynews_info");

        if(StringUtils.isNotBlank(form.getId())){
            ServiceResult<WebsiteCompanyNews> result = this.websiteCompanyNewsService
                    .getRecord(form);
            modelAndView.addObject("record", result.getResult());
        }

        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 插入新闻
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("insertAction")
    public ServiceResult<WebsiteCompanyNews> insertAction(HttpServletRequest request,
                                                          WebsiteCompanyNews form) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<WebsiteCompanyNews>();

        result = this.websiteCompanyNewsService.insertRecord(form);
        return result;
    }

    /**
     * 更改新闻
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("updateAction")
    public ServiceResult<WebsiteCompanyNews> updateAction(HttpServletRequest request,
                                                                   WebsiteCompanyNews form) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<WebsiteCompanyNews>();

        result = this.websiteCompanyNewsService.updateRecord(form);
        return result;
    }
    
    /**
     * 用户删除新闻记录
     *
     * @return
     */
    @RequestMapping(value = "removeOrderAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> removeOrderAction(HttpServletRequest request, @RequestBody WebsiteCompanyNews form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();

        String id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteCompanyNews> recordResult = this.websiteCompanyNewsService.removeRecord(id);
            if (recordResult.isSuccess()) {
                isSuccess = true;
                message="删除成功";
            }else{
                message="删除失败";
            }
        }else{
            message="删除失败";
        }

        ret.setSuccess(isSuccess);
        ret.setMessage(message);
        return ret;
    }
    
    /**
     * 预览新闻详情页(含有id更新，不含有id添加)
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("previewDetail")
    public ModelAndView previewDetail(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteCompanyNews form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/companynews/companynews_preview");
        if(StringUtils.isBlank(form.getCnEnFlag())){
        	form.setCnEnFlag("0");
        }
        if(StringUtils.isBlank(form.getType())){
        	form.setType("0");
        }
        if(StringUtils.isNotBlank(form.getPublishTime())){
        	Date date = DateFormat.stringToDate(form.getPublishTime(), DateFormat.YYYY_MM_DD_HH_MM_SS);
        	form.setPublishTime(DateFormat.dateToString(date, DateFormat.YYYY_MM_DD));
        }
        modelAndView.addObject("newsRecord", form);
        
        return modelAndView;
    }
}
