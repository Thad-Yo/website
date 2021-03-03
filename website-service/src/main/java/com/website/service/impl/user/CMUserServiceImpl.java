/*
 * Copyright(c) 2012-2017 JD Pharma.Ltd. All Rights Reserved.
 * 
 */
package com.website.service.impl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CMUserExample;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.user.CMUserService;

/**
 * 此处为类说明
 * 
 * @author renxingchen
 * @version website 1.0
 * @since website 1.0 2017年4月20日
 * @see 上午10:53:04
 */
@Service
public class CMUserServiceImpl extends BaseServiceImpl implements CMUserService {

	/**
	 * 
	 * 更新用户
	 * 
	 * @author renxingchen
	 * @param user
	 * @return
	 * @see com.website.service.user.CMUserService#updateCMUserByPrimaryKeySelective(com.website.mybatis.bean.auto.system.CMUser)
	 */
	@Override
	public int updateCMUserByPrimaryKeySelective(CMUser user) {
		return cmUserMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 
	 * 根据用户名密码获取用户
	 * 
	 * @author renxingchen
	 * @param username
	 * @param password
	 * @return
	 * @see com.website.service.user.CMUserService#getCMUserByUnpw(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public CMUser getCMUserByUnpw(String username, String password) {
		CMUserExample example = new CMUserExample();
		example.createCriteria().andUserNameEqualTo(username).andPasswordEqualTo(password);
		List<CMUser> users = cmUserMapper.selectByExample(example);
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
