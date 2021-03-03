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
    <tiles:putAttribute name="pageTitle" value="部门管理"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
    
    <div class="col-sm-8" style="min-height:250px;overflow-y:auto; max-height:300px;">
    	<c:if test="${not empty positionResult }">
       		<c:forEach var="positionType" items="${positionResult}" begin="0" step="1" varStatus="status">
       			<lable><input class="checkId" type="checkbox" name="positionType[${status.index }]" value="${positionType.id }" id="${positionType.id }" onclick="Events.checkedClick(this);" 
       			 />${positionType.positionTypeName}</lable><br/>
       			<div class="col-sm-8">
     			<c:forEach var="position" items="${positionType.positionList }" begin="0" step="1" varStatus="statusposition">
     				<lable><input class="fn-check" onclick="Events.fncheck(this)" type="checkbox" name="${positionType.id }" value="${position.id}-;-${position.positionTypeId}-;-${position.positionName}-;-${position.positionCode}" 
     				${(not empty position.remark)?"checked='checked'":"" }/>${position.positionName}</lable><br/>
     			</c:forEach>
     			</div>
       		</c:forEach>
        </c:if>
    </div>
    <div class="form-group" style="text-align: center">
        <button class="btn btn-danger dep-submit" type="button">确认</button>
    </div>
        <!-- End Panel Other -->
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
        <link href="${webRoot}/js/plugins/select2/select2.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">

    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
     <script src="${webRoot}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script type='text/javascript' src="${webRoot}/js/plugins/select2/select2.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
       <jsp:include page="department_button.js.jsp"></jsp:include>
    </tiles:putAttribute>

</tiles:insertTemplate>


