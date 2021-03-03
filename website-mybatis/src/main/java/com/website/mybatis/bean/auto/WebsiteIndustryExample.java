package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteIndustryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteIndustryExample() {
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

        public Criteria andImgUrlZhIsNull() {
            addCriterion("img_url_zh is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhIsNotNull() {
            addCriterion("img_url_zh is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhEqualTo(String value) {
            addCriterion("img_url_zh =", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhNotEqualTo(String value) {
            addCriterion("img_url_zh <>", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhGreaterThan(String value) {
            addCriterion("img_url_zh >", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhGreaterThanOrEqualTo(String value) {
            addCriterion("img_url_zh >=", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhLessThan(String value) {
            addCriterion("img_url_zh <", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhLessThanOrEqualTo(String value) {
            addCriterion("img_url_zh <=", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhLike(String value) {
            addCriterion("img_url_zh like", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhNotLike(String value) {
            addCriterion("img_url_zh not like", value, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhIn(List<String> values) {
            addCriterion("img_url_zh in", values, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhNotIn(List<String> values) {
            addCriterion("img_url_zh not in", values, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhBetween(String value1, String value2) {
            addCriterion("img_url_zh between", value1, value2, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlZhNotBetween(String value1, String value2) {
            addCriterion("img_url_zh not between", value1, value2, "imgUrlZh");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnIsNull() {
            addCriterion("img_url_en is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnIsNotNull() {
            addCriterion("img_url_en is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnEqualTo(String value) {
            addCriterion("img_url_en =", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnNotEqualTo(String value) {
            addCriterion("img_url_en <>", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnGreaterThan(String value) {
            addCriterion("img_url_en >", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnGreaterThanOrEqualTo(String value) {
            addCriterion("img_url_en >=", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnLessThan(String value) {
            addCriterion("img_url_en <", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnLessThanOrEqualTo(String value) {
            addCriterion("img_url_en <=", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnLike(String value) {
            addCriterion("img_url_en like", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnNotLike(String value) {
            addCriterion("img_url_en not like", value, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnIn(List<String> values) {
            addCriterion("img_url_en in", values, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnNotIn(List<String> values) {
            addCriterion("img_url_en not in", values, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnBetween(String value1, String value2) {
            addCriterion("img_url_en between", value1, value2, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andImgUrlEnNotBetween(String value1, String value2) {
            addCriterion("img_url_en not between", value1, value2, "imgUrlEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhIsNull() {
            addCriterion("industry_name_zh is null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhIsNotNull() {
            addCriterion("industry_name_zh is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhEqualTo(String value) {
            addCriterion("industry_name_zh =", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhNotEqualTo(String value) {
            addCriterion("industry_name_zh <>", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhGreaterThan(String value) {
            addCriterion("industry_name_zh >", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhGreaterThanOrEqualTo(String value) {
            addCriterion("industry_name_zh >=", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhLessThan(String value) {
            addCriterion("industry_name_zh <", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhLessThanOrEqualTo(String value) {
            addCriterion("industry_name_zh <=", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhLike(String value) {
            addCriterion("industry_name_zh like", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhNotLike(String value) {
            addCriterion("industry_name_zh not like", value, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhIn(List<String> values) {
            addCriterion("industry_name_zh in", values, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhNotIn(List<String> values) {
            addCriterion("industry_name_zh not in", values, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhBetween(String value1, String value2) {
            addCriterion("industry_name_zh between", value1, value2, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameZhNotBetween(String value1, String value2) {
            addCriterion("industry_name_zh not between", value1, value2, "industryNameZh");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnIsNull() {
            addCriterion("industry_name_en is null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnIsNotNull() {
            addCriterion("industry_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnEqualTo(String value) {
            addCriterion("industry_name_en =", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnNotEqualTo(String value) {
            addCriterion("industry_name_en <>", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnGreaterThan(String value) {
            addCriterion("industry_name_en >", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("industry_name_en >=", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnLessThan(String value) {
            addCriterion("industry_name_en <", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnLessThanOrEqualTo(String value) {
            addCriterion("industry_name_en <=", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnLike(String value) {
            addCriterion("industry_name_en like", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnNotLike(String value) {
            addCriterion("industry_name_en not like", value, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnIn(List<String> values) {
            addCriterion("industry_name_en in", values, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnNotIn(List<String> values) {
            addCriterion("industry_name_en not in", values, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnBetween(String value1, String value2) {
            addCriterion("industry_name_en between", value1, value2, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEnNotBetween(String value1, String value2) {
            addCriterion("industry_name_en not between", value1, value2, "industryNameEn");
            return (Criteria) this;
        }

        public Criteria andHasEnIsNull() {
            addCriterion("has_en is null");
            return (Criteria) this;
        }

        public Criteria andHasEnIsNotNull() {
            addCriterion("has_en is not null");
            return (Criteria) this;
        }

        public Criteria andHasEnEqualTo(String value) {
            addCriterion("has_en =", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnNotEqualTo(String value) {
            addCriterion("has_en <>", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnGreaterThan(String value) {
            addCriterion("has_en >", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnGreaterThanOrEqualTo(String value) {
            addCriterion("has_en >=", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnLessThan(String value) {
            addCriterion("has_en <", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnLessThanOrEqualTo(String value) {
            addCriterion("has_en <=", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnLike(String value) {
            addCriterion("has_en like", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnNotLike(String value) {
            addCriterion("has_en not like", value, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnIn(List<String> values) {
            addCriterion("has_en in", values, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnNotIn(List<String> values) {
            addCriterion("has_en not in", values, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnBetween(String value1, String value2) {
            addCriterion("has_en between", value1, value2, "hasEn");
            return (Criteria) this;
        }

        public Criteria andHasEnNotBetween(String value1, String value2) {
            addCriterion("has_en not between", value1, value2, "hasEn");
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