/**
 * Copyright 2015-2016 the author is GOGTZ group.
 * System Name锛欸OGTZ寮?鍙戞鏋?
 * http://www.gogtz.com
 * 娉ㄦ剰锛? 鏈唴瀹逛粎闄愪簬GOGTZ灏忕粍鍐呴儴浣跨敤锛岀姝㈣浆鍙?
 */
package com.website.admin.www.login;

import com.alibaba.fastjson.JSONObject;
import com.website.admin.base.BaseController;
import com.website.admin.shiro.realm.AdminAuthorizingRealm;
import com.website.common.util.Utils;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.code.RandomValidateCode;
import com.website.common.util.properties.PropertyUtil;
import com.website.common.util.security.MD5Util;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author GOGTZ-Z
 * @version V1.0??
 * @package com.gogtz.admin.login
 * @date 2015/07/09 17:00
 */
@Controller(value = LoginDefine.CONTROLLOR_VALUE)
@RequestMapping(value = LoginDefine.CONTROLLOR_REQUEST_MAPPING)
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AdminAuthorizingRealm adminAuthorizingRealm;

    /**
     * 画面初始化
     *
     * @param request
     * @return
     */
    @RequestMapping(LoginDefine.INIT)
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modeAndView = new ModelAndView(LoginDefine.LOGIN_PATH);
        return modeAndView;
    }

    /**
     * 画面初始化
     *
     * @param request
     * @return
     */
    @RequestMapping(value = LoginDefine.LOGIN_ACTION, method = RequestMethod.POST)
    public ModelAndView loginAction(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String randomcode = request.getParameter("randomcode");

        // 检查验证码
/*        RandomValidateCode randomValidateCode = new RandomValidateCode();
        boolean checkResult = randomValidateCode.checkRandomCode(request, randomcode, "LOGIN_");
        if (!checkResult) {
            ModelAndView modeAndView = new ModelAndView("/www/login/login");
            modeAndView.addObject("id", "#randomcode");
            modeAndView.addObject("usererror", "验证码不正确");
            modeAndView.addObject("username", userName);
            modeAndView.addObject("randomcode", randomcode);
            return modeAndView;
        }*/

        Subject currentUser = SecurityUtils.getSubject();

        CMUser user = new CMUser();
        user.setUserName(userName);
        user.setPassword(MD5Util.string2MD5(password));
        ServiceResult<CMUser> serviceResult = this.loginService.getCMUser(user);
        CMUser userModel = null;
        if (serviceResult.isSuccess()) {
            userModel = serviceResult.getResult();
        } else {
            userModel = new CMUser();
        }

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, MD5Util.string2MD5(password));
            token.setRememberMe(false);
            try {
                currentUser.login(token);
            } catch (AuthenticationException e) {
                e.printStackTrace();
                ModelAndView modeAndView = new ModelAndView("/www/login/login");
                modeAndView.addObject("id", ".btn-Login");
                modeAndView.addObject("usererror", "用户名或密码不正确，请重新输入");
                modeAndView.addObject("username", userName);
                modeAndView.addObject("randomcode", randomcode);
                return modeAndView;
            }
            Assert.isTrue(currentUser.isAuthenticated());
        }

        // 重新设置权限
        this.loginService.doGetAuthorizationInfo(userModel.getUserId());

        adminAuthorizingRealm.clearCachedAuthorizationInfo(userModel.getUserId());// 清除权限缓存
        adminAuthorizingRealm.isPermitted(SecurityUtils.getSubject().getPrincipals(), String.valueOf(System.currentTimeMillis()));
        String webRoot = PropertyUtil.getSystemResourcesPropertieValue("server.host");
        ModelAndView modeAndView = new ModelAndView(new RedirectView(webRoot + "/"));
        return modeAndView;
    }


    /**
     * 退出
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        String webRoot = PropertyUtil.getSystemResourcesPropertieValue("server.host");
        ModelAndView modeAndView = new ModelAndView(new RedirectView(webRoot + "/"));
        return modeAndView;
    }

    /**
     * 生成图片验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = LoginDefine.REGIST_RANDOMCODE, method = RequestMethod.GET)
    public void randomCode(HttpServletRequest request, HttpServletResponse response) {
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response, "LOGIN_");// 输出图片方法
        } catch (Exception e) {
        }
    }

    /**
     * 检查图片验证码
     *
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = LoginDefine.REGIST_CHECK_RANDOMCODE)
    public String checkRandomCode(HttpServletRequest request, HttpServletResponse response) {
        JSONObject ret = new JSONObject();
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        boolean checkResult = randomValidateCode.checkRandomCode(request, request.getParameter("randomcode"), "LOGIN_");
        if (checkResult) {
            return JSONObject.toJSONString(Utils.getSuccessJson("验证通过"));
        } else {
            return JSONObject.toJSONString(Utils.getErrorJson("验证码不正确"));
        }
    }

}
