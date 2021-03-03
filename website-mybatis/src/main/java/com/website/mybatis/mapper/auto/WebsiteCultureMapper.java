package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteCulture;
import com.website.mybatis.bean.auto.WebsiteCultureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteCultureMapper {
    int countByExample(WebsiteCultureExample example);

    int deleteByExample(WebsiteCultureExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteCulture record);

    int insertSelective(WebsiteCulture record);

    List<WebsiteCulture> selectByExampleWithBLOBs(WebsiteCultureExample example);

    List<WebsiteCulture> selectByExample(WebsiteCultureExample example);

    WebsiteCulture selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteCulture record, @Param("example") WebsiteCultureExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteCulture record, @Param("example") WebsiteCultureExample example);

    int updateByExample(@Param("record") WebsiteCulture record, @Param("example") WebsiteCultureExample example);

    int updateByPrimaryKeySelective(WebsiteCulture record);

    int updateByPrimaryKeyWithBLOBs(WebsiteCulture record);

    int updateByPrimaryKey(WebsiteCulture record);
}