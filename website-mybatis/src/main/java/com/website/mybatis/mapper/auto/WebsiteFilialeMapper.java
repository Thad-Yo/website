package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteFiliale;
import com.website.mybatis.bean.auto.WebsiteFilialeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteFilialeMapper {
    int countByExample(WebsiteFilialeExample example);

    int deleteByExample(WebsiteFilialeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteFiliale record);

    int insertSelective(WebsiteFiliale record);

    List<WebsiteFiliale> selectByExample(WebsiteFilialeExample example);

    WebsiteFiliale selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteFiliale record, @Param("example") WebsiteFilialeExample example);

    int updateByExample(@Param("record") WebsiteFiliale record, @Param("example") WebsiteFilialeExample example);

    int updateByPrimaryKeySelective(WebsiteFiliale record);

    int updateByPrimaryKey(WebsiteFiliale record);
}