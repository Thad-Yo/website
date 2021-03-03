<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.website.common.util.properties.PropertyUtil"%>
<%
	String webRoot = PropertyUtil.getSystemResourcesPropertieValue("server.host");
	String programName = PropertyUtil.getSystemResourcesPropertieValue("program.name");
	String imgServer = PropertyUtil.getSystemResourcesPropertieValue("img.server") + "/";
	//用上面的方式容易在网络有代理的时候出现问题。
	String path = request.getContextPath();
	//String webRoot = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	//System.out.println("======================webRoot:"+webRoot+";\n webRoot2:"+webRoot2);
%>
<c:set var="webRoot" value="<%=webRoot%>"/>
<c:set var="imgServer" value="<%=imgServer%>"/>
<c:set var="programName" value="<%=programName%>"/>
<script>
	var webRoot = '${webRoot}';
	var imgServer = '${imgServer}';
	var programName = '${programName}';
</script>
