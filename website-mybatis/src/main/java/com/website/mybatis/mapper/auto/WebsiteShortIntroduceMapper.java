package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteShortIntroduce;
import com.website.mybatis.bean.auto.WebsiteShortIntroduceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteShortIntroduceMapper {
    int countByExample(WebsiteShortIntroduceExample example);

    int deleteByExample(WebsiteShortIntroduceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteShortIntroduce record);

    int insertSelective(WebsiteShortIntroduce record);

    List<WebsiteShortIntroduce> selectByExample(WebsiteShortIntroduceExample example);

    WebsiteShortIntroduce selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteShortIntroduce record, @Param("example") WebsiteShortIntroduceExample example);

    int updateByExample(@Param("record") WebsiteShortIntroduce record, @Param("example") WebsiteShortIntroduceExample example);

    int updateByPrimaryKeySelective(WebsiteShortIntroduce record);

    int updateByPrimaryKey(WebsiteShortIntroduce record);
}