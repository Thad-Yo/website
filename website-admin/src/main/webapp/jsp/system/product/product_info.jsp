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
    <tiles:putAttribute name="pageTitle" value="产品详情"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10">
                        <div class="ibox-content">
                            <form method="post" class="form-horizontal registerform" id="mainForm">
                            	<input type="hidden" id="id" name="id" value = "<c:out value="${record.id}"></c:out>">
                                <input type="hidden" id="cnEnFlag" name="cnEnFlag" value = "<c:out value="${record.cnEnFlag}"></c:out>">
                                <input type="hidden" id="cnid" name="cnid" value = "<c:out value="${record.cnid}"></c:out>">
                                <input type="hidden" id="productType" name="productType" value = "<c:out value="${record.productType}"></c:out>">

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>产品服务标题</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" name="title" id="title"
                                               datatype="*"  value='<c:out value="${record.title}"></c:out>'/>
                                        <div class="Validform_checktip" id="titleCheck">请输入标题！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>摘要</label>
                                    <div class="col-sm-8">
                                        <textarea id="summary" name="summary" class="form-control" rows="5" maxlength="550" datatype="*"><c:out value="${record.summary}"></c:out></textarea>
                                    	<div class="Validform_checktip" id="summaryCheck">请输入摘要！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>简介</label>
                                    <div class="col-sm-8">
                                        <textarea id="content" name="content" class="form-control" rows="5" maxlength="550" datatype="*"><c:out value="${record.content}"></c:out></textarea>
                                   		<div class="Validform_checktip" id="contentCheck">请输入简介！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>排序数字</label>
                                    <div class="col-sm-3">
	                                    <input type="text" class="form-control" name="sortNumber" id="sortNumber"
	                                               datatype="n"  value='<c:out value="${record.sortNumber}"></c:out>'/>
	                                    <div class="Validform_checktip">请输入排序数字！</div>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="form-group">
                                    <div class="col-sm-12 text-center">
                                        <button type="button" class="btn btn-add btn-lg btn-warning fn-Cancel" style="margin-bottom: 15px;"
                                                title="取消">
                                            <i class="fa fa-remove" aria-hidden="true"> 取消</i>
                                        </button>
                                        <button type="button" class="ml30 btn btn-add btn-lg btn-success fn-Save" style="margin-bottom: 15px;"
                                                title="确定">
                                            <i class="fa fa-save" aria-hidden="true"> 确定</i>
                                        </button>
                                    </div>
                                </div>
                                </div>
                            </form>
                        </div>


                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link href="${webRoot}/css/plugins/iCheck/skins/square/red.css" rel="stylesheet">
        <link href="${webRoot}/css/plugins/webuploader/webuploader.css" rel="stylesheet">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/webuploader/webuploader.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <jsp:include page="product_info.js.jsp"></jsp:include>
    </tiles:putAttribute>

</tiles:insertTemplate>


