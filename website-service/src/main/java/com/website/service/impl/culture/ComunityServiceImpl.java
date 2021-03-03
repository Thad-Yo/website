package com.website.service.impl.culture;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteCommunity;
import com.website.mybatis.bean.auto.WebsiteCommunityExample;
import com.website.mybatis.bean.auto.WebsiteCompanyNews;
import com.website.mybatis.bean.auto.WebsiteCompanyNewsExample;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.culture.ComunityService;
import com.website.service.impl.BaseServiceImpl;
@Service
public class ComunityServiceImpl extends BaseServiceImpl implements ComunityService{
	
	/**
	 * 列表查询
	 */
	@Override
	public ServiceResult<List<WebsiteCommunity>> findComunityList(WebsiteCommunity record) {

		 ServiceResult<List<WebsiteCommunity>> result = new ServiceResult<>();
	        WebsiteCommunityExample example = new WebsiteCommunityExample();
	        WebsiteCommunityExample.Criteria criteria = example.createCriteria();
	        if(StringUtils.isNotBlank(record.getCnEnFlag())){
	            criteria.andCnEnFlagEqualTo(record.getCnEnFlag());
	        }else{
	            criteria.andCnEnFlagEqualTo("0");
	        }
	        if(StringUtils.isNotBlank(record.getHasEnFlag())){
	            criteria.andHasEnFlagEqualTo(record.getHasEnFlag());
	        }
	        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
	        example.setOrderByClause(" sort_number asc");
	        List<WebsiteCommunity> culList = this.websiteCommunityMapper.selectByExampleWithBLOBs(example);
	        for(WebsiteCommunity culture : culList){
	            if(StringUtils.isNotBlank(culture.getUpdateTime())){
	                CMUser user = this.cmUserMapper.selectByPrimaryKey(culture.getUpdateUser());
	                culture.setUpdateTime(DateFormat.timestampToString(culture.getUpdateTime(),DateFormat.YYYY_MM_DD_HH_MM_SS));
	                if(user!=null){
	                    culture.setUpdateUser(user.getUserName());
	                }else{
	                    culture.setUpdateUser("");
	                }
	            }
	        }
	        result.setResult(culList);
	        result.setSuccess(true);
	        
		return result;
	}
	
	/**
	 * 详情查询
	 */
	@Override
	public ServiceResult<WebsiteCommunity> getComunityRecord(WebsiteCommunity record) {
		ServiceResult<WebsiteCommunity> result = new ServiceResult<>();
		WebsiteCommunity ws = new WebsiteCommunity();
		WebsiteCommunityExample example = new WebsiteCommunityExample();
        WebsiteCommunityExample.Criteria criteria = example.createCriteria();
        if("0".equals(record.getCnEnFlag())){
        	criteria.andDelFlagEqualTo("0");//未删除
        	criteria.andIdEqualTo(record.getId());
        	List<WebsiteCommunity> wsList = this.websiteCommunityMapper.selectByExampleWithBLOBs(example);
        	if(wsList != null && wsList.size() > 0){
        		  ws=wsList.get(0);
        	}
        }else if("0".equals(record.getHasEnFlag())){
            ws=this.websiteCommunityMapper.selectByPrimaryKey(record.getId());
            ws.setCnEnFlag("1");
            ws.setCnid(ws.getId());
            ws.setId("");
        }else{
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(record.getId());
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteCommunity> list = this.websiteCommunityMapper.selectByExampleWithBLOBs(example);
            if(list.size()>0){
                ws=list.get(0);
            }
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
	}
	
	/**
	 * 插入数据
	 */
	@Override
	public ServiceResult<WebsiteCommunity> insertRecord(WebsiteCommunity record) {
		ServiceResult<WebsiteCommunity> result = new ServiceResult<WebsiteCommunity>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDate();
        if(StringUtils.isNotBlank(record.getCnid())){
            record.setCnEnFlag("1");
            WebsiteCommunity ns = this.websiteCommunityMapper.selectByPrimaryKey(record.getCnid());
            if(ns!=null){
                ns.setHasEnFlag("1");
                this.websiteCommunityMapper.updateByPrimaryKeySelective(ns);
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

        this.websiteCommunityMapper.insertSelective(record);

        result.setResult(record);
        result.setSuccess(true);
        return result;
	}
	
	/**
	 * 修改数据
	 */
	@Override
	public ServiceResult<WebsiteCommunity> updateRecord(WebsiteCommunity record) {
		ServiceResult<WebsiteCommunity> result = new ServiceResult<>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDate();
        if(StringUtils.isNotBlank(record.getId())){
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            this.websiteCommunityMapper.updateByPrimaryKeySelective(record);
        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
	}
	
	/**
	 * 删除数据
	 */
	@Override
	public ServiceResult<WebsiteCommunity> removeRecord(String id) {
		ServiceResult<WebsiteCommunity> result = new ServiceResult<>();
		WebsiteCommunity wrp = new WebsiteCommunity();
        wrp=this.websiteCommunityMapper.selectByPrimaryKey(id);
        if(wrp!=null){
            wrp.setDelFlag("1");
            int cnt = this.websiteCommunityMapper.updateByPrimaryKeySelective(wrp);
            WebsiteCommunityExample example = new WebsiteCommunityExample();
            WebsiteCommunityExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(id);
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteCommunity> list = this.websiteCommunityMapper.selectByExample(example);
            if(list.size()>0){
                list.get(0).setDelFlag("1");
                int cn =this.websiteCommunityMapper.updateByPrimaryKeySelective(list.get(0));
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
        }else{
            result.setSuccess(false);
        }
        return result;
	}

}
