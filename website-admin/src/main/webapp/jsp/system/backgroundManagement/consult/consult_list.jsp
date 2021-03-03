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
    <tiles:putAttribute name="pageTitle" value="订单类型配置"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content mb10 search-panel">
                            <form class="form-inline m0 ">
                            <button type="button" class="btn btn-danger btn-sm fn-search"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询</button>
                            </form>
                        </div>
                        <div class="ibox-content">
                            <table id="listTable" data-height="505" data-mobile-responsive="true"
                             style="width: 100%; table-layout: fixed;word-break: break-all; word-wrap: break-word;" data-sort-name="creat_date" data-height="100%" data-sort-order="desc">
                                <thead>
                                <tr>
                                    <th data-align="center" data-width="50px" data-field="number" data-formatter="Common.indexFormat">序号</th>
                                    <th data-align="center" data-width="100px" data-field="name" data-sortable="false">联系人</th>
                                    <th data-align="center" data-width="100px" data-field="tel" data-sortable="false" >联系电话</th>
                                    <th data-align="center" data-width="250px" data-field="company" data-sortable="false" >公司名称</th>
                                    <th data-align="center" data-width="250px" data-field="debtorName">债务公司名称</th>
                                    <th data-align="center" data-width="100px" data-field="debtorCountry">所在国家</th>
                                    <th data-align="center" data-width="150px" data-field="amount">币种和金额</th>
                                    <th data-align="center" data-width="150px" data-field="consultTime">咨询时间</th>
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
        <jsp:include page="consult_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


