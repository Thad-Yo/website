package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteScope extends BaseBean implements Serializable {
    private Integer id;

    private String year;

    private String fgsCount;

    private String khCount;

    private String ryCount;

    private String show;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getFgsCount() {
        return fgsCount;
    }

    public void setFgsCount(String fgsCount) {
        this.fgsCount = fgsCount == null ? null : fgsCount.trim();
    }

    public String getKhCount() {
        return khCount;
    }

    public void setKhCount(String khCount) {
        this.khCount = khCount == null ? null : khCount.trim();
    }

    public String getRyCount() {
        return ryCount;
    }

    public void setRyCount(String ryCount) {
        this.ryCount = ryCount == null ? null : ryCount.trim();
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show == null ? null : show.trim();
    }
}