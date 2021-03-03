package com.website.service.industry;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteIndustryExample;
import com.website.mybatis.bean.auto.WebsiteIndustryWithBLOBs;
import com.website.mybatis.bean.ext.ExtWebsiteIndustryWithBLOBsModel;

public interface IndustryService {


    ServiceResult<JSONObject> deleteByPrimaryKey(String id);

    List<WebsiteIndustryWithBLOBs> selectByExampleWithBLOBs(WebsiteIndustryExample example);

    WebsiteIndustryWithBLOBs selectByPrimaryKey(String id);

	ServiceResult<JSONObject> saveWebsiteIndustry(ExtWebsiteIndustryWithBLOBsModel form);

}
