package com.website.web.system.social;

import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.cache.RedisUtils;
import com.website.mybatis.bean.auto.WebsiteConsult;
import com.website.mybatis.bean.auto.WebsiteDonationInstance;
import com.website.mybatis.bean.ext.ExtWebsiteDonationInstanceModel;
import com.website.service.enterprise.WebsiteDonationInstanceService;
import com.website.web.base.BaseController;
import com.website.web.base.BaseDefine;
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
 * @Date: 2018/6/21 13:48
 * @Description:
 */
@Controller
@RequestMapping(value="/system/social")
public class SocialController extends BaseController {
    @Autowired
    WebsiteDonationInstanceService websiteDonationInstanceService;
    /**
     * 初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(HttpServletRequest request, ExtWebsiteDonationInstanceModel form) {
        ModelAndView modelAndView = new ModelAndView("/socialResponsibility");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
        String flag = AreaUtil.getLanguageFlag(request);
        String cnEnFlag = "0";
        if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }
        form.setCnEnFlag(cnEnFlag);
        ServiceResult<List<ExtWebsiteDonationInstanceModel>> result = this.websiteDonationInstanceService
                .findCompanyNewsList(form);
        modelAndView.addObject("record",result.getResult());
        return modelAndView;
    }

    /**
     * 捐赠详情页(含有id更新，不含有id添加)
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("detail")
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteDonationInstance form) {
        ModelAndView modelAndView = new ModelAndView("/socialListInfo");
        String hostIp = this.getIpAddr(request);
        String flag = RedisUtils.get(hostIp);
        String cnEnFlag = "0";
        if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }
        WebsiteDonationInstance instance = new WebsiteDonationInstance();
        if(StringUtils.isNotBlank(form.getId())){
            ServiceResult<WebsiteDonationInstance> record = this.websiteDonationInstanceService
                    .getDonationRecord(form);
            //该条记录中英文
            String languageFlag = record.getResult().getCnEnFlag();
            if(StringUtils.equals("0",languageFlag)){
                if(StringUtils.equals("1",cnEnFlag)){
                    ServiceResult<WebsiteDonationInstance> result = this.websiteDonationInstanceService
                            .getEnDonationRecord(form);
                    instance = result.getResult();
                }else{
                    instance = record.getResult();
                }
            }else{
                if(StringUtils.equals("0",cnEnFlag)){
                   if(StringUtils.isNotEmpty(record.getResult().getCnid())) {
                       form.setId(record.getResult().getCnid());
                       ServiceResult<WebsiteDonationInstance> result = this.websiteDonationInstanceService
                               .getDonationRecord(form);
                       instance = result.getResult();
                   }
                }else{
                    instance = record.getResult();
                }
            }

            if(StringUtils.isNotBlank(instance.getDonationTime()) && instance.getDonationTime().length()>10){
                instance.setDonationTime(instance.getDonationTime().substring(0,10));
            }
        }

        modelAndView.addObject("record", instance);

        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 捐赠列表页
     *
     * @return
     */
    @RequestMapping("more")
    public ModelAndView more(HttpServletRequest request, ExtWebsiteDonationInstanceModel form) {
        ModelAndView modelAndView = new ModelAndView("/socialList");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
        String flag = AreaUtil.getLanguageFlag(request);
        String cnEnFlag = "0";
        /*if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }*/
        form.setCnEnFlag(cnEnFlag);
        ServiceResult<List<ExtWebsiteDonationInstanceModel>> result = this.websiteDonationInstanceService
                .findCompanyNewsList(form);
        for(ExtWebsiteDonationInstanceModel donation:result.getResult()){
            String showDay="";
            String showMonth="";
            String showYear="";
            if(StringUtils.isNotBlank(donation.getDonationTime())&&donation.getDonationTime().length()>10){
                showDay =donation.getDonationTime().substring(8,10);
                showMonth = donation.getDonationTime().substring(5,7);
                showYear = donation.getDonationTime().substring(0,4);
            }
            donation.setShowDay(showDay);
            donation.setShowMonth(showYear+'-'+showMonth);
        }
        modelAndView.addObject("record",result.getResult());
        modelAndView.addObject("count",result.getResult().size());
        return modelAndView;
    }
    /**
     * 分页查询
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("searchAction")
    public ServiceResult<JSONObject> searchAction(HttpServletRequest request, ExtWebsiteDonationInstanceModel form){
        
        ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
        String hostIp = this.getIpAddr(request);
        String flag = RedisUtils.get(hostIp);
        String cnEnFlag = "0";
        /*if(StringUtils.isNotBlank(flag)){
            cnEnFlag = flag;
        }*/
        form.setCnEnFlag(cnEnFlag);
//        int limitStart = form.getLimitStart();
//        int limitEnd = form.getLimitEnd();
        ServiceResult<List<ExtWebsiteDonationInstanceModel>> result = this.websiteDonationInstanceService
                .findCompanyNewsList(form);
        for(ExtWebsiteDonationInstanceModel donation:result.getResult()){
            String showDay="";
            String showMonth="";
            String showYear="";
            if(StringUtils.isNotBlank(donation.getDonationTime())&&donation.getDonationTime().length()>10){
                showDay =donation.getDonationTime().substring(8,10);
                showMonth = donation.getDonationTime().substring(5,7);
                showYear = donation.getDonationTime().substring(0,4);
            }
            donation.setShowDay(showDay);
            donation.setShowMonth(showYear+'-'+showMonth);
        }
        int total = this.websiteDonationInstanceService.count(form);
        JSONObject object = new JSONObject();
        object.put("websiteDonationInstancelist", result.getResult());
        object.put("total", total);
        res.setResult(object);
        res.setSuccess(result.getSuccess());
        res.setMessage(result.getMessage());
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
