package com.website.web.system.productService;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.cache.RedisUtils;
import com.website.mybatis.bean.auto.WebsiteCommunity;
import com.website.mybatis.bean.auto.WebsiteConsult;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyCultureModel;
import com.website.service.enterprise.WebsiteDonationInstanceService;
import com.website.service.product.WebsiteProductService;
import com.website.web.base.BaseController;
import com.website.web.system.language.AreaUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 13:48
 * @Description:
 */
@Controller
@RequestMapping(value = "/system/produce")
public class ProduceController extends BaseController {
    @Autowired
    WebsiteDonationInstanceService websiteDonationInstanceService;
    @Autowired
    WebsiteProductService websiteProductService;

    /**
     * 产品
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/services");
        //String hostIp = request.getRemoteHost();
        String hostIp = this.getIpAddr(request);
        String flag = AreaUtil.getLanguageFlag(request);

        String cnEnFlag = "0";
        if (StringUtils.isNotBlank(flag)) {
            cnEnFlag = flag;
        }

        String[] categoriesTitle = {
                "汽车金融公司",
                "保险公司",
                "银行",
                "互联网金融",
                "其他金融公司"},
                categoriesTitleEN = {
                        "Automobile Financial Companies",
                        "Insurance Companies",
                        "Banking",
                        "Internet Financial Companies",
                        "Other Financial Companies"};
        ArrayList<ExtWebsiteCompanyCultureModel> categoriesList = Lists.newArrayList();
        for (int i = 0; i < categoriesTitle.length; i++) {
            ExtWebsiteCompanyCultureModel category = new ExtWebsiteCompanyCultureModel();
            category.setSrc("");
            category.setTitleCN(categoriesTitle[i]);
            category.setTitleEN(categoriesTitleEN[i]);
            categoriesList.add(category);
        }
        modelAndView.addObject("categoriesList", categoriesList);

        String[] advantageTitle = {
                "覆盖全国的服务网络",
                "及时高效的对接服务",
                "拥有较高职业素养的员工",
                "灵活高效的业务模式",
                "持续的自主创新能力",
                "严格的信息安全管控",
                "强大的技术和AI团队",
                "先进的业务管理系统"},
                advantageText = {
                        "提供专业化、本地化的催收服务。",
                        "我们为每一个客户提供专属的对接人员，以确保公司服务品质和客户体验。",
                        "在公司不断推行专业化、职业化的道路上，注重员工培训及个人发展。",
                        "立足于市场需求进行服务升级和延伸，提供多元化、标准化、优质化的服务。",
                        "针对不同的业务项目需求，我司自主研发了业务系统和APP并不断对其进行优化升级。",
                        "通过了SGS认证的ISO27001信息安全管理体系和安永会计师事务所审计。",
                        "独立的数据研发中心，不断引进高端技术人才，坚持科技引领，联信腾飞。",
                        "全流程线上操作，可实现万人同时作业，同时运用机器学习模型在线助推业务人员高效作业。"},
                advantageTitleEN = {
                        "A Nationwide Service Network ",
                        "Timely and Efficient Client Service",
                        "High Professionalism of Staff",
                        "Flexible and Efficient Business Model",
                        "Ongoing Capacity for Independent Innovation",
                        "Strict Control of Information Security",
                        "Powerful Technical and AI Team",
                        "Advanced Business Management System"},
                advantageTextEN = {
                        "We provide professional and localized domestic debt collection services. ",
                        "We provide exclusive service for each client to ensure service quality and customer experience.",
                        "On the way of professionalism and specialization, we pay attention to staff training and personal career development.",
                        "Based on market demand for service upgrading and extension, we provide diverse, standardized and high-quality services.",
                        "According to different project needs, we independently developed the business system and APP, and constantly optimized and upgraded them. ",
                        "We have passed the certification of ISO 27001 Information Security Management Systems and auditing by Ernst & Young.",
                        "We have independent data R&D center and continuous introduction of high tech talents, to ensure that our company is boosted by technology.",
                        "Full process of online operation enables the simultaneous work of a large number of people. At the same time, online machine learning model is used to promote the efficient operation of employees."};
        ArrayList<ExtWebsiteCompanyCultureModel> advantagesList = Lists.newArrayList();
        for (int i = 0; i < advantageTitle.length; i++) {
            ExtWebsiteCompanyCultureModel advantage = new ExtWebsiteCompanyCultureModel();
            advantage.setSrc("");
            advantage.setTitle("0".equals(cnEnFlag) ? advantageTitle[i] : advantageTitleEN[i]);
            advantage.setText("0".equals(cnEnFlag) ? advantageText[i] : advantageTextEN[i]);
            advantagesList.add(advantage);
        }
        modelAndView.addObject("advantagesList", advantagesList);


        String[] internationalAdvantageTitle = {
                "<span>20余年</span>潜心笃志",
                "<span>1对1</span>定制方案",
                "<span>7大</span>支持中心",
                "<span>98%</span>的全球覆盖率",},
                internationalAdvantageText = {
                        "积累多行业经验，快速洞察行业特点",
                        "根据您的业务需求，制定适合您的专属方案",
                        "整合多渠道资源，全方位支持催收业务",
                        "为您提供专业、高效、本地化的催收和法律服务",},
                internationalAdvantageTitleEN = {   
                        "<span>20+ Years’Experience</span> Focusing on Debt Collection",
                        "<span>1-to-1</span> Customized Debt Solution ",
                        "<span>7</span> Supporting Centers",
                        "<span>98%</span> Global Coverage",},
                internationalAdvantageTextEN = {
                        "Rich multi-industry experience and quick insight into industry characteristics.",
                        "Tailor your solution to your business needs.",
                        "Integrate multi-channel resources, provide full support to debt collection.",
                        "Bring you the most professional, efficient, localized collection and legal services.",};
        ArrayList<ExtWebsiteCompanyCultureModel> internationalAdvantageList = Lists.newArrayList();
        for (int i = 0; i < internationalAdvantageTitle.length; i++) {
            ExtWebsiteCompanyCultureModel internationalAdvantage = new ExtWebsiteCompanyCultureModel();
            internationalAdvantage.setSrc("/images/services/international-advantages-" + (i + 1) + (i == 0 ? ".jpg" : ".png"));
            internationalAdvantage.setTitle("0".equals(cnEnFlag) ? internationalAdvantageTitle[i] : internationalAdvantageTitleEN[i]);
            internationalAdvantage.setText("0".equals(cnEnFlag) ? internationalAdvantageText[i] : internationalAdvantageTextEN[i]);
            internationalAdvantageList.add(internationalAdvantage);
        }
        modelAndView.addObject("internationalAdvantagesList", internationalAdvantageList);


        String reportContent = "0".equals(cnEnFlag) ?
                "<span>企业信用调查报告</span>是在深入探究公司的经营发展状况和财务成果基础之上，结合股东及领导人的背景，对企业进行信用评级，使您准确掌握竞争对手、合作伙伴、目标客户的信息情报，提前制定应对措施，主动调整合作方式，确保您在赚取最大利润的同时，尽可能地规避风险。"
                : "<span>Business Credit Reports</span>, based on thorough investigations on Subject Company's operation, financial status, background of shareholders and management, stating credit rating, provide accurate information on competitors, cooperative partners or clients, to help you making plans ahead or adjusting cooperation mode, avoiding risks while maximizing profits. ";
        String chineseReportTitle = "0".equals(cnEnFlag) ?
                "国内企业征信报告"
                : "Chinese Business Credit Reports";
        String internationalReportTitle = "0".equals(cnEnFlag) ?
                "国外企业征信报告"
                : "Overseas Business Credit Reports";
        String[] reportTitles = {
                "基本信息报告",
                "商业信息报告",
                "信用分析报告",
                "提供全球220个国家的企业征信报告服务"},
                reportTitlesEN = {
                        "Basic Information Reports",
                        "Business Information Reports",
                        "Credit Risk Analysis Reports",
                        "Credit Services cover 220 Countries"};
        String[][] reports = {{"企业注册信息","股东信息","管理层信息"},
                {"企业注册信息","股东信息","管理层信息","经营信息","财务信息","法律诉讼"},
                {"企业注册信息","股东信息","管理层信息","经营信息","财务信息","法律诉讼","行业分析","财务分析"},
                {"企业注册信息","股东信息","管理层信息","经营信息","财务信息","法律诉讼"}},
                reportsEN = {{"Business Registration Information","Shareholders","Management"},
                        {"Business Registration Information","Shareholders","Management","Business Activities","Financial Information","Litigation"},
                        {"Business Registration Information","Shareholders","Management","Business Activities","Financial Information","Litigation","Industry Analysis","Financial Analysis"},
                        {"Business Registration Information","Shareholders","Management","Business Activities","Financial Information","Litigation"}};
        ArrayList<ExtWebsiteCompanyCultureModel> reportList = Lists.newArrayList();
        for (int i = 0; i < reportTitles.length; i++) {
            ExtWebsiteCompanyCultureModel report = new ExtWebsiteCompanyCultureModel();
            String title = i!=3?"0"+(i+1)+"/":"";
            report.setText(title+("0".equals(cnEnFlag) ? reportTitles[i] : reportTitlesEN[i]));
            for (int j = 0; j < reports[i].length; j++) {
                ExtWebsiteCompanyCultureModel temp = new ExtWebsiteCompanyCultureModel();
                temp.setText("0".equals(cnEnFlag) ? reports[i][j] : reportsEN[i][j]);
                report.addChild(temp);
            }
            reportList.add(report);
        }
        modelAndView.addObject("reportContent", reportContent);
        modelAndView.addObject("chineseReportTitle", chineseReportTitle);
        modelAndView.addObject("internationalReportTitle", internationalReportTitle);
        modelAndView.addObject("reportList", reportList);

        ExtWebsiteCompanyCultureModel authenticationContent = new ExtWebsiteCompanyCultureModel();
        authenticationContent.setSrc("/images/services/authentication.png");
        authenticationContent.setText("0".equals(cnEnFlag) ?
                "<p style='text-indent: 2rem;'>通过企业工商信息核实、企业法人信息核实、电话核实、欺诈核实、资料核实等多种有效手段帮助客户识别合作方的信用风险。</p><p style='text-indent: 2rem;'>成功案例：阿里巴巴集团1688平台商户认证，有效的校验企业是否存在入驻平台的资质，帮助平台清退不良商户。</p>"
                : "<p style='text-indent: inherit; text-align:left;margin-bottom: 10px;'>Verifying registered information from the Ministry of Industry and Commerce to inspect the qualification of SMEs, verifying information of legal representative, and telephone interviewing employees to inspect fraudulent conducts. To inspect and analyze gathered information, audit enterprises’ qualification.</p><p style='text-indent: inherit; text-align:left;'>Stressful case: Authentication service for 1688.net platform of Alibaba Group. To inspect and analyze gathered information, audit enterprises’ qualification, and help Alibaba to eliminate unqualified enterprises.</p>");
        modelAndView.addObject("authenticationContent", authenticationContent);

        ExtWebsiteCompanyCultureModel systemContent = new ExtWebsiteCompanyCultureModel();
        systemContent.setSrc("/images/services/system.png");
        systemContent.setText("0".equals(cnEnFlag) ?
                "<div style='text-indent: 2rem;'><p>提供查询国内企业基本信息，可在线选择报告样本，下订单。</p><p>提供国内企业动态监控，可根据需求选择监控周期，监控内容包含基本信息变更、异常名录、裁判文书、法院公告、失信被执行、新增商标及专利。</p></div>"
                : "<div style='text-indent: inherit; text-align:left;'><p style='margin-bottom: 10px;'>Our Information System provides registration information of Chinese enterprises. You can download online reports and also order online.</p><p style='margin-bottom: 10px;'>Monitoring service of Chinese enterprises provides periodic notifications of changes on registered information, irregular operation, judgment documents, court announcements, promise-breaking behaviors, enforcement information, trademarks and patents.</p><p>Monitoring period can be chosen on demand.</p></div>");
        systemContent.setHref("http://www.intercreditbc.com/homepage/home");
        modelAndView.addObject("systemContent", systemContent);

        String diligenceContent = "0".equals(cnEnFlag) ?
                "我司在帮助客户核实目标公司的信息并进行专业化分析方面拥有近20年的行业经验，依托全国各省、地区的网点分布，遍布全球的合作伙伴，自主研发的应用程序以及专业的在线审核团队，可以及时有效的完成现场取证、实地征信、贷前和贷后调查的业务，为客户提供更专业、更有效的信息，帮助客户做出准确地决策，降低信用风险。"
                : "Over 20 years’experiences on helping clients to verify business information and providing professional analysis. With branches all over China and global partners, as well as self-developed APP and professional online auditing teams, we provide prompt and efficient on-site documentation collection, pre-loan and post-loan investigations, supplying professional and updated information, thus to assist our clients making decisions and reducing credit risks.";
        modelAndView.addObject("diligenceContent", diligenceContent);

        String[] categoryTitles = {
                "国内外银行",
                "非银行金融机构",
                "国内外企业服务平台",
                "进出口贸易平台",
                "企业"},
                categoryTitlesEN = {
                        "Banks",
                        "Non-bank Financial Institutions",
                        "Business Service Platform",
                        "Trading Platform",
                        "Enterprises"};
        modelAndView.addObject("categoryList", "0".equals(cnEnFlag) ? categoryTitles : categoryTitlesEN);

        String[] advantageTitles = {
                "高质",
                "高效",
                "专业",
                "严谨",
                "可靠",
                "安全",
                "职业道德",
                "全面",
                "灵活"},
                advantageTitlesEN = {
                        "High-quality",
                        "High-efficiency",
                        "Profession",
                        "Preciseness",
                        "Reliable",
                        "Security",
                        "High Professional Morality",
                        "Comprehensive",
                        "Flexibility"};
        ArrayList<ExtWebsiteCompanyCultureModel> advantageList = Lists.newArrayList();
        for (int i = 0; i < advantageTitles.length; i++) {
            ExtWebsiteCompanyCultureModel advantage = new ExtWebsiteCompanyCultureModel();
            advantage.setTitleCN(advantageTitles[i]);
            advantage.setTitleEN(advantageTitlesEN[i]);
            advantageList.add(advantage);
        }
        modelAndView.addObject("advantageList", advantageList);
        return modelAndView;
    }

    /**
     * 发送咨询
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("saveAction")
    public ServiceResult<JSONObject> saveAction(HttpServletRequest request, WebsiteConsult form) {
        String remoteAddr = request.getRemoteAddr();
        if (StringUtils.isNotBlank(remoteAddr)) {
            form.setConsultIp(remoteAddr);
        }
        ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
        ServiceResult<WebsiteConsult> recordResult = this.websiteProductService.insertConsult(form);
        res.setSuccess(recordResult.getSuccess());
        res.setMessage(recordResult.getMessage());
        return res;
    }

}
