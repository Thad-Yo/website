package com.website.web;

import com.website.mybatis.bean.auto.WebsiteConfigPosition;
import com.website.mybatis.bean.auto.WebsiteDonationInstance;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteProduct;
import com.website.mybatis.mapper.auto.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.website.mybatis.mapper.auto.system.CMDepartmentMapper;
import com.website.mybatis.mapper.auto.system.CMDepartmentUserMapper;
import com.website.mybatis.mapper.auto.system.CMMenuMapper;
import com.website.mybatis.mapper.auto.system.CMMenuPermissionMapper;
import com.website.mybatis.mapper.auto.system.CMNameMapper;
import com.website.mybatis.mapper.auto.system.CMRoleMapper;
import com.website.mybatis.mapper.auto.system.CMRoleMenuPermissionMapper;
import com.website.mybatis.mapper.auto.system.CMUserCustomMapper;
import com.website.mybatis.mapper.auto.system.CMUserMapper;
import com.website.mybatis.mapper.auto.system.CMUserRoleMapper;
import com.website.mybatis.mapper.auto.system.CTAttachmentMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteBasicMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteDevMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteFilialeMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteHonorMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteIntroduceMapper;

public class AutoMapper {
	/*********************************** 框架基础配置 勿动 开始 ***********************************/
	@Autowired
	protected CMMenuMapper cmMenuMapper;

	@Autowired
	protected CMMenuPermissionMapper cmMenuPermissionMapper;

	@Autowired
	protected CMNameMapper cmNameMapper;

	@Autowired
	protected CMRoleMapper cmRoleMapper;

	@Autowired
	protected CMRoleMenuPermissionMapper cmRoleMenuPermissionMapper;

	@Autowired
	protected CMUserMapper cmUserMapper;

	@Autowired
	protected CMUserRoleMapper cmUserRoleMapper;

	@Autowired
	protected CMDepartmentMapper cmDepartmentMapper;

	@Autowired
	protected CMDepartmentUserMapper cmDepartmentUserMapper;

	@Autowired
	protected CTAttachmentMapper ctAttachmentMapper;

	@Autowired
	protected CMUserCustomMapper cmUserCustomMapper;
	/*********************************** 框架基础配置 勿动 结束 ***********************************/
	
	@Autowired
	protected WebsiteConfigBannerMapper websiteConfigBannerMapper;
	@Autowired
	protected WebsiteCompanyNewsMapper websiteCompanyNewsMapper;
	@Autowired
	protected WebsiteDonationInstanceMapper websiteDonationInstanceMapper;
	@Autowired
	protected WebsiteIntroduceMapper websiteIntroduceMapper;
	@Autowired
	protected ExtWebsiteIntroduceMapper extWebsiteIntroduceMapper;
	@Autowired
	protected WebsiteDevMapper websiteDevMapper;
	@Autowired
	protected ExtWebsiteDevMapper extWebsiteDevMapper;
	@Autowired
	protected WebsiteHonorMapper websiteHonorMapper;
	@Autowired
	protected ExtWebsiteHonorMapper extWebsiteHonorMapper;
	@Autowired
	protected WebsiteIndustryMapper websiteIndustryMapper;
	@Autowired
	protected WebsiteConfigPositionMapper websiteConfigPositionMapper;
	@Autowired
	protected WebsiteFeedbackMapper websiteFeedbackMapper;
	@Autowired
	protected WebsiteRecruitPositionMapper websiteRecruitPositionMapper;
	@Autowired
	protected ExtWebsiteFilialeMapper extWebsiteFilialeMapper;
	@Autowired
	protected WebsiteFilialeMapper websiteFilialeMapper;
	@Autowired
	protected WebsiteScopeMapper websiteScopeMapper;
	@Autowired
	protected HrConfigPositionMapper hrConfigPositionMapper;
	@Autowired
	protected ExtWebsiteBasicMapper extWebsiteBasicMapper;
	@Autowired
	protected CMDepartmentPositionMapper cmDepartmentPositionMapper;
	@Autowired
	protected WebsiteProductMapper websiteProductMapper;
	@Autowired
	protected HrResumeBasicMapper hrResumeBasicMapper;
	@Autowired
	protected WebsiteConsultMapper websiteConsultMapper;
	@Autowired
	protected WebsiteShortIntroduceMapper websiteShortIntroduceMapper;
	@Autowired
	protected WebsiteCultureMapper websiteCultureMapper;
	@Autowired
	protected WebsiteCultureTypeMapper websiteCultureTypeMapper;
	@Autowired
	protected WebsiteOurStaffMapper websiteOurStaffMapper;
	@Autowired
	protected WebsiteCommunityMapper websiteCommunityMapper;
}
