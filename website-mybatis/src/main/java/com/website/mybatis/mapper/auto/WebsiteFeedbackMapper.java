package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteFeedbackMapper {
    int countByExample(WebsiteFeedbackExample example);

    int deleteByExample(WebsiteFeedbackExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteFeedback record);

    int insertSelective(WebsiteFeedback record);

    List<WebsiteFeedback> selectByExample(WebsiteFeedbackExample example);

    WebsiteFeedback selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteFeedback record, @Param("example") WebsiteFeedbackExample example);

    int updateByExample(@Param("record") WebsiteFeedback record, @Param("example") WebsiteFeedbackExample example);

    int updateByPrimaryKeySelective(WebsiteFeedback record);

    int updateByPrimaryKey(WebsiteFeedback record);
}