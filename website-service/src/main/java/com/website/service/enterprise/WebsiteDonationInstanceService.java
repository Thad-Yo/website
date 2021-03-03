package com.website.service.enterprise;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteDonationInstance;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel;
import com.website.mybatis.bean.ext.ExtWebsiteDonationInstanceModel;
import com.website.service.BaseService;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:33
 * @Description:
 */
public interface WebsiteDonationInstanceService extends BaseService {

    /**
     * 获取捐赠纪实列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<ExtWebsiteDonationInstanceModel>> findCompanyNewsList(ExtWebsiteDonationInstanceModel record);
    /**
     * 获取捐赠纪实总条数
     *
     * @param record
     * @return
     */
    public int count(ExtWebsiteDonationInstanceModel form);
    /**
     * 插入捐赠纪实
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteDonationInstance> insertRecord(WebsiteDonationInstance record);
    /**
     * 更新捐赠纪实
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteDonationInstance> updateRecord(WebsiteDonationInstance record);
    /**
     * 获取捐赠纪实纪录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteDonationInstance> getRecord(WebsiteDonationInstance record);
    /**
     * 删除捐赠纪实记录
     *
     * @param
     * @return
     */
    public ServiceResult<WebsiteDonationInstance> removeRecord(String id);
    /**
     * 获取捐赠纪实纪录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteDonationInstance> getDonationRecord(WebsiteDonationInstance record);
    /**
     * 获取英文记录
     *
     * @param record
     * @return
     */
    ServiceResult<WebsiteDonationInstance> getEnDonationRecord(WebsiteDonationInstance record);

}
