package com.website.service.impl.product;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.*;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.ExtWebsiteCompanyNewsModel;
import com.website.service.enterprise.WebsiteCompanyNewsService;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.product.WebsiteProductService;
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
public class WebsiteProductServiceImpl extends BaseServiceImpl implements WebsiteProductService {

    /**
     * 获取列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<WebsiteProductWithBLOBs>> findProductList(WebsiteProduct record) {
        ServiceResult<List<WebsiteProductWithBLOBs>> result = new ServiceResult<>();
        WebsiteProductExample example = new WebsiteProductExample();
        WebsiteProductExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(record.getCnEnFlag())){
            criteria.andCnEnFlagEqualTo(record.getCnEnFlag());
        }else{
            criteria.andCnEnFlagEqualTo("0");
        }
        if(StringUtils.isNotBlank(record.getHasEnFlag())){
            criteria.andHasEnFlagEqualTo(record.getHasEnFlag());
        }
//        if("0".equals(record.getCnEnFlag())){
//        	example.setOrderByClause("id desc");
//        }else{
//        	example.setOrderByClause("cnId desc");
//        }
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
        example.setOrderByClause("sort_number asc");

        List<WebsiteProductWithBLOBs> roleList = this.websiteProductMapper.selectByExampleWithBLOBs(example);
        for(WebsiteProductWithBLOBs product : roleList){
            if(StringUtils.isNotBlank(product.getUpdateTime())){
                CMUser user = this.cmUserMapper.selectByPrimaryKey(product.getUpdateUser());
                product.setUpdateTime(DateFormat.timestampToString(product.getUpdateTime(),DateFormat.YYYY_MM_DD_HH_MM_SS));
                if(user!=null){
                    product.setUpdateUser(user.getUserName());
                }else{
                    product.setUpdateUser("");
                }
            }
        }
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }
    /**
     * 插入纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteProductWithBLOBs> insertRecord(WebsiteProductWithBLOBs record) {
        ServiceResult<WebsiteProductWithBLOBs> result = new ServiceResult<WebsiteProductWithBLOBs>();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        if(StringUtils.isNotBlank(record.getCnid())){
            record.setCnEnFlag("1");
            WebsiteProductWithBLOBs ns = this.websiteProductMapper.selectByPrimaryKey(record.getCnid());
            if(ns!=null){
                ns.setHasEnFlag("1");
                this.websiteProductMapper.updateByPrimaryKeySelective(ns);
            }
        }else{
            WebsiteProductExample example = new WebsiteProductExample();
            WebsiteProductExample.Criteria criteria = example.createCriteria();
            criteria.andCnEnFlagEqualTo("0");
            List<WebsiteProductWithBLOBs> roleList = this.websiteProductMapper.selectByExampleWithBLOBs(example);
            if(roleList.size()>4){
                result.setMessage("不可超过5条产品服务");
                result.setSuccess(false);
                return result;
            }

            record.setCnEnFlag("0");//中文标识
            record.setHasEnFlag("0");//无英文版
        }
        record.setId(UUID.randomUUID().toString());
        record.setDelFlag("0");//删除标识
        record.setCreateUser(loginUserCd);
        record.setCreateTime(nowDate);
        record.setUpdateUser(loginUserCd);
        record.setUpdateTime(nowDate);

        this.websiteProductMapper.insertSelective(record);

        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

    /**
     * 更新纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteProductWithBLOBs> updateRecord(WebsiteProductWithBLOBs record) {
        ServiceResult<WebsiteProductWithBLOBs> result = new ServiceResult<WebsiteProductWithBLOBs>();

        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
        if(StringUtils.isNotBlank(record.getId())){
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            int count = this.websiteProductMapper.updateByPrimaryKeySelective(record);
            if(count>0){
                result.setMessage("更新成功");
                result.setSuccess(true);
            }else{
                result.setMessage("更新失败");
                result.setSuccess(false);
            }
        }else{
            result.setMessage("更新失败");
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
    public ServiceResult<WebsiteProductWithBLOBs> getRecord(WebsiteProductWithBLOBs record) {
        ServiceResult<WebsiteProductWithBLOBs> result = new ServiceResult<>();
        WebsiteProductWithBLOBs ws = new WebsiteProductWithBLOBs();
        if("0".equals(record.getCnEnFlag())){
            ws=this.websiteProductMapper.selectByPrimaryKey(record.getId());
        }else if("0".equals(record.getHasEnFlag())){
            ws=this.websiteProductMapper.selectByPrimaryKey(record.getId());
            ws.setCnEnFlag("1");
            ws.setCnid(ws.getId());
            ws.setId("");
        }else{
            WebsiteProductExample example = new WebsiteProductExample();
            WebsiteProductExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo("0");//未删除
            criteria.andCnidEqualTo(record.getId());
            example.setOrderByClause(" update_time DESC");
            example.setLimitStart(0);
            example.setLimitEnd(1);
            List<WebsiteProductWithBLOBs> list = this.websiteProductMapper.selectByExampleWithBLOBs(example);
            if(list.size()>0){
                ws=list.get(0);
            }
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }
	/**
	 *(non-Javadoc)
	 * <p>Title: insertConsult</p>
	 * <p>Description: 添加免费咨询记录</p>
	 * @param form
	 * @return
	 * @see com.website.service.product.WebsiteProductService#insertConsult(com.website.mybatis.bean.auto.WebsiteConsult)
	 */
	
	@Override
	public ServiceResult<WebsiteConsult> insertConsult(WebsiteConsult form) {
		ServiceResult<WebsiteConsult> result = new ServiceResult<WebsiteConsult>();
        String consultDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String nowDate = DateUtils.getNowServerDateTime();
        form.setConsultTime(consultDate);
        String id = UUID.randomUUID().toString();
        form.setId(id);
        try {
            this.websiteConsultMapper.insertSelective(form);
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

}
