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
    <tiles:putAttribute name="pageTitle" value="岗位大类"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content mb10 search-panel">
                            <form class="form-inline m0 ">
                            	<div class="pl10 pb10 form-group">
                                    <label class="control-label"></label>
                                    <div class="input-group" style="width: 200px;">
                                    </div>
                                </div>
                                <div class="pl10 pb10 pull-right">
                                    <shiro:hasPermission name="configPosition:NEW">
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
                                    <th data-align="center" data-width="200px" data-field="positionName" data-sortable="false">岗位大类</th>
                                    <th data-align="center" data-width="200px" data-field="matchingPosition" data-sortable="false">适用岗位</th>
                                    <th data-align="center" data-width="200px" data-field="positionIntroduce" data-sortable="false">类别说明</th>
                                    <th data-align="center" data-width="65px" data-field="updateTime">操作时间</th>
                                    <th data-align="center" data-width="80px" data-field="updateUser">操作人</th>
                                    <th data-align="center" data-width="100px" data-field="action" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents">操作</th>
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
        <jsp:include page="configPosition_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


