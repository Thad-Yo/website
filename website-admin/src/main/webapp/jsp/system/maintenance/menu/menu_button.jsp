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
            <div class="row" style="padding-top:5px;">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <form id="mainForm">
                            <input type="hidden" name="parentMenuId" value="">
                            <input type="hidden" name="menuId" value="">
                            <div class="form-group">
                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center">权限名称</th>
                                            <th style="text-align: center">权限标识</th>
                                            <th style="text-align: center; width: 75px;">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="permissionTable">
                                        <tr>
                                            <td>
                                                <input name="permissionName" class="form-control" type="text" readonly="readonly" value="查看"></td>
                                            <td>
                                                <input name="permission" class="form-control" type="text" readonly="readonly" value="VIEW">
                                            </td>
                                            <td style="text-align: center">
                                                <button type="button" title="添加" class="btn btn-warning btn-xs fn-addRow">加</button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="form-group" style="text-align: center">
                                <button class="btn btn-danger fn-submit" type="button">确认</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- 列表的行模板 -->
        <table id="rowTemplts" type="text/x-tmpl" style="display:none">
            <tr>
                <td>
                    <input name="permissionName" class="form-control" type="text" maxlength="15" value="">
                </td>
                <td>
                    <input name="permission" class="form-control" type="text" maxlength="15"  value="">
                </td>
                <td style="text-align: center">
                    <button type="button" title="添加" class="btn btn-warning btn-xs fn-addRow">加</button>
                    <button type="button" title="删除" class="btn btn-danger btn-xs fn-removeRow">删</button>
                </td>
            </tr>
        </table>
        <!-- End Panel Other -->
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">

    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <script type='text/javascript' src="${webRoot}/jsp/system/maintenance/menu/menu_button.js"></script>
    </tiles:putAttribute>

</tiles:insertTemplate>


