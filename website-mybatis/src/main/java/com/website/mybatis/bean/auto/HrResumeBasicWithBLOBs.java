package com.website.mybatis.bean.auto;

import java.io.Serializable;

public class HrResumeBasicWithBLOBs extends HrResumeBasic implements Serializable {
    private String selfEvaluation;

    private String studySituation;

    private static final long serialVersionUID = 1L;

    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation == null ? null : selfEvaluation.trim();
    }

    public String getStudySituation() {
        return studySituation;
    }

    public void setStudySituation(String studySituation) {
        this.studySituation = studySituation == null ? null : studySituation.trim();
    }
}