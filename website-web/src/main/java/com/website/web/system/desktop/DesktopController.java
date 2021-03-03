package com.website.web.system.desktop;

import com.google.common.collect.Lists;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.cache.RedisUtils;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.*;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.ext.*;
import com.website.mybatis.bean.ext.system.ExtAttachment;
import com.website.mybatis.bean.ext.system.ExtMenuModel;
import com.website.mybatis.mapper.auto.WebsiteProductMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteBasicMapper;
import com.website.service.AttachmentService;
import com.website.service.aboutUs.WebsiteIntroduceService;
import com.website.service.enterprise.WebsiteCompanyNewsService;
import com.website.service.enterprise.WebsiteCompanyShortIntroService;
import com.website.service.enterprise.WebsiteDonationInstanceService;
import com.website.service.pro.AboutUsService;
import com.website.service.pro.HomePageService;
import com.website.service.product.WebsiteProductService;
import com.website.web.base.BaseController;

import com.website.web.system.language.AreaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: hzm
 * @Date: 2018/6/12 09:31
 * @Description:
 */
@Controller(value = DesktopDefine.CONTROLLOR_VALUE)
@RequestMapping(value = DesktopDefine.CONTROLLOR_REQUEST_MAPPING)
public class DesktopController extends BaseController {
    @Autowired
    private HomePageService homePageService;
    @Autowired
    private AboutUsService aboutUsService;
    @Autowired
    WebsiteCompanyNewsService websiteCompanyNewsService;
    @Autowired
    WebsiteDonationInstanceService websiteDonationInstanceService;
    @Autowired
    AttachmentService attachmentService;
    @Autowired
    WebsiteIntroduceService websiteIntroduceService;
    @Autowired
    WebsiteProductService websiteProductService;
    @Autowired
    ExtWebsiteBasicMapper extWebsiteBasicMapper;
    @Autowired
    WebsiteProductMapper websiteProductMapper;
    @Autowired
    HomePageService websiteBasicService;
    @Autowired
    WebsiteCompanyShortIntroService websiteCompanyShortIntroService;

    /**
     * 首页初始化
     *
     * @param request
     * @return
     */
    @RequestMapping(DesktopDefine.INIT)
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/index");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
        String flag = AreaUtil.getLanguageFlag(request);
        String cnEnFlag = "0";
        if (StringUtils.isNotBlank(flag)) {
            cnEnFlag = flag;
        }
        ExtWebsiteCompanyNewsModel companyNewsModel = new ExtWebsiteCompanyNewsModel();//新闻
        WebsiteProduct websiteProduct = new WebsiteProduct();//
        ExtWebsiteConfigBannerModel bannerModel = new ExtWebsiteConfigBannerModel();
        bannerModel.setIssue("1");
        ServiceResult<List<ExtWebsiteConfigBannerModel>> result = homePageService.getRecordList(bannerModel);//轮播图
        for (ExtWebsiteConfigBannerModel banner : result.getResult()) {
            if ("1".equals(banner.getImageLink())) {
                if ("".equals(banner.getLinkShare()) || banner.getLinkShare() == null) {
                    banner.setAddress("javascript:;");
                } else {
                    banner.setAddress("https://" + banner.getLinkShare());
                }

            } else if ("2".equals(banner.getImageLink())) {
                //区分中英文 标志位  缺少
                if ("0".equals(cnEnFlag)) {
                    if ("".equals(banner.getLinkChinese()) || banner.getLinkChinese() == null) {
                        banner.setAddress("javascript:;");
                    } else {
                        banner.setAddress("https://" + banner.getLinkChinese());
                    }
                } else if ("1".equals(cnEnFlag)) {
                    if ("".equals(banner.getLinkEnglish()) || banner.getLinkEnglish() == null) {
                        banner.setAddress("javascript:;");
                    } else {
                        banner.setAddress("https://" + banner.getLinkEnglish());
                    }
                }
            } else {
                banner.setAddress("javascript:;");
            }
        }

        companyNewsModel.setCnEnFlag(cnEnFlag);
        companyNewsModel.setIsTop("0");
        ServiceResult<List<ExtWebsiteCompanyNewsModel>> newsResult = this.websiteCompanyNewsService
                .findCompanyNewsList(companyNewsModel);//公司新闻
        for (ExtWebsiteCompanyNewsModel newsModel : newsResult.getResult()) {
            String showDay = "";
            String showMonth = "";
            String showYear = "";
            if(StringUtils.isNotBlank(newsModel.getPublishTime())&&newsModel.getPublishTime().length()>10){
                showDay =newsModel.getPublishTime().substring(8,10);
                showMonth = newsModel.getPublishTime().substring(5,7);
                showYear = newsModel.getPublishTime().substring(0,4);
            }
            newsModel.setShowDay(showDay);
            newsModel.setShowMonth(showYear+'-'+showMonth);
        }
        ExtAttachment ctattachment = new ExtAttachment();
        ctattachment.setFileId("partnersfile");
        ctattachment.setSort("id");
        ctattachment.setOrder("desc");
        List<CTAttachment> attachmentlist = attachmentService.getRecordList(ctattachment).getResult();

