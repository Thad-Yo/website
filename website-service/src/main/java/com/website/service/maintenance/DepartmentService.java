package com.website.service.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.session.LoginUserInfo;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMDepartmentUser;
import com.website.mybatis.bean.ext.system.AdminMenuBean;
import com.website.mybatis.bean.ext.system.ExtDepartmentModel;
import com.website.service.BaseService;

import java.util.List;

public interface DepartmentService extends BaseService {

    /**
     * 获取部门列表
     *
     * @return
     */
    ServiceResult<JSONArray> getRecordList(AdminMenuBean form);


    /**
     * 获取部门列表
     *
     * @return
     */
    ServiceResult<JSONArray> getRecordListWithUserCnt(AdminMenuBean form);
    
    /**
     * 获取部门
     *
     * @param param
     * @return
     */
    ServiceResult<List<ExtDepartmentModel>> selectDepartment(ExtDepartmentModel param);

    ServiceResult<List<ExtDepartmentModel>> selectDepartmentRes(ExtDepartmentModel form, String departmentPCd);
    /**
     * 获取单个部门
     *
     * @return
     */
    ServiceResult<ExtDepartmentModel> getRecord(String id);

    /**
     * 根据主键判断部门数据是否存在
     *
     * @return
     */
    ServiceResult<Integer> isExistsRecord(String menuId, String menuName);

    /**
     * 部门插入
     *
     * @param record
     */
    ServiceResult<CMDepartment> insertRecord(LoginUserInfo userInfo, ExtDepartmentModel record) throws Exception;

    /**
     * 部门更新
     *
     * @param record
     */
    ServiceResult<CMDepartment> updateRecord(LoginUserInfo userInfo, ExtDepartmentModel record) throws Exception;

    /**
     * 获取部门的子菜单
     *
     * @param departmentCd
     * @return
     */
    ServiceResult<List<String>> getAllChildDepartment(String departmentCd);


    /**
     * 获取用户所在的部门
     *
     * @param userId
     * @return
     */
    ServiceResult<List<CMDepartmentUser>> getDepartmentListByUserId(String userId);

    /**
     * 获取登录用户所管辖的部门
     *
     * @return
     */
    public ServiceResult<List<String>> getLoginUserDepartmentList();
    
    /**
     * 获取所有的分公司列表
     *
     * @return
     */
    List<CMDepartment> getBranchDepartmentList();
    
    /**
     * 根据已知的部门ID获取该部门以及所有父级的列表数据,排序由低级部门向高级部门排序
     * @param new List, departmentCd
     * @return
     */
    List<CMDepartment> getDepartmentParentsList(List<CMDepartment> departmentList, String departmentCd);


	/**  
	 * <p>Title: selectDepartment</p>
	 * <p>Description: 获取国内催收中心下的各个分公司</p>
	 * @param departmentPCd
	 * @return
	 */ 
	
	ServiceResult<JSONArray> selectDepartment(AdminMenuBean form, String departmentPCd);
	
	/**
	 * 
	 * <p>Title: selectCity</p>
	 * <p>Description: 获取国内催收中心下的各个分公司所在城市</p>
	 * @param form
	 * @param departmentPCd
	 * @return
	 */
	List<ExtDepartmentModel> selectCitys(String departmentPCd);
}
