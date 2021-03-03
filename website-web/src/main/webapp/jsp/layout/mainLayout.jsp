<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<%--<html lang="en">--%>
<html lang="cn">
<!--<![endif]-->
<head>
    <%-- 画面的共通MATE --%>
    <%@include file="/jsp/common/headMetas.jsp" %>
    <%-- 浏览器左上角显示的文字 --%>
    <title><tiles:getAsString name="pageTitle"/> - 联信集团</title>
    <%-- 画面的共通CSS --%>
    <%@include file="/jsp/common/headCss.jsp" %>
    <%-- 各个画面的CSS --%>
    <tiles:insertAttribute name="pageCss" ignore="true"/>
    <%-- 上部分共通的JS --%>
    <%@include file="/jsp/common/headJavascript.jsp" %>
    <%-- 上部分的JS --%>
    <tiles:insertAttribute name="pageGlobalImport" ignore="true"/>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <%@include file="/jsp/common/pageContent.jsp" %>
    <tiles:insertAttribute name="backTop"/>
    <tiles:insertAttribute name="footer"/>
</body>

<!-- Javascripts required for this page only -->
<tiles:insertAttribute name="pageJavaScript" ignore="true"/>

</html>
