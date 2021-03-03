package com.website.web.system.enterprise;

import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.cache.RedisUtils;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel;
import com.website.service.AttachmentService;
import com.website.service.enterprise.WebsiteCompanyNewsService;
import com.website.service.enterprise.WebsiteDonationInstanceService;
import com.website.web.base.BaseController;
import com.website.web.base.BaseDefine;
import com.website.web.system.desktop.DesktopDefine;
import com.website.web.system.language.AreaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/6/12 09:31
 * @Description:
 */
@Controller
@RequestMapping(value="/system/companyDynamic")
public class CompanyDynamicController extends BaseController {
//    @Autowired
//    private HomePageService homePageService;
//    @Autowired
//    private AboutUsService aboutUsService;
    @Autowired
    WebsiteCompanyNewsService websiteCompanyNewsService;
    @Autowired
    WebsiteDonationInstanceService websiteDonationInstanceService;
    @Autowired
    AttachmentService attachmentService;
    /**
     * 初始化联信动态
     *
     * @param request
     * @return
     */
    @RequestMapping(DesktopDefine.INIT)
    public ModelAndView init(HttpServletRequest request,@ModelAttribute(BaseDefine.FORM) ExtWebsiteCompanyNewsModel form) {
        ModelAndView modelAndView = new ModelAndView("/companyDynamic");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
        String flag = AreaUtil.getLanguageFlag(request);
        String cnEnFlag = "0";
        if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }
        String type= "0";
        if(StringUtils.isNotBlank(form.getType())){
            type=form.getType();
        }
        form.setCnEnFlag(cnEnFlag);
        ServiceResult<List<ExtWebsiteCompanyNewsModel>> newsResult = this.websiteCompanyNewsService
                .findCompanyNewsList(form);//公司新闻
        for(ExtWebsiteCompanyNewsModel newsModel:newsResult.getResult()){
            String showDay="";
            String showMonth="";
            if(StringUtils.isNotBlank(newsModel.getPublishTime())&&newsModel.getPublishTime().length()>10){
                showDay =newsModel.getPublishTime().substring(8,10);
                showMonth = newsModel.getPublishTime().substring(5,7);
            }
            newsModel.setShowDay(showDay);
            newsModel.setShowMonth(showMonth);
        }
        modelAndView.addObject("type",type);
        modelAndView.addObject("newsRecord",newsResult.getResult());

