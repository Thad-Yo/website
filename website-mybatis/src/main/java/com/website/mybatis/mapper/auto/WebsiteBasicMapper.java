package com.website.mybatis.mapper.auto;

import com.website.mybatis.bean.auto.WebsiteBasic;
import com.website.mybatis.bean.auto.WebsiteBasicExample;
import com.website.mybatis.bean.auto.WebsiteBasicWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebsiteBasicMapper {
    int countByExample(WebsiteBasicExample example);

    int deleteByExample(WebsiteBasicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteBasicWithBLOBs record);

    int insertSelective(WebsiteBasicWithBLOBs record);

    List<WebsiteBasicWithBLOBs> selectByExampleWithBLOBs(WebsiteBasicExample example);

    List<WebsiteBasic> selectByExample(WebsiteBasicExample example);

    WebsiteBasicWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebsiteBasicWithBLOBs record, @Param("example") WebsiteBasicExample example);

    int updateByExampleWithBLOBs(@Param("record") WebsiteBasicWithBLOBs record, @Param("example") WebsiteBasicExample example);

    int updateByExample(@Param("record") WebsiteBasic record, @Param("example") WebsiteBasicExample example);

    int updateByPrimaryKeySelective(WebsiteBasicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WebsiteBasicWithBLOBs record);

    int updateByPrimaryKey(WebsiteBasic record);
}