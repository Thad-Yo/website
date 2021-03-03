package com.website.service.pro;

import java.awt.geom.Area;
import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteFiliale;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.service.BaseService;

public interface FilialeService  extends BaseService{

	ServiceResult<WebsiteFiliale> updateNew(WebsiteFiliale form);
	
	ServiceResult<List<WebsiteFiliale>> getRecordList(WebsiteFiliale form);
	
	WebsiteFiliale getConfigBanner(WebsiteFiliale form);
	
	ServiceResult<WebsiteFiliale> deleteAction(WebsiteFiliale form);
	
	/**
	 * 获取省列表
	 *
	 * @return
	 */
	ServiceResult<List<Area>> getProvince();

	public ServiceResult<List<WebsiteFiliale>> getFilialeProList();

}
