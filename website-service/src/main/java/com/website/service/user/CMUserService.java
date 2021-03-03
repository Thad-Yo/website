/*
 * Copyright(c) 2012-2017 JD Pharma.Ltd. All Rights Reserved.
 * 
 */
package com.website.service.user;

import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.BaseService;

/**
 * 此处为类说明
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月20日
 * @see 上午10:49:31
 */
public interface CMUserService extends BaseService {

	int updateCMUserByPrimaryKeySelective(CMUser user);

	CMUser getCMUserByUnpw(String username, String password);

}
