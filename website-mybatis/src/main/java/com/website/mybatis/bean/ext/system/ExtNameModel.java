package com.website.mybatis.bean.ext.system;


import com.website.mybatis.bean.BaseBean;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class ExtNameModel extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String nameClass;

    private String nameCd;

    private String name;

    private String sortKey;

    private String data;

    private String reserve01;

    private String reserve02;

    private String reserve03;

    private String notes;

    private String delFlag;

    private String createUserCd;

    private String createGroupCd;

    private String createDate;

    private String updateUserCd;

    private String updateGroupCd;

    private String updateDate;

    private List<String> nameCdList;
}