package com.website.admin.system.enterprise;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteDonationInstance;
import com.website.mybatis.bean.ext.ExtWebsiteDonationInstanceModel;
import com.website.service.enterprise.WebsiteDonationInstanceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:21
 * @Description:
 */
@Controller
@RequestMapping(value="/system/donation")
public class DonationController {
    @Autowired
    WebsiteDonationInstanceService websiteDonationInstanceService;

    /**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(
            @ModelAttribute(BaseDefine.FORM) WebsiteDonationInstance form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/donation/donationInstance_list");
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
                                   @ModelAttribute(BaseDefine.FORM) ExtWebsiteDonationInstanceModel form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, ExtWebsiteDonationInstanceModel form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));

        ServiceResult<List<ExtWebsiteDonationInstanceModel>> result = this.websiteDonationInstanceService
                .findCompanyNewsList(form);

        if (result != null) {
            List<ExtWebsiteDonationInstanceModel> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteDonationInstance form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/donation/donationInstance_info");

        if(StringUtils.isNotBlank(form.getId())){
            ServiceResult<WebsiteDonationInstance> result = this.websiteDonationInstanceService
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
    public ServiceResult<WebsiteDonationInstance> insertAction(HttpServletRequest request,
                                                          WebsiteDonationInstance form) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<WebsiteDonationInstance>();

        result = this.websiteDonationInstanceService.insertRecord(form);
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
    public ServiceResult<WebsiteDonationInstance> updateAction(HttpServletRequest request,
                                                               WebsiteDonationInstance form) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<WebsiteDonationInstance>();

        result = this.websiteDonationInstanceService.updateRecord(form);
        return result;
    }
    /**
     * 用户删除新闻记录
     *
     * @return
     */
    @RequestMapping(value = "removeOrderAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> removeOrderAction(HttpServletRequest request, @RequestBody WebsiteDonationInstance form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();

        String id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteDonationInstance> recordResult = this.websiteDonationInstanceService.removeRecord(id);
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
     * 预览详情页
     */
    @RequestMapping("detail")
    public ModelAndView detailInfo(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteDonationInstance form) {
        ModelAndView modelAndView = new ModelAndView("system/enterprise/donation/foreview_info");
        //编辑
        if(StringUtils.isNotBlank(form.getId())){
        	 ServiceResult<WebsiteDonationInstance> result = this.websiteDonationInstanceService
                     .getRecord(form);
        	 modelAndView.addObject("record", result.getResult());
        }else{
        	//新增
        	modelAndView.addObject("record", form);
        }
        return modelAndView;
    }
}