        return modelAndView;
    }

    /**
     * 新闻详情页(含有id更新，不含有id添加)
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("detail")
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteCompanyNews form) {
        ModelAndView modelAndView = new ModelAndView("companyNews");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
        String flag = RedisUtils.get(hostIp);
        String cnEnFlag = "0";
        if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }
        WebsiteCompanyNews news = new WebsiteCompanyNews();
        if(StringUtils.isNotBlank(form.getId())){
            ServiceResult<WebsiteCompanyNews> record = this.websiteCompanyNewsService
                    .getNewsRecord(form);
            //该条记录中英文
            String languageFlag = record.getResult().getCnEnFlag();
            if(StringUtils.equals("0",languageFlag)){
                if(StringUtils.equals("1",cnEnFlag)){
                    ServiceResult<WebsiteCompanyNews> result = this.websiteCompanyNewsService
                            .getEnNewsRecord(form);
                    news = result.getResult();
                }else{
                    news = record.getResult();
                }
            }else{
                if(StringUtils.equals("0",cnEnFlag)){
                    if(StringUtils.isNotEmpty(record.getResult().getCnid())) {
                        form.setId(record.getResult().getCnid());
                        ServiceResult<WebsiteCompanyNews> result = this.websiteCompanyNewsService
                                .getNewsRecord(form);
                        news = result.getResult();
                    }
                }else{
                    news = record.getResult();
                }
            }
            if(StringUtils.isNotBlank(news.getPublishTime()) && news.getPublishTime().length()>10){
                news.setPublishTime(news.getPublishTime().substring(0,10));
            }
        }

        modelAndView.addObject("newsRecord", news);

        return modelAndView;
    }
    
    /**
     * 分页查询
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("searchAction")
    public ServiceResult<JSONObject> searchAction(HttpServletRequest request, ExtWebsiteCompanyNewsModel form){
        
        ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
        String hostIp = this.getIpAddr(request);
        String flag = AreaUtil.getLanguageFlag(request);
        String cnEnFlag = "0";
        if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }
        form.setCnEnFlag(cnEnFlag);
//        int limitStart = form.getLimitStart();
//        int limitEnd = form.getLimitEnd();
//        String type = form.getType();
        ServiceResult<List<ExtWebsiteCompanyNewsModel>> newsResult = this.websiteCompanyNewsService
                .findCompanyNewsList(form);//公司新闻
        for(ExtWebsiteCompanyNewsModel newsModel:newsResult.getResult()){
            String showDay="";
            String showMonth="";
            String showYear="";
            if(StringUtils.isNotBlank(newsModel.getPublishTime())&&newsModel.getPublishTime().length()>10){
                showDay =newsModel.getPublishTime().substring(8,10);
                showMonth = newsModel.getPublishTime().substring(5,7);
                showYear = newsModel.getPublishTime().substring(0,4);
            }
            newsModel.setShowDay(showDay);
            newsModel.setShowMonth(showYear+'-'+showMonth);
        }
        int total = this.websiteCompanyNewsService.count(form);
        JSONObject object = new JSONObject();
        object.put("newsList", newsResult.getResult());
        object.put("total", total);
        res.setResult(object);
        res.setSuccess(newsResult.getSuccess());
        res.setMessage(newsResult.getMessage());
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
    public ServiceResult<List<ExtWebsiteCompanyNewsModel>> getRecordAction(HttpServletRequest request,@ModelAttribute(BaseDefine.FORM) ExtWebsiteCompanyNewsModel form) {
        ServiceResult<List<ExtWebsiteCompanyNewsModel>> res = new ServiceResult<>();
//        String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
        String flag = RedisUtils.get(hostIp);
        String cnEnFlag = "0";
        if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }
        form.setCnEnFlag(cnEnFlag);
        ServiceResult<List<ExtWebsiteCompanyNewsModel>> newsResult = this.websiteCompanyNewsService
                .findCompanyNewsList(form);//公司新闻
        for(ExtWebsiteCompanyNewsModel newsModel:newsResult.getResult()){
            String showDay="";
            String showMonth="";
            String showYear="";
            if(StringUtils.isNotBlank(newsModel.getPublishTime())&&newsModel.getPublishTime().length()>10){
                showDay =newsModel.getPublishTime().substring(8,10);
                showMonth = newsModel.getPublishTime().substring(5,7);
                showYear = newsModel.getPublishTime().substring(0,4);
            }
            newsModel.setShowDay(showDay);
            newsModel.setShowMonth(showYear+'-'+showMonth);
        }
        res.setSuccess(newsResult.getSuccess());
        res.setMessage(newsResult.getMessage());
        res.setResult(newsResult.getResult());
        return res;
    }


    /*
     * 月份转换
     * param month
     * param flag
     * */
    public String getChangeMonth(String month,String flag){
        String enMonth="";
        if("0".equals(flag)){
        	enMonth=month+"月";
        }else{
            if("01".equals(month)){
                enMonth="Jan";
            }else if("02".equals(month)){
                enMonth="Feb";
            }else if("03".equals(month)){
                enMonth="Mar";
            }else if("04".equals(month)){
                enMonth="Apr";
            }else if("05".equals(month)){
                enMonth="May";
            }else if("06".equals(month)){
                enMonth="Jun";
            }else if("07".equals(month)){
                enMonth="Jul";
            }else if("08".equals(month)){
                enMonth="Aug";
            }else if("09".equals(month)){
                enMonth="Sept";
            }else if("10".equals(month)){
                enMonth="Oct";
            }else if("11".equals(month)){
                enMonth="Nov";
            }else if("12".equals(month)){
                enMonth="Dec";
            }
        }
        return enMonth;
    }

}
