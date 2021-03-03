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
    <tiles:putAttribute name="pageTitle" value="新增编辑Banner图片"/>

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
							  		</div>
							  		<div class="col-sm-3 control-label" >
			                        	<div class="ibox float-e-margins">
				                            <div class="ibox-content" style="height: 150px;">
												<img id="imgChinese" border="1" width="100%" height="100%"
						                            <c:choose>
						                            <c:when test="${row.imgChineseAdress.length() > 0}">
						                                 src="${imgServer}${row.imgChineseAdress}"
						                            </c:when>
						                            <c:otherwise>
						                                 src="${webRoot}/img/webuploader.png"
						                            </c:otherwise>
						                            </c:choose>>
											</div>
				                            <div class="ibox-title">
				                            	<input id="imgChineseAdress" type="hidden" name="imgChineseAdress" value="<c:out value="${row.imgChineseAdress}"/>">
                                                <span id="uploadImgChinese" class="label label-success pull-right">上传</span>
				                                <h5>中文图片上传&nbsp;&nbsp;<div id="imgChineseAdressVol" class="Validform_checktip">请选择小于1M的上传图片</div></h5>
				                            </div>
				                        </div>
				                        <div  class="Validform_checktip" style="text-align:left">推荐尺寸1920*940像素72的图片！</div>
							  		</div>
							  		<div class="col-sm-3 control-label" >
			                        	<div class="ibox float-e-margins">
				                            <div class="ibox-content" style="height: 150px;">
												<img id="imgEnglish"  border="1" width="100%" height="100%"
						                            <c:choose>
						                            <c:when test="${row.imgEnglishAdress.length() > 0}">
						                                 src="${imgServer}${row.imgEnglishAdress}"
						                            </c:when>
						                            <c:otherwise>
						                                 src="${webRoot}/img/webuploader.png"
						                            </c:otherwise>
						                            </c:choose>>
											</div>
				                            <div class="ibox-title">
				                            	<input id="imgEnglishAdress" type="hidden" name="imgEnglishAdress" value="<c:out value="${row.imgEnglishAdress}"/>">
				                                <span id="uploadImgEnglish" class="label label-success pull-right">上传</span>
				                                <h5>英文图片上传&nbsp;&nbsp;<div id="imgEnglishAdressVol" class="Validform_checktip">请选择小于1M的上传图片</div></h5>
				                            </div>
				                        </div>
				                        <div  class="Validform_checktip" style="text-align:left">推荐尺寸1920*940像素72的图片！</div>
							  		</div>
                    
							  	</div>
							  	<div class="form-group">
                                    <label class="col-sm-4 control-label">轮播序号</label>
                                    <div class="col-sm-3">
                                         <input type="text" class="form-control val-userName"
                                                   name="bannerNumber" id="bannerNumber" maxlength="50"
                                                   placeholder="" showAllError="false"
                                                   nullmsg="请输入轮播序号"  errormsg="请输入正确轮播序号"
                                                   dataType="*"
                                                   value="<c:out value="${row.bannerNumber}"/>"/>
                                        <div class="Validform_checktip">请输入轮播序号</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">图片链接</label>
                                    <div class="col-sm-3">
                                        <select id="imageLink" name="imageLink" class="form-control" >
                                            <option value="0" <c:if test="${row.imageLink=='0' }">selected="selected"</c:if>>无链接 </option>
                                            <option value="1" <c:if test="${row.imageLink=='1' }">selected="selected"</c:if>>链接共有 </option>
                                            <option value="2" <c:if test="${row.imageLink=='2' }">selected="selected"</c:if>>链接区分 </option>
                                            
                                        </select>
                                    </div>
                                </div>
	                        </form>
	                        <form class="form-horizontal registerform mt10">
                                <div class="form-group" id="linkShare_show" 
                               		<c:choose>
			                            <c:when test="${row.imageLink == '1'}">
			                                 style="display: ;"
			                            </c:when>
			                            <c:otherwise>
			                                 style="display: none;"
			                            </c:otherwise>
		                            </c:choose>>
                                    <label class="col-sm-4 control-label">共有链接</label>
                                    <div class="col-sm-5">
                                       <input name="linkShare" id="linkShare" type="text" class="form-control"
                                                   placeholder="" showAllError="false"
                                                   nullmsg="请输入链接"  errormsg="请输入链接"
                                                   <c:if test="${row.imageLink=='1' }">dataType="*"</c:if>
                                                   value="<c:out value="${row.linkShare}"/>"/>
                                        <div class="Validform_checktip">请输入链接</div>
                                    </div>
                                </div>
                                <div class="form-group" id="linkChinese_show" 
                                	<c:choose>
			                            <c:when test="${row.imageLink == '2'}">
			                                 style="display: ;"
			                            </c:when>
			                            <c:otherwise>
			                                 style="display: none;"
			                            </c:otherwise>
		                            </c:choose>>
                                    <label class="col-sm-4 control-label">中文链接</label>
                                    <div class="col-sm-5">
                                        <input name="linkChinese" id="linkChinese" type="text" class="form-control"
                                                   placeholder="" showAllError="false"
                                                   nullmsg="请输入中文链接"  errormsg="请输正确入中文链接"
                                                   <c:if test="${row.imageLink=='2' }">dataType="*"</c:if>
                                                   value="<c:out value="${row.linkChinese}"/>"/>
                                        <div class="Validform_checktip">请输入中文链接</div>
                                    </div>
                                </div>
                                <div class="form-group" id="linkEnglish_show" 
									<c:choose>
			                            <c:when test="${row.imageLink == '2'}">
			                                 style="display: ;"
			                            </c:when>
			                            <c:otherwise>
			                                 style="display: none;"
			                            </c:otherwise>
		                            </c:choose>>
                                    <label class="col-sm-4 control-label">英文链接</label>
                                    <div class="col-sm-5">
                                        <input name="linkEnglish" id="linkEnglish" type="text" class="form-control"
                                                   placeholder="" showAllError="false"
                                                   nullmsg="请输入中文链接"  errormsg="请输入正确中文链接"
                                                   <c:if test="${row.imageLink=='2' }">dataType="*"</c:if>
                                                   value="<c:out value="${row.linkEnglish}"/>"/>
                                        <div class="Validform_checktip">请输入中文链接</div>
                                    </div>
                                </div>
                        	</form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="popupChangeStatus" style="display: none;">

        </div>

        <div class="form-group">
          <div class="form-group">
          <div class="col-sm-12 text-center">
            <button type="button" class="btn btn-add btn-lg btn-info fn-return" style="margin-bottom: 15px; background:#FFCC00; border-color:#FFCC00; width:106px; height:40px; margin-right:20px;" title="返回" onclick="Events.returnAction()">
                <i class="fa fa-modify" aria-hidden="true">返回</i>
            </button>
            <button type="button" class="btn btn-add btn-lg btn-info fn-modify" style="margin-bottom: 15px; width:106px; margin-right:20px;" title="保存" data-id="" onclick="Events.saveAction(<c:out value="${row.issue=='1'?'1':'0' }"/>)">
                <i class="fa fa-modify" aria-hidden="true">保存</i>
            </button>
            <button type="button" class="btn btn-add btn-lg btn-info fn-modify" style="margin-bottom: 15px; width:106px; margin-right:20px;" title="<c:out value="${row.issue=='1'?'取消发布':'发布' }"/>" data-id="" onclick="Events.saveAction(<c:out value="${row.issue=='1'?'0':'1' }"/>)">
                <i class="fa fa-modify" aria-hidden="true"><c:out value="${row.issue=='1'?'取消发布':'发布' }"/></i>
            </button>
        </div></div></div>
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
        
        <jsp:include page="banner_edit.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>
