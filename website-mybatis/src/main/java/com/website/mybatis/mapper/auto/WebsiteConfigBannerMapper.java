package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteConfigBannerExample;
import com.website.mybatis.bean.auto.WebsiteConfigBannerWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteConfigBannerMapper {
    int countByExample(WebsiteConfigBannerExample example);

    int deleteByExample(WebsiteConfigBannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteConfigBannerWithBLOBs record);

    int insertSelective(WebsiteConfigBannerWithBLOBs record);

    List<WebsiteConfigBannerWithBLOBs> selectByExampleWithBLOBs(WebsiteConfigBannerExample example);

    List<WebsiteConfigBanner> selectByExample(WebsiteConfigBannerExample example);

    WebsiteConfigBannerWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteConfigBannerWithBLOBs record, @Param("example") WebsiteConfigBannerExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteConfigBannerWithBLOBs record, @Param("example") WebsiteConfigBannerExample example);

    int updateByExample(@Param("record") WebsiteConfigBanner record, @Param("example") WebsiteConfigBannerExample example);

    int updateByPrimaryKeySelective(WebsiteConfigBannerWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WebsiteConfigBannerWithBLOBs record);

    int updateByPrimaryKey(WebsiteConfigBanner record);
}