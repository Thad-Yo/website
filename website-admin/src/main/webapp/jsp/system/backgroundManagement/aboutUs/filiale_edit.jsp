<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertTemplate template="/jsp/layout/mainLayout.jsp" flush="true">
    <%@ include file="/jsp/base/pageBase.jsp" %>
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="新增资质荣誉"/>

        <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10 mb10">
                        <div class="ibox-content"  style="width: 100%;height: 95%">
                       		<form class="form-horizontal registerform mt10">
							  	<div class="form-group">
							  	<div class="col-sm-3 control-label" id="hidePlace">
							  			<input type="hidden" id="id" name="id" value="<c:out value="${row.id}"/>">
							  		</div>
							  		  </div>
							  		
                                <div class="form-group">
                                    <label class="col-sm-4 control-label"><span class="need">*</span>分公司名称</label>
                                    <div class="col-sm-3">
                                         <input type="text" class="form-control val-userName"
                                                   name="filialeName" id="filialeName" maxlength="50"
                                                   placeholder="" showAllError="false"
                                                   nullmsg="请输入分公司名称"  errormsg="请输入正确分公司名称"
                                                   dataType="*"
                                                   value="<c:out value="${row.filialeName}"/>"/>
                                        <div class="Validform_checktip">请输入分公司名称</div>
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-sm-4 control-label"><span class="need">*</span>联系电话</label>
                                    <div class="col-sm-3">
                                         <%-- <textarea id="tel" name="tel" class="form-control val-userName"  maxlength="11""
                                                    placeholder="" showAllError="false"
                                                   nullmsg="请输入联系电话"  errormsg="请输入正确联系电话"
                                                   datatype="/^\d{11}$/"><c:out
                                                 value="${row.tel}"></c:out></textarea> --%>
                                             
                                         <textarea id="tel" name="tel" class="form-control val-userName""
                                                    placeholder="" showAllError="false"
                                                   nullmsg="请输入联系电话"  errormsg="请输入正确联系电话"
                                                   datatype="*"><c:out
                                                 value="${row.tel}"></c:out></textarea>

                                        <div class="Validform_checktip">请输入联系电话</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label"><span class="need">*</span>所属省份</label>
                                    <div class="col-sm-3">
                                         <select id="province" name="province" class="form-control">
                                                <option value="${row.province}">全部</option>
                                                <c:if test="${not empty provinceList}">
                                                    <c:forEach items="${provinceList}" var="province" begin="0" step="1"
                                                               varStatus="status">
                                                        <option value="${province.name}" <c:out
                                                                value="${province.name == row.province ? 'selected' : ''}"/> >${province.name }</option>
                                                    </c:forEach>
                                                </c:if>
                                            </select>
                                        <div class="Validform_checktip">请选择所属省份</div>
                                    </div>
                                </div>
                        	</form>
                        	<br/><br/>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="popupChangeStatus" style="display: none;">

        </div>

 		<div align="center">
            <button type="button" class="btn btn-add btn-lg btn-info fn-return" style="margin-bottom: 15px; background:#FFCC00; border-color:#FFCC00; width:106px; height:40px; margin-right:20px;" title="返回" onclick="Events.returnAction()">
                <i class="fa fa-modify" aria-hidden="true">返回</i>
            </button>
            <button type="button" class="btn btn-add btn-lg btn-info fn-modify" style="margin-bottom: 15px; width:106px; margin-right:20px;" title="保存" data-id="" onclick="Events.saveAction()">
                <i class="fa fa-modify" aria-hidden="true">保存</i>
            </button>
        </div>
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
    	<link href="${webRoot}/css/plugins/webuploader/webuploader.css" rel="stylesheet">
    	<link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    	
        <style>
        </style>
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/webuploader/webuploader.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        
        <jsp:include page="filiale_edit.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>
