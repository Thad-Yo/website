package com.website.mybatis.mapper.ext;



import com.website.mybatis.bean.auto.WebsiteFiliale;

import java.awt.geom.Area;
import java.util.List;

public interface ExtWebsiteFilialeMapper {

	List<WebsiteFiliale> selectUsList(WebsiteFiliale form);
	
	WebsiteFiliale selectByPrimaryKey(String id);
	
	 int insert(WebsiteFiliale record);
	 
	 int updateByPrimaryKey(WebsiteFiliale record);
	 
	 int updateEng(WebsiteFiliale record);
	 
	 /**
	     * 获取省
	     *
	     * @return
	     */
	    List<Area> findProvinceList();

	List<WebsiteFiliale> getFilialeProList();

}