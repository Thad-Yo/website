<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit"/>
	<meta name="force-rendering" content="webkit"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<script>
		/*@cc_on window.location.href="http://support.dmeng.net/upgrade-your-browser.html?referrer="+encodeURIComponent(window.location.href); @*/
	</script>
	<title>产品服务</title>
	<link rel="icon" href="${webRoot}/images/favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="${webRoot}/images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="${webRoot}/css/credit.min.css" />
	<link rel="stylesheet" href="${webRoot}/css/header.css" />
	<link rel="stylesheet" href="${webRoot}/css/iconfont.css" />
	<link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css" />
	<link rel="stylesheet" href="${webRoot}/js/plugins/cssmap-continents/cssmap-continents.css" />
</head>
<body>
	<script src="${webRoot}/js/headerHtml.js"></script>
	<div class="credit">
	<input type="hidden" id="yqType" value="${yqType }"/>
	<input type="hidden" id="proType" value="${proType }"/>
		<div class="banner">
			<img src="${webRoot}/images/credit/banner.jpg" width="100%">
			<div class="banner-tab">
				<ul>
					<li>
						<img src="${webRoot}/images/credit/tab1.png"/>
						<div class="banner-tabCon">
							<p class="tabCN">征信业务</p>
							<p class="tabEN">Credit Services</p>
						</div>
					</li>
					<li>
						<img src="${webRoot}/images/credit/tab2.png"/>
						<div class="banner-tabCon">
							<p class="tabCN">逾期账款管理</p>
							<p class="tabEN">Debt Collection</p>
						</div>
					</li>
					<%-- <li>
						<img src="${webRoot}/images/credit/tab3.png"/>
						<a class="lianxinTech" href="http://www.lianxin-tech.com/" target="_blank">
							<div class="banner-tabCon">
								<p class="tabCN">联信科技</p>
								<p class="tabEN">Inter-Credit Tech</p>
							</div>
						</a>
					</li> --%>
				</ul>
			</div>
		</div>
		
		
		<!-- 征信业务 开始 -->
		<div class="creditAll creditOne">
			<!--第一部分-->
			<ul class="nav-ul">
				<li>
					<a href="#main-one" title="" class="active"></a>
					<p class="textDisCN">国内外企业信息服务</p>
					<p class="textDisEN">Enterprise Information Service</p>
				</li>
				<li>
					<a href="#main-two" title=""></a>
					<p class="textDisCN">国内外尽职调查</p>
					<p class="textDisEN">Due Diligence</p>
				</li>
				<li>
					<a href="#main-three" title=""></a>
					<p class="textDisCN">征信业务优势</p>
					<p class="textDisEN">Credit Services Advantage</p>
				</li>
			</ul>
			<div class="section1 panel1" id="main-one">
				<div class="panel-title">
					<img src="${webRoot}/images/credit/text1.png">
				</div>
				<div class="panel-text">国内外企业信息服务</div>
				<div class="companyTab">
					<ul>
						<li class="active">
							<span class="textCN">国内外企业征信报告</span>
							<span class="textEN">Enterprise Credit Report</span>
							<div></div>
						</li>
						<li>
							<span class="textCN">企业信息认证</span>
							<span class="textEN">Information Authentication</span>
							<div></div>
						</li>
						<li>
							<span class="textCN">企业信息系统</span>
							<span class="textEN">Information System</span>
							<div></div>
						</li>
					</ul>
				</div>
				<div class="companyTabCon">
					<div class="companyTabCon-first" style="text-align:center;">
						<p class="textCN"><span>企业信用调查报告</span> 是在深入探究公司的经营发展状况和财务成果基础之上，结合股东及领导人的背景，对企业进行了信用评级，使您准确掌握竞争对手、合作伙伴、目标客户的信息情报，提前制定应对措施，主动调整合作方式，确保您在赚取最大利润的同时，尽可能地规避风险。</p>
						<p class="textEN">Credit investigation report is the credit rating for enterprise which is based on investigation of its operation and financial, combined with the background of the enterprise’s shareholders and leaders. A credit report is used to reduce business risks which improve profitability through getting the accurate information about the information of your competitors, partners, and target customers so as to response in advance and adjust cooperation initiatively. </p>
					</div>
					<div class="companyTabCon-second" style="text-align:center;">
						<p class="textCN">通过多方数据核实企业相关资质，对相关资料的完整性、有效性、合规性、清晰性严格质检，综合分析，把控风险，确保其满足特定的要求。 </p>
						<p class="textEN">Using multiparty data to verify the related qualifications of enterprises and using strict quality inspection to ensure the completeness, validity, compliance and clarity of related information. The comprehensive analysis and risks control ensure that our services can meet your specific requirements.</p>
					</div>
					<div class="companyTabCon-third">
						<img src="${webRoot}/images/credit/typeTab.png" alt="" />
						<div class="companyTabCon-btn">
							<a href="http://www.bcr.inter-credit.net" target="_blank" style="display: inline-block;">
								<button type="button">
									<i class="iconfont icon-icon"></i>
										<span class="textCN">友情链接</span>
										<span class="textEN">Link</span>
								</button>
							</a>	
						</div>
					</div>
				</div>
			</div>
			<div class="panel-all">
				<div class="panel-report">
					<div class="panel-position">
						<div class="reportRight-title textCN">
							国内企业征信报告
						</div>
						<div class="reportRight-title textEN">
							Chinese Credit Reports
						</div>
						<ul class="textCN">
							<li>
								<img src="${webRoot}/images/credit/panel1-con1.png"/>
								<p>基本信息报告</p>
							</li>
							<li class="liLine"></li>
							<li>
								<img src="${webRoot}/images/credit/panel1-con2.png"/>
								<p>商业信息报告</p>
							</li>
							<li class="liLine"></li>
							<li>
								<img src="${webRoot}/images/credit/panel1-con3.png"/>
								<p>信用分析报告</p>
							</li>
						</ul>
						<ul class="textEN">
							<li>
								<img src="${webRoot}/images/credit/panel1-con1.png"/>
								<p>Registration Reports</p>
							</li>
							<li class="liLine"></li>
							<li>
								<img src="${webRoot}/images/credit/panel1-con2.png"/>
								<p>Business Information Reports</p>
							</li>
							<li class="liLine"></li>
							<li>
								<img src="${webRoot}/images/credit/panel1-con3.png"/>
								<p>Credit Risk Analysis Reports</p>
							</li>
						</ul>
					</div>
					<div class="reportLeft">
		
					</div>
					<div class="reportRight">
						<div class="reportRight-title textCN">
							国外企业征信报告
						</div>
						<div class="reportRight-title textEN">
							International Credit Reports
						</div>
						<div class="reportRight-con textCN">
							<img src="${webRoot}/images/credit/panel1-con4.png"/>
							<p>国外企业征信报告</p>
						</div>
						<div class="reportRight-con textEN">
							<img src="${webRoot}/images/credit/panel1-con4.png"/>
							<p>International Credit Reports</p>
						</div>
					</div>
				</div>
				<!--第二部分-->
				<div class="section1 panel2" id="main-two">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text2.png">
					</div>
					<div class="panel-text" style="padding-bottom:20px;">国内外尽职调查</div>
					<div class="panel2-content">
						<div class="panel2-infor textCN">
							通过近20年的企业征信经验核实目标公司的信息并进行专业化分析；全国各省、地区的网点分布；
							以及遍布全球的合作伙伴；自主研发的应用程序；专业的在线审核团队，可以及时有效的完成现场取证
							、实地征信、贷前和贷后调查的业务。为客户提供更专业、更有效的信息，帮助客户做出准确地决策，
							降低信用风险。
						</div>
						<div class="panel2-infor textEN">
							20 years credit investigation experience to verify location, operation and other 
							information of SC and providing professional analysis; 36 subsidies and 50 branches 
							around China to collected information timely; APP developed by self and qualified 
							review team to confirm the accuracy and effective of information. Provide more 
							professional and effective information for our clients to make decision accurately 
							and reduce credit risks. 
						</div>
						<img class="leftBorder" src="${webRoot}/images/credit/panel2-con1.png"/>
						<img class="rightBorder" src="${webRoot}/images/credit/panel2-con2.png"/>
					</div>
				</div>
				<!--第三部分-->
				<div class="section1 panel3" id="main-three">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text3.png">
					</div>
					<div class="panel-text">征信业务优势</div>
					<img src="${webRoot}/images/credit/panel3-con.png"/>
				</div>
			</div>
		</div>
		<!-- 征信业务 结束 -->
		<!-- 逾期账款 开始 -->
		<div class="creditAll creditTwo">
			<div class="companyTab">
				<ul>
					<li class="active">
						<span class="textCN">国内逾期账款管理</span>
						<span class="textEN">Chinese Debt Collection</span>
						<div></div>
					</li>
					<li>
						<a href='${webRoot}/system/produce/init?proType=1&yqType=1'>
							<span class="textCN">国际逾期账款管理</span>
							<span class="textEN">International Debt Collection</span>
							<div></div>
						</a>
					</li>
				</ul>
			</div>
			<!-- 国内 -->
			<div class="chinese">
				<ul class="nav-ul2">
					<li>
						<a href="#main-four" title="" class="active"></a>
						<p class="textDisCN">业务概况</p>
						<p class="textDisEN">Our Services</p>
					</li>
					<li>
						<a href="#main-five" title=""></a>
						<p class="textDisCN">业务类别</p>
						<p class="textDisEN">Business Category</p>
					</li>
					<li>
						<a href="#main-six" title=""></a>
						<p class="textDisCN">业务优势</p>
						<p class="textDisEN">Business Advantage</p>
					</li>
				</ul>
				<div class="section2 panel1" id="main-four" style="	width: 1000px;">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text4.png">
					</div>
					<div class="panel-text">业务概况</div>
					<div class="companyTabCon">
						<p class="textCN" style="text-indent:2.4rem;text-align: justify;">联信集团20多年来专注于<span>金融风控领域</span>，以客户需求为导向，依托覆盖全国的服务网络、先进的互联网服务平台和强大的计算机技术支持，为客户提供专业的逾期账款管理服务。</p>
						<p class="textCN" style="text-indent:2.4rem;text-align: justify;">联信集团遵循超越客户期望，提高服务质量，严控信息安全，持续追求服务品质的原则，基于6sigma、ISO9001以及ISO27001建立了标准的作业流程、高效的管理模式、严格的信息安全服务以及完善的品质管理，通过电话、信函、上门等多种的合法作业方式，协助委托人有效降低不良逾期压力，减少损失。</p>
						<p class="textCN" style="text-indent:2.4rem;text-align: justify;">同时，联信集团凭借领先的业绩以及卓越的服务品质积累了众多的客户资源和良好的业界口碑，目前联信集团已成为了招商银行、交通银行、广发银行、中信银行、蚂蚁金服的战略级合作伙伴以及兴业银行、平安银行、浦发银行等全国性商业银行的重要核心合作伙伴。</p>
						<p class="textEN" style="text-indent:2.4rem;text-align: justify;">Inter-Credit has been focusing on the field of financial risk control for more than 20 years. Oriented to clients’needs and relying on the nationwide service network, advanced Internet service platform and powerful computer technology support, Inter-Credit provides our clients with professional services of post-loan account management.</p>
						<p class="textEN" style="text-indent:2.4rem;text-align: justify;">Inter-Credit Group follows the principles of exceeding customer expectations, improving quality of service, strictly controlling information security, and continuing to pursue service quality. Based on the 6Sigma, ISO9001 (quality management) system, and ISO27001 (Information Security Management) system, we have established the standard operation process, efficient management model, strict information security services and perfect quality management. And we assist the client to effectively reduce the bad overdue pressure and loss through phone calls, letters, door-to-door and other legal working mode.</p>
						<p class="textEN" style="text-indent:2.4rem;text-align: justify;">Besides, Inter-Credit Group has accumulated rich customer resources and good reputation in the industry with leading performance and excellent service quality. Now we’re the core partner of large commercial bank like CMB, BCM, CGB, China CITIC Bank, Ant Financial, CIB, Ping An Bank, SPDB ,and etc.</p>
					</div>
				</div>
				<div class="section2 panelCate" id="main-five">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text5.png">
					</div>
					<div class="panel-text" style="color:#fff;">业务类别</div>
					<div class="panelCateCon">
						<img alt="" src="${webRoot}/images/credit/cateTop.png">
						<div class="cateChild cateChild1">
							<img alt="" src="${webRoot}/images/credit/cate1.png">
							<div class="cateText">
								<p class="textCN">银行</p>
								<p class="textEN">Banks</p>
							</div>
						</div>
						<div class="cateChild cateChild2">
							<img alt="" src="${webRoot}/images/credit/cate2.png">
							<div class="cateText">
								<p class="textCN">互联网金融</p>
								<p class="textEN">Internet financial institution</p>
							</div>
						</div>
						<div class="cateChild cateChild3">
							<img alt="" src="${webRoot}/images/credit/cate3.png">
							<div class="cateText">
								<p class="textCN">汽车金融公司</p>
								<p class="textEN">Auto financing companies</p>
							</div>
						</div>
						<div class="cateChild cateChild4">
							<img alt="" src="${webRoot}/images/credit/cate4.png">
							<div class="cateText">
								<p class="textCN">其他金融公司</p>
								<p class="textEN">Other financial firms</p>
							</div>
						</div>
					</div>
				</div>
				<div class="section2 panelAdvantage" id="main-six">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text6.png">
					</div>
					<div class="panel-text">业务优势</div>
					<div class="panelAdvan">
						<div class="advanchild advanchild1">
							<div class="advanchildText textCN">
								<p class="textCNTop">覆盖全国的服务网络</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">提供专业化、本地化的催收服务 </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Nationwide service network</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">Professional and localized domestic collection services</p>
							</div>
						</div>
						<div class="advanchild advanchild2">
							<div class="advanchildText textCN">
								<p class="textCNTop">全面高效的专业化服务</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">前中后期与客户专业对接，<br/>注重员工培训及个人发展 </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Comprehensive, efficient and professional services.</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">Professional contact with customers throughout the course, and pay attention to staff’s training and their personal development</p>
							</div>
						</div>
						<div class="advanchild advanchild3">
							<div class="advanchildText textCN">
								<p class="textCNTop">灵活高效的业务模式</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">提供多元化、标准化、优质化<br/>的服务 </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Flexible and efficient business model</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">Provide diversified, standardized and high-quality services</p>
							</div>
						</div>
						<div class="advanchild advanchild4">
							<div class="advanchildText textCN">
								<p class="textCNTop">持续的自主创新能力</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">立足于市场需求，不断对服务<br/>进行升级和延伸 </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Ongoing capacity for independent innovation</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">Based on the market demand, upgrade and extend the service continuously</p>
							</div>
						</div>
						<div class="advanchild advanchild5">
							<div class="advanchildText textCN">
								<p class="textCNTop">严格的信息安全管控</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">通过了SGS认证的ISO 27001信息安全管理体系和安永会计师事务所审计 </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Strict control of information security</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">We have passed the ISO27001 information security management system certified by SGS and the auditon of Ernst & Young</p>
							</div>
						</div>
						<div class="advanchild advanchild6">
							<div class="advanchildText textCN">
								<p class="textCNTop">强大的AI团队</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">独立的数据中心，不断引进高端技术<br/>人才，坚持科技引领，联信腾飞  </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Awesome AI team</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">We have independent data center, and we Introduce talents with high-end technology constantly. We are sure that the science and technology will lead Inter-credit to take off.</p>
							</div>
						</div>
						<div class="advanchild advanchild7">
							<div class="advanchildText textCN">
								<p class="textCNTop">先进的业务管理系统</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">保障全国服务快捷、高效、准确  </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Advanced business management system</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">Ensure fast, efficient and accurate national services</p>
							</div>
						</div>
						<div class="advanchild advanchild8">
							<div class="advanchildText textCN">
								<p class="textCNTop">独立的信息修复团队</p>
								<div class="line lineCN"></div>
								<p class="textCNBtm">提高失联修复率，推动业绩增长  </p>
							</div>
							<div class="advanchildText textEN">
								<p class="textENTop">Independent information repair team</p>
								<div class="line lineEN"></div>
								<p class="textENBtm">Increase the information restoration rate of the loss of communication and drive the performance growth</p>
							</div>
						</div>
					</div>
				</div>
				
			</div>
			<!-- 国际 -->
			<div class="international">
				<ul class="nav-ul3">
					<li>
						<a href="#main-seven" title="" class="active"></a>
						<p class="textDisCN">业务概况</p>
						<p class="textDisEN">Our Services</p>
					</li>
					<li>
						<a href="#main-eight" title=""></a>
						<p class="textDisCN">全球服务网络</p>
						<p class="textDisEN">Global Service Network</p>
					</li>
					<li>
						<a href="#main-nine" title=""></a>
						<p class="textDisCN">世界网点分布</p>
						<p class="textDisEN">Choose Your Location</p>
					</li>
					<li>
						<a href="#main-ten" title=""></a>
						<p class="textDisCN">我们的优势</p>
						<p class="textDisEN">Our Advantages</p>
					</li>
					<li>
						<a href="#main-eleven" title=""></a>
						<p class="textDisCN">免费咨询</p>
						<p class="textDisEN">Free Consultation</p>
					</li>
				</ul>
				<div class="section3 panel1" id="main-seven">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text4.png">
					</div>
					<div class="panel-text">业务概况</div>
					<div class="companyTabCon">
						<p class="textCN">联信集团在<span>国际商账催收</span>领域具有20余年的丰富经验，我们潜心为海内外企业及金融机构提供逾期账款追收直至法律诉讼的一站式服务。</p>
						<p class="textCN">通过完善的信用管理服务，友好的庭外和解，成功地帮助绝大多数客户回收国际应收账款。</p>
						<p class="textCN">作为TCM Group（全面信用管理集团）唯一的中方股东，联信集团的国际网络覆盖了全球98%的地区。</p>
						<p class="textCN">无论您的债务人身在何处，我们都能为您提供专业、高效、本地化的逾期账款管理服务。</p>
						<p class="textEN">With more than 20 years of rich experience in the field of international debt collection, Inter-Credit has devoted itself to provide one-stop services from amicable collection to legal proceedings for companies all over the world.</p>
						<p class="textEN">We have succeeded in helping our clients to recover their international debts through effective credit management and amicable out-of-court settlements.</p>
						<p class="textEN">As the sole Chinese shareholder of TCM Group, our service network has covered 98% of the world.</p>
						<p class="textEN">No matter where your debtor is, we can provide you with professional, efficient and localized overdue account management services.</p>
					</div>
				</div>
				<div class="section3 panelGlobal" id="main-eight">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text8.png">
					</div>
					<div class="panel-text">全球服务网络</div>
					<div class="globalCon">
						<div class="globalConChild">
							<img class="globalBg" alt="" src="${webRoot}/images/credit/globalBg1.png">
							<div class="globalText">
								<div class="globalLeft textCN">
									<p class="textCN"><span>Total Credit Management Group（全面信用管理集团）</span>成立于1987年，是由世界领先的信用风险管理机构和专业律师事务所组成的全球收账联盟。</p>
									<p class="textCN only">2008年，联信集团成为TCM集团的唯一中方股东。我们的服务网络覆盖了全球145个国家和地区。通过统一的质量管理，无缝的业务衔接，高效的操作平台，我们能够为您提供专业而卓越的一站式国际逾期账款管理服务。</p>
									<div class="globalBtn">
										<a href="https://www.tcmgroup.com/" target="_blank">
											<i class="iconfont icon-icon"></i>
											<span>友情链接</span>
										</a>
									</div>
								</div>
								<div class="globalLeft textEN">
									<p class="textEN"><span>Total Credit Management Group</span>, established in 1987, is a global alliance of carefully selected and strategically placed debt collection agencies and specialized law firms.</p>
									<p class="textEN only">In 2008, Inter-Credit became the sole Chinese shareholder of TCM Group. Our service network covers 145 countries and regions around the world. Through unified quality management, seamless business connection and efficient operation platform, we provide you with superior one-stop solutions of international debt collection.</p>
									<div class="globalBtn">
										<a href="https://www.tcmgroup.com/">
											<i class="iconfont icon-icon"></i>
											<span>Link</span>
										</a>
									</div>
								</div>
							</div>
							<div id="mediaplayer">
								
							</div>
							<div class="videoBorder">
								<img alt="" src="${webRoot}/images/credit/videoBorder.png">
							</div>
						</div>
					</div>
				</div>
				<div class="section3 panelLocation" id="main-nine">
					<div class="tab2">
						<div id="main2">
							<div class="companyInfor">
								<div class="panel-title">
									<img src="${webRoot}/images/credit/text9.png">
								</div>
								<div class="panel-text">世界网点分布</div>
								<div class="chineseItem textCN">
									<div class="menu-item">
										<a class="menuTitle">非洲<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>阿尔及利亚、</li>
												<li>安哥拉、</li>
												<li>贝宁、</li>
												<li>博茨瓦纳、</li>
												<li>布吉纳法索、</li>
												<li>喀麦隆、</li>
												<li>加纳、</li>
												<li>几内亚、</li>
												<li>象牙海岸共和国、</li>
												<li>肯尼亚、</li>
												<li>利比亚、</li>
												<li>马达加斯加、</li>
												<li>马拉维、</li>
												<li>马里、</li>
												<li>摩洛哥、</li>
												<li>莫桑比克共和国、</li>
												<li>纳米比亚、</li>
												<li>尼日利亚、</li>
												<li>塞内加尔、</li>
												<li>南非、</li>
												<li>苏丹、</li>
												<li>斯威士兰、</li>
												<li>留尼汪岛、</li>
												<li>坦桑尼亚、</li>
												<li>多哥共和国、</li>
												<li>突尼斯、</li>
												<li>乌干达、</li>
												<li>津巴布韦、</li>
												<li>埃及</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">亚洲<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>中国、</li>
												<li>亚美尼亚、</li>
												<li>阿塞拜疆、</li>
												<li>孟加拉国、</li>
												<li>文莱达鲁萨兰国、</li>
												<li>格鲁吉亚、</li>
												<li>印度、</li>
												<li>印度尼西亚、</li>
												<li>日本、</li>
												<li>哈萨克斯坦、</li>
												<li>吉尔吉斯斯坦、</li>
												<li>马来西亚、</li>
												<li>蒙古、</li>
												<li>缅甸、</li>
												<li>巴基斯坦、</li>
												<li>菲律宾、</li>
												<li>波利尼西亚、</li>
												<li>新加坡、</li>
												<li>韩国、</li>
												<li>斯里兰卡、</li>
												<li>塔吉克斯坦、</li>
												<li>泰国、</li>
												<li>土库曼斯坦、</li>
												<li>乌兹别克斯坦、</li>
												<li>越南、</li>
												<li>巴林、</li>
												<li>伊朗、</li>
												<li>伊拉克、</li>
												<li>以色列、</li>
												<li>约旦、</li>
												<li>科威特、</li>
												<li>黎巴嫩、</li>
												<li>阿曼、</li>
												<li>卡塔尔、</li>
												<li>沙特阿拉伯、</li>
												<li>叙利亚、</li>
												<li>土耳其、</li>
												<li>阿联酋、</li>
												<li>也门</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">大洋洲<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>澳大利亚、</li>
												<li>新西兰、</li>
												<li>波利尼西亚、</li>
												<li>瓦利斯群岛和富图纳群岛</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">欧洲<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>科索沃、</li>
												<li>阿尔巴尼亚、</li>
												<li>奥地利、</li>
												<li>白俄罗斯、</li>
												<li>比利时、</li>
												<li>波斯尼亚黑塞哥维那、</li>
												<li>保加利亚、</li>
												<li>克罗地亚、</li>
												<li>捷克共和国、</li>
												<li>塞浦路斯、</li>
												<li>丹麦、</li>
												<li>爱沙尼亚、</li>
												<li>法罗群岛、</li>
												<li>芬兰、</li>
												<li>法国、</li>
												<li>德国、</li>
												<li>希腊、</li>
												<li>格陵兰岛、</li>
												<li>匈牙利、</li>
												<li>冰岛、</li>
												<li>爱尔兰、</li>
												<li>意大利、</li>
												<li>拉脱维亚、</li>
												<li>列支敦斯登、</li>
												<li>立陶宛、</li>
												<li>卢森堡、</li>
												<li>马其顿、</li>
												<li>马耳他、</li>
												<li>黑山共和国、</li>
												<li>荷兰、</li>
												<li>挪威、</li>
												<li>波兰、</li>
												<li>葡萄牙、</li>
												<li>罗马尼亚、</li>
												<li>俄罗斯联邦、</li>
												<li>塞尔维亚、</li>
												<li>斯洛伐克、</li>
												<li>斯洛文尼亚、</li>
												<li>西班牙、</li>
												<li>瑞典、</li>
												<li>瑞士、</li>
												<li>乌克兰、</li>
												<li>英国</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">北美洲<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>加拿大、</li>
												<li>圣皮埃尔、</li>
												<li>美国</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">南美洲<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>阿根廷、</li>
												<li>玻利维亚、</li>
												<li>巴西、</li>
												<li>智利、</li>
												<li>哥伦比亚、</li>
												<li>哥斯达黎加共和国、</li>
												<li>多米尼加共和国、</li>
												<li>厄瓜多尔、</li>
												<li>瓜德罗普岛、</li>
												<li>危地马拉、</li>
												<li>法属圭亚那、</li>
												<li>洪都拉斯、</li>
												<li>牙买加、</li>
												<li>马提尼克岛、</li>
												<li>马约特岛、</li>
												<li>墨西哥、</li>
												<li>新喀里多尼亚、</li>
												<li>尼加拉瓜、</li>
												<li>巴拿马、</li>
												<li>巴拉圭、</li>
												<li>秘鲁、</li>
												<li>萨尔瓦多、</li>
												<li>乌拉圭、</li>
												<li>委内瑞拉</li>
											</ol>
										</div>
									</div>
								</div>
								<div class="englishItem textEN">
									<div class="menu-item">
										<a class="menuTitle">Africa<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>Algeria、</li>
												<li>Angola、</li>
												<li>Benin、</li>
												<li>Botswana、</li>
												<li>Burkina Faso、</li>
												<li>Cameroon、</li>
												<li>Ghana、</li>
												<li>Guinea、</li>
												<li>Lvory Coast、</li>
												<li>Kenya、</li>
												<li>Libya、</li>
												<li>Madagascar、</li>
												<li>Malawi、</li>
												<li>Mali、</li>
												<li>Morocco、</li>
												<li>Mozambique、</li>
												<li>Namibia、</li>
												<li>Nigeria、</li>
												<li>Senegal、</li>
												<li>South Africa、</li>
												<li>Sudan、</li>
												<li>Swaziland、</li>
												<li>Reunion、</li>
												<li>Tanzania、</li>
												<li>Togo、</li>
												<li>Tunisia、</li>
												<li>Uganda、</li>
												<li>Zimbabwe、</li>
												<li>Egypt</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">Asia<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>China、</li>
												<li>Armenia、</li>
												<li>Azerbaijan、</li>
												<li>Bangladesh、</li>
												<li>Brunei Darussalam、</li>
												<li>Georgia、</li>
												<li>India、</li>
												<li>Indonesia、</li>
												<li>Japan、</li>
												<li>Kazakhstan、</li>
												<li>Kyrgyzstan、</li>
												<li>Malaysia、</li>
												<li>Mongolia、</li>
												<li>Myanmar、</li>
												<li>Pakistan、</li>
												<li>Philippines、</li>
												<li>Polynesia、</li>
												<li>Singapore、</li>
												<li>South Korea、</li>
												<li>Sri Lanka、</li>
												<li>Tajikistan、</li>
												<li>Thailand、</li>
												<li>Turkmenistan、</li>
												<li>Uzbekistan、</li>
												<li>Vietnam、</li>
												<li>Bahrain、</li>
												<li>Iran、</li>
												<li>Iraq、</li>
												<li>Israel、</li>
												<li>Jordan、</li>
												<li>Kuwait、</li>
												<li>Lebanon、</li>
												<li>Oman、</li>
												<li>Qatar、</li>
												<li>Saudi Arabia、</li>
												<li>Syria、</li>
												<li>Turkey、</li>
												<li>United Arad Emirates、</li>
												<li>Yemen</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">Australia<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>Australia、</li>
												<li>New Zealand、</li>
												<li>Polynesia、</li>
												<li>Wallis&Futuna</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">Europe<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>Kosovo、</li>
												<li>Albania、</li>
												<li>Austria、</li>
												<li>Belarus、</li>
												<li>Belgium、</li>
												<li>Bosnia Herzegovina、</li>
												<li>Bulgaria、</li>
												<li>Croatia、</li>
												<li>Czech Republic、</li>
												<li>Denmark、</li>
												<li>Estonia、</li>
												<li>Faroe Islands、</li>
												<li>Finland、</li>
												<li>France、</li>
												<li>Germany、</li>
												<li>Greece、</li>
												<li>Greenland、</li>
												<li>Hungary、</li>
												<li>Iceland、</li>
												<li>Ireland、</li>
												<li>Italy、</li>
												<li>Latvia、</li>
												<li>Liechtenstein、</li>
												<li>Lithuania、</li>
												<li>Luxemburg、</li>
												<li>Macedonia、</li>
												<li>Malta、</li>
												<li>Montenegro、</li>
												<li>Netherlands、</li>
												<li>Norway、</li>
												<li>Poland、</li>
												<li>Portugal、</li>
												<li>Romania、</li>
												<li>Russian Federation、</li>
												<li>Serbia、</li>
												<li>Slovakia、</li>
												<li>Slovenia、</li>
												<li>Spain、</li>
												<li>Sweden、</li>
												<li>Switzerland、</li>
												<li>Ukraine、</li>
												<li>United Kingdom</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">North America<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>Canada、</li>
												<li>Saint pierre、</li>
												<li>USA</li>
											</ol>
										</div>
									</div>
									<div class="menu-item">
										<a class="menuTitle">South America<i class="iconfont icon-icon"></i></a>
										<div class="menuCon">
											<ol>
												<li>Argentina、</li>
												<li>Bolivia、</li>
												<li>Brazil、</li>
												<li>Chile、</li>
												<li>Colombia、</li>
												<li>Costa Rica、</li>
												<li>Dominican Republic、</li>
												<li>Ecuador、</li>
												<li>Guadeloupe、</li>
												<li>Guatemala、</li>
												<li>Guiana French、</li>
												<li>Honduras、</li>
												<li>Jamaica、</li>
												<li>Martinique、</li>
												<li>Mayotte、</li>
												<li>Mexico、</li>
												<li>New Caledonia、</li>
												<li>Nicaragua、</li>
												<li>Panama、</li>
												<li>Paraguay、</li>
												<li>Peru、</li>
												<li>Salvador、</li>
												<li>Uruguay、</li>
												<li>Venezuela</li>
											</ol>
										</div>
									</div>
								</div>
							</div>
							<ul class="continents" style="float:left;margin-top: 40px!important;">
							  	<li class="c1"><a href="#africa">Africa</a></li>
							  	<li class="c2"><a href="#asia">Asia</a></li>
							  	<li class="c3"><a href="#australia">Australia</a></li>
							  	<li class="c4"><a href="#europe">Europe</a></li>
							  	<li class="c5"><a href="#north-america">North America</a></li>
							  	<li class="c6"><a href="#south-america">South America</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="section3 panelYS" id="main-ten">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text10.png">
					</div>
					<div class="panel-text">我们的优势</div>
					<div class="panelYSCon">
						<div class="ysConChild">
							<div class="ysConChildAll ysConChild_one">
								<div class="textCN">
									<p class="tourism">旅游业</p>
									<p class="medical">医疗</p>
									<p class="education">教育</p>
									<p class="trade">贸易</p>
									<p class="exhibition">展会</p>
									<p class="manufacture">制造业</p>
									<p class="banking">银行</p>
									<p class="other">其他行业</p>
									<p class="titleTop">20余年潜心笃志</p>
									<p class="titleBtm">积累多行业经验，快速洞察行业特点</p>
								</div>
								<div class="textEN">
									<p class="tourism">Tourism</p>
									<p class="medical">Medical</p>
									<p class="education">Education</p>
									<p class="trade">Trade</p>
									<p class="exhibition">Exhibition</p>
									<p class="manufacture">Manufacture</p>
									<p class="banking">Banking</p>
									<p class="other">Other</p>
									<p class="titleTop">20 years’ experience focusing on debt collection</p>
									<p class="titleBtm">rich multi-industry experience and quick insight into industry characteristics</p>
								</div>
							</div>
							<div class="ysConChildAll ysConChild_two">
								<div class="textCN">
									<p class="titleTop">1对1定制方案</p>
									<p class="titleBtm">根据您的业务需求，制定适合您的专属方案</p>
								</div>
								<div class="textEN">
									<p class="titleTop">1-to-1 customized debt solution</p>
									<p class="titleBtm">tailor your solution to your business needs</p>
								</div>
							</div>
							<div class="ysConChildAll ysConChild_three">
								<div class="textCN">
									<p class="legal">法律</p>
									<p class="field">外访</p>
									<p class="service">客服</p>
									<p class="restoration">信修</p>
									<p class="improvement">稽核</p>
									<p class="credit">征信</p>
									<p class="RD">研发</p>
									<p class="team">催收团队</p>
									<p class="titleTop">7大支持中心</p>
									<p class="titleBtm">整合多渠道资源，全方位支持催收业务</p>
								</div>
								<div class="textEN">
									<p class="legal">Legal Support</p>
									<p class="field">Field Collectors</p>
									<p class="service">Customer Service</p>
									<p class="restoration">Info Restoration</p>
									<p class="improvement">Improvement Center</p>
									<p class="credit">Credit Center</p>
									<p class="RD">R&D Center</p>
									<p class="team">Collection<br/>&nbsp;&nbsp;&nbsp;&nbsp;Team</p>
									<p class="titleTop">7 supporting centers</p>
									<p class="titleBtm">integrate multi-channel resources, provide full support to debt collection</p>
								</div>
							</div>
							<div class="ysConChildAll ysConChild_four">
								<div class="textCN">
									<p class="titleTop">98%的全球覆盖率</p>
									<p class="titleBtm">为您提供专业、高效、本地化的催收和法律服务</p>
								</div>
								<div class="textEN">
									<p class="titleTop">98% global coverage</p>
									<p class="titleBtm">bring you the most professional, efficient, localized collection and legal services</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="section3 panel1" id="main-eleven" style="padding:0;">
					<div class="panel-title">
						<img src="${webRoot}/images/credit/text11.png">
					</div>
					<div class="panel-text">免费咨询</div>
					<div class="panelFree">
						<div class="suggestionsInfor">
							<ul>
								<li>
									<div class="liLine"></div>
									<i class="iconfont icon-name"></i>
									<input class="textCN" id="ContactCN" placeholder="联系人(必填)"/>
									<input class="textEN" id="ContactEN" placeholder="Contact(Required)"/>
								</li>
								<li>
									<div class="liLine"></div>
									<i class="iconfont icon-shouji"></i>
									<input class="textCN" id="TelephoneCN" placeholder="联系电话(必填)"/>
									<input class="textEN" id="TelephoneEN" placeholder="Telephone(Required)"/>
								</li>
								<li>
									<div class="liLine"></div>
									<i class="iconfont icon-gongsimingcheng"></i>
									<input class="textCN" id="CompanyCN" placeholder="公司名称(必填)"/>
									<input class="textEN" id="CompanyEN" placeholder="Your Company(Required)"/>
								</li>
								<li>
									<div class="liLine"></div>
									<i class="iconfont icon-youxiang"></i>
									<input class="textCN" id="EmailCN" placeholder="邮箱"/>
									<input class="textEN" id="EmailEN" placeholder="Email"/>
								</li>
							</ul>
						</div>
						<div class="suggestionsInfor">
							<ul>
								<li>
									<input class="textCN" id="NameCN" placeholder="债务公司名称(必填)"/>
									<input class="textEN" id="NameEN" placeholder="Debtor’s Name(Required)"/>
								</li>
								<li>
									<input class="textCN" id="CountryCN" placeholder="所在国家(必填)"/>
									<input class="textEN" id="CountryEN" placeholder="Debtor’s Country(Required)"/>
								</li>
								<li style="position:relative;">
									<input class="textCN" id="DayCN" placeholder="逾期天数"/>
									<input class="textEN" id="DayEN" placeholder="Overdue Days"/>
									<p class="textCN">天</p>
									<p class="textEN">Days</p>
								</li>
								<li>
									<input class="textCN" id="AmountCN" placeholder="币种和金额(必填)"/>
									<input class="textEN" id="AmountEN" placeholder="Currency & Amount(Required)"/>
								</li>
							</ul>
						</div>
						<div class="suggestionsContent">
							<textarea class="textCN" name="content" id="contentCN" placeholder="其他说明(必填)"></textarea>
							<textarea class="textEN" name="content" id="contentEN" placeholder="Other Information"></textarea>
						</div>
						<div class="suggestionsBtn">
							<button id="sendBtn">
								<span class="textCN">提交</span>
								<span class="textEN">Submit</span>
							</button>
							<div>
								<p class="resetCN">*请填写联系人！</p>
								<p class="resetCNPhone">*请填写11位有效手机号码！</p>
								<p class="resetCNGSName">*请填写公司名称！</p>
								<p class="resetCNZWGSName">*请填写债务公司名称！</p>
								<p class="resetCNGJ">*请填写所在国家！</p>
								<p class="resetCNMoney">*请填写币种和金额！</p>
								<p class="resetCNContent">*请填写咨询内容！</p>
								<p class="successCN">*提交成功</p>
								<p class="resetEN">*Please fill in the contact/contact number/company name/debt company name/country/currency and amount!</p>
								<p class="successEN">*Submitted successfully</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 逾期账款 结束 -->
	</div>
	
	<script src="${webRoot}/js/footer.js"></script>
	<script type="text/javascript" src="${webRoot}/js/jquery.min.js"></script>
	<script>
		var _url = webRoot+"/images/credit/play.png";
	</script>
	<script type="text/javascript" src="${webRoot}/js/plugins/cssmap-continents/jquery.cssmap.min.js"></script>
	<script type="text/javascript" src="${webRoot}/js/DD_belatedPNG.min.js"></script>
	<script src="${webRoot}/js/jwplayer.js"></script>
	<script src="${webRoot}/js/jwpsrv.js"></script>
	<script type="text/javascript" src="${webRoot}/js/credit.min.js"></script>
	<script type="text/javascript" src="${webRoot}/js/header.js"></script>
</body>
</html>
