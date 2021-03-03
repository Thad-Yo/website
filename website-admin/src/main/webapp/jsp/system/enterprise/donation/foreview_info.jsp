<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit"/>
	<meta name="force-rendering" content="webkit"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<script>
		/*@cc_on window.location.href="http://support.dmeng.net/upgrade-your-browser.html?referrer="+encodeURIComponent(window.location.href); @*/
	</script>
	<title></title>
	<link rel="icon" href="${webRoot}/img/images/favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="${webRoot}/img/images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="${webRoot}/css/scss/index.css" />
	<script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
	<script src="${webRoot}/js/common.js"></script>
	<link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css" />
	<link rel="stylesheet" href="${webRoot}/css/header.css" />
	<link rel="stylesheet" href="${webRoot}/css/social.css" />
</head>

<body>
<script src="${webRoot}/js/headerHtml.js"></script>
<div class="company">
	<input hidden id="type" value="${newsRecord.type}">
	<div class="banner">
		<img src="${webRoot}/img/images/social/banner.jpg" width="100%">
	</div>
	<div class="breadNav">
		<ul>
			<li><img src="${webRoot}/img/images/companyNew/house.png"></li>
			<li>
				<a href="" class="textCN">社会责任 ></a>
				<a href="" class="textEN">Social Awareness></a>
			</li>
			<li class="currentColor">
				<a class="textCN">责任详情</a>
				<a class="textEN">Awareness Details</a>
			</li>
		</ul>
	</div>
	<div class="conentDiv">
		<div class="title-text wow fadeInDown" id="newsTitle">
		</div>
		<div class="grayBox">
			<ul>
				<li class="borderBox textCN">社会责任</li>
				<li class="borderBox textEN">Social Awareness</li>
				<li id="donationTime"></li>
			</ul>
		</div>
		<div class="detailBox wow fadeIn" id="content">
		</div>
	</div>
</div>
<script>
    var newsTitle = localStorage.newsTitle;
    var donationTime = localStorage.donationTime;
    var content = localStorage.content;
    if(newsTitle != null){
    	$("#newsTitle").text(newsTitle);
    }
    if(donationTime != null){
    	$("#donationTime").text(donationTime);
    }
    if(content != null){
    	$("#content").html(content);
    }
</script>
<script src="${webRoot}/js/footer.js"></script>
<script type="text/javascript" src="${webRoot}/js/DD_belatedPNG.js"></script>
<script src="${webRoot}/js/plugins/wow/wow.min.js"></script>
<script type="text/javascript" src="${webRoot}/js/header.js"></script>
<script>
    new WOW().init();
</script>
</body>

</html>