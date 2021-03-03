package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.CMDepartmentPosition;
import com.website.mybatis.bean.auto.CMDepartmentPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CMDepartmentPositionMapper {
    int countByExample(CMDepartmentPositionExample example);

    int deleteByExample(CMDepartmentPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CMDepartmentPosition record);

    int insertSelective(CMDepartmentPosition record);

    List<CMDepartmentPosition> selectByExample(CMDepartmentPositionExample example);

    CMDepartmentPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CMDepartmentPosition record, @Param("example") CMDepartmentPositionExample example);

    int updateByExample(@Param("record") CMDepartmentPosition record, @Param("example") CMDepartmentPositionExample example);

    int updateByPrimaryKeySelective(CMDepartmentPosition record);

    int updateByPrimaryKey(CMDepartmentPosition record);
}