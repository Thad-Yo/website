package com.website.service.culture;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteCommunity;
import com.website.service.BaseService;

public interface ComunityService extends BaseService {
	/**
	 * 社区列表查询
	 * @param form
	 * @return
	 */
	ServiceResult<List<WebsiteCommunity>> findComunityList(WebsiteCommunity form);
	/**
	 * 详情
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteCommunity> getComunityRecord(WebsiteCommunity form);
	/**
	 * 插入数据
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteCommunity> insertRecord(WebsiteCommunity form);
	/**
	 * 修改数据
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteCommunity> updateRecord(WebsiteCommunity form);
	/**
	 * 删除数据
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteCommunity> removeRecord(String id);

}
