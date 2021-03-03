package com.website.mybatis.mapper.ext;

import java.util.List;

import com.website.mybatis.bean.auto.WebsiteScope;

public interface ExtWebsiteScopeMapper {
	
	List<WebsiteScope> selectByPrimaryKey(Integer id);
	
	int delete(Integer id);
	
}