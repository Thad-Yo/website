package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMUserCustom;
import com.website.mybatis.bean.auto.system.CMUserCustomExample;

public interface CMUserCustomMapper {
    int countByExample(CMUserCustomExample example);

    int deleteByExample(CMUserCustomExample example);

    int deleteByPrimaryKey(String id);

    int insert(CMUserCustom record);

    int insertSelective(CMUserCustom record);

    List<CMUserCustom> selectByExample(CMUserCustomExample example);

    CMUserCustom selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CMUserCustom record, @Param("example") CMUserCustomExample example);

    int updateByExample(@Param("record") CMUserCustom record, @Param("example") CMUserCustomExample example);

    int updateByPrimaryKeySelective(CMUserCustom record);

    int updateByPrimaryKey(CMUserCustom record);
}