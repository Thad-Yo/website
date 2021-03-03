package com.website.mybatis.bean.ext;


import java.io.Serializable;
import java.util.List;

import com.website.mybatis.bean.BaseBean;
import com.website.mybatis.bean.auto.HrConfigPosition;

import lombok.Data;

@Data
public class ExtConfig extends BaseBean implements Serializable {
    private List<HrConfigPosition> result;
    private String success;

}