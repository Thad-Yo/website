package com.website.service.culture;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteOurStaff;
import com.website.service.BaseService;

public interface WebsiteOurStaffService extends BaseService {
	/**
	 * 我们的员工列表查询
	 * @param form
	 * @return
	 */
	ServiceResult<List<WebsiteOurStaff>> findOurStaffList(WebsiteOurStaff form);
	/**
	 * 详情
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteOurStaff> getStaffRecord(WebsiteOurStaff form);
	/**
	 * 插入数据
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteOurStaff> insertRecord(WebsiteOurStaff form);
	/**
	 * 修改数据
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteOurStaff> updateRecord(WebsiteOurStaff form);
	/**
	 * 删除数据
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteOurStaff> removeRecord(String id);
}
