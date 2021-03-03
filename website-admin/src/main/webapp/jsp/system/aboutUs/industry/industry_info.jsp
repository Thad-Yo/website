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
    <tiles:putAttribute name="pageTitle" value="捐赠纪实详情"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10">
                        <div class="ibox-content">
                            <form method="post" class="form-horizontal registerform" id="mainForm">
                            	<input type="hidden" id="id" name="id" value = "<c:out value="${record.id}"></c:out>">
                                <input type="hidden" id="isEn" name="isEn" value = "<c:out value="${isEn}"></c:out>">

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>行业图标</label>
                                    <div class="col-sm-3 control-label" >
                                        <div class="ibox float-e-margins">
                                            <div class="ibox-content" style="height: 150px;">
                                                <img id="imgAddress" border="1" width="100%" height="100%"<c:choose>
						                            <c:when test="${record.imgUrl.length() > 0}">
						                                 src="${imgServer}${record.imgUrl}"
						                            </c:when>
						                            <c:otherwise>
						                                 src="${webRoot}/img/webuploader.png"
						                            </c:otherwise>
						                            </c:choose>>
                                            </div>
                                            <div class="ibox-title">
                                                <input id="imgUrl" type="hidden" name="imgUrl" value="<c:out value="${record.imgUrl}"/>">
                                                <span id="uploadImg" class="label label-success pull-right">上传</span>
                                                <h5>图片上传&nbsp;&nbsp;<div id="coverPageUrlVol" class="Validform_checktip">请选择小于1M的上传图片</div></h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>行业名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" name="industryName" id="industryName"
                                               datatype="*"  value='<c:out value="${record.industryName}"></c:out>'/>
                                        <div class="Validform_checktip">请输入行业名称！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>行业介绍</label>
                                    <div class="col-sm-9">
                                        <textarea class="form-control" id="industryInfo" name="industryInfo" datatype="*" >${record.industryInfo}</textarea>
                                        <div class="Validform_checktip">请输入行业介绍。</div>
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
        <!-- 配置文件 -->
        <script type="text/javascript" src="${webRoot}/js/plugins/ueditor/ueditor.config.js"></script>
        <jsp:include page="industry_info.js.jsp"></jsp:include>

    </tiles:putAttribute>

</tiles:insertTemplate>


