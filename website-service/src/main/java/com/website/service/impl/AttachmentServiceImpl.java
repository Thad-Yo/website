package com.website.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.string.GetterUtil;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.auto.system.CTAttachmentExample;
import com.website.mybatis.bean.ext.system.ExtAttachment;
import com.website.service.AttachmentService;

@Service
public class AttachmentServiceImpl extends BaseServiceImpl
        implements
        AttachmentService {
    private static final String THIS_CLASS = AttachmentServiceImpl.class
            .getName();

    /**
     * 获取表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<CTAttachment>> getRecordList(
            ExtAttachment record) {
        ServiceResult<List<CTAttachment>> result = new ServiceResult<>();
        CTAttachmentExample example = new CTAttachmentExample();
        CTAttachmentExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);

        if (StringUtils.isNotEmpty(record.getFileId())) {
            criteria.andFileIdEqualTo(record.getFileId());
        }
        if (StringUtils.isNotEmpty(record.getItemId())) {
            criteria.andItemIdEqualTo(record.getItemId());
        }
        if (StringUtils.isNotEmpty(record.getAttType())) {
            criteria.andAttTypeEqualTo(record.getAttType());
        }
        if (record.getFileOrder() != null) {
            criteria.andFileOrderEqualTo(record.getFileOrder());
        }
        if (StringUtils.isNotEmpty(record.getFileType())) {
            criteria.andFileTypeEqualTo(record.getFileType());
        }
        // 排序
        if (StringUtils.isNotEmpty(record.getSort())) {
            example.setOrderByClause(
                    formatOrder(record.getSort(), record.getOrder()));
        } else {
            example.setOrderByClause("file_order asc");
        }

        List<CTAttachment> roleList = this.ctAttachmentMapper
                .selectByExample(example);
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CTAttachment> getRecord(ExtAttachment record) {
        ServiceResult<CTAttachment> result = new ServiceResult<>();
        result.setResult(this.ctAttachmentMapper
                .selectByPrimaryKey(GetterUtil.getInteger(record.getId())));
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CTAttachment> insertRecord(CMUser userInfo,
                                                    ExtAttachment record) {
        ServiceResult<CTAttachment> result = new ServiceResult<>();

        CTAttachment CTAttachment = new CTAttachment();
        BeanUtils.copyProperties(record, CTAttachment);

        CTAttachment.setDelFlag(ConstantsUtil.FLG_NORMAL);
        CTAttachment.setCreateGroupCd(userInfo.getUserId());
        CTAttachment.setCreateUserCd(userInfo.getUserId());
        CTAttachment.setCreateDate(DateUtils.getNowServerDateTime());
        CTAttachment.setUpdateGroupCd(userInfo.getUserId());
        CTAttachment.setUpdateUserCd(userInfo.getUserId());
        CTAttachment.setUpdateDate(DateUtils.getNowServerDateTime());
        this.ctAttachmentMapper.insert(CTAttachment);

        result.setResult(CTAttachment);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CTAttachment> updateRecord(CMUser userInfo,
                                                    ExtAttachment record) {
        ServiceResult<CTAttachment> result = new ServiceResult<>();

        CTAttachment CTAttachment = new CTAttachment();
        BeanUtils.copyProperties(record, CTAttachment);

        CTAttachment.setDelFlag(ConstantsUtil.FLG_NORMAL);
        CTAttachment.setUpdateGroupCd(userInfo.getUserId());
        CTAttachment.setUpdateUserCd(userInfo.getUserId());
        CTAttachment.setUpdateDate(DateUtils.getNowServerDateTime());
        this.ctAttachmentMapper.updateByPrimaryKeySelective(CTAttachment);

        result.setResult(CTAttachment);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CTAttachment> deleteRecord(CMUser userInfo,
                                                    ExtAttachment record) {
        ServiceResult<CTAttachment> result = new ServiceResult<>();
        CTAttachment CTAttachment = new CTAttachment();
        CTAttachment.setId(GetterUtil.getInteger(record.getId()));
        CTAttachment.setDelFlag(ConstantsUtil.FLG_DELETE);
        CTAttachment.setUpdateGroupCd(userInfo.getUserId());
        CTAttachment.setUpdateUserCd(userInfo.getUserId());
        CTAttachment.setUpdateDate(DateUtils.getNowServerDateTime());
        this.ctAttachmentMapper.updateByPrimaryKeySelective(CTAttachment);

        result.setResult(CTAttachment);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CTAttachment> updateByPrimaryKeySelective(CMUser userInfo,
                                                                   ExtAttachment record) {
        ServiceResult<CTAttachment> result = new ServiceResult<>();
        record.setDelFlag(ConstantsUtil.FLG_NORMAL);
        record.setUpdateGroupCd(userInfo.getUserId());
        record.setUpdateUserCd(userInfo.getUserId());
        record.setUpdateDate(DateUtils.getNowServerDateTime());
        this.ctAttachmentMapper.updateByPrimaryKeySelective(record);
        result.setResult(record);
        result.setSuccess(true);
        return result;
    }

	@Override
	public void deleteRecordByid(Integer id) {
		ctAttachmentMapper.deleteByPrimaryKey(id);
	}

}
