package com.website.mybatis.mapper.ext;

import com.website.mybatis.bean.auto.WebsiteScope;
import com.website.mybatis.bean.ext.ExtCMDepartmentPosition;

import java.util.List;

public interface ExtCMDepartmentPositionMapper {
	/**
	 * 查询上一级的岗位
	 */
	public List<ExtCMDepartmentPosition> selectDepartmentPositionFromDepartment(ExtCMDepartmentPosition record);
	
}