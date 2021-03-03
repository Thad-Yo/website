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
		<title>关于我们-荣誉资质</title>
		<link rel="icon" href="${webRoot}/images/favicon.ico" type="image/x-icon">
		<link rel="shortcut icon" href="${webRoot}/images/favicon.ico" type="image/x-icon">
		<link rel="stylesheet" href="${webRoot}/css/index.css" />
		<link rel="stylesheet" href="${webRoot}/css/header.css" />
		<link rel="stylesheet" href="${webRoot}/js/plugins/swiper/css/swiper.min.css" />
		<link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css" />
	</head>

	<body>
		<script src="${webRoot}/js/headerHtml.js"></script>
		
		<div class="aboutHonor">
			<div class="banner">
				<img src="${webRoot}/images/aboutUs/banner.jpg" width="100%">
			</div>
			<div class="breadNav">
				<ul>
					<li><img src="${webRoot}/images/companyNew/house.png"></li>
					<li>
						<a href="${webRoot}/system/aboutUs/init" class="textCN">关于我们 > </a>
						<a href="${webRoot}/system/aboutUs/init" class="textEN">About Us > </a>
					</li>
					<li>
						<a href="${webRoot}/system/aboutUs/init#main-six" class="textCN">荣誉资质> </a>
						<a href="${webRoot}/system/aboutUs/init#main-six" class="textEN">Honor > </a>				
					</li>
					<li class="currentColor">
						<a class="textCN">资质详情 </a>
						<a class="textEN">Qualification Details</a>
					</li>
					<input type="hidden" id="year" value="${year }" />
				</ul>
			</div>
			<div class="timeLine">
				<div class="currentBox">
					<div class="swiper-container gallery-thumbs">
						<div class="swiper-wrapper">
						<c:forEach var="mymap" items="${websiteHonorMap}" varStatus="status1">
							<div class="swiper-slide">${mymap.key }</div>
						</c:forEach>
						</div>
						<!-- Add Arrows -->
						<div class="swiperBtn swiper-button-next "></div>
						<div class="swiperBtn swiper-button-prev "></div>
					</div>
				</div>
			</div>

			<!--列表显示-->
			<c:forEach var="mymap" items="${websiteHonorMap}" varStatus="status1">
			<div class="listDiv">
				<c:forEach var="websiteHonor" items="${mymap.value}" varStatus="status1">
				<div class="listone">
					<div class="listL wow fadeInLeft">
						<div class="dateBox">
							<div class="DayBox">${fn:substring(websiteHonor.honorNumber, 8, 10)}</div>
							<div class="monthDiv">
								<c:choose>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '01'}">
								        Jan
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '02'}">
								        Feb
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '03'}">
								        Mar
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '04'}">
								        Apr
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '05'}">
								        May
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '06'}">
								        Jun
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '07'}">
								        Jul
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '08'}">
								        Aug
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '09'}">
								        Sep
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '10'}">
								        Oct
								    </c:when>
								    <c:when test="${fn:substring(websiteHonor.honorNumber, 5, 7) == '11'}">
								        Nov
								    </c:when>
								    <c:otherwise>
								        Dec
								    </c:otherwise>
								</c:choose>
							</div>
							<!-- <div class="line"></div> -->
						</div>
					</div>
					<div class="listR wow fadeInRight">
						<div class="rightAll">
							<div class="allLeft"><img src="${imgServer}${websiteHonor.imgAddress}" width="100%"></div>
							<div class="allRight">
								<div class="titleBox">${websiteHonor.honorName}</div>
								<div class="line"></div>
								<div class="detailText">${websiteHonor.honorDetails}</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			</c:forEach>
		</div>
		<script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
		<script src="${webRoot}/js/common.min.js"></script>
		<script src="${webRoot}/js/footer.js"></script>
		<script type="text/javascript" src="${webRoot}/js/DD_belatedPNG.min.js"></script>

		<script src="${webRoot}/js/plugins/wow/wow.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/header.js"></script>
	</body>
	<script>
		new WOW().init();
	</script>
	<script>
		window.onload = function(){
			var wrapperW = $('.swiper-wrapper').width();
			var slideW = $('.swiper-slide').eq(0).width();
			var slateW = null;
			var year = $('#year').val();
			var index = null;
			var slideObj = $('.gallery-thumbs .swiper-wrapper .swiper-slide');
			slideObj.each(function(){
				if($(this).text() == year){
					index = $(this).index();
					slateW = (wrapperW - slideW) / 2 - slideW * index;
					slate(slateW);
				};
			});
			$('.gallery-thumbs .swiper-button-next').on('click',function(){
				index++;
				slateW = (wrapperW - slideW) / 2 - slideW * index;
				slate(slateW);
			});
			$('.gallery-thumbs .swiper-button-prev').on('click',function(){
				index--;
				slateW = (wrapperW - slideW) / 2 - slideW * index;
				slate(slateW);
			});
			function slate(num){
				$('.swiper-wrapper').css({
					'transition-duration':'300ms',
					'transform':'translate3d('+num+'px, 0px, 0px)'
				});
				slideObj.eq(index).addClass('swiper-slide-active').siblings().removeClass('swiper-slide-active');
				$('.listDiv').eq(index).show().siblings('.listDiv').hide();
				if(index == slideObj.length - 1){
					$('.swiper-button-next').addClass('swiper-button-disabled');
					$('.swiper-button-prev').removeClass('swiper-button-disabled');
				}
				else if(index == 0){
					$('.swiper-button-next').removeClass('swiper-button-disabled');
					$('.swiper-button-prev').addClass('swiper-button-disabled');
				}
				else{
					$('.swiperBtn').removeClass('swiper-button-disabled');
				}
				new WOW().init();
			}
		};
		
		$(".listone").hover(function() {
			$(this).find(".titleBox").css("color", "#b90b2c");
			$(this).find(".dateBox").css("background","#b90b2c");
			$(this).find(".DayBox").css("color","white");
			$(this).find(".monthDiv").css("color","white");
			
		}, function() {
			$(this).find(".titleBox").css("color", "#000");
			$(this).find(".dateBox").css("background","white");
			$(this).find(".DayBox").css("color","#000000");
			$(this).find(".monthDiv").css("color","#999999");
		});
	</script>

</html>