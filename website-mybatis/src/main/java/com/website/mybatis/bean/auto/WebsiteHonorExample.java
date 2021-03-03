package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteHonorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteHonorExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngIsNull() {
            addCriterion("img_address_eng is null");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngIsNotNull() {
            addCriterion("img_address_eng is not null");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngEqualTo(String value) {
            addCriterion("img_address_eng =", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngNotEqualTo(String value) {
            addCriterion("img_address_eng <>", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngGreaterThan(String value) {
            addCriterion("img_address_eng >", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngGreaterThanOrEqualTo(String value) {
            addCriterion("img_address_eng >=", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngLessThan(String value) {
            addCriterion("img_address_eng <", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngLessThanOrEqualTo(String value) {
            addCriterion("img_address_eng <=", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngLike(String value) {
            addCriterion("img_address_eng like", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngNotLike(String value) {
            addCriterion("img_address_eng not like", value, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngIn(List<String> values) {
            addCriterion("img_address_eng in", values, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngNotIn(List<String> values) {
            addCriterion("img_address_eng not in", values, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngBetween(String value1, String value2) {
            addCriterion("img_address_eng between", value1, value2, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressEngNotBetween(String value1, String value2) {
            addCriterion("img_address_eng not between", value1, value2, "imgAddressEng");
            return (Criteria) this;
        }

        public Criteria andImgAddressIsNull() {
            addCriterion("img_address is null");
            return (Criteria) this;
        }

        public Criteria andImgAddressIsNotNull() {
            addCriterion("img_address is not null");
            return (Criteria) this;
        }

        public Criteria andImgAddressEqualTo(String value) {
            addCriterion("img_address =", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotEqualTo(String value) {
            addCriterion("img_address <>", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressGreaterThan(String value) {
            addCriterion("img_address >", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressGreaterThanOrEqualTo(String value) {
            addCriterion("img_address >=", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressLessThan(String value) {
            addCriterion("img_address <", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressLessThanOrEqualTo(String value) {
            addCriterion("img_address <=", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressLike(String value) {
            addCriterion("img_address like", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotLike(String value) {
            addCriterion("img_address not like", value, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressIn(List<String> values) {
            addCriterion("img_address in", values, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotIn(List<String> values) {
            addCriterion("img_address not in", values, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressBetween(String value1, String value2) {
            addCriterion("img_address between", value1, value2, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andImgAddressNotBetween(String value1, String value2) {
            addCriterion("img_address not between", value1, value2, "imgAddress");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngIsNull() {
            addCriterion("honor_number_eng is null");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngIsNotNull() {
            addCriterion("honor_number_eng is not null");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngEqualTo(String value) {
            addCriterion("honor_number_eng =", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngNotEqualTo(String value) {
            addCriterion("honor_number_eng <>", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngGreaterThan(String value) {
            addCriterion("honor_number_eng >", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngGreaterThanOrEqualTo(String value) {
            addCriterion("honor_number_eng >=", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngLessThan(String value) {
            addCriterion("honor_number_eng <", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngLessThanOrEqualTo(String value) {
            addCriterion("honor_number_eng <=", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngLike(String value) {
            addCriterion("honor_number_eng like", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngNotLike(String value) {
            addCriterion("honor_number_eng not like", value, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngIn(List<String> values) {
            addCriterion("honor_number_eng in", values, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngNotIn(List<String> values) {
            addCriterion("honor_number_eng not in", values, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngBetween(String value1, String value2) {
            addCriterion("honor_number_eng between", value1, value2, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEngNotBetween(String value1, String value2) {
            addCriterion("honor_number_eng not between", value1, value2, "honorNumberEng");
            return (Criteria) this;
        }

        public Criteria andHonorNumberIsNull() {
            addCriterion("honor_number is null");
            return (Criteria) this;
        }

        public Criteria andHonorNumberIsNotNull() {
            addCriterion("honor_number is not null");
            return (Criteria) this;
        }

        public Criteria andHonorNumberEqualTo(String value) {
            addCriterion("honor_number =", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberNotEqualTo(String value) {
            addCriterion("honor_number <>", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberGreaterThan(String value) {
            addCriterion("honor_number >", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberGreaterThanOrEqualTo(String value) {
            addCriterion("honor_number >=", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberLessThan(String value) {
            addCriterion("honor_number <", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberLessThanOrEqualTo(String value) {
            addCriterion("honor_number <=", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberLike(String value) {
            addCriterion("honor_number like", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberNotLike(String value) {
            addCriterion("honor_number not like", value, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberIn(List<String> values) {
            addCriterion("honor_number in", values, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberNotIn(List<String> values) {
            addCriterion("honor_number not in", values, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberBetween(String value1, String value2) {
            addCriterion("honor_number between", value1, value2, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNumberNotBetween(String value1, String value2) {
            addCriterion("honor_number not between", value1, value2, "honorNumber");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngIsNull() {
            addCriterion("honor_name_eng is null");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngIsNotNull() {
            addCriterion("honor_name_eng is not null");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngEqualTo(String value) {
            addCriterion("honor_name_eng =", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngNotEqualTo(String value) {
            addCriterion("honor_name_eng <>", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngGreaterThan(String value) {
            addCriterion("honor_name_eng >", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngGreaterThanOrEqualTo(String value) {
            addCriterion("honor_name_eng >=", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngLessThan(String value) {
            addCriterion("honor_name_eng <", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngLessThanOrEqualTo(String value) {
            addCriterion("honor_name_eng <=", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngLike(String value) {
            addCriterion("honor_name_eng like", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngNotLike(String value) {
            addCriterion("honor_name_eng not like", value, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngIn(List<String> values) {
            addCriterion("honor_name_eng in", values, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngNotIn(List<String> values) {
            addCriterion("honor_name_eng not in", values, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngBetween(String value1, String value2) {
            addCriterion("honor_name_eng between", value1, value2, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameEngNotBetween(String value1, String value2) {
            addCriterion("honor_name_eng not between", value1, value2, "honorNameEng");
            return (Criteria) this;
        }

        public Criteria andHonorNameIsNull() {
            addCriterion("honor_name is null");
            return (Criteria) this;
        }

        public Criteria andHonorNameIsNotNull() {
            addCriterion("honor_name is not null");
            return (Criteria) this;
        }

        public Criteria andHonorNameEqualTo(String value) {
            addCriterion("honor_name =", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameNotEqualTo(String value) {
            addCriterion("honor_name <>", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameGreaterThan(String value) {
            addCriterion("honor_name >", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameGreaterThanOrEqualTo(String value) {
            addCriterion("honor_name >=", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameLessThan(String value) {
            addCriterion("honor_name <", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameLessThanOrEqualTo(String value) {
            addCriterion("honor_name <=", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameLike(String value) {
            addCriterion("honor_name like", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameNotLike(String value) {
            addCriterion("honor_name not like", value, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameIn(List<String> values) {
            addCriterion("honor_name in", values, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameNotIn(List<String> values) {
            addCriterion("honor_name not in", values, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameBetween(String value1, String value2) {
            addCriterion("honor_name between", value1, value2, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorNameNotBetween(String value1, String value2) {
            addCriterion("honor_name not between", value1, value2, "honorName");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngIsNull() {
            addCriterion("honor_state_eng is null");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngIsNotNull() {
            addCriterion("honor_state_eng is not null");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngEqualTo(String value) {
            addCriterion("honor_state_eng =", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngNotEqualTo(String value) {
            addCriterion("honor_state_eng <>", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngGreaterThan(String value) {
            addCriterion("honor_state_eng >", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngGreaterThanOrEqualTo(String value) {
            addCriterion("honor_state_eng >=", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngLessThan(String value) {
            addCriterion("honor_state_eng <", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngLessThanOrEqualTo(String value) {
            addCriterion("honor_state_eng <=", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngLike(String value) {
            addCriterion("honor_state_eng like", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngNotLike(String value) {
            addCriterion("honor_state_eng not like", value, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngIn(List<String> values) {
            addCriterion("honor_state_eng in", values, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngNotIn(List<String> values) {
            addCriterion("honor_state_eng not in", values, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngBetween(String value1, String value2) {
            addCriterion("honor_state_eng between", value1, value2, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateEngNotBetween(String value1, String value2) {
            addCriterion("honor_state_eng not between", value1, value2, "honorStateEng");
            return (Criteria) this;
        }

        public Criteria andHonorStateIsNull() {
            addCriterion("honor_state is null");
            return (Criteria) this;
        }

        public Criteria andHonorStateIsNotNull() {
            addCriterion("honor_state is not null");
            return (Criteria) this;
        }

        public Criteria andHonorStateEqualTo(String value) {
            addCriterion("honor_state =", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateNotEqualTo(String value) {
            addCriterion("honor_state <>", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateGreaterThan(String value) {
            addCriterion("honor_state >", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateGreaterThanOrEqualTo(String value) {
            addCriterion("honor_state >=", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateLessThan(String value) {
            addCriterion("honor_state <", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateLessThanOrEqualTo(String value) {
            addCriterion("honor_state <=", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateLike(String value) {
            addCriterion("honor_state like", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateNotLike(String value) {
            addCriterion("honor_state not like", value, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateIn(List<String> values) {
            addCriterion("honor_state in", values, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateNotIn(List<String> values) {
            addCriterion("honor_state not in", values, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateBetween(String value1, String value2) {
            addCriterion("honor_state between", value1, value2, "honorState");
            return (Criteria) this;
        }

        public Criteria andHonorStateNotBetween(String value1, String value2) {
            addCriterion("honor_state not between", value1, value2, "honorState");
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

        public Criteria andHonorDetailsEngIsNull() {
            addCriterion("honor_details_eng is null");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngIsNotNull() {
            addCriterion("honor_details_eng is not null");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngEqualTo(String value) {
            addCriterion("honor_details_eng =", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngNotEqualTo(String value) {
            addCriterion("honor_details_eng <>", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngGreaterThan(String value) {
            addCriterion("honor_details_eng >", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngGreaterThanOrEqualTo(String value) {
            addCriterion("honor_details_eng >=", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngLessThan(String value) {
            addCriterion("honor_details_eng <", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngLessThanOrEqualTo(String value) {
            addCriterion("honor_details_eng <=", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngLike(String value) {
            addCriterion("honor_details_eng like", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngNotLike(String value) {
            addCriterion("honor_details_eng not like", value, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngIn(List<String> values) {
            addCriterion("honor_details_eng in", values, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngNotIn(List<String> values) {
            addCriterion("honor_details_eng not in", values, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngBetween(String value1, String value2) {
            addCriterion("honor_details_eng between", value1, value2, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEngNotBetween(String value1, String value2) {
            addCriterion("honor_details_eng not between", value1, value2, "honorDetailsEng");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsIsNull() {
            addCriterion("honor_details is null");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsIsNotNull() {
            addCriterion("honor_details is not null");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsEqualTo(String value) {
            addCriterion("honor_details =", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsNotEqualTo(String value) {
            addCriterion("honor_details <>", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsGreaterThan(String value) {
            addCriterion("honor_details >", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("honor_details >=", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsLessThan(String value) {
            addCriterion("honor_details <", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsLessThanOrEqualTo(String value) {
            addCriterion("honor_details <=", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsLike(String value) {
            addCriterion("honor_details like", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsNotLike(String value) {
            addCriterion("honor_details not like", value, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsIn(List<String> values) {
            addCriterion("honor_details in", values, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsNotIn(List<String> values) {
            addCriterion("honor_details not in", values, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsBetween(String value1, String value2) {
            addCriterion("honor_details between", value1, value2, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andHonorDetailsNotBetween(String value1, String value2) {
            addCriterion("honor_details not between", value1, value2, "honorDetails");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andHasEngIsNull() {
            addCriterion("has_eng is null");
            return (Criteria) this;
        }

        public Criteria andHasEngIsNotNull() {
            addCriterion("has_eng is not null");
            return (Criteria) this;
        }

        public Criteria andHasEngEqualTo(String value) {
            addCriterion("has_eng =", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngNotEqualTo(String value) {
            addCriterion("has_eng <>", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngGreaterThan(String value) {
            addCriterion("has_eng >", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngGreaterThanOrEqualTo(String value) {
            addCriterion("has_eng >=", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngLessThan(String value) {
            addCriterion("has_eng <", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngLessThanOrEqualTo(String value) {
            addCriterion("has_eng <=", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngLike(String value) {
            addCriterion("has_eng like", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngNotLike(String value) {
            addCriterion("has_eng not like", value, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngIn(List<String> values) {
            addCriterion("has_eng in", values, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngNotIn(List<String> values) {
            addCriterion("has_eng not in", values, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngBetween(String value1, String value2) {
            addCriterion("has_eng between", value1, value2, "hasEng");
            return (Criteria) this;
        }

        public Criteria andHasEngNotBetween(String value1, String value2) {
            addCriterion("has_eng not between", value1, value2, "hasEng");
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