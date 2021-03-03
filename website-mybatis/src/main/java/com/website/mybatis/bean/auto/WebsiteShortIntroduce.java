package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteShortIntroduce extends BaseBean implements Serializable {
    private Integer id;

    private String titleCn;

    private String titleEn;

    private String introduceCn;

    private String introduceEn;

    private String imgUrlCn;

    private String imgUrlEn;

    private Integer sortNumber;

    private String delFlag;

    private String createTime;

    private String createUser;

    private String updateTime;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn == null ? null : titleCn.trim();
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn == null ? null : titleEn.trim();
    }

    public String getIntroduceCn() {
        return introduceCn;
    }

    public void setIntroduceCn(String introduceCn) {
        this.introduceCn = introduceCn == null ? null : introduceCn.trim();
    }

    public String getIntroduceEn() {
        return introduceEn;
    }

    public void setIntroduceEn(String introduceEn) {
        this.introduceEn = introduceEn == null ? null : introduceEn.trim();
    }

    public String getImgUrlCn() {
        return imgUrlCn;
    }

    public void setImgUrlCn(String imgUrlCn) {
        this.imgUrlCn = imgUrlCn == null ? null : imgUrlCn.trim();
    }

    public String getImgUrlEn() {
        return imgUrlEn;
    }

    public void setImgUrlEn(String imgUrlEn) {
        this.imgUrlEn = imgUrlEn == null ? null : imgUrlEn.trim();
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}