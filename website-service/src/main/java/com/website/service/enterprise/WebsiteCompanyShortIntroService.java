package com.website.service.enterprise;

import java.util.List;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteShortIntroduce;
import com.website.service.BaseService;
/**
 * @Auther: jcd
 * @Date: 2018/11/12 11:33
 * @Description:
 */
public interface WebsiteCompanyShortIntroService extends BaseService{
	 /**
     * 获取简介列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<WebsiteShortIntroduce>> findCompanyShortIntroList(WebsiteShortIntroduce record);
    /**
     * 获取简介详情
     *
     * @param record
     * @return
     */
	public ServiceResult<WebsiteShortIntroduce> getRecord(WebsiteShortIntroduce form);
	/**
     * 新增简介
     *
     * @param record
     * @return
     */
	public ServiceResult<WebsiteShortIntroduce> insertRecord(WebsiteShortIntroduce form);
	/**
     * 修改简介
     *
     * @param record
     * @return
     */
	public ServiceResult<WebsiteShortIntroduce> updateRecord(WebsiteShortIntroduce form);
	/**
     * 删除简介
     *
     * @param record
     * @return
     */
	public ServiceResult<WebsiteShortIntroduce> removeRecord(Integer id);
}
