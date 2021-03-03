package com.website.admin.system.product;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteProduct;
import com.website.mybatis.bean.auto.WebsiteProductWithBLOBs;
import com.website.service.product.WebsiteProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="/system/product")
public class ProductServiceController {
    @Autowired
    WebsiteProductService websiteProductService;

    /**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(
            @ModelAttribute(BaseDefine.FORM) WebsiteProduct form) {
        ModelAndView modelAndView = new ModelAndView("system/product/product_list");
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
                                   @ModelAttribute(BaseDefine.FORM) WebsiteProduct form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteProduct form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));

        ServiceResult<List<WebsiteProductWithBLOBs>> result = this.websiteProductService
                .findProductList(form);

        if (result != null) {
            List<WebsiteProductWithBLOBs> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteProductWithBLOBs form) {
        ModelAndView modelAndView = new ModelAndView("system/product/product_info");

        if(StringUtils.isNotBlank(form.getId())){
            ServiceResult<WebsiteProductWithBLOBs> result = this.websiteProductService
                    .getRecord(form);
            modelAndView.addObject("record", result.getResult());
        }

        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 插入产品服务
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("insertAction")
    public ServiceResult<WebsiteProductWithBLOBs> insertAction(HttpServletRequest request,
                                                               WebsiteProductWithBLOBs form) {
        ServiceResult<WebsiteProductWithBLOBs> result = new ServiceResult<WebsiteProductWithBLOBs>();

        result = this.websiteProductService.insertRecord(form);
        return result;
    }

    /**
     * 更改产品服务
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("updateAction")
    public ServiceResult<WebsiteProductWithBLOBs> updateAction(HttpServletRequest request,
                                                               WebsiteProductWithBLOBs form) {
        ServiceResult<WebsiteProductWithBLOBs> result = new ServiceResult<WebsiteProductWithBLOBs>();

        result = this.websiteProductService.updateRecord(form);
        return result;
    }

}
