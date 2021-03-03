package com.website.service.contactUs;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.service.BaseService;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:33
 * @Description:
 */
public interface WebsiteFeedbackService extends BaseService {

    /**
     * 获取意见反馈列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<ExtWebsiteFeedbackModel>> findFeedbackList(ExtWebsiteFeedbackModel record);
    /**
     * 插入反馈列表
     *
     * @param record
     * @return
     */
    //public ServiceResult<WebsiteFeedback> insertRecord(WebsiteFeedback record);
    /**
     * 添加反馈列表记录
     *
     * @param
     * @return
     */
    public ServiceResult<WebsiteFeedback> insertAdvice(WebsiteFeedback form);

}
