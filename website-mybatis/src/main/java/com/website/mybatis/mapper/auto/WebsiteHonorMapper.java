package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteHonorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteHonorMapper {
    int countByExample(WebsiteHonorExample example);

    int deleteByExample(WebsiteHonorExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteHonor record);

    int insertSelective(WebsiteHonor record);

    List<WebsiteHonor> selectByExample(WebsiteHonorExample example);

    WebsiteHonor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteHonor record, @Param("example") WebsiteHonorExample example);

    int updateByExample(@Param("record") WebsiteHonor record, @Param("example") WebsiteHonorExample example);

    int updateByPrimaryKeySelective(WebsiteHonor record);

    int updateByPrimaryKey(WebsiteHonor record);
}