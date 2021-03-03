package com.website.service.maintenance;

import com.website.common.util.bean.ServiceResult;
import com.website.common.util.session.LoginUserInfo;
import com.website.mybatis.bean.auto.system.CMName;
import com.website.mybatis.bean.ext.system.ExtNameModel;
import com.website.service.BaseService;

import java.util.List;

/**
 * Created by ZN on 2016/8/3.
 */
public interface NameService extends BaseService {

  /**
   * 获取列表
   *
   * @param record
   * @return
   */
  ServiceResult<List<CMName>> getRecordList(ExtNameModel record);

  /**
   * 获取名称
   *
   * @param record
   * @return
   */
  ServiceResult<CMName> getRecord(ExtNameModel record);

  /**
   * 数据插入
   *
   * @param record
   */
  ServiceResult<CMName> insertRecord(LoginUserInfo userInfo, ExtNameModel record);

  /**
   * 数据更新
   *
   * @param record
   */
  ServiceResult<CMName> updateRecord(LoginUserInfo userInfo, ExtNameModel record);

  /**
   * 数据逻辑删除
   *
   * @param record
   */
  ServiceResult<CMName> deleteRecord(LoginUserInfo userInfo, ExtNameModel record);

}
