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
	<title></title>
	<link rel="stylesheet" href="${webRoot}/css/index.css" />
	<link rel="stylesheet" href="${webRoot}/css/header.css" />
	<link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css" />
</head>

<body>

<div class="header">
    <div class="imgBoxlogo textCN"><img src='${webRoot}/img/logo1.png'></div>
    <div class="imgBoxlogo textEN"><img src='${webRoot}/img/logo1-EN.png'></div>
	<ul class="nav">
		<li>
			<a class='textCN'>首页</a>
			<a class='textEN'>Home</a>
		</li>
		<li>
			<a class='textCN'>关于我们</a>
			<a class='textEN'>About Us</a>
		</li>
		<li>
			<a class='textCN'>产品服务</a>
			<a class='textEN'>Services</a>
			<ul class="second-nav">
				<li>
					<a class='textCN'>征信业务</a>
					<a class='textEN'>Credit Services</a>
				</li>
				<li>
					<a class='textCN'>逾期账款管理</a>
					<a class='textEN'>Debt Collection</a>
					<ul class="third-nav">
						<li>
							<a class='textCN'>国内逾期账款管理</a>
							<a class='textEN'>Domestic Debt Collection</a>
						</li>
						<li>
							<a class='textCN'>国际逾期账款管理</a>
							<a class='textEN'>International Debt Collection</a>
						</li>
					</ul>
				</li>
				<li>
					<a class='textCN'>联信科技</a>
					<a class='textEN'>Inter-Credit</a>
				</li>
			</ul>
		</li>
		<li class="active">
			<a class='textCN'>联信动态</a>
			<a class='textEN'>Newsletters</a>
			<ul class="second-nav">
				<li>
					<a class='textCN'>联信时讯</a>
					<a class='textEN'>Latest News</a>
				</li>
				<li>
					<a class='textCN'>行业新闻</a>
					<a class='textEN'>Industry news</a>
				</li>
				<li>
					<a class='textCN'>联信Style</a>
					<a class='textEN'>Inter-Credit Style</a>
				</li>
			</ul>
		</li>
		<li>
			<a class='textCN'>社会责任</a>
			<a class='textEN'>Social Awareness</a>
		</li>
		<li>
			<a class='textCN'>加入我们</a>
			<a class='textEN'>join us</a>
		</li>
		<li>
			<a class='textCN'>联系我们</a>
			<a class='textEN'>Contact</a>
		</li>
	</ul>
</div>
<div class="company">
	<input type="hidden" id="type" value="${newsRecord.type}">
	<input type="hidden" id="cnEnFlag" value="${newsRecord.cnEnFlag}">
	<div class="banner">
		<img src="${webRoot}/img/banner.jpg" width="100%">
	</div>
	<div class="breadNav">
		<ul>
			<li><img src="${webRoot}/img/house.png"></li>
			<li>
				<a href="" class="textCN">联信动态  > </a>
				<a href="" class="textEN">Newsletters > </a>
			</li>
			<li>
				<a href='' class="textCN"></a>
				<a href='' class="textEN"></a>				
			</li>
			<li class="currentColor">
				<a class="textCN"></a>
				<a class="textEN"></a>
			</li>
		</ul>
	</div>
	<div class="conentDiv">
		<div class="title-text wow fadeInDown">
			${newsRecord.newsTitle}
		</div>
		<div class="grayBox">
			<ul>
				<li class="borderBox textCN"></li>
				<li class="borderBox textEN"></li>
				<li>${newsRecord.publishTime}</li>
			</ul>
		</div>
		<div class="zhayaobox">
			${newsRecord.summary}
			<div class="fuhao"><img src="${webRoot}/img/f11.png"></div>
			<div class="fuhao2"><img src="${webRoot}/img/f22.png"></div>
		</div>
		<div class="detailBox wow fadeIn">
			${newsRecord.content}
		</div>
	</div>
</div>
<div id="" class="footer">
	<div class="two-all top">
		<ul>
			<li class="left">
				<ul class="leftSmall">
					<li><span class='textCN'>关于我们</span><span class='textEN'>About Us</span></li>
					<li><a><span class='textCN'>企业简介</span><span class='textEN'>Who We Are</span></a></li>
					<li><a><span class='textCN'>企业文化</span><span class='textEN'>Our Culture</span></a></li>
					<li><a><span class='textCN'>发展历程</span><span class='textEN'>History</span></a></li>
					<li><a><span class='textCN'>荣誉资质</span><span class='textEN'>Honor</span></a></li>
					<li><a><span class='textCN'>合作伙伴</span><span class='textEN'>Partners</span></a></li>
				</ul>
				<ul class="leftSmall">
					<li><span class='textCN'>产品服务</span><span class='textEN'>Services</span></li>
					<li><a>征信业务</span><span class='textEN'>Credit Services</span></a></li>
					<li><a>逾期账款管理</span><span class='textEN'>Debt Collection</span></a></li>
					<li><a>联信科技</span><span class='textEN'>Inter-Credit Technology</span></a></li>
				</ul>
				<ul class="leftSmall">
					<li><span class='textCN'>联信动态</span><span class='textEN'>Newsletters</span></li>
					<li><a><span class='textCN'>联信时讯</span><span class='textEN'>Latest News</span></a></li>
					<li><a><span class='textCN'>行业新闻</span><span class='textEN'>Industry News</span></a></li>
					<li><a><span class='textCN'>联信Style</span><span class='textEN'>Latest Style</span></a></li>
					<li><a><span class='textCN'>社会责任</span><span class='textEN'>Social Awareness</span></a></li>
				</ul>
				<ul class="leftSmall">
					<li><span class='textCN'>加入我们</span><span class='textEN'>Join Us</span></li>
					<li><a><span class='textCN'>校园招聘</span><span class='textEN'>Society Recruitment</span></a></li>
					<li><a><span class='textCN'>社会招聘</span><span class='textEN'>Campus Recruitment</span></a></li>
					<li><a><span class='textCN'>储备人才库</span><span class='textEN'>Talents Reserve</span></a></li>
					<li><a><span class='textCN'>联系我们</span><span class='textEN'>Contact</span></a></li>
				</ul>
			</li>
			<li class="middle">
				<ul class="middleL">
					<li><img src='${webRoot}/img/f7.png'></li>
				</ul>
				<ul class="middleR">
					<li><span class='textCN'>咨询电话</span><span class='textEN'>Hotline</span></li>
					<li class="fontRE">
						<ul>
							<li>0532-87487494</li>
							<li class="grayfont"><span class='textCN'>工作日</span><span class='textEN'>Workday</span> 9:00-18:00</li>
						</ul>
					</li>
					<li><span class='textCN'>邮箱</span><span class='textEN'>Email</span></li>
					<li>culture@inter-credit.net</li>
				</ul>
			</li>
			<li class="right">
				<div><img src='${webRoot}/img/f6.png'></div>
				<div><p class='textCN'>公众号</p><p class='textEN'>WeChat Official Account</p> QDlianxin1997</div>
			</li>
		</ul>
	</div>
	<div class="line"></div>
	<div class="footer-all">
		<ul>
			<li><img src='${webRoot}/img/f5.png'></li>
			<li><img src='${webRoot}/img/f1.png'></li>
			<li><img src='${webRoot}/img/f2.png'></li>
			<li><img src='${webRoot}/img/f3.png'></li>
			<li><img src='${webRoot}/img/f4.png'></li>
		</ul>
	</div>
	<div class="footert-bottom textCN">© 2018 青岛联信商务咨询有限公司 版权所有 鲁ICP备06004466号-1</div>
	<div class="footert-bottom textEN">Copyright © 2018 Inter-credit. All rights reserved</div>
</div>

<script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
<script type="text/javascript" src="${webRoot}/js/DD_belatedPNG.js"></script>
<script type="text/javascript" src="${webRoot}/js/header.js"></script>
<script src="${webRoot}/js/plugins/wow/wow.min.js"></script>
<script>
	new WOW().init();
    var val = $('#type').val();
    var obj = $('.breadNav').find('ul li');
    if(val == 0){//联信时讯
    	obj.eq(2).children('.textCN').text('联信时讯>');
    	obj.eq(2).children('.textEN').text('Latest News>');
    	obj.eq(3).children('.textCN').text('时讯详情');
    	obj.eq(3).children('.textEN').text('Newsletter Details');
    	$('.borderBox.textCN').text('联信时讯');
    	$('.borderBox.textEN').text('Latest News');
    }
    else if(val == 1){//行业新闻
    	obj.eq(2).children('.textCN').text('行业新闻>');
    	obj.eq(2).children('.textEN').text('Industry News>');
    	obj.eq(3).children('.textCN').text('新闻详情');
    	obj.eq(3).children('.textEN').text('News Details');
    	$('.borderBox.textCN').text('行业新闻');
    	$('.borderBox.textEN').text('Industry News');
    }
    else if(val == 2){//联信Style
    	obj.eq(2).children('.textCN').text('联信Style>');
    	obj.eq(2).children('.textEN').text('Inter-Credit Style>');
    	obj.eq(3).children('.textCN').text('Style详情');
    	obj.eq(3).children('.textEN').text('Style Details');
    	$('.borderBox.textCN').text('联信Style');
    	$('.borderBox.textEN').text('Style News');
    }
</script>
</body>

</html>