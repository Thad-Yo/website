package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMDepartmentUser;
import com.website.mybatis.bean.auto.system.CMDepartmentUserExample;

public interface CMDepartmentUserMapper {
    int countByExample(CMDepartmentUserExample example);

    int deleteByExample(CMDepartmentUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CMDepartmentUser record);

    int insertSelective(CMDepartmentUser record);

    List<CMDepartmentUser> selectByExample(CMDepartmentUserExample example);

    CMDepartmentUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CMDepartmentUser record, @Param("example") CMDepartmentUserExample example);

    int updateByExample(@Param("record") CMDepartmentUser record, @Param("example") CMDepartmentUserExample example);

    int updateByPrimaryKeySelective(CMDepartmentUser record);

    int updateByPrimaryKey(CMDepartmentUser record);
}