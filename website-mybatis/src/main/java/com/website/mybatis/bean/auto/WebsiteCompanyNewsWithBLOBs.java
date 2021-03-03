package com.website.mybatis.bean.auto;

import java.io.Serializable;

public class WebsiteCompanyNewsWithBLOBs extends WebsiteCompanyNews implements Serializable {

    private String content;

    private static final long serialVersionUID = 1L;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}