package com.website.mybatis.bean.ext;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;

/**
 * @Auther: mxy
 * @Date: 2018/12/03 15:46
 * @Description: “我们的员工”模块数据模型
 */
@Data
public class ExtWebsiteCompanyCultureModel {
    private String id;
    private String src;
    private String subSrc;
    private String titleCN;
    private String titleEN;
    private String title;
    private String text;
    private String href;
    private ArrayList<ExtWebsiteCompanyCultureModel> childList = Lists.newArrayList();
    public void addChild(ExtWebsiteCompanyCultureModel child){
        childList.add(child);
    }
}

