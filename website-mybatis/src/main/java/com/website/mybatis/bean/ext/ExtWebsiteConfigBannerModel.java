package com.website.mybatis.bean.ext;

import java.util.List;

import lombok.Data;

@Data
public class ExtWebsiteConfigBannerModel {
	private String id;

    private String imgChineseAdress;

    private String imgEnglishAdress;

    private String bannerNumber;

    private String imageLink;

    private String issue;

    private String createTime;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private String deleteFlag;

    private String linkShare;

    private String linkChinese;

    private String linkEnglish;
    
    private List<String> dropImg;
    
    private String address;

}