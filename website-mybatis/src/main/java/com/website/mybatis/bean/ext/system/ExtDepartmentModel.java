package com.website.mybatis.bean.ext.system;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ExtDepartmentModel extends BaseBean implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String departmentCd;

    private String departmentName;

    private String departmentPCd;

    private String status;

    private Integer sortKey;

    private String departmentIconUrl;

    private String delFlag;

    private String areas;

    private String savePath;

    private String userCnt;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }


    public String getUserCnt() {
        return userCnt;
    }

    public void setUserCnt(String userCnt) {
        this.userCnt = userCnt;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getDepartmentIconUrl() {
        return departmentIconUrl;
    }

    public void setDepartmentIconUrl(String departmentIconUrl) {
        this.departmentIconUrl = departmentIconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentCd() {
        return departmentCd;
    }

    public void setDepartmentCd(String departmentCd) {
        this.departmentCd = departmentCd;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentPCd() {
        return departmentPCd;
    }

    public void setDepartmentPCd(String departmentPCd) {
        this.departmentPCd = departmentPCd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortKey() {
        return sortKey;
    }

    public void setSortKey(Integer sortKey) {
        this.sortKey = sortKey;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
