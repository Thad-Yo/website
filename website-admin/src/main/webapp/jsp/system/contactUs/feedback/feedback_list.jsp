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
    <tiles:putAttribute name="pageTitle" value="意见反馈"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content mb10 search-panel">
                            <form id="searchForm" class="form-inline m0 ">
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">反馈时间：</label>
                                    <input type="text" name="feedbackTime" id="feedbackTime" class="input-sm form-control" value="" >
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">电话</label>
                                    <div class="input-group" style="width: 200px;">
                                        <input type="text" class="form-control" id="tel" name="tel" value="" placeholder="请输入电话号码">
                                    </div>
                                </div>
                                <div class="pl10 pb10 pull-right">
                                    <shiro:hasPermission name="feedback:VIEW">
                                        <button type="button" class="btn btn-danger btn-sm fn-search"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询</button>
                                    </shiro:hasPermission>
                                        <button type="button" class="btn btn-info btn-sm fn-clear"><i class="fa fn-clear" aria-hidden="true"></i>&nbsp;清空</button>
                                    <shiro:hasPermission name="feedback:EXPORT">
                                        <button type="button" class="btn btn-info btn-sm fn-export"><i class="fa fn-export" aria-hidden="true"></i>&nbsp;导出</button>
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
                                    <th data-align="center" data-width="200px" data-field="feedbackTime" data-sortable="false">反馈时间</th>
                                    <th data-align="center" data-width="200px" data-field="feedbackIp" data-sortable="false">反馈IP地址</th>
                                    <th data-align="center" data-width="65px" data-field="name" data-sortable="false">姓名</th>
                                    <th data-align="center" data-width="50px" data-field="tel" >电话</th>
                                    <th data-align="center" data-width="65px" data-field="mailbox">邮箱</th>
                                    <th data-align="center" data-width="80px" data-field="content">反馈内容</th>
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
        <jsp:include page="feedback_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


