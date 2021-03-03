package com.website.service.recruit;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.validator.KeyValueBean;
import com.website.mybatis.bean.auto.HrConfigPosition;
import com.website.mybatis.bean.auto.HrResumeBasic;
import com.website.mybatis.bean.auto.WebsiteConfigPosition;
import com.website.mybatis.bean.auto.WebsiteRecruitPosition;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.ext.ExtWebsiteRecruitPositionModel;
import com.website.service.BaseService;

import java.util.List;

/**
 * @Auther: gq
 * @Date: 2018/5/29 11:33
 * @Description:
 */
public interface WebsiteRecruitPositionService extends BaseService {

    /**
     * 获取招聘岗位列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<WebsiteRecruitPosition>> findRecruitPositionList(WebsiteRecruitPosition record);
    /**
     * 插入招聘岗位
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteRecruitPosition> insertRecord(WebsiteRecruitPosition record);
    
    public ServiceResult<HrConfigPosition> insertHrRecord(HrConfigPosition record);
    
    public ServiceResult<HrConfigPosition> delete(String record);
    /**
     * 更新招聘岗位
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteRecruitPosition> updateRecord(WebsiteRecruitPosition record);
    /**
     * 获取招聘岗位纪录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteRecruitPosition> getRecord(WebsiteRecruitPosition record);
    /**
     * 删除招聘岗位记录
     *
     * @param
     * @return
     */
    public ServiceResult<WebsiteRecruitPosition> removeRecord(Integer id);
	/**  
	 * <p>Title: cancelPublish</p>
	 * <p>Description: 列表页发布与取消发布</p>
	 * @param id
	 * @return
	 */ 
	
	public ServiceResult<WebsiteRecruitPosition> cancelPublish(Integer id);
	/**  
	 * <p>Title: getPositionTypeList</p>
	 * <p>Description: 获取岗位大类</p>
	 * @return
	 */ 
	
	public ServiceResult<List<WebsiteConfigPosition>> getPositionTypeList();
	/**  
	 * <p>Title: getPositionListBypositionType</p>
	 * <p>Description: 获取某一岗位大类下的岗位</p>
	 * @param positionType
	 * @return
	 */ 
	
	public ServiceResult<List<KeyValueBean>> getPositionListByPositionType(String positionType);
	
	public ServiceResult<List<HrConfigPosition>> getPositionListByPositionTypeAll(HrConfigPosition record);
	/**  
	 * <p>Title: publishRecord</p>
	 * <p>Description: 详情页招聘岗位发布</p>
	 * @param form
	 * @return
	 */ 
	
	public ServiceResult<WebsiteRecruitPosition> publishRecord(WebsiteRecruitPosition form);
	/**
	 * <p>Title: getPositionListByWorkCity</p>
	 * <p>Description: 获取某一城市下的岗位</p>
	 * @param string
	 * @return
	 */

	public ServiceResult<List<KeyValueBean>> getPositionListByWorkCity(String workCity);
	/**
	 * <p>Description: 招聘条件查询</p>
	 * @param record
	 * @return
	 */
	public ServiceResult<List<WebsiteRecruitPosition>> getRecordList(ExtWebsiteRecruitPositionModel record);
	/**
	 * <p>Description: 查询城市</p>
	 * @param record
	 * @return
	 */
	public ServiceResult<List<WebsiteRecruitPosition>> findProvinceList(ExtWebsiteRecruitPositionModel record);
	/**
	 * <p>Description: 查询部门</p>
	 * @param id
	 * @return
	 */
	public ServiceResult<CMDepartment> findDepartment(int id);
	/**
	 * <p>Description: 插入简历基本信息</p>
	 * @param record
	 * @return
	 */
	public ServiceResult<HrResumeBasic> insert(HrResumeBasic record);
	/**
	 * 
	 * <p>Title: update</p>
	 * <p>Description: 更新简历基本信息</p>
	 * @param record
	 * @return
	 */
	public ServiceResult<HrResumeBasic> update(HrResumeBasic record);
	
	
	public ServiceResult<List<WebsiteRecruitPosition>> selectByExample(String record);
}
