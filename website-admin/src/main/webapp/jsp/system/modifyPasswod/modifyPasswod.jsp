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
    <tiles:putAttribute name="pageTitle" value="修改密码"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-content mt10">
                            <form method="post" class="form-horizontal registerform pt10" id="mainForm">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label w100px"><span class="need">*</span>旧密码</label>

                                    <div class="col-sm-6">
                                        <input type="password" class="form-control" name="oldPassword" id="oldPassword" maxlength="20" ajaxurl="ajaxCheckAction"
                                               datatype="pwd" errormsg="请输入正确的旧密码。" value=''/>

                                        <div class="Validform_checktip">请输入正确的旧密码。</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label w100px"><span class="need">*</span>密码</label>

                                    <div class="col-sm-6">
                                        <input type="password" class="form-control" name="password" id="password" value=''
                                               datatype="pwd"/>
                                        <div class="Validform_checktip">长度为6-20，由字母下划线和数字组成。</div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label w100px"><span class="need">*</span>密码确认</label>

                                    <div class="col-sm-6">
                                        <input type="password" class="form-control" name="repassword" value=''
                                               datatype="pwd"
                                               recheck="password" nullmsg="请再输入一次密码！" errormsg="您两次输入的密码不一致！"/>

                                        <div class="Validform_checktip">请输入相同的密码。</div>
                                    </div>
                                </div>
                            </form>
                            <div class="row">
                                <div class="col-sm-offset-3">
                                    <button type="button" class="btn btn-add btn-success btn-lg fn-Save" style="margin-bottom: 15px;"
                                            title="保存">
                                        <i class="fa fa-save" aria-hidden="true"> 保存</i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <script type='text/javascript' src="${webRoot}/jsp/system/modifyPasswod/modifyPasswod.js"></script>
    </tiles:putAttribute>

</tiles:insertTemplate>




