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
            <div class="row">
                <div class="col-sm-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>部门信息</h5>
                            <div class="ibox-tools">
                                <button type="button" class="btn btn-danger btn-xs fn-refresh">刷新</button>
                                <button type="button" class="btn btn-info btn-xs fn-expandAllBtn">展开</button>
                                <button type="button" class="btn btn-warning btn-xs fn-collapseAllBtn">收起</button>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <input type="text" class="form-control input-sm underline margin-bottom-10" value=""
                                   id="tree_search" placeholder="Search">
                            <div id="menuTree" style="height:calc(100% - 95px);overflow-y:auto;"></div>
                        </div>
                    </div>
                </div>
                <div id="departmentInfo" class="col-sm-8" style="display: none;">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>部门维护</h5>
                        </div>
                        <div class="ibox-content">
                            <form class="form-horizontal m-t registerform" id="mainForm">
                                <input type="hidden" id="departmentPCd" name="departmentPCd" value="">
                                <input type="hidden" id="departmentCd" name="departmentCd" value="">
                                <input type="hidden" id="nowDepartmentCd" name="nowDepartmentCd" value="${nowDepartmentCd}">
                                <input type="hidden" id="id" name="id" value="">
                                <input type="hidden" id="areas" name="areas" value="">
                                <div class="form-group" style="display: none;">
                                    <label class="col-sm-2 control-label">部门编号：</label>
                                    <div class="col-sm-8">
                                        <input id="departmentCdDisplay" class="form-control" type="text"
                                               readonly="readonly">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">父级部门：</label>
                                    <div class="col-sm-8">
                                        <input id="departmentPName" class="form-control" type="text"
                                               readonly="readonly">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">部门名称：</label>
                                    <div class="col-sm-8">
                                        <input id="departmentName" name="departmentName" class="form-control"
                                               type="text" value="" maxlength="20" datatype="s1-20"
                                               errormsg="请输入至少1个字符,最多20个字符！"/>
                                        <div class="Validform_checktip">请输入至少1个字符,最多20个字符！</div>
                                    </div>
                                </div>
                                <div id="positionDiv">

                                </div>
                                
                                <div class="form-group">
	                                <label class="col-sm-2 control-label">分公司IP：</label>
	                                <div class="col-sm-8">
	                                    <input id="departmentIp" name="departmentIp" class="form-control" ignore="ignore"
	                                           type="text" value="" maxlength="30" datatype="s1-30"
	                                           errormsg="请输入至少1个字符,最多30个字符！"/>
	                                    <div class="Validform_checktip">请输入至少1个字符,最多30个字符！</div>
	                                </div>
                               	</div>
                               	<div class="form-group">
	                                <label class="col-sm-2 control-label">部门排序：</label>
	                                <div class="col-sm-8">
	                                    <input id="sortKey" name="sortKey" class="form-control" ignore="ignore"
	                                           type="text" value="" maxlength="3" datatype="n"
	                                           errormsg="请输入3位及以下的正整数！"/>
	                                    <div class="Validform_checktip">请输入3位及以下的正整数！</div>
	                                </div>
                               	</div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">删除状态：</label>
                                    <div class="col-sm-8">
                                        <div class="checkbox i-checks">
                                            <label style="padding-left:0px;">
                                            <input type="checkbox" value="1" name="delFlag" id="delFlag"> <i></i>
                                            	选中为删除
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-8 col-sm-offset-3">
                                        <button class="btn btn-danger fn-add" type="button">提交</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Panel Other -->
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link href="${webRoot}/css/plugins/iCheck/skins/square/red.css" rel="stylesheet">
        <link href="${webRoot}/css/plugins/jsTree/style.min.css" rel="stylesheet">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">

    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/jsTree/jstree.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <jsp:include page="department_list.js.jsp"></jsp:include>
    </tiles:putAttribute>

</tiles:insertTemplate>


