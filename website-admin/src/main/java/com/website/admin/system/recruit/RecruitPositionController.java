package com.website.admin.system.recruit;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.common.util.validator.KeyValueBean;
import com.website.mybatis.bean.auto.WebsiteConfigPosition;
import com.website.mybatis.bean.auto.WebsiteRecruitPosition;
import com.website.service.maintenance.DepartmentService;
import com.website.service.recruit.WebsiteRecruitPositionService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: gq
 * @Date: 2018/5/29 11:21
 * @Description:
 */
@Controller
@RequestMapping(value="/system/recruitPosition")
public class RecruitPositionController {
    
    @Autowired
    WebsiteRecruitPositionService websiteRecruitPositionService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(@ModelAttribute(BaseDefine.FORM) WebsiteRecruitPosition form) {
        ModelAndView modelAndView = new ModelAndView("system/recruit/recruitPosition/recruitPosition_list");
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
                                   @ModelAttribute(BaseDefine.FORM) WebsiteRecruitPosition form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteRecruitPosition form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));

        ServiceResult<List<WebsiteRecruitPosition>> result = this.websiteRecruitPositionService.findRecruitPositionList(form);

        if (result != null) {
            List<WebsiteRecruitPosition> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteRecruitPosition form) {
        ModelAndView modelAndView = new ModelAndView("system/recruit/recruitPosition/recruitPosition_info");
        System.out.println(form.getId());
        if(form.getId() != null){
        	if(StringUtils.isNotBlank(form.getId().toString())){
        		ServiceResult<WebsiteRecruitPosition> result = this.websiteRecruitPositionService.getRecord(form);
        		modelAndView.addObject("record", result.getResult());
        	}
        }
        ServiceResult<List<WebsiteConfigPosition>> positionTypeRes = this.websiteRecruitPositionService.getPositionTypeList();
        modelAndView.addObject("positionTypeList", positionTypeRes.getResult());
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
    public ServiceResult<WebsiteRecruitPosition> insertAction(HttpServletRequest request,
                                                             WebsiteRecruitPosition form) {
        ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        form.setStatus("n");
        result = this.websiteRecruitPositionService.insertRecord(form);
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
    public ServiceResult<WebsiteRecruitPosition> updateAction(HttpServletRequest request,
                                                             WebsiteRecruitPosition form) {
        ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();

        result = this.websiteRecruitPositionService.updateRecord(form);
        return result;
    }
    
    /**
     * 详情页招聘岗位发布
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("publishAction")
    public ServiceResult<WebsiteRecruitPosition> publishAction(HttpServletRequest request,
                                                             WebsiteRecruitPosition form) {
        ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        form.setStatus("y");
        if(form.getId() != null ){
        	result = this.websiteRecruitPositionService.updateRecord(form);        	
        }else{
        	result = this.websiteRecruitPositionService.insertRecord(form);
        }
        return result;
    }
    
    /**
     * 发布与取消发布
     *
     * @return
     */
    @RequestMapping(value = "cancelAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> cancelAction(HttpServletRequest request, @RequestBody WebsiteRecruitPosition form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();

        Integer id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteRecruitPosition> recordResult = this.websiteRecruitPositionService.cancelPublish(id);
            if (recordResult.isSuccess()) {
                isSuccess = true;
                message="成功";
            }else{
                message="失败";
            }
        }else{
            message="失败";
        }

        ret.setSuccess(isSuccess);
        ret.setMessage(message);
        return ret;
    }
    
    /**
     * 删除招聘岗位
     *
     * @return
     */
    @RequestMapping(value = "removeOrderAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> removeOrderAction(HttpServletRequest request, @RequestBody WebsiteRecruitPosition form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();

        Integer id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteRecruitPosition> recordResult = this.websiteRecruitPositionService.removeRecord(id);
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
    
    
    /**
     * 得到特定大类下的招聘岗位
     *
     * @param request
     * @param departmentId 部门id
     */
    @ResponseBody
    @RequestMapping(value = "getPositionList", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public ServiceResult<List<KeyValueBean>> getPositionList(HttpServletRequest request, @RequestBody JSONObject positionType) {
        ServiceResult<List<KeyValueBean>> selectResult = this.websiteRecruitPositionService.getPositionListByPositionType(positionType.getString("positionType"));
        return selectResult;
    }
    
}
