package com.website.mybatis.bean.auto.system;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class CMSequence extends BaseBean implements Serializable {
    private String name;

    private Integer currentValue;

    private Integer increment;

    private String notes;

    private String delFlag;

    private String createGroupCd;

    private String createUserCd;

    private String createDate;

    private String updateGroupCd;

    private String updateUserCd;

    private String updateDate;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
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

    public String getCreateGroupCd() {
        return createGroupCd;
    }

    public void setCreateGroupCd(String createGroupCd) {
        this.createGroupCd = createGroupCd == null ? null : createGroupCd.trim();
    }

    public String getCreateUserCd() {
        return createUserCd;
    }

    public void setCreateUserCd(String createUserCd) {
        this.createUserCd = createUserCd == null ? null : createUserCd.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUpdateGroupCd() {
        return updateGroupCd;
    }

    public void setUpdateGroupCd(String updateGroupCd) {
        this.updateGroupCd = updateGroupCd == null ? null : updateGroupCd.trim();
    }

    public String getUpdateUserCd() {
        return updateUserCd;
    }

    public void setUpdateUserCd(String updateUserCd) {
        this.updateUserCd = updateUserCd == null ? null : updateUserCd.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}