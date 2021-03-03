package com.website.mybatis.bean.ext;

import com.website.mybatis.bean.auto.CMDepartmentPosition;
import lombok.Data;

@Data
public class ExtCMDepartmentPosition extends CMDepartmentPosition {
	private String positionTypeName;
	private String positionTypeCode;
	private String groupby;//设置分组状态
}
