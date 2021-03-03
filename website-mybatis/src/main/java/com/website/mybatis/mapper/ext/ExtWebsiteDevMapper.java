package com.website.mybatis.mapper.ext;



import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtWebsiteDevMapper {

	List<WebsiteDev> selectUsList(WebsiteDev form);
	
	WebsiteDev selectByPrimaryKey(String id);
	
	 int updateByPrimaryKey(WebsiteDev record);
	 
	 int insert(WebsiteDev record);
	 
	 int updateEng(WebsiteDev record);
	 
}