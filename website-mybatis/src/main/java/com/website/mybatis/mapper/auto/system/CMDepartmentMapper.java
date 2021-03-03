package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMDepartmentExample;

public interface CMDepartmentMapper {
    int countByExample(CMDepartmentExample example);

    int deleteByExample(CMDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CMDepartment record);

    int insertSelective(CMDepartment record);

    List<CMDepartment> selectByExample(CMDepartmentExample example);

    CMDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CMDepartment record, @Param("example") CMDepartmentExample example);

    int updateByExample(@Param("record") CMDepartment record, @Param("example") CMDepartmentExample example);

    int updateByPrimaryKeySelective(CMDepartment record);

    int updateByPrimaryKey(CMDepartment record);
}