package com.website.service.pro;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.auto.WebsiteScope;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.service.BaseService;

public interface AboutUsService  extends BaseService{

	ServiceResult<WebsiteIntroduce> insertNew(WebsiteIntroduce form);
	
	ServiceResult<WebsiteDev> updateDevNew(WebsiteDev form);
	
	ServiceResult<List<WebsiteDev>> getRecordList(WebsiteDev form);
	
	WebsiteDev getConfigBanner(WebsiteDev form);
	
	ServiceResult<WebsiteDev> deleteAction(WebsiteDev form);

	List<WebsiteIntroduce> selectWebsiteIntroduceList();

	List<WebsiteScope> selectWebsiteScopeList();

	List<CTAttachment> selectPartnersPic();

	List<WebsiteDev> selectWebsiteDevList();

	List<WebsiteHonor> selectWebsiteHonorList();
	
	 /**
     * 检查订单类型是否重复
     *
     * @param id
     * @param orderType
     * @return
     */
    ServiceResult<Integer> count(String id,String year);
}
