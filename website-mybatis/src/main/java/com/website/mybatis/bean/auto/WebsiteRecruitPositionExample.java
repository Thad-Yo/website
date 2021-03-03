package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteRecruitPositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteRecruitPositionExample() {
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

        public Criteria andRecruitPositionIdIsNull() {
            addCriterion("recruit_position_id is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIsNotNull() {
            addCriterion("recruit_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdEqualTo(Integer value) {
            addCriterion("recruit_position_id =", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotEqualTo(Integer value) {
            addCriterion("recruit_position_id <>", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThan(Integer value) {
            addCriterion("recruit_position_id >", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recruit_position_id >=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThan(Integer value) {
            addCriterion("recruit_position_id <", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("recruit_position_id <=", value, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdIn(List<Integer> values) {
            addCriterion("recruit_position_id in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotIn(List<Integer> values) {
            addCriterion("recruit_position_id not in", values, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("recruit_position_id between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recruit_position_id not between", value1, value2, "recruitPositionId");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIsNull() {
            addCriterion("recruit_position is null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIsNotNull() {
            addCriterion("recruit_position is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionEqualTo(String value) {
            addCriterion("recruit_position =", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionNotEqualTo(String value) {
            addCriterion("recruit_position <>", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionGreaterThan(String value) {
            addCriterion("recruit_position >", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_position >=", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionLessThan(String value) {
            addCriterion("recruit_position <", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionLessThanOrEqualTo(String value) {
            addCriterion("recruit_position <=", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionLike(String value) {
            addCriterion("recruit_position like", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionNotLike(String value) {
            addCriterion("recruit_position not like", value, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionIn(List<String> values) {
            addCriterion("recruit_position in", values, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionNotIn(List<String> values) {
            addCriterion("recruit_position not in", values, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionBetween(String value1, String value2) {
            addCriterion("recruit_position between", value1, value2, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andRecruitPositionNotBetween(String value1, String value2) {
            addCriterion("recruit_position not between", value1, value2, "recruitPosition");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("salary like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("salary not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andRecruitCityIsNull() {
            addCriterion("recruit_city is null");
            return (Criteria) this;
        }

        public Criteria andRecruitCityIsNotNull() {
            addCriterion("recruit_city is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitCityEqualTo(String value) {
            addCriterion("recruit_city =", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNotEqualTo(String value) {
            addCriterion("recruit_city <>", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityGreaterThan(String value) {
            addCriterion("recruit_city >", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_city >=", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityLessThan(String value) {
            addCriterion("recruit_city <", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityLessThanOrEqualTo(String value) {
            addCriterion("recruit_city <=", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityLike(String value) {
            addCriterion("recruit_city like", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNotLike(String value) {
            addCriterion("recruit_city not like", value, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityIn(List<String> values) {
            addCriterion("recruit_city in", values, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNotIn(List<String> values) {
            addCriterion("recruit_city not in", values, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityBetween(String value1, String value2) {
            addCriterion("recruit_city between", value1, value2, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNotBetween(String value1, String value2) {
            addCriterion("recruit_city not between", value1, value2, "recruitCity");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameIsNull() {
            addCriterion("recruit_city_name is null");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameIsNotNull() {
            addCriterion("recruit_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameEqualTo(String value) {
            addCriterion("recruit_city_name =", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameNotEqualTo(String value) {
            addCriterion("recruit_city_name <>", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameGreaterThan(String value) {
            addCriterion("recruit_city_name >", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_city_name >=", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameLessThan(String value) {
            addCriterion("recruit_city_name <", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameLessThanOrEqualTo(String value) {
            addCriterion("recruit_city_name <=", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameLike(String value) {
            addCriterion("recruit_city_name like", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameNotLike(String value) {
            addCriterion("recruit_city_name not like", value, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameIn(List<String> values) {
            addCriterion("recruit_city_name in", values, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameNotIn(List<String> values) {
            addCriterion("recruit_city_name not in", values, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameBetween(String value1, String value2) {
            addCriterion("recruit_city_name between", value1, value2, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitCityNameNotBetween(String value1, String value2) {
            addCriterion("recruit_city_name not between", value1, value2, "recruitCityName");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIsNull() {
            addCriterion("recruit_type is null");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIsNotNull() {
            addCriterion("recruit_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeEqualTo(String value) {
            addCriterion("recruit_type =", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotEqualTo(String value) {
            addCriterion("recruit_type <>", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeGreaterThan(String value) {
            addCriterion("recruit_type >", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_type >=", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLessThan(String value) {
            addCriterion("recruit_type <", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLessThanOrEqualTo(String value) {
            addCriterion("recruit_type <=", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeLike(String value) {
            addCriterion("recruit_type like", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotLike(String value) {
            addCriterion("recruit_type not like", value, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeIn(List<String> values) {
            addCriterion("recruit_type in", values, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotIn(List<String> values) {
            addCriterion("recruit_type not in", values, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeBetween(String value1, String value2) {
            addCriterion("recruit_type between", value1, value2, "recruitType");
            return (Criteria) this;
        }

        public Criteria andRecruitTypeNotBetween(String value1, String value2) {
            addCriterion("recruit_type not between", value1, value2, "recruitType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNull() {
            addCriterion("position_type is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNotNull() {
            addCriterion("position_type is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeEqualTo(String value) {
            addCriterion("position_type =", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotEqualTo(String value) {
            addCriterion("position_type <>", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThan(String value) {
            addCriterion("position_type >", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("position_type >=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThan(String value) {
            addCriterion("position_type <", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThanOrEqualTo(String value) {
            addCriterion("position_type <=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLike(String value) {
            addCriterion("position_type like", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotLike(String value) {
            addCriterion("position_type not like", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIn(List<String> values) {
            addCriterion("position_type in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotIn(List<String> values) {
            addCriterion("position_type not in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeBetween(String value1, String value2) {
            addCriterion("position_type between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotBetween(String value1, String value2) {
            addCriterion("position_type not between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIsNull() {
            addCriterion("position_type_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIsNotNull() {
            addCriterion("position_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameEqualTo(String value) {
            addCriterion("position_type_name =", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotEqualTo(String value) {
            addCriterion("position_type_name <>", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameGreaterThan(String value) {
            addCriterion("position_type_name >", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_type_name >=", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLessThan(String value) {
            addCriterion("position_type_name <", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLessThanOrEqualTo(String value) {
            addCriterion("position_type_name <=", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameLike(String value) {
            addCriterion("position_type_name like", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotLike(String value) {
            addCriterion("position_type_name not like", value, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameIn(List<String> values) {
            addCriterion("position_type_name in", values, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotIn(List<String> values) {
            addCriterion("position_type_name not in", values, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameBetween(String value1, String value2) {
            addCriterion("position_type_name between", value1, value2, "positionTypeName");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNameNotBetween(String value1, String value2) {
            addCriterion("position_type_name not between", value1, value2, "positionTypeName");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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