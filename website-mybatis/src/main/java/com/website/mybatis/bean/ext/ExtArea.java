package com.website.mybatis.bean.ext;


import java.io.Serializable;

import com.website.mybatis.bean.BaseBean;

public class ExtArea extends BaseBean implements Serializable {
    private String code;

    private String name;

    private Integer isprovince;

    private Integer iscity;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIsprovince() {
        return isprovince;
    }

    public void setIsprovince(Integer isprovince) {
        this.isprovince = isprovince;
    }

    public Integer getIscity() {
        return iscity;
    }

    public void setIscity(Integer iscity) {
        this.iscity = iscity;
    }
}