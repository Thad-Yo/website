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
    <tiles:putAttribute name="pageTitle" value="岗位大类详情"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10">
                        <div class="ibox-content">
                            <form method="post" class="form-horizontal registerform" id="mainForm">
                            	<input type="hidden" id="id" name="id" value = "<c:out value="${record.id}"></c:out>">

								<div class="form-group">
									<label class="col-sm-2 control-label"><span class="need">*</span>招聘类型</label>
									<div class="input-group" style="width: 200px;" overflow:auto>
										<c:choose>
											<c:when test="${ record.recruitType == '1' }">
												<input type="radio" id="recruitType1" name="recruitType"
													value="1" checked="checked">&nbsp;&nbsp;
												<label for="recruitType1"> 校园招聘 </label>&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" id="recruitType2" name="recruitType"
													value="2">&nbsp;&nbsp;
												<label for="recruitType2"> 社会招聘 </label>
											</c:when>
											<c:when test="${ record.recruitType == '2' }">
												<input type="radio" id="recruitType1" name="recruitType"
													value="1">&nbsp;&nbsp;
												<label for="recruitType1"> 校园招聘 </label>&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" id="recruitType2" name="recruitType"
													value="2" checked="checked">&nbsp;&nbsp;
												<label for="recruitType2"> 社会招聘 </label>
											</c:when>
											<c:otherwise>
												<input type="radio" id="recruitType1" name="recruitType"
													value="1" dataType="*" nullmsg="请选择招聘类型！"
													showAllError="false" errormsg="请选择招聘类型！">&nbsp;&nbsp;
												<label for="recruitType1"> 校园招聘 </label>&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" id="recruitType2" name="recruitType"
													value="2">&nbsp;&nbsp;
												<label for="recruitType2"> 社会招聘 </label>
												<div class="Validform_checktip"></div>
											</c:otherwise>
										</c:choose>
									</div>
								</div>

								<div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>岗位大类</label>
                                    <%-- <div class="input-group" style="width: 200px;" overflow:auto>
                                        <select id="positionType" name="positionType" class="form-control select2">
                                        	<option value="">${record.positionType}</option>
                                    	</select>
                                    </div>  --%>
                                    <div class="input-group" style="width: 200px;" overflow:auto>
                                        <select 
                                        	id="positionType" 
                                        	name="positionType" 
                                        	class="form-control select2" 
                                        	dataType="*"
                                            nullmsg="请选择岗位大类！" showAllError="false"
                                            errormsg="请选择岗位大类！">
                                        	<option value="">请选择</option>
                                        	<c:if test="${not empty positionTypeList}">
                                            	<c:forEach items="${positionTypeList}" var="positionTypeItem" begin="0" step="1"
                                                       		varStatus="status">
                                                       		<c:choose>
                                                       			<c:when test="${record.positionTypeName == positionTypeItem.positionName }">
                                                       				<option value="${positionTypeItem.id}" selected="selected">${positionTypeItem.positionName }</option>
                                                       			</c:when>
   																<c:otherwise>
                                                       				<option value="${positionTypeItem.id}" >${positionTypeItem.positionName }</option>
   																</c:otherwise>
                                                       		</c:choose>
                                            	</c:forEach>
                                        	</c:if>
                                    	</select>
                                    	<div class="Validform_checktip"></div>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>岗位</label>
                                    <div class="input-group" style="width: 200px;" overflow:auto>
                                        <select 
                                        	id="recruitPosition" 
                                        	name="recruitPosition" 
                                        	class="form-control select2" 
                                        	dataType="*"
                                            nullmsg="请选择岗位！" showAllError="false"
                                            errormsg="请选择岗位！">
                                        	<option value="">请选择</option>
                                        	<c:if test="${ not empty record }">
                                            	<option value="${record.recruitPositionId}" selected="selected">${record.recruitPosition}</option>
                                        	</c:if>
                                        </select>
                                        <div class="Validform_checktip"></div>
                                    </div> 
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>薪资</label>
                                    <div class="input-group" style="width: 200px;">
                                        <input type="text" class="form-control" id="salary" name="salary" value="${record.salary}" placeholder="请输入薪资" 
                                        datatype="*" nullmsg="请输入薪资！" errormsg="请输入薪资！">
                                    	<div class="Validform_checktip"></div>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>办公城市</label>
                                    <div class="input-group" style="width: 200px;" overflow:auto>
                                        <input type="text" id="recruitDepartment" name="recruitDepartment" 
                                        class="input form-control" value="${record.recruitCityName}" 
                                        datatype="*" nullmsg="请选择办公城市！" errormsg="请选择办公城市！">
                                        <input type="hidden" name="departmentId" id="department_id" value="${record.recruitCity}"/>
                                        <div id="menuTreeDepartment" class="menuDepartment"></div>
                                        <div class="Validform_checktip"></div>
                                    </div>
                                    
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">岗位说明</label>
                                   <%-- <div class="input-group" style="width: 600px;" overflow:auto>
                                        <textarea rows="5" class="form-control" id="positionIntroduce" name="positionIntroduce" datatype="*" >${record.positionIntroduce}</textarea>
                                        <div class="Validform_checktip">输入岗位说明！</div>
                                    </div>--%>
                                    <div class="input-group" style="width: 600px;" overflow:auto>
                                        <script id="positionIntroduce" name="positionIntroduce" type="text/plain" ></script>
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
                                            <i class="fa fa-save" aria-hidden="true"> 保存</i>
                                        </button>
                                        <button type="button" class="ml30 btn btn-add btn-lg btn-success fn-Publish" style="margin-bottom: 15px;"
                                                title="发布">
                                            <i class="fa fa-send" aria-hidden="true"> 发布</i>
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
        <link href="${webRoot}/js/plugins/select2/select2.css" rel="stylesheet">
        <link href="${webRoot}/js/plugins/select2/select2-lianxin.css" rel="stylesheet">
        <link href="${webRoot}/css/plugins/jsTree/style.min.css" rel="stylesheet">
        <style>
            #menuTreeDepartment{
		        position: absolute;
			    background: white;
			    z-index: 1000;
			    width: 200px;
			    top: 0;
			    max-height: 350px;
			    overflow-y: scroll;
			}
			
        </style>
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
    	<script type='text/javascript' src="${webRoot}/js/plugins/select2/select2.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/layer/laydate/laydate.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/jsTree/jstree.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/webuploader/webuploader.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <!-- 配置文件 -->
        <script type="text/javascript" src="${webRoot}/js/plugins/ueditor/ueditor.config.js"></script>
        <!-- 编辑器源码文件 -->
        <script type="text/javascript" src="${webRoot}/js/plugins/ueditor/ueditor.all.js"></script>
        <!-- 实例化编辑器 -->
        <script type="text/javascript">
            var editor = UE.getEditor('positionIntroduce');
        </script>
        <script type="text/javascript">
            editor.ready(function(){
                editor.setContent('${record.positionIntroduce}');//这里的{{$content}}是我的框架前端页面调用后端数据的方法，根据个人情况不同进行调整
            });
        </script>
        <jsp:include page="recruitPosition_info.js.jsp"></jsp:include>

    </tiles:putAttribute>

</tiles:insertTemplate>


