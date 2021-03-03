package com.website.service.impl.pro;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.service.impl.BaseServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteConfigBannerWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteDevExample;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteHonorExample;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.auto.WebsiteIntroduceExample;
import com.website.mybatis.bean.auto.WebsiteIntroduceExample.Criteria;
import com.website.mybatis.bean.auto.WebsiteScope;
import com.website.mybatis.bean.auto.WebsiteScopeExample;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.auto.system.CTAttachmentExample;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.mybatis.mapper.auto.WebsiteIntroduceMapper;
import com.website.mybatis.mapper.auto.WebsiteScopeMapper;
import com.website.service.pro.AboutUsService;

@Service
public class AboutUsServiceImpl extends BaseServiceImpl implements AboutUsService{
	
	
	@Override
	public ServiceResult<WebsiteIntroduce> insertNew(WebsiteIntroduce form) {
		ServiceResult<WebsiteIntroduce> result = new ServiceResult<WebsiteIntroduce>();
		
		try {
			
			this.websiteIntroduceMapper.insertSelective(form);
			
			result.setSuccess(true);
			result.setMessage("保存成功");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage("保存失败");
			return result;
		}
	}
	
	@Override
	public ServiceResult<WebsiteDev> updateDevNew(WebsiteDev form) {
		
		ServiceResult<WebsiteDev> result = new ServiceResult<WebsiteDev>();
		try {
			form.setUpdateUserId(SessionUtils.getLoginUserInfo().getUserId());
	    	form.setUpdateUserName(SessionUtils.getLoginUserInfo().getRealName());
			form.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
			form.setDeleteFlag("0");
			if(form.getId()==""||form.getId()==null){
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				/*String string = form.getDevDate(); //去掉时间戳后三位
				string=string.substring(0,string.length()-3);
				form.setDevDate(string);*/
				form.setId(uuid);
				form.setHasEng("0");
				this.extWebsiteDevMapper.insert(form);
				 
			}else{
				 form.setUpdateTime(String.valueOf(System.currentTimeMillis()/1000));
				 
				 if("3".equals(form.getHasEng())){
					 form.setHasEng("1");
					 this.extWebsiteDevMapper.updateEng(form);
				 }else{
					 this.extWebsiteDevMapper.updateByPrimaryKey(form);
					 }
				
				
			}
			result.setSuccess(true);
			result.setMessage("保存成功");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMessage("保存失败");
			return result;
		}
	}

	@Override
	public ServiceResult<List<WebsiteDev>> getRecordList(WebsiteDev form) {

		if (StringUtils.isNotEmpty(form.getSort())) {
			form.setOrderByClause(formatOrder(form.getSort(), form.getOrder()));
		}else{
			form.setOrderByClause("dev_date desc");
		}
		ServiceResult<List<WebsiteDev>> result = new ServiceResult<List<WebsiteDev>>();
        
    	result.setResult(this.extWebsiteDevMapper.selectUsList(form));
    	
	   	if(result.getResult()!=null && result.getResult().size()>0){
	    		result.setSuccess(true);
	   	}else{
	    		result.setSuccess(false);
	   	}
    	return result;
	}

	@Override
	public WebsiteDev getConfigBanner(WebsiteDev form) {
		WebsiteDev selectByPrimaryKey = this.extWebsiteDevMapper.selectByPrimaryKey(form.getId());
		return selectByPrimaryKey;
	}

	@Override
	public ServiceResult<WebsiteDev> deleteAction(WebsiteDev form) {
		ServiceResult<WebsiteDev> result = new ServiceResult<WebsiteDev>();
		if(StringUtils.isNotBlank(form.getId())){
			WebsiteDev selectByPrimaryKey = this.extWebsiteDevMapper.selectByPrimaryKey(form.getId());
			selectByPrimaryKey.setDeleteFlag("1");
			int updateByPrimaryKeySelective = this.websiteDevMapper.updateByPrimaryKey(selectByPrimaryKey);
			if(updateByPrimaryKeySelective>0){
				result.setSuccess(true);
				result.setMessage("删除成功");
				return result;
			}
		}
		result.setSuccess(false);
		result.setMessage("删除失败");
		return result;
	}
	/**
	 * 查询企业介绍列表
	 */
	@Override
	public List<WebsiteIntroduce> selectWebsiteIntroduceList() {
		//
		WebsiteIntroduceExample example = new WebsiteIntroduceExample();
		example.setOrderByClause("id DESC");
		
		List<WebsiteIntroduce> list = this.websiteIntroduceMapper.selectByExampleWithBLOBs(example);
		
		return list;
	}

	/**
	 * 查询集团规模变化列表
	 */
	@Override
	public List<WebsiteScope> selectWebsiteScopeList() {
		
		WebsiteScopeExample example = new WebsiteScopeExample();
		example.setOrderByClause("year ASC");
		com.website.mybatis.bean.auto.WebsiteScopeExample.Criteria criteria = example.createCriteria();
		criteria.andShowEqualTo("1");
		
		List<WebsiteScope> list = this.websiteScopeMapper.selectByExample(example);
		
		return list;
	}

	/**
	 * 查询合作伙伴图片列表
	 */
	@Override
	public List<CTAttachment> selectPartnersPic() {
		
		CTAttachmentExample example = new CTAttachmentExample();
		example.setOrderByClause("id DESC");
		com.website.mybatis.bean.auto.system.CTAttachmentExample.Criteria criteria = example.createCriteria();
		criteria.andFileIdEqualTo("partnersfile");
		criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
		List<CTAttachment> list = this.ctAttachmentMapper.selectByExample(example);
		
		return list;
	}

	/**
	 * 查询发展历程列表
	 */
	@Override
	public List<WebsiteDev> selectWebsiteDevList() {
		
		WebsiteDevExample example = new WebsiteDevExample();
		example.setOrderByClause("dev_date ASC");
		com.website.mybatis.bean.auto.WebsiteDevExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteFlagEqualTo("0");
		List<WebsiteDev> list = this.websiteDevMapper.selectByExample(example);
		
		return list;
	}

	/**
	 * 查询荣誉资质列表
	 */
	@Override
	public List<WebsiteHonor> selectWebsiteHonorList() {
		
		WebsiteHonorExample example = new WebsiteHonorExample();
		example.setOrderByClause("honor_number ASC");
		com.website.mybatis.bean.auto.WebsiteHonorExample.Criteria criteria = example.createCriteria();
		criteria.andDeleteFlagEqualTo("0");
		List<WebsiteHonor> list = this.websiteHonorMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public ServiceResult<Integer> count(String id,String year) {
		ServiceResult<Integer> result = new ServiceResult<>();
        int cnt = 0;
        if (StringUtils.isNotBlank(year)) {
        	WebsiteScopeExample example = new WebsiteScopeExample();
        	WebsiteScopeExample.Criteria criteria = example.createCriteria();
            criteria.andYearEqualTo(year);
           
            cnt = this.websiteScopeMapper.countByExample(example);
        }
        result.setResult(cnt);
        result.setSuccess(true);
        return result;
	}

}
