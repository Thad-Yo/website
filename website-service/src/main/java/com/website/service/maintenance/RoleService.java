package com.website.service.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.session.LoginUserInfo;
import com.website.mybatis.bean.auto.system.CMRole;
import com.website.mybatis.bean.auto.system.CMRoleMenuPermission;
import com.website.mybatis.bean.ext.system.ExtRoleModel;
import com.website.service.BaseService;

import java.util.List;

/**
 * Created by ZN on 2016/8/3.
 */
public interface RoleService extends BaseService {

  /**
   * 获取角色列表
   *
   * @param record
   * @return
   */
  ServiceResult<List<CMRole>> getRoleList(ExtRoleModel record);


  /**
   * 检查角色是否重复
   *
   * @param roleId
   * @param role
   * @return
   */
  ServiceResult<Integer> countRoleByRole(String roleId, String role);

  /**
   * 获取用户角色
   *
   * @param record
   * @return
   */
  ServiceResult<CMRole> getRole(ExtRoleModel record);

  /**
   * 数据插入
   *
   * @param record
   */
  ServiceResult<CMRole> insertRecord(LoginUserInfo userInfo, ExtRoleModel record);

  /**
   * 数据更新
   *
   * @param record
   */
  ServiceResult<CMRole> updateRecord(LoginUserInfo userInfo, ExtRoleModel record);

  /**
   * 数据逻辑删除
   *
   * @param record
   */
  ServiceResult<CMRole> deleteRecord(LoginUserInfo userInfo, ExtRoleModel record);

  /**
   * 取得角色菜单列表
   *
   * @param roleId
   * @return
   */
  ServiceResult<JSONArray> getAdminRoleMenu(String roleId);


  /**
   * 插入或更新[角色菜单权限表]数据
   *
   * @param list
   */
  ServiceResult<JSONObject> updatePermission(String roleId, LoginUserInfo loginUserInfo, List<CMRoleMenuPermission> list);
}
