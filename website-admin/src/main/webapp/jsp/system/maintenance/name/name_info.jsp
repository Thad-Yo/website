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
    <tiles:putAttribute name="pageTitle" value="数据字典"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10 mb10">
                        <div class="ibox-content">
                            <form method="post" class="form-horizontal registerform" id="mainForm">
                                <input type="hidden" id="id" name="id"
                                       value='<c:out value="${record.id}"></c:out>'/>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>名称区分</label>

                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="nameClass" name="nameClass" maxlength="20"
                                               datatype="*"
                                               errormsg="请输入名称区分。"
                                               value='<c:out value="${record.nameClass}"></c:out>'/>

                                        <div class="Validform_checktip">请输入名称区分。</div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>名称编号</label>

                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="nameCd" name="nameCd" maxlength="6"
                                               datatype="*"
                                               errormsg="请输入名称编号。"
                                               value='<c:out value="${record.nameCd}"></c:out>'/>

                                        <div class="Validform_checktip">请输入名称编号。</div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"><span class="need">*</span>名称</label>

                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="name" name="name" maxlength="20"
                                               datatype="*"
                                               errormsg="请输入名称。"
                                               value='<c:out value="${record.name}"></c:out>'/>

                                        <div class="Validform_checktip">请输入名称。</div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">值</label>

                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" id="data" name="data" maxlength="20"
                                               datatype="*0-20"
                                               errormsg="请输入值。"
                                               value='<c:out value="${record.data}"></c:out>'/>

                                        <div class="Validform_checktip">请输入值。</div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">排序</label>

                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" name="sortKey" maxlength="2"
                                               datatype="n0-2"
                                               errormsg="请输入正确的排序编号。"
                                               value='<c:out value="${record.sortKey}"></c:out>'/>

                                        <div class="Validform_checktip">请输入排序。</div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">备注</label>

                                    <div class="col-sm-9">
                                         <textarea id="notes" name="notes" class="form-control" rows="5" maxlength="200"
                                                   ignore="ignore" datatype="s0-500" errormsg="最多输入200个字符！"><c:out
                                                 value="${record.notes}"></c:out></textarea>

                                        <div class="Validform_checktip">最多输入200位字符！</div>

                                    </div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group mb10">
                                    <div class="col-sm-12 text-center">
                                        <button type="button" class="btn btn-add btn-lg btn-success fn-Save" style="margin-bottom: 15px;"
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
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <jsp:include page="name_info.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


