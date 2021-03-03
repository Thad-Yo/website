package com.website.mybatis.bean.auto.system;

import com.website.mybatis.bean.BaseBean;
import java.io.Serializable;

public class CMUserCustom extends BaseBean implements Serializable {
    private String id;

    private String userId;

    private String customType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType == null ? null : customType.trim();
    }
}