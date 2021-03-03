package com.website.service.aboutUs;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.service.BaseService;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:33
 * @Description:
 */
public interface WebsiteIntroduceService extends BaseService {

    /**
     * 企业介绍
     * @param record
     * @return
     */
    public ServiceResult<WebsiteIntroduce> findIntroduce(WebsiteIntroduce record);

}
