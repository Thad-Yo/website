package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class HrResumeBasicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public HrResumeBasicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andResumeNumberIsNull() {
            addCriterion("resume_number is null");
            return (Criteria) this;
        }

        public Criteria andResumeNumberIsNotNull() {
            addCriterion("resume_number is not null");
            return (Criteria) this;
        }

        public Criteria andResumeNumberEqualTo(Long value) {
            addCriterion("resume_number =", value, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberNotEqualTo(Long value) {
            addCriterion("resume_number <>", value, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberGreaterThan(Long value) {
            addCriterion("resume_number >", value, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("resume_number >=", value, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberLessThan(Long value) {
            addCriterion("resume_number <", value, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberLessThanOrEqualTo(Long value) {
            addCriterion("resume_number <=", value, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberIn(List<Long> values) {
            addCriterion("resume_number in", values, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberNotIn(List<Long> values) {
            addCriterion("resume_number not in", values, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberBetween(Long value1, Long value2) {
            addCriterion("resume_number between", value1, value2, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andResumeNumberNotBetween(Long value1, Long value2) {
            addCriterion("resume_number not between", value1, value2, "resumeNumber");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdIsNull() {
            addCriterion("interviewer_id is null");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdIsNotNull() {
            addCriterion("interviewer_id is not null");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdEqualTo(Long value) {
            addCriterion("interviewer_id =", value, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdNotEqualTo(Long value) {
            addCriterion("interviewer_id <>", value, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdGreaterThan(Long value) {
            addCriterion("interviewer_id >", value, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("interviewer_id >=", value, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdLessThan(Long value) {
            addCriterion("interviewer_id <", value, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdLessThanOrEqualTo(Long value) {
            addCriterion("interviewer_id <=", value, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdIn(List<Long> values) {
            addCriterion("interviewer_id in", values, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdNotIn(List<Long> values) {
            addCriterion("interviewer_id not in", values, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdBetween(Long value1, Long value2) {
            addCriterion("interviewer_id between", value1, value2, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andInterviewerIdNotBetween(Long value1, Long value2) {
            addCriterion("interviewer_id not between", value1, value2, "interviewerId");
            return (Criteria) this;
        }

        public Criteria andGetTypeIsNull() {
            addCriterion("get_type is null");
            return (Criteria) this;
        }

        public Criteria andGetTypeIsNotNull() {
            addCriterion("get_type is not null");
            return (Criteria) this;
        }

        public Criteria andGetTypeEqualTo(String value) {
            addCriterion("get_type =", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeNotEqualTo(String value) {
            addCriterion("get_type <>", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeGreaterThan(String value) {
            addCriterion("get_type >", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("get_type >=", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeLessThan(String value) {
            addCriterion("get_type <", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeLessThanOrEqualTo(String value) {
            addCriterion("get_type <=", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeLike(String value) {
            addCriterion("get_type like", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeNotLike(String value) {
            addCriterion("get_type not like", value, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeIn(List<String> values) {
            addCriterion("get_type in", values, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeNotIn(List<String> values) {
            addCriterion("get_type not in", values, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeBetween(String value1, String value2) {
            addCriterion("get_type between", value1, value2, "getType");
            return (Criteria) this;
        }

        public Criteria andGetTypeNotBetween(String value1, String value2) {
            addCriterion("get_type not between", value1, value2, "getType");
            return (Criteria) this;
        }

        public Criteria andApplyPositionIsNull() {
            addCriterion("apply_position is null");
            return (Criteria) this;
        }

        public Criteria andApplyPositionIsNotNull() {
            addCriterion("apply_position is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPositionEqualTo(String value) {
            addCriterion("apply_position =", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionNotEqualTo(String value) {
            addCriterion("apply_position <>", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionGreaterThan(String value) {
            addCriterion("apply_position >", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionGreaterThanOrEqualTo(String value) {
            addCriterion("apply_position >=", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionLessThan(String value) {
            addCriterion("apply_position <", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionLessThanOrEqualTo(String value) {
            addCriterion("apply_position <=", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionLike(String value) {
            addCriterion("apply_position like", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionNotLike(String value) {
            addCriterion("apply_position not like", value, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionIn(List<String> values) {
            addCriterion("apply_position in", values, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionNotIn(List<String> values) {
            addCriterion("apply_position not in", values, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionBetween(String value1, String value2) {
            addCriterion("apply_position between", value1, value2, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andApplyPositionNotBetween(String value1, String value2) {
            addCriterion("apply_position not between", value1, value2, "applyPosition");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdIsNull() {
            addCriterion("resume_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdIsNotNull() {
            addCriterion("resume_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdEqualTo(Short value) {
            addCriterion("resume_channel_id =", value, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdNotEqualTo(Short value) {
            addCriterion("resume_channel_id <>", value, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdGreaterThan(Short value) {
            addCriterion("resume_channel_id >", value, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdGreaterThanOrEqualTo(Short value) {
            addCriterion("resume_channel_id >=", value, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdLessThan(Short value) {
            addCriterion("resume_channel_id <", value, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdLessThanOrEqualTo(Short value) {
            addCriterion("resume_channel_id <=", value, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdIn(List<Short> values) {
            addCriterion("resume_channel_id in", values, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdNotIn(List<Short> values) {
            addCriterion("resume_channel_id not in", values, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdBetween(Short value1, Short value2) {
            addCriterion("resume_channel_id between", value1, value2, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andResumeChannelIdNotBetween(Short value1, Short value2) {
            addCriterion("resume_channel_id not between", value1, value2, "resumeChannelId");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(String value) {
            addCriterion("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(String value) {
            addCriterion("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(String value) {
            addCriterion("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(String value) {
            addCriterion("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(String value) {
            addCriterion("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(String value) {
            addCriterion("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLike(String value) {
            addCriterion("apply_date like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotLike(String value) {
            addCriterion("apply_date not like", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<String> values) {
            addCriterion("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<String> values) {
            addCriterion("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(String value1, String value2) {
            addCriterion("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(String value1, String value2) {
            addCriterion("apply_date not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andIsOnIsNull() {
            addCriterion("is_on is null");
            return (Criteria) this;
        }

        public Criteria andIsOnIsNotNull() {
            addCriterion("is_on is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnEqualTo(String value) {
            addCriterion("is_on =", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnNotEqualTo(String value) {
            addCriterion("is_on <>", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnGreaterThan(String value) {
            addCriterion("is_on >", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnGreaterThanOrEqualTo(String value) {
            addCriterion("is_on >=", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnLessThan(String value) {
            addCriterion("is_on <", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnLessThanOrEqualTo(String value) {
            addCriterion("is_on <=", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnLike(String value) {
            addCriterion("is_on like", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnNotLike(String value) {
            addCriterion("is_on not like", value, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnIn(List<String> values) {
            addCriterion("is_on in", values, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnNotIn(List<String> values) {
            addCriterion("is_on not in", values, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnBetween(String value1, String value2) {
            addCriterion("is_on between", value1, value2, "isOn");
            return (Criteria) this;
        }

        public Criteria andIsOnNotBetween(String value1, String value2) {
            addCriterion("is_on not between", value1, value2, "isOn");
            return (Criteria) this;
        }

        public Criteria andCareerYearIsNull() {
            addCriterion("career_year is null");
            return (Criteria) this;
        }

        public Criteria andCareerYearIsNotNull() {
            addCriterion("career_year is not null");
            return (Criteria) this;
        }

        public Criteria andCareerYearEqualTo(String value) {
            addCriterion("career_year =", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearNotEqualTo(String value) {
            addCriterion("career_year <>", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearGreaterThan(String value) {
            addCriterion("career_year >", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearGreaterThanOrEqualTo(String value) {
            addCriterion("career_year >=", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearLessThan(String value) {
            addCriterion("career_year <", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearLessThanOrEqualTo(String value) {
            addCriterion("career_year <=", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearLike(String value) {
            addCriterion("career_year like", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearNotLike(String value) {
            addCriterion("career_year not like", value, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearIn(List<String> values) {
            addCriterion("career_year in", values, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearNotIn(List<String> values) {
            addCriterion("career_year not in", values, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearBetween(String value1, String value2) {
            addCriterion("career_year between", value1, value2, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCareerYearNotBetween(String value1, String value2) {
            addCriterion("career_year not between", value1, value2, "careerYear");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryIsNull() {
            addCriterion("current_salary is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryIsNotNull() {
            addCriterion("current_salary is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryEqualTo(String value) {
            addCriterion("current_salary =", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryNotEqualTo(String value) {
            addCriterion("current_salary <>", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryGreaterThan(String value) {
            addCriterion("current_salary >", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("current_salary >=", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryLessThan(String value) {
            addCriterion("current_salary <", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryLessThanOrEqualTo(String value) {
            addCriterion("current_salary <=", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryLike(String value) {
            addCriterion("current_salary like", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryNotLike(String value) {
            addCriterion("current_salary not like", value, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryIn(List<String> values) {
            addCriterion("current_salary in", values, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryNotIn(List<String> values) {
            addCriterion("current_salary not in", values, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryBetween(String value1, String value2) {
            addCriterion("current_salary between", value1, value2, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andCurrentSalaryNotBetween(String value1, String value2) {
            addCriterion("current_salary not between", value1, value2, "currentSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryIsNull() {
            addCriterion("expect_salary is null");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryIsNotNull() {
            addCriterion("expect_salary is not null");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryEqualTo(String value) {
            addCriterion("expect_salary =", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotEqualTo(String value) {
            addCriterion("expect_salary <>", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryGreaterThan(String value) {
            addCriterion("expect_salary >", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("expect_salary >=", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryLessThan(String value) {
            addCriterion("expect_salary <", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryLessThanOrEqualTo(String value) {
            addCriterion("expect_salary <=", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryLike(String value) {
            addCriterion("expect_salary like", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotLike(String value) {
            addCriterion("expect_salary not like", value, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryIn(List<String> values) {
            addCriterion("expect_salary in", values, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotIn(List<String> values) {
            addCriterion("expect_salary not in", values, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryBetween(String value1, String value2) {
            addCriterion("expect_salary between", value1, value2, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectSalaryNotBetween(String value1, String value2) {
            addCriterion("expect_salary not between", value1, value2, "expectSalary");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeIsNull() {
            addCriterion("expect_fulltime is null");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeIsNotNull() {
            addCriterion("expect_fulltime is not null");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeEqualTo(String value) {
            addCriterion("expect_fulltime =", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeNotEqualTo(String value) {
            addCriterion("expect_fulltime <>", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeGreaterThan(String value) {
            addCriterion("expect_fulltime >", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeGreaterThanOrEqualTo(String value) {
            addCriterion("expect_fulltime >=", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeLessThan(String value) {
            addCriterion("expect_fulltime <", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeLessThanOrEqualTo(String value) {
            addCriterion("expect_fulltime <=", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeLike(String value) {
            addCriterion("expect_fulltime like", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeNotLike(String value) {
            addCriterion("expect_fulltime not like", value, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeIn(List<String> values) {
            addCriterion("expect_fulltime in", values, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeNotIn(List<String> values) {
            addCriterion("expect_fulltime not in", values, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeBetween(String value1, String value2) {
            addCriterion("expect_fulltime between", value1, value2, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectFulltimeNotBetween(String value1, String value2) {
            addCriterion("expect_fulltime not between", value1, value2, "expectFulltime");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceIsNull() {
            addCriterion("expect_workplace is null");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceIsNotNull() {
            addCriterion("expect_workplace is not null");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceEqualTo(String value) {
            addCriterion("expect_workplace =", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceNotEqualTo(String value) {
            addCriterion("expect_workplace <>", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceGreaterThan(String value) {
            addCriterion("expect_workplace >", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceGreaterThanOrEqualTo(String value) {
            addCriterion("expect_workplace >=", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceLessThan(String value) {
            addCriterion("expect_workplace <", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceLessThanOrEqualTo(String value) {
            addCriterion("expect_workplace <=", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceLike(String value) {
            addCriterion("expect_workplace like", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceNotLike(String value) {
            addCriterion("expect_workplace not like", value, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceIn(List<String> values) {
            addCriterion("expect_workplace in", values, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceNotIn(List<String> values) {
            addCriterion("expect_workplace not in", values, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceBetween(String value1, String value2) {
            addCriterion("expect_workplace between", value1, value2, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectWorkplaceNotBetween(String value1, String value2) {
            addCriterion("expect_workplace not between", value1, value2, "expectWorkplace");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryIsNull() {
            addCriterion("expect_industry is null");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryIsNotNull() {
            addCriterion("expect_industry is not null");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryEqualTo(String value) {
            addCriterion("expect_industry =", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryNotEqualTo(String value) {
            addCriterion("expect_industry <>", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryGreaterThan(String value) {
            addCriterion("expect_industry >", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("expect_industry >=", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryLessThan(String value) {
            addCriterion("expect_industry <", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryLessThanOrEqualTo(String value) {
            addCriterion("expect_industry <=", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryLike(String value) {
            addCriterion("expect_industry like", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryNotLike(String value) {
            addCriterion("expect_industry not like", value, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryIn(List<String> values) {
            addCriterion("expect_industry in", values, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryNotIn(List<String> values) {
            addCriterion("expect_industry not in", values, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryBetween(String value1, String value2) {
            addCriterion("expect_industry between", value1, value2, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectIndustryNotBetween(String value1, String value2) {
            addCriterion("expect_industry not between", value1, value2, "expectIndustry");
            return (Criteria) this;
        }

        public Criteria andExpectJobIsNull() {
            addCriterion("expect_job is null");
            return (Criteria) this;
        }

        public Criteria andExpectJobIsNotNull() {
            addCriterion("expect_job is not null");
            return (Criteria) this;
        }

        public Criteria andExpectJobEqualTo(String value) {
            addCriterion("expect_job =", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobNotEqualTo(String value) {
            addCriterion("expect_job <>", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobGreaterThan(String value) {
            addCriterion("expect_job >", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobGreaterThanOrEqualTo(String value) {
            addCriterion("expect_job >=", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobLessThan(String value) {
            addCriterion("expect_job <", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobLessThanOrEqualTo(String value) {
            addCriterion("expect_job <=", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobLike(String value) {
            addCriterion("expect_job like", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobNotLike(String value) {
            addCriterion("expect_job not like", value, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobIn(List<String> values) {
            addCriterion("expect_job in", values, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobNotIn(List<String> values) {
            addCriterion("expect_job not in", values, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobBetween(String value1, String value2) {
            addCriterion("expect_job between", value1, value2, "expectJob");
            return (Criteria) this;
        }

        public Criteria andExpectJobNotBetween(String value1, String value2) {
            addCriterion("expect_job not between", value1, value2, "expectJob");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNull() {
            addCriterion("name_cn is null");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNotNull() {
            addCriterion("name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andNameCnEqualTo(String value) {
            addCriterion("name_cn =", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotEqualTo(String value) {
            addCriterion("name_cn <>", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThan(String value) {
            addCriterion("name_cn >", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("name_cn >=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThan(String value) {
            addCriterion("name_cn <", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThanOrEqualTo(String value) {
            addCriterion("name_cn <=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLike(String value) {
            addCriterion("name_cn like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotLike(String value) {
            addCriterion("name_cn not like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnIn(List<String> values) {
            addCriterion("name_cn in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotIn(List<String> values) {
            addCriterion("name_cn not in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnBetween(String value1, String value2) {
            addCriterion("name_cn between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotBetween(String value1, String value2) {
            addCriterion("name_cn not between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(String value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(String value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(String value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(String value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(String value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(String value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLike(String value) {
            addCriterion("birth_date like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotLike(String value) {
            addCriterion("birth_date not like", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<String> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<String> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(String value1, String value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(String value1, String value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("marriage is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("marriage is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("marriage =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("marriage <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("marriage >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("marriage >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("marriage <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("marriage <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("marriage like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("marriage not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("marriage in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("marriage not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("marriage between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("marriage not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileIsNull() {
            addCriterion("phone_mobile is null");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileIsNotNull() {
            addCriterion("phone_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileEqualTo(String value) {
            addCriterion("phone_mobile =", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileNotEqualTo(String value) {
            addCriterion("phone_mobile <>", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileGreaterThan(String value) {
            addCriterion("phone_mobile >", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileGreaterThanOrEqualTo(String value) {
            addCriterion("phone_mobile >=", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileLessThan(String value) {
            addCriterion("phone_mobile <", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileLessThanOrEqualTo(String value) {
            addCriterion("phone_mobile <=", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileLike(String value) {
            addCriterion("phone_mobile like", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileNotLike(String value) {
            addCriterion("phone_mobile not like", value, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileIn(List<String> values) {
            addCriterion("phone_mobile in", values, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileNotIn(List<String> values) {
            addCriterion("phone_mobile not in", values, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileBetween(String value1, String value2) {
            addCriterion("phone_mobile between", value1, value2, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andPhoneMobileNotBetween(String value1, String value2) {
            addCriterion("phone_mobile not between", value1, value2, "phoneMobile");
            return (Criteria) this;
        }

        public Criteria andEmailPersonIsNull() {
            addCriterion("email_person is null");
            return (Criteria) this;
        }

        public Criteria andEmailPersonIsNotNull() {
            addCriterion("email_person is not null");
            return (Criteria) this;
        }

        public Criteria andEmailPersonEqualTo(String value) {
            addCriterion("email_person =", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonNotEqualTo(String value) {
            addCriterion("email_person <>", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonGreaterThan(String value) {
            addCriterion("email_person >", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonGreaterThanOrEqualTo(String value) {
            addCriterion("email_person >=", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonLessThan(String value) {
            addCriterion("email_person <", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonLessThanOrEqualTo(String value) {
            addCriterion("email_person <=", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonLike(String value) {
            addCriterion("email_person like", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonNotLike(String value) {
            addCriterion("email_person not like", value, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonIn(List<String> values) {
            addCriterion("email_person in", values, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonNotIn(List<String> values) {
            addCriterion("email_person not in", values, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonBetween(String value1, String value2) {
            addCriterion("email_person between", value1, value2, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andEmailPersonNotBetween(String value1, String value2) {
            addCriterion("email_person not between", value1, value2, "emailPerson");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIsNull() {
            addCriterion("address_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIsNotNull() {
            addCriterion("address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddressDetailEqualTo(String value) {
            addCriterion("address_detail =", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotEqualTo(String value) {
            addCriterion("address_detail <>", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThan(String value) {
            addCriterion("address_detail >", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("address_detail >=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThan(String value) {
            addCriterion("address_detail <", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("address_detail <=", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailLike(String value) {
            addCriterion("address_detail like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotLike(String value) {
            addCriterion("address_detail not like", value, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailIn(List<String> values) {
            addCriterion("address_detail in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotIn(List<String> values) {
            addCriterion("address_detail not in", values, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailBetween(String value1, String value2) {
            addCriterion("address_detail between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andAddressDetailNotBetween(String value1, String value2) {
            addCriterion("address_detail not between", value1, value2, "addressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailIsNull() {
            addCriterion("register_address_detail is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailIsNotNull() {
            addCriterion("register_address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailEqualTo(String value) {
            addCriterion("register_address_detail =", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailNotEqualTo(String value) {
            addCriterion("register_address_detail <>", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailGreaterThan(String value) {
            addCriterion("register_address_detail >", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("register_address_detail >=", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailLessThan(String value) {
            addCriterion("register_address_detail <", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("register_address_detail <=", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailLike(String value) {
            addCriterion("register_address_detail like", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailNotLike(String value) {
            addCriterion("register_address_detail not like", value, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailIn(List<String> values) {
            addCriterion("register_address_detail in", values, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailNotIn(List<String> values) {
            addCriterion("register_address_detail not in", values, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailBetween(String value1, String value2) {
            addCriterion("register_address_detail between", value1, value2, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressDetailNotBetween(String value1, String value2) {
            addCriterion("register_address_detail not between", value1, value2, "registerAddressDetail");
            return (Criteria) this;
        }

        public Criteria andPhotoPathIsNull() {
            addCriterion("photo_path is null");
            return (Criteria) this;
        }

        public Criteria andPhotoPathIsNotNull() {
            addCriterion("photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoPathEqualTo(String value) {
            addCriterion("photo_path =", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotEqualTo(String value) {
            addCriterion("photo_path <>", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathGreaterThan(String value) {
            addCriterion("photo_path >", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("photo_path >=", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathLessThan(String value) {
            addCriterion("photo_path <", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("photo_path <=", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathLike(String value) {
            addCriterion("photo_path like", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotLike(String value) {
            addCriterion("photo_path not like", value, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathIn(List<String> values) {
            addCriterion("photo_path in", values, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotIn(List<String> values) {
            addCriterion("photo_path not in", values, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathBetween(String value1, String value2) {
            addCriterion("photo_path between", value1, value2, "photoPath");
            return (Criteria) this;
        }

        public Criteria andPhotoPathNotBetween(String value1, String value2) {
            addCriterion("photo_path not between", value1, value2, "photoPath");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailIsNull() {
            addCriterion("certificate_detail is null");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailIsNotNull() {
            addCriterion("certificate_detail is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailEqualTo(String value) {
            addCriterion("certificate_detail =", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailNotEqualTo(String value) {
            addCriterion("certificate_detail <>", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailGreaterThan(String value) {
            addCriterion("certificate_detail >", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_detail >=", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailLessThan(String value) {
            addCriterion("certificate_detail <", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailLessThanOrEqualTo(String value) {
            addCriterion("certificate_detail <=", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailLike(String value) {
            addCriterion("certificate_detail like", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailNotLike(String value) {
            addCriterion("certificate_detail not like", value, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailIn(List<String> values) {
            addCriterion("certificate_detail in", values, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailNotIn(List<String> values) {
            addCriterion("certificate_detail not in", values, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailBetween(String value1, String value2) {
            addCriterion("certificate_detail between", value1, value2, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andCertificateDetailNotBetween(String value1, String value2) {
            addCriterion("certificate_detail not between", value1, value2, "certificateDetail");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(String value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(String value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(String value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(String value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(String value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(String value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLike(String value) {
            addCriterion("interest like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotLike(String value) {
            addCriterion("interest not like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<String> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<String> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(String value1, String value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(String value1, String value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentIsNull() {
            addCriterion("apply_letter_content is null");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentIsNotNull() {
            addCriterion("apply_letter_content is not null");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentEqualTo(String value) {
            addCriterion("apply_letter_content =", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentNotEqualTo(String value) {
            addCriterion("apply_letter_content <>", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentGreaterThan(String value) {
            addCriterion("apply_letter_content >", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentGreaterThanOrEqualTo(String value) {
            addCriterion("apply_letter_content >=", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentLessThan(String value) {
            addCriterion("apply_letter_content <", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentLessThanOrEqualTo(String value) {
            addCriterion("apply_letter_content <=", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentLike(String value) {
            addCriterion("apply_letter_content like", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentNotLike(String value) {
            addCriterion("apply_letter_content not like", value, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentIn(List<String> values) {
            addCriterion("apply_letter_content in", values, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentNotIn(List<String> values) {
            addCriterion("apply_letter_content not in", values, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentBetween(String value1, String value2) {
            addCriterion("apply_letter_content between", value1, value2, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andApplyLetterContentNotBetween(String value1, String value2) {
            addCriterion("apply_letter_content not between", value1, value2, "applyLetterContent");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNull() {
            addCriterion("attachment_name is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIsNotNull() {
            addCriterion("attachment_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameEqualTo(String value) {
            addCriterion("attachment_name =", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotEqualTo(String value) {
            addCriterion("attachment_name <>", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThan(String value) {
            addCriterion("attachment_name >", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_name >=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThan(String value) {
            addCriterion("attachment_name <", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLessThanOrEqualTo(String value) {
            addCriterion("attachment_name <=", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameLike(String value) {
            addCriterion("attachment_name like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotLike(String value) {
            addCriterion("attachment_name not like", value, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameIn(List<String> values) {
            addCriterion("attachment_name in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotIn(List<String> values) {
            addCriterion("attachment_name not in", values, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameBetween(String value1, String value2) {
            addCriterion("attachment_name between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentNameNotBetween(String value1, String value2) {
            addCriterion("attachment_name not between", value1, value2, "attachmentName");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathIsNull() {
            addCriterion("attachment_path is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathIsNotNull() {
            addCriterion("attachment_path is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathEqualTo(String value) {
            addCriterion("attachment_path =", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotEqualTo(String value) {
            addCriterion("attachment_path <>", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathGreaterThan(String value) {
            addCriterion("attachment_path >", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathGreaterThanOrEqualTo(String value) {
            addCriterion("attachment_path >=", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathLessThan(String value) {
            addCriterion("attachment_path <", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathLessThanOrEqualTo(String value) {
            addCriterion("attachment_path <=", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathLike(String value) {
            addCriterion("attachment_path like", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotLike(String value) {
            addCriterion("attachment_path not like", value, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathIn(List<String> values) {
            addCriterion("attachment_path in", values, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotIn(List<String> values) {
            addCriterion("attachment_path not in", values, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathBetween(String value1, String value2) {
            addCriterion("attachment_path between", value1, value2, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andAttachmentPathNotBetween(String value1, String value2) {
            addCriterion("attachment_path not between", value1, value2, "attachmentPath");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIsNull() {
            addCriterion("resume_status is null");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIsNotNull() {
            addCriterion("resume_status is not null");
            return (Criteria) this;
        }

        public Criteria andResumeStatusEqualTo(String value) {
            addCriterion("resume_status =", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotEqualTo(String value) {
            addCriterion("resume_status <>", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusGreaterThan(String value) {
            addCriterion("resume_status >", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("resume_status >=", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLessThan(String value) {
            addCriterion("resume_status <", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLessThanOrEqualTo(String value) {
            addCriterion("resume_status <=", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusLike(String value) {
            addCriterion("resume_status like", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotLike(String value) {
            addCriterion("resume_status not like", value, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusIn(List<String> values) {
            addCriterion("resume_status in", values, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotIn(List<String> values) {
            addCriterion("resume_status not in", values, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusBetween(String value1, String value2) {
            addCriterion("resume_status between", value1, value2, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andResumeStatusNotBetween(String value1, String value2) {
            addCriterion("resume_status not between", value1, value2, "resumeStatus");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(String value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(String value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(String value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(String value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(String value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(String value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(String value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<String> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<String> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(String value1, String value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(String value1, String value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusIsNull() {
            addCriterion("special_offer_status is null");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusIsNotNull() {
            addCriterion("special_offer_status is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusEqualTo(String value) {
            addCriterion("special_offer_status =", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusNotEqualTo(String value) {
            addCriterion("special_offer_status <>", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusGreaterThan(String value) {
            addCriterion("special_offer_status >", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusGreaterThanOrEqualTo(String value) {
            addCriterion("special_offer_status >=", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusLessThan(String value) {
            addCriterion("special_offer_status <", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusLessThanOrEqualTo(String value) {
            addCriterion("special_offer_status <=", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusLike(String value) {
            addCriterion("special_offer_status like", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusNotLike(String value) {
            addCriterion("special_offer_status not like", value, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusIn(List<String> values) {
            addCriterion("special_offer_status in", values, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusNotIn(List<String> values) {
            addCriterion("special_offer_status not in", values, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusBetween(String value1, String value2) {
            addCriterion("special_offer_status between", value1, value2, "specialOfferStatus");
            return (Criteria) this;
        }

        public Criteria andSpecialOfferStatusNotBetween(String value1, String value2) {
            addCriterion("special_offer_status not between", value1, value2, "specialOfferStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}