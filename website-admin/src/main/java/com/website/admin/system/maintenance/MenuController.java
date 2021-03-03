package com.website.admin.system.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.website.admin.base.BaseController;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.session.SessionUtils;
import com.website.common.util.validator.ValidatorAjaxCheckResult;
import com.website.mybatis.bean.auto.system.CMMenuPermission;
import com.website.mybatis.bean.ext.system.AdminMenuBean;
import com.website.service.maintenance.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/system/maintenance/menu")
public class MenuController extends BaseController {

  @Autowired
  private MenuService menuService;

  /**
   * 护画面初始化
   *
   * @return
   */
  @RequestMapping("init")
  public ModelAndView init() {
    ModelAndView modelAndView = new ModelAndView("/system/maintenance/menu/menu_list");
    return modelAndView;
  }

  /**
   * 打开画面的菜单
   *
   * @return
   */
  @RequestMapping("openMenuButton")
  public ModelAndView openMenuButton() {
    ModelAndView modelAndView = new ModelAndView("/system/maintenance/menu/menu_button");
    return modelAndView;
  }

  /**
   * 获取该菜单下的权限
   *
   * @return
   */
  @ResponseBody
  @RequestMapping("getMenuInfo")
  public ServiceResult<AdminMenuBean> getMenu(AdminMenuBean form) {
    String menuId = form.getMenuId();
    ServiceResult<AdminMenuBean> result = this.menuService.getRecord(menuId);
    return result;
  }

  /**
   * 获取该菜单下的权限
   *
   * @return
   */
  @ResponseBody
  @RequestMapping("getMenuPermissionsList")
  public ServiceResult<List<CMMenuPermission>> getMenuPermissionsList(AdminMenuBean form) {
    String menuId = form.getMenuId();
    ServiceResult<List<CMMenuPermission>> result = this.menuService.getMenuPermissionsList(menuId);
    return result;
  }


  /**
   * 护画面初始化
   *
   * @return
   */
  @ResponseBody
  @RequestMapping("menuTree")
  public JSONArray menuTree(AdminMenuBean form) {
    ServiceResult<JSONArray> result = this.menuService.getRecordList(form);
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
    ServiceResult<Integer> result = menuService.isExistsRecord(id, param);
    int cnt = result.getResult();
    return ValidatorAjaxCheckResult.getAjaxCheckResult(cnt, "菜单名称重复，请重新输入!");
  }

  /**
   * 护画面初始化
   *
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "insertAction")
  public ServiceResult<String> insertAction(AdminMenuBean form) {
    ServiceResult<String> result = null;
    try {
      result = this.menuService.insertRecord(SessionUtils.getLoginUserInfo(), form);
    } catch (Exception e) {
      e.printStackTrace();
      result.setMessage("菜单保存失败！");
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
  public ServiceResult<Integer> updateAction(AdminMenuBean form) {
    ServiceResult<Integer> result = null;
    try {
      result = this.menuService.updateRecord(SessionUtils.getLoginUserInfo(), form);
    } catch (Exception e) {
      e.printStackTrace();
      result.setMessage("菜单保存失败！");
      result.setSuccess(false);
    }
    return result;
  }
}

