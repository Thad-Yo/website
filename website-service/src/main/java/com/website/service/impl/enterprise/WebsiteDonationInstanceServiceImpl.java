package com.website.service.impl.enterprise;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteDonationInstance;
import com.website.mybatis.bean.auto.WebsiteDonationInstanceExample;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.ExtWebsiteDonationInstanceModel;
import com.website.service.enterprise.WebsiteDonationInstanceService;
import com.website.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:35
 * @Description:
 */
@Service
public class WebsiteDonationInstanceServiceImpl extends BaseServiceImpl implements WebsiteDonationInstanceService {

    /**
     * 获取新闻列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<ExtWebsiteDonationInstanceModel>> findCompanyNewsList(ExtWebsiteDonationInstanceModel record) {
        ServiceResult<List<ExtWebsiteDonationInstanceModel>> result = new ServiceResult<>();
        if(StringUtils.isBlank(record.getCnEnFlag())){
            record.setCnEnFlag("0");
        }
        List<ExtWebsiteDonationInstanceModel> roleList = this.extWebsiteDonationInstanceMapper.findDonationInstanceList(record);
        for(WebsiteDonationInstance news : roleList){
            if(StringUtils.isNotBlank(news.getUpdateTime())){
                CMUser user = this.cmUserMapper.selectByPrimaryKey(news.getUpdateUser());
                news.setUpdateTime(DateFormat.timestampToString(news.getUpdateTime(),DateFormat.YYYY_MM_DD_HH_MM_SS));
                if(user!=null){
                    news.setUpdateUser(user.getUserName());
                }else{
                    news.setUpdateUser("");
                }
            }
        }
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }
    /**
     * 插入新闻纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteDonationInstance> insertRecord(WebsiteDonationInstance record) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<WebsiteDonationInstance>();

        String loginUserCd = SessionUtils.getLoginUserCd();

        String nowDate = DateUtils.getNowServerDateTime();
        if(StringUtils.isNotBlank(record.getCnid())){
            record.setCnEnFlag("1");
            WebsiteDonationInstance ns = this.websiteDonationInstanceMapper.selectByPrimaryKey(record.getCnid());
            if(ns!=null){
                ns.setHasEnFlag("1");
                this.websiteDonationInstanceMapper.updateByPrimaryKeySelective(ns);
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

        this.websiteDonationInstanceMapper.insertSelective(record);

        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

    /**
     * 更新新闻纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteDonationInstance> updateRecord(WebsiteDonationInstance record) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<WebsiteDonationInstance>();

        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        if(StringUtils.isNotBlank(record.getId())){
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            this.websiteDonationInstanceMapper.updateByPrimaryKeySelective(record);

        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

    /**
     * 获取新闻记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteDonationInstance> getRecord(WebsiteDonationInstance record) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<>();
        WebsiteDonationInstance ws = new WebsiteDonationInstance();
        WebsiteDonationInstanceExample example = new WebsiteDonationInstanceExample();
        WebsiteDonationInstanceExample.Criteria criteria = example.createCriteria();
        if("0".equals(record.getCnEnFlag())){
        	criteria.andIdEqualTo(record.getId());
            List<WebsiteDonationInstance> list=this.websiteDonationInstanceMapper.selectByExampleWithBLOBs(example);
            if(list != null && list.size() > 0){
            	ws = list.get(0);
            }
        }else if("0".equals(record.getHasEnFlag())){
        	criteria.andIdEqualTo(record.getId());
            List<WebsiteDonationInstance> list=this.websiteDonationInstanceMapper.selectByExampleWithBLOBs(example);
            if(list != null && list.size() > 0){
            	ws = list.get(0);
            }
            ws.setCnid(ws.getId());
            ws.setId("");
        }else{
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(record.getId());
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteDonationInstance> list = this.websiteDonationInstanceMapper.selectByExampleWithBLOBs(example);
            if(list.size()>0){
                ws=list.get(0);
            }
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }

    /**
     * 删除订单数据
     * @param id
     */
    @Override
    public ServiceResult<WebsiteDonationInstance> removeRecord(String id) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<WebsiteDonationInstance>();
        WebsiteDonationInstance ws = new WebsiteDonationInstance();
        ws=this.websiteDonationInstanceMapper.selectByPrimaryKey(id);
        ws.setDelFlag("1");
        if(ws!=null){
            int cnt = this.websiteDonationInstanceMapper.updateByPrimaryKeySelective(ws);
            WebsiteDonationInstanceExample example = new WebsiteDonationInstanceExample();
            WebsiteDonationInstanceExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(id);
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteDonationInstance> list = this.websiteDonationInstanceMapper.selectByExample(example);
            if(list.size()>0){
                list.get(0).setDelFlag("1");
                int cn =this.websiteDonationInstanceMapper.updateByPrimaryKeySelective(list.get(0));
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

    /**
     * 获取新闻记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteDonationInstance> getDonationRecord(WebsiteDonationInstance record) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<>();
        WebsiteDonationInstance ws = new WebsiteDonationInstance();
        ws=this.websiteDonationInstanceMapper.selectByPrimaryKey(record.getId());
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }
    /**
     * 获取英文记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteDonationInstance> getEnDonationRecord(WebsiteDonationInstance record) {
        ServiceResult<WebsiteDonationInstance> result = new ServiceResult<>();
        WebsiteDonationInstance ws = new WebsiteDonationInstance();
        WebsiteDonationInstanceExample example = new WebsiteDonationInstanceExample();
        WebsiteDonationInstanceExample.Criteria criteria = example.createCriteria();
        criteria.andCnidEqualTo(record.getId());
        List<WebsiteDonationInstance> list = this.websiteDonationInstanceMapper.selectByExampleWithBLOBs(example);
        if(list.size()>0){
            ws = list.get(0);
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }
	/**
	 *(non-Javadoc)
	 * <p>Title: count</p>
	 * <p>Description: 获取捐赠纪实总条数</p>
	 * @return
	 * @see com.website.service.enterprise.WebsiteDonationInstanceService#count()
	 */
	
	@Override
	public int count(ExtWebsiteDonationInstanceModel form) {
		WebsiteDonationInstanceExample example = new WebsiteDonationInstanceExample();
		example.createCriteria().andDelFlagEqualTo("0").andCnEnFlagEqualTo(form.getCnEnFlag());
		return this.websiteDonationInstanceMapper.countByExample(example);
	}

}
