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
import com.website.mybatis.bean.auto.WebsiteCultureType;
import com.website.mybatis.bean.auto.WebsiteOurStaff;
import com.website.mybatis.bean.auto.WebsiteOurStaffExample;
import com.website.mybatis.bean.auto.WebsiteShortIntroduce;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.culture.WebsiteOurStaffService;
import com.website.service.impl.BaseServiceImpl;

@Service
public class WebsiteOurStaffServiceImpl extends BaseServiceImpl implements WebsiteOurStaffService{
	/**
	 * 我们的员工列表查询
	 */
	@Override
	public ServiceResult<List<WebsiteOurStaff>> findOurStaffList(WebsiteOurStaff record) {
		 ServiceResult<List<WebsiteOurStaff>> result = new ServiceResult<>();
	        WebsiteOurStaffExample example = new WebsiteOurStaffExample();
	        WebsiteOurStaffExample.Criteria criteria = example.createCriteria();
	        if(StringUtils.isNotBlank(record.getCnEnFlag())){
	            criteria.andCnEnFlagEqualTo(record.getCnEnFlag());
	        }else{
	            criteria.andCnEnFlagEqualTo("0");
	        }
	        if(StringUtils.isNotBlank(record.getHasEnFlag())){
	            criteria.andHasEnFlagEqualTo(record.getHasEnFlag());
	        }
	        if(StringUtils.isNotBlank(record.getImgDesc())){
	        	criteria.andImgDescLike("%"+record.getImgDesc()+"%");
	        }
	        if(StringUtils.isNotBlank(record.getTypeCode())){
	            criteria.andTypeCodeEqualTo(record.getTypeCode());
	        }
	        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
	        example.setOrderByClause(" img_type,sort_number ");
	        List<WebsiteOurStaff> culList = this.websiteOurStaffMapper.selectByExample(example);
	        for(WebsiteOurStaff culture : culList){
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
	 * 我们的员工详情
	 */
	@Override
	public ServiceResult<WebsiteOurStaff> getStaffRecord(WebsiteOurStaff record) {
		ServiceResult<WebsiteOurStaff> result = new ServiceResult<>();
        WebsiteOurStaff ws = new WebsiteOurStaff();
        if("0".equals(record.getCnEnFlag())){
            ws=this.websiteOurStaffMapper.selectByPrimaryKey(record.getId());
        }else if("0".equals(record.getHasEnFlag())){
            ws=this.websiteOurStaffMapper.selectByPrimaryKey(record.getId());
            ws.setCnEnFlag("1");
            ws.setCnid(ws.getId());
            ws.setId("");
        }else{
            WebsiteOurStaffExample example = new WebsiteOurStaffExample();
            WebsiteOurStaffExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(record.getId());
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteOurStaff> list = this.websiteOurStaffMapper.selectByExample(example);
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
	public ServiceResult<WebsiteOurStaff> insertRecord(WebsiteOurStaff record) {
        ServiceResult<WebsiteOurStaff> result = new ServiceResult<WebsiteOurStaff>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDate();
        if(StringUtils.isNotBlank(record.getCnid())){
            record.setCnEnFlag("1");
            WebsiteOurStaff ns = this.websiteOurStaffMapper.selectByPrimaryKey(record.getCnid());
            if(ns!=null){
                ns.setHasEnFlag("1");
                this.websiteOurStaffMapper.updateByPrimaryKeySelective(ns);
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

        this.websiteOurStaffMapper.insertSelective(record);

        result.setResult(record);
        result.setSuccess(true);
        return result;
    }
	
	/**
	 * 修改数据
	 */
	@Override
	public ServiceResult<WebsiteOurStaff> updateRecord(WebsiteOurStaff record) {
		ServiceResult<WebsiteOurStaff> result = new ServiceResult<>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDate();
        if(StringUtils.isNotBlank(record.getId())){
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            this.websiteOurStaffMapper.updateByPrimaryKeySelective(record);
        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
	}
	
	/**
	 * 删除数据
	 */
	@Override
	public ServiceResult<WebsiteOurStaff> removeRecord(String id) {
		ServiceResult<WebsiteOurStaff> result = new ServiceResult<>();
		WebsiteOurStaff wrp = new WebsiteOurStaff();
        wrp=this.websiteOurStaffMapper.selectByPrimaryKey(id);
        if(wrp!=null){
            wrp.setDelFlag("1");
            int cnt = this.websiteOurStaffMapper.updateByPrimaryKeySelective(wrp);
            WebsiteOurStaffExample example = new WebsiteOurStaffExample();
            WebsiteOurStaffExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(id);
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteOurStaff> list = this.websiteOurStaffMapper.selectByExample(example);
            if(list.size()>0){
                list.get(0).setDelFlag("1");
                int cn =this.websiteOurStaffMapper.updateByPrimaryKeySelective(list.get(0));
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
