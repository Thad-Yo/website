package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteRecruitPosition;
import lombok.Data;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:53
 * @Description:
 */
@Data
public class ExtWebsiteRecruitPositionModel extends WebsiteRecruitPosition {
    private List cityList;
}
