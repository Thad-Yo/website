package com.website.app.base;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.serializer.PropertyFilter;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.date.DateFormat;
import com.website.common.util.date.DateUtils;
import com.website.common.util.string.GetterUtil;

public class BaseController {


    /**
     * 初始化数据绑定
     * <ol><li>将所有传递进来的String进行HTML编码，防止XSS攻击</li>
     * <li>将字段中Date类型转换为String类型</li></ol>
     * <p>@InitBinder 和 WebDataBinder 可以参考：https://segmentfault.com/a/1190000007013461</p>
     *
     * @param binder WebDataBinder
     */
    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(null == text ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return null != value ? value.toString() : StringUtils.EMPTY;
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateFormat.stringToDate(text));
            }
        });
        // Integer 类型转换
        binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (StringUtils.isEmpty(text)) {
                    setValue(null);
                } else {
                    setValue(text);
                }
            }
        });
    }


    /**
     * 去掉不用的字段
     */
    protected PropertyFilter getProfilter(String... param) {
        final List<String> filterList = new ArrayList<String>();
        filterList.add("createGroupCd");
        filterList.add("createUserCd");
        filterList.add("delFlag");
        filterList.add("updateDate");
        filterList.add("updateGroupCd");
        filterList.add("updateUserCd");
        filterList.add("limitStart");
        filterList.add("limitEnd");
        if (param != null && param.length > 0) {
            Collections.addAll(filterList, param);
        }

        PropertyFilter profilter = new PropertyFilter() {
            @Override
            public boolean apply(Object object, String name, Object value) {
                if (filterList.contains(name)) {
                    //false表示last字段将被排除在外
                    return false;
                }
                return true;
            }
        };
        return profilter;
    }


}
