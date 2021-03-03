package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteRecruitPosition;
import com.website.mybatis.bean.auto.WebsiteRecruitPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteRecruitPositionMapper {
    int countByExample(WebsiteRecruitPositionExample example);

    int deleteByExample(WebsiteRecruitPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteRecruitPosition record);

    int insertSelective(WebsiteRecruitPosition record);

    List<WebsiteRecruitPosition> selectByExampleWithBLOBs(WebsiteRecruitPositionExample example);

    List<WebsiteRecruitPosition> selectByExample(WebsiteRecruitPositionExample example);

    WebsiteRecruitPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteRecruitPosition record, @Param("example") WebsiteRecruitPositionExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteRecruitPosition record, @Param("example") WebsiteRecruitPositionExample example);

    int updateByExample(@Param("record") WebsiteRecruitPosition record, @Param("example") WebsiteRecruitPositionExample example);

    int updateByPrimaryKeySelective(WebsiteRecruitPosition record);

    int updateByPrimaryKeyWithBLOBs(WebsiteRecruitPosition record);

    int updateByPrimaryKey(WebsiteRecruitPosition record);
}