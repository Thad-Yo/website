<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
	<%-- 画面的标题 --%>
	<tiles:putAttribute name="pageTitle" value="联系我们"/>
	<%-- 画面主面板 --%>
	<tiles:putAttribute name="mainContentinner" type="string">
		<div class="contactUs">
			<div class="banner">
				<img src="${webRoot}/images/contactUs/banner.jpg" width="100%">
			</div>
			<!--第一部分  联系方式-->
			<div class="panel1">
				<div class="panel-title">
					<img src="${webRoot}/images/contactUs/contact.png">
				</div>
				<div class="panel-text">青岛总部联系方式</div>
				<div class="panel-content">
					<div class="panel-contact1 wow fadeInLeft">
						<img src="${webRoot}/images/contactUs/contact1.png"/>
						<div class="panel-infor panel-infor1">
							<p class="textCN">总部地址</p>
							<p class="panel-line textCN"></p>
							<p class="textCN" style="padding: 20px 10px;line-height: 22px;">山东省青岛市市南区中山路44-60号百盛商务中心18楼</p>
							<p class="textEN">Addr</p>
							<p class="panel-line textEN"></p>
							<p class="textEN" style="padding: 20px 10px;line-height: 22px;">Parkson international business center 18th floor, 44-60# zhong shan road, Qingdao, Shandong</p>
						</div>
					</div>
					<div class="panel-contact2 wow fadeInUp">
						<img style="filter:alpha(opacity:30);opacity:0.3; -moz-opacity:0.3;-khtml-opacity: 0.3;" src="${webRoot}/images/contactUs/contact2.png"/>
						<div class="panel-infor panel-infor2">
							<p class="textCN">科技子公司</p>
							<p class="panel-line textCN"></p>
							<p class="textCN" style="margin-left: -76px;margin-top: 20px;">电话：0532-82023835</p>
							<p class="textCN">邮箱：caoliying@lianxin-tech.com</p>
							<p class="textEN">Inter-Credit Technology</p>
							<p class="panel-line textEN"></p>
							<p class="textEN" style="margin-top: 25px;">Tel：0532-82023835</p>
							<p class="textEN">Email：caoliying@lianxin-tech.com</p>
						</div>
					</div>
					<div class="panel-contact3 wow flipInX">
						<img src="${webRoot}/images/contactUs/contact3.png"/>
						<div class="panel-infor panel-infor3">
							<p class="textCN">联系电话</p>
							<p class="panel-line textCN"></p>
							<p class="textCN" style="margin-top: 20px;">国内市场：0532-82023560</p>
							<p class="textCN">国际市场：0532-82870539</p>
							<p class="textCN" style="margin-left: -12px;">认证部：0532-82870738</p>
							<%--<p class="textCN">人力部：0532-82023159</p>--%>
							<%--<p class="textCN" style="margin-left: -12px;">技术部：0532-82023571</p>
							<p class="textCN" style="margin-left: -12px;">传&nbsp;&nbsp;&nbsp;真：0532-82023863</p>--%>
							<p class="textCN">投诉电话：0532-82022612</p>
							<p class="textEN">Tel.</p>
							<p class="panel-line textEN"></p>
							<p class="textEN" style="margin-top: 25px;">Credit Service：86-532-82870738</p>
							<p class="textEN">Domestic Market：86-532-82023560</p>
							<p class="textEN">International Market：86-532-82870539</p>
								<%--<p class="textEN" style="margin-left: -65px;">HR：86-532-82023159</p>--%>
								<%--<p class="textEN">Internet Technology：86-532-82023571</p>--%>
							<p class="textEN">Hotline：86-532-82881676</p>
                            </div>
                        </div>
                        <div class="panel-contact4 wow fadeInDown">
                            <img src="${webRoot}/images/contactUs/contact4.png"/>
                            <div class="panel-infor panel-infor4">
                                <p class="textCN">邮箱</p>
                                <p class="panel-line textCN"></p>
                                <p class="textCN" style="margin-left: -24px;margin-top: 30px;">国内市场：lianxin@inter-credit.net</p>
                                <p class="textCN" style="margin-left: -24px">国际市场：service@inter-credit.net</p>
                                <%--<p class="textCN" style="margin-left: -10px;">人力部：hr.zyl@inter-credit.net</p>--%>
								<%--<p class="textCN" style="margin-left: -22px;">技术部：yuxin@inter-credit.net</p>--%>
								<p class="textCN" style="margin-left: -10px">业务投诉：complain@inter-credit.net</p>
								<p class="textCN">员工投诉：suggestion@inter-credit.net</p>
							<p class="textEN">Email</p>
							<p class="panel-line textEN"></p>
							<p class="textEN" style="margin: 20px auto 2px -38px;">Domestic Market:</p>
							<p class="textEN" style="margin-bottom: 15px;">lianxin@inter-credit.net</p>
							<p class="textEN" style="margin: 0 auto 2px -16px;">International Market:</p>
							<p class="textEN" style="margin-bottom: 15px;">service@inter-credit.net</p>
							<%--<p class="textEN" style="margin-left: -75px;">HR：hr.zyl@inter-credit.net</p>--%>
							<%--<p class="textEN" style="margin: 0 auto 2px -17px;">Internet Technology:</p>
							<p class="textEN" style="margin-left: -5px;">yuxin@inter-credit.net</p>--%>
							<p class="textEN" style="margin: 0 auto 2px -16px;">Business Complaints:</p>
							<p class="textEN" style="margin-bottom: 15px;">&nbsp;&nbsp;&nbsp;&nbsp;complain@inter-credit.net</p>
						</div>
					</div>
					<div class="panel-contact5 wow fadeInRight">
						<img src="${webRoot}/images/contactUs/contact5.png"/>
						<div class="panel-infor panel-infor5">
							<p class="textCN">关注微信</p>
							<p class="textEN">WeChat Official Account</p>
							<img src="${webRoot}/images/contactUs/erwm.png"/>
							<p class="textCN">公众号  QDlianxin1997</p>
							<p class="textEN">QDlianxin1997</p>
						</div>
					</div>
				</div>
			</div>
			<!--第二部分 地图分布-->
			<section class="panel-map">
				<div class="section-body">
					<div class="section-title">
						<p class="section-title-EN">Branch recruitment call</p>
						<p class="section-title-CN">分公司招聘电话</p>
					</div>
					<div class="map-box">
						<div class="panel-search">
							<img src="${webRoot}/images/contactUs/position.png"/>
							<select name="province" id="panel-select">
								<option value="0" class="textCN">请选择省市区/ Search Provinces</option>
								<c:forEach items="${recordList}" var="record" begin="0" step="1" varStatus="status">
									<option value="${record.province}">${record.shorthand}</option>
								</c:forEach>
							</select>
							<button id="panel-btn">
								<span class="textCN">查询</span>
								<span class="textEN">Search</span>
							</button>
						</div>
						<div id="mapMain"></div>
					</div>
				</div>
			</section>
			<!--第三部分  意见建议-->
			<div class="panel-suggestions">
				<div class="panel3">
					<div class="panel-title">
						<img src="${webRoot}/images/contactUs/text3.png">
					</div>
					<div class="panel-text">意见与建议</div>
					<div class="suggestionsInfor">
						<ul>
							<li>
								<div class="liLine"></div>
								<i class="iconfont icon-name"></i>
								<input type="text" class="textCN" id="NameCN" placeholder="姓名(必填)"/>
								<input type="text" class="textEN" id="NameEN" placeholder="Name(Required)"/>
							</li>
							<li>
								<div class="liLine"></div>
								<i class="iconfont icon-shouji"></i>
								<input type="tel" class="textCN" id="TelephoneCN" placeholder="电话(必填)" maxlength="11"/>
								<input type="tel" class="textEN" id="TelephoneEN" placeholder="Telephone(Required)" maxlength="50"/>
							</li>
							<li>
								<div class="liLine"></div>
								<i class="iconfont icon-youxiang"></i>
								<input type="email" class="textCN" id="EmailCN" placeholder="邮箱"/>
								<input type="email" class="textEN" id="EmailEN" placeholder="Email"/>
							</li>
						</ul>
					</div>
					<div class="suggestionsContent">
						<textarea class="textCN" name="content" id="contentCN" placeholder="其他说明"></textarea>
						<textarea class="textEN" name="content" id="contentEN" placeholder="Your Suggestions"></textarea>
					</div>
					<div class="suggestionsBtn">
						<button id="sendBtn">
							<span class="textCN">发送您的建议</span>
							<span class="textEN">SEND</span>
						</button>
                        <div>
                            <p class="resetCN">*请填写姓名！</p>
                            <p class="resetCNPhone">*请填写11位手机号码！</p>
                            <p class="resetCNSuggest">*请填写意见与建议，且长度小于1000个字符或500个字！</p>
                            <p class="successCN">*发送成功</p>
                            <p class="resetEN">*Please fill in your name!</p>
                            <p class="resetENPhone">*Please fill in your telephone!</p>
                            <p class="resetENSuggest">*Please fill in comments and suggestions and the length is less than 1000 characters!</p>
                            <p class="successEN">*Sent Successfully</p>
                        </div>
					</div>
				</div>
			</div>
			<!--第四部分 地图-->
			<div id="container"></div>
			<input type="hidden" name="en" id="zh_en" value="english" />



		</div>
		<!--意见和建议弹框-->
		<div class="maskBox">
		</div>
	</tiles:putAttribute>
	<%-- 画面的CSS (ignore) --%>
	<tiles:putAttribute name="pageCss" type="string">
		<link rel="stylesheet" href="${webRoot}/css/contactUs.css?${now}" />
		<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main.css?v=1.0?v=1.0" />
		<link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css" />
		<style type="text/css">
			.suggestionsContent  input, .suggestionsContent textarea {
				font-family: 'Microsoft YaHei';
				font-size: 1.4rem;
			}
		</style>
	</tiles:putAttribute>
	<tiles:putAttribute name="pageJavaScript" type="string">
		<script type="text/javascript" src="http://cache.amap.com/lbs/static/es5.min.js"></script>
		<script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
		<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=46ca1d10942508d4fa6d446f989f6a6e"></script>
		<script type="text/javascript" src="${webRoot}/js/DD_belatedPNG.min.js"></script>
		<script src="${webRoot}/js/plugins/wow/wow.min.js"></script>
		<script src="${webRoot}/js/contact/echarts.js"></script>
		<script src="${webRoot}/js/contactUs.js?${now}"></script>
		<script type="text/javascript">
			new WOW().init();
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>

