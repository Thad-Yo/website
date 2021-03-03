package com.website.mybatis.mapper.ext.system;


import java.util.List;

import com.website.mybatis.bean.ext.system.ExtDepartmentModel;


public interface ExtDepartmentMapper {

    /**
     * 获取部门
     *
     * @param param
     * @return
     */
    List<ExtDepartmentModel> selectDepartment(ExtDepartmentModel param);


    /**
     * 获取部门
     *
     * @param param
     * @return
     */
    List<ExtDepartmentModel> selectDepartmentWithUserCnt(ExtDepartmentModel param);


	/**  
	 * <p>Title: selectDepartmentByDepartmentPCd</p>
	 * <p>Description: 获取国内催收中心下的各个分公司</p>
	 * @param param
	 * @return
	 */ 
	
	List<ExtDepartmentModel> selectDepartmentByDepartmentPCd(ExtDepartmentModel param);
    


}