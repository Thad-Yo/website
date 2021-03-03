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
		<title>关于我们</title>
		<link rel="icon" href="${webRoot}/images/favicon.ico" type="image/x-icon">
		<link rel="shortcut icon" href="${webRoot}/images/favicon.ico" type="image/x-icon">
		<link rel="stylesheet" href="${webRoot}/css/index.css" />
		<link rel="stylesheet" href="${webRoot}/css/scroll.css" />
		<link rel="stylesheet" href="${webRoot}/css/iconfont.css" />
		<link rel="stylesheet" href="${webRoot}/css/header.css" />
		<link rel="stylesheet" href="${webRoot}/js/plugins/swiper/css/swiper.min.css" />
		<link rel="stylesheet" href="${webRoot}/js/plugins/mCustomScrollbar/jquery.mCustomScrollbar.css" />
		<script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
	</head>

	<body>
		<script src="${webRoot}/js/headerHtml.js"></script>
		<div class="aboutusPage">
			<ul class="nav-ul">
				<li>
					<a href="#main-two" title="" class="active"></a>
					<p class="textDisCN">集团简介</p>
					<p class="textDisEN">Company Profile</p>
				</li>
				<li>
					<a href="#main-three" title=""></a>
					<p class="textDisCN">企业规模变化</p>
					<p class="textDisEN">Enterprise Scale</p>
				</li>
				<li>
					<a href="#main-four" title=""></a>
					<p class="textDisCN">企业文化</p>
					<p class="textDisEN">Our Culture</p>
				</li>
				<li>
					<a href="#main-five" title=""></a>
					<p class="textDisCN">发展历程</p>
					<p class="textDisEN">History</p>
				</li>
				<li>
					<a href="#main-six" title=""></a>
					<p class="textDisCN">荣誉资质</p>
					<p class="textDisEN">Honor</p>
				</li>
				<li>
					<a href="#main-seven" title=""></a>
					<p class="textDisCN">合作伙伴</p>
					<p class="textDisEN">Partness</p>
				</li>
			</ul>
			<div class="index-main">
				<div id="main-one" class="section1">
					<div class="banner">
						<img src="${webRoot}/images/aboutUs/banner.jpg" width="100%">
					</div>
				</div>
				<div id="main-two" class="section section2">
					<div class="panel1">
						<div class="panel-img"><img src="${webRoot}/images/aboutUsAll/text1.png"></div>
						<div class="panel-tite">集团简介</div>
						${websiteIntroduce.introduce }
						<div class="img-group"><img src="${webRoot}/images/aboutUsAll/text.png"></div>
					</div>

				</div>
				<div id="main-three" class="section section3">
					<div class="pane3">
						<div class="panel-img"><img src="${webRoot}/images/aboutUsAll/text6.png"></div>
						<div class="panel-tite">企业规模变化</div>
						<div class="panel-all">
							<div id="container" style="height: 100%; height: 460px;"></div>
						</div>
					</div>

				</div>
				<div id="main-four" class="section section4">
					<div class="bototmbg"></div>
					<div class="panel4">
						<div class="panel-img"><img src="${webRoot}/images/aboutUsAll/corporate.png"></div>
						<div class="panel-tite">企业文化</div>
					</div>
					<div class="group-all">
						<div class="group-one  one1">
							<div class="top">
								<div class="topText">
									<img src="${webRoot}/images/aboutUsAll/group1.png">
									<p class="textCN">企业愿景</p>
									<p class="textEN">Company Vision</p>
								</div>
							</div>
							<div class="bottom">
								<div class="bottom-text textCN">
									联信助力风控 <br> 为金融体系保驾护航
								</div>
								<div class="bottom-text bottom-textEN textEN">
									Company Vision: Inter-credit helps our client to build up risk control and to convoy the financial system
								</div>
								<div class="bottom-arrow"><img src="${webRoot}/images/aboutUsAll/arrowbg.png"></div>

							</div>
						</div>
						<div class="group-one one2">
							<div class="top">
								<div class="topText">
									<img src="${webRoot}/images/aboutUsAll/group2.png">
									<p class="textCN">企业文化</p>
									<p class="textEN">Company Culture</p>
								</div>
							</div>
							<div class="bottom">
								<div class="bottom-text textCN">
									人性化强势企业
								</div>
								<div class="bottom-text bottom-textEN textEN">
									Company Culture: a people oriented and progressive enterprise
								</div>
								<div class="bottom-arrow"><img src="${webRoot}/images/aboutUsAll/arrowbg.png"></div>

							</div>
						</div>
						<div class="group-one one3">
							<div class="top">
								<div class="topText">
									<img src="${webRoot}/images/aboutUsAll/group3.png">
									<p class="textCN">业务定位</p>
									<p class="textEN">Business Orientation</p>
								</div>
							</div>
							<div class="bottom">
								<div class="bottom-text textCN">
									金融服务体系的延伸
								</div>
								<div class="bottom-text bottom-textEN textEN">
									Business Orientation: extension of the financial services system
								</div>
								<div class="bottom-arrow"><img src="${webRoot}/images/aboutUsAll/arrowbg.png"></div>

							</div>
						</div>
						<div class="group-one one4">
							<div class="top">
								<div class="topText">
									<img src="${webRoot}/images/aboutUsAll/group4.png">
									<p class="textCN">使命宣言</p>
									<p class="textEN">Mission Statement</p>
								</div>
							</div>
							<div class="bottom">
								<div class="bottom-text textCN">像管理自己的资产一样管理客户的资产</div>
								<div class="bottom-text bottom-textEN textEN">
									Manage the assets of the customer like managing our own assets
								</div>
								<div class="bottom-arrow"><img src="${webRoot}/images/aboutUsAll/arrowbg.png"></div>

							</div>
							<div class="group-hide2 group-hideCN hide">
								像管理自己的资产一样管理客户的资产<br/> 创造积极、放松、注意力高度集中的工作氛围<br/> 致力于个人高效率，公司高效率；个人高效益，公司高效益<br/> 工作中秉持较高的职业道德和人文精神
							</div>
							<div class="group-hide2 hide">
								Manage the assets of the customer like managing our own assets
								Create a positive, relaxed, and highly focused work environment
								Committed to improve work efficiency and economic benefit
								Adhere to a high level of professional ethics and humanism
							</div>
						</div>
					</div>
				</div>
				<div id="main-five" class="section section5">
					<div class="panel-img"><img src="${webRoot}/images/aboutUsAll/history.png"></div>
					<div class="panel-tite">发展历程</div>
					<div class="swiper-all">
						<div class="swiper-btn">
							<!-- Add Pagination -->
							<div class="swiper-button-next"></div>
							<div class="swiper-button-prev"></div>
						</div>
						<div class="swiper-top">
							<div class="swiper-container swiper3">
								<div class="swiper-wrapper">
							<c:forEach var="mymap" items="${mapList}" begin="0" step="1" varStatus="status">
									<div class="swiper-slide">
										<div class="swiper-year">
											<div class="num-text">${fn:substring(mymap.key, 0, 4)}</div>
											<input type="hidden" class="year-index" value="${fn:substring(mymap.key, 4, 5)}" />
											<div class="year-text">YEAR</div>
										</div>
									</div>
							</c:forEach>
								</div>
							</div>
						</div>
						<div class="swiper-bottom">
						<c:forEach var="mymap" items="${mapList}" varStatus="status1">
							<div class="swiper-container swiper2">
								<div class="swiper-wrapper">
								<c:forEach var="websiteDev" items="${mymap.value}" varStatus="status2">
									<div class="swiper-slide">
										<div class="swiper-line">
											<div class="swiper-left">
												<div class="swiper-red">${fn:substring(websiteDev.devDate, 0, 4)}</div>
												<div class="swiper-gray">${fn:substring(websiteDev.devDate, 5, 7)}${fn:substring(websiteDev.devDate, 8, 10)}</div>
											</div>
											<div class="swiper-right">
												<div class="swiper-title">${websiteDev.devTitle }</div>
												<div class="swiper-details"><p>${websiteDev.devText }</p></div>
												<div class="swiper-circle"></div>
												<div class="swiper-border"></div>
											</div>
										</div>
									</div>
								</c:forEach>
								</div>
								<!-- Add Pagination -->
								<div class="swiper-button-next"></div>
								<div class="swiper-button-prev"></div>
							</div>
						</c:forEach>
						</div>
					</div>
				</div>
				<div id="main-six" class="section section6">
					<div class="two-all">
						<div class="two-title" style="padding-top: 30px;"><img src="${webRoot}/images/aboutUsAll/text4.png"></div>
						<div class="two-text">荣誉资质</div>

					</div>
					<div class="two-all">
						<div class="swiper-container swiper4">
							<div class="swiper-wrapper">
					<c:forEach var="mymap" items="${websiteHonorMap}" varStatus="status1">
								<div class="swiper-slide">
									<div class="swiper-all">
										<div class="swiper-c"></div>
										<div class="content swiper-small">
									<c:forEach var="websiteHonor" items="${mymap.value}" varStatus="status1">
											<div class="topText">
												<div class="line-title">${fn:substring(websiteHonor.honorNumber, 5, 7)}月${fn:substring(websiteHonor.honorNumber, 8, 10)}日</div>
												<div class="line-details">${websiteHonor.honorDetails}</div>
											</div>
									</c:forEach>
										</div>
										<div class="swiper-check">
											<a href="${webRoot}/system/aboutUs/websiteHonorDetail?yearInput=${mymap.key }" class="check-button">
												<i class="iconfont icon-goRight"></i>
												<span class="textCN">查看详情</span>
												<span class="textEN">View Details</span>
											</a>
										</div>
									</div>
									<div class="textYear">${mymap.key }</div>
								</div>
					</c:forEach>
							</div>
						</div>
						<div class="swiper-button-next"></div>
						<!--<div class="swiper-button-prev"></div>-->
					</div>
				</div>
				<div id="main-seven" class="section section7">
					<div class="two-all">
						<div class="two-title"><img src="${webRoot}/images/index/partners.png"></div>
						<div class="two-text">合作伙伴</div>
					</div>
					<div class="two-all">
						<div class="box">
							<span class="prev">
								<i class="iconfont icon-leftarrow"></i>
							</span>
							<div>
								<dl id="roll">
									<c:forEach items="${attachmentRecord}" var="attachment" begin="0" step="1" varStatus="attStatus">
										<dd>
											<c:forEach items="${attachment.ctAttachmentList}" var="partners" begin="0" step="1" varStatus="status">
												<a><img src="${webRoot}${partners.savePath}" alt="${partners.fileName }"></a>
											</c:forEach>
										</dd>
									</c:forEach>
								</dl>
							</div>
							<span class="next">
								<i class="iconfont icon-rightarrow"></i>
							</span>
						</div>	
					</div>
				</div>
			</div>

		</div>
		<div class="backTop">
			<i class="iconfont icon-boshiweb_zhiding"></i>
		</div>
		<script src="${webRoot}/js/footer.js"></script>
		
		<script type="text/javascript" src="${webRoot}/js/plugins/swiper/js/swiper.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/plugins/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
		<script src="${webRoot}/js/common.min.js"></script>
		<script src="${webRoot}/js/plugins/echarts/echarts.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/DD_belatedPNG.min.js"></script>

		<script type="text/javascript" src="${webRoot}/js/aboutUs.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/super_slider.js"></script>
		<script type="text/javascript" src="${webRoot}/js/header.js"></script>
		<script type="text/javascript">

			var year= [];
			var fgsCount= [];
			var khCount= [];
			var ryCount= [];
			<c:forEach var="websiteScope" items="${websiteScopeList}" begin="0" step="1" varStatus="status">
				year.push("${websiteScope.year}");
				fgsCount.push("${websiteScope.fgsCount}");
				khCount.push("${websiteScope.khCount}");
				ryCount.push("${websiteScope.ryCount}");
			</c:forEach>
			var data = [];
		    redisFlag = cookie.get("redisFlag");
			var dataTitle = [];
			var danweiX,danweiY;
			if(redisFlag == undefined){
				redisFlag = 0;
			}
			if(redisFlag == '0'){ 
				danweiX = '年';
				danweiY = '数量';
				dataTitle = ['分支机构数', '客户数', '人员数'];
				data = [{
						name: '分支机构数',
						type: 'bar',
						data: fgsCount,
						barWidth:20,
						itemStyle: {
							normal: {
								color: '#ffffff'
							}
						}
					},
					{
						name: '客户数',
						type: 'bar',
						data: khCount,
						barWidth:20,
						itemStyle: {
							normal: {
								color: '#950000'
							}
						}
					},
					{
						name: '人员数',
						type: 'line',
						data: ryCount,
						itemStyle: {
							normal: {
								lineStyle: {
									width: 2,
									type: 'dotted' //'dotted'虚线 'solid'实线
								}
							}
	
						}
	
					}]
			 }
			else if(redisFlag == '1'){
				dataTitle = ['Number of branches', 'Number of customers', 'Number of people'];
				data = [{
					name: 'Number of branches',
					type: 'bar',
					data: fgsCount,
					barWidth:20,
					itemStyle: {
						normal: {
							color: '#ffffff'
						}
					}
				},
				{
					name: 'Number of customers',
					type: 'bar',
					data: khCount,
					barWidth:20,
					itemStyle: {
						normal: {
							color: '#950000'
						}
					}
				},
				{
					name: 'Number of people',
					type: 'line',
					data: ryCount,
					itemStyle: {
						normal: {
							lineStyle: {
								width: 2,
								type: 'dotted' //'dotted'虚线 'solid'实线
							}
						}

					}

				}]
			} 
			var dom = document.getElementById("container");
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			option = {
				title: {
					text: '',
					subtext: ''
				},
				tooltip: {
					trigger: 'axis'
				},
				legend: {
					data: dataTitle,
					textStyle: { //图例文字的样式
						color: '#ffffff',
						fontSize: 12
					},
					bottom: 0
				},
				calculable: true,
				xAxis: [{
					name:danweiX,
					type: 'category',
					data: year,
					axisLine: {
						lineStyle: {
							type: 'solid',
							color: '#3a3e46',
							width: '1'
						}
					},
					axisLabel: {
						textStyle: {
							color: '#fff'
						}
					},
					nameTextStyle:{
						color:'#fff',
						fontSize:14
					}
				}],
				yAxis: [{
					name:danweiY,
					type: 'value',
					splitLine: {
						show: true,
						lineStyle: {
							color: ['#727478'],
							type: 'dashed'
						},
					}, //去除网格线
					axisLine: {
						lineStyle: {
							type: 'solid',
							color: '#3a3e46',
							width: '1'
						}
					},
					axisLabel: {
						textStyle: {
							color: '#fff'
						}
					},
					nameTextStyle:{
						color:'#fff',
						fontSize:14
					}
				}],
				series: data
			};

			if(option && typeof option === "object") {
				myChart.setOption(option, true);
			}
		</script>
	</body>

</html>