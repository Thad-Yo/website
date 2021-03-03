package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteCommunity;
import com.website.mybatis.bean.auto.WebsiteCommunityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteCommunityMapper {
    int countByExample(WebsiteCommunityExample example);

    int deleteByExample(WebsiteCommunityExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteCommunity record);

    int insertSelective(WebsiteCommunity record);

    List<WebsiteCommunity> selectByExampleWithBLOBs(WebsiteCommunityExample example);

    List<WebsiteCommunity> selectByExample(WebsiteCommunityExample example);

    WebsiteCommunity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteCommunity record, @Param("example") WebsiteCommunityExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteCommunity record, @Param("example") WebsiteCommunityExample example);

    int updateByExample(@Param("record") WebsiteCommunity record, @Param("example") WebsiteCommunityExample example);

    int updateByPrimaryKeySelective(WebsiteCommunity record);

    int updateByPrimaryKeyWithBLOBs(WebsiteCommunity record);

    int updateByPrimaryKey(WebsiteCommunity record);
}