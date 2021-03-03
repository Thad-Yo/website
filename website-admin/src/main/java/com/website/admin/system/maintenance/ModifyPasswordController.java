package com.website.admin.system.maintenance;

import com.alibaba.fastjson.JSONObject;
import com.website.admin.base.BaseController;
import com.website.admin.base.BaseDefine;
import com.website.common.util.Utils;
import com.website.common.util.date.DateUtils;
import com.website.common.util.security.MD5Util;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.system.ExtUserModel;
import com.website.service.AdminUserService;
import com.website.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/system/modpwd")
public class ModifyPasswordController extends BaseController {

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private LoginService loginService;

    /**
     * 护画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtUserModel form) {
        ModelAndView modelAndView = new ModelAndView("/system/modifyPasswod/modifyPasswod");
        return modelAndView;
    }

    /**
     * 修改
     */
    @RequestMapping("updateAction")
    public JSONObject updateAction(HttpServletRequest request, RedirectAttributes attr, ExtUserModel form) {

        String oldPassword = request.getParameter("oldPassword");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        CMUser user = new CMUser();
        user.setUserName(SessionUtils.getLoginUserInfo().getUserName());
        user.setPassword(MD5Util.string2MD5(oldPassword));
        user = loginService.getCMUser(user).getResult();
        JSONObject ret = new JSONObject();
        if (user == null) {
            return Utils.getErrorJson("请输入正确的旧密码!");
        }

        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUserId(loginUserCd);
        form.setPassword(password);
        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);
        CMUser cMUser = this.adminUserService.updatePassword(form).getResult();
        if (cMUser != null && cMUser.getUserId() != null) {
            return Utils.getSuccessJson(form);
        } else {
            return Utils.getErrorJson("更新失败");
        }
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
        String param = request.getParameter("param");
        ExtUserModel user = new ExtUserModel();
        user.setUserId(SessionUtils.getLoginUserInfo().getUserId());
        user = adminUserService.getRecord(user).getResult();
        if (user != null && user.getPassword() != null && user.getPassword().equals(MD5Util.string2MD5(param))) {
            ret.put(BaseDefine.JSON_VALID_STATUS_KEY, BaseDefine.JSON_VALID_STATUS_OK);
            return ret.toString();
        }
        ret.put(BaseDefine.JSON_VALID_INFO_KEY, "请输入正确的旧密码!");
        return ret.toString();
    }
}

