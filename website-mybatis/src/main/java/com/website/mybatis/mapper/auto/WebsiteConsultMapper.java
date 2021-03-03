package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteConsult;
import com.website.mybatis.bean.auto.WebsiteConsultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteConsultMapper {
    int countByExample(WebsiteConsultExample example);

    int deleteByExample(WebsiteConsultExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteConsult record);

    int insertSelective(WebsiteConsult record);

    List<WebsiteConsult> selectByExample(WebsiteConsultExample example);

    WebsiteConsult selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteConsult record, @Param("example") WebsiteConsultExample example);

    int updateByExample(@Param("record") WebsiteConsult record, @Param("example") WebsiteConsultExample example);

    int updateByPrimaryKeySelective(WebsiteConsult record);

    int updateByPrimaryKey(WebsiteConsult record);
}