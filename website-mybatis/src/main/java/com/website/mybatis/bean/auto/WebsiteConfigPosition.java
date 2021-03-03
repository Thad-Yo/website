package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class WebsiteConfigPosition extends BaseBean implements Serializable {
    private String id;

    private String positionName;

    private String matchingPositionIds;

    private String matchingPosition;

    private String positionIntroduce;

    private String delFlag;

    private String createUser;

    private String createTime;

    private String updateUser;

    private String updateTime;

    private Integer sortNumber;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public String getMatchingPositionIds() {
        return matchingPositionIds;
    }

    public void setMatchingPositionIds(String matchingPositionIds) {
        this.matchingPositionIds = matchingPositionIds == null ? null : matchingPositionIds.trim();
    }

    public String getMatchingPosition() {
        return matchingPosition;
    }

    public void setMatchingPosition(String matchingPosition) {
        this.matchingPosition = matchingPosition == null ? null : matchingPosition.trim();
    }

    public String getPositionIntroduce() {
        return positionIntroduce;
    }

    public void setPositionIntroduce(String positionIntroduce) {
        this.positionIntroduce = positionIntroduce == null ? null : positionIntroduce.trim();
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

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }
}