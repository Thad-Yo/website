package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteBasic extends BaseBean implements Serializable {
    private Integer id;

    private String time;

    private String khCount;

    private String ryCount;

    private String fgsCount;

    private String videoShareAdress;

    private String videoChineseAdress;

    private String videoEnglishAdress;

    private String checked;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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

    public String getFgsCount() {
        return fgsCount;
    }

    public void setFgsCount(String fgsCount) {
        this.fgsCount = fgsCount == null ? null : fgsCount.trim();
    }

    public String getVideoShareAdress() {
        return videoShareAdress;
    }

    public void setVideoShareAdress(String videoShareAdress) {
        this.videoShareAdress = videoShareAdress == null ? null : videoShareAdress.trim();
    }

    public String getVideoChineseAdress() {
        return videoChineseAdress;
    }

    public void setVideoChineseAdress(String videoChineseAdress) {
        this.videoChineseAdress = videoChineseAdress == null ? null : videoChineseAdress.trim();
    }

    public String getVideoEnglishAdress() {
        return videoEnglishAdress;
    }

    public void setVideoEnglishAdress(String videoEnglishAdress) {
        this.videoEnglishAdress = videoEnglishAdress == null ? null : videoEnglishAdress.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }
}