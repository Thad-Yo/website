package com.website.app.base;

public interface BaseDefine {

	/** 登录画面初始化 @RequestMapping值 */
	String INIT = "init";

	/** 删除后跳转的画面 */
	String DELETE_AFTER_PATH = "redirect:init";

	/** 画面值 */
	String FORM = "form";

	/** 画面值 */
	String RECORD = "record";

	/** 画面返回结果集 */
	String RECORD_LIST = "recordList";

	/** 画面返回结果集(行业列表) */
	String INDUSTRY_LIST = "industryList";

	/** 画面返回结果集(职位列表) */
	String POSITION_LIST = "positionList";

	/** 画面返回结果集(管理员列表) */
	String ADMIN_USER_LIST = "adminUserList";

	/** 画面返回结果集(合作机构列表) */
	String COOP_USER_LIST = "coopUserList";

	/** 列表中的按钮 */
	String RECORD_LIST_BUTTON = "recordListButton";

	/** 画面返回分页 */
	String PAGINATOR = "paginator";

	/** 画面值 */
	String FORM_ACTION = "formAction";

	/** 是否是更新功能 */
	String IS_EDIT = "IS_EDIT";

	/** 返回json的编码格式*/
	String JSON_UTF8 = "text/html;charset=UTF-8";

	/**
	 * ValidateForm请求返回值Key
	 */
	public static final String JSON_VALID_STATUS_KEY = "status";
	/**
	 * ValidateForm请求返回值正常
	 */
	public static final String JSON_VALID_INFO_KEY = "info";
	/**
	 * ValidateForm请求返回值正常
	 */
	public static final String JSON_VALID_STATUS_OK = "y";
	/**
	 * JSON : JSON文件的ContendType类型
	 */
	public static final String JSON = "application/json;charset=UTF-8";

}
