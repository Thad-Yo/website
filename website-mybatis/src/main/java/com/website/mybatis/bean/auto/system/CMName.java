package com.website.mybatis.bean.auto.system;

import java.io.Serializable;

public class CMName implements Serializable {
    private Integer id;

    private String nameClass;

    private String nameCd;

    private String name;

    private String sortKey;

    private String data;

    private String reserve01;

    private String reserve02;

    private String reserve03;

    private String notes;

    private String delFlag;

    private String createUserCd;

    private String createGroupCd;

    private String createDate;

    private String updateUserCd;

    private String updateGroupCd;

    private String updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass == null ? null : nameClass.trim();
    }

    public String getNameCd() {
        return nameCd;
    }

    public void setNameCd(String nameCd) {
        this.nameCd = nameCd == null ? null : nameCd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey == null ? null : sortKey.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getReserve01() {
        return reserve01;
    }

    public void setReserve01(String reserve01) {
        this.reserve01 = reserve01 == null ? null : reserve01.trim();
    }

    public String getReserve02() {
        return reserve02;
    }

    public void setReserve02(String reserve02) {
        this.reserve02 = reserve02 == null ? null : reserve02.trim();
    }

    public String getReserve03() {
        return reserve03;
    }

    public void setReserve03(String reserve03) {
        this.reserve03 = reserve03 == null ? null : reserve03.trim();
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

    public String getCreateUserCd() {
        return createUserCd;
    }

    public void setCreateUserCd(String createUserCd) {
        this.createUserCd = createUserCd == null ? null : createUserCd.trim();
    }

    public String getCreateGroupCd() {
        return createGroupCd;
    }

    public void setCreateGroupCd(String createGroupCd) {
        this.createGroupCd = createGroupCd == null ? null : createGroupCd.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUpdateUserCd() {
        return updateUserCd;
    }

    public void setUpdateUserCd(String updateUserCd) {
        this.updateUserCd = updateUserCd == null ? null : updateUserCd.trim();
    }

    public String getUpdateGroupCd() {
        return updateGroupCd;
    }

    public void setUpdateGroupCd(String updateGroupCd) {
        this.updateGroupCd = updateGroupCd == null ? null : updateGroupCd.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}