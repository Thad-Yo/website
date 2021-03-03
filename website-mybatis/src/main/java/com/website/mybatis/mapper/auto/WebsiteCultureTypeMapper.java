package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteCultureType;
import com.website.mybatis.bean.auto.WebsiteCultureTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteCultureTypeMapper {
    int countByExample(WebsiteCultureTypeExample example);

    int deleteByExample(WebsiteCultureTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteCultureType record);

    int insertSelective(WebsiteCultureType record);

    List<WebsiteCultureType> selectByExample(WebsiteCultureTypeExample example);

    WebsiteCultureType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteCultureType record, @Param("example") WebsiteCultureTypeExample example);

    int updateByExample(@Param("record") WebsiteCultureType record, @Param("example") WebsiteCultureTypeExample example);

    int updateByPrimaryKeySelective(WebsiteCultureType record);

    int updateByPrimaryKey(WebsiteCultureType record);
}