package com.website.service.impl.recruit;

import com.website.common.util.Utils;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.*;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.ext.ExtCMDepartmentPosition;
import com.website.mybatis.bean.ext.ExtHrConfigPositionType;
import com.website.mybatis.bean.ext.ExtWebsiteDonationInstanceModel;
import com.website.service.enterprise.WebsiteDonationInstanceService;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.recruit.WebsiteConfigPositionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:35
 * @Description:
 */
@Service
public class WebsiteConfigPositionServiceImpl extends BaseServiceImpl implements WebsiteConfigPositionService {

    /**
     * 获取岗位类别列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<WebsiteConfigPosition>> findConfigPositionList(WebsiteConfigPosition record) {
        ServiceResult<List<WebsiteConfigPosition>> result = new ServiceResult<>();
        WebsiteConfigPositionExample example = new WebsiteConfigPositionExample();
        WebsiteConfigPositionExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo("0");
        example.setOrderByClause("sort_number asc");
        List<WebsiteConfigPosition> list = this.websiteConfigPositionMapper.selectByExample(example);

        for(WebsiteConfigPosition position : list){
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
        result.setResult(list);
        result.setSuccess(true);
        return result;
    }
    /**
     * 插入岗位类别纪录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteConfigPosition> insertRecord(WebsiteConfigPosition record) {
        ServiceResult<WebsiteConfigPosition> result = new ServiceResult<>();

        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();
            record.setId(UUID.randomUUID().toString());
        record.setDelFlag("0");//删除标识
        record.setCreateUser(loginUserCd);
        record.setCreateTime(nowDate);
        record.setUpdateUser(loginUserCd);
        record.setUpdateTime(nowDate);

        this.websiteConfigPositionMapper.insertSelective(record);
        result.setResult(record);
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
    public ServiceResult<WebsiteConfigPosition> updateRecord(WebsiteConfigPosition record) {
        ServiceResult<WebsiteConfigPosition> result = new ServiceResult<>();

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
        if(StringUtils.isNotBlank(record.getId())){
            record.setUpdateUser(loginUserCd);
            record.setUpdateTime(nowDate);
            this.websiteConfigPositionMapper.updateByPrimaryKeySelective(record);

        }
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

    /**
     * 获取岗位类别记录
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<WebsiteConfigPosition> getRecord(WebsiteConfigPosition record) {
        ServiceResult<WebsiteConfigPosition> result = new ServiceResult<>();
        WebsiteConfigPosition ws = new WebsiteConfigPosition();
        WebsiteConfigPositionExample example = new WebsiteConfigPositionExample();
        WebsiteConfigPositionExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo("0");//未删除
        criteria.andIdEqualTo(record.getId());
        example.setOrderByClause(" update_time DESC");
        List<WebsiteConfigPosition> list = this.websiteConfigPositionMapper.selectByExample(example);
        if(list.size()>0){
            ws=list.get(0);
        }
        result.setResult(ws);
        result.setSuccess(true);
        return result;
    }

    /**
     * 删除数据
     * @param id
     */
    @Override
    public ServiceResult<WebsiteConfigPosition> removeRecord(String id) {
        ServiceResult<WebsiteConfigPosition> result = new ServiceResult<>();
        WebsiteConfigPosition ws = new WebsiteConfigPosition();
        ws=this.websiteConfigPositionMapper.selectByPrimaryKey(id);
        if(ws!=null){
            ws.setDelFlag("1");
            int cnt = this.websiteConfigPositionMapper.updateByPrimaryKeySelective(ws);
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
     * 封装岗位
     * @param record
     * @param positionIds
     * @param departmentId
     */
    @Override
    public ServiceResult<List<ExtHrConfigPositionType>> getPositionTypeList(CMDepartmentPosition record, String departmentId, String positionIds){
        ServiceResult<List<ExtHrConfigPositionType>> result = new ServiceResult<>();
        //查询大类
        HrConfigPositionType positionType= new HrConfigPositionType();
        positionType.setDelFlag(ConstantsUtil.FLG_NO);
        ServiceResult<List<HrConfigPositionType>> potypeResult = this.getRecordList(positionType);
        if(potypeResult.getSuccess()){
            //组合list
            List<ExtHrConfigPositionType> extPoTypeList = new ArrayList<ExtHrConfigPositionType>();
            List<HrConfigPositionType> listpoType = potypeResult.getResult();

            //如果大类不为空，遍历查询岗位
            if(listpoType != null && listpoType.size() > 0){
                for(HrConfigPositionType poType : listpoType){
                    ExtHrConfigPositionType extPoType = new ExtHrConfigPositionType();
                    extPoType.setPositionTypeCode(poType.getPositionTypeCode());
                    extPoType.setPositionTypeName(poType.getPositionTypeName());
                    extPoType.setId(poType.getId());
                    HrConfigPosition po = new HrConfigPosition();
                    po.setPositionTypeId(poType.getId());
                    po.setSort("position_type_id");
                    po.setDelFlag(ConstantsUtil.FLG_NO);
                    ServiceResult<List<HrConfigPosition>> listpo = this.getRecordList(po);
                    //判断是否成功
                    if(listpo.getSuccess() && listpo.getResult() != null && listpo.getResult().size()>0){
                        extPoType.setPositionList(listpo.getResult());
                        //判断是否已经被选中
                        this.isCheckbox(listpo.getResult(), positionIds, departmentId);
                        extPoTypeList.add(extPoType);
                    }

                }
            }
            result.setResult(extPoTypeList);
            result.setSuccess(true);
            return result;
        }else{
            result.setSuccess(false);
            result.setMessage("大类为空");
            return result;
        }
    }
    /**
     * 岗位类别数据列表查询（带模糊查询）
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<HrConfigPositionType>> getRecordList(HrConfigPositionType record) {
        ServiceResult<List<HrConfigPositionType>> result = new ServiceResult<List<HrConfigPositionType>>();
        if (StringUtils.isEmpty(record.getSort())) {
            record.setSort("t.create_time");
            record.setOrder(" DESC ");
        }
        record.setOrderByClause(formatOrder(record.getSort(), record.getOrder()));
//    	List<HrConfigPositionType> list = this.hrConfigPositionTypeMapper.selectByExample(null);
        List<HrConfigPositionType> list = this.extHrConfigPositionTypeMapper.selectPositionTypeList(record);
        result.setResult(list);
        if (list != null && list.size() > 0) {
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 获取角色列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<HrConfigPosition>> getRecordList(HrConfigPosition record) {
        ServiceResult<List<HrConfigPosition>> result = new ServiceResult<>();
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
        if (StringUtils.isNotEmpty(record.getSort())) {
            example.setOrderByClause(formatOrder(record.getSort(), record.getOrder()));
        } else {
            example.setOrderByClause("sort_key asc");
        }

        List<HrConfigPosition> roleList = this.hrConfigPositionMapper.selectByExample(example);
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }
    /**
     * p判断是否已经被选中
     */
    private boolean isCheckbox(List<HrConfigPosition> listHrcp, String positionIds, String departmentId){
        boolean bo = false;
        List<CMDepartmentPosition> listCmp = new ArrayList<CMDepartmentPosition>();
        if(StringUtils.isNoneBlank(departmentId)){
            CMDepartmentPosition cmp = new CMDepartmentPosition();
            cmp.setDepartmentId(Integer.valueOf(departmentId));
            ServiceResult<List<CMDepartmentPosition>> resCmp = this.getRecordList(cmp);
            listCmp = resCmp.getResult();
        }
//			List<HrConfigPosition> listHrcp = positionResult.getResult();
        //判断岗位是否已经保存
        for(int i = 0; i < listHrcp.size(); i++){
            listHrcp.get(i).setRemark(null);
            //判断是否是新选中的,如果是选中的，说明岗位已经发生变化，按照已经更改的显示
            if(StringUtils.isNotBlank(positionIds) && positionIds.split(";").length > 0){
                for(int j = 0; j < positionIds.split(";").length; j++){
                    if(String.valueOf(listHrcp.get(i).getId()).equals(positionIds.split(";")[j])){
                        listHrcp.get(i).setRemark("check");
                        break;
                    }
                }
            }else{
                for(int j = 0; j < listCmp.size(); j++){
                    if(listHrcp.get(i).getId().equals(listCmp.get(j).getPositionId())){
                        listHrcp.get(i).setRemark("check");
                        break;
                    }
                }
            }
        }
        return bo;
    }

    public ServiceResult<List<CMDepartmentPosition>> getRecordList(CMDepartmentPosition record) {
        ServiceResult<List<CMDepartmentPosition>> result = new ServiceResult<>();
        CMDepartmentPositionExample example = new CMDepartmentPositionExample();
        CMDepartmentPositionExample.Criteria cia = example.createCriteria();
        if(record.getDepartmentId() != null){
            cia.andDepartmentIdEqualTo(record.getDepartmentId());
        }
        if(record.getPositionId() != null){
            cia.andPositionIdEqualTo(record.getPositionId());
        }
        if(record.getPositionTypeId() != null){
            cia.andPositionTypeIdEqualTo(record.getPositionTypeId());
        }
        if(StringUtils.isNoneBlank(record.getPositionName())){
            cia.andPositionNameEqualTo(record.getPositionName());
        }
        if(StringUtils.isNotBlank(record.getPositionCode())){
            cia.andPositionCodeEqualTo(record.getPositionCode());
        }
        // 排序
        example.setOrderByClause(formatOrder(record.getSort(), record.getOrder()));

        List<CMDepartmentPosition> roleList = this.cmDepartmentPositionMapper.selectByExample(example);
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }

    /**
     * 格式化排序
     *
     * @param sort
     * @param order
     * @return
     */
    public String formatOrder(String sort, String order) {
        if (StringUtils.isNotBlank(sort)) {
            sort = Utils.camelToUnderline(sort);
            order = StringUtils.isNotBlank(order) ? order : "asc";
            return sort + " " + order;
        }
        return null;
    }

}
