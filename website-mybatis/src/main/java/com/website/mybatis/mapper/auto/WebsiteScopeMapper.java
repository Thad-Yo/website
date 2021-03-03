package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteScope;
import com.website.mybatis.bean.auto.WebsiteScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteScopeMapper {
    int countByExample(WebsiteScopeExample example);

    int deleteByExample(WebsiteScopeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteScope record);

    int insertSelective(WebsiteScope record);

    List<WebsiteScope> selectByExample(WebsiteScopeExample example);

    WebsiteScope selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteScope record, @Param("example") WebsiteScopeExample example);

    int updateByExample(@Param("record") WebsiteScope record, @Param("example") WebsiteScopeExample example);

    int updateByPrimaryKeySelective(WebsiteScope record);

    int updateByPrimaryKey(WebsiteScope record);
}