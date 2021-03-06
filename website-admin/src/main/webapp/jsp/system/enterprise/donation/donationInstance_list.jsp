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
    <tiles:putAttribute name="pageTitle" value="捐赠纪实"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content mb10 search-panel">
                            <form class="form-inline m0 ">
                            	<div class="pl10 pb10 form-group">
                                    <label class="control-label">标题</label>
                                    <div class="input-group" style="width: 200px;">
                                        <input type="text" class="form-control" id="newsTitle" name="newsTitle" value="" placeholder="请输入标题名称">
                                    </div>
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">发布时间：</label>
                                    <input type="text" name="donationTime" id="donationTime" class="input-sm form-control" value="" >
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">英文</label>
                                    <div class="input-group" style="width: 200px;">
                                        <select id="hasEnFlag" name="hasEnFlag" class="form-control">
                                            <option value="">全部</option>
                                            <option value="1">有</option>
                                            <option value="0">无</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="pl10 pb10 pull-right">
                                    <shiro:hasPermission name="donation:VIEW">
                                        <button type="button" class="btn btn-danger btn-sm fn-search"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询</button>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="donation:ADD">
                                        <button type="button" class="btn btn-info btn-sm fn-add"><i class="fa fa-add" aria-hidden="true"></i>&nbsp;添加</button>
                                    </shiro:hasPermission>
                                </div>
                            </form>
                        </div>
                        <div class="ibox-content">
                            <table id="listTable" data-height="505" data-mobile-responsive="true"
                             style="width: 100%; table-layout: fixed;word-break: break-all; word-wrap: break-word;" data-sort-name="creat_date" data-height="100%" data-sort-order="desc">
                                <thead>
                                <tr>
                                    <th data-align="center" data-width="50px" data-field="number" data-formatter="Common.indexFormat">序号</th>
                                    <th data-align="center" data-width="200px" data-field="coverPageUrl" data-sortable="false" data-formatter="ActionEvents.imgFormatter">捐赠图片</th>
                                    <th data-align="center" data-width="200px" data-field="newsTitle" data-sortable="false">标题</th>
                                    <th data-align="center" data-width="65px" data-field="donationTime" data-sortable="false">捐赠时间</th>
                                    <th data-align="center" data-width="50px" data-field="hasEnFlag" data-sortable="false" data-formatter="ActionEvents.hasEnAction">英文</th>
                                    <th data-align="center" data-width="65px" data-field="updateTime">编辑日期</th>
                                    <th data-align="center" data-width="80px" data-field="updateUser">操作人</th>
                                    <th data-align="center" data-width="200px" data-field="action" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents">操作
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
    <link href="${webRoot}/js/plugins/laydate/theme/laydate.css" rel="stylesheet">	
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
    <script type="text/javascript" src="${webRoot}/js/plugins/laydate/laydate.js"></script>
        <jsp:include page="donationInstance_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


