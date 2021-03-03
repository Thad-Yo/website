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
                        <!-- 搜索条件 -->
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
                                    <label class="control-label">英文：</label>
                                    <div class="input-group" style="width: 200px;">
                                    	<select id=hasEn name="hasEn" class="form-control">
                                    		<option value="">请选择</option>
                                    		<option value="1">有</option>
                                    		<option value="0">无</option>
                                    	</select>
                                    </div>
                                </div>
                                <div class="pl10 pb10 pull-right">
                                    <div class="pl10 pb10 form-group pull-right">
                                        <button type="button" class="btn btn-danger btn-sm fn-search"><i
                                                class="fa fa-search" aria-hidden="true"></i>&nbsp;查询
                                        </button>
                                        <shiro:hasPermission name="industry:NEW">
                                        <button type="button" class="btn btn-warning btn-sm fn-add"><i
                                                class="fa fa-add" aria-hidden="true"></i>&nbsp;新建
                                        </button>
                                        </shiro:hasPermission>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                   	 <table id="listTable"  class="table" data-height="100%" style="width: 100%; word-break: break-all; word-wrap: break-word;">
                        <thead>
	                        <tr>
	                            <th data-field="index" data-width="20px" data-align="center" data-formatter="Common.indexFormat">序号</th>
	                            <th data-field="imgUrlZh" data-width="60px" data-align="center" data-formatter="ActionEvents.imgFormatter">行业图标</th>
	                            <th data-field="industryNameZh" data-width="100px" data-align="center">行业名称</th>
	                            <th data-field="industryInfoZh" data-width="200px" data-align="center">行业介绍</th>
	                            <th data-field="hasEn" data-width="20px" data-formatter="ActionEvents.issueStatusFormatter" data-align="center">英文</th>
	                            <th data-field="updateDate" data-align="center" data-width="140px" data-formatter="Common.dateFormatYMDHMS">编辑日期</th>
	                            <th data-field="updateUserName" data-width="40px" data-align="center">操作人</th>
	                            <th data-field="action" data-width="60px" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents" data-align="center">操作</th>
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
        <jsp:include page="industry_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>
