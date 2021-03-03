<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.website.common.util.properties.PropertyUtil"%>
<%@ page import="com.website.common.util.cache.RedisUtils" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.website.web.system.language.AreaUtil" %>
<%
	String webRoot = PropertyUtil.getSystemResourcesPropertieValue("server.host");
	String hrwebRoot = PropertyUtil.getSystemResourcesPropertieValue("hrServer.host");
	String programName = PropertyUtil.getSystemResourcesPropertieValue("program.name");
	String imgServer = PropertyUtil.getSystemResourcesPropertieValue("img.server") + "/";
	//String hostIp = request.getRemoteHost();
	String redisFlag = AreaUtil.getLanguageFlag(request);

	//用上面的方式容易在网络有代理的时候出现问题。
	String path = request.getContextPath();
	//String webRoot = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	//System.out.println("======================webRoot:"+webRoot+";\n webRoot2:"+webRoot2);
%>
<c:set var="now" value='<%="var="+new Date()%>'/>
<c:set var="webRoot" value="<%=webRoot%>"/>
<c:set var="hrwebRoot" value="<%=hrwebRoot%>"/>
<c:set var="imgServer" value="<%=imgServer%>"/>
<c:set var="programName" value="<%=programName%>"/>
<c:set var="redisFlag" value="<%=redisFlag%>"/>
<script>
	var webRoot = '${webRoot}';
	var hrwebRoot = '${hrwebRoot}';
	var imgServer = '${imgServer}';
	var programName = '${programName}';
	redisFlag = '${redisFlag}';
</script>
