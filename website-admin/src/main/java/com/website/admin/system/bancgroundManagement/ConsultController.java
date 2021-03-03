package com.website.admin.system.bancgroundManagement;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteConsult;
import com.website.service.consult.WebsiteConsultService;
/**
 * @Auther: jcd
 * @Date: 2018/12/4 14:48
 * @Description:
 */
@Controller
@RequestMapping(value="/system/backgroundManageMent/consultController")
public class ConsultController {
	@Autowired
	private WebsiteConsultService WebsiteConsultService;
	/**
     * 查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(@ModelAttribute(BaseDefine.FORM) WebsiteConsult form) {
        ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/consult/consult_list");
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
                                   @ModelAttribute(BaseDefine.FORM) WebsiteConsult form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteConsult form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));
        ServiceResult<List<WebsiteConsult>> result = this.WebsiteConsultService.findConsultList(form);

        if (result != null) {
            List<WebsiteConsult> recordList = result.getResult();
            PageInfo paginator = new PageInfo(recordList);// 默认8页数据
            object.put("rows", paginator.getList());
            object.put("total", paginator.getTotal());
        }
        return object;
    }
    
}
