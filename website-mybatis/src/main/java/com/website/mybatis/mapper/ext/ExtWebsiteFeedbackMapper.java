package com.website.mybatis.mapper.ext;

import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 14:57
 * @Description:
 */
public interface ExtWebsiteFeedbackMapper {
    List<ExtWebsiteFeedbackModel> findWebsiteFeedbackList(ExtWebsiteFeedbackModel record);
}
