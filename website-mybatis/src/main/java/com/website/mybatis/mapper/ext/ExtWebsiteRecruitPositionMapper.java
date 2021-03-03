package com.website.mybatis.mapper.ext;

import com.website.mybatis.bean.auto.WebsiteRecruitPosition;
import com.website.mybatis.bean.ext.ExtWebsiteFeedbackModel;
import com.website.mybatis.bean.ext.ExtWebsiteRecruitPositionModel;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 14:57
 * @Description:
 */
public interface ExtWebsiteRecruitPositionMapper {
    List<WebsiteRecruitPosition> findRecruitPositinList(ExtWebsiteRecruitPositionModel record);


    List<WebsiteRecruitPosition> findProvinceList(ExtWebsiteRecruitPositionModel record);
}
