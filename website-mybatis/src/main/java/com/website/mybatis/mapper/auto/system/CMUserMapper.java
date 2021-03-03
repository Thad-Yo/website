package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CMUserExample;

public interface CMUserMapper {
    int countByExample(CMUserExample example);

    int deleteByExample(CMUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(CMUser record);

    int insertSelective(CMUser record);

    List<CMUser> selectByExample(CMUserExample example);

    CMUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") CMUser record, @Param("example") CMUserExample example);

    int updateByExample(@Param("record") CMUser record, @Param("example") CMUserExample example);

    int updateByPrimaryKeySelective(CMUser record);

    int updateByPrimaryKey(CMUser record);
}