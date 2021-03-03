package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMUserRole;
import com.website.mybatis.bean.auto.system.CMUserRoleExample;
import com.website.mybatis.bean.auto.system.CMUserRoleKey;

public interface CMUserRoleMapper {
    int countByExample(CMUserRoleExample example);

    int deleteByExample(CMUserRoleExample example);

    int deleteByPrimaryKey(CMUserRoleKey key);

    int insert(CMUserRole record);

    int insertSelective(CMUserRole record);

    List<CMUserRole> selectByExample(CMUserRoleExample example);

    CMUserRole selectByPrimaryKey(CMUserRoleKey key);

    int updateByExampleSelective(@Param("record") CMUserRole record, @Param("example") CMUserRoleExample example);

    int updateByExample(@Param("record") CMUserRole record, @Param("example") CMUserRoleExample example);

    int updateByPrimaryKeySelective(CMUserRole record);

    int updateByPrimaryKey(CMUserRole record);
}