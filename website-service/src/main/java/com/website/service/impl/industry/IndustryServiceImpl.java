package com.website.service.impl.industry;

import java.util.List;
import java.util.UUID;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteIndustryExample;
import com.website.mybatis.bean.auto.WebsiteIndustryWithBLOBs;
import com.website.mybatis.bean.ext.ExtWebsiteIndustryWithBLOBsModel;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.industry.IndustryService;
@Service
public class IndustryServiceImpl extends BaseServiceImpl implements IndustryService {

	/**
	 * 新增或编辑
	 */
	@Override
	public ServiceResult<JSONObject> saveWebsiteIndustry(ExtWebsiteIndustryWithBLOBsModel form) {
		ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
		String nowDate = DateUtils.getNowServerDateTime();
		LoginUserInfo userInfo = SessionUtils.getLoginUserInfo();
		WebsiteIndustryWithBLOBs record = new WebsiteIndustryWithBLOBs();
		BeanUtils.copyProperties(form, record);
		try{
			record.setUpdateDate(nowDate);
			record.setUpdateUserCd(userInfo.getUserId());
			record.setUpdateUserName(userInfo.getUserName());
			if(StringUtils.isNotBlank(form.getId())){//编辑
				this.websiteIndustryMapper.updateByPrimaryKeySelective(record);
			}else{//新增
				record.setId(UUID.randomUUID().toString());
				this.websiteIndustryMapper.insertSelective(record);
			}
			res.setSuccess(true);
			res.setMessage("保存成功");
			return res;
		}catch (Exception e) {
			e.printStackTrace();
		}
		res.setSuccess(false);
		res.setMessage("保存失败");
		return res;
	}

	/**
	 * 删除
	 */
	@Override
	public ServiceResult<JSONObject> deleteByPrimaryKey(String id) {
		ServiceResult<JSONObject> res = new ServiceResult<JSONObject>();
		try {
			this.websiteIndustryMapper.deleteByPrimaryKey(id);
			res.setSuccess(true);
			res.setMessage("删除成功");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.setSuccess(false);
		res.setMessage("删除失败");
		return res;
	}

	@Override
	public List<WebsiteIndustryWithBLOBs> selectByExampleWithBLOBs(WebsiteIndustryExample example) {
		return this.websiteIndustryMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public WebsiteIndustryWithBLOBs selectByPrimaryKey(String id) {
		return this.websiteIndustryMapper.selectByPrimaryKey(id);
	}

}
