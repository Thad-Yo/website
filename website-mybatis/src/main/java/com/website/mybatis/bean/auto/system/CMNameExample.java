package com.website.mybatis.bean.auto.system;

import java.util.ArrayList;
import java.util.List;

public class CMNameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CMNameExample() {
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

        public Criteria andNameClassIsNull() {
            addCriterion("name_class is null");
            return (Criteria) this;
        }

        public Criteria andNameClassIsNotNull() {
            addCriterion("name_class is not null");
            return (Criteria) this;
        }

        public Criteria andNameClassEqualTo(String value) {
            addCriterion("name_class =", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassNotEqualTo(String value) {
            addCriterion("name_class <>", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassGreaterThan(String value) {
            addCriterion("name_class >", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassGreaterThanOrEqualTo(String value) {
            addCriterion("name_class >=", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassLessThan(String value) {
            addCriterion("name_class <", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassLessThanOrEqualTo(String value) {
            addCriterion("name_class <=", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassLike(String value) {
            addCriterion("name_class like", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassNotLike(String value) {
            addCriterion("name_class not like", value, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassIn(List<String> values) {
            addCriterion("name_class in", values, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassNotIn(List<String> values) {
            addCriterion("name_class not in", values, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassBetween(String value1, String value2) {
            addCriterion("name_class between", value1, value2, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameClassNotBetween(String value1, String value2) {
            addCriterion("name_class not between", value1, value2, "nameClass");
            return (Criteria) this;
        }

        public Criteria andNameCdIsNull() {
            addCriterion("name_cd is null");
            return (Criteria) this;
        }

        public Criteria andNameCdIsNotNull() {
            addCriterion("name_cd is not null");
            return (Criteria) this;
        }

        public Criteria andNameCdEqualTo(String value) {
            addCriterion("name_cd =", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdNotEqualTo(String value) {
            addCriterion("name_cd <>", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdGreaterThan(String value) {
            addCriterion("name_cd >", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdGreaterThanOrEqualTo(String value) {
            addCriterion("name_cd >=", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdLessThan(String value) {
            addCriterion("name_cd <", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdLessThanOrEqualTo(String value) {
            addCriterion("name_cd <=", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdLike(String value) {
            addCriterion("name_cd like", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdNotLike(String value) {
            addCriterion("name_cd not like", value, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdIn(List<String> values) {
            addCriterion("name_cd in", values, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdNotIn(List<String> values) {
            addCriterion("name_cd not in", values, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdBetween(String value1, String value2) {
            addCriterion("name_cd between", value1, value2, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameCdNotBetween(String value1, String value2) {
            addCriterion("name_cd not between", value1, value2, "nameCd");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
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

        public Criteria andSortKeyEqualTo(String value) {
            addCriterion("sort_key =", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyNotEqualTo(String value) {
            addCriterion("sort_key <>", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyGreaterThan(String value) {
            addCriterion("sort_key >", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sort_key >=", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyLessThan(String value) {
            addCriterion("sort_key <", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyLessThanOrEqualTo(String value) {
            addCriterion("sort_key <=", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyLike(String value) {
            addCriterion("sort_key like", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyNotLike(String value) {
            addCriterion("sort_key not like", value, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyIn(List<String> values) {
            addCriterion("sort_key in", values, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyNotIn(List<String> values) {
            addCriterion("sort_key not in", values, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyBetween(String value1, String value2) {
            addCriterion("sort_key between", value1, value2, "sortKey");
            return (Criteria) this;
        }

        public Criteria andSortKeyNotBetween(String value1, String value2) {
            addCriterion("sort_key not between", value1, value2, "sortKey");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("`data` is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("`data` is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("`data` =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("`data` <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("`data` >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("`data` >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("`data` <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("`data` <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("`data` like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("`data` not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("`data` in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("`data` not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("`data` between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("`data` not between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andReserve01IsNull() {
            addCriterion("reserve01 is null");
            return (Criteria) this;
        }

        public Criteria andReserve01IsNotNull() {
            addCriterion("reserve01 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve01EqualTo(String value) {
            addCriterion("reserve01 =", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01NotEqualTo(String value) {
            addCriterion("reserve01 <>", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01GreaterThan(String value) {
            addCriterion("reserve01 >", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01GreaterThanOrEqualTo(String value) {
            addCriterion("reserve01 >=", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01LessThan(String value) {
            addCriterion("reserve01 <", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01LessThanOrEqualTo(String value) {
            addCriterion("reserve01 <=", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01Like(String value) {
            addCriterion("reserve01 like", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01NotLike(String value) {
            addCriterion("reserve01 not like", value, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01In(List<String> values) {
            addCriterion("reserve01 in", values, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01NotIn(List<String> values) {
            addCriterion("reserve01 not in", values, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01Between(String value1, String value2) {
            addCriterion("reserve01 between", value1, value2, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve01NotBetween(String value1, String value2) {
            addCriterion("reserve01 not between", value1, value2, "reserve01");
            return (Criteria) this;
        }

        public Criteria andReserve02IsNull() {
            addCriterion("reserve02 is null");
            return (Criteria) this;
        }

        public Criteria andReserve02IsNotNull() {
            addCriterion("reserve02 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve02EqualTo(String value) {
            addCriterion("reserve02 =", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02NotEqualTo(String value) {
            addCriterion("reserve02 <>", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02GreaterThan(String value) {
            addCriterion("reserve02 >", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02GreaterThanOrEqualTo(String value) {
            addCriterion("reserve02 >=", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02LessThan(String value) {
            addCriterion("reserve02 <", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02LessThanOrEqualTo(String value) {
            addCriterion("reserve02 <=", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02Like(String value) {
            addCriterion("reserve02 like", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02NotLike(String value) {
            addCriterion("reserve02 not like", value, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02In(List<String> values) {
            addCriterion("reserve02 in", values, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02NotIn(List<String> values) {
            addCriterion("reserve02 not in", values, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02Between(String value1, String value2) {
            addCriterion("reserve02 between", value1, value2, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve02NotBetween(String value1, String value2) {
            addCriterion("reserve02 not between", value1, value2, "reserve02");
            return (Criteria) this;
        }

        public Criteria andReserve03IsNull() {
            addCriterion("reserve03 is null");
            return (Criteria) this;
        }

        public Criteria andReserve03IsNotNull() {
            addCriterion("reserve03 is not null");
            return (Criteria) this;
        }

        public Criteria andReserve03EqualTo(String value) {
            addCriterion("reserve03 =", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03NotEqualTo(String value) {
            addCriterion("reserve03 <>", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03GreaterThan(String value) {
            addCriterion("reserve03 >", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03GreaterThanOrEqualTo(String value) {
            addCriterion("reserve03 >=", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03LessThan(String value) {
            addCriterion("reserve03 <", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03LessThanOrEqualTo(String value) {
            addCriterion("reserve03 <=", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03Like(String value) {
            addCriterion("reserve03 like", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03NotLike(String value) {
            addCriterion("reserve03 not like", value, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03In(List<String> values) {
            addCriterion("reserve03 in", values, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03NotIn(List<String> values) {
            addCriterion("reserve03 not in", values, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03Between(String value1, String value2) {
            addCriterion("reserve03 between", value1, value2, "reserve03");
            return (Criteria) this;
        }

        public Criteria andReserve03NotBetween(String value1, String value2) {
            addCriterion("reserve03 not between", value1, value2, "reserve03");
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