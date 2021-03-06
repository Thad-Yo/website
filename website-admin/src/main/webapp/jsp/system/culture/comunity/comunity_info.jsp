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
    <tiles:putAttribute name="pageTitle" value="我们的员工详情"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10">
                        <div class="ibox-content">
                            <form method="post" class="form-horizontal registerform" id="mainForm">
                            	<input type="hidden" id="id" name="id" value = "<c:out value="${record.id}"></c:out>">
                                <input type="hidden" id="cnid" name="cnid" value = "<c:out value="${record.cnid}"></c:out>">
                                <input type="hidden" id="cnEnFlag" name="cnEnFlag" value = "<c:out value="${record.cnEnFlag}"></c:out>">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>书评标题</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" name="title" id="title"
                                               datatype="*"  value='<c:out value="${record.title}"></c:out>'/>
                                        <div class="Validform_checktip" id="titleCheck">请输入标题！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>图片</label>
                                    <div class="col-sm-3 control-label" >
                                        <div class="ibox float-e-margins">
                                            <div class="ibox-content" style="height: 150px;width: 266px;">
                                                <img id="imgAddress" border="1" width="100%" height="100%"
                                                <c:choose>
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
                                         <div  class="Validform_checktip" style="text-align:left">请上传宽高比例为1:1的图片！</div>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>缩略图</label>
                                    <div class="col-sm-3 control-label" >
                                        <div class="ibox float-e-margins">
                                            <div class="ibox-content" style="height: 150px;width: 266px;">
                                                <img id="imgAddress1" border="1" width="100%" height="100%"
                                                <c:choose>
                                                <c:when test="${record.imgLessUrl.length() > 0}">
                                                     src="${imgServer}${record.imgLessUrl}"
                                                </c:when>
                                                <c:otherwise>
                                                     src="${webRoot}/img/webuploader.png"
                                                </c:otherwise>
                                                </c:choose>>
                                            </div>
                                            <div class="ibox-title">
                                                <input id="imgLessUrl" type="hidden" name="imgLessUrl" value="<c:out value="${record.imgLessUrl}"/>">
                                                <span id="uploadImg1" class="label label-success pull-right">上传</span>
                                                <h5>图片上传&nbsp;&nbsp;<div id="coverPageUrlVol" class="Validform_checktip">请选择小于1M的上传图片</div></h5>
                                            </div>
                                        </div>
                                         <div  class="Validform_checktip" style="text-align:left">请上传宽高比例为16:10的图片！</div>
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
                                 <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>书评</label>
                                    <div class="col-sm-8">
                                        <script id="imgDesc" name="imgDesc" type="text/plain"></script>
                                        <div class="Validform_checktip">输入书评！</div>
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
        <link href="${webRoot}/js/plugins/laydate/theme/laydate.css" rel="stylesheet">	
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
        <!-- 编辑器源码文件 -->
        <script type="text/javascript" src="${webRoot}/js/plugins/ueditor/ueditor.all.js"></script>
        <script type="text/javascript" src="${webRoot}/js/plugins/laydate/laydate.js"></script>
        <!-- 实例化编辑器 -->
        <script type="text/javascript">
            var editor = UE.getEditor('imgDesc');
        </script>
        <script type="text/javascript">
            editor.ready(function(){
                editor.setContent('${record.imgDesc}');//这里的{{$content}}是我的框架前端页面调用后端数据的方法，根据个人情况不同进行调整
            });
        </script>
        <jsp:include page="comunity_info.js.jsp"></jsp:include>
    </tiles:putAttribute>

</tiles:insertTemplate>


