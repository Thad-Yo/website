package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.HrResumeBasic;
import com.website.mybatis.bean.auto.HrResumeBasicExample;
import com.website.mybatis.bean.auto.HrResumeBasicWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HrResumeBasicMapper {
    int countByExample(HrResumeBasicExample example);

    int deleteByExample(HrResumeBasicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HrResumeBasicWithBLOBs record);

    int insertSelective(HrResumeBasicWithBLOBs record);

    List<HrResumeBasicWithBLOBs> selectByExampleWithBLOBs(HrResumeBasicExample example);

    List<HrResumeBasic> selectByExample(HrResumeBasicExample example);

    HrResumeBasicWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HrResumeBasicWithBLOBs record, @Param("example") HrResumeBasicExample example);

    int updateByExampleWithBLOBs(@Param("record") HrResumeBasicWithBLOBs record, @Param("example") HrResumeBasicExample example);

    int updateByExample(@Param("record") HrResumeBasic record, @Param("example") HrResumeBasicExample example);

    int updateByPrimaryKeySelective(HrResumeBasicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HrResumeBasicWithBLOBs record);

    int updateByPrimaryKey(HrResumeBasic record);
}