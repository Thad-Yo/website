package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteIndustry;
import com.website.mybatis.bean.auto.WebsiteIndustryExample;
import com.website.mybatis.bean.auto.WebsiteIndustryWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteIndustryMapper {
    int countByExample(WebsiteIndustryExample example);

    int deleteByExample(WebsiteIndustryExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteIndustryWithBLOBs record);

    int insertSelective(WebsiteIndustryWithBLOBs record);

    List<WebsiteIndustryWithBLOBs> selectByExampleWithBLOBs(WebsiteIndustryExample example);

    List<WebsiteIndustry> selectByExample(WebsiteIndustryExample example);

    WebsiteIndustryWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteIndustryWithBLOBs record, @Param("example") WebsiteIndustryExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteIndustryWithBLOBs record, @Param("example") WebsiteIndustryExample example);

    int updateByExample(@Param("record") WebsiteIndustry record, @Param("example") WebsiteIndustryExample example);

    int updateByPrimaryKeySelective(WebsiteIndustryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WebsiteIndustryWithBLOBs record);

    int updateByPrimaryKey(WebsiteIndustry record);
}