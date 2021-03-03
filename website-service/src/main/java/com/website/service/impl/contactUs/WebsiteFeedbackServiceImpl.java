package com.website.service.impl.contactUs;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteConfigPosition;
import com.website.mybatis.bean.auto.WebsiteConfigPositionExample;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteFeedbackExample;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.service.contactUs.WebsiteFeedbackService;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.recruit.WebsiteConfigPositionService;
import org.apache.commons.lang3.StringUtils;
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
public class WebsiteFeedbackServiceImpl extends BaseServiceImpl implements WebsiteFeedbackService {

    /**
     * 获取意见反馈列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<ExtWebsiteFeedbackModel>> findFeedbackList(ExtWebsiteFeedbackModel record) {
        ServiceResult<List<ExtWebsiteFeedbackModel>> result = new ServiceResult<>();
        record.setOrderByClause("feedback_time Desc");
        List<ExtWebsiteFeedbackModel> list = this.extWebsiteFeedbackMapper.findWebsiteFeedbackList(record);

        result.setResult(list);
        result.setSuccess(true);
        return result;
    }
    @Override
    public ServiceResult<WebsiteFeedback> insertAdvice(WebsiteFeedback form) {
        ServiceResult<WebsiteFeedback> result = new ServiceResult<WebsiteFeedback>();
        String feedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String nowDate = DateUtils.getNowServerDateTime();
        form.setFeedbackTime(feedDate);
        String id = UUID.randomUUID().toString();
        form.setId(id);
        try {
            this.websiteFeedbackMapper.insertSelective(form);
            result.setSuccess(true);
            result.setMessage("保存成功");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("保存失败");
            return result;
        }
    }
}
