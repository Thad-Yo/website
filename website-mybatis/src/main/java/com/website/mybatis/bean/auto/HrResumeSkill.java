package com.website.mybatis.bean.auto;

import com.website.mybatis.bean.BaseBean;

import java.io.Serializable;

public class HrResumeSkill extends BaseBean implements Serializable {
    private Long id;

    private Long resumeNumber;

    private String skillName;

    private String skillEvaluate;

    private String delFlag;

    private String createTime;

    private String createUserId;

    private String createUserName;

    private String updateTime;

    private String updateUserId;

    private String updateUserName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResumeNumber() {
        return resumeNumber;
    }

    public void setResumeNumber(Long resumeNumber) {
        this.resumeNumber = resumeNumber;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName == null ? null : skillName.trim();
    }

    public String getSkillEvaluate() {
        return skillEvaluate;
    }

    public void setSkillEvaluate(String skillEvaluate) {
        this.skillEvaluate = skillEvaluate == null ? null : skillEvaluate.trim();
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