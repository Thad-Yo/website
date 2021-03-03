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
import com.website.service.culture.OurstaffTypeService;

/**
 * @Auther: jcd
 * @Date: 2018/12/5 10:30
 * @Description:
 */
@Controller
@RequestMapping(value="/system/ourstaffTypeController")
public class OurstaffTypeController {
	@Autowired
    private OurstaffTypeService ourstaffTypeService;
	/**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(@ModelAttribute(BaseDefine.FORM) WebsiteCultureType form) {
        ModelAndView modelAndView = new ModelAndView("system/culture/ourstaff/staff_type_list");
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
                                   @ModelAttribute(BaseDefine.FORM) WebsiteCultureType form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteCultureType form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));
        form.setCultureTypeCode(ConstantsUtil.CULTURE_STAFF);
        ServiceResult<List<WebsiteCultureType>> result = this.ourstaffTypeService.findOurStaffTypeList(form);

        if (result != null) {
            List<WebsiteCultureType> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteCultureType form) {
        ModelAndView modelAndView = new ModelAndView("system/culture/ourstaff/staff_type_info");
        System.out.println(form.getId());
        if(form.getId() != null){
        	if(StringUtils.isNotBlank(form.getId().toString())){
        		ServiceResult<WebsiteCultureType> result = this.ourstaffTypeService.getRecord(form);
        		modelAndView.addObject("record", result.getResult());
        	}
        }
        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }
    
    /**
     * 插入招聘岗位
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("insertAction")
    public ServiceResult<WebsiteCultureType> insertAction(HttpServletRequest request,
                                                             WebsiteCultureType form) {
        ServiceResult<WebsiteCultureType> result = new ServiceResult<>();
        form.setCultureTypeCode(ConstantsUtil.CULTURE_STAFF);
        result = this.ourstaffTypeService.insertRecord(form);
        return result;
    }

    /**
     * 更改招聘岗位
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("updateAction")
    public ServiceResult<WebsiteCultureType> updateAction(HttpServletRequest request,
                                                             WebsiteCultureType form) {
        ServiceResult<WebsiteCultureType> result = new ServiceResult<>();

        result = this.ourstaffTypeService.updateRecord(form);
        return result;
    }
    
    /**
     * 删除招聘岗位
     *
     * @return
     */
    @RequestMapping(value = "removeOrderAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> removeOrderAction(HttpServletRequest request, @RequestBody WebsiteCultureType form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();

        Integer id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteCultureType> recordResult = this.ourstaffTypeService.removeRecord(id);
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
