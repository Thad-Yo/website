package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteConfigPosition;
import com.website.mybatis.bean.auto.WebsiteConfigPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteConfigPositionMapper {
    int countByExample(WebsiteConfigPositionExample example);

    int deleteByExample(WebsiteConfigPositionExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteConfigPosition record);

    int insertSelective(WebsiteConfigPosition record);

    List<WebsiteConfigPosition> selectByExample(WebsiteConfigPositionExample example);

    WebsiteConfigPosition selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteConfigPosition record, @Param("example") WebsiteConfigPositionExample example);

    int updateByExample(@Param("record") WebsiteConfigPosition record, @Param("example") WebsiteConfigPositionExample example);

    int updateByPrimaryKeySelective(WebsiteConfigPosition record);

    int updateByPrimaryKey(WebsiteConfigPosition record);
}