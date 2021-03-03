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
                            	<input type="hidden" id="cnEnFlag" name="cnEnFlag" value = "<c:out value="${record.cnEnFlag}"></c:out>">
                            	<input type="hidden" id="isTop" name="isTop" value = "<c:out value="${record.isTop}"></c:out>">
                                <input type="hidden" id="cnid" name="cnid" value = "<c:out value="${record.cnid}"></c:out>">

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need" id="picspan">*</span>捐赠图片</label>
                                    <div class="col-sm-3 control-label" >
                                        <div class="ibox float-e-margins">
                                            <div class="ibox-content" style="height: 150px;">
                                                <img id="imgAddress" border="1" width="100%" height="100%"
                                                <c:choose>
                                                <c:when test="${record.coverPageUrl.length() > 0}">
                                                     src="${imgServer}${record.coverPageUrl}"
                                                </c:when>
                                                <c:otherwise>
                                                     src="${webRoot}/img/webuploader.png"
                                                </c:otherwise>
                                                </c:choose>>
                                            </div>
                                            <div class="ibox-title">
                                                <input id="coverPageUrl" type="hidden" name="coverPageUrl" value="<c:out value="${record.coverPageUrl}"/>">
                                                <span id="uploadImg" class="label label-success pull-right">上传</span>
                                                <h5>图片上传&nbsp;&nbsp;<div id="coverPageUrlVol" class="Validform_checktip">请选择小于1M的上传图片</div></h5>
                                            </div>
                                        </div>
                                        <div  class="Validform_checktip">请上传宽高比16*9且最小宽度220像素的图片！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>标题</label>
                                    <div class="col-sm-3" style="position:relative;">
                                        <input type="text" class="form-control" name="newsTitle" id="newsTitle"
                                               datatype="*"  value='<c:out value="${record.newsTitle}"></c:out>'/>
                                        <div class="lengthR">（最大长度为36个字符！）</div>
                                        <div class="Validform_checktip">请输入标题！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                     <label class="col-sm-2 control-label"><span class="need">*</span>置顶</label>
                                     <div class="col-sm-9">
                                         <div class="radio clip-radio radio-primary ">
                                             <input type="radio" id="sexOn" name="isToppp" value="0"  <c:if test="${record.isTop == '0'}">checked</c:if> />
                                             <label  for="sexOn">是 </label>
                                             <input type="radio" id="sexOff" name="isToppp" value="1" <c:if test="${record.isTop == '1'}">checked</c:if> />
                                             <label for="sexOff">否</label>
                                         </div>
                                     </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>捐赠时间</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="donationTime" name="donationTime" maxlength="20" value="${record.donationTime}"/>
                                        <div class="Validform_checktip">请选择发布日期。</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>捐赠内容</label>
                                    <div class="col-sm-8">
                                        <script id="content" name="content" type="text/plain"></script>
                                        <div class="Validform_checktip">输入捐赠内容！</div>
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
                                        <button type="button" class="ml30 btn btn-add btn-lg btn-success fn-foreView" style="margin-bottom: 15px;"
                                                title="预览">
                                            <i class="fa fa-foreView" aria-hidden="true">预览</i>
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
        <style>
            .lengthR{
                position: absolute;
                right: -155px;
                top: 9px;
                color: #999;
            }
        </style>
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
        <!-- 实例化编辑器 -->
        <script type="text/javascript">
            var editor = UE.getEditor('content');
        </script>

        <script type="text/javascript">
        editor.ready(function()
        　　　　　　{
        　　　　　　　　editor.setContent('${record.content}');//这里的{{$content}}是我的框架前端页面调用后端数据的方法，根据个人情况不同进行调整
        　　　　　　});
        </script>
        <script type="text/javascript" src="${webRoot}/js/plugins/laydate/laydate.js"></script>
        <jsp:include page="donationInstance_info.js.jsp"></jsp:include>

   </tiles:putAttribute>

</tiles:insertTemplate>


