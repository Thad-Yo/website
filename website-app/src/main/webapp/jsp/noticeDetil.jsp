<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<c:set var="ctx" value="${pageContext.request.contextPath}" />
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/page.css"/>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
		<link rel="stylesheet" href="${ctx}/css/font-awesome.min.css">
		<title>公告详情</title>
	</head>
	<body class="about-us-body">
		<div class="specialFont response" >
		<div>
		<h1>${websiteNotice.noticeTitle}</h1>
		<h6>${websiteNotice.createDate}</h6>
		</div>	
			<div>
			${websiteNotice.noticeContent}
			</div>	
		</div>
	</body>
</html>