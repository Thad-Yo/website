package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteConfigBanner extends BaseBean implements Serializable {
    private Integer id;

    private String imgChineseAdress;

    private String imgEnglishAdress;

    private String bannerNumber;

    private String imageLink;

    private String issue;

    private String createTime;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private String deleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgChineseAdress() {
        return imgChineseAdress;
    }

    public void setImgChineseAdress(String imgChineseAdress) {
        this.imgChineseAdress = imgChineseAdress == null ? null : imgChineseAdress.trim();
    }

    public String getImgEnglishAdress() {
        return imgEnglishAdress;
    }

    public void setImgEnglishAdress(String imgEnglishAdress) {
        this.imgEnglishAdress = imgEnglishAdress == null ? null : imgEnglishAdress.trim();
    }

    public String getBannerNumber() {
        return bannerNumber;
    }

    public void setBannerNumber(String bannerNumber) {
        this.bannerNumber = bannerNumber == null ? null : bannerNumber.trim();
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink == null ? null : imageLink.trim();
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue == null ? null : issue.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}