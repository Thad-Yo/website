package com.website.service.impl.culture;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteCultureType;
import com.website.mybatis.bean.auto.WebsiteCultureTypeExample;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.service.culture.OurstaffTypeService;
import com.website.service.impl.BaseServiceImpl;
@Service
public class OurstaffTypeServiceImpl extends BaseServiceImpl implements OurstaffTypeService{
	/**
	 * 员工类型列表查询
	 */
	@Override
	public ServiceResult<List<WebsiteCultureType>> findOurStaffTypeList(WebsiteCultureType form) {
		ServiceResult<List<WebsiteCultureType>> result = new ServiceResult<>();
		WebsiteCultureTypeExample  example = new WebsiteCultureTypeExample();
		WebsiteCultureTypeExample.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(form.getCultureTypeName())){
			criteria.andCultureTypeNameLike("%"+form.getCultureTypeName()+"%");
		}
		if(StringUtils.isNotBlank(form.getCultureTypeCode())){
			criteria.andCultureTypeCodeEqualTo(form.getCultureTypeCode());
		}
		criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
		List<WebsiteCultureType> list = websiteCultureTypeMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			for(WebsiteCultureType type : list){
				if(StringUtils.isNotBlank(type.getUpdateTime())){
        			CMUser user = this.cmUserMapper.selectByPrimaryKey(type.getUpdateUser());
        			type.setUpdateTime(DateFormat.timestampToString(type.getUpdateTime(),DateFormat.YYYY_MM_DD_HH_MM_SS));
        			if(user!=null){
        				type.setUpdateUser(user.getUserName());
        			}else{
        				type.setUpdateUser("");
        			}
        		}
			}
		}
		result.setResult(list);
		result.setSuccess(true);
		return result;
	}
	
	/**
	 * 详细记录查询
	 */
	@Override
	public ServiceResult<WebsiteCultureType> getRecord(WebsiteCultureType record) {
		ServiceResult<WebsiteCultureType> result = new ServiceResult<>();
	    WebsiteCultureType type = new WebsiteCultureType();
        WebsiteCultureTypeExample example = new WebsiteCultureTypeExample();
        WebsiteCultureTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo("0");//未删除
        criteria.andIdEqualTo(record.getId());
        example.setOrderByClause(" update_time DESC");
        List<WebsiteCultureType> list = this.websiteCultureTypeMapper.selectByExample(example);
        if(list != null && list.size()>0){
            type=list.get(0);
        }
        result.setResult(type);
        result.setSuccess(true);
		return result;
	}

	/**
	 * 插入数据 
	 */
	@Override
	public ServiceResult<WebsiteCultureType> insertRecord(WebsiteCultureType record) {

        ServiceResult<WebsiteCultureType> result = new ServiceResult<>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDate();
        record.setDelFlag("0");//删除标识
        record.setCreateUser(loginUserCd);
        record.setCreateTime(nowDate);
        record.setUpdateUser(loginUserCd);
        record.setUpdateTime(nowDate);

        this.websiteCultureTypeMapper.insertSelective(record);
        result.setMessage("保存成功");
        result.setResult(record);
        result.setSuccess(true);
        return result;
    
	}

	/**
	 * 修改数据 
	 */
	@Override
	public ServiceResult<WebsiteCultureType> updateRecord(WebsiteCultureType record) {
        ServiceResult<WebsiteCultureType> result = new ServiceResult<>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDate();
        try{
            if(StringUtils.isNotBlank(record.getUpdateTime())){
                SimpleDateFormat df = new SimpleDateFormat(DateFormat.YYYY_MM_DD_HH_MM_SS);
                Long donationTime = df.parse(record.getUpdateTime()).getTime();
                record.setUpdateTime(donationTime.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(record.getId() != null){
        	if(StringUtils.isNotBlank(record.getId().toString())){
        		record.setUpdateUser(loginUserCd);
        		record.setUpdateTime(nowDate);
        		this.websiteCultureTypeMapper.updateByPrimaryKeySelective(record);
        		
        	}
        }else{
        	this.websiteCultureTypeMapper.insertSelective(record);
        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

	/**
	 * 删除数据 
	 */
	@Override
	public ServiceResult<WebsiteCultureType> removeRecord(Integer id) {
        ServiceResult<WebsiteCultureType> result = new ServiceResult<>();
        WebsiteCultureType wrp = new WebsiteCultureType();
        wrp=this.websiteCultureTypeMapper.selectByPrimaryKey(id);
        if(wrp!=null){
            wrp.setDelFlag("1");
            int cnt = this.websiteCultureTypeMapper.updateByPrimaryKeySelective(wrp);
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
