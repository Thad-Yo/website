package com.website.mybatis.mapper.ext;

import java.util.List;

import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;

public interface ExtHomePageMapper {

	List<ExtWebsiteConfigBannerModel> selectBannerList(ExtWebsiteConfigBannerModel form);
}