package com.website.service.impl.pro;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.service.impl.BaseServiceImpl;

import java.awt.geom.Area;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteConfigBannerWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteFiliale;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.service.pro.AboutUsService;
import com.website.service.pro.FilialeService;
import com.website.service.pro.HonorService;

@Service
public class FilialeServiceImpl extends BaseServiceImpl implements FilialeService{
	

	@Override
	public ServiceResult<WebsiteFiliale> updateNew(WebsiteFiliale form) {
		
		ServiceResult<WebsiteFiliale> result = new ServiceResult<WebsiteFiliale>();
		try {
			
			form.setShow("1");
			if(("").equals(form.getId())||form.getId()==null){
				this.websiteFilialeMapper.insert(form);
				 
			}else{
				 
				this.websiteFilialeMapper.updateByPrimaryKey(form);
					 	
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
	public ServiceResult<List<WebsiteFiliale>> getRecordList(WebsiteFiliale form) {
		
		ServiceResult<List<WebsiteFiliale>> result = new ServiceResult<List<WebsiteFiliale>>();
        
    	result.setResult(this.extWebsiteFilialeMapper.selectUsList(form));
    	
	   	if(result.getResult()!=null && result.getResult().size()>0){
	    		result.setSuccess(true);
	   	}else{
	    		result.setSuccess(false);
	   	}
    	return result;
	}

	@Override
	public WebsiteFiliale getConfigBanner(WebsiteFiliale form) {
		WebsiteFiliale selectByPrimaryKey = this.websiteFilialeMapper.selectByPrimaryKey(form.getId());
		return selectByPrimaryKey;
	}

	@Override
	public ServiceResult<WebsiteFiliale> deleteAction(WebsiteFiliale form) {
		ServiceResult<WebsiteFiliale> result = new ServiceResult<WebsiteFiliale>();
			WebsiteFiliale selectByPrimaryKey = this.websiteFilialeMapper.selectByPrimaryKey(form.getId());
			selectByPrimaryKey.setShow("0");
			int updateByPrimaryKeySelective = this.websiteFilialeMapper.updateByPrimaryKey(selectByPrimaryKey);
			if(updateByPrimaryKeySelective>0){
				result.setSuccess(true);
				result.setMessage("删除成功");
				return result;
			}
		result.setSuccess(false);
		result.setMessage("删除失败");
		return result;
	}

	/**
	 * 获取省列表
	 *
	 * @return
	 */
	public ServiceResult<List<Area>> getProvince() {
		ServiceResult<List<Area>> serviceResult = new ServiceResult<List<Area>>();
		serviceResult.setSuccess(true);
		serviceResult.setResult(this.extWebsiteFilialeMapper.findProvinceList());
		return serviceResult;
	}

	/**
	 * 获取省列表
	 *
	 * @return
	 */
	@Override
	public ServiceResult<List<WebsiteFiliale>> getFilialeProList() {
		ServiceResult<List<WebsiteFiliale>> serviceResult = new ServiceResult<List<WebsiteFiliale>>();
		serviceResult.setResult(this.extWebsiteFilialeMapper.getFilialeProList());
		serviceResult.setSuccess(true);
		return serviceResult;
	}

}
