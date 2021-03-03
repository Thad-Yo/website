package com.website.admin.system.enterprise;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteShortIntroduce;
import com.website.service.enterprise.WebsiteCompanyShortIntroService;

/**
 * 企业简介
 * @Auther: jcd
 * @Date: 2018/11/12 11:21
 * @Description:
 */
@Controller
@RequestMapping(value="/system/shortIntroduce")
public class ShortIntroduceController {
    @Autowired
    WebsiteCompanyShortIntroService websiteCompanyShortIntroService;

    /**
     * 查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(
            @ModelAttribute(BaseDefine.FORM) WebsiteShortIntroduce form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/shortIntroduce/short_introduce_list");
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
                                   @ModelAttribute(BaseDefine.FORM) WebsiteShortIntroduce form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteShortIntroduce form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));

        ServiceResult<List<WebsiteShortIntroduce>> result = this.websiteCompanyShortIntroService
                .findCompanyShortIntroList(form);

        if (result != null) {
            List<WebsiteShortIntroduce> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteShortIntroduce form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/shortIntroduce/short_introduce");

        if(form.getId() != null){
            ServiceResult<WebsiteShortIntroduce> result = this.websiteCompanyShortIntroService.getRecord(form);
            modelAndView.addObject("record", result.getResult());
        }
        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 插入简介
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("insertAction")
    public ServiceResult<WebsiteShortIntroduce> insertAction(HttpServletRequest request,
                                                          WebsiteShortIntroduce form) {
        ServiceResult<WebsiteShortIntroduce> result = new ServiceResult<WebsiteShortIntroduce>();

        result = this.websiteCompanyShortIntroService.insertRecord(form);
        return result;
    }

    /**
     * 更改
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("updateAction")
    public ServiceResult<WebsiteShortIntroduce> updateAction(HttpServletRequest request,
                                                                   WebsiteShortIntroduce form) {
        ServiceResult<WebsiteShortIntroduce> result = new ServiceResult<WebsiteShortIntroduce>();

        result = this.websiteCompanyShortIntroService.updateRecord(form);
        return result;
    }
    
    /**
     * 用户删除记录
     *
     * @return
     */
    @RequestMapping(value = "removeOrderAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> removeOrderAction(HttpServletRequest request, @RequestBody WebsiteShortIntroduce form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();

        Integer id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteShortIntroduce> recordResult = this.websiteCompanyShortIntroService.removeRecord(id);
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
    
}
