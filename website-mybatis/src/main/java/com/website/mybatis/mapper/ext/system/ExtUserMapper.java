package com.website.mybatis.mapper.ext.system;

import java.util.List;

import com.website.mybatis.bean.ext.system.ExtUserModel;

public interface ExtUserMapper {

    int selectUserListCount(ExtUserModel record);

    List<ExtUserModel> selectUserList(ExtUserModel record);

    ExtUserModel selectUserById(String userId);

    List<ExtUserModel> selectAuthorizationUserList(ExtUserModel record);

    List<ExtUserModel> selectInviteUserList(ExtUserModel record);

    List<ExtUserModel> selectLoginUserDepartment(ExtUserModel record);

}