package com.website.mybatis.mapper.ext;



import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtWebsiteHonorMapper {

	List<WebsiteHonor> selectUsList(WebsiteHonor form);
	
	WebsiteHonor selectByPrimaryKey(String id);
	
	 int insert(WebsiteHonor record);
	 
	 int updateByPrimaryKey(WebsiteHonor record);
	 
	 int updateEng(WebsiteHonor record);


}