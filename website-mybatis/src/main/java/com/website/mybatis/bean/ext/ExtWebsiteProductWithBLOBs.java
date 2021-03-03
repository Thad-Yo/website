package com.website.mybatis.bean.ext;

import java.io.Serializable;

import com.website.mybatis.bean.auto.WebsiteProductWithBLOBs;

public class ExtWebsiteProductWithBLOBs extends WebsiteProductWithBLOBs implements Serializable {
    private String address;
    private String href;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

    
}