package com.website.admin.system.maintenance;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseController;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.paginator.Paginator;
import com.website.common.util.security.MD5Util;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMRole;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.system.ExtRoleModel;
import com.website.mybatis.bean.ext.system.ExtUserModel;
import com.website.service.AdminUserService;
import com.website.service.maintenance.DepartmentService;
import com.website.service.maintenance.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author GOGTZ
 * @version V1.0  
 * @date Tue Jul 12 16:47:53 CST 2016
 */
@Controller
@RequestMapping(value = "/system/maintenance/adminuser")
public class AdminUserController extends BaseController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = BaseDefine.INIT)
    public ModelAndView init(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtUserModel form) {
        ModelAndView modelAndView = new ModelAndView("/system/maintenance/adminuser/adminuser_list");
        return modelAndView;
    }

    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "searchAction")
    public JSONObject searchAction(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtUserModel form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, ExtUserModel form) {
        JSONObject object = new JSONObject();
        List<ExtUserModel> recordList = new ArrayList<>();

        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));

        // 取得内容
        ServiceResult<List<ExtUserModel>> recordResult = this.adminUserService.getRecordList(form);

        if (recordResult != null && recordResult.isSuccess() && recordResult.getResult() != null) {
            recordList = recordResult.getResult();
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
    @RequestMapping(value = "infoAction")
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtUserModel form) {
        ModelAndView modelAndView = new ModelAndView("/system/maintenance/adminuser/adminuser_info");
        //获取所有分公司列表
        List<CMDepartment> branchDepartmentList = this.departmentService.getBranchDepartmentList();
        modelAndView.addObject("branchDepartmentList", branchDepartmentList);
        // 根据主键获取相应的数据
        if (form != null && StringUtils.isNotBlank(form.getUserId())) {
            ServiceResult<ExtUserModel> recordResult = this.adminUserService.getRecord(form);
            if (recordResult.isSuccess()) {
                modelAndView.addObject(BaseDefine.RECORD, recordResult.getResult());
            }
            //获取用户所在部门以及父级列表数据
            List<List<CMDepartment>> userDepartmentModelList = this.adminUserService.getDepartmentModelByUser(form);
            if(userDepartmentModelList!=null && userDepartmentModelList.size()>0){
            	for(List<CMDepartment> userDepartmentModel : userDepartmentModelList){
            		Collections.reverse(userDepartmentModel);
            	}
            }
            modelAndView.addObject("userDepartmentModelList", userDepartmentModelList);
        }

        // 取得角色列表
        ExtRoleModel roleModel = new ExtRoleModel();
        roleModel.setDelFlag(ConstantsUtil.FLG_NORMAL);
        List<CMRole> listRole = this.roleService.getRoleList(roleModel).getResult();
        modelAndView.addObject("listRole", listRole);

        modelAndView.addObject(BaseDefine.FORM, form);
        return modelAndView;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping(value = "insertAction")
    public ServiceResult<JSONObject> insertAction(HttpServletRequest request, ExtUserModel form) {
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
        boolean isSuccess = false;

        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setCreateGroupCd(loginDepartmentCd);
        form.setCreateUserCd(loginUserCd);
        form.setCreateDate(nowDate);
        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);

        ServiceResult<CMUser> recordResult = this.adminUserService.insertRecord(form);

        if (loginUserCd.equals(form.getUserId())) {
            updateUserSession(form);
        }
        if (recordResult.isSuccess()) {
            isSuccess = true;
        }
        ret.setSuccess(isSuccess);

        List<String> cityList = departmentService.getLoginUserDepartmentList().getResult();
        SessionUtils.setSession(ConstantsUtil.LOGIN_USER_MANAGE_DEPARTMENT, cityList);

        return ret;
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping(value = "updateAction")
    public ServiceResult<JSONObject> updateAction(HttpServletRequest request, ExtUserModel form) {
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
        boolean isSuccess = false;

        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);

        if (loginUserCd.equals(form.getUserId())) {
            updateUserSession(form);
        }

        ServiceResult<CMUser> recordResult = this.adminUserService.updateRecord(form);
        if (recordResult.isSuccess()) {
            isSuccess = true;
        }
        ret.setSuccess(isSuccess);

        List<String> cityList = departmentService.getLoginUserDepartmentList().getResult();
        SessionUtils.setSession(ConstantsUtil.LOGIN_USER_MANAGE_DEPARTMENT, cityList);
        
        return ret;
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "deleteAction")
    public ServiceResult<JSONObject> deleteAction(HttpServletRequest request, ExtUserModel form) {
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
        boolean isSuccess = false;

        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);

        if (loginUserCd.equals(form.getUserId())) {
            updateUserSession(form);
        }

        ServiceResult<CMUser> recordResult = this.adminUserService.deleteRecord(form);
        if (recordResult.isSuccess()) {
            isSuccess = true;
        }

        ret.setSuccess(isSuccess);
        return ret;
    }

    /**
     * 更新用户的session数据
     *
     * @param form
     */
    private void updateUserSession(ExtUserModel form) {
        ExtUserModel record = new ExtUserModel();
        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUserId(form.getUserId());
        userInfo.setUserName(form.getUserName());
        userInfo.setRealName(form.getRealName());
        SessionUtils.setSession(ConstantsUtil.LOGIN_USER_INFO, userInfo);
    }

    /**
     * 重置密码
     */
    @ResponseBody
    @RequestMapping(value = "resetAction")
    public ServiceResult<JSONObject> resetAction(HttpServletRequest request, ExtUserModel form) {
        ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
        boolean isSuccess = false;

        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);

        ExtUserModel user = new ExtUserModel();
        user.setUserId(form.getUserId());
        user.setPassword(MD5Util.string2MD5("a123456"));

        ServiceResult<CMUser> recordResult = this.adminUserService.updateRecord(user);
        if (recordResult.isSuccess()) {
            isSuccess = true;
        }

        ret.setSuccess(isSuccess);
        return ret;
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
        JSONObject ret = new JSONObject();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String param = request.getParameter("param");
        if (StringUtils.isNotEmpty(param)) {
            ExtUserModel user = new ExtUserModel();
            if ("userName".equals(name)) {
                user.setUserName(param);
            } else if ("mobileNumber".equals(name)) {
                user.setMobileNumber(param);
            } else if ("emailAddress".equals(name)) {
                user.setEmailAddress(param);
            }

            List<CMUser> listUser = adminUserService.selectByExample(user).getResult();
            if (listUser == null) {
                ret.put(BaseDefine.JSON_VALID_STATUS_KEY, BaseDefine.JSON_VALID_STATUS_OK);
                return ret.toString();
            } else {
                for (CMUser userModel : listUser) {
                    if ("userName".equals(name)) {
                        if (!userModel.getUserId().equals(id)) {
                            ret.put(BaseDefine.JSON_VALID_INFO_KEY, "登录用户名重复!");
                            return ret.toString();
                        }
                    } else if ("mobileNumber".equals(name)) {
                        if (!userModel.getUserId().equals(id)) {
                            ret.put(BaseDefine.JSON_VALID_INFO_KEY, "电话重复!");
                            return ret.toString();
                        }
                    } else if ("emailAddress".equals(name)) {
                        if (!userModel.getUserId().equals(id)) {
                            ret.put(BaseDefine.JSON_VALID_INFO_KEY, "邮箱重复!");
                            return ret.toString();
                        }
                    }


                }
            }
        }
        ret.put(BaseDefine.JSON_VALID_STATUS_KEY, BaseDefine.JSON_VALID_STATUS_OK);
        return ret.toString();
    }

    /**
     * 检查编号唯一性
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxCheckUserNoAction", method = RequestMethod.POST)
    public String ajaxCheckUserNoAction(HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        String id = request.getParameter("id");
        String param = request.getParameter("param");
        if (StringUtils.isNotEmpty(param)) {
            ExtUserModel user = new ExtUserModel();
            user.setUserNo(param);
            List<CMUser> listUser = adminUserService.selectByExample(user).getResult();
            if (listUser == null) {
                ret.put(BaseDefine.JSON_VALID_STATUS_KEY, BaseDefine.JSON_VALID_STATUS_OK);
                return ret.toString();
            } else {
                for (CMUser userModel : listUser) {
                    if (!userModel.getUserId().equals(id)) {
                        ret.put(BaseDefine.JSON_VALID_INFO_KEY, "登录用户名重复!");
                        return ret.toString();
                    }
                }
            }
        }
        ret.put(BaseDefine.JSON_VALID_STATUS_KEY, BaseDefine.JSON_VALID_STATUS_OK);
        return ret.toString();
    }
}

