package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteCompanyNewsWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteScope;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:53
 * @Description:
 */
@Data
public class ExtWebsiteScopeModel extends WebsiteScope {
	private String configVisitJson;
}
