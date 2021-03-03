package com.website.service;

import com.website.common.util.bean.ServiceResult;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.ext.system.ExtAttachment;

import java.util.List;

/**
 *
 */
public interface AttachmentService extends BaseService {

    /**
     * 获取列表
     *
     * @param record
     * @return
     */
    ServiceResult<List<CTAttachment>> getRecordList(ExtAttachment record);

    /**
     * 获取名称
     *
     * @param record
     * @return
     */
    ServiceResult<CTAttachment> getRecord(ExtAttachment record);

    /**
     * 数据插入
     *
     * @param record
     */
    ServiceResult<CTAttachment> insertRecord(CMUser userInfo, ExtAttachment record);

    /**
     * 数据更新
     *
     * @param record
     */
    ServiceResult<CTAttachment> updateRecord(CMUser userInfo, ExtAttachment record);

    /**
     * 数据逻辑删除
     *
     * @param record
     */
    ServiceResult<CTAttachment> deleteRecord(CMUser userInfo, ExtAttachment record);
    /**
     * 根据id删除附件
     * @param record
     * @return
     */
    void deleteRecordByid(Integer id);

    ServiceResult<CTAttachment> updateByPrimaryKeySelective(CMUser userInfo, ExtAttachment record);

}
