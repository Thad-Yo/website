package com.website.mybatis.mapper.ext;

import com.website.mybatis.bean.auto.WebsiteBasic;
import com.website.mybatis.bean.auto.WebsiteBasicExample;
import com.website.mybatis.bean.auto.WebsiteBasicWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteDev;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtWebsiteBasicMapper {
   
    int delete(WebsiteBasic example);

    int insert(WebsiteBasic record);
    
    WebsiteBasicWithBLOBs select(String id);

}