package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMRoleMenuPermission;
import com.website.mybatis.bean.auto.system.CMRoleMenuPermissionExample;

public interface CMRoleMenuPermissionMapper {
    int countByExample(CMRoleMenuPermissionExample example);

    int deleteByExample(CMRoleMenuPermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(CMRoleMenuPermission record);

    int insertSelective(CMRoleMenuPermission record);

    List<CMRoleMenuPermission> selectByExample(CMRoleMenuPermissionExample example);

    CMRoleMenuPermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CMRoleMenuPermission record, @Param("example") CMRoleMenuPermissionExample example);

    int updateByExample(@Param("record") CMRoleMenuPermission record, @Param("example") CMRoleMenuPermissionExample example);

    int updateByPrimaryKeySelective(CMRoleMenuPermission record);

    int updateByPrimaryKey(CMRoleMenuPermission record);
}