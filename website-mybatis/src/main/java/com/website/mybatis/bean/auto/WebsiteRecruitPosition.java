package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteRecruitPosition extends BaseBean implements Serializable {
    private Integer id;

    private Integer recruitPositionId;

    private String recruitPosition;

    private String salary;

    private String recruitCity;

    private String recruitCityName;

    private String recruitType;

    private String positionType;

    private String positionTypeName;

    private String status;

    private String delFlag;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private String positionIntroduce;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecruitPositionId() {
        return recruitPositionId;
    }

    public void setRecruitPositionId(Integer recruitPositionId) {
        this.recruitPositionId = recruitPositionId;
    }

    public String getRecruitPosition() {
        return recruitPosition;
    }

    public void setRecruitPosition(String recruitPosition) {
        this.recruitPosition = recruitPosition == null ? null : recruitPosition.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getRecruitCity() {
        return recruitCity;
    }

    public void setRecruitCity(String recruitCity) {
        this.recruitCity = recruitCity == null ? null : recruitCity.trim();
    }

    public String getRecruitCityName() {
        return recruitCityName;
    }

    public void setRecruitCityName(String recruitCityName) {
        this.recruitCityName = recruitCityName == null ? null : recruitCityName.trim();
    }

    public String getRecruitType() {
        return recruitType;
    }

    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType == null ? null : recruitType.trim();
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType == null ? null : positionType.trim();
    }

    public String getPositionTypeName() {
        return positionTypeName;
    }

    public void setPositionTypeName(String positionTypeName) {
        this.positionTypeName = positionTypeName == null ? null : positionTypeName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getPositionIntroduce() {
        return positionIntroduce;
    }

    public void setPositionIntroduce(String positionIntroduce) {
        this.positionIntroduce = positionIntroduce == null ? null : positionIntroduce.trim();
    }
}