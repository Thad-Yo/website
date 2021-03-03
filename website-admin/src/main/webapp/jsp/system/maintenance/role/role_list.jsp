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
    <tiles:putAttribute name="pageTitle" value="角色管理"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content mb10 search-panel">
                            <form class="form-inline m0 ">
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">角色编码：</label>
                                    <div class="input-group" style="width: 200px;">
                                        <input type="text" class="form-control" id="role" name="role" placeholder="请输入角色编码">
                                        <!-- /btn-group -->
                                    </div>
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">角色名称：</label>
                                    <div class="input-group" style="width: 200px;">
                                        <input type="text" class="form-control" id="roleName" name="roleName" placeholder="请输入角色名称">
                                    </div>
                                </div>
                                <div class="pl10 pb10 pull-right">
                                    <shiro:hasPermission name="sys_role:VIEW">
                                    <button type="button" class="btn btn-danger btn-sm fn-search"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询</button>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="sys_role:ADD">
                                    <button type="button" class="btn btn-info btn-sm fn-add ml10"><i class="fa fa-add" aria-hidden="true"></i>&nbsp;添加</button>
                                    </shiro:hasPermission>
                                </div>
                            </form>
                        </div>
                        <div class="ibox-content">
                            <table id="listTable" data-height="505" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-align="center" data-width="50px" data-field="id" data-formatter="Common.indexFormat">序号</th>
                                    <th data-align="left" data-width="150px" data-field="role" data-sortable="true">角色编码</th>
                                    <th data-align="left" data-width="150px" data-field="roleName" data-sortable="true" data-sort="role_name">角色名称</th>
                                    <th data-align="left" data-field="note" data-sortable="true">角色说明</th>
                                    <th data-align="center" data-width="120px" data-field="action" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents">操作
                                    </th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" id="delFlag" name="delFlag" value=""/>
        </div>
        <!-- End Panel Other -->
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <jsp:include page="role_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


