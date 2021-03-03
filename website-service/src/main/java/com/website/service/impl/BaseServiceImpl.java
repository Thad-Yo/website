package com.website.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.website.common.util.Utils;
import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CMUserExample;
import com.website.web.CustomMapper;

/**
 * Created by Administrator on 2016/8/8.
 */
public class BaseServiceImpl extends CustomMapper {

	/**
	 * 格式化排序
	 *
	 * @param sort
	 * @param order
	 * @return
	 */
	public String formatOrder(String sort, String order) {
		if (StringUtils.isNotBlank(sort)) {
			sort = Utils.camelToUnderline(sort);
			order = StringUtils.isNotBlank(order) ? order : "asc";
			return sort + " " + order;
		}
		return null;
	}

	/**
	 * 获取用户信息
	 * 
	 * @return
	 */
	public ServiceResult<CMUser> getUserByUserId(String userId) {
		if (StringUtils.isBlank(userId)) {
			return null;
		}
		ServiceResult<CMUser> result = new ServiceResult<CMUser>();
		CMUserExample example = new CMUserExample();
		CMUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<CMUser> cmUser = this.cmUserMapper.selectByExample(example);
		if (cmUser != null && cmUser.size() == 1) {
			result.setResult(cmUser.get(0));
			return result;
		} else {
			return null;
		}
	}

}
