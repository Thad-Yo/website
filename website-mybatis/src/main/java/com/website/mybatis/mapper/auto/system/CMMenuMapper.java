package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMMenu;
import com.website.mybatis.bean.auto.system.CMMenuExample;

public interface CMMenuMapper {
    int countByExample(CMMenuExample example);

    int deleteByExample(CMMenuExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(CMMenu record);

    int insertSelective(CMMenu record);

    List<CMMenu> selectByExample(CMMenuExample example);

    CMMenu selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") CMMenu record, @Param("example") CMMenuExample example);

    int updateByExample(@Param("record") CMMenu record, @Param("example") CMMenuExample example);

    int updateByPrimaryKeySelective(CMMenu record);

    int updateByPrimaryKey(CMMenu record);
}