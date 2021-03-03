package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteOurStaff;
import com.website.mybatis.bean.auto.WebsiteOurStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteOurStaffMapper {
    int countByExample(WebsiteOurStaffExample example);

    int deleteByExample(WebsiteOurStaffExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteOurStaff record);

    int insertSelective(WebsiteOurStaff record);

    List<WebsiteOurStaff> selectByExample(WebsiteOurStaffExample example);

    WebsiteOurStaff selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteOurStaff record, @Param("example") WebsiteOurStaffExample example);

    int updateByExample(@Param("record") WebsiteOurStaff record, @Param("example") WebsiteOurStaffExample example);

    int updateByPrimaryKeySelective(WebsiteOurStaff record);

    int updateByPrimaryKey(WebsiteOurStaff record);
}