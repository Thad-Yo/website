package com.website.service.impl.recruit;


import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.common.util.validator.KeyValueBean;
import com.website.mybatis.bean.auto.*;
import com.website.mybatis.bean.auto.WebsiteRecruitPositionExample.Criterion;
import com.website.mybatis.bean.auto.WebsiteConfigPositionExample.Criteria;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.ExtWebsiteRecruitPositionModel;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.recruit.WebsiteRecruitPositionService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:35
 * @Description:
 */
@Service
public class WebsiteRecruitPositionServiceImpl extends BaseServiceImpl implements WebsiteRecruitPositionService {

    /**
     * 获取岗位类别列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<WebsiteRecruitPosition>> findRecruitPositionList(WebsiteRecruitPosition record) {
        ServiceResult<List<WebsiteRecruitPosition>> result = new ServiceResult<>();
        List<WebsiteRecruitPosition> positionList = new ArrayList<>();
        List<String> recruitCity = new ArrayList<>();
        
        if(StringUtils.isNotEmpty(record.getRecruitCity())){
        	
        	if(StringUtils.contains(record.getRecruitCity(), ",")){
        		recruitCity = Arrays.asList(record.getRecruitCity().split(","));
        	}else{
        		recruitCity.add(record.getRecruitCity());
        	}
        	List<WebsiteRecruitPosition> list = new ArrayList<>();
        	for(String city : recruitCity){
        		WebsiteRecruitPositionExample example = new WebsiteRecruitPositionExample();
                WebsiteRecruitPositionExample.Criteria criteria = example.createCriteria();
                criteria.andDelFlagEqualTo("0");
                if(StringUtils.isNotEmpty(record.getRecruitPosition())){
                	criteria.andRecruitPositionLike("%"+record.getRecruitPosition()+"%");
                }
                if(StringUtils.isNotEmpty(record.getRecruitType())){
                	criteria.andRecruitTypeEqualTo(record.getRecruitType());
                }
                if(StringUtils.isNotEmpty(record.getStatus())){
                	criteria.andStatusEqualTo(record.getStatus());
                }
        		criteria.andRecruitCityLike("%"+city+"%");
        		list = this.websiteRecruitPositionMapper.selectByExampleWithBLOBs(example);
        		if(list != null && list.size()>0){
        			addByid(list, positionList);
        		}
        	}
        }else{
        	WebsiteRecruitPositionExample example = new WebsiteRecruitPositionExample();
            WebsiteRecruitPositionExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo("0");
            if(StringUtils.isNotEmpty(record.getRecruitPosition())){
            	criteria.andRecruitPositionLike("%"+record.getRecruitPosition()+"%");
            }
            if(StringUtils.isNotEmpty(record.getRecruitType())){
            	criteria.andRecruitTypeEqualTo(record.getRecruitType());
            }
            if(StringUtils.isNotEmpty(record.getStatus())){
            	criteria.andStatusEqualTo(record.getStatus());
            }
			if(StringUtils.isNotEmpty(record.getPositionType())){
				criteria.andPositionTypeEqualTo(record.getPositionType());
			}
        	positionList = this.websiteRecruitPositionMapper.selectByExampleWithBLOBs(example);
        }
        
        if(positionList != null && positionList.size()>0){
        	for(WebsiteRecruitPosition position : positionList){
        		if(StringUtils.isNotBlank(position.getUpdateTime())){
        			CMUser user = this.cmUserMapper.selectByPrimaryKey(position.getUpdateUser());
        			position.setUpdateTime(DateFormat.timestampToString(position.getUpdateTime(),DateFormat.YYYY_MM_DD_HH_MM_SS));
        			if(user!=null){
        				position.setUpdateUser(user.getUserName());
        			}else{
        				position.setUpdateUser("");
        			}
        		}
        	}
        }
        result.setResult(positionList);
        result.setSuccess(true);
        return result;
    }
    /**  
	 * <p>Title: addByid</p>
	 * <p>Description: 去重添加WebsiteRecruitPosition</p>
	 * @param list
	 * @param positionList
	 */ 
	
