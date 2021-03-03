package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteScopeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteScopeExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("`year` is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("`year` is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("`year` =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("`year` <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("`year` >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("`year` >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("`year` <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("`year` <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("`year` like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("`year` not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("`year` in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("`year` not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("`year` between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("`year` not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andFgsCountIsNull() {
            addCriterion("fgs_count is null");
            return (Criteria) this;
        }

        public Criteria andFgsCountIsNotNull() {
            addCriterion("fgs_count is not null");
            return (Criteria) this;
        }

        public Criteria andFgsCountEqualTo(String value) {
            addCriterion("fgs_count =", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountNotEqualTo(String value) {
            addCriterion("fgs_count <>", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountGreaterThan(String value) {
            addCriterion("fgs_count >", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountGreaterThanOrEqualTo(String value) {
            addCriterion("fgs_count >=", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountLessThan(String value) {
            addCriterion("fgs_count <", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountLessThanOrEqualTo(String value) {
            addCriterion("fgs_count <=", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountLike(String value) {
            addCriterion("fgs_count like", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountNotLike(String value) {
            addCriterion("fgs_count not like", value, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountIn(List<String> values) {
            addCriterion("fgs_count in", values, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountNotIn(List<String> values) {
            addCriterion("fgs_count not in", values, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountBetween(String value1, String value2) {
            addCriterion("fgs_count between", value1, value2, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andFgsCountNotBetween(String value1, String value2) {
            addCriterion("fgs_count not between", value1, value2, "fgsCount");
            return (Criteria) this;
        }

        public Criteria andKhCountIsNull() {
            addCriterion("kh_count is null");
            return (Criteria) this;
        }

        public Criteria andKhCountIsNotNull() {
            addCriterion("kh_count is not null");
            return (Criteria) this;
        }

        public Criteria andKhCountEqualTo(String value) {
            addCriterion("kh_count =", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountNotEqualTo(String value) {
            addCriterion("kh_count <>", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountGreaterThan(String value) {
            addCriterion("kh_count >", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountGreaterThanOrEqualTo(String value) {
            addCriterion("kh_count >=", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountLessThan(String value) {
            addCriterion("kh_count <", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountLessThanOrEqualTo(String value) {
            addCriterion("kh_count <=", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountLike(String value) {
            addCriterion("kh_count like", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountNotLike(String value) {
            addCriterion("kh_count not like", value, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountIn(List<String> values) {
            addCriterion("kh_count in", values, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountNotIn(List<String> values) {
            addCriterion("kh_count not in", values, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountBetween(String value1, String value2) {
            addCriterion("kh_count between", value1, value2, "khCount");
            return (Criteria) this;
        }

        public Criteria andKhCountNotBetween(String value1, String value2) {
            addCriterion("kh_count not between", value1, value2, "khCount");
            return (Criteria) this;
        }

        public Criteria andRyCountIsNull() {
            addCriterion("ry_count is null");
            return (Criteria) this;
        }

        public Criteria andRyCountIsNotNull() {
            addCriterion("ry_count is not null");
            return (Criteria) this;
        }

        public Criteria andRyCountEqualTo(String value) {
            addCriterion("ry_count =", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountNotEqualTo(String value) {
            addCriterion("ry_count <>", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountGreaterThan(String value) {
            addCriterion("ry_count >", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountGreaterThanOrEqualTo(String value) {
            addCriterion("ry_count >=", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountLessThan(String value) {
            addCriterion("ry_count <", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountLessThanOrEqualTo(String value) {
            addCriterion("ry_count <=", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountLike(String value) {
            addCriterion("ry_count like", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountNotLike(String value) {
            addCriterion("ry_count not like", value, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountIn(List<String> values) {
            addCriterion("ry_count in", values, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountNotIn(List<String> values) {
            addCriterion("ry_count not in", values, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountBetween(String value1, String value2) {
            addCriterion("ry_count between", value1, value2, "ryCount");
            return (Criteria) this;
        }

        public Criteria andRyCountNotBetween(String value1, String value2) {
            addCriterion("ry_count not between", value1, value2, "ryCount");
            return (Criteria) this;
        }

        public Criteria andShowIsNull() {
            addCriterion("`show` is null");
            return (Criteria) this;
        }

        public Criteria andShowIsNotNull() {
            addCriterion("`show` is not null");
            return (Criteria) this;
        }

        public Criteria andShowEqualTo(String value) {
            addCriterion("`show` =", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotEqualTo(String value) {
            addCriterion("`show` <>", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowGreaterThan(String value) {
            addCriterion("`show` >", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowGreaterThanOrEqualTo(String value) {
            addCriterion("`show` >=", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowLessThan(String value) {
            addCriterion("`show` <", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowLessThanOrEqualTo(String value) {
            addCriterion("`show` <=", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowLike(String value) {
            addCriterion("`show` like", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotLike(String value) {
            addCriterion("`show` not like", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowIn(List<String> values) {
            addCriterion("`show` in", values, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotIn(List<String> values) {
            addCriterion("`show` not in", values, "show");
            return (Criteria) this;
        }

        public Criteria andShowBetween(String value1, String value2) {
            addCriterion("`show` between", value1, value2, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotBetween(String value1, String value2) {
            addCriterion("`show` not between", value1, value2, "show");
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