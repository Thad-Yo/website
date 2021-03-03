package com.website.service.culture;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteCultureType;
import com.website.service.BaseService;

/**
 * @Auther: jcd
 * @Date: 2018/12/5 10:33
 * @Description:
 */
public interface OurstaffTypeService extends BaseService{
	/**
	 * 员工类型列表查询
	 * @param form
	 * @return
	 */
	ServiceResult<List<WebsiteCultureType>> findOurStaffTypeList(WebsiteCultureType form);
	/**
	 * 详细信息查询
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteCultureType> getRecord(WebsiteCultureType form);
	/**
	 * 插入数据
	 * @param form
	 * @return
	 */
	ServiceResult<WebsiteCultureType> insertRecord(WebsiteCultureType form);
	/**
	 * 修改数据
	 */
	ServiceResult<WebsiteCultureType> updateRecord(WebsiteCultureType form);
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	ServiceResult<WebsiteCultureType> removeRecord(Integer id);
	

}
