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
                                    <label class="col-sm-2 control-label"><span class="need">*</span>类型名称</label>

                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="cultureTypeName" name="cultureTypeName" maxlength="50" datatype="*1-50"
                                               errormsg="由1-50位的汉字字母下划线和数字组成,不能重复。"
                                               value='<c:out value="${record.cultureTypeName}"></c:out>'/>

                                        <div class="Validform_checktip" id="ValidForm_Position">由1-50位的汉字字母下划线和数字组成,不能重复。</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>类型名称英文</label>

                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="cultureTypeEnName" name="cultureTypeEnName" maxlength="100" datatype="*1-100"
                                               errormsg="由1-50位的字母下划线和数字组成,不能重复。"
                                               value='<c:out value="${record.cultureTypeEnName}"></c:out>'/>

                                        <div class="Validform_checktip" id="ValidForm_Position">由1-50位的字母下划线和数字组成,不能重复。</div>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">类型说明</label>

                                    <div class="col-sm-8">
                                        <textarea id="notes" name="notes" class="form-control" rows="3" maxlength="100" datatype="*0-100"><c:out value="${record.notes}"></c:out></textarea>
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
        <jsp:include page="staff_type_info.js.jsp"></jsp:include>

    </tiles:putAttribute>

</tiles:insertTemplate>


