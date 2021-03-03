package com.website.mybatis.mapper.auto.system;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.website.mybatis.bean.auto.system.CMSequence;
import com.website.mybatis.bean.auto.system.CMSequenceExample;

public interface CMSequenceMapper {
    int countByExample(CMSequenceExample example);

    int deleteByExample(CMSequenceExample example);

    int deleteByPrimaryKey(String name);

    int insert(CMSequence record);

    int insertSelective(CMSequence record);

    List<CMSequence> selectByExample(CMSequenceExample example);

    CMSequence selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") CMSequence record, @Param("example") CMSequenceExample example);

    int updateByExample(@Param("record") CMSequence record, @Param("example") CMSequenceExample example);

    int updateByPrimaryKeySelective(CMSequence record);

    int updateByPrimaryKey(CMSequence record);
}