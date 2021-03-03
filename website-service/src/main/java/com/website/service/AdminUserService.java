package com.website.service;

import com.alibaba.fastjson.JSONArray;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMDepartmentExample;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.system.ExtUserModel;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface AdminUserService extends BaseService {

    /**
     * 获取用户件数
     *
     * @return
     */
    ServiceResult<Integer> getRecordListSize(ExtUserModel form);

    /**
     * 获取用户列表
     *
     * @return
     */
    ServiceResult<List<ExtUserModel>> getRecordList(ExtUserModel form);

    /**
     * 获取用户
     *
     * @return
     */
    ServiceResult<ExtUserModel> getRecord(ExtUserModel form);

    /**
     * 数据插入
     *
     * @param record
     */
    ServiceResult<CMUser> insertRecord(ExtUserModel record);

    /**
     * 数据更新
     *
     * @param record
     */
    ServiceResult<CMUser> updateRecord(ExtUserModel record);

    /**
     * 数据逻辑删除
     *
     * @param record
     */
    ServiceResult<CMUser> deleteRecord(ExtUserModel record);

    /**
     * 查询数据
     *
     * @param record
     */
    ServiceResult<List<CMUser>> selectByExample(ExtUserModel record);

    ServiceResult<CMUser> updatePassword(ExtUserModel record);

    /**
     * 获取分配的人员
     *
     * @param record
     * @return
     */
    ServiceResult<List<ExtUserModel>> selectInviteUserList(ExtUserModel record);

    /**
     * 获取登录用户的登录部门
     *
     * @param record
     * @return
     */
    ServiceResult<List<ExtUserModel>> selectLoginUserDepartment(ExtUserModel record);


    /**
     * 获取用户列表
     *
     * @return
     */
    ServiceResult<List<CMUser>> getUserListByExample(ExtUserModel form);
    
    /**
     * 根据用户信息获取该用户下关联的部门关系模型
     * @param form
     * @return
     */
    List<List<CMDepartment>> getDepartmentModelByUser(ExtUserModel form);
    
}
