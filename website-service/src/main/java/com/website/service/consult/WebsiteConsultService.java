package com.website.service.consult;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteConsult;
import com.website.service.BaseService;

public interface WebsiteConsultService extends BaseService{

	ServiceResult<List<WebsiteConsult>> findConsultList(WebsiteConsult form);

}
