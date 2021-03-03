package com.website.web;

import com.website.mybatis.mapper.ext.*;
import com.website.mybatis.mapper.ext.system.ExtDepartmentMapper;
import com.website.mybatis.mapper.ext.system.ExtMenuMapper;
import com.website.mybatis.mapper.ext.system.ExtPermissionMapper;
import com.website.mybatis.mapper.ext.system.ExtUserMapper;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomMapper extends AutoMapper {

	@Autowired
	protected ExtMenuMapper extMenuMapper;

	@Autowired
	protected ExtPermissionMapper extPermissionMapper;

	@Autowired
	protected ExtDepartmentMapper extDepartmentMapper;

	@Autowired
	protected ExtUserMapper extUserMapper;
	
	@Autowired
	protected ExtHomePageMapper extHomePageMapper;

	@Autowired
	protected ExtWebsiteCompanyNewsMapper extWebsiteCompanyNewsMapper;

	@Autowired
	protected ExtWebsiteDonationInstanceMapper extWebsiteDonationInstanceMapper;

	@Autowired
	protected ExtWebsiteFeedbackMapper extWebsiteFeedbackMapper;

	@Autowired
	protected ExtCMDepartmentPositionMapper extCMDepartmentPositionMapper;

	@Autowired
	protected ExtHrConfigPositionTypeMapper extHrConfigPositionTypeMapper;

	@Autowired
	protected ExtWebsiteRecruitPositionMapper extWebsiteRecruitPositionMapper;
}
