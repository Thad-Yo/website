package com.website.service.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.session.LoginUserInfo;
import com.website.mybatis.bean.auto.system.CMMenuPermission;
import com.website.mybatis.bean.ext.system.AdminMenuBean;
import com.website.service.BaseService;

import java.util.List;

public interface MenuService extends BaseService {

  /**
   * 获取菜单列表
   *
   * @return
   */
  ServiceResult<JSONArray> getRecordList(AdminMenuBean form);

  /**
   * 获取单个菜单
   *
   * @return
   */
  ServiceResult<AdminMenuBean> getRecord(String id);

  /**
   * 根据主键判断菜单数据是否存在
   *
   * @return
   */
  ServiceResult<Integer> isExistsRecord(String menuId, String menuName);

  /**
   * 菜单插入
   *
   * @param record
   */
  ServiceResult<String> insertRecord(LoginUserInfo userInfo, AdminMenuBean record) throws Exception;

  /**
   * 菜单更新
   *
   * @param record
   */
  ServiceResult<Integer> updateRecord(LoginUserInfo userInfo, AdminMenuBean record) throws Exception;

  /**
   * 取得菜单权限列表
   *
   * @param menuId
   */
  ServiceResult<List<CMMenuPermission>> getMenuPermissionsList(String menuId);

  /**
   * 菜单权限更新
   *
   * @param record
   */
  void updateMenuPermissions(AdminMenuBean record);
}
