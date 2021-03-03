package com.website.service.impl.pro;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.service.impl.BaseServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteConfigBannerWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.service.pro.AboutUsService;
import com.website.service.pro.HonorService;

@Service
public class HonorServiceImpl extends BaseServiceImpl implements HonorService{
	

	@Override
	public ServiceResult<WebsiteHonor> updateNew(WebsiteHonor form) {
		
		ServiceResult<WebsiteHonor> result = new ServiceResult<WebsiteHonor>();
		try {
			form.setUpdateUserId(SessionUtils.getLoginUserInfo().getUserId());
	    	form.setUpdateUserName(SessionUtils.getLoginUserInfo().getRealName());
			form.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));
			form.setDeleteFlag("0");
			if(form.getId()==""||form.getId()==null){
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				form.setId(uuid);
				form.setHasEng("0");
				this.extWebsiteHonorMapper.insert(form);
				 
			}else{
				 form.setUpdateTime(String.valueOf(System.currentTimeMillis()/1000));
				 if("3".equals(form.getHasEng())){
					 form.setHasEng("1");
					 this.extWebsiteHonorMapper.updateEng(form);
					 }else{
						 	this.extWebsiteHonorMapper.updateByPrimaryKey(form);
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
	public ServiceResult<List<WebsiteHonor>> getRecordList(WebsiteHonor form) {
		/*if (StringUtils.isNotEmpty(form.getSort())) {
			form.setOrderByClause(formatOrder(form.getSort(), form.getOrder()));
		}else{
			form.setOrderByClause("create_time desc");
		}
		*/
		ServiceResult<List<WebsiteHonor>> result = new ServiceResult<List<WebsiteHonor>>();
        
    	result.setResult(this.extWebsiteHonorMapper.selectUsList(form));
    	
	   	if(result.getResult()!=null && result.getResult().size()>0){
	    		result.setSuccess(true);
	   	}else{
	    		result.setSuccess(false);
	   	}
    	return result;
	}

	@Override
	public WebsiteHonor getConfigBanner(WebsiteHonor form) {
		WebsiteHonor selectByPrimaryKey = this.extWebsiteHonorMapper.selectByPrimaryKey(form.getId());
		return selectByPrimaryKey;
	}

	@Override
	public ServiceResult<WebsiteHonor> deleteAction(WebsiteHonor form) {
		ServiceResult<WebsiteHonor> result = new ServiceResult<WebsiteHonor>();
		if(StringUtils.isNotBlank(form.getId())){
			WebsiteHonor selectByPrimaryKey = this.extWebsiteHonorMapper.selectByPrimaryKey(form.getId());
			selectByPrimaryKey.setDeleteFlag("1");
			int updateByPrimaryKeySelective = this.websiteHonorMapper.updateByPrimaryKey(selectByPrimaryKey);
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

}
