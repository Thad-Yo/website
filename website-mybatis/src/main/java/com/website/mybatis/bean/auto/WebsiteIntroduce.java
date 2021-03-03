package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteIntroduce extends BaseBean implements Serializable {
    private Integer id;

    private String introduce;

    private String introduceEng;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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