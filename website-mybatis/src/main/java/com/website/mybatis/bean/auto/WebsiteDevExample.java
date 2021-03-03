package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteDevExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteDevExample() {
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

        public Criteria andDevNumberIsNull() {
            addCriterion("dev_number is null");
            return (Criteria) this;
        }

        public Criteria andDevNumberIsNotNull() {
            addCriterion("dev_number is not null");
            return (Criteria) this;
        }

        public Criteria andDevNumberEqualTo(String value) {
            addCriterion("dev_number =", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotEqualTo(String value) {
            addCriterion("dev_number <>", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberGreaterThan(String value) {
            addCriterion("dev_number >", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberGreaterThanOrEqualTo(String value) {
            addCriterion("dev_number >=", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberLessThan(String value) {
            addCriterion("dev_number <", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberLessThanOrEqualTo(String value) {
            addCriterion("dev_number <=", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberLike(String value) {
            addCriterion("dev_number like", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotLike(String value) {
            addCriterion("dev_number not like", value, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberIn(List<String> values) {
            addCriterion("dev_number in", values, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotIn(List<String> values) {
            addCriterion("dev_number not in", values, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberBetween(String value1, String value2) {
            addCriterion("dev_number between", value1, value2, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevNumberNotBetween(String value1, String value2) {
            addCriterion("dev_number not between", value1, value2, "devNumber");
            return (Criteria) this;
        }

        public Criteria andDevDateEngIsNull() {
            addCriterion("dev_date_eng is null");
            return (Criteria) this;
        }

        public Criteria andDevDateEngIsNotNull() {
            addCriterion("dev_date_eng is not null");
            return (Criteria) this;
        }

        public Criteria andDevDateEngEqualTo(String value) {
            addCriterion("dev_date_eng =", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngNotEqualTo(String value) {
            addCriterion("dev_date_eng <>", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngGreaterThan(String value) {
            addCriterion("dev_date_eng >", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngGreaterThanOrEqualTo(String value) {
            addCriterion("dev_date_eng >=", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngLessThan(String value) {
            addCriterion("dev_date_eng <", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngLessThanOrEqualTo(String value) {
            addCriterion("dev_date_eng <=", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngLike(String value) {
            addCriterion("dev_date_eng like", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngNotLike(String value) {
            addCriterion("dev_date_eng not like", value, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngIn(List<String> values) {
            addCriterion("dev_date_eng in", values, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngNotIn(List<String> values) {
            addCriterion("dev_date_eng not in", values, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngBetween(String value1, String value2) {
            addCriterion("dev_date_eng between", value1, value2, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateEngNotBetween(String value1, String value2) {
            addCriterion("dev_date_eng not between", value1, value2, "devDateEng");
            return (Criteria) this;
        }

        public Criteria andDevDateIsNull() {
            addCriterion("dev_date is null");
            return (Criteria) this;
        }

        public Criteria andDevDateIsNotNull() {
            addCriterion("dev_date is not null");
            return (Criteria) this;
        }

        public Criteria andDevDateEqualTo(String value) {
            addCriterion("dev_date =", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateNotEqualTo(String value) {
            addCriterion("dev_date <>", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateGreaterThan(String value) {
            addCriterion("dev_date >", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateGreaterThanOrEqualTo(String value) {
            addCriterion("dev_date >=", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateLessThan(String value) {
            addCriterion("dev_date <", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateLessThanOrEqualTo(String value) {
            addCriterion("dev_date <=", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateLike(String value) {
            addCriterion("dev_date like", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateNotLike(String value) {
            addCriterion("dev_date not like", value, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateIn(List<String> values) {
            addCriterion("dev_date in", values, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateNotIn(List<String> values) {
            addCriterion("dev_date not in", values, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateBetween(String value1, String value2) {
            addCriterion("dev_date between", value1, value2, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevDateNotBetween(String value1, String value2) {
            addCriterion("dev_date not between", value1, value2, "devDate");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngIsNull() {
            addCriterion("dev_title_eng is null");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngIsNotNull() {
            addCriterion("dev_title_eng is not null");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngEqualTo(String value) {
            addCriterion("dev_title_eng =", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngNotEqualTo(String value) {
            addCriterion("dev_title_eng <>", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngGreaterThan(String value) {
            addCriterion("dev_title_eng >", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngGreaterThanOrEqualTo(String value) {
            addCriterion("dev_title_eng >=", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngLessThan(String value) {
            addCriterion("dev_title_eng <", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngLessThanOrEqualTo(String value) {
            addCriterion("dev_title_eng <=", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngLike(String value) {
            addCriterion("dev_title_eng like", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngNotLike(String value) {
            addCriterion("dev_title_eng not like", value, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngIn(List<String> values) {
            addCriterion("dev_title_eng in", values, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngNotIn(List<String> values) {
            addCriterion("dev_title_eng not in", values, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngBetween(String value1, String value2) {
            addCriterion("dev_title_eng between", value1, value2, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleEngNotBetween(String value1, String value2) {
            addCriterion("dev_title_eng not between", value1, value2, "devTitleEng");
            return (Criteria) this;
        }

        public Criteria andDevTitleIsNull() {
            addCriterion("dev_title is null");
            return (Criteria) this;
        }

        public Criteria andDevTitleIsNotNull() {
            addCriterion("dev_title is not null");
            return (Criteria) this;
        }

        public Criteria andDevTitleEqualTo(String value) {
            addCriterion("dev_title =", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleNotEqualTo(String value) {
            addCriterion("dev_title <>", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleGreaterThan(String value) {
            addCriterion("dev_title >", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleGreaterThanOrEqualTo(String value) {
            addCriterion("dev_title >=", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleLessThan(String value) {
            addCriterion("dev_title <", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleLessThanOrEqualTo(String value) {
            addCriterion("dev_title <=", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleLike(String value) {
            addCriterion("dev_title like", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleNotLike(String value) {
            addCriterion("dev_title not like", value, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleIn(List<String> values) {
            addCriterion("dev_title in", values, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleNotIn(List<String> values) {
            addCriterion("dev_title not in", values, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleBetween(String value1, String value2) {
            addCriterion("dev_title between", value1, value2, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTitleNotBetween(String value1, String value2) {
            addCriterion("dev_title not between", value1, value2, "devTitle");
            return (Criteria) this;
        }

        public Criteria andDevTextEngIsNull() {
            addCriterion("dev_text_eng is null");
            return (Criteria) this;
        }

        public Criteria andDevTextEngIsNotNull() {
            addCriterion("dev_text_eng is not null");
            return (Criteria) this;
        }

        public Criteria andDevTextEngEqualTo(String value) {
            addCriterion("dev_text_eng =", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngNotEqualTo(String value) {
            addCriterion("dev_text_eng <>", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngGreaterThan(String value) {
            addCriterion("dev_text_eng >", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngGreaterThanOrEqualTo(String value) {
            addCriterion("dev_text_eng >=", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngLessThan(String value) {
            addCriterion("dev_text_eng <", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngLessThanOrEqualTo(String value) {
            addCriterion("dev_text_eng <=", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngLike(String value) {
            addCriterion("dev_text_eng like", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngNotLike(String value) {
            addCriterion("dev_text_eng not like", value, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngIn(List<String> values) {
            addCriterion("dev_text_eng in", values, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngNotIn(List<String> values) {
            addCriterion("dev_text_eng not in", values, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngBetween(String value1, String value2) {
            addCriterion("dev_text_eng between", value1, value2, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextEngNotBetween(String value1, String value2) {
            addCriterion("dev_text_eng not between", value1, value2, "devTextEng");
            return (Criteria) this;
        }

        public Criteria andDevTextIsNull() {
            addCriterion("dev_text is null");
            return (Criteria) this;
        }

        public Criteria andDevTextIsNotNull() {
            addCriterion("dev_text is not null");
            return (Criteria) this;
        }

        public Criteria andDevTextEqualTo(String value) {
            addCriterion("dev_text =", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextNotEqualTo(String value) {
            addCriterion("dev_text <>", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextGreaterThan(String value) {
            addCriterion("dev_text >", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextGreaterThanOrEqualTo(String value) {
            addCriterion("dev_text >=", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextLessThan(String value) {
            addCriterion("dev_text <", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextLessThanOrEqualTo(String value) {
            addCriterion("dev_text <=", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextLike(String value) {
            addCriterion("dev_text like", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextNotLike(String value) {
            addCriterion("dev_text not like", value, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextIn(List<String> values) {
            addCriterion("dev_text in", values, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextNotIn(List<String> values) {
            addCriterion("dev_text not in", values, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextBetween(String value1, String value2) {
            addCriterion("dev_text between", value1, value2, "devText");
            return (Criteria) this;
        }

        public Criteria andDevTextNotBetween(String value1, String value2) {
            addCriterion("dev_text not between", value1, value2, "devText");
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