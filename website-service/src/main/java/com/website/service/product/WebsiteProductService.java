package com.website.service.product;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.WebsiteConsult;
import com.website.mybatis.bean.auto.WebsiteFeedback;
import com.website.mybatis.bean.auto.WebsiteProduct;
import com.website.mybatis.bean.auto.WebsiteProductWithBLOBs;
import com.website.service.BaseService;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:33
 * @Description:
 */
public interface WebsiteProductService extends BaseService {

    /**
     * 获取列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<WebsiteProductWithBLOBs>> findProductList(WebsiteProduct record);
    /**
     * 插入记录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteProductWithBLOBs> insertRecord(WebsiteProductWithBLOBs record);
    /**
     * 更新记录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteProductWithBLOBs> updateRecord(WebsiteProductWithBLOBs record);
    /**
     * 获取新闻纪录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteProductWithBLOBs> getRecord(WebsiteProductWithBLOBs record);
    /**
     * 添加免费咨询记录
     *
     * @param
     * @return
     */
    public ServiceResult<WebsiteConsult> insertConsult(WebsiteConsult form);

}
