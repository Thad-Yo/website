package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteDonationInstance;
import com.website.mybatis.bean.auto.WebsiteDonationInstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteDonationInstanceMapper {
    int countByExample(WebsiteDonationInstanceExample example);

    int deleteByExample(WebsiteDonationInstanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteDonationInstance record);

    int insertSelective(WebsiteDonationInstance record);

    List<WebsiteDonationInstance> selectByExampleWithBLOBs(WebsiteDonationInstanceExample example);

    List<WebsiteDonationInstance> selectByExample(WebsiteDonationInstanceExample example);

    WebsiteDonationInstance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteDonationInstance record, @Param("example") WebsiteDonationInstanceExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteDonationInstance record, @Param("example") WebsiteDonationInstanceExample example);

    int updateByExample(@Param("record") WebsiteDonationInstance record, @Param("example") WebsiteDonationInstanceExample example);

    int updateByPrimaryKeySelective(WebsiteDonationInstance record);

    int updateByPrimaryKeyWithBLOBs(WebsiteDonationInstance record);

    int updateByPrimaryKey(WebsiteDonationInstance record);
}