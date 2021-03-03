package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMMenuPermission;
import com.website.mybatis.bean.auto.system.CMMenuPermissionExample;

public interface CMMenuPermissionMapper {
    int countByExample(CMMenuPermissionExample example);

    int deleteByExample(CMMenuPermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(CMMenuPermission record);

    int insertSelective(CMMenuPermission record);

    List<CMMenuPermission> selectByExample(CMMenuPermissionExample example);

    CMMenuPermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CMMenuPermission record, @Param("example") CMMenuPermissionExample example);

    int updateByExample(@Param("record") CMMenuPermission record, @Param("example") CMMenuPermissionExample example);

    int updateByPrimaryKeySelective(CMMenuPermission record);

    int updateByPrimaryKey(CMMenuPermission record);
}