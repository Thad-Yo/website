package com.website.mybatis.mapper.ext;

import com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:56
 * @Description:
 */
public interface ExtWebsiteCompanyNewsMapper {

    List<ExtWebsiteCompanyNewsModel> findNewsList(ExtWebsiteCompanyNewsModel record);
}
