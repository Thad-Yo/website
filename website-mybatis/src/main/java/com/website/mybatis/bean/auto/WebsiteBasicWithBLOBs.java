package com.website.mybatis.bean.auto;

import java.io.Serializable;

public class WebsiteBasicWithBLOBs extends WebsiteBasic implements Serializable {
    private String introduce;

    private String introduceEng;

    private static final long serialVersionUID = 1L;

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getIntroduceEng() {
        return introduceEng;
    }

    public void setIntroduceEng(String introduceEng) {
        this.introduceEng = introduceEng == null ? null : introduceEng.trim();
    }
}