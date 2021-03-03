package com.website.service.impl.pro;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.mybatis.bean.auto.WebsiteBasic;
import com.website.mybatis.bean.auto.WebsiteBasicWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteConfigBannerWithBLOBs;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.pro.HomePageService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class HomePageServiceImpl extends BaseServiceImpl implements HomePageService {

	@Override
	public ServiceResult<ExtWebsiteConfigBannerModel> insertRecord(ExtWebsiteConfigBannerModel form) {
		ServiceResult<ExtWebsiteConfigBannerModel> result = new ServiceResult<ExtWebsiteConfigBannerModel>();
		WebsiteConfigBannerWithBLOBs banner = new WebsiteConfigBannerWithBLOBs();
		try {
			String nowDate = DateUtils.getNowServerDateTime().substring(0, 10);
			BeanUtils.copyProperties(banner,form);
			banner.setDeleteFlag("0");
			if(StringUtils.isNotBlank(form.getId())){
				banner.setId(Integer.parseInt(form.getId()));
				banner.setUpdateTime(nowDate);
				this.websiteConfigBannerMapper.updateByPrimaryKeyWithBLOBs(banner);
			}else{
				banner.setCreateTime(nowDate);
				banner.setUpdateTime(nowDate);
				this.websiteConfigBannerMapper.insert(banner);
			}
			result.setSuccess(true);
			result.setMessage("保存成功");
			return result;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		result.setSuccess(false);
		result.setMessage("保存失败");
		return result;
	}

	public static void main(String[] args) {
		System.out.println(StringUtils.isNotBlank(""));
	}

	@Override
	public ServiceResult<List<ExtWebsiteConfigBannerModel>> getRecordList(ExtWebsiteConfigBannerModel form) {
		ServiceResult<List<ExtWebsiteConfigBannerModel>> result = new ServiceResult<List<ExtWebsiteConfigBannerModel>>();
        
    	result.setResult( this.extHomePageMapper.selectBannerList(form));
    	
	   	if(result.getResult()!=null && result.getResult().size()>0){
	    		result.setSuccess(true);
	   	}else{
	    		result.setSuccess(false);
	   	}
    	return result;
	}

	@Override
	public WebsiteConfigBanner getConfigBanner(ExtWebsiteConfigBannerModel form) {
		WebsiteConfigBanner selectByPrimaryKey = this.websiteConfigBannerMapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
		return selectByPrimaryKey;
		
	}

	@Override
	public ServiceResult<ExtWebsiteConfigBannerModel> updateIssue(ExtWebsiteConfigBannerModel form) {
		ServiceResult<ExtWebsiteConfigBannerModel> result = new ServiceResult<ExtWebsiteConfigBannerModel>();
		if(StringUtils.isNotBlank(form.getId())){
			WebsiteConfigBannerWithBLOBs selectByPrimaryKey = this.websiteConfigBannerMapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
			if(StringUtils.isNotBlank(form.getIssue())){
				String nowDate = DateUtils.getNowServerDateTime().substring(0, 10);
				selectByPrimaryKey.setIssue(form.getIssue());
				selectByPrimaryKey.setUpdateTime(nowDate);
				selectByPrimaryKey.setUpdateUserId(form.getUpdateUserId());
				selectByPrimaryKey.setUpdateUserName(form.getUpdateUserName());
				int updateByPrimaryKeySelective = this.websiteConfigBannerMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
				if(updateByPrimaryKeySelective>0){
					result.setSuccess(true);
					result.setMessage("修改成功");
					return result;
					
				}
			}
		}
		result.setSuccess(false);
		result.setMessage("修改失败");
		return result;
	}

	@Override
	public ServiceResult<ExtWebsiteConfigBannerModel> deleteAction(ExtWebsiteConfigBannerModel form) {
		ServiceResult<ExtWebsiteConfigBannerModel> result = new ServiceResult<ExtWebsiteConfigBannerModel>();
		if(StringUtils.isNotBlank(form.getId())){
			WebsiteConfigBannerWithBLOBs selectByPrimaryKey = this.websiteConfigBannerMapper.selectByPrimaryKey(Integer.parseInt(form.getId()));
			String nowDate = DateUtils.getNowServerDateTime().substring(0, 10);
			selectByPrimaryKey.setDeleteFlag("1");
			selectByPrimaryKey.setUpdateTime(nowDate);
			selectByPrimaryKey.setUpdateUserId(form.getUpdateUserId());
			selectByPrimaryKey.setUpdateUserName(form.getUpdateUserName());
			int updateByPrimaryKeySelective = this.websiteConfigBannerMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
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

	@Override
	public ServiceResult<WebsiteBasicWithBLOBs> insertBasic(WebsiteBasicWithBLOBs form) {
		ServiceResult<WebsiteBasicWithBLOBs> result = new ServiceResult<WebsiteBasicWithBLOBs>();
		try {
			this.extWebsiteBasicMapper.insert(form);
			
			result.setSuccess(true);
			result.setMessage("保存成功");
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		}
		result.setSuccess(false);
		result.setMessage("保存失败");
		return result;
	}

	@Override
	public WebsiteBasicWithBLOBs select(String id) {
		WebsiteBasicWithBLOBs websiteBasic = this.extWebsiteBasicMapper.select("1");
		return websiteBasic;
	}

	
}
