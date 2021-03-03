package com.website.mybatis.bean.ext;


import com.website.mybatis.bean.auto.HrConfigPosition;
import com.website.mybatis.bean.auto.HrConfigPositionType;
import lombok.Data;

import java.util.List;

@Data
public class ExtHrConfigPositionType extends HrConfigPositionType {
	private List<HrConfigPosition> positionList;
	private List<ExtCMDepartmentPosition> departmentPostionList;
}
