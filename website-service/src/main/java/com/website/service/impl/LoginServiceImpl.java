package com.website.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.stereotype.Service;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMDepartmentExample;
import com.website.mybatis.bean.auto.system.CMDepartmentUser;
import com.website.mybatis.bean.auto.system.CMDepartmentUserExample;
import com.website.mybatis.bean.auto.system.CMRole;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CMUserExample;
import com.website.mybatis.bean.auto.system.CMUserRole;
import com.website.mybatis.bean.auto.system.CMUserRoleExample;
import com.website.mybatis.bean.ext.system.ExtMenuModel;
import com.website.mybatis.bean.ext.system.ExtPermissionModel;
import com.website.service.LoginService;

/**
 * Created by Administrator on 2016/8/2.
 */
@Service
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

    private static final String THIS_CLASS = LoginServiceImpl.class.getName();

    /**
     * 根据用户账户和密码
     *
     * @param user
     * @return
     */
    public ServiceResult<CMUser> getCMUser(CMUser user) {
        ServiceResult<CMUser> result = new ServiceResult<>();

        CMUserExample example = new CMUserExample();
        CMUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andPasswordEqualTo(user.getPassword());
        //criteria.andUserFlagEqualTo("2");
        List<CMUser> listUser = this.cmUserMapper.selectByExample(example);
        if (listUser == null || listUser.size() == 0) {
            result.setResult(null);
        } else {
            result.setResult(listUser.get(0));
        }
        result.setSuccess(true);

        return result;
    }


    /**
     * 根据用户ID获取用户信息
     *
     * @return
     */
    public ServiceResult<CMUser> getCMUserByUserId(String userId) {
        ServiceResult<CMUser> result = new ServiceResult<>();
        CMUserExample example = new CMUserExample();
        CMUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL).andUserIdEqualTo(userId);
        List<CMUser> listUser = this.cmUserMapper.selectByExample(example);
        if (listUser == null || listUser.size() == 0) {
            result.setResult(null);
        } else {
            result.setResult(listUser.get(0));
        }
        result.setSuccess(true);
        return result;
    }


    /**
     * 根据用户ID获取用户信息
     *
     * @return
     */
    public ServiceResult<CMDepartment> getUserDepartment(String userId) {
        ServiceResult<CMDepartment> result = new ServiceResult<>();
        CMDepartmentUserExample example = new CMDepartmentUserExample();
        CMDepartmentUserExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL).andUserIdEqualTo(userId);
        List<CMDepartmentUser> listUser = this.cmDepartmentUserMapper.selectByExample(example);
        if (listUser == null || listUser.size() == 0) {
            result.setResult(null);
        } else {
            CMDepartmentExample exampleDepartment = new CMDepartmentExample();
            CMDepartmentExample.Criteria criteriaDepartment = exampleDepartment.createCriteria();
            criteriaDepartment.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL).andDepartmentCdEqualTo(listUser.get(0).getDepartmentCd());
            List<CMDepartment> departments = this.cmDepartmentMapper.selectByExample(exampleDepartment);
            if (departments == null || departments.size() == 0) {
                result.setResult(null);
            } else {
                result.setResult(departments.get(0));
            }
        }
        result.setSuccess(true);
        return result;
    }

    /**
     * 获取用户的角色
     *
     * @param userId
     * @return
     */
    public ServiceResult<List<String>> getUserRole(String userId) {
        ServiceResult<List<String>> result = new ServiceResult<>();

        CMUserRoleExample example = new CMUserRoleExample();
        CMUserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<CMUserRole> list = cmUserRoleMapper.selectByExample(example);

        List<String> roleCdList = new ArrayList<String>();
        if (list != null && list.size() > 0) {
            for (CMUserRole cmuserRole : list) {
                CMRole role = this.cmRoleMapper.selectByPrimaryKey(cmuserRole.getRoleId());
                if (role != null) {
                    roleCdList.add(role.getRole());
                }
            }
        }
        result.setResult(roleCdList);
        result.setSuccess(true);

        return result;
    }


    /**
     * 获取菜单列表
     *
     * @param extMenuModel
     * @return
     * @author Administrator
     */
    public ServiceResult<List<ExtMenuModel>> selectLeftMenuTree(ExtMenuModel extMenuModel) {
        ServiceResult<List<ExtMenuModel>> result = new ServiceResult<>();

        List<ExtMenuModel> leftMenuList = this.extMenuMapper.selectLeftMenuTree(extMenuModel);
        result.setResult(this.treeMenuList(leftMenuList, ConstantsUtil.TREE_TOP));
        result.setSuccess(true);
        return result;
    }

    /**
     * 菜单树形结构
     *
     * @param menuTreeDBList
     * @param topParentMenuCd
     * @return
     */
    private List<ExtMenuModel> treeMenuList(List<ExtMenuModel> menuTreeDBList, String topParentMenuCd) {
        List<ExtMenuModel> childMenu = new ArrayList<ExtMenuModel>();
        if (menuTreeDBList != null && menuTreeDBList.size() > 0) {
            for (ExtMenuModel menuTreeRecord : menuTreeDBList) {
                ExtMenuModel menuTree = menuTreeRecord;
                String menuCd = menuTree.getMenuId();
                String parentMenuCd = menuTree.getParentMenuId();
                if (topParentMenuCd.equals(parentMenuCd)) {
                    List<ExtMenuModel> MenuTreeList = treeMenuList(menuTreeDBList, menuCd);
                    menuTree.setMenuTreeClild(MenuTreeList);
                    childMenu.add(menuTree);
                }
            }
        }

        return childMenu;
    }

    /**
     * 获取用户的权限
     *
     * @param userCd 登录用户的编号
     * @return
     */
    public ServiceResult<List<ExtPermissionModel>> selectPermission(String userCd) {
        ServiceResult<List<ExtPermissionModel>> result = new ServiceResult<>();

        ExtPermissionModel mode = new ExtPermissionModel();
        mode.setUserId(userCd);
        List<ExtPermissionModel> permissionList = this.extPermissionMapper.selectPermission(mode);
        result.setResult(permissionList);
        result.setSuccess(true);
        return result;
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
     */
    @Override
    public void doGetAuthorizationInfo(String userId) {

        ServiceResult<CMUser> userResult = this.getCMUserByUserId(userId);

        if (userResult.isSuccess()) {
            CMUser user = userResult.getResult();
            Set<String> roles = new HashSet<String>();
            Set<String> permissions = new HashSet<String>();

            // 角色
            ServiceResult<List<String>> userRoleListResult = this.getUserRole(user.getUserId());
            if (userRoleListResult.isSuccess()) {
                List<String> userRoleList = userRoleListResult.getResult();
                if (userRoleList != null && userRoleList.size() > 0) {
                    for (String userRole : userRoleList) {
                        roles.add(userRole);
                    }
                }
            }
            // 权限
            ServiceResult<List<ExtPermissionModel>> permissionListResult = this.selectPermission(String.valueOf(user.getUserId()));
            if (permissionListResult.isSuccess()) {
                List<ExtPermissionModel> permissionList = permissionListResult.getResult();
                if (permissionList != null && permissionList.size() > 0) {
                    for (ExtPermissionModel permissionEntity : permissionList) {
                        // 菜单与权限关联
                        permissions.add(permissionEntity.getMenuCtrl() + ":" + permissionEntity.getPermission());
                    }
                }
            }

            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.setRoles(roles);
            info.setStringPermissions(permissions);
        }
    }

}