	private void addByid(List<WebsiteRecruitPosition> list, List<WebsiteRecruitPosition> positionList) {
		for(WebsiteRecruitPosition pos : list){
			boolean flag = false;
			for(int i=0;i<positionList.size();i++){
				if(pos.getId() == positionList.get(i).getId()){
					flag = true;
					break;
				}
			}
			if(!flag){
				positionList.add(pos);
			}
		}
	}
	/**
     * 插入岗位类别纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteRecruitPosition> insertRecord(WebsiteRecruitPosition record) {
        ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        
        if(StringUtils.isNotEmpty(record.getPositionIntroduce())){
			record.setPositionIntroduce(record.getPositionIntroduce());
        }
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        record.setDelFlag("0");//删除标识
        record.setCreateUser(loginUserCd);
        record.setCreateTime(nowDate);
        record.setUpdateUser(loginUserCd);
        record.setUpdateTime(nowDate);

        this.websiteRecruitPositionMapper.insertSelective(record);
        result.setMessage("保存成功");
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }
    
    @Override
    public ServiceResult<HrConfigPosition> insertHrRecord(HrConfigPosition record) {
        ServiceResult<HrConfigPosition> result = new ServiceResult<>();
        
        HrConfigPositionExample example = new HrConfigPositionExample();
        this.hrConfigPositionMapper.insertSelective(record);
        result.setMessage("保存成功");
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }
    
    @Override
    public ServiceResult<HrConfigPosition> delete(String record) {
        ServiceResult<HrConfigPosition> result = new ServiceResult<>();
        
        HrConfigPositionExample example = new HrConfigPositionExample();
        this.hrConfigPositionMapper.deleteByExample(example);
        result.setMessage("删除成功");
        result.setSuccess(true);
        return result;
    }

    /**
     * 更新岗位类别纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteRecruitPosition> updateRecord(WebsiteRecruitPosition record) {
        ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
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
        		this.websiteRecruitPositionMapper.updateByPrimaryKeySelective(record);
        		
        	}
        }else{
        	this.websiteRecruitPositionMapper.insertSelective(record);
        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

    /**
     * 获取招聘岗位记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteRecruitPosition> getRecord(WebsiteRecruitPosition record) {
        ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        WebsiteRecruitPosition wrp = new WebsiteRecruitPosition();
        WebsiteRecruitPositionExample example = new WebsiteRecruitPositionExample();
        WebsiteRecruitPositionExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo("0");//未删除
        criteria.andIdEqualTo(record.getId());
        example.setOrderByClause(" update_time DESC");
        List<WebsiteRecruitPosition> list = this.websiteRecruitPositionMapper.selectByExampleWithBLOBs(example);
        if(list != null && list.size()>0){
            wrp=list.get(0);
        }
		
        result.setResult(wrp);
        result.setSuccess(true);
        return result;
    }

    /**
     * 删除数据
     * @param id
     */
    @Override
    public ServiceResult<WebsiteRecruitPosition> removeRecord(Integer id) {
        ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        WebsiteRecruitPosition wrp = new WebsiteRecruitPosition();
        wrp=this.websiteRecruitPositionMapper.selectByPrimaryKey(id);
        if(wrp!=null){
            wrp.setDelFlag("1");
            int cnt = this.websiteRecruitPositionMapper.updateByPrimaryKeySelective(wrp);
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
	/**
	 *(non-Javadoc)
	 * <p>Title: cancelPublish</p>
	 * <p>Description: 发布与取消发布</p>
	 * @param id
	 * @return
	 * @see com.website.service.recruit.WebsiteRecruitPositionService#cancelPublish(java.lang.Integer, java.lang.String)
	 */
	
	@Override
	public ServiceResult<WebsiteRecruitPosition> cancelPublish(Integer id) {
		ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        WebsiteRecruitPosition wrp = new WebsiteRecruitPosition();
        wrp=this.websiteRecruitPositionMapper.selectByPrimaryKey(id);
        if(wrp!=null){
        	String status = wrp.getStatus();
        	if(StringUtils.equals(status, "y")){
        		wrp.setStatus("n");
        	}else if(StringUtils.equals(status, "n")){
        		wrp.setStatus("y");
        	}
            int cnt = this.websiteRecruitPositionMapper.updateByPrimaryKeySelective(wrp);
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
	/**
	 *(non-Javadoc)
	 * <p>Title: getPositionTypeList</p>
	 * <p>Description: 得到所有的岗位类别</p>
	 * @return
	 * @see com.website.service.recruit.WebsiteRecruitPositionService#getPositionTypeList()
	 */
	
	@Override
	public ServiceResult<List<WebsiteConfigPosition>> getPositionTypeList() {
		ServiceResult<List<WebsiteConfigPosition>> result = new ServiceResult<>();
		
		WebsiteConfigPositionExample example = new WebsiteConfigPositionExample();
		Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("0");
		List<WebsiteConfigPosition> pList = this.websiteConfigPositionMapper.selectByExample(example);
		if(pList != null && pList.size()>0){
			result.setResult(pList);
		}
		return result;
	}
	/**
	 *(non-Javadoc)
	 * <p>Title: getPositionListBypositionType</p>
	 * <p>Description: 根据岗位类别获得招聘岗位</p>
	 * @param positionType
	 * @return
	 * @see com.website.service.recruit.WebsiteRecruitPositionService#getPositionListBypositionType(java.lang.String)
	 */
	
	@Override
	public ServiceResult<List<KeyValueBean>> getPositionListByPositionType(String positionType) {
		ServiceResult<List<KeyValueBean>> result = new ServiceResult<List<KeyValueBean>>();
		List<KeyValueBean> kvList = new ArrayList<>();
		
		WebsiteConfigPositionExample example = new WebsiteConfigPositionExample();
		WebsiteConfigPositionExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("0");
		if(StringUtils.isNotEmpty(positionType)){
			criteria.andIdEqualTo(positionType);
		}
		List<WebsiteConfigPosition> pList = this.websiteConfigPositionMapper.selectByExample(example);
		if(pList != null && pList.size()>0){
			for(int j=0;j<pList.size();j++){
				WebsiteConfigPosition wcp = pList.get(j);
				String matchPositionIds = wcp.getMatchingPositionIds().substring(1);
				String matchposition = wcp.getMatchingPosition().substring(0, wcp.getMatchingPosition().length()-1);
				List<String> ids = new ArrayList<>();
				List<String> positions = new ArrayList<>();
				if(StringUtils.contains(matchPositionIds, ";")){
					ids = Arrays.asList(matchPositionIds.split(";"));
				}else{
					ids.add(matchPositionIds);
				}
				if(StringUtils.contains(matchposition, ",")){
					positions = Arrays.asList(matchposition.split(","));
				}else{
					positions.add(matchposition);
				}
				if(ids != null && ids.size()>0 && ids.size() == positions.size()){
					for(int i=0;i<ids.size();i++){
						kvList.add(new KeyValueBean(ids.get(i), positions.get(i)));
					}
				}
			}
			
		}
		result.setResult(kvList);
		return result;
	}
	
		@Override
	    public ServiceResult<List<HrConfigPosition>> getPositionListByPositionTypeAll(HrConfigPosition record) {
	        ServiceResult<List<HrConfigPosition>> result = new ServiceResult<>();
	        record.setDelFlag("0");
	        HrConfigPositionExample example = new HrConfigPositionExample();
	        HrConfigPositionExample.Criteria cia = example.createCriteria();
	        //大类ID
	        if(record.getPositionTypeId() != null){
	            cia.andPositionTypeIdEqualTo(record.getPositionTypeId());
	        }
	        if(StringUtils.isNotBlank(record.getDelFlag())){
	            cia.andDelFlagEqualTo(record.getDelFlag());
	        }
	        // 排序
	        /*if (StringUtils.isNotEmpty(record.getSort())) {
	            example.setOrderByClause(formatOrder(record.getSort(), record.getOrder()));
	        } else {
	            example.setOrderByClause("sort_key asc");
	        }*/

	        List<HrConfigPosition> roleList = this.hrConfigPositionMapper.selectByExample(example);
	        result.setResult(roleList);
	        result.setSuccess(true);
	        return result;
	    }
	/**
	 *(non-Javadoc)
	 * <p>Title: publishRecord</p>
	 * <p>Description: 详情页招聘岗位发布</p>
	 * @param form
	 * @return
	 * @see com.website.service.recruit.WebsiteRecruitPositionService#publishRecord(com.website.mybatis.bean.auto.WebsiteRecruitPosition)
	 */
	
	@Override
	public ServiceResult<WebsiteRecruitPosition> publishRecord(WebsiteRecruitPosition form) {
		ServiceResult<WebsiteRecruitPosition> result = new ServiceResult<>();
        WebsiteRecruitPosition wrp = new WebsiteRecruitPosition();
        wrp=this.websiteRecruitPositionMapper.selectByPrimaryKey(form.getId());
        if(wrp!=null){
        	wrp.setStatus("y");
            int cnt = this.websiteRecruitPositionMapper.updateByPrimaryKeySelective(wrp);
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
	/**
	 *(non-Javadoc)
	 * <p>Title: getPositionListByWorkCity</p>
	 * <p>Description: 根据城市获取岗位</p>
	 * @param workCity
	 * @return
	 * @see com.website.service.recruit.WebsiteRecruitPositionService#getPositionListByWorkCity(java.lang.String)
	 */
	
	@Override
	public ServiceResult<List<KeyValueBean>> getPositionListByWorkCity(String workCity) {
		ServiceResult<List<KeyValueBean>> result = new ServiceResult<List<KeyValueBean>>();
		List<KeyValueBean> kvList = new ArrayList<>();
		
		WebsiteRecruitPositionExample example = new WebsiteRecruitPositionExample();
		WebsiteRecruitPositionExample.Criteria criteria = example.createCriteria();
		criteria.andDelFlagEqualTo("0");
		if(StringUtils.isNotEmpty(workCity)){
			criteria.andRecruitCityLike("%"+workCity+"%");
		}
		List<WebsiteRecruitPosition> pList = this.websiteRecruitPositionMapper.selectByExample(example);
		if(pList != null && pList.size()>0){
			for(int j=0;j<pList.size();j++){
				WebsiteRecruitPosition wcp = pList.get(j);
				kvList.add(new KeyValueBean(wcp.getId().toString(), wcp.getRecruitPosition()));
			}
		}
		result.setResult(kvList);
		return result;
	}

	/**
	 * 获取岗位类别列表
	 *
	 * @param record
	 * @return
	 */
	@Override
	public ServiceResult<List<WebsiteRecruitPosition>> getRecordList(ExtWebsiteRecruitPositionModel record) {
		ServiceResult<List<WebsiteRecruitPosition>> result = new ServiceResult<>();
		List<WebsiteRecruitPosition> positionList = new ArrayList<>();
		positionList = this.extWebsiteRecruitPositionMapper.findRecruitPositinList(record);
		result.setResult(positionList);
		result.setSuccess(true);
		return result;
	}

	/**
	 * 获取省份列表
	 *
	 * @param record
	 * @return
	 */
	@Override
	public ServiceResult<List<WebsiteRecruitPosition>> findProvinceList(ExtWebsiteRecruitPositionModel record) {
		ServiceResult<List<WebsiteRecruitPosition>> result = new ServiceResult<>();
		List<WebsiteRecruitPosition> positionList = new ArrayList<>();
		positionList = this.extWebsiteRecruitPositionMapper.findProvinceList(record);
		result.setResult(positionList);
		result.setSuccess(true);
		return result;
	}

	/**
	 * 获取部门
	 *
	 * @param id
	 * @return
	 */
	@Override
	public ServiceResult<CMDepartment> findDepartment(int id) {
		ServiceResult<CMDepartment> result = new ServiceResult<>();
		CMDepartment cmDepartment = cmDepartmentMapper.selectByPrimaryKey(id);
		result.setResult(cmDepartment);
		result.setSuccess(true);
		return result;
	}

	/**
	 * 插入简历基本信息
	 *
	 * @param record
	 * @return
	 */
	@Override
	public ServiceResult<HrResumeBasic> insert(HrResumeBasic record){
		ServiceResult<HrResumeBasic> result = new ServiceResult<>();
		HrResumeBasicWithBLOBs hrResumeBasic = new HrResumeBasicWithBLOBs();
		BeanUtils.copyProperties(record, hrResumeBasic);
		HrResumeBasicExample example = new HrResumeBasicExample();
		example.createCriteria()
			.andNameCnEqualTo(hrResumeBasic.getNameCn())
			.andPhoneMobileEqualTo(hrResumeBasic.getPhoneMobile())
			.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
		List<HrResumeBasicWithBLOBs> list = this.hrResumeBasicMapper.selectByExampleWithBLOBs(example);
		if(list != null && list.size()>0){
			result.setMessage("您已投递过简历，请勿重复投递");
		}else{
			int basicCnt = this.hrResumeBasicMapper.insert(hrResumeBasic);
			if(basicCnt > 0){
				result.setSuccess(true);
			}else{
				result.setSuccess(false);
			}
		}
		return result;
	}
	/**
	 *(non-Javadoc)
	 * <p>Title: update</p>
	 * <p>Description: 更新简历基本信息</p>
	 * @param record
	 * @return
	 * @see com.website.service.recruit.WebsiteRecruitPositionService#update(com.website.mybatis.bean.auto.HrResumeBasic)
	 */
	
	@Override
	public ServiceResult<HrResumeBasic> update(HrResumeBasic record) {
		ServiceResult<HrResumeBasic> result = new ServiceResult<>();
		HrResumeBasicWithBLOBs hrResumeBasic = new HrResumeBasicWithBLOBs();
		BeanUtils.copyProperties(record, hrResumeBasic);
		HrResumeBasicExample example = new HrResumeBasicExample();
		example.createCriteria().andNameCnEqualTo(hrResumeBasic.getNameCn()).andPhoneMobileEqualTo(hrResumeBasic.getPhoneMobile());
		int basicCnt = this.hrResumeBasicMapper.updateByExampleSelective(hrResumeBasic, example);
		result.setSuccess(true);
		return result;
	}
	@Override
	public ServiceResult<List<WebsiteRecruitPosition>> selectByExample(String record) {
		ServiceResult<List<WebsiteRecruitPosition>> result = new ServiceResult<>();
		WebsiteRecruitPositionExample example = new WebsiteRecruitPositionExample();
        WebsiteRecruitPositionExample.Criteria criteria = example.createCriteria();
        criteria.andPositionTypeEqualTo(record);
        criteria.andDelFlagEqualTo("0");
        List<WebsiteRecruitPosition> List = this.websiteRecruitPositionMapper.selectByExample(example);
        result.setResult(List);
		return result;
	}


}
