package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteBasicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteBasicExample() {
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

        public Criteria andTimeIsNull() {
            addCriterion("`time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("`time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("`time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("`time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("`time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("`time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("`time` like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("`time` not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("`time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("`time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("`time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("`time` not between", value1, value2, "time");
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

        public Criteria andVideoShareAdressIsNull() {
            addCriterion("video_share_adress is null");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressIsNotNull() {
            addCriterion("video_share_adress is not null");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressEqualTo(String value) {
            addCriterion("video_share_adress =", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressNotEqualTo(String value) {
            addCriterion("video_share_adress <>", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressGreaterThan(String value) {
            addCriterion("video_share_adress >", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressGreaterThanOrEqualTo(String value) {
            addCriterion("video_share_adress >=", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressLessThan(String value) {
            addCriterion("video_share_adress <", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressLessThanOrEqualTo(String value) {
            addCriterion("video_share_adress <=", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressLike(String value) {
            addCriterion("video_share_adress like", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressNotLike(String value) {
            addCriterion("video_share_adress not like", value, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressIn(List<String> values) {
            addCriterion("video_share_adress in", values, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressNotIn(List<String> values) {
            addCriterion("video_share_adress not in", values, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressBetween(String value1, String value2) {
            addCriterion("video_share_adress between", value1, value2, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoShareAdressNotBetween(String value1, String value2) {
            addCriterion("video_share_adress not between", value1, value2, "videoShareAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressIsNull() {
            addCriterion("video_chinese_adress is null");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressIsNotNull() {
            addCriterion("video_chinese_adress is not null");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressEqualTo(String value) {
            addCriterion("video_chinese_adress =", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressNotEqualTo(String value) {
            addCriterion("video_chinese_adress <>", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressGreaterThan(String value) {
            addCriterion("video_chinese_adress >", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressGreaterThanOrEqualTo(String value) {
            addCriterion("video_chinese_adress >=", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressLessThan(String value) {
            addCriterion("video_chinese_adress <", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressLessThanOrEqualTo(String value) {
            addCriterion("video_chinese_adress <=", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressLike(String value) {
            addCriterion("video_chinese_adress like", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressNotLike(String value) {
            addCriterion("video_chinese_adress not like", value, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressIn(List<String> values) {
            addCriterion("video_chinese_adress in", values, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressNotIn(List<String> values) {
            addCriterion("video_chinese_adress not in", values, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressBetween(String value1, String value2) {
            addCriterion("video_chinese_adress between", value1, value2, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoChineseAdressNotBetween(String value1, String value2) {
            addCriterion("video_chinese_adress not between", value1, value2, "videoChineseAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressIsNull() {
            addCriterion("video_english_adress is null");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressIsNotNull() {
            addCriterion("video_english_adress is not null");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressEqualTo(String value) {
            addCriterion("video_english_adress =", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressNotEqualTo(String value) {
            addCriterion("video_english_adress <>", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressGreaterThan(String value) {
            addCriterion("video_english_adress >", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressGreaterThanOrEqualTo(String value) {
            addCriterion("video_english_adress >=", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressLessThan(String value) {
            addCriterion("video_english_adress <", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressLessThanOrEqualTo(String value) {
            addCriterion("video_english_adress <=", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressLike(String value) {
            addCriterion("video_english_adress like", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressNotLike(String value) {
            addCriterion("video_english_adress not like", value, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressIn(List<String> values) {
            addCriterion("video_english_adress in", values, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressNotIn(List<String> values) {
            addCriterion("video_english_adress not in", values, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressBetween(String value1, String value2) {
            addCriterion("video_english_adress between", value1, value2, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andVideoEnglishAdressNotBetween(String value1, String value2) {
            addCriterion("video_english_adress not between", value1, value2, "videoEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andCheckedIsNull() {
            addCriterion("`checked` is null");
            return (Criteria) this;
        }

        public Criteria andCheckedIsNotNull() {
            addCriterion("`checked` is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedEqualTo(String value) {
            addCriterion("`checked` =", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotEqualTo(String value) {
            addCriterion("`checked` <>", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedGreaterThan(String value) {
            addCriterion("`checked` >", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedGreaterThanOrEqualTo(String value) {
            addCriterion("`checked` >=", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLessThan(String value) {
            addCriterion("`checked` <", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLessThanOrEqualTo(String value) {
            addCriterion("`checked` <=", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedLike(String value) {
            addCriterion("`checked` like", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotLike(String value) {
            addCriterion("`checked` not like", value, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedIn(List<String> values) {
            addCriterion("`checked` in", values, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotIn(List<String> values) {
            addCriterion("`checked` not in", values, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedBetween(String value1, String value2) {
            addCriterion("`checked` between", value1, value2, "checked");
            return (Criteria) this;
        }

        public Criteria andCheckedNotBetween(String value1, String value2) {
            addCriterion("`checked` not between", value1, value2, "checked");
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