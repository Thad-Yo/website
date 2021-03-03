package com.website.admin.system.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.admin.base.BaseController;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.session.SessionUtils;
import com.website.common.util.validator.ValidatorAjaxCheckResult;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.ext.system.AdminMenuBean;
import com.website.mybatis.bean.ext.system.ExtDepartmentModel;
import com.website.service.maintenance.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/system/maintenance/department")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 护画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView("/system/maintenance/department/department_list");
        return modelAndView;
    }

    /**
     * 获取该菜单下的权限
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "geDepartment", method = {RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResult<ExtDepartmentModel> getMenu(String departmentCd) {
        ServiceResult<ExtDepartmentModel> result = this.departmentService.getRecord(departmentCd);
        return result;
    }


    /**
     * 护画面初始化
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("departmentTree")
    public JSONArray menuTree(AdminMenuBean form) {
        ServiceResult<JSONArray> result = this.departmentService.getRecordList(form);
        return result.getResult();
    }

    /**
     * 获取国内催收中心下的各个分公司
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("getDepartmentByDepartmentPCd")
    public JSONArray getDepartmentByDepartmentPCd(AdminMenuBean form) {
    	String departmentPCd = "f9358fba-c335-4e56-ada5-5b8ea6d5c57a";//国内催收中心的department_cd
        ServiceResult<JSONArray> result = this.departmentService.selectDepartment(form, departmentPCd);
        return result.getResult();
    }
    
    /**
     * 检查编号唯一性
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxCheckAction", method = RequestMethod.POST)
    public String ajaxCheckAction(HttpServletRequest request) {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String param = request.getParameter("param");

        // 检查角色名称唯一性
        ServiceResult<Integer> result = departmentService.isExistsRecord(id, param);
        int cnt = result.getResult();
        return ValidatorAjaxCheckResult.getAjaxCheckResult(cnt, "部门名称重复，请重新输入!");
    }

    /**
     * 护画面初始化
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "insertAction")
    public ServiceResult<CMDepartment> insertAction(ExtDepartmentModel form) {
        ServiceResult<CMDepartment> result = null;
        try {
            result = this.departmentService.insertRecord(SessionUtils.getLoginUserInfo(), form);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("部门保存失败！");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 护画面初始化
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateAction")
    public ServiceResult<CMDepartment> updateAction(ExtDepartmentModel form) {
        ServiceResult<CMDepartment> result = null;
        try {
            result = this.departmentService.updateRecord(SessionUtils.getLoginUserInfo(), form);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("部门修改失败！");
            result.setSuccess(false);
        }
        return result;
    }
    
    /**
     * 获取部门
     *
     * @param param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getDepartmentByParam")
    public ServiceResult<List<ExtDepartmentModel>> getDepartmentByParam(ExtDepartmentModel form) {
        ServiceResult<List<ExtDepartmentModel>> result = null;
        try {
            result = this.departmentService.selectDepartment(form);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("部门查询失败！");
            result.setSuccess(false);
        }
        return result;
    }

}

