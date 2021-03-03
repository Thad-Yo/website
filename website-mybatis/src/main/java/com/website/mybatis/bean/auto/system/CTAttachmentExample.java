package com.website.mybatis.bean.auto.system;

import java.util.ArrayList;
import java.util.List;

public class CTAttachmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CTAttachmentExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("file_id is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("file_id is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(String value) {
            addCriterion("file_id =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(String value) {
            addCriterion("file_id <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(String value) {
            addCriterion("file_id >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("file_id >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(String value) {
            addCriterion("file_id <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(String value) {
            addCriterion("file_id <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLike(String value) {
            addCriterion("file_id like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotLike(String value) {
            addCriterion("file_id not like", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<String> values) {
            addCriterion("file_id in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<String> values) {
            addCriterion("file_id not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(String value1, String value2) {
            addCriterion("file_id between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(String value1, String value2) {
            addCriterion("file_id not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andFileOrderIsNull() {
            addCriterion("file_order is null");
            return (Criteria) this;
        }

        public Criteria andFileOrderIsNotNull() {
            addCriterion("file_order is not null");
            return (Criteria) this;
        }

        public Criteria andFileOrderEqualTo(Integer value) {
            addCriterion("file_order =", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderNotEqualTo(Integer value) {
            addCriterion("file_order <>", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderGreaterThan(Integer value) {
            addCriterion("file_order >", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_order >=", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderLessThan(Integer value) {
            addCriterion("file_order <", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderLessThanOrEqualTo(Integer value) {
            addCriterion("file_order <=", value, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderIn(List<Integer> values) {
            addCriterion("file_order in", values, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderNotIn(List<Integer> values) {
            addCriterion("file_order not in", values, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderBetween(Integer value1, Integer value2) {
            addCriterion("file_order between", value1, value2, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("file_order not between", value1, value2, "fileOrder");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNull() {
            addCriterion("att_type is null");
            return (Criteria) this;
        }

        public Criteria andAttTypeIsNotNull() {
            addCriterion("att_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttTypeEqualTo(String value) {
            addCriterion("att_type =", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotEqualTo(String value) {
            addCriterion("att_type <>", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThan(String value) {
            addCriterion("att_type >", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeGreaterThanOrEqualTo(String value) {
            addCriterion("att_type >=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThan(String value) {
            addCriterion("att_type <", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLessThanOrEqualTo(String value) {
            addCriterion("att_type <=", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeLike(String value) {
            addCriterion("att_type like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotLike(String value) {
            addCriterion("att_type not like", value, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeIn(List<String> values) {
            addCriterion("att_type in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotIn(List<String> values) {
            addCriterion("att_type not in", values, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeBetween(String value1, String value2) {
            addCriterion("att_type between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andAttTypeNotBetween(String value1, String value2) {
            addCriterion("att_type not between", value1, value2, "attType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNull() {
            addCriterion("extension is null");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNotNull() {
            addCriterion("extension is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionEqualTo(String value) {
            addCriterion("extension =", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotEqualTo(String value) {
            addCriterion("extension <>", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThan(String value) {
            addCriterion("extension >", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThanOrEqualTo(String value) {
            addCriterion("extension >=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThan(String value) {
            addCriterion("extension <", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThanOrEqualTo(String value) {
            addCriterion("extension <=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLike(String value) {
            addCriterion("extension like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotLike(String value) {
            addCriterion("extension not like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionIn(List<String> values) {
            addCriterion("extension in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotIn(List<String> values) {
            addCriterion("extension not in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionBetween(String value1, String value2) {
            addCriterion("extension between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotBetween(String value1, String value2) {
            addCriterion("extension not between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andSavePathIsNull() {
            addCriterion("save_path is null");
            return (Criteria) this;
        }

        public Criteria andSavePathIsNotNull() {
            addCriterion("save_path is not null");
            return (Criteria) this;
        }

        public Criteria andSavePathEqualTo(String value) {
            addCriterion("save_path =", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotEqualTo(String value) {
            addCriterion("save_path <>", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathGreaterThan(String value) {
            addCriterion("save_path >", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathGreaterThanOrEqualTo(String value) {
            addCriterion("save_path >=", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLessThan(String value) {
            addCriterion("save_path <", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLessThanOrEqualTo(String value) {
            addCriterion("save_path <=", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathLike(String value) {
            addCriterion("save_path like", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotLike(String value) {
            addCriterion("save_path not like", value, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathIn(List<String> values) {
            addCriterion("save_path in", values, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotIn(List<String> values) {
            addCriterion("save_path not in", values, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathBetween(String value1, String value2) {
            addCriterion("save_path between", value1, value2, "savePath");
            return (Criteria) this;
        }

        public Criteria andSavePathNotBetween(String value1, String value2) {
            addCriterion("save_path not between", value1, value2, "savePath");
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