package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteDonationInstance;
import lombok.Data;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:53
 * @Description:
 */
@Data
public class ExtWebsiteDonationInstanceModel extends WebsiteDonationInstance{
    private String showMonth;
    private String showDay;
    private String proType;
    private String yqType;
}
