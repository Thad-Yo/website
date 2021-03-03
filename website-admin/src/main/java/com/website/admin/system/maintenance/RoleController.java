package com.website.admin.system.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseController;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.common.util.paginator.Paginator;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.common.util.validator.Validator;
import com.website.common.util.validator.ValidatorAjaxCheckResult;
import com.website.mybatis.bean.auto.system.CMRole;
import com.website.mybatis.bean.auto.system.CMRoleMenuPermission;
import com.website.mybatis.bean.ext.system.ExtRoleModel;
import com.website.service.maintenance.RoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 角色管理
 */
@Controller
@RequestMapping(value = "/system/maintenance/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 护画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView("/system/maintenance/role/role_list");
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
    public JSONObject searchAction(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtRoleModel form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, ExtRoleModel form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));

        ServiceResult<List<CMRole>> result = this.roleService.getRoleList(form);

        if (result != null) {
            List<CMRole> recordList = result.getResult();
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
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtRoleModel form) {
        ModelAndView modelAndView = new ModelAndView("system/maintenance/role/role_info");
        // 根据主键获取相应的数据
        String primaryKey = form.getRoleId();
        if (StringUtils.isNotEmpty(primaryKey)) {
            ServiceResult<CMRole> result = this.roleService.getRole(form);
            CMRole role = result.getResult();
            modelAndView.addObject("record", role);
        }
        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 画面迁移(含有id更新，不含有id添加)
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("authAction")
    public ModelAndView authAction(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtRoleModel form) {
        ModelAndView modelAndView = new ModelAndView("system/maintenance/role/role_auth");
        // 根据主键获取相应的数据
        String primaryKey = form.getRoleId();
        if (StringUtils.isNotEmpty(primaryKey)) {
            ServiceResult<CMRole> role = this.roleService.getRole(form);
            modelAndView.addObject("record", role);
        }
        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 菜单管理画面初始化
     *
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("menuInfoAction/{roleId}")
    public String getAdminRoleMenu(@PathVariable String roleId) {
        if (Validator.isNotNull(roleId)) {
            ExtRoleModel record = new ExtRoleModel();
            record.setRoleId(roleId);
            ServiceResult<CMRole> role = this.roleService.getRole(record);
            if (role != null) {
                // 取得角色菜单权限表数据
                ServiceResult<JSONArray> result = this.roleService.getAdminRoleMenu(role.getResult().getRoleId());
                if (result.getSuccess()) {
                    return result.getResult().toJSONString();
                }
            }
        }
        return null;
    }

    /**
     * 插入或更新[角色菜单权限表]数据
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "modifyPermissionAction", method = RequestMethod.POST)
    public ServiceResult<JSONObject> modifyPermissionAction(HttpServletRequest request, String roleId, String param) {
        LoginUserInfo loginUserInfo = SessionUtils.getLoginUserInfo();
        String params = StringEscapeUtils.unescapeHtml4(param);
        ServiceResult<JSONObject> serviceResult = this.roleService.updatePermission(roleId, loginUserInfo, JSONObject.parseArray(params, CMRoleMenuPermission.class));
        return serviceResult;
    }


    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping("insertAction")
    public ServiceResult<CMRole> insertAction(HttpServletRequest request, ExtRoleModel form) {
        // 画面验证
        Map<String, String> errorMap = this.validatorFieldCheck(form);
        //校验角色编码role唯一性
        if(form.getRole()!=null){
        	ExtRoleModel roleModel = new ExtRoleModel();
        	roleModel.setRole(form.getRole());
        	ServiceResult<List<CMRole>> roles = this.roleService.getRoleList(roleModel);
        	if(roles!=null && roles.getResult()!=null && roles.getResult().size()>0){
        		ServiceResult<CMRole> result = new ServiceResult<>();
        		result.setError("角色编码 "+form.getRole()+ " 已经存在，请勿重复添加！");
        		return result;
        	}
        }
        
        
        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setCreateGroupCd(loginDepartmentCd);
        form.setCreateUserCd(loginUserCd);
        form.setCreateDate(nowDate);
        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);
        ServiceResult<CMRole> result = this.roleService.insertRecord(SessionUtils.getLoginUserInfo(), form);
        return result;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("updateAction")
    public ServiceResult<CMRole> updateAction(HttpServletRequest request, ExtRoleModel form) {

        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);

        return this.roleService.updateRecord(SessionUtils.getLoginUserInfo(), form);
    }

    /**
     * 删除配置信息
     *
     * @param request
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteAction")
    public ServiceResult<CMRole> deleteRecordAction(HttpServletRequest request, ExtRoleModel form) {
        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);
        return this.roleService.deleteRecord(SessionUtils.getLoginUserInfo(), form);
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
        ServiceResult<Integer> result = roleService.countRoleByRole(id, param);
        int cnt = result.getResult();
        return ValidatorAjaxCheckResult.getAjaxCheckResult(cnt, "角色编码重复，请重新输入");
    }

    /**
     * 调用校验表单方法
     */
    private Map<String, String> validatorFieldCheck(ExtRoleModel form) {
        Map<String, String> errorMap = new HashMap<>();
        return errorMap;
    }
}

