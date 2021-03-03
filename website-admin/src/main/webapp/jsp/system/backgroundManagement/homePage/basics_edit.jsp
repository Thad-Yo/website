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
                        <div class="ibox-content"  style="width: 100%;">
                       		<form class="form-horizontal registerform mt10">
							  	<div class="form-group">
							  		<div class="col-sm-3 control-label" id="hidePlace">
							  			<input type="hidden" id="id" name="id" value="<c:out value="${row.id}"/>">
							  			<%-- <input type="hidden" id="createTime" name="createTime" value="<c:out value="${row.createTime}"/>"> --%>
							  		</div>
							  		<%-- <div class="col-sm-12" >
			                        	<div class="ibox float-e-margins">
				                            <div class="ibox-title">
				                                <h5>基础数据</h5>
				                            </div>
				                            <div class="ibox-content" style="height: 150px;">
				                            	<div class="form-group">
					                            	<label class="col-sm-4 control-label">计时开始时间</label>
				                                    <div class="col-sm-3">
				                                         <input type="text" class="form-control val-userName"
				                                                   name="time" id="time" maxlength="50"
				                                                   placeholder="" showAllError="false"
				                                                   nullmsg="请输入计时开始时间"  errormsg="请输入正确计时开始时间"
				                                                   dataType="*"
				                                                   value="<c:out value="${row.time}"/>"/>
				                                        <div class="Validform_checktip">请输入计时开始时间</div>
				                                    </div>
                               		 			</div>
				                            	<div class="form-group">
					                            	<label class="col-sm-4 control-label">客户数量</label>
				                                    <div class="col-sm-3">
				                                         <input type="text" class="form-control val-userName" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                                                   name="khCount" id="khCount" maxlength="50"
				                                                   placeholder="" showAllError="false"
				                                                   nullmsg="请输入客户数量"  errormsg="请输入正确客户数量"
				                                                   dataType="*"
				                                                   value="<c:out value="${row.khCount}"/>"/>
				                                        <div class="Validform_checktip">请输入客户数量</div>
				                                    </div>
                               		 			</div>
				                            	<div class="form-group">
					                            	<label class="col-sm-4 control-label">人员数量</label>
				                                    <div class="col-sm-3">
				                                         <input type="text" class="form-control val-userName" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                                                   name="ryCount" id="ryCount" maxlength="50"
				                                                   placeholder="" showAllError="false"
				                                                   nullmsg="请输入人员数量"  errormsg="请输入正确人员数量"
				                                                   dataType="*"
				                                                   value="<c:out value="${row.ryCount}"/>"/>
				                                        <div class="Validform_checktip">请输入人员数量</div>
				                                    </div>
                               		 			</div>
				                            	<div class="form-group">
					                            	<label class="col-sm-4 control-label">分公司数量</label>
				                                    <div class="col-sm-3">
				                                         <input type="text" class="form-control val-userName" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                                                   name="fgsCount" id="fgsCount" maxlength="50"
				                                                   placeholder="" showAllError="false"
				                                                   nullmsg="请输入分公司数量"  errormsg="请输入分公司数量"
				                                                   dataType="*"
				                                                   value="<c:out value="${row.fgsCount}"/>"/>
				                                        <div class="Validform_checktip">请输入分公司数量</div>
				                                    </div>
                               		 			</div>
											</div>
				                        </div>
							  		</div>
							  		 <div class="col-sm-12 control-label" >
			                        	<div class="ibox float-e-margins">
				                            <div class="ibox-title">
				                                <h5>企业介绍</h5>
				                            </div>
											<div class="ibox-content" style="height: 150px;">
												<div class="form-group">
													<label class="col-sm-2 control-label">中文版</label>
													<div class="col-sm-8">
														<script id="introduceCn" name="introduceCn" type="text/plain"></script>
														<div class="Validform_checktip">输入中文版企业介绍！</div>
													</div>
												</div>

												<div class="form-group">
													<label class="col-sm-2 control-label">英文版</label>
													<div class="col-sm-8">
														<script id="introduceEn" name="introduceEn" type="text/plain"></script>
														<div class="Validform_checktip">输入英文版企业介绍！</div>
													</div>
												</div>


											</div>
										</div>
							  		</div> --%>
                    
							  		<div class="col-sm-12 control-label" >
			                        	<div class="ibox float-e-margins">
				                            <div class="ibox-title">
				                                <h5>企业视频</h5>
				                            </div>
				                            <div class="ibox-content" style="height: 150px;">
											  	<div class="form-group">
											  		<label class="col-sm-4 control-label">是否有视频</label>
											  		<div class="col-sm-3">
											  		<input type="hidden" id="checked" name="checked" value="<c:out value="${row.checked}"/>">
													    <label class="radio-inline">
															<input type="radio" name="videoConfig" id="xxx0"  value="0"onclick="divClick();" <c:if test="${row.checked=='0'}">checked</c:if>> 无视频
													    </label>
													    <label class="radio-inline">
													        <input type="radio" name="videoConfig" id="xxx1"  value="1" onclick="divClick();" <c:if test="${row.checked=='1'}">checked</c:if>> 视频共用
													    </label>
													    <label class="radio-inline">
													        <input type="radio" name="videoConfig" id="xxx2"  value="2" onclick="divClick();" <c:if test="${row.checked=='2'}">checked</c:if>> 视频区分
													    </label>
													    
											  		</div>
												</div>
				                            	
				                            	<div class="form-group">
											  		<div class="col-sm-2 control-label" >
											  		</div>  
											  		<div class="col-sm-8 control-label" id="gyVideo"  <c:if test="${row.checked=='0' or row.checked=='2'}">hidden</c:if>>
							                        	<div class="ibox float-e-margins">
								                            <div class="ibox-title">
								                            	<input id="videoShareAdress" type="hidden" name="imgChineseAdress" value="<c:out value="${row.videoShareAdress}"/>">
				                                                <shiro:hasPermission name="pageHome_basics:UPLOAD">
				                                                <span id="uploadVideoShare" class="label label-success pull-right">上传</span>
				                                                </shiro:hasPermission>
								                                <h5 style="padding-right: 30px">共用视频上传&nbsp;&nbsp;<div id="videoShareAdressVol" class="Validform_checktip">请选择上传视频</div></h5>
								                                <div class="progress progress-striped" style="width: 70%;">
										                            <div id="uploadVideoShareProgress" style="width: 0%" aria-valuemax="100" aria-valuemin="0" role="progressbar" class="progress-bar progress-bar-warning">
										                            	<span class="">0%</span>
										                            </div>
										                        </div>
								                            </div>
								                        </div>
											  		</div>
											  	</div>
				                            	<div class="form-group">
											  		<div class="col-sm-2 control-label" >
											  		</div>
											  		<div class="col-sm-8 control-label" id="zwVideo"  <c:if test="${row.checked=='0' or row.checked=='1'}">hidden</c:if>>
							                        	<div class="ibox float-e-margins">
								                            <div class="ibox-title">
								                            	<input id="videoChineseAdress" type="hidden" name="imgChineseAdress" value="<c:out value="${row.videoChineseAdress}"/>">
				                                                <shiro:hasPermission name="pageHome_basics:UPLOAD">
				                                                <span id="uploadVideoChinese" class="label label-success pull-right">上传</span>
								                                </shiro:hasPermission>
								                                <h5 style="padding-right: 30px">中文视频上传&nbsp;&nbsp;<div id="videoChineseAdressVol" class="Validform_checktip">请选择上传视频</div></h5>
								                           		<div class="progress progress-striped" style="width: 70%;">
										                            <div id="uploadVideoChineseProgress" style="width: 0%" aria-valuemax="100" aria-valuemin="0" role="progressbar" class="progress-bar progress-bar-warning">
										                            	<span class="">0%</span>
										                            </div>
										                        </div>
								                            </div>
								                        </div>
											  		</div>
											  	</div>
				                            	<div class="form-group">
											  		<div class="col-sm-2 control-label" >
											  		</div>
											  		<div class="col-sm-8 control-label" id="ywVideo" <c:if test="${row.checked=='0' or row.checked=='1'}">hidden</c:if>>
							                        	<div class="ibox float-e-margins">
								                            <div class="ibox-title">
								                            	<input id="videoEnglishAdress" type="hidden" name="imgEnglishAdress" value="<c:out value="${row.videoEnglishAdress}"/>">
								                                <shiro:hasPermission name="pageHome_basics:UPLOAD">
								                                <span id="uploadVideoEnglish" class="label label-success pull-right">上传</span>
								                                </shiro:hasPermission>
								                                <h5 style="padding-right: 30px">英文视频上传&nbsp;&nbsp;<div id="videoEnglishAdressVol" class="Validform_checktip">请选择上传视频</div></h5>
								                           		<div class="progress progress-striped" style="width: 70%;">
										                            <div id="uploadVideoEnglishProgress" style="width: 0%" aria-valuemax="100" aria-valuemin="0" role="progressbar" class="progress-bar progress-bar-warning">
										                            	<span class="">0%</span>
										                            </div>
										                        </div>
								                            </div>
								                        </div>
											  		</div>
				                    
											  	</div>
				                            	
				                            	
											</div>
				                        </div>
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
        <div align="center">
        <shiro:hasPermission name="pageHome_basics:SAVE">
        <button type="button"  class="btn btn-add btn-lg btn-info fn-modify" style="margin-bottom: 15px; width:106px; margin-right:20px;" title="保存" data-id="" onclick="Events.saveBasicAction()">
            <i class="fa fa-modify" aria-hidden="true">保存</i>
        </button>
        </shiro:hasPermission>
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
        <jsp:include page="basics_edit.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>
