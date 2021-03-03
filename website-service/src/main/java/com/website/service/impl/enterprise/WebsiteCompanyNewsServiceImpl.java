package com.website.service.impl.enterprise;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteCompanyNewsExample;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel;
import com.website.service.enterprise.WebsiteCompanyNewsService;
import com.website.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:35
 * @Description:
 */
@Service
public class WebsiteCompanyNewsServiceImpl extends BaseServiceImpl implements WebsiteCompanyNewsService {

    /**
     * 获取新闻列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<ExtWebsiteCompanyNewsModel>> findCompanyNewsList(ExtWebsiteCompanyNewsModel record) {
        ServiceResult<List<ExtWebsiteCompanyNewsModel>> result = new ServiceResult<>();

        if(StringUtils.isBlank(record.getCnEnFlag())){
            record.setCnEnFlag("0");
        }
        List<ExtWebsiteCompanyNewsModel> roleList = this.extWebsiteCompanyNewsMapper.findNewsList(record);
        for(WebsiteCompanyNews news : roleList){
            if(StringUtils.isNotBlank(news.getUpdateTime())){
                CMUser user = this.cmUserMapper.selectByPrimaryKey(news.getUpdateUser());
                news.setUpdateTime(DateFormat.timestampToString(news.getUpdateTime(),DateFormat.YYYY_MM_DD_HH_MM_SS));
                if(user!=null){
                    news.setUpdateUser(user.getUserName());
                }else{
                    news.setUpdateUser("");
                }
            }
        }
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }
    /**
     * 插入新闻纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteCompanyNews> insertRecord(WebsiteCompanyNews record) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<WebsiteCompanyNews>();

        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        if(StringUtils.isNotBlank(record.getCnid())){
            record.setCnEnFlag("1");
            WebsiteCompanyNews ns = this.websiteCompanyNewsMapper.selectByPrimaryKey(record.getCnid());
            if(ns!=null){
                ns.setHasEnFlag("1");
                this.websiteCompanyNewsMapper.updateByPrimaryKeySelective(ns);
            }
        }else{
            record.setCnEnFlag("0");//中文标识
            record.setHasEnFlag("0");//无英文版
        }
        record.setId(UUID.randomUUID().toString());
        record.setDelFlag("0");//删除标识
        record.setCreateUser(loginUserCd);
        record.setCreateTime(nowDate);
        record.setUpdateUser(loginUserCd);
        record.setUpdateTime(nowDate);

        this.websiteCompanyNewsMapper.insertSelective(record);

        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

    /**
     * 更新新闻纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteCompanyNews> updateRecord(WebsiteCompanyNews record) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<WebsiteCompanyNews>();

        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        if(StringUtils.isNotBlank(record.getId())){
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            if("0".equals(record.getCnEnFlag())){
                WebsiteCompanyNewsExample example = new WebsiteCompanyNewsExample();
                WebsiteCompanyNewsExample.Criteria criteria = example.createCriteria();
                criteria.andDelFlagEqualTo("0");//未删除
                criteria.andCnidEqualTo(record.getId());
                example.setOrderByClause(" update_time DESC");
                example.setLimitStart(0);
                example.setLimitEnd(1);
                List<WebsiteCompanyNews> list = this.websiteCompanyNewsMapper.selectByExample(example);
                if(list.size()>0){
                    list.get(0).setIsTop(record.getIsTop());
                    this.websiteCompanyNewsMapper.updateByPrimaryKeySelective(list.get(0));
                }

            }
            this.websiteCompanyNewsMapper.updateByPrimaryKeySelective(record);

        }


        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

    /**
     * 获取新闻记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteCompanyNews> getRecord(WebsiteCompanyNews record) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<>();
        WebsiteCompanyNews ws = new WebsiteCompanyNews();
        WebsiteCompanyNewsExample example = new WebsiteCompanyNewsExample();
        WebsiteCompanyNewsExample.Criteria criteria = example.createCriteria();
        if("0".equals(record.getCnEnFlag())){
        	criteria.andIdEqualTo(record.getId());
            List<WebsiteCompanyNews> list=this.websiteCompanyNewsMapper.selectByExampleWithBLOBs(example);
            if(list != null && list.size() > 0){
            	ws = list.get(0);
            }
        }else if("0".equals(record.getHasEnFlag())){
        	criteria.andIdEqualTo(record.getId());
            List<WebsiteCompanyNews> list=this.websiteCompanyNewsMapper.selectByExampleWithBLOBs(example);
            if(list != null && list.size() > 0){
            	ws = list.get(0);
            }
            ws.setCnEnFlag("1");
            ws.setCnid(ws.getId());
            ws.setId("");
        }else{
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(record.getId());
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteCompanyNews> list = this.websiteCompanyNewsMapper.selectByExampleWithBLOBs(example);
            if(list.size()>0){
                ws=list.get(0);
            }
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }

    /**
     * 删除订单数据
     * @param id
     */
    @Override
    public ServiceResult<WebsiteCompanyNews> removeRecord(String id) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<WebsiteCompanyNews>();
        WebsiteCompanyNews ws = new WebsiteCompanyNews();
        ws=this.websiteCompanyNewsMapper.selectByPrimaryKey(id);
        ws.setDelFlag("1");
        if(ws!=null){
            int cnt = this.websiteCompanyNewsMapper.updateByPrimaryKeySelective(ws);
            WebsiteCompanyNewsExample example = new WebsiteCompanyNewsExample();
            WebsiteCompanyNewsExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(id);
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteCompanyNews> list = this.websiteCompanyNewsMapper.selectByExample(example);
            if(list.size()>0){
                list.get(0).setDelFlag("1");
                int cn =this.websiteCompanyNewsMapper.updateByPrimaryKeySelective(list.get(0));
                if(cn>0){
                    result.setSuccess(true);
                }else{
                    result.setSuccess(false);
                }
                return result;
            }
            if(cnt>0){
                result.setSuccess(true);
            }else{
                result.setSuccess(false);
            }
        }
        return result;
    }

    /**
     * 获取新闻记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteCompanyNews> getNewsRecord(WebsiteCompanyNews record) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<>();
        WebsiteCompanyNews ws = new WebsiteCompanyNews();
        ws=this.websiteCompanyNewsMapper.selectByPrimaryKey(record.getId());
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }

    /**
     * 获取英文新闻记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteCompanyNews> getEnNewsRecord(WebsiteCompanyNews record) {
        ServiceResult<WebsiteCompanyNews> result = new ServiceResult<>();
        WebsiteCompanyNews ws = new WebsiteCompanyNews();
        WebsiteCompanyNewsExample example = new WebsiteCompanyNewsExample();
        WebsiteCompanyNewsExample.Criteria criteria = example.createCriteria();
        criteria.andCnidEqualTo(record.getId());
        List<WebsiteCompanyNews> list = this.websiteCompanyNewsMapper.selectByExampleWithBLOBs(example);
        if(list.size()>0){
            ws = list.get(0);
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }
	/**
	 *(non-Javadoc)
	 * <p>Title: count</p>
	 * <p>Description: 获取不同type的新闻条数</p>
	 * @param record
	 * @return
	 * @see com.website.service.enterprise.WebsiteCompanyNewsService#count(com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel)
	 */
	
	@Override
	public int count(ExtWebsiteCompanyNewsModel record) {
		WebsiteCompanyNewsExample example = new WebsiteCompanyNewsExample();
		example.createCriteria().andCnEnFlagEqualTo(record.getCnEnFlag()).andDelFlagEqualTo("0").andTypeEqualTo(record.getType());
		return websiteCompanyNewsMapper.countByExample(example);
	}

}
