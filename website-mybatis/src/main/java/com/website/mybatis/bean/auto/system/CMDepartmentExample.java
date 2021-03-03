package com.website.mybatis.bean.auto.system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CMDepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CMDepartmentExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdIsNull() {
            addCriterion("department_cd is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdIsNotNull() {
            addCriterion("department_cd is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdEqualTo(String value) {
            addCriterion("department_cd =", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdNotEqualTo(String value) {
            addCriterion("department_cd <>", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdGreaterThan(String value) {
            addCriterion("department_cd >", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdGreaterThanOrEqualTo(String value) {
            addCriterion("department_cd >=", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdLessThan(String value) {
            addCriterion("department_cd <", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdLessThanOrEqualTo(String value) {
            addCriterion("department_cd <=", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdLike(String value) {
            addCriterion("department_cd like", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdNotLike(String value) {
            addCriterion("department_cd not like", value, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdIn(List<String> values) {
            addCriterion("department_cd in", values, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdNotIn(List<String> values) {
            addCriterion("department_cd not in", values, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdBetween(String value1, String value2) {
            addCriterion("department_cd between", value1, value2, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentCdNotBetween(String value1, String value2) {
            addCriterion("department_cd not between", value1, value2, "departmentCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIsNull() {
            addCriterion("department_code is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIsNotNull() {
            addCriterion("department_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeEqualTo(String value) {
            addCriterion("department_code =", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotEqualTo(String value) {
            addCriterion("department_code <>", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeGreaterThan(String value) {
            addCriterion("department_code >", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("department_code >=", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLessThan(String value) {
            addCriterion("department_code <", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLessThanOrEqualTo(String value) {
            addCriterion("department_code <=", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeLike(String value) {
            addCriterion("department_code like", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotLike(String value) {
            addCriterion("department_code not like", value, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeIn(List<String> values) {
            addCriterion("department_code in", values, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotIn(List<String> values) {
            addCriterion("department_code not in", values, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeBetween(String value1, String value2) {
            addCriterion("department_code between", value1, value2, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentCodeNotBetween(String value1, String value2) {
            addCriterion("department_code not between", value1, value2, "departmentCode");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdIsNull() {
            addCriterion("department_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdIsNotNull() {
            addCriterion("department_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdEqualTo(String value) {
            addCriterion("department_leader_id =", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotEqualTo(String value) {
            addCriterion("department_leader_id <>", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdGreaterThan(String value) {
            addCriterion("department_leader_id >", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_leader_id >=", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdLessThan(String value) {
            addCriterion("department_leader_id <", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdLessThanOrEqualTo(String value) {
            addCriterion("department_leader_id <=", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdLike(String value) {
            addCriterion("department_leader_id like", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotLike(String value) {
            addCriterion("department_leader_id not like", value, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdIn(List<String> values) {
            addCriterion("department_leader_id in", values, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotIn(List<String> values) {
            addCriterion("department_leader_id not in", values, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdBetween(String value1, String value2) {
            addCriterion("department_leader_id between", value1, value2, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderIdNotBetween(String value1, String value2) {
            addCriterion("department_leader_id not between", value1, value2, "departmentLeaderId");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameIsNull() {
            addCriterion("department_leader_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameIsNotNull() {
            addCriterion("department_leader_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameEqualTo(String value) {
            addCriterion("department_leader_name =", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameNotEqualTo(String value) {
            addCriterion("department_leader_name <>", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameGreaterThan(String value) {
            addCriterion("department_leader_name >", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_leader_name >=", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameLessThan(String value) {
            addCriterion("department_leader_name <", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameLessThanOrEqualTo(String value) {
            addCriterion("department_leader_name <=", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameLike(String value) {
            addCriterion("department_leader_name like", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameNotLike(String value) {
            addCriterion("department_leader_name not like", value, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameIn(List<String> values) {
            addCriterion("department_leader_name in", values, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameNotIn(List<String> values) {
            addCriterion("department_leader_name not in", values, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameBetween(String value1, String value2) {
            addCriterion("department_leader_name between", value1, value2, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLeaderNameNotBetween(String value1, String value2) {
            addCriterion("department_leader_name not between", value1, value2, "departmentLeaderName");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIsNull() {
            addCriterion("department_type is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIsNotNull() {
            addCriterion("department_type is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeEqualTo(String value) {
            addCriterion("department_type =", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotEqualTo(String value) {
            addCriterion("department_type <>", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeGreaterThan(String value) {
            addCriterion("department_type >", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("department_type >=", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeLessThan(String value) {
            addCriterion("department_type <", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeLessThanOrEqualTo(String value) {
            addCriterion("department_type <=", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeLike(String value) {
            addCriterion("department_type like", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotLike(String value) {
            addCriterion("department_type not like", value, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeIn(List<String> values) {
            addCriterion("department_type in", values, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotIn(List<String> values) {
            addCriterion("department_type not in", values, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeBetween(String value1, String value2) {
            addCriterion("department_type between", value1, value2, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentTypeNotBetween(String value1, String value2) {
            addCriterion("department_type not between", value1, value2, "departmentType");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIsNull() {
            addCriterion("department_level is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIsNotNull() {
            addCriterion("department_level is not null");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelEqualTo_back(Byte value) {
            addCriterion("department_level =", value, "departmentLevel");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelNotEqualTo_back(Byte value) {
            addCriterion("department_level <>", value, "departmentLevel");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelGreaterThan_back(Byte value) {
            addCriterion("department_level >", value, "departmentLevel");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelGreaterThanOrEqualTo_back(Byte value) {
            addCriterion("department_level >=", value, "departmentLevel");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelLessThan_back(Byte value) {
            addCriterion("department_level <", value, "departmentLevel");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelLessThanOrEqualTo_back(Byte value) {
            addCriterion("department_level <=", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelIn(List<Byte> values) {
            addCriterion("department_level in", values, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotIn(List<Byte> values) {
            addCriterion("department_level not in", values, "departmentLevel");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelBetween_back(Byte value1, Byte value2) {
            addCriterion("department_level between", value1, value2, "departmentLevel");
            return (Criteria) this;
        }

        private Criteria andDepartmentLevelNotBetween_back(Byte value1, Byte value2) {
            addCriterion("department_level not between", value1, value2, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdIsNull() {
            addCriterion("department_p_cd is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdIsNotNull() {
            addCriterion("department_p_cd is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdEqualTo(String value) {
            addCriterion("department_p_cd =", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdNotEqualTo(String value) {
            addCriterion("department_p_cd <>", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdGreaterThan(String value) {
            addCriterion("department_p_cd >", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdGreaterThanOrEqualTo(String value) {
            addCriterion("department_p_cd >=", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdLessThan(String value) {
            addCriterion("department_p_cd <", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdLessThanOrEqualTo(String value) {
            addCriterion("department_p_cd <=", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdLike(String value) {
            addCriterion("department_p_cd like", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdNotLike(String value) {
            addCriterion("department_p_cd not like", value, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdIn(List<String> values) {
            addCriterion("department_p_cd in", values, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdNotIn(List<String> values) {
            addCriterion("department_p_cd not in", values, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdBetween(String value1, String value2) {
            addCriterion("department_p_cd between", value1, value2, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentPCdNotBetween(String value1, String value2) {
            addCriterion("department_p_cd not between", value1, value2, "departmentPCd");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeIsNull() {
            addCriterion("department_regtime is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeIsNotNull() {
            addCriterion("department_regtime is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeEqualTo(String value) {
            addCriterion("department_regtime =", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeNotEqualTo(String value) {
            addCriterion("department_regtime <>", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeGreaterThan(String value) {
            addCriterion("department_regtime >", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeGreaterThanOrEqualTo(String value) {
            addCriterion("department_regtime >=", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeLessThan(String value) {
            addCriterion("department_regtime <", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeLessThanOrEqualTo(String value) {
            addCriterion("department_regtime <=", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeLike(String value) {
            addCriterion("department_regtime like", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeNotLike(String value) {
            addCriterion("department_regtime not like", value, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeIn(List<String> values) {
            addCriterion("department_regtime in", values, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeNotIn(List<String> values) {
            addCriterion("department_regtime not in", values, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeBetween(String value1, String value2) {
            addCriterion("department_regtime between", value1, value2, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentRegtimeNotBetween(String value1, String value2) {
            addCriterion("department_regtime not between", value1, value2, "departmentRegtime");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationIsNull() {
            addCriterion("department_workstation is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationIsNotNull() {
            addCriterion("department_workstation is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationEqualTo(Integer value) {
            addCriterion("department_workstation =", value, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationNotEqualTo(Integer value) {
            addCriterion("department_workstation <>", value, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationGreaterThan(Integer value) {
            addCriterion("department_workstation >", value, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationGreaterThanOrEqualTo(Integer value) {
            addCriterion("department_workstation >=", value, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationLessThan(Integer value) {
            addCriterion("department_workstation <", value, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationLessThanOrEqualTo(Integer value) {
            addCriterion("department_workstation <=", value, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationIn(List<Integer> values) {
            addCriterion("department_workstation in", values, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationNotIn(List<Integer> values) {
            addCriterion("department_workstation not in", values, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationBetween(Integer value1, Integer value2) {
            addCriterion("department_workstation between", value1, value2, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentWorkstationNotBetween(Integer value1, Integer value2) {
            addCriterion("department_workstation not between", value1, value2, "departmentWorkstation");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaIsNull() {
            addCriterion("department_area is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaIsNotNull() {
            addCriterion("department_area is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaEqualTo(BigDecimal value) {
            addCriterion("department_area =", value, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaNotEqualTo(BigDecimal value) {
            addCriterion("department_area <>", value, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaGreaterThan(BigDecimal value) {
            addCriterion("department_area >", value, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("department_area >=", value, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaLessThan(BigDecimal value) {
            addCriterion("department_area <", value, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("department_area <=", value, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaIn(List<BigDecimal> values) {
            addCriterion("department_area in", values, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaNotIn(List<BigDecimal> values) {
            addCriterion("department_area not in", values, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("department_area between", value1, value2, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andDepartmentAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("department_area not between", value1, value2, "departmentArea");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(String value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(String value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(String value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(String value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(String value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(String value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLike(String value) {
            addCriterion("province_id like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotLike(String value) {
            addCriterion("province_id not like", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<String> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<String> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(String value1, String value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(String value1, String value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(String value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(String value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(String value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(String value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(String value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLike(String value) {
            addCriterion("city_id like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotLike(String value) {
            addCriterion("city_id not like", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<String> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<String> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(String value1, String value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(String value1, String value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(String value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(String value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(String value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(String value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(String value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(String value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLike(String value) {
            addCriterion("district_id like", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotLike(String value) {
            addCriterion("district_id not like", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<String> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<String> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(String value1, String value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(String value1, String value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressIsNull() {
            addCriterion("complete_address is null");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressIsNotNull() {
            addCriterion("complete_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressEqualTo(String value) {
            addCriterion("complete_address =", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressNotEqualTo(String value) {
            addCriterion("complete_address <>", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressGreaterThan(String value) {
            addCriterion("complete_address >", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressGreaterThanOrEqualTo(String value) {
            addCriterion("complete_address >=", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressLessThan(String value) {
            addCriterion("complete_address <", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressLessThanOrEqualTo(String value) {
            addCriterion("complete_address <=", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressLike(String value) {
            addCriterion("complete_address like", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressNotLike(String value) {
            addCriterion("complete_address not like", value, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressIn(List<String> values) {
            addCriterion("complete_address in", values, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressNotIn(List<String> values) {
            addCriterion("complete_address not in", values, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressBetween(String value1, String value2) {
            addCriterion("complete_address between", value1, value2, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andCompleteAddressNotBetween(String value1, String value2) {
            addCriterion("complete_address not between", value1, value2, "completeAddress");
            return (Criteria) this;
        }

        public Criteria andNotesIsNull() {
            addCriterion("notes is null");
            return (Criteria) this;
        }

        public Criteria andNotesIsNotNull() {
            addCriterion("notes is not null");
            return (Criteria) this;
        }

        public Criteria andNotesEqualTo(String value) {
            addCriterion("notes =", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotEqualTo(String value) {
            addCriterion("notes <>", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThan(String value) {
            addCriterion("notes >", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesGreaterThanOrEqualTo(String value) {
            addCriterion("notes >=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThan(String value) {
            addCriterion("notes <", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLessThanOrEqualTo(String value) {
            addCriterion("notes <=", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesLike(String value) {
            addCriterion("notes like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotLike(String value) {
            addCriterion("notes not like", value, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesIn(List<String> values) {
            addCriterion("notes in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotIn(List<String> values) {
            addCriterion("notes not in", values, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesBetween(String value1, String value2) {
            addCriterion("notes between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andNotesNotBetween(String value1, String value2) {
            addCriterion("notes not between", value1, value2, "notes");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSortKeyIsNull() {
            addCriterion("sort_key is null");
            return (Criteria) this;
        }

        public Criteria andSortKeyIsNotNull() {
            addCriterion("sort_key is not null");
            return (Criteria) this;
        }

        public Criteria andSortKeyEqualTo(Integer value) {
            addCriterion("sort_key =", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyNotEqualTo(Integer value) {
            addCriterion("sort_key <>", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyGreaterThan(Integer value) {
            addCriterion("sort_key >", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_key >=", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyLessThan(Integer value) {
            addCriterion("sort_key <", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyLessThanOrEqualTo(Integer value) {
            addCriterion("sort_key <=", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyIn(List<Integer> values) {
            addCriterion("sort_key in", values, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyNotIn(List<Integer> values) {
            addCriterion("sort_key not in", values, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyBetween(Integer value1, Integer value2) {
            addCriterion("sort_key between", value1, value2, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_key not between", value1, value2, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdIsNull() {
            addCriterion("sms_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdIsNotNull() {
            addCriterion("sms_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdEqualTo(String value) {
            addCriterion("sms_user_id =", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdNotEqualTo(String value) {
            addCriterion("sms_user_id <>", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdGreaterThan(String value) {
            addCriterion("sms_user_id >", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("sms_user_id >=", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdLessThan(String value) {
            addCriterion("sms_user_id <", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdLessThanOrEqualTo(String value) {
            addCriterion("sms_user_id <=", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdLike(String value) {
            addCriterion("sms_user_id like", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdNotLike(String value) {
            addCriterion("sms_user_id not like", value, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdIn(List<String> values) {
            addCriterion("sms_user_id in", values, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdNotIn(List<String> values) {
            addCriterion("sms_user_id not in", values, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdBetween(String value1, String value2) {
            addCriterion("sms_user_id between", value1, value2, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsUserIdNotBetween(String value1, String value2) {
            addCriterion("sms_user_id not between", value1, value2, "smsUserId");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordIsNull() {
            addCriterion("sms_password is null");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordIsNotNull() {
            addCriterion("sms_password is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordEqualTo(String value) {
            addCriterion("sms_password =", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordNotEqualTo(String value) {
            addCriterion("sms_password <>", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordGreaterThan(String value) {
            addCriterion("sms_password >", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("sms_password >=", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordLessThan(String value) {
            addCriterion("sms_password <", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordLessThanOrEqualTo(String value) {
            addCriterion("sms_password <=", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordLike(String value) {
            addCriterion("sms_password like", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordNotLike(String value) {
            addCriterion("sms_password not like", value, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordIn(List<String> values) {
            addCriterion("sms_password in", values, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordNotIn(List<String> values) {
            addCriterion("sms_password not in", values, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordBetween(String value1, String value2) {
            addCriterion("sms_password between", value1, value2, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsPasswordNotBetween(String value1, String value2) {
            addCriterion("sms_password not between", value1, value2, "smsPassword");
            return (Criteria) this;
        }

        public Criteria andSmsUrlIsNull() {
            addCriterion("sms_url is null");
            return (Criteria) this;
        }

        public Criteria andSmsUrlIsNotNull() {
            addCriterion("sms_url is not null");
            return (Criteria) this;
        }

        public Criteria andSmsUrlEqualTo(String value) {
            addCriterion("sms_url =", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotEqualTo(String value) {
            addCriterion("sms_url <>", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlGreaterThan(String value) {
            addCriterion("sms_url >", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sms_url >=", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlLessThan(String value) {
            addCriterion("sms_url <", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlLessThanOrEqualTo(String value) {
            addCriterion("sms_url <=", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlLike(String value) {
            addCriterion("sms_url like", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotLike(String value) {
            addCriterion("sms_url not like", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlIn(List<String> values) {
            addCriterion("sms_url in", values, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotIn(List<String> values) {
            addCriterion("sms_url not in", values, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlBetween(String value1, String value2) {
            addCriterion("sms_url between", value1, value2, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotBetween(String value1, String value2) {
            addCriterion("sms_url not between", value1, value2, "smsUrl");
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

        public Criteria andCreateGroupCdIsNull() {
            addCriterion("create_group_cd is null");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdIsNotNull() {
            addCriterion("create_group_cd is not null");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdEqualTo(String value) {
            addCriterion("create_group_cd =", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdNotEqualTo(String value) {
            addCriterion("create_group_cd <>", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdGreaterThan(String value) {
            addCriterion("create_group_cd >", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdGreaterThanOrEqualTo(String value) {
            addCriterion("create_group_cd >=", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdLessThan(String value) {
            addCriterion("create_group_cd <", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdLessThanOrEqualTo(String value) {
            addCriterion("create_group_cd <=", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdLike(String value) {
            addCriterion("create_group_cd like", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdNotLike(String value) {
            addCriterion("create_group_cd not like", value, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdIn(List<String> values) {
            addCriterion("create_group_cd in", values, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdNotIn(List<String> values) {
            addCriterion("create_group_cd not in", values, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdBetween(String value1, String value2) {
            addCriterion("create_group_cd between", value1, value2, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateGroupCdNotBetween(String value1, String value2) {
            addCriterion("create_group_cd not between", value1, value2, "createGroupCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdIsNull() {
            addCriterion("create_user_cd is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdIsNotNull() {
            addCriterion("create_user_cd is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdEqualTo(String value) {
            addCriterion("create_user_cd =", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdNotEqualTo(String value) {
            addCriterion("create_user_cd <>", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdGreaterThan(String value) {
            addCriterion("create_user_cd >", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_cd >=", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdLessThan(String value) {
            addCriterion("create_user_cd <", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdLessThanOrEqualTo(String value) {
            addCriterion("create_user_cd <=", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdLike(String value) {
            addCriterion("create_user_cd like", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdNotLike(String value) {
            addCriterion("create_user_cd not like", value, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdIn(List<String> values) {
            addCriterion("create_user_cd in", values, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdNotIn(List<String> values) {
            addCriterion("create_user_cd not in", values, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdBetween(String value1, String value2) {
            addCriterion("create_user_cd between", value1, value2, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateUserCdNotBetween(String value1, String value2) {
            addCriterion("create_user_cd not between", value1, value2, "createUserCd");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdIsNull() {
            addCriterion("update_group_cd is null");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdIsNotNull() {
            addCriterion("update_group_cd is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdEqualTo(String value) {
            addCriterion("update_group_cd =", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdNotEqualTo(String value) {
            addCriterion("update_group_cd <>", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdGreaterThan(String value) {
            addCriterion("update_group_cd >", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdGreaterThanOrEqualTo(String value) {
            addCriterion("update_group_cd >=", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdLessThan(String value) {
            addCriterion("update_group_cd <", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdLessThanOrEqualTo(String value) {
            addCriterion("update_group_cd <=", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdLike(String value) {
            addCriterion("update_group_cd like", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdNotLike(String value) {
            addCriterion("update_group_cd not like", value, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdIn(List<String> values) {
            addCriterion("update_group_cd in", values, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdNotIn(List<String> values) {
            addCriterion("update_group_cd not in", values, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdBetween(String value1, String value2) {
            addCriterion("update_group_cd between", value1, value2, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateGroupCdNotBetween(String value1, String value2) {
            addCriterion("update_group_cd not between", value1, value2, "updateGroupCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdIsNull() {
            addCriterion("update_user_cd is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdIsNotNull() {
            addCriterion("update_user_cd is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdEqualTo(String value) {
            addCriterion("update_user_cd =", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdNotEqualTo(String value) {
            addCriterion("update_user_cd <>", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdGreaterThan(String value) {
            addCriterion("update_user_cd >", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdGreaterThanOrEqualTo(String value) {
            addCriterion("update_user_cd >=", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdLessThan(String value) {
            addCriterion("update_user_cd <", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdLessThanOrEqualTo(String value) {
            addCriterion("update_user_cd <=", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdLike(String value) {
            addCriterion("update_user_cd like", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdNotLike(String value) {
            addCriterion("update_user_cd not like", value, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdIn(List<String> values) {
            addCriterion("update_user_cd in", values, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdNotIn(List<String> values) {
            addCriterion("update_user_cd not in", values, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdBetween(String value1, String value2) {
            addCriterion("update_user_cd between", value1, value2, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCdNotBetween(String value1, String value2) {
            addCriterion("update_user_cd not between", value1, value2, "updateUserCd");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(String value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(String value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(String value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(String value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLike(String value) {
            addCriterion("update_date like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotLike(String value) {
            addCriterion("update_date not like", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<String> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<String> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(String value1, String value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(String value1, String value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameIsNull() {
            addCriterion("report_company_name is null");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameIsNotNull() {
            addCriterion("report_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameEqualTo(String value) {
            addCriterion("report_company_name =", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameNotEqualTo(String value) {
            addCriterion("report_company_name <>", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameGreaterThan(String value) {
            addCriterion("report_company_name >", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("report_company_name >=", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameLessThan(String value) {
            addCriterion("report_company_name <", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("report_company_name <=", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameLike(String value) {
            addCriterion("report_company_name like", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameNotLike(String value) {
            addCriterion("report_company_name not like", value, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameIn(List<String> values) {
            addCriterion("report_company_name in", values, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameNotIn(List<String> values) {
            addCriterion("report_company_name not in", values, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameBetween(String value1, String value2) {
            addCriterion("report_company_name between", value1, value2, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andReportCompanyNameNotBetween(String value1, String value2) {
            addCriterion("report_company_name not between", value1, value2, "reportCompanyName");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelEqualTo(int value) {
            addCriterion("department_level =", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotEqualTo(int value) {
            addCriterion("department_level <>", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelGreaterThan(int value) {
            addCriterion("department_level >", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelGreaterThanOrEqualTo(int value) {
            addCriterion("department_level >=", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelLessThan(int value) {
            addCriterion("department_level <", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelLessThanOrEqualTo(int value) {
            addCriterion("department_level <=", value, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelBetween(int value1, int value2) {
            addCriterion("department_level between", value1, value2, "departmentLevel");
            return (Criteria) this;
        }

        public Criteria andDepartmentLevelNotBetween(int value1, int value2) {
            addCriterion("department_level not between", value1, value2, "departmentLevel");
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