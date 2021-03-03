package com.website.service.enterprise;

import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel;
import com.website.service.BaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:33
 * @Description:
 */
public interface WebsiteCompanyNewsService extends BaseService {

    /**
     * 获取新闻列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<ExtWebsiteCompanyNewsModel>> findCompanyNewsList(ExtWebsiteCompanyNewsModel record);
    
    /**
     * 获取不同type的新闻条数
     *
     * @param record
     * @return
     */
    public int count(ExtWebsiteCompanyNewsModel record);
    
    /**
     * 插入新闻
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteCompanyNews> insertRecord(WebsiteCompanyNews record);
    /**
     * 更新新闻
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteCompanyNews> updateRecord(WebsiteCompanyNews record);
    /**
     * 获取新闻纪录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteCompanyNews> getRecord(WebsiteCompanyNews record);
    /**
     * 删除新闻记录
     *
     * @param
     * @return
     */
    public ServiceResult<WebsiteCompanyNews> removeRecord(String id);
    /**
     * 获取新闻记录
     *
     * @param
     * @return
     */
    public ServiceResult<WebsiteCompanyNews> getNewsRecord(WebsiteCompanyNews record);

    /**
     * 获取英文新闻记录
     *
     * @param record
     * @return
     */
    ServiceResult<WebsiteCompanyNews> getEnNewsRecord(WebsiteCompanyNews record);

}
