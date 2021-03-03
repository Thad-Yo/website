package com.website.common.util.session;

import javax.servlet.http.HttpServletRequest;

import com.website.common.util.constants.ConstantsUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class SessionUtils {

    /**
     * 获取登录用户的部门编号
     *
     * @return
     */
    public static String getLoginDepartmentCd() {
        return getLoginUserInfo().getDepartmentId();
    }

    /**
     * 获取登录用户编号
     *
     * @return
     */
    public static String getLoginUserCd() {
        return getLoginUserInfo().getUserId();
    }

    /**
     * 获取登陆用户
     *
     * @return
     */
    public static LoginUserInfo getLoginUserInfo() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        LoginUserInfo cmuser = (LoginUserInfo) session.getAttribute(ConstantsUtil.LOGIN_USER_INFO);
        if (cmuser == null) {
            return new LoginUserInfo();
        }
        return cmuser;
    }

    /**
     * 设置SESSION
     *
     * @return
     */
    public static void setSession(String key, String value) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(true);
        session.setAttribute(key, value);
    }

    /**
     * 设置SESSION
     *
     * @return
     */
    public static void setSession(String key, Object value) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(true);
        session.setAttribute(key, value);
    }

    /**
     * 获取SESSION
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getSession(String key) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(true);
        return (T) session.getAttribute(key);
    }

    /**
     * 清除SESSION
     *
     * @return
     */
    public static void removeSession(String key) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(true);
        session.removeAttribute(key);
    }

    /**
     * @param request
     * @return
     */
    public static String getWebRootPath(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serviceName = request.getServerName();
        String port = String.valueOf(request.getServerPort());
        String webPath = request.getContextPath();
        String basePath = scheme + "://" + serviceName + ":" + port + webPath;
        return basePath;
    }
}
