package com.website.service;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.system.ExtMenuModel;
import com.website.mybatis.bean.ext.system.ExtPermissionModel;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface LoginService extends BaseService {

    /**
     * 根据用户ID获取用户信息
     *
     * @param user
     * @return
     */
    ServiceResult<CMUser> getCMUser(CMUser user);

    /**
     * 根据用户ID获取用户信息
     *
     * @param userId
     * @return
     */
    ServiceResult<CMUser> getCMUserByUserId(String userId);

    /**
     * 根据用户ID获取用户信息
     *
     * @return
     */
    ServiceResult<CMDepartment> getUserDepartment(String userId);

    ServiceResult<List<String>> getUserRole(String userId);

    ServiceResult<List<ExtMenuModel>> selectLeftMenuTree(ExtMenuModel extMenuModel);

    ServiceResult<List<ExtPermissionModel>> selectPermission(String userId);

    void doGetAuthorizationInfo(String userId);
}
