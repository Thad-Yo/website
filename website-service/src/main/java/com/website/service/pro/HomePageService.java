package com.website.service.pro;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteBasic;
import com.website.mybatis.bean.auto.WebsiteBasicWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.service.BaseService;


/**
 * Created by HomePageService on 2018/5/18.
 */
public interface HomePageService extends BaseService {

	ServiceResult<ExtWebsiteConfigBannerModel> insertRecord(ExtWebsiteConfigBannerModel form);
	
	ServiceResult<List<ExtWebsiteConfigBannerModel>> getRecordList(ExtWebsiteConfigBannerModel form);

	WebsiteConfigBanner getConfigBanner(ExtWebsiteConfigBannerModel form);

	ServiceResult<ExtWebsiteConfigBannerModel> updateIssue(ExtWebsiteConfigBannerModel form);

	ServiceResult<ExtWebsiteConfigBannerModel> deleteAction(ExtWebsiteConfigBannerModel form);
	
	ServiceResult<WebsiteBasicWithBLOBs> insertBasic(WebsiteBasicWithBLOBs form);
	
	WebsiteBasicWithBLOBs select(String id);

}
