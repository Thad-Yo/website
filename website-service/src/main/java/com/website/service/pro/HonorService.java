package com.website.service.pro;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.service.BaseService;

public interface HonorService  extends BaseService{

	ServiceResult<WebsiteHonor> updateNew(WebsiteHonor form);
	
	ServiceResult<List<WebsiteHonor>> getRecordList(WebsiteHonor form);
	
	WebsiteHonor getConfigBanner(WebsiteHonor form);
	
	ServiceResult<WebsiteHonor> deleteAction(WebsiteHonor form);
}
