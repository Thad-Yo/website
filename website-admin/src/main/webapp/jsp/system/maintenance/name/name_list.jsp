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
    <tiles:putAttribute name="pageTitle" value="数据字典"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content mb10 search-panel">
                            <form class="form-inline m0 ">
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">名称区分：</label>
                                    <input type="text" id="nameClass" name="nameClass" value=""
                                           class="input form-control" placeholder="请输入名称区分">
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <button type="button" class="btn btn-danger btn-sm fn-search"><i
                                            class="fa fa-search" aria-hidden="true"></i>&nbsp;查询
                                    </button>
                                    <shiro:hasPermission name="sys_name:ADD">
                                    <button type="button" class="btn btn-info btn-sm fn-add ml10"><i class="fa fa-plus"
                                                                                                     aria-hidden="true"></i>&nbsp;添加
                                    </button>
                                    </shiro:hasPermission>
                                </div>
                            </form>
                        </div>
                        <div class="ibox-content">
                            <table id="listTable" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-field="id" data-formatter="Common.indexFormat" data-align="center" data-width="50">序号</th>
                                    <th data-field="nameClass" data-align="left" data-width="" data-sortable="true">名称区分</th>
                                    <th data-field="nameCd" data-align="left" data-width="" data-sortable="true"> 名称编号</th>
                                    <th data-field="name" data-align="left" data-width="" data-sortable="true"> 名称</th>
                                    <th data-field="sortKey" data-align="center" data-width="50">排序</th>
                                    <th data-field="action" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents" data-align="center" data-width="80">操作</th>
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
        <jsp:include page="name_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