        int attSize = attachmentlist.size() / 2;
        int battSize = attachmentlist.size() % 2;
        if (battSize > 0) {
            attSize = attSize + 1;
        }
        List attList = new ArrayList();
        for (int i = 0; i < attSize; i++) {
            ExtCTAttachment ct = new ExtCTAttachment();
            List<CTAttachment> list = new ArrayList<>();
            for (int j = 0; j < attachmentlist.size(); j++) {
                if (i * 2 <= j && j < (i + 1) * 2) {
                    list.add(attachmentlist.get(j));
                }
            }
            ct.setCtAttachmentList(list);
            attList.add(ct);
        }

        WebsiteBasicWithBLOBs websiteBasic = homePageService.select("1");
        if ("2".equals(websiteBasic.getChecked())) {
            //区分中英文 标志位
            if ("0".equals(cnEnFlag)) {
                websiteBasic.setVideoShareAdress(websiteBasic.getVideoChineseAdress());
            } else {
                websiteBasic.setVideoShareAdress(websiteBasic.getVideoEnglishAdress());
            }
        }

        websiteProduct.setCnEnFlag(cnEnFlag);
        ServiceResult<List<WebsiteProductWithBLOBs>> websiteProductWithBLOBs = this.websiteProductService.findProductList(websiteProduct);
        List<ExtWebsiteProductWithBLOBs> websiteProductList = new ArrayList<ExtWebsiteProductWithBLOBs>();
        for (int i = 0; i < websiteProductWithBLOBs.getResult().size(); i++) {
            ExtWebsiteProductWithBLOBs wp = new ExtWebsiteProductWithBLOBs();
            wp.setTitle(websiteProductWithBLOBs.getResult().get(i).getTitle());
            wp.setContent(websiteProductWithBLOBs.getResult().get(i).getContent());
            wp.setSummary(websiteProductWithBLOBs.getResult().get(i).getSummary());
            wp.setProductType(websiteProductWithBLOBs.getResult().get(i).getProductType());
            int a = Integer.parseInt(websiteProductWithBLOBs.getResult().get(i).getProductType()) + 2;
            wp.setAddress("/images/index/3-" + a + ".png");
            websiteProductList.add(wp);
        }

        if (!"0".equals(cnEnFlag)) {
            websiteBasic.setIntroduce(websiteBasic.getIntroduceEng());
        }
        WebsiteShortIntroduce shortIntroduce = new WebsiteShortIntroduce();
        List<WebsiteShortIntroduce> shortIntroduceResult = this.websiteCompanyShortIntroService.findCompanyShortIntroList(shortIntroduce).getResult();
        String[] aboutUsHref = {
                        "/system/companyCulture/init",
                        "/system/companyIntroduce/init",
                        "/system/companyCulture/init#1",
                        "/system/companyCulture/init#2"};
        ArrayList<ExtWebsiteCompanyCultureModel> aboutUsList = Lists.newArrayList();
        for (WebsiteShortIntroduce shortIntroduce1 : shortIntroduceResult) {
            ExtWebsiteCompanyCultureModel aboutUs = new ExtWebsiteCompanyCultureModel();
            aboutUs.setHref(aboutUsHref[shortIntroduce1.getId() - 1]);
            aboutUs.setTitleCN(shortIntroduce1.getTitleCn());
            aboutUs.setTitleEN(shortIntroduce1.getTitleEn());
            aboutUs.setText("0".equals(cnEnFlag) ? shortIntroduce1.getIntroduceCn() : shortIntroduce1.getIntroduceEn());
            aboutUs.setSrc("0".equals(cnEnFlag) ? shortIntroduce1.getImgUrlCn() : shortIntroduce1.getImgUrlEn());
            aboutUsList.add(aboutUs);
        }
        modelAndView.addObject("cnEnFlag", cnEnFlag);
        modelAndView.addObject("aboutUsList", aboutUsList);
        modelAndView.addObject("websiteProductList", websiteProductList);
        modelAndView.addObject("websiteBasic", websiteBasic);
        modelAndView.addObject("configBanner", result.getResult());
        modelAndView.addObject("newsRecord", newsResult.getResult());
        //modelAndView.addObject("donationRecord",donationResult.getResult());
        modelAndView.addObject("attachmentRecord", attList);
        return modelAndView;
    }

    /*
     * 月份转换
     * param month
     * param flag
     * */
    public String getChangeMonth(String month, String flag) {
        String enMonth = "";
        if ("0".equals(flag)) {
            enMonth = month + "月";
        } else {
            if ("01".equals(month)) {
                enMonth = "Jan";
            } else if ("02".equals(month)) {
                enMonth = "Feb";
            } else if ("03".equals(month)) {
                enMonth = "Mar";
            } else if ("04".equals(month)) {
                enMonth = "Apr";
            } else if ("05".equals(month)) {
                enMonth = "May";
            } else if ("06".equals(month)) {
                enMonth = "Jun";
            } else if ("07".equals(month)) {
                enMonth = "Jul";
            } else if ("08".equals(month)) {
                enMonth = "Aug";
            } else if ("09".equals(month)) {
                enMonth = "Sept";
            } else if ("10".equals(month)) {
                enMonth = "Oct";
            } else if ("11".equals(month)) {
                enMonth = "Nov";
            } else if ("12".equals(month)) {
                enMonth = "Dec";
            }
        }
        return enMonth;
    }

}
