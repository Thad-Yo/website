package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.HrConfigPosition;
import com.website.mybatis.bean.auto.HrConfigPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HrConfigPositionMapper {
    int countByExample(HrConfigPositionExample example);

    int deleteByExample(HrConfigPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HrConfigPosition record);

    int insertSelective(HrConfigPosition record);

    List<HrConfigPosition> selectByExample(HrConfigPositionExample example);

    HrConfigPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HrConfigPosition record, @Param("example") HrConfigPositionExample example);

    int updateByExample(@Param("record") HrConfigPosition record, @Param("example") HrConfigPositionExample example);

    int updateByPrimaryKeySelective(HrConfigPosition record);

    int updateByPrimaryKey(HrConfigPosition record);
}