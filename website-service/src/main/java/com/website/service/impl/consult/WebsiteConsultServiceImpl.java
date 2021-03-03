package com.website.service.impl.consult;

import java.util.List;

import org.springframework.stereotype.Service;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteConsult;
import com.website.mybatis.bean.auto.WebsiteConsultExample;
import com.website.service.consult.WebsiteConsultService;
import com.website.service.impl.BaseServiceImpl;

@Service
public class WebsiteConsultServiceImpl extends BaseServiceImpl implements WebsiteConsultService{
	/**
	 * 获取免费咨询表
	 */
	@Override
	public ServiceResult<List<WebsiteConsult>> findConsultList(WebsiteConsult form) {
		ServiceResult<List<WebsiteConsult>> result = new ServiceResult<>();
		WebsiteConsultExample example = new WebsiteConsultExample();
		example.setOrderByClause(" consult_time desc ");
		List<WebsiteConsult> list =  websiteConsultMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			result.setResult(list);
		}
		return result;
	}

}
