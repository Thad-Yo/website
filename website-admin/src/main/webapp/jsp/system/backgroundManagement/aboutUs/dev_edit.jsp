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
    <tiles:putAttribute name="pageTitle" value="新增发展历程"/>

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
							  			<input type="hidden" id="createTime" name="createTime" value="<c:out value="${row.createTime}"/>">
                               			<input type="hidden" id="isEng" name="isEng" value = "<c:out value="${isEng}"></c:out>">
							  		</div>
							  		 <%-- <div class="col-sm-3 control-label" >
			                        	<div class="ibox float-e-margins" >
				                            <div class="ibox-content" style="height: 150px;">
												<img id="img" border="1" width="100%" height="100%"
						                            <c:choose>
						                            <c:when test="${row.imgAddress.length() > 0}">
						                                 src="${imgServer}${row.imgAddress}"
						                            </c:when>
						                            <c:otherwise>
						                                 src="${webRoot}/img/webuploader.png"
						                            </c:otherwise>
						                            </c:choose>>
											</div>
				                            <div class="ibox-title">
				                            	<input id="imgAddress" type="hidden" name="imgAddress" value="<c:out value="${row.imgAddress}"/>">
                                                <span id="uploadimgAddress" class="label label-success pull-right">上传</span>
				                                <h5>历程图片上传&nbsp;&nbsp;<div id="imgAddressVol" class="Validform_checktip">请选择小于1M的上传图片</div></h5>
				                            </div>
				                        </div>
							  		</div> --%> </div>
							  		
							  	<div class="form-group">
                                    <label class="col-sm-4 control-label"><span class="need">*</span>历程日期</label>
                                    <div class="col-sm-2">
                                         <input type="text" class="form-control val-userName"
                                                   name="devDate" id="devDate" maxlength="50"
                                                   value="${row.devDate}"/>
                                        <div class="Validform_checktip">请输入历程日期</div>
                                    </div>
                                </div>
	                        </form>
	                        
	                        <form class="form-horizontal registerform mt10">
	                        <div class="form-group">
                                    <label class="col-sm-4 control-label"><span class="need">*</span>历程标题</label>
                                    <div class="col-sm-3">
                                         <input type="text" class="form-control val-userName"
                                                   name="devTitle" id="devTitle" maxlength="50"
                                                   placeholder="" showAllError="false"
                                                   nullmsg="请输入历程标题"  errormsg="请输入正确历程标题"
                                                   dataType="*"
                                                   value="<c:out value="${row.devTitle}"/>"/>
                                        <div class="Validform_checktip">请输入历程标题</div>
                                    </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-sm-4 control-label"><span class="need">*</span>历程简介</label>

                                    <div class="col-sm-6">
                                         <textarea id="devText" name="devText" class="form-control" rows="5" maxlength="1000"
                                                    placeholder="" showAllError="false"
                                                   nullmsg="请输入历程简介"  errormsg="请输入正确历程简介"
                                                   dataType="*"><c:out
                                                 value="${row.devText}"></c:out></textarea>

                                        <div class="Validform_checktip">请输入历程简介</div>
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
    	<link href="${webRoot}/js/plugins/laydate/theme/laydate.css" rel="stylesheet">
    	
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
         <script type="text/javascript" src="${webRoot}/js/plugins/laydate/laydate.js"></script>
        
        <jsp:include page="dev_edit.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>
