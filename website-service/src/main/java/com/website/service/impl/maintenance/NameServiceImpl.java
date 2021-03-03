package com.website.service.impl.maintenance;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.string.GetterUtil;
import com.website.mybatis.bean.auto.system.CMName;
import com.website.mybatis.bean.auto.system.CMNameExample;
import com.website.mybatis.bean.ext.system.ExtNameModel;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.maintenance.NameService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameServiceImpl extends BaseServiceImpl implements NameService {
    private static final String THIS_CLASS = NameServiceImpl.class.getName();

    /**
     * 获取角色列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<CMName>> getRecordList(ExtNameModel record) {
        ServiceResult<List<CMName>> result = new ServiceResult<>();
        CMNameExample example = new CMNameExample();
        CMNameExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);

        if (StringUtils.isNotEmpty(record.getNameClass())) {
            criteria.andNameClassEqualTo(record.getNameClass());
        }
        if (StringUtils.isNotEmpty(record.getNameCd())) {
            criteria.andNameCdEqualTo(record.getNameCd());
        }
        if (record.getNameCdList() != null && record.getNameCdList().size() > 0) {
            criteria.andNameCdIn(record.getNameCdList());
        }
        // 排序
        if (StringUtils.isNotEmpty(record.getSort())) {
            example.setOrderByClause(formatOrder(record.getSort(), record.getOrder()));
        } else {
            example.setOrderByClause("sort_key asc");
        }

        List<CMName> roleList = this.cmNameMapper.selectByExample(example);
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMName> getRecord(ExtNameModel record) {
        ServiceResult<CMName> result = new ServiceResult<>();
        result.setResult(this.cmNameMapper.selectByPrimaryKey(GetterUtil.getInteger(record.getId())));
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMName> insertRecord(LoginUserInfo userInfo, ExtNameModel record) {
        ServiceResult<CMName> result = new ServiceResult<>();

        CMName cmName = new CMName();
        BeanUtils.copyProperties(record, cmName);

        cmName.setDelFlag(ConstantsUtil.FLG_NORMAL);
        cmName.setCreateGroupCd(userInfo.getDepartmentId());
        cmName.setCreateUserCd(userInfo.getUserId());
        cmName.setCreateDate(DateUtils.getNowServerDateTime());
        cmName.setUpdateGroupCd(userInfo.getDepartmentId());
        cmName.setUpdateUserCd(userInfo.getUserId());
        cmName.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmNameMapper.insert(cmName);

        result.setResult(cmName);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMName> updateRecord(LoginUserInfo userInfo, ExtNameModel record) {
        ServiceResult<CMName> result = new ServiceResult<>();

        CMName cmName = new CMName();
        BeanUtils.copyProperties(record, cmName);

        cmName.setDelFlag(ConstantsUtil.FLG_NORMAL);
        cmName.setUpdateGroupCd(userInfo.getDepartmentId());
        cmName.setUpdateUserCd(userInfo.getUserId());
        cmName.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmNameMapper.updateByPrimaryKeySelective(cmName);

        result.setResult(cmName);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMName> deleteRecord(LoginUserInfo userInfo, ExtNameModel record) {
        ServiceResult<CMName> result = new ServiceResult<>();
        CMName cmName = new CMName();
        cmName.setId(GetterUtil.getInteger(record.getId()));
        cmName.setDelFlag(ConstantsUtil.FLG_DELETE);
        cmName.setUpdateGroupCd(userInfo.getDepartmentId());
        cmName.setUpdateUserCd(userInfo.getUserId());
        cmName.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmNameMapper.updateByPrimaryKeySelective(cmName);

        result.setResult(cmName);
        result.setSuccess(true);
        return result;
    }

}
