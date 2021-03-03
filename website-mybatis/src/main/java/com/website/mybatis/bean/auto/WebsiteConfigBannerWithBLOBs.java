package com.website.mybatis.bean.auto;

import java.io.Serializable;

public class WebsiteConfigBannerWithBLOBs extends WebsiteConfigBanner implements Serializable {
    private String linkShare;

    private String linkChinese;

    private String linkEnglish;

    private static final long serialVersionUID = 1L;

    public String getLinkShare() {
        return linkShare;
    }

    public void setLinkShare(String linkShare) {
        this.linkShare = linkShare == null ? null : linkShare.trim();
    }

    public String getLinkChinese() {
        return linkChinese;
    }

    public void setLinkChinese(String linkChinese) {
        this.linkChinese = linkChinese == null ? null : linkChinese.trim();
    }

    public String getLinkEnglish() {
        return linkEnglish;
    }

    public void setLinkEnglish(String linkEnglish) {
        this.linkEnglish = linkEnglish == null ? null : linkEnglish.trim();
    }
}