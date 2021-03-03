package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.HrConfigPositionType;
import com.website.mybatis.bean.auto.HrConfigPositionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HrConfigPositionTypeMapper {
    int countByExample(HrConfigPositionTypeExample example);

    int deleteByExample(HrConfigPositionTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HrConfigPositionType record);

    int insertSelective(HrConfigPositionType record);

    List<HrConfigPositionType> selectByExample(HrConfigPositionTypeExample example);

    HrConfigPositionType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HrConfigPositionType record, @Param("example") HrConfigPositionTypeExample example);

    int updateByExample(@Param("record") HrConfigPositionType record, @Param("example") HrConfigPositionTypeExample example);

    int updateByPrimaryKeySelective(HrConfigPositionType record);

    int updateByPrimaryKey(HrConfigPositionType record);
}