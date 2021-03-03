package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.auto.WebsiteIntroduceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteIntroduceMapper {
    int countByExample(WebsiteIntroduceExample example);

    int deleteByExample(WebsiteIntroduceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteIntroduce record);

    int insertSelective(WebsiteIntroduce record);

    List<WebsiteIntroduce> selectByExampleWithBLOBs(WebsiteIntroduceExample example);

    List<WebsiteIntroduce> selectByExample(WebsiteIntroduceExample example);

    WebsiteIntroduce selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteIntroduce record, @Param("example") WebsiteIntroduceExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteIntroduce record, @Param("example") WebsiteIntroduceExample example);

    int updateByExample(@Param("record") WebsiteIntroduce record, @Param("example") WebsiteIntroduceExample example);

    int updateByPrimaryKeySelective(WebsiteIntroduce record);

    int updateByPrimaryKeyWithBLOBs(WebsiteIntroduce record);
}