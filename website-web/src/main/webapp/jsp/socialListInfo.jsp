<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
	<%-- 画面的标题 --%>
	<tiles:putAttribute name="pageTitle" value="责任详情"/>
	<%-- 画面主面板 --%>
	<tiles:putAttribute name="mainContentinner" type="string">
		<div class="social">
			<div class="banner">
				<img src="${webRoot}/images/social/banner.jpg" width="100%">
			</div>
			<div class="breadNav">
				<ul>
					<li><img src="${webRoot}/images/companyNew/house.png"></li>
					<li>
						<a href="${webRoot}/system/social/init?isTop=0" class="textCN">社会责任 ></a>
						<a href="${webRoot}/system/social/init?isTop=0" class="textEN">Social Awareness></a>
					</li>
					<li class="currentColor">
						<a class="textCN">责任详情</a>
						<a class="textEN">Awareness Details</a>
					</li>
				</ul>
			</div>
			<div class="conentDiv">
				<div class="title-text wow fadeInDown">
						${record.newsTitle}
				</div>
				<div class="grayBox">
					<ul>
						<li class="borderBox textCN">社会责任</li>
						<li class="borderBox textEN">Social Awareness</li>
						<li>${record.donationTime}</li>
					</ul>
				</div>
				<div class="detailBox wow fadeIn">
						${record.content}
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	<%-- 画面的CSS (ignore) --%>
	<tiles:putAttribute name="pageCss" type="string">
		<link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css" />
		<style type="text/css">
			.social .banner img {
				display: block;
			}

			.social .breadNav {
				border-bottom: 1px solid #dddddd;
				height: 52px;
				box-sizing: border-box;
			}

			.social .breadNav ul {
				width: 60%;
				margin: auto;
			}

			.social .breadNav li {
				float: left;
				font-size: 1.4rem;
				line-height: 52px;
				color: #666666;
				cursor: pointer;
			}

			.social .breadNav li img {
				margin-right: 10px;
			}

			.social .breadNav .currentColor {
				color: #000;
			}

			.social .breadNav .currentColor a {
				cursor: default;
			}

			.social .breadNav ul li:nth-of-type(2) a, .social .breadNav ul li:nth-of-type(3) a {
				color: #666;
			}

			.social .conentDiv {
				width: 60%;
				margin: auto;
			}

			.social .conentDiv img {
				max-width: 100%;
			}

			.social .conentDiv .title-text {
				font-size: 3rem;
				color: #2b2b2f;
				font-weight: bold;
				text-align: center;
				margin-top: 52px;
			}

			.social .conentDiv .grayBox ul {
				overflow: hidden;
				text-align: center;
				color: #adadad;
				width: 210px;
				margin: 20px auto;
			}

			.social .conentDiv .grayBox li {
				float: left;
				line-height: 22px;
				font-size: 1.2rem;
			}

			.social .conentDiv .grayBox .borderBox {
				border: 1px solid #adadad;
				height: 22px;
				text-align: center;
				font-size: 12px;
				color: #adadad;
				width: 96px;
				border-radius: 22px;
				line-height: 22px;
				margin-right: 15px;
			}

			.social .conentDiv .imgbox .imgtext img {
				margin-right: 10px;
			}

			.social .conentDiv .detailBox {
				/* font-size: 1.4rem; */
				color: #2b2b2f;
				padding-bottom: 20px;
			}
		</style>
	</tiles:putAttribute>
	<tiles:putAttribute name="pageJavaScript" type="string">
		<script src="${webRoot}/js/plugins/wow/wow.min.js"></script>
		<script type="text/javascript">
			new WOW().init();
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>