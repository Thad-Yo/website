/*
 * Copyright 2015-2016 the original author or authors..
 *
 * Licensed under the 青岛高软盛信息技术有限公司 License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.gogtz.com/licenses/LICENSE-1.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.website.common.util.constants;

/**
 * <p>
 * 共通常量文件
 * </p>
 *
 * @author GOGTZ-T
 * @version 0.0.0
 * @since 1.0
 */
public class ConstantsUtil {
    /**
     * 用户信息
     */
    public static final String LOGIN_USER_INFO = "LOGIN_USER_INFO";
    public static final String LOGIN_USER_MANAGE_DEPARTMENT = "LOGIN_USER_MANAGE_DEPARTMENT";
    public static final String LOGIN_USER_RESOURCE = "LOGIN_USER_RESOURCE";
    /**
     * 微信保留的用户信息
     */
    public static final String WECHAR_USER_INFO = "WECHAR_USER_INFO";
    /**
     * 用户信息
     */
    public static final String MAIN_MENU_TREE = "MAIN_MENU_TREE";
    /**
     * 后台验证有错误，防止二次提交用
     */
    public static final String FORM_HAS_ERROR = "FORM_HAS_ERROR";
    /**
     * 菜单KEY
     */
    public static final String FUNCTION_ID = "fid";
    /**
     * 用户菜单的权限
     */
    public static final String VIEW = "VIEW";
    /**
     * 树的顶级菜单的编号
     */
    public static final String TREE_TOP = "00000000-0000-0000-0000-000000000000";
    
    /**
     * 树的顶级菜单的编号
     */
    public static final String DEPARTMENT_TOP = "00000000-0000-0000-0000-000000000000";

    /**
     * ajax调用返回KEY
     */
    public static final String AJAX_RESULT_KEY = "success";
    /**
     * ajax调用成功
     */
    public static final String AJAX_RESULT_SUCCESS_VALUE = "0";
    /**
     * ajax调用失败
     */
    public static final String AJAX_RESULT_FINAL_VALUE = "1";

    /**
     * Flag删除
     */
    public static final String FLG_DELETE = "1";
    /**
     * Flag正常
     */
    public static final String FLG_NORMAL = "0";

    /**
     * LIMIT
     */
    public static final int LIMIT_MINUS_ONE = -1;

    /**
     * 文件类型
     */
    public static final String FILE_XLS = "xls";

    /**
     * 文件类型
     */
    public static final String FILE_XLSX = "xlsx";
    
    /**
     * 文件类型
     */
    public static final String FILE_APK = "apk";
    /**
     * 用户信息
     */
    public static final String ADMIN = "admin";

    public static String SPLIT_MARK = "$$$$$$";

    /**
     * 首页顶部搜索栏默认提示信息
     */
    public static final String INDEX_SEARCH_TIP = "index_search_tip";

    // 权限名
    public static final String ROLE_ADMIN = "admin";    // 系统管理员
    // 附件类型：合作伙伴
    public static final String CTATTACHMENT_TYPE_3 = "3";  

    /**
     * Flag是
     */
    public static final String FLG_YES = "1";
    /**
     * Flag否
     */
    public static final String FLG_NO = "0";
    /**
     * 我们的文化 类型
     */
    public static final String CULTURE_STAFF="1";
    public static final String CULTURE_ART="2";
}
