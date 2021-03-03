<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertTemplate template="/jsp/layout/mainLayout.jsp" flush="true">
    <%@ include file="/jsp/base/pageBase.jsp" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="banner"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                       <div class="ibox-title">
                            <h5>搜索条件</h5> <span class="label label-primary">search</span>
                            <div class="ibox-tools">
                                <a class="collapse-link ui-sortable">
                                    <i class="fa fa-chevron-down"></i>
                                </a>
                            </div>
                        </div>
                       <div class="ibox-content mb10 search-panel">
                            <form id="searchForm" class="form-inline m0 search-content">
                                <div class="pl10 pb10 form-group">
                                            <label class="control-label">分公司名称：</label>
                                            <input type="text" id="filialeName" name="filialeName" value=""
                                                   class="input form-control" placeholder="请输入分公司名称">
                                        </div>
                                <div class="pl10 pb10 form-group">
                                            <label class="control-label">联系电话：</label>
                                            <input type="text" id="tel" name="tel" value=""
                                                   class="input form-control" placeholder="请输入联系电话">
                                        </div>
                                <div class="pl10 pb10 pull-right">
                                    <div class="pl10 pb10 form-group pull-right">
                                        <button type="button" class="btn btn-danger btn-sm fn-search"><i
                                                class="fa fa-search" aria-hidden="true"></i>&nbsp;查询
                                        </button>
                                         <button type="button" class="btn btn-warning btn-sm fn-clear"><i
                                                    class="fa fa-remove" aria-hidden="true"></i>&nbsp;清空
                                            </button>
                                            <shiro:hasPermission name="company:NEW">
                                        <button type="button" class="btn btn-warning btn-sm fn-add"><i
                                                class="fa fa-add" aria-hidden="true"></i>&nbsp;新建
                                        </button>
                                        </shiro:hasPermission>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                   	 <table id="listTable"  class="table" data-height="100%"
                                   style="width: 100%; word-break: break-all; word-wrap: break-word;">
	                    <colgroup>
					      <col width="10%">
					      <col width="15%">
					      <col width="10%">
					      <col width="10%">
					      <col width="10%">
					      <col width="10%">
					      <col width="10%">
					      <col>
					    </colgroup>
                        <thead>
	                        <tr>
	                            <th data-field="devNumber" data-align="center" data-formatter="Common.indexFormat" data-sortable="true">序号</th>
	                            <th data-field="filialeName" data-align="center">分公司名称</th>
	                            <th data-field="tel" data-align="center" data-sortable="true">电话</th>
	                            <th data-field="province" data-align="left" data-sortable="true" >所属省份</th>
	                            <th data-field="action" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents" data-align="center">操作</th>
	                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
        <!-- End Panel Other -->
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <style>
            .search-content {
                display: none;
            }
            #listTable{background:white;}
        </style>
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <jsp:include page="filiale_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>
