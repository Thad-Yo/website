package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteCompanyNewsWithBLOBs;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:53
 * @Description:
 */
@Data
public class ExtWebsiteCompanyNewsModel extends WebsiteCompanyNewsWithBLOBs {
    private String showDay;
    private String showMonth;
}
