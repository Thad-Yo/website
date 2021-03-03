package com.website.mybatis.mapper.ext.system;


import com.website.mybatis.bean.auto.system.CMUserExample;
import com.website.mybatis.bean.ext.system.ExtPermissionModel;
import com.website.mybatis.bean.ext.system.ExtRoleMenuPermissionModel;
import com.website.mybatis.bean.ext.system.ExtUserModel;

import java.util.List;


public interface ExtPermissionMapper {

  /**
   * 获取用户的菜单权限
   *
   * @param param
   * @return
   */
  List<ExtPermissionModel> selectPermission(ExtPermissionModel param);


  /**
   * 获取用户信息
   *
   * @param example
   * @return
   */
  List<ExtUserModel> selectUserByExample(CMUserExample example);


  /**
   * 获取菜单的权限
   *
   * @param param
   * @return
   */
  List<ExtRoleMenuPermissionModel> selectRoleMenuPermission(ExtRoleMenuPermissionModel param);

}