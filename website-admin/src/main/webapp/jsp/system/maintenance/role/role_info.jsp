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
    <tiles:putAttribute name="pageTitle" value="编辑角色"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10">
                        <div class="ibox-content">
                            <form method="post" class="form-horizontal registerform" id="mainForm">
                                <input type="hidden" id="roleId" name="roleId"
                                       value='<c:out value="${record.roleId}"></c:out>'/>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>角色编码</label>

                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="role" maxlength="10" datatype="*3-10"
                                               errormsg="由3-10位的字母下划线和数字组成,不能以数字或下划线开头。"
                                               value='<c:out value="${record.role}"></c:out>'/>

                                        <div class="Validform_checktip">由3-10位的字母下划线和数字组成,不能以数字或下划线开头。</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>角色名称</label>

                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" name="roleName" maxlength="100"
                                               value='<c:out value="${record.roleName}"></c:out>' datatype="s1-100"
                                               errormsg="请输入至少1个字符,最多100个字符！"/>

                                        <div class="Validform_checktip">请输入至少1个字符,最多100个字符！</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">角色说明</label>

                                    <div class="col-sm-8">
                                        <textarea id="note" name="note" class="form-control" rows="5" maxlength="500"
                                                  ignore="ignore" datatype="s0-500" errormsg="最多输入500个字符！"><c:out
                                                value="${record.note}"></c:out></textarea>

                                        <div class="Validform_checktip">最多输入500位字符！</div>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group">
                                    <div class="col-sm-12 text-center">
                                        <button type="button" class="btn btn-add btn-success btn-lg fn-Save"
                                                style="margin-bottom: 15px;"
                                                title="保存">
                                            <i class="fa fa-save" aria-hidden="true"> 保存</i>
                                        </button>
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
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <script type='text/javascript' src="${webRoot}/jsp/system/maintenance/role/role_info.js"></script>
    </tiles:putAttribute>

</tiles:insertTemplate>


