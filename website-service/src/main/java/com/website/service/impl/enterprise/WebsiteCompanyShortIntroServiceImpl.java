package com.website.service.impl.enterprise;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteShortIntroduceExample;
import com.website.mybatis.bean.auto.WebsiteShortIntroduceExample;
import com.website.mybatis.bean.auto.WebsiteShortIntroduce;
import com.website.mybatis.bean.auto.WebsiteShortIntroduce;
import com.website.mybatis.bean.auto.WebsiteShortIntroduce;
import com.website.mybatis.bean.auto.WebsiteShortIntroduceExample;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.enterprise.WebsiteCompanyShortIntroService;
import com.website.service.impl.BaseServiceImpl;
@Service
public class WebsiteCompanyShortIntroServiceImpl extends BaseServiceImpl implements WebsiteCompanyShortIntroService {
	/**
     * 获取简介列表
     *
     */
	@Override
	public ServiceResult<List<WebsiteShortIntroduce>> findCompanyShortIntroList(WebsiteShortIntroduce record) {
		ServiceResult<List<WebsiteShortIntroduce>> result = new ServiceResult<>();
		WebsiteShortIntroduceExample  example = new WebsiteShortIntroduceExample();
		WebsiteShortIntroduceExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
		example.setOrderByClause("sort_number asc");
		List<WebsiteShortIntroduce> list = websiteShortIntroduceMapper.selectByExample(example);
		if(list != null){
			for(WebsiteShortIntroduce shortIntro : list){
				if(StringUtils.isNotBlank(shortIntro.getUpdateTime())){
	                CMUser user = this.cmUserMapper.selectByPrimaryKey(shortIntro.getUpdateUser());
	                shortIntro.setUpdateTime(DateFormat.timestampToString(shortIntro.getUpdateTime(),DateFormat.YYYY_MM_DD_HH_MM_SS));
	                if(user!=null){
	                	shortIntro.setUpdateUser(user.getUserName());
	                }else{
	                	shortIntro.setUpdateUser("");
	                }
	            }			
			}
		}
		result.setResult(list);
		return result;
	}
	/**
     * 获取简介详情
     *
     */
	@Override
	public ServiceResult<WebsiteShortIntroduce> getRecord(WebsiteShortIntroduce record) {
        ServiceResult<WebsiteShortIntroduce> result = new ServiceResult<>();
        WebsiteShortIntroduce ws = new WebsiteShortIntroduce();
        WebsiteShortIntroduceExample example = new WebsiteShortIntroduceExample();
        WebsiteShortIntroduceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo("0");//未删除
        criteria.andIdEqualTo(record.getId());
        example.setOrderByClause(" update_time DESC");
        example.setLimitStart(0);
        example.setLimitEnd(1);
        List<WebsiteShortIntroduce> list = this.websiteShortIntroduceMapper.selectByExample(example);
        if(list.size()>0){
            ws=list.get(0);
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }
	/**
     * 新增简介
     *
     */
	@Override
	public ServiceResult<WebsiteShortIntroduce> insertRecord(WebsiteShortIntroduce record) {
        ServiceResult<WebsiteShortIntroduce> result = new ServiceResult<WebsiteShortIntroduce>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        WebsiteShortIntroduce ns = this.websiteShortIntroduceMapper.selectByPrimaryKey(record.getId());
        if(ns!=null){
            this.websiteShortIntroduceMapper.updateByPrimaryKeySelective(record);
        }else{
        	record.setDelFlag("0");//删除标识
            record.setCreateUser(loginUserCd);
            record.setCreateTime(nowDate);
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            this.websiteShortIntroduceMapper.insertSelective(record);
        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }
	/**
     * 更新简介
     *
     */
	@Override
	public ServiceResult<WebsiteShortIntroduce> updateRecord(WebsiteShortIntroduce record) {
		ServiceResult<WebsiteShortIntroduce> result = new ServiceResult<>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        if(record.getId() != null){
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            this.websiteShortIntroduceMapper.updateByPrimaryKeySelective(record);
        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
	}
	/**
     * 删除简介
     *
     */
	@Override
	public ServiceResult<WebsiteShortIntroduce> removeRecord(Integer id) {
		ServiceResult<WebsiteShortIntroduce> result = new ServiceResult<>();
		this.websiteShortIntroduceMapper.deleteByPrimaryKey(id);
        result.setSuccess(true);
		return result;
	}

}
