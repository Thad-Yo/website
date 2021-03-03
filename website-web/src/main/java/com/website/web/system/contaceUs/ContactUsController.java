package com.website.web.system.contaceUs;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteFiliale;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.service.contactUs.WebsiteFeedbackService;
import com.website.service.pro.FilialeService;
import com.website.web.base.BaseController;
import com.website.web.base.BaseDefine;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.awt.geom.Area;
import java.util.*;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 13:48
 * @Description:
 */
@Controller
@RequestMapping(value="/system/contactUs")
public class ContactUsController extends BaseController {
    @Autowired
    private WebsiteFeedbackService websiteFeedbackService;
    @Autowired
    private FilialeService filialeService;
    /**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/contactUs");
        ServiceResult<List<WebsiteFiliale>> record = filialeService.getFilialeProList();
        modelAndView.addObject("recordList",record.getResult());
        return modelAndView;
    }

    /**
     * 发送建议
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("saveAction")
    public ServiceResult<JSONObject> saveAction(HttpServletRequest request, WebsiteFeedback form){
        String remoteAddr = request.getRemoteAddr();
        if(StringUtils.isNotBlank(remoteAddr)){
            form.setFeedbackIp(remoteAddr);
        }
        if(form.getContent()==null||form.getContent()==""||form.getContent().length()>1000){
        	ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
        	res.setSuccess(false);
            res.setMessage("请输入小于1000字符数的意见说明！");
            return res;
        }
        ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
        ServiceResult<WebsiteFeedback> recordResult = this.websiteFeedbackService.insertAdvice(form);
        res.setSuccess(recordResult.getSuccess());
        res.setMessage(recordResult.getMessage());
        return res;
    }

    /**
     * 获取满足条件的记录
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "getRecordAction")
    public ServiceResult<List<WebsiteFiliale>> editInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteFiliale form) {
        ServiceResult<List<WebsiteFiliale>> res = new ServiceResult<>();
        // 取得内容
        ServiceResult<List<WebsiteFiliale>> recordResult = this.filialeService.getRecordList(form);
        res.setSuccess(recordResult.getSuccess());
        res.setMessage(recordResult.getMessage());
        res.setResult(recordResult.getResult());
        return res;
    }
}
