<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertTemplate template="/jsp/layout/mainLayout.jsp" flush="true">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="菜单管理"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>菜单列表</h5>
                            <div class="ibox-tools">
                                <button type="button" class="btn btn-danger btn-xs fn-refresh">刷新</button>
                                <button type="button" class="btn btn-info btn-xs fn-expandAllBtn">展开</button>
                                <button type="button" class="btn btn-warning btn-xs fn-collapseAllBtn">收起</button>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div id="menuTree" style="height:calc(100% - 95px);overflow-y:auto;"></div>
                        </div>
                    </div>
                </div>
                <div id="menuInfo" class="col-sm-8" style="display: none;" >
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>菜单维护</h5>
                        </div>
                        <div class="ibox-content">
                            <form class="form-horizontal registerform" id="mainForm">
                                <input type="hidden" id="parentMenuId" name="parentMenuId" value="">
                                <input type="hidden" id="menuId" name="menuId" value="">
                                <input type="hidden" name="menuPermissionJson" id="menuPermissionJson" value=''>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">父级菜单：</label>
                                    <div class="col-sm-8">
                                        <input id="parentMenuName" class="form-control" type="text" readonly="readonly">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">菜单名称：</label>
                                    <div class="col-sm-8">
                                        <input id="menuName" name="menuName" class="form-control" type="text" value="" maxlength="100" datatype="s1-100" errormsg="请输入至少1个字符,最多100个字符！" />
                                        <div class="Validform_checktip">请输入至少1个字符,最多100个字符！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">菜单图标：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i id="menuIconMark" class="fa fa-list-ul"></i></span>
                                            <input id="menuIcon" name="menuIcon" class="form-control" type="text" value="" onblur="Events.changeMenuIcon(this);">
                                        </div>
                                        <div class="Validform_checktip">请输入符合格式的图标的CSS样式！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">菜单链接：</label>
                                    <div class="col-sm-8">
                                        <input id="menuUrl" name="menuUrl" class="form-control" type="text" value="" ignore="ignore" datatype="*0-500" errormsg="最多输入500个字符！"/>
                                        <div class="Validform_checktip">最多输入500位字符！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">菜单权限：</label>
                                    <div class="col-sm-8">
                                        <input id="menuControllor" name="menuControllor" class="form-control" type="text" value="" ignore="ignore" datatype="menuControllor" errormsg="由1-100位的字母和下划线组成！"/>
                                        <div class="Validform_checktip">由1-100位的字母和下划线组成！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">菜单顺序：</label>
                                    <div class="col-sm-8">
                                        <input id="sort" name="sort" class="form-control" type="text" value="" maxlength="5" ignore="ignore" datatype="n0-5" errormsg="只能输入数字，最多输入5位字符！"/>
                                        <div class="Validform_checktip">只能输入数字，最多输入5位字符！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">按钮权限：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <span class="input-group-btn">
                                                <button type="button" class="btn btn-primary fn-AddButton">维护</button>
                                            </span>
                                            <input type="text" id="menuBtns" class="form-control" value="" readonly="readonly">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">删除状态：</label>
                                    <div class="col-sm-8">
                                        <div class="checkbox i-checks">
                                            <label style="padding-left:0px;"><input type="checkbox" value="1" name="delFlag" id="delFlag"> <i></i> 选中为删除</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-8 col-sm-offset-3">
                                        <button class="btn btn-danger fn-add" type="button">提交</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Panel Other -->
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link href="${webRoot}/css/plugins/iCheck/skins/square/red.css" rel="stylesheet">
        <link href="${webRoot}/css/plugins/jsTree/style.min.css" rel="stylesheet">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">

    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/jsTree/jstree.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <script type='text/javascript' src="${webRoot}/jsp/system/maintenance/menu/menu_list.js"></script>
    </tiles:putAttribute>

</tiles:insertTemplate>


