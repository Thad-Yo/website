package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMName;
import com.website.mybatis.bean.auto.system.CMNameExample;

public interface CMNameMapper {
    int countByExample(CMNameExample example);

    int deleteByExample(CMNameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CMName record);

    int insertSelective(CMName record);

    List<CMName> selectByExample(CMNameExample example);

    CMName selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CMName record, @Param("example") CMNameExample example);

    int updateByExample(@Param("record") CMName record, @Param("example") CMNameExample example);

    int updateByPrimaryKeySelective(CMName record);

    int updateByPrimaryKey(CMName record);
}