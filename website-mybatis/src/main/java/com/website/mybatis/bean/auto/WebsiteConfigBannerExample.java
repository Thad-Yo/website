package com.website.mybatis.bean.auto;

import java.util.ArrayList;
import java.util.List;

public class WebsiteConfigBannerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public WebsiteConfigBannerExample() {
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

        public Criteria andImgChineseAdressIsNull() {
            addCriterion("img_Chinese_adress is null");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressIsNotNull() {
            addCriterion("img_Chinese_adress is not null");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressEqualTo(String value) {
            addCriterion("img_Chinese_adress =", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressNotEqualTo(String value) {
            addCriterion("img_Chinese_adress <>", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressGreaterThan(String value) {
            addCriterion("img_Chinese_adress >", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressGreaterThanOrEqualTo(String value) {
            addCriterion("img_Chinese_adress >=", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressLessThan(String value) {
            addCriterion("img_Chinese_adress <", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressLessThanOrEqualTo(String value) {
            addCriterion("img_Chinese_adress <=", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressLike(String value) {
            addCriterion("img_Chinese_adress like", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressNotLike(String value) {
            addCriterion("img_Chinese_adress not like", value, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressIn(List<String> values) {
            addCriterion("img_Chinese_adress in", values, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressNotIn(List<String> values) {
            addCriterion("img_Chinese_adress not in", values, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressBetween(String value1, String value2) {
            addCriterion("img_Chinese_adress between", value1, value2, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgChineseAdressNotBetween(String value1, String value2) {
            addCriterion("img_Chinese_adress not between", value1, value2, "imgChineseAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressIsNull() {
            addCriterion("img_English_adress is null");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressIsNotNull() {
            addCriterion("img_English_adress is not null");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressEqualTo(String value) {
            addCriterion("img_English_adress =", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressNotEqualTo(String value) {
            addCriterion("img_English_adress <>", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressGreaterThan(String value) {
            addCriterion("img_English_adress >", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressGreaterThanOrEqualTo(String value) {
            addCriterion("img_English_adress >=", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressLessThan(String value) {
            addCriterion("img_English_adress <", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressLessThanOrEqualTo(String value) {
            addCriterion("img_English_adress <=", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressLike(String value) {
            addCriterion("img_English_adress like", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressNotLike(String value) {
            addCriterion("img_English_adress not like", value, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressIn(List<String> values) {
            addCriterion("img_English_adress in", values, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressNotIn(List<String> values) {
            addCriterion("img_English_adress not in", values, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressBetween(String value1, String value2) {
            addCriterion("img_English_adress between", value1, value2, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andImgEnglishAdressNotBetween(String value1, String value2) {
            addCriterion("img_English_adress not between", value1, value2, "imgEnglishAdress");
            return (Criteria) this;
        }

        public Criteria andBannerNumberIsNull() {
            addCriterion("banner_number is null");
            return (Criteria) this;
        }

        public Criteria andBannerNumberIsNotNull() {
            addCriterion("banner_number is not null");
            return (Criteria) this;
        }

        public Criteria andBannerNumberEqualTo(String value) {
            addCriterion("banner_number =", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberNotEqualTo(String value) {
            addCriterion("banner_number <>", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberGreaterThan(String value) {
            addCriterion("banner_number >", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberGreaterThanOrEqualTo(String value) {
            addCriterion("banner_number >=", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberLessThan(String value) {
            addCriterion("banner_number <", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberLessThanOrEqualTo(String value) {
            addCriterion("banner_number <=", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberLike(String value) {
            addCriterion("banner_number like", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberNotLike(String value) {
            addCriterion("banner_number not like", value, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberIn(List<String> values) {
            addCriterion("banner_number in", values, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberNotIn(List<String> values) {
            addCriterion("banner_number not in", values, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberBetween(String value1, String value2) {
            addCriterion("banner_number between", value1, value2, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andBannerNumberNotBetween(String value1, String value2) {
            addCriterion("banner_number not between", value1, value2, "bannerNumber");
            return (Criteria) this;
        }

        public Criteria andImageLinkIsNull() {
            addCriterion("image_link is null");
            return (Criteria) this;
        }

        public Criteria andImageLinkIsNotNull() {
            addCriterion("image_link is not null");
            return (Criteria) this;
        }

        public Criteria andImageLinkEqualTo(String value) {
            addCriterion("image_link =", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotEqualTo(String value) {
            addCriterion("image_link <>", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkGreaterThan(String value) {
            addCriterion("image_link >", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkGreaterThanOrEqualTo(String value) {
            addCriterion("image_link >=", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkLessThan(String value) {
            addCriterion("image_link <", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkLessThanOrEqualTo(String value) {
            addCriterion("image_link <=", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkLike(String value) {
            addCriterion("image_link like", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotLike(String value) {
            addCriterion("image_link not like", value, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkIn(List<String> values) {
            addCriterion("image_link in", values, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotIn(List<String> values) {
            addCriterion("image_link not in", values, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkBetween(String value1, String value2) {
            addCriterion("image_link between", value1, value2, "imageLink");
            return (Criteria) this;
        }

        public Criteria andImageLinkNotBetween(String value1, String value2) {
            addCriterion("image_link not between", value1, value2, "imageLink");
            return (Criteria) this;
        }

        public Criteria andIssueIsNull() {
            addCriterion("issue is null");
            return (Criteria) this;
        }

        public Criteria andIssueIsNotNull() {
            addCriterion("issue is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEqualTo(String value) {
            addCriterion("issue =", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotEqualTo(String value) {
            addCriterion("issue <>", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThan(String value) {
            addCriterion("issue >", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThanOrEqualTo(String value) {
            addCriterion("issue >=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThan(String value) {
            addCriterion("issue <", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThanOrEqualTo(String value) {
            addCriterion("issue <=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLike(String value) {
            addCriterion("issue like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotLike(String value) {
            addCriterion("issue not like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueIn(List<String> values) {
            addCriterion("issue in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotIn(List<String> values) {
            addCriterion("issue not in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueBetween(String value1, String value2) {
            addCriterion("issue between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotBetween(String value1, String value2) {
            addCriterion("issue not between", value1, value2, "issue");
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