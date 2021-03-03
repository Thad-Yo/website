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
    <tiles:putAttribute name="pageTitle" value="员工管理"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-3 pr5">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content">
                            <div class="ibox-title" style="border-top:none;">
                                <h5>员工信息</h5>

                                <div class="ibox-tools">
                                    <button type="button" class="btn btn-danger btn-xs fn-refresh">刷新</button>
                                    <button type="button" class="btn btn-info btn-xs fn-expandAllBtn">展开</button>
                                    <button type="button" class="btn btn-warning btn-xs fn-collapseAllBtn">收起</button>
                                </div>
                            </div>
                            <div class="hr-line-dashed mt0 mb10"></div>
                            <input type="text" class="form-control input-sm underline margin-bottom-10" value="" id="tree_search" placeholder="Search">
                            <div id="menuTree" style="height:calc(100% - 135px);overflow-y:auto;"></div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-9 pl5">
                    <div class="ibox m0 mt10">
                        <div class="ibox-content mb10 search-panel">
                            <form class="form-inline m0 ">
                                <div class="pl10 pb10 form-group ">
                                    <label class="control-label">真实姓名：</label>
                                    <input type="text" id="realName" name="realName" value="" class="input form-control" placeholder="请输入真实姓名">
                                </div>
                                 <div class="pl10 pb10 form-group ">
                                    <label class="control-label">用户名：</label>
                                    <input type="text" id="userName" name="userName" value="" class="input form-control" placeholder="请输用户名">
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">手机号码：</label>
                                    <input type="text" id="mobileNumber" name="mobileNumber" value="" class="input form-control" placeholder="请输入手机号码">
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">角色：</label>
                                    <input type="text" id="roleName" name="roleName" value="" class="input form-control" placeholder="请输入角色">
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <button type="button" class="btn btn-danger btn-sm fn-search"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询</button>
                                    <button type="button" class="btn btn-info btn-sm fn-add ml10"><i class="fa fa-plus" aria-hidden="true"></i>&nbsp;添加</button>
                                </div>
                            </form>
                        </div>
                        <div class="ibox-content">
                            <table id="listTable" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-field="id" data-formatter="Common.indexFormat" data-align="center" data-width="50">序号</th>
                                    <th data-field="userName" data-align="left" data-sortable="true" data-width="180">用户名</th>
                                    <th data-field="realName" data-align="left" data-sortable="true"  data-width="100">姓名</th>
                                    <th data-field="mobileNumber" data-align="center" data-sortable="true" data-width="100">手机号</th>
                                    <th data-field="extensionNumber" data-align="left" data-sortable="true" data-width="120">固话</th>
                                    <th data-field="departmentName" data-align="left" data-sortable="true">所属部门</th>
                                    <th data-field="roleName" data-align="center"  data-sortable="true" data-width="100">角色</th>
                                    <th data-field="action" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents" data-align="center" data-width="110">操作</th>
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
        <link href="${webRoot}/css/plugins/jsTree/style.min.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/jsTree/jstree.min.js"></script>
        <script type='text/javascript' src="${webRoot}/jsp/system/maintenance/adminuser/adminuser_list.js"></script>
    </tiles:putAttribute>

</tiles:insertTemplate>


