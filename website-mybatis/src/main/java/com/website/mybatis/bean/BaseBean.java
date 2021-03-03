package com.website.mybatis.bean;


import java.io.Serializable;

/**
 * @author GOGTZ-Z
 * @version V1.0  
 * @package com.hyjf.admin.maintenance.AdminPermissions;
 * @date 2015/07/09 17:00
 */
public class BaseBean implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 387630498860089653L;

    /**
     * 关键字
     */
    private String search;

    /**
     * id列表
     */
    private String ids;

    private int limitStart = -1;

    private int limitEnd = -1;

    private String orderByClause;

    private String sortByClause;

    private String sts;

    private String sort;

    private String order;

    private String offset;

    private String limit;

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(int limitStart) {
        this.limitStart = limitStart;
    }

    public int getLimitEnd() {
        return limitEnd;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd = limitEnd;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getSortByClause() {
        return sortByClause;
    }

    public void setSortByClause(String sortByClause) {
        this.sortByClause = sortByClause;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
