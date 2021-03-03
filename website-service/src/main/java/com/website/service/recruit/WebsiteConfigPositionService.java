package com.website.service.recruit;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.session.LoginUserInfo;
import com.website.mybatis.bean.auto.*;
import com.website.mybatis.bean.ext.ExtHrConfigPositionType;
import com.website.service.BaseService;

import java.util.List;

/**
 * @Auther: hzm
 * @Date: 2018/5/29 11:33
 * @Description:
 */
public interface WebsiteConfigPositionService extends BaseService {

    /**
     * 获取岗位类别列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<WebsiteConfigPosition>> findConfigPositionList(WebsiteConfigPosition record);
    /**
     * 插入岗位类别
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteConfigPosition> insertRecord(WebsiteConfigPosition record);
    /**
     * 更新岗位类别
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteConfigPosition> updateRecord(WebsiteConfigPosition record);
    /**
     * 获取岗位类别纪录
     *
     * @param record
     * @return
     */
    public ServiceResult<WebsiteConfigPosition> getRecord(WebsiteConfigPosition record);
    /**
     * 删除岗位类别记录
     *
     * @param
     * @return
     */
    public ServiceResult<WebsiteConfigPosition> removeRecord(String id);
    /**
     * 获取适用职位
     *
     * @param
     * @return
     */
    public ServiceResult<List<ExtHrConfigPositionType>> getPositionTypeList(CMDepartmentPosition record, String departmentId, String positionIds);
    /**
     * 岗位类别数据列表查询（带模糊查询）
     * @param record
     * @return
     */
    public ServiceResult<List<HrConfigPositionType>> getRecordList(HrConfigPositionType record);
    /**
     * 获取角色列表
     *
     * @param record
     * @return
     */
    public ServiceResult<List<HrConfigPosition>> getRecordList(HrConfigPosition record);

}
