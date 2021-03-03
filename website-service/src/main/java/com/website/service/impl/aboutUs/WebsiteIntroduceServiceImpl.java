package com.website.service.impl.aboutUs;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.auto.WebsiteIntroduceExample;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.service.aboutUs.WebsiteIntroduceService;
import com.website.service.contactUs.WebsiteFeedbackService;
import com.website.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:35
 * @Description:
 */
@Service
public class WebsiteIntroduceServiceImpl extends BaseServiceImpl implements WebsiteIntroduceService {

    /**
     * 获取意见反馈列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteIntroduce> findIntroduce(WebsiteIntroduce record) {
        ServiceResult<WebsiteIntroduce> result = new ServiceResult<>();
        WebsiteIntroduceExample example = new WebsiteIntroduceExample();
        WebsiteIntroduceExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id Desc");
        example.setLimitStart(0);
        example.setLimitEnd(1);
        List<WebsiteIntroduce> introduceList = websiteIntroduceMapper.selectByExampleWithBLOBs(example);
        if(introduceList.size()>0){
            result.setSuccess(true);
            result.setResult(introduceList.get(0));
        }else{
            result.setSuccess(false);
        }
        return result;
    }
}
