package com.website.mybatis.bean.auto;

import java.io.Serializable;

public class WebsiteIndustryWithBLOBs extends WebsiteIndustry implements Serializable {
    private String industryInfoZh;

    private String industryInfoEn;

    private static final long serialVersionUID = 1L;

    public String getIndustryInfoZh() {
        return industryInfoZh;
    }

    public void setIndustryInfoZh(String industryInfoZh) {
        this.industryInfoZh = industryInfoZh == null ? null : industryInfoZh.trim();
    }

    public String getIndustryInfoEn() {
        return industryInfoEn;
    }

    public void setIndustryInfoEn(String industryInfoEn) {
        this.industryInfoEn = industryInfoEn == null ? null : industryInfoEn.trim();
    }
}