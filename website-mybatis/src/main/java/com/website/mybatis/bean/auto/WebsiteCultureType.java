package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteCultureType extends BaseBean implements Serializable {
    private Integer id;

    private String cultureTypeCode;

    private String cultureTypeName;

    private String cultureTypeEnName;

    private String notes;

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

    public String getCultureTypeCode() {
        return cultureTypeCode;
    }

    public void setCultureTypeCode(String cultureTypeCode) {
        this.cultureTypeCode = cultureTypeCode == null ? null : cultureTypeCode.trim();
    }

    public String getCultureTypeName() {
        return cultureTypeName;
    }

    public void setCultureTypeName(String cultureTypeName) {
        this.cultureTypeName = cultureTypeName == null ? null : cultureTypeName.trim();
    }

    public String getCultureTypeEnName() {
        return cultureTypeEnName;
    }

    public void setCultureTypeEnName(String cultureTypeEnName) {
        this.cultureTypeEnName = cultureTypeEnName == null ? null : cultureTypeEnName.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
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