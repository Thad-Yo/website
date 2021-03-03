package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.WebsiteIndustryWithBLOBs;

public class ExtWebsiteIndustryWithBLOBsModel extends WebsiteIndustryWithBLOBs{

	private String imgUrl;
	private String industryName;
	private String industryInfo;
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getIndustryInfo() {
		return industryInfo;
	}
	public void setIndustryInfo(String industryInfo) {
		this.industryInfo = industryInfo;
	}
}
