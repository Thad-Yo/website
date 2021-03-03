package com.website.admin.system.contactUs;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.file.ExportExcel2;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.service.contactUs.WebsiteFeedbackService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 13:48
 * @Description:
 */
@Controller
@RequestMapping(value="/system/feedback")
public class FeedbackController {
    @Autowired
    private WebsiteFeedbackService websiteFeedbackService;
    /**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(@ModelAttribute(BaseDefine.FORM) WebsiteFeedback form) {
        ModelAndView modelAndView = new ModelAndView("system/contactUs/feedback/feedback_list");
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
                                   @ModelAttribute(BaseDefine.FORM) ExtWebsiteFeedbackModel form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, ExtWebsiteFeedbackModel form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));

        ServiceResult<List<ExtWebsiteFeedbackModel>> result = this.websiteFeedbackService
                .findFeedbackList(form);

        if (result != null) {
            List<ExtWebsiteFeedbackModel> recordList = result.getResult();
            PageInfo paginator = new PageInfo(recordList);// 默认8页数据
            object.put("rows", paginator.getList());
            object.put("total", paginator.getTotal());
        }

        return object;
    }

    /**
     * 导出功能
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "exportAction", method = RequestMethod.POST)
    public void exportAction(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExtWebsiteFeedbackModel form, String sheetName) throws Exception {
        ServiceResult<List<ExtWebsiteFeedbackModel>> result = this.websiteFeedbackService
                .findFeedbackList(form);
        this.exportExcelFile(request, response, result.getResult(), sheetName);
    }

    /**
     * 导出Excel文件
     *
     * @param request
     * @param response
     * @throws Exception
     */
    private void exportExcelFile(HttpServletRequest request, HttpServletResponse response, List<ExtWebsiteFeedbackModel> recordList, String sheetName) throws Exception {
        String fileName = "意见反馈_" + new Date().getTime() + ".xls";
        sheetName = StringUtils.isBlank(sheetName) ? "意见反馈" : sheetName;

        String[] titles;
        titles= new String[]{"反馈时间", "反馈IP地址", "姓名", "电话", "邮箱","反馈内容"};
        List<Map<String, String>> infoList = new ArrayList<>();
        if (recordList != null && recordList.size() > 0) {
            Map<String, String> map = null;
            int i = 0;
            for (ExtWebsiteFeedbackModel record : recordList) {
                map = new HashMap<>();
                map.put("反馈时间", record.getFeedbackTime());
                map.put("反馈IP地址", record.getFeedbackIp());
                map.put("姓名", record.getName());
                map.put("电话", record.getTel());
                map.put("邮箱", record.getMailbox());
                map.put("反馈内容", record.getContent());
                infoList.add(map);
            }
        }
        // 声明一个工作薄
        HSSFWorkbook workbook = ExportExcel2.createHSSFWorkbookInfo(titles, infoList, sheetName);
        // 导出
        ExportExcel2.writeExcelFile(request, response, workbook, fileName);
    }
}
