package com.website.admin.system.desktop;

import com.website.admin.base.BaseController;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.ext.system.ExtMenuModel;
import com.website.service.AdminUserService;
import com.website.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author GOGTZ-Z
 * @version V1.0
 * @package com.gration.admin.system.desktop
 * @date 2015/07/09 17:00
 */
@Controller(value = DesktopDefine.CONTROLLOR_VALUE)
@RequestMapping(value = DesktopDefine.CONTROLLOR_REQUEST_MAPPING)
public class DesktopController extends BaseController {

    @Autowired
    LoginService loginService;

    @Autowired
    AdminUserService adminUserService;

    /**
     * 桌面程序初始化
     *
     * @param request
     * @return
     */
    @RequestMapping(DesktopDefine.INIT)
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(DesktopDefine.INFO_PATH);
        String userId = SessionUtils.getLoginUserCd();
        ExtMenuModel adminShiro = new ExtMenuModel();
        adminShiro.setUserCd(userId);
        adminShiro.setPermission(ConstantsUtil.VIEW);

        List<ExtMenuModel> leftMenuTree = this.loginService.selectLeftMenuTree(adminShiro).getResult();
        SessionUtils.setSession(ConstantsUtil.MAIN_MENU_TREE, leftMenuTree);

        return modelAndView;
    }

    /**
     * 画面初始化
     *
     * @param request
     * @return
     */
    @RequestMapping(DesktopDefine.INIT_HOME)
    public ModelAndView initHome(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(DesktopDefine.HOME_PATH);

        return modelAndView;
    }
}
