package com.website.mybatis.mapper.ext;

import com.website.mybatis.bean.auto.HrConfigPositionType;

import java.util.List;

/**
 * 自定义查询映射接口 
 * hr_config_position_type
 * @author WangYouzheng
 * 2017年10月23日15:04:07
 */
public interface ExtHrConfigPositionTypeMapper {
    List<HrConfigPositionType> selectPositionTypeList(HrConfigPositionType param);
}
