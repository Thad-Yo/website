package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteOurStaffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteOurStaffExample() {
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

        public Criteria andCnidIsNull() {
            addCriterion("cnId is null");
            return (Criteria) this;
        }

        public Criteria andCnidIsNotNull() {
            addCriterion("cnId is not null");
            return (Criteria) this;
        }

        public Criteria andCnidEqualTo(String value) {
            addCriterion("cnId =", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidNotEqualTo(String value) {
            addCriterion("cnId <>", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidGreaterThan(String value) {
            addCriterion("cnId >", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidGreaterThanOrEqualTo(String value) {
            addCriterion("cnId >=", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidLessThan(String value) {
            addCriterion("cnId <", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidLessThanOrEqualTo(String value) {
            addCriterion("cnId <=", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidLike(String value) {
            addCriterion("cnId like", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidNotLike(String value) {
            addCriterion("cnId not like", value, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidIn(List<String> values) {
            addCriterion("cnId in", values, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidNotIn(List<String> values) {
            addCriterion("cnId not in", values, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidBetween(String value1, String value2) {
            addCriterion("cnId between", value1, value2, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnidNotBetween(String value1, String value2) {
            addCriterion("cnId not between", value1, value2, "cnid");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagIsNull() {
            addCriterion("cn_en_flag is null");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagIsNotNull() {
            addCriterion("cn_en_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagEqualTo(String value) {
            addCriterion("cn_en_flag =", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagNotEqualTo(String value) {
            addCriterion("cn_en_flag <>", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagGreaterThan(String value) {
            addCriterion("cn_en_flag >", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagGreaterThanOrEqualTo(String value) {
            addCriterion("cn_en_flag >=", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagLessThan(String value) {
            addCriterion("cn_en_flag <", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagLessThanOrEqualTo(String value) {
            addCriterion("cn_en_flag <=", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagLike(String value) {
            addCriterion("cn_en_flag like", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagNotLike(String value) {
            addCriterion("cn_en_flag not like", value, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagIn(List<String> values) {
            addCriterion("cn_en_flag in", values, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagNotIn(List<String> values) {
            addCriterion("cn_en_flag not in", values, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagBetween(String value1, String value2) {
            addCriterion("cn_en_flag between", value1, value2, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andCnEnFlagNotBetween(String value1, String value2) {
            addCriterion("cn_en_flag not between", value1, value2, "cnEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagIsNull() {
            addCriterion("has_en_flag is null");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagIsNotNull() {
            addCriterion("has_en_flag is not null");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagEqualTo(String value) {
            addCriterion("has_en_flag =", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagNotEqualTo(String value) {
            addCriterion("has_en_flag <>", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagGreaterThan(String value) {
            addCriterion("has_en_flag >", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagGreaterThanOrEqualTo(String value) {
            addCriterion("has_en_flag >=", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagLessThan(String value) {
            addCriterion("has_en_flag <", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagLessThanOrEqualTo(String value) {
            addCriterion("has_en_flag <=", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagLike(String value) {
            addCriterion("has_en_flag like", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagNotLike(String value) {
            addCriterion("has_en_flag not like", value, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagIn(List<String> values) {
            addCriterion("has_en_flag in", values, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagNotIn(List<String> values) {
            addCriterion("has_en_flag not in", values, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagBetween(String value1, String value2) {
            addCriterion("has_en_flag between", value1, value2, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andHasEnFlagNotBetween(String value1, String value2) {
            addCriterion("has_en_flag not between", value1, value2, "hasEnFlag");
            return (Criteria) this;
        }

        public Criteria andImgDescIsNull() {
            addCriterion("img_desc is null");
            return (Criteria) this;
        }

        public Criteria andImgDescIsNotNull() {
            addCriterion("img_desc is not null");
            return (Criteria) this;
        }

        public Criteria andImgDescEqualTo(String value) {
            addCriterion("img_desc =", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotEqualTo(String value) {
            addCriterion("img_desc <>", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescGreaterThan(String value) {
            addCriterion("img_desc >", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescGreaterThanOrEqualTo(String value) {
            addCriterion("img_desc >=", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLessThan(String value) {
            addCriterion("img_desc <", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLessThanOrEqualTo(String value) {
            addCriterion("img_desc <=", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescLike(String value) {
            addCriterion("img_desc like", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotLike(String value) {
            addCriterion("img_desc not like", value, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescIn(List<String> values) {
            addCriterion("img_desc in", values, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotIn(List<String> values) {
            addCriterion("img_desc not in", values, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescBetween(String value1, String value2) {
            addCriterion("img_desc between", value1, value2, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgDescNotBetween(String value1, String value2) {
            addCriterion("img_desc not between", value1, value2, "imgDesc");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlIsNull() {
            addCriterion("img_less_url is null");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlIsNotNull() {
            addCriterion("img_less_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlEqualTo(String value) {
            addCriterion("img_less_url =", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlNotEqualTo(String value) {
            addCriterion("img_less_url <>", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlGreaterThan(String value) {
            addCriterion("img_less_url >", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_less_url >=", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlLessThan(String value) {
            addCriterion("img_less_url <", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlLessThanOrEqualTo(String value) {
            addCriterion("img_less_url <=", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlLike(String value) {
            addCriterion("img_less_url like", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlNotLike(String value) {
            addCriterion("img_less_url not like", value, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlIn(List<String> values) {
            addCriterion("img_less_url in", values, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlNotIn(List<String> values) {
            addCriterion("img_less_url not in", values, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlBetween(String value1, String value2) {
            addCriterion("img_less_url between", value1, value2, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andImgLessUrlNotBetween(String value1, String value2) {
            addCriterion("img_less_url not between", value1, value2, "imgLessUrl");
            return (Criteria) this;
        }

        public Criteria andSortNumberIsNull() {
            addCriterion("sort_number is null");
            return (Criteria) this;
        }

        public Criteria andSortNumberIsNotNull() {
            addCriterion("sort_number is not null");
            return (Criteria) this;
        }

        public Criteria andSortNumberEqualTo(Integer value) {
            addCriterion("sort_number =", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotEqualTo(Integer value) {
            addCriterion("sort_number <>", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberGreaterThan(Integer value) {
            addCriterion("sort_number >", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_number >=", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberLessThan(Integer value) {
            addCriterion("sort_number <", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sort_number <=", value, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberIn(List<Integer> values) {
            addCriterion("sort_number in", values, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotIn(List<Integer> values) {
            addCriterion("sort_number not in", values, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberBetween(Integer value1, Integer value2) {
            addCriterion("sort_number between", value1, value2, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andSortNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_number not between", value1, value2, "sortNumber");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNull() {
            addCriterion("img_type is null");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNotNull() {
            addCriterion("img_type is not null");
            return (Criteria) this;
        }

        public Criteria andImgTypeEqualTo(String value) {
            addCriterion("img_type =", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotEqualTo(String value) {
            addCriterion("img_type <>", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThan(String value) {
            addCriterion("img_type >", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("img_type >=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThan(String value) {
            addCriterion("img_type <", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThanOrEqualTo(String value) {
            addCriterion("img_type <=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLike(String value) {
            addCriterion("img_type like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotLike(String value) {
            addCriterion("img_type not like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeIn(List<String> values) {
            addCriterion("img_type in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotIn(List<String> values) {
            addCriterion("img_type not in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeBetween(String value1, String value2) {
            addCriterion("img_type between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotBetween(String value1, String value2) {
            addCriterion("img_type not between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNull() {
            addCriterion("type_code is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("type_code is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("type_code =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("type_code <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("type_code >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("type_code >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("type_code <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("type_code <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("type_code like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("type_code not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("type_code in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("type_code not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("type_code between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("type_code not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameIsNull() {
            addCriterion("img_type_name is null");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameIsNotNull() {
            addCriterion("img_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameEqualTo(String value) {
            addCriterion("img_type_name =", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameNotEqualTo(String value) {
            addCriterion("img_type_name <>", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameGreaterThan(String value) {
            addCriterion("img_type_name >", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("img_type_name >=", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameLessThan(String value) {
            addCriterion("img_type_name <", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameLessThanOrEqualTo(String value) {
            addCriterion("img_type_name <=", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameLike(String value) {
            addCriterion("img_type_name like", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameNotLike(String value) {
            addCriterion("img_type_name not like", value, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameIn(List<String> values) {
            addCriterion("img_type_name in", values, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameNotIn(List<String> values) {
            addCriterion("img_type_name not in", values, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameBetween(String value1, String value2) {
            addCriterion("img_type_name between", value1, value2, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeNameNotBetween(String value1, String value2) {
            addCriterion("img_type_name not between", value1, value2, "imgTypeName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameIsNull() {
            addCriterion("img_type_En_name is null");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameIsNotNull() {
            addCriterion("img_type_En_name is not null");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameEqualTo(String value) {
            addCriterion("img_type_En_name =", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameNotEqualTo(String value) {
            addCriterion("img_type_En_name <>", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameGreaterThan(String value) {
            addCriterion("img_type_En_name >", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("img_type_En_name >=", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameLessThan(String value) {
            addCriterion("img_type_En_name <", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameLessThanOrEqualTo(String value) {
            addCriterion("img_type_En_name <=", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameLike(String value) {
            addCriterion("img_type_En_name like", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameNotLike(String value) {
            addCriterion("img_type_En_name not like", value, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameIn(List<String> values) {
            addCriterion("img_type_En_name in", values, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameNotIn(List<String> values) {
            addCriterion("img_type_En_name not in", values, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameBetween(String value1, String value2) {
            addCriterion("img_type_En_name between", value1, value2, "imgTypeEnName");
            return (Criteria) this;
        }

        public Criteria andImgTypeEnNameNotBetween(String value1, String value2) {
            addCriterion("img_type_En_name not between", value1, value2, "imgTypeEnName");
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