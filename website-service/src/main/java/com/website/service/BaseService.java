package com.website.service;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.system.CMUser;

/**
 * Created by Administrator on 2016/8/8.
 */
public interface BaseService {
	ServiceResult<CMUser> getUserByUserId(String userId);
}
