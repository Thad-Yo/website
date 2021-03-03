package com.website.admin.system.recruit;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.paginator.Paginator;
import com.website.mybatis.bean.auto.CMDepartmentPosition;
import com.website.mybatis.bean.auto.WebsiteConfigPosition;
import com.website.mybatis.bean.auto.WebsiteRecruitPosition;
import com.website.mybatis.bean.ext.ExtHrConfigPositionType;
import com.website.service.recruit.WebsiteConfigPositionService;
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
 * 岗位大类
 * @Auther: hzm
 * @Date: 2018/5/29 11:21
 * @Description:
 */
@Controller
@RequestMapping(value="/system/configPosition")
public class ConfigPositionController {
    @Autowired
    WebsiteConfigPositionService websiteConfigPositionService;
	@Autowired
	WebsiteRecruitPositionService websiteRecruitPositionService;
    /**
     * 订单查询画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(@ModelAttribute(BaseDefine.FORM) WebsiteConfigPosition form) {
        ModelAndView modelAndView = new ModelAndView("system/recruit/configPosition/configPosition_list");
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
                                   @ModelAttribute(BaseDefine.FORM) WebsiteConfigPosition form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteConfigPosition form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator
                .getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"),
                pageNumSizeMap.get("pageSize"));

        ServiceResult<List<WebsiteConfigPosition>> result = this.websiteConfigPositionService
                .findConfigPositionList(form);

        if (result != null) {
            List<WebsiteConfigPosition> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) WebsiteConfigPosition form) {
        ModelAndView modelAndView = new ModelAndView("system/recruit/configPosition/configPosition_info");

        if(StringUtils.isNotBlank(form.getId())){
            ServiceResult<WebsiteConfigPosition> result = this.websiteConfigPositionService
                    .getRecord(form);
            modelAndView.addObject("record", result.getResult());
        }

        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 插入记录
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("insertAction")
    public ServiceResult<WebsiteConfigPosition> insertAction(HttpServletRequest request,
                                                             WebsiteConfigPosition form) {
        ServiceResult<WebsiteConfigPosition> result = new ServiceResult<>();
        result = this.websiteConfigPositionService.insertRecord(form);
        return result;
    }

    /**
     * 更改记录
     *
     * @param request
     * @param form
     */
    @ResponseBody
    @RequestMapping("updateAction")
    public ServiceResult<WebsiteConfigPosition> updateAction(HttpServletRequest request,
                                                             WebsiteConfigPosition form) {
        ServiceResult<WebsiteConfigPosition> result = new ServiceResult<>();

        result = this.websiteConfigPositionService.updateRecord(form);
        return result;
    }
    /**
     * 用户删除记录
     *
     * @return
     */
    @RequestMapping(value = "removeOrderAction", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<JSONObject> removeOrderAction(HttpServletRequest request, @RequestBody WebsiteConfigPosition form){
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
        //校验是否已启用，如有，则不给删
        ServiceResult<List<WebsiteRecruitPosition>> list = this.websiteRecruitPositionService.selectByExample(form.getId());
        if(list.getResult().size()>0){
        	ret.setSuccess(false);
            ret.setMessage("岗位大类已启用,无法删除！");
            return ret;
        }
        String id = form.getId();
        boolean isSuccess = false;
        String message="";
        if(id!=null&&!"".equals(id)){
            ServiceResult<WebsiteConfigPosition> recordResult = this.websiteConfigPositionService.removeRecord(id);
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
     * 护画面初始化
     *
     * @return
     */
    @RequestMapping("openPositionButton")
    public ModelAndView openPositionButton(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView("/system/recruit/configPosition/department_button");
        String positionIds = request.getParameter("matchingPositionIds");
        CMDepartmentPosition recordposi = new CMDepartmentPosition();
        //JSONArray json=getDepartment(request);
        ServiceResult<List<ExtHrConfigPositionType>> positionResult =
                this.websiteConfigPositionService.getPositionTypeList(recordposi, "1", positionIds);
        modelAndView.addObject("positionResult",positionResult.getResult());
        return modelAndView;
    }

    /*//调用http接口
    public JSONArray getDepartment(HttpServletRequest request) throws Exception{
        String positionIds = request.getParameter("matchingPositionIds");
        JSONArray arr = new JSONArray();
        //传入中文参数并设置编码格式
        String param = "{\"url\":\"中文\"}";
        param = URLEncoder.encode(param, "UTF-8");
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL("http://172.16.110.157:8088/lxhr-admin/system/maintenance/department/getDepartment");
            HttpURLConnection httpConn = (HttpURLConnection) realUrl.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            //httpConn.connect();
            PrintWriter pw=new PrintWriter(httpConn.getOutputStream());
            String content = "matchingPositionIds=" + positionIds;
            pw.print(content);
            pw.flush();
            pw.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream(), "UTF-8"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            httpConn.disconnect();
            String str= buffer.toString();
            URLEncoder.encode(str,"UTF-8");
            //解析json对象
            //jsStr = JSON.parseObject(str);
            arr=JSON.parseObject(str).getJSONArray("positionResult");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }*/

}
