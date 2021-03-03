package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteProduct;
import com.website.mybatis.bean.auto.WebsiteProductExample;
import com.website.mybatis.bean.auto.WebsiteProductWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteProductMapper {
    int countByExample(WebsiteProductExample example);

    int deleteByExample(WebsiteProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(WebsiteProductWithBLOBs record);

    int insertSelective(WebsiteProductWithBLOBs record);

    List<WebsiteProductWithBLOBs> selectByExampleWithBLOBs(WebsiteProductExample example);

    List<WebsiteProduct> selectByExample(WebsiteProductExample example);

    WebsiteProductWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WebsiteProductWithBLOBs record, @Param("example") WebsiteProductExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteProductWithBLOBs record, @Param("example") WebsiteProductExample example);

    int updateByExample(@Param("record") WebsiteProduct record, @Param("example") WebsiteProductExample example);

    int updateByPrimaryKeySelective(WebsiteProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WebsiteProductWithBLOBs record);

    int updateByPrimaryKey(WebsiteProduct record);
}