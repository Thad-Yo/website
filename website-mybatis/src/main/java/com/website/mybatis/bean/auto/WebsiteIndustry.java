package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteIndustry extends BaseBean implements Serializable {
    private String id;

    private String imgUrlZh;

    private String imgUrlEn;

    private String industryNameZh;

    private String industryNameEn;

    private String hasEn;

    private String updateUserCd;

    private String updateUserName;

    private String updateDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImgUrlZh() {
        return imgUrlZh;
    }

    public void setImgUrlZh(String imgUrlZh) {
        this.imgUrlZh = imgUrlZh == null ? null : imgUrlZh.trim();
    }

    public String getImgUrlEn() {
        return imgUrlEn;
    }

    public void setImgUrlEn(String imgUrlEn) {
        this.imgUrlEn = imgUrlEn == null ? null : imgUrlEn.trim();
    }

    public String getIndustryNameZh() {
        return industryNameZh;
    }

    public void setIndustryNameZh(String industryNameZh) {
        this.industryNameZh = industryNameZh == null ? null : industryNameZh.trim();
    }

    public String getIndustryNameEn() {
        return industryNameEn;
    }

    public void setIndustryNameEn(String industryNameEn) {
        this.industryNameEn = industryNameEn == null ? null : industryNameEn.trim();
    }

    public String getHasEn() {
        return hasEn;
    }

    public void setHasEn(String hasEn) {
        this.hasEn = hasEn == null ? null : hasEn.trim();
    }

    public String getUpdateUserCd() {
        return updateUserCd;
    }

    public void setUpdateUserCd(String updateUserCd) {
        this.updateUserCd = updateUserCd == null ? null : updateUserCd.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}