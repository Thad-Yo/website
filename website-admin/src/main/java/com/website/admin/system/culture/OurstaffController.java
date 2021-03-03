package com.website.admin.system.culture;

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
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.WebsiteCultureType;
import com.website.mybatis.bean.auto.WebsiteOurStaff;
import com.website.service.culture.OurstaffTypeService;
import com.website.service.culture.WebsiteOurStaffService;

/**
 * @Auther: jcd
 * @Date: 2018/12/4 14:48
 * @Description:
 */
@Controller
@RequestMapping(value="/system/ourstaffController")
public class OurstaffController {
	@Autowired
	private WebsiteOurStaffService websiteOurStaffService;
	@Autowired
    private OurstaffTypeService ourstaffTypeService;
	/**
     * 查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(@ModelAttribute(BaseDefine.FORM) WebsiteOurStaff form) {
        ModelAndView modelAndView = new ModelAndView("system/culture/ourstaff/ourstaff_list");
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
                                   @ModelAttribute(BaseDefine.FORM) WebsiteOurStaff form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteOurStaff form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));
        form.setTypeCode(ConstantsUtil.CULTURE_STAFF);
        ServiceResult<List<WebsiteOurStaff>> result = this.websiteOurStaffService.findOurStaffList(form);

        if (result != null) {
            List<WebsiteOurStaff> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteOurStaff form) {
        ModelAndView modelAndView = new ModelAndView("system/culture/ourstaff/ourstaff_info");

        if(StringUtils.isNotBlank(form.getId())){
            ServiceResult<WebsiteOurStaff> result = this.websiteOurStaffService.getStaffRecord(form);
            modelAndView.addObject("record", result.getResult());
        }
        WebsiteCultureType type = new WebsiteCultureType();
        type.setCultureTypeCode(ConstantsUtil.CULTURE_STAFF);
        List<WebsiteCultureType> typeList = ourstaffTypeService.findOurStaffTypeList(type).getResult();
        modelAndView.addObject(BaseDefine.FORM, form);
        modelAndView.addObject("typeList", typeList);
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
    public ServiceResult<WebsiteOurStaff> insertAction(HttpServletRequest request,
                                                          WebsiteOurStaff form) {
        ServiceResult<WebsiteOurStaff> result = new ServiceResult<WebsiteOurStaff>();
        form.setTypeCode(ConstantsUtil.CULTURE_STAFF);
        result = this.websiteOurStaffService.insertRecord(form);
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
    public ServiceResult<WebsiteOurStaff> updateAction(HttpServletRequest request,
                                                                   WebsiteOurStaff form) {
        ServiceResult<WebsiteOurStaff> result = new ServiceResult<WebsiteOurStaff>();

        result = this.websiteOurStaffService.updateRecord(form);
        return result;
    }
    
    /**
     * 用户删除记录
     *
     * @return
     */
    @RequestMapping(value = "removeOrderAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> removeOrderAction(HttpServletRequest request, @RequestBody WebsiteOurStaff form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();

        String id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteOurStaff> recordResult = this.websiteOurStaffService.removeRecord(id);
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
