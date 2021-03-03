package com.website.mybatis.bean.auto;

import java.io.Serializable;

public class WebsiteProductWithBLOBs extends WebsiteProduct implements Serializable {
    private String summary;

    private String content;

    private static final long serialVersionUID = 1L;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}