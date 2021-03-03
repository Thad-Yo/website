<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
	<%-- 画面的标题 --%>
	<tiles:putAttribute name="pageTitle" value="标题"/>
	<%-- 画面主面板 --%>
	<tiles:putAttribute name="mainContentinner" type="string">

	</tiles:putAttribute>
	<%-- 画面的CSS (ignore) --%>
	<tiles:putAttribute name="pageCss" type="string">
		<style type="text/css">
		</style>
	</tiles:putAttribute>
	<tiles:putAttribute name="pageJavaScript" type="string">
		<script type="text/javascript">
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>