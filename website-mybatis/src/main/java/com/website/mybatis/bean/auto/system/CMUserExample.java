package com.website.mybatis.bean.auto.system;

import java.util.ArrayList;
import java.util.List;

public class CMUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CMUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andDes3IsNull() {
            addCriterion("des3 is null");
            return (Criteria) this;
        }

        public Criteria andDes3IsNotNull() {
            addCriterion("des3 is not null");
            return (Criteria) this;
        }

        public Criteria andDes3EqualTo(String value) {
            addCriterion("des3 =", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3NotEqualTo(String value) {
            addCriterion("des3 <>", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3GreaterThan(String value) {
            addCriterion("des3 >", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3GreaterThanOrEqualTo(String value) {
            addCriterion("des3 >=", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3LessThan(String value) {
            addCriterion("des3 <", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3LessThanOrEqualTo(String value) {
            addCriterion("des3 <=", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3Like(String value) {
            addCriterion("des3 like", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3NotLike(String value) {
            addCriterion("des3 not like", value, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3In(List<String> values) {
            addCriterion("des3 in", values, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3NotIn(List<String> values) {
            addCriterion("des3 not in", values, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3Between(String value1, String value2) {
            addCriterion("des3 between", value1, value2, "des3");
            return (Criteria) this;
        }

        public Criteria andDes3NotBetween(String value1, String value2) {
            addCriterion("des3 not between", value1, value2, "des3");
            return (Criteria) this;
        }

        public Criteria andMobileNumberIsNull() {
            addCriterion("mobile_number is null");
            return (Criteria) this;
        }

        public Criteria andMobileNumberIsNotNull() {
            addCriterion("mobile_number is not null");
            return (Criteria) this;
        }

        public Criteria andMobileNumberEqualTo(String value) {
            addCriterion("mobile_number =", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberNotEqualTo(String value) {
            addCriterion("mobile_number <>", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberGreaterThan(String value) {
            addCriterion("mobile_number >", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_number >=", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberLessThan(String value) {
            addCriterion("mobile_number <", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberLessThanOrEqualTo(String value) {
            addCriterion("mobile_number <=", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberLike(String value) {
            addCriterion("mobile_number like", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberNotLike(String value) {
            addCriterion("mobile_number not like", value, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberIn(List<String> values) {
            addCriterion("mobile_number in", values, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberNotIn(List<String> values) {
            addCriterion("mobile_number not in", values, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberBetween(String value1, String value2) {
            addCriterion("mobile_number between", value1, value2, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andMobileNumberNotBetween(String value1, String value2) {
            addCriterion("mobile_number not between", value1, value2, "mobileNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberIsNull() {
            addCriterion("extension_number is null");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberIsNotNull() {
            addCriterion("extension_number is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberEqualTo(String value) {
            addCriterion("extension_number =", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberNotEqualTo(String value) {
            addCriterion("extension_number <>", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberGreaterThan(String value) {
            addCriterion("extension_number >", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberGreaterThanOrEqualTo(String value) {
            addCriterion("extension_number >=", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberLessThan(String value) {
            addCriterion("extension_number <", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberLessThanOrEqualTo(String value) {
            addCriterion("extension_number <=", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberLike(String value) {
            addCriterion("extension_number like", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberNotLike(String value) {
            addCriterion("extension_number not like", value, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberIn(List<String> values) {
            addCriterion("extension_number in", values, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberNotIn(List<String> values) {
            addCriterion("extension_number not in", values, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberBetween(String value1, String value2) {
            addCriterion("extension_number between", value1, value2, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andExtensionNumberNotBetween(String value1, String value2) {
            addCriterion("extension_number not between", value1, value2, "extensionNumber");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNull() {
            addCriterion("email_address is null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIsNotNull() {
            addCriterion("email_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmailAddressEqualTo(String value) {
            addCriterion("email_address =", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotEqualTo(String value) {
            addCriterion("email_address <>", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThan(String value) {
            addCriterion("email_address >", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressGreaterThanOrEqualTo(String value) {
            addCriterion("email_address >=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThan(String value) {
            addCriterion("email_address <", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLessThanOrEqualTo(String value) {
            addCriterion("email_address <=", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressLike(String value) {
            addCriterion("email_address like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotLike(String value) {
            addCriterion("email_address not like", value, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressIn(List<String> values) {
            addCriterion("email_address in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotIn(List<String> values) {
            addCriterion("email_address not in", values, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressBetween(String value1, String value2) {
            addCriterion("email_address between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andEmailAddressNotBetween(String value1, String value2) {
            addCriterion("email_address not between", value1, value2, "emailAddress");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNull() {
            addCriterion("user_flag is null");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNotNull() {
            addCriterion("user_flag is not null");
            return (Criteria) this;
        }

        public Criteria andUserFlagEqualTo(String value) {
            addCriterion("user_flag =", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotEqualTo(String value) {
            addCriterion("user_flag <>", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThan(String value) {
            addCriterion("user_flag >", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThanOrEqualTo(String value) {
            addCriterion("user_flag >=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThan(String value) {
            addCriterion("user_flag <", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThanOrEqualTo(String value) {
            addCriterion("user_flag <=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLike(String value) {
            addCriterion("user_flag like", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotLike(String value) {
            addCriterion("user_flag not like", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagIn(List<String> values) {
            addCriterion("user_flag in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotIn(List<String> values) {
            addCriterion("user_flag not in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagBetween(String value1, String value2) {
            addCriterion("user_flag between", value1, value2, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotBetween(String value1, String value2) {
            addCriterion("user_flag not between", value1, value2, "userFlag");
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

        public Criteria andUserNoIsNull() {
            addCriterion("user_no is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("user_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("user_no =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("user_no <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("user_no >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_no >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("user_no <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("user_no <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("user_no like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("user_no not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("user_no in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("user_no not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("user_no between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("user_no not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("`position` is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("`position` is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("`position` =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("`position` <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("`position` >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("`position` >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("`position` <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("`position` <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("`position` like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("`position` not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("`position` in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("`position` not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("`position` between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("`position` not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNull() {
            addCriterion("join_date is null");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNotNull() {
            addCriterion("join_date is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDateEqualTo(String value) {
            addCriterion("join_date =", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotEqualTo(String value) {
            addCriterion("join_date <>", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThan(String value) {
            addCriterion("join_date >", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThanOrEqualTo(String value) {
            addCriterion("join_date >=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThan(String value) {
            addCriterion("join_date <", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThanOrEqualTo(String value) {
            addCriterion("join_date <=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLike(String value) {
            addCriterion("join_date like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotLike(String value) {
            addCriterion("join_date not like", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateIn(List<String> values) {
            addCriterion("join_date in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotIn(List<String> values) {
            addCriterion("join_date not in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateBetween(String value1, String value2) {
            addCriterion("join_date between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotBetween(String value1, String value2) {
            addCriterion("join_date not between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserIconIsNull() {
            addCriterion("user_icon is null");
            return (Criteria) this;
        }

        public Criteria andUserIconIsNotNull() {
            addCriterion("user_icon is not null");
            return (Criteria) this;
        }

        public Criteria andUserIconEqualTo(String value) {
            addCriterion("user_icon =", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotEqualTo(String value) {
            addCriterion("user_icon <>", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconGreaterThan(String value) {
            addCriterion("user_icon >", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconGreaterThanOrEqualTo(String value) {
            addCriterion("user_icon >=", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLessThan(String value) {
            addCriterion("user_icon <", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLessThanOrEqualTo(String value) {
            addCriterion("user_icon <=", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconLike(String value) {
            addCriterion("user_icon like", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotLike(String value) {
            addCriterion("user_icon not like", value, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconIn(List<String> values) {
            addCriterion("user_icon in", values, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotIn(List<String> values) {
            addCriterion("user_icon not in", values, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconBetween(String value1, String value2) {
            addCriterion("user_icon between", value1, value2, "userIcon");
            return (Criteria) this;
        }

        public Criteria andUserIconNotBetween(String value1, String value2) {
            addCriterion("user_icon not between", value1, value2, "userIcon");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyIsNull() {
            addCriterion("user_sort_key is null");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyIsNotNull() {
            addCriterion("user_sort_key is not null");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyEqualTo(Integer value) {
            addCriterion("user_sort_key =", value, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyNotEqualTo(Integer value) {
            addCriterion("user_sort_key <>", value, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyGreaterThan(Integer value) {
            addCriterion("user_sort_key >", value, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_sort_key >=", value, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyLessThan(Integer value) {
            addCriterion("user_sort_key <", value, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyLessThanOrEqualTo(Integer value) {
            addCriterion("user_sort_key <=", value, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyIn(List<Integer> values) {
            addCriterion("user_sort_key in", values, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyNotIn(List<Integer> values) {
            addCriterion("user_sort_key not in", values, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyBetween(Integer value1, Integer value2) {
            addCriterion("user_sort_key between", value1, value2, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andUserSortKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("user_sort_key not between", value1, value2, "userSortKey");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementIsNull() {
            addCriterion("is_agree_agreement is null");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementIsNotNull() {
            addCriterion("is_agree_agreement is not null");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementEqualTo(String value) {
            addCriterion("is_agree_agreement =", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementNotEqualTo(String value) {
            addCriterion("is_agree_agreement <>", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementGreaterThan(String value) {
            addCriterion("is_agree_agreement >", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementGreaterThanOrEqualTo(String value) {
            addCriterion("is_agree_agreement >=", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementLessThan(String value) {
            addCriterion("is_agree_agreement <", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementLessThanOrEqualTo(String value) {
            addCriterion("is_agree_agreement <=", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementLike(String value) {
            addCriterion("is_agree_agreement like", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementNotLike(String value) {
            addCriterion("is_agree_agreement not like", value, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementIn(List<String> values) {
            addCriterion("is_agree_agreement in", values, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementNotIn(List<String> values) {
            addCriterion("is_agree_agreement not in", values, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementBetween(String value1, String value2) {
            addCriterion("is_agree_agreement between", value1, value2, "isAgreeAgreement");
            return (Criteria) this;
        }

        public Criteria andIsAgreeAgreementNotBetween(String value1, String value2) {
            addCriterion("is_agree_agreement not between", value1, value2, "isAgreeAgreement");
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