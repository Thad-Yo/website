package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteDevExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteDevMapper {
    int countByExample(WebsiteDevExample example);

    int deleteByExample(WebsiteDevExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteDev record);

    int insertSelective(WebsiteDev record);

    List<WebsiteDev> selectByExample(WebsiteDevExample example);

    WebsiteDev selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteDev record, @Param("example") WebsiteDevExample example);

    int updateByExample(@Param("record") WebsiteDev record, @Param("example") WebsiteDevExample example);

    int updateByPrimaryKeySelective(WebsiteDev record);

    int updateByPrimaryKey(WebsiteDev record);
}