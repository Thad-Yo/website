package com.website.admin.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.system.ExtMenuModel;
import com.website.mybatis.bean.ext.system.ExtPermissionModel;
import com.website.service.AdminUserService;
import com.website.service.LoginService;
import com.website.service.maintenance.DepartmentService;

@Component
public class AdminAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    private DepartmentService departmentService;

    public AdminAuthorizingRealm() {
        super();
    }

    /**
     * 认证回调函数, 登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();

        char[] pwd = token.getPassword();
        String password = new String(pwd);

        CMUser user = new CMUser();
        user.setUserName(username);
        user.setPassword(password);
        user = this.loginService.getCMUser(user).getResult();

        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserId(), password, getName());
        } else {
            throw new AuthenticationException();
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = principals.getPrimaryPrincipal().toString();

        CMUser user = this.loginService.getCMUserByUserId(userId).getResult();

        Set<String> roles = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();

        // 角色
        List<String> userRoleList = this.loginService.getUserRole(user.getUserId()).getResult();
        if (userRoleList != null && userRoleList.size() > 0) {
            for (String userRole : userRoleList) {
                roles.add(userRole);
            }
        }

        // 权限
        List<ExtPermissionModel> permissionList = this.loginService.selectPermission(String.valueOf(user.getUserId())).getResult();
        if (permissionList != null && permissionList.size() > 0) {
            for (ExtPermissionModel permissionEntity : permissionList) {
                // 菜单与权限关联
                permissions.add(permissionEntity.getMenuCtrl() + ":" + permissionEntity.getPermission());
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);

        ExtMenuModel adminShiro = new ExtMenuModel();
        adminShiro.setUserCd(String.valueOf(user.getUserId()));
        adminShiro.setPermission(ConstantsUtil.VIEW);

        List<ExtMenuModel> leftMenuTree = this.loginService.selectLeftMenuTree(adminShiro).getResult();
        SessionUtils.setSession(ConstantsUtil.MAIN_MENU_TREE, leftMenuTree);

        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setUserName(user.getUserName());
        userInfo.setRealName(user.getRealName());
        userInfo.setUserFlag(user.getUserFlag());
        userInfo.setMobile(user.getMobileNumber());
        userInfo.setExtension(user.getExtensionNumber());
        SessionUtils.setSession(ConstantsUtil.LOGIN_USER_INFO, userInfo);


        List<String> departmentList = departmentService.getLoginUserDepartmentList().getResult();
        SessionUtils.setSession(ConstantsUtil.LOGIN_USER_MANAGE_DEPARTMENT, departmentList);

        return info;
    }

    /**
     * 更新用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }
}
