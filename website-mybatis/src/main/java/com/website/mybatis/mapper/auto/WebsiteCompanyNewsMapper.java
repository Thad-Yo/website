package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteCompanyNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteCompanyNewsMapper {
    int countByExample(WebsiteCompanyNewsExample example);

    int deleteByExample(WebsiteCompanyNewsExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteCompanyNews record);

    int insertSelective(WebsiteCompanyNews record);

    List<WebsiteCompanyNews> selectByExampleWithBLOBs(WebsiteCompanyNewsExample example);

    List<WebsiteCompanyNews> selectByExample(WebsiteCompanyNewsExample example);

    WebsiteCompanyNews selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteCompanyNews record, @Param("example") WebsiteCompanyNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteCompanyNews record, @Param("example") WebsiteCompanyNewsExample example);

    int updateByExample(@Param("record") WebsiteCompanyNews record, @Param("example") WebsiteCompanyNewsExample example);

    int updateByPrimaryKeySelective(WebsiteCompanyNews record);

    int updateByPrimaryKeyWithBLOBs(WebsiteCompanyNews record);

    int updateByPrimaryKey(WebsiteCompanyNews record);
}