package com.website.mybatis.bean.ext.system;


import com.website.mybatis.bean.BaseBean;
import com.website.mybatis.bean.ext.ExtCMDepartmentPosition;

import java.io.Serializable;
import java.util.List;

public class ExtWebConfigPositionType extends BaseBean implements Serializable {
    private Integer id;

    private String positionTypeName;

    private String positionTypeCode;

    private String notes;

    private String isUse;

    private String delFlag;

    private String createTime;

    private String createUserId;

    private String createUserName;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private static final long serialVersionUID = 1L;

    private List<ExtWebConfigPosition> positionList;
    private List<ExtCMDepartmentPosition> departmentPostionList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionTypeName() {
        return positionTypeName;
    }

    public void setPositionTypeName(String positionTypeName) {
        this.positionTypeName = positionTypeName == null ? null : positionTypeName.trim();
    }

    public String getPositionTypeCode() {
        return positionTypeCode;
    }

    public void setPositionTypeCode(String positionTypeCode) {
        this.positionTypeCode = positionTypeCode == null ? null : positionTypeCode.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
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
}