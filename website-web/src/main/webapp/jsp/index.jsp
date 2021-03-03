<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="首页"/>
    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <input id="beginDate" type="hidden" value="${websiteBasic.time}">
        <%--<input id="cnEnFlag" type="hidden" value="${cnEnFlag}">--%>
        <ul class="nav-ul">
            <li class="active" value="#main-two">
                <p class="textCN">关于联信</p>
                <p class="textEN">About Us</p>
            </li>
            <li value="#main-three">
                <p class="textCN">联信动态</p>
                <p class="textEN">News</p>
            </li>
            <li value="#main-four">
                <p class="textCN">联信业务</p>
                <p class="textEN">Services</p>
            </li>
            <li value="#main-five">
                <p class="textCN">我们的服务平台</p>
                <p class="textEN">Service Platform</p>
            </li>
            <li value="#main-six">
                <p class="textCN">服务网络</p>
                <p class="textEN">Our Network</p>
            </li>
        </ul>
        <div class="index-main">
            <div id="main-one" class="section1" style="overflow: hidden;">
                <input type="hidden" id="videoActive" value="${websiteBasic.checked}">
                <div class="arrowDown arrowAni"><img src="${webRoot}/images/index/arrow.png"></div>
                <div class="banner-box" id="banner-box">
                    <div class="swiper-wrapper">
                        <c:forEach var="banner" items="${configBanner}" varStatus="s">
                            <div class="swiper-slide">
                                    <%--<a href="${banner.address}">--%>
                                <a href="${banner.address}" target="view_window">
                                    <img class="textCN" src="${imgServer}${banner.imgChineseAdress}"/>
                                    <img class="textEN" src="${imgServer}${banner.imgEnglishAdress}"/>
                                </a>
                            </div>
                        </c:forEach>
                        <c:if test="${websiteBasic.checked!='0'}">
                            <div class="swiper-slide banner-video">
                                <video
                                    <%--src="${webRoot}/assets/lianxin.mp4"--%>
                                        src="${imgServer}${websiteBasic.videoShareAdress}"
                                        poster="${webRoot}/images/videoImg.jpg">
                                </video>
                                <i class="videoPlayButton iconfont icon-shipinbofang" onclick="videoPlay(this)"></i>
                            </div>
                        </c:if>
                    </div>
                    <div class="banner-pagination"></div>
                </div>
            </div>
            <section id="main-two" class="section2">
                <div class="section-body">
                    <div class="section-title">
                        <p class="section-title-EN">about us</p>
                        <p class="section-title-CN">关于联信</p>
                    </div>
                    <div class="about-us-list">
                        <c:forEach items="${aboutUsList}" var="aboutUs" varStatus="s">
                            <div class="about-us-item">
                                <a href='${webRoot}${aboutUs.href}'>
                                    <div class="about-us-item-pic">
                                        <div class="about-us-item-pic-s">
                                            <img src="${imgServer}${aboutUs.src}">
                                            <%-- <div class="about-us-item-pic-h">
                                                <img src="${webRoot}/images/index/aboutus-btn-h.png">
                                                <div class="about-us-item-pic-text">${aboutUs.text}</div>
                                            </div> --%>
                                        </div>
                                    </div>
                                    <div class="about-us-item-text">${aboutUs.titleCN}</div>
                                    <div class="about-us-item-text-en">${aboutUs.titleEN}</div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
            <section id="main-three" class="section3">
                <div class="section-body">
                    <div class="section-title">
                        <p class="section-title-EN">news</p>
                        <p class="section-title-CN">联信动态</p>
                        <a class="news-title-more" href="${webRoot}/system/companyDynamic/init?type=0">
                            <span class="textCN">MORE</span>
                            <span class="textEN">MORE</span>
                            >
                        </a>
                    </div>
                    <div class="swiper-container" id="news-box">
                        <div class="swiper-wrapper">
                            <c:forEach items="${newsRecord}" var="news" begin="0" step="1" varStatus="newsStatus">
                                <div class="swiper-slide">
                                    <div class="tab-show">
                                        <div class="day-show">
                                            <div class="big">${news.showDay}</div>
                                            <div class="small">
                                                    ${news.showMonth}
                                            </div>
                                        </div>
                                        <a href="${webRoot}/system/companyDynamic/detail?id=${news.id}"><img src="${imgServer}${news.coverPageUrl}" width="100%">
                                        <div class="title-text">${news.newsTitle}</div>
                                        <div class="line"></div>
                                        <div class="grayfont">
                                            <p>${news.summary}</p>
                                        </div>
                                        </a>
                                        <%-- <div class="tab-hide">
                                            <div class="title-text">${news.newsTitle}</div>
                                            <div class="line"></div>
                                            <div class="grayfont">
                                                <div>${news.mainContent}</div>
                                            </div>
                                            <div class="news-link">
                                                <a class="link-btn" href="${webRoot}/system/companyDynamic/detail?id=${news.id}">
                                                    <i class="iconfont"></i>
                                                    <span class="textCN">查看详情</span><span class="textEN">View Details</span>
                                                </a>
                                            </div>
                                        </div> --%>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
                        <div class="news-pagination"></div>
                    </div>
                </div>
            </section>
            <section id="main-four" class="section4">
                <div class="section-body">
                    <div class="section-title white">
                        <p class="section-title-EN">services</p>
                        <p class="section-title-CN">联信业务</p>
                        <a class="services-title-more" href="${webRoot}/system/produce/init">
                            <span class="textCN">MORE</span>
                            <span class="textEN">MORE</span>
                            >
                        </a>
                    </div>
                    <div class="services-panel <c:if test="${cnEnFlag eq 1}">services-panel-EN</c:if>">
                        <c:forEach items="${websiteProductList}" var="product" varStatus="status">
                            <div class="services-item">
                                <div class="services-show ">
                                    <div class="services-inner">
                                        <div class="services-img">
                                            <img src="${webRoot}${product.address}">
                                        </div>
                                        <div class="services-title">${product.title}</div>
                                        <div class="services-line"></div>
                                        <div class="services-summary">${product.summary}</div>
                                        <div class="services-more">
                                            <img src="${webRoot}/images/index/more.png">
                                        </div>
                                    </div>
                                </div>
                                <div class="services-bg">
                                    <div class="services-show ">
                                        <div class="services-img">
                                            <img src="${webRoot}${product.address}">
                                        </div>
                                        <div class="services-line"></div>
                                    </div>
                                    <div class="services-hide">
                                        <div class="services-hContent">
                                            <div class="services-title">${product.title}</div>
                                            <div class="services-line"></div>
                                            <div class="services-content">
                                                    ${product.content}
                                            </div>
                                        </div>
                                        <div class="services-arrow">
                                            <a class="link-btn" href="${webRoot}/system/produce/init#${product.productType}">
                                                <i class="iconfont"></i>
                                                <span class="textCN">查看详情</span><span class="textEN">View Details</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
            <section id="main-five" class="section5">
                <div class="section-body">
                    <div class="section-title">
                        <p class="section-title-EN">service platform</p>
                        <p class="section-title-CN">我们的服务平台</p>
                    </div>
                    <!-- 金融服务平台      中文 -->
                    <div class="f-content textCN">
                        <img src="${webRoot}/images/index/4-8.png">
                        <div class="group-one">
                            <div class="icon1"><img src="${webRoot}/images/index/4-2.png"></div>
                            <div class="iconText">
                                <div class="icontitle">智能化催收业务管理系统
                                    <div class="iconline"></div>
                                    <div class="iconcircle"></div>
                                </div>
                                <div class="icongray">
                                    标准化流程+全流程监测 <br/>+可视化报表+人工智能=精准化管理
                                </div>
                            </div>
                        </div>
                        <div class="group-two">
                            <div class="icon1"><img src="${webRoot}/images/index/4-3.png"></div>
                            <div class="iconText">
                                <div class="icontitle">专业、标准化的国际业务管理系统
                                    <div class="iconline"></div>
                                    <div class="iconcircle"></div>
                                </div>
                                <div class="icongray">
                                    全球统一业务操作平台；数据加密传输；<br/>保障信息安全；标准化业务操作
                                </div>
                            </div>
                        </div>
                        <div class="group-three">
                            <div class="icon1"><img src="${webRoot}/images/index/4-4.png"></div>
                            <div class="iconText">
                                <div class="icontitle">规避风险、高质、高效的尽职调查系统
                                    <div class="iconline"></div>
                                    <div class="iconcircle"></div>
                                </div>
                                <div class="icongray">
                                    流程规避风险、实时审核提高质量及效率、<br/>AI分配、线路规划提高效率
                                </div>
                            </div>
                        </div>
                        <div class="group-four">
                            <div class="icon1"><img src="${webRoot}/images/index/4-5.png"></div>
                            <div class="iconText">
                                <div class="icontitle">智能化的外访APP
                                    <div class="iconline2"></div>
                                    <div class="iconcircle2"></div>
                                </div>
                                <div class="icongray">
                                    自动筛选案件、规划路线、分配访员，无线触达全国200余座城市
                                </div>
                            </div>
                        </div>
                        <div class="group-five">
                            <div class="icon1"><img src="${webRoot}/images/index/4-6.png"></div>
                            <div class="iconText">
                                <div class="icontitle">高效、贴心的尽职调查APP
                                    <div class="iconline2"></div>
                                    <div class="iconcircle2"></div>
                                </div>
                                <div class="icongray">
                                    提供业务、培训等综合性服务，既保障信息安全又方便操作
                                </div>
                            </div>
                        </div>
                        <div class="group-six">
                            <div class="icon1"><img src="${webRoot}/images/index/4-7.png"></div>
                            <div class="iconText">
                                <div class="icontitle">全面、专业的大数据企业信息服务
                                    <div class="iconline2"></div>
                                    <div class="iconcircle2"></div>
                                </div>
                                <div class="icongray">
                                    20多年数据及经验积累、AI学习满足个性化需求
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 金融服务平台   英文 -->
                    <div class="f-content textEN">
                        <img src="${webRoot}/images/index/4-8.png">
                        <div class="group-one">
                            <div class="icon1"><img src="${webRoot}/images/index/4-2.png"></div>
                            <div class="iconText">
                                <div class="icontitle">Domestic Business Management System
                                    <div class="iconline"></div>
                                    <div class="iconcircle"></div>
                                </div>

                                <div class="icongray">
                                    Standard process + Full process monitoring<br/> + Visualized reports + Artificial intelligence = Precise management
                                </div>
                            </div>
                        </div>

                        <div class="group-two">
                            <div class="icon1"><img src="${webRoot}/images/index/4-3.png"></div>
                            <div class="iconText">
                                <div class="icontitle">International Business Management System
                                    <div class="iconline"></div>
                                    <div class="iconcircle"></div>
                                </div>

                                <div class="icongray">
                                    Global unified business operation platform; Encrypted data transmission; Information security assurance
                                </div>
                            </div>
                        </div>
                        <div class="group-three">
                            <div class="icon1"><img src="${webRoot}/images/index/4-4.png"></div>
                            <div class="iconText">
                                <div class="icontitle">Due Diligence System
                                    <div class="iconline"></div>
                                    <div class="iconcircle"></div>
                                </div>

                                <div class="icongray">
                                    Optimized process to avoid risks; auditing teams to improve quality; AI order consignment and route planning with high efficiency
                                </div>
                            </div>
                        </div>
                        <div class="group-four">
                            <div class="icon1"><img src="${webRoot}/images/index/4-5.png"></div>
                            <div class="iconText">
                                <div class="icontitle">On-site Visiting APP
                                    <div class="iconline2"></div>
                                    <div class="iconcircle2"></div>
                                </div>

                                <div class="icongray">
                                    Automatic screening of cases, Route planning, Assignment of field collectors, wireless coverage of 200+ cities across the country
                                </div>
                            </div>
                        </div>
                        <div class="group-five">
                            <div class="icon1"><img src="${webRoot}/images/index/4-6.png"></div>
                            <div class="iconText">
                                <div class="icontitle">Due Diligence APP
                                    <div class="iconline2"></div>
                                    <div class="iconcircle2"></div>
                                </div>

                                <div class="icongray">
                                    Provide comprehensive operating and training services to ensure information security and user friendly
                                </div>
                            </div>
                        </div>
                        <div class="group-six">
                            <div class="icon1"><img src="${webRoot}/images/index/4-7.png"></div>
                            <div class="iconText">
                                <div class="icontitle">Big Data Business Information Services
                                    <div class="iconline2"></div>
                                    <div class="iconcircle2"></div>
                                </div>

                                <div class="icongray">
                                    Over 20 years’experiences and Big Data, AI makes customized service happen
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="main-six" class="section6">
                <div class="section-body">
                    <div class="section-title">
                        <p class="section-title-EN">our network</p>
                        <p class="section-title-CN">服务网络</p>
                        <div class="detailContent textCN">经过20多年的发展，联信集团业务已经覆盖全国超过650个城市，同时作为TCM集团的中方股东，业务覆盖全球超过140个国家。
                        </div>
                        <div class="detailContent textEN">
                            After 20 years of development，Inter-Credit has already covered more than 650 cities across China.
                            <br/>
                            As one of the shareholders of TCM group, our global service covers more than 140 countries worldwide.
                        </div>
                    </div>
                    <div class="" style="width: 100%;">
                        <div class="tabMenu o">
                            <ul class="f">
                                <li class="selectLi oneLi">
                                    <img src="${webRoot}/images/index/6-2.png">
                                    <div class="textCN">国内<span></span></div>
                                    <div class="textEN">China<span></span></div>
                                </li>
                                <li class="twoLi">
                                    <img src="${webRoot}/images/index/6-3.png">
                                    <div class="textCN">国际<span></span></div>
                                    <div class="textEN">Global<span></span></div>
                                </li>
                            </ul>
                        </div>
                        <div class="tabBox">
                            <div class="menuBox">
                                <div class="tab1">
                                    <div id="main1" style="width:100%;height:495px;margin: auto;"></div>
                                </div>
                                <!--tab1 end-->
                                <div class="tab2">
                                    <div id="main2">
                                        <div class="menu textCN">
                                            <div class="menu-item">
                                                <a class="menuTitle" value="1">非洲<i class="iconfont icon-icon"></i></a>
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
                                                <a class="menuTitle" value="2">亚洲<i class="iconfont icon-icon"></i></a>
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
                                                        <%--<li>伊朗、</li>--%>
                                                        <li>伊拉克、</li>
                                                        <li>以色列、</li>
                                                        <li>约旦、</li>
                                                        <li>科威特、</li>
                                                        <li>黎巴嫩、</li>
                                                        <li>阿曼、</li>
                                                        <li>卡塔尔、</li>
                                                        <li>沙特阿拉伯、</li>
                                                        <%--<li>叙利亚、</li>--%>
                                                        <li>土耳其、</li>
                                                        <li>阿联酋、</li>
                                                        <li>也门</li>
                                                    </ol>
                                                </div>
                                            </div>
                                            <div class="menu-item">
                                                <a class="menuTitle" value="3">大洋洲<i class="iconfont icon-icon"></i></a>
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
                                                <a class="menuTitle" value="4">欧洲<i class="iconfont icon-icon"></i></a>
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
                                                        <%--<li>俄罗斯联邦、</li>--%>
                                                        <li>塞尔维亚、</li>
                                                        <li>斯洛伐克、</li>
                                                        <li>斯洛文尼亚、</li>
                                                        <li>西班牙、</li>
                                                        <li>瑞典、</li>
                                                        <li>瑞士、</li>
                                                        <%--<li>乌克兰、</li>--%>
                                                        <li>英国</li>
                                                    </ol>
                                                </div>
                                            </div>
                                            <div class="menu-item">
                                                <a class="menuTitle" value="5">北美洲<i class="iconfont icon-icon"></i></a>
                                                <div class="menuCon">
                                                    <ol>
                                                        <li>加拿大、</li>
                                                        <li>圣皮埃尔、</li>
                                                        <li>美国</li>
                                                    </ol>
                                                </div>
                                            </div>
                                            <div class="menu-item">
                                                <a class="menuTitle" value="6">南美洲<i class="iconfont icon-icon"></i></a>
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
                                                        <%--<li>委内瑞拉</li>--%>
                                                    </ol>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="menu textEN">
                                            <div class="menu-item">
                                                <a class="menuTitle" value="1">Africa<i class="iconfont icon-icon"></i></a>
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
                                                <a class="menuTitle" value="2">Asia<i class="iconfont icon-icon"></i></a>
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
                                                        <%--<li>Iran、</li>--%>
                                                        <li>Iraq、</li>
                                                        <li>Israel、</li>
                                                        <li>Jordan、</li>
                                                        <li>Kuwait、</li>
                                                        <li>Lebanon、</li>
                                                        <li>Oman、</li>
                                                        <li>Qatar、</li>
                                                        <li>Saudi Arabia、</li>
                                                        <%--<li>Syria、</li>--%>
                                                        <li>Turkey、</li>
                                                        <li>United Arad Emirates、</li>
                                                        <li>Yemen</li>
                                                    </ol>
                                                </div>
                                            </div>
                                            <div class="menu-item">
                                                <a class="menuTitle" value="3">Australia<i class="iconfont icon-icon"></i></a>
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
                                                <a class="menuTitle" value="4">Europe<i class="iconfont icon-icon"></i></a>
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
                                                        <%--<li>Russian Federation、</li>--%>
                                                        <li>Serbia、</li>
                                                        <li>Slovakia、</li>
                                                        <li>Slovenia、</li>
                                                        <li>Spain、</li>
                                                        <li>Sweden、</li>
                                                        <li>Switzerland、</li>
                                                        <%--<li>Ukraine、</li>--%>
                                                        <li>United Kingdom</li>
                                                    </ol>
                                                </div>
                                            </div>
                                            <div class="menu-item">
                                                <a class="menuTitle" value="5">North America<i class="iconfont icon-icon"></i></a>
                                                <div class="menuCon">
                                                    <ol>
                                                        <li>Canada、</li>
                                                        <li>Saint pierre、</li>
                                                        <li>USA</li>
                                                    </ol>
                                                </div>
                                            </div>
                                            <div class="menu-item">
                                                <a class="menuTitle" value="6">South America<i class="iconfont icon-icon"></i></a>
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
                                                        <%--<li>Venezuela</li>--%>
                                                    </ol>
                                                </div>
                                            </div>
                                        </div>
                                        <ul class="continents" style="float:right;">
                                            <li class="c1"><a href="#africa">非洲/Africa</a></li>
                                            <li class="c2"><a href="#asia">亚洲/Asia</a></li>
                                            <li class="c3"><a href="#australia">大洋洲/Australia</a></li>
                                            <li class="c4"><a href="#europe">欧洲/Europe</a></li>
                                            <li class="c5"><a href="#north-america">北美洲/North America</a></li>
                                            <li class="c6"><a href="#south-america">南美洲/South America</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </tiles:putAttribute>
    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link rel="stylesheet" href="${webRoot}/css/index.css?${now}"/>
        <link rel="stylesheet" href="${webRoot}/js/plugins/cssmap-continents/cssmap-continents.css">
        <style type="text/css">
        </style>
    </tiles:putAttribute>
    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type="text/javascript" src='${webRoot}/js/plugins/echarts/echarts.min.js'></script>
        <script type="text/javascript" src="${webRoot}/js/plugins/cssmap-continents/jquery.cssmap.min.js"></script>
        <%--<script type="text/javascript" src="http://gallery.echartsjs.com/dep/echarts/map/js/world.js"></script>--%>
        <script type="text/javascript" src="${webRoot}/js/plugins/echarts/map/js/china.js"></script>
        <script type="text/javascript" src="${webRoot}/js/guonei.js"></script>
        <script src="${webRoot}/js/number.js"></script>

        <script type="text/javascript">
            let video;

            function videoPlay(Button) {
                if (Button){
                    video = Button.previousElementSibling;
                    video.onpause=function() {
                        videoPauseAfter();
                    };
                    video.onseeking = function() {
                        videoPlay();
                    };
                }
                video.play(); //播放控制
                video.parentElement.classList.add('swiper-no-swiping');
                video.controls = true;
                $('.banner-pagination').hide();
                $('.videoPlayButton').hide();
            }

            function videoPauseAfter() {
                video.parentElement.classList.remove('swiper-no-swiping');
                video.controls = false;
                $('.banner-pagination').show();
                $('.videoPlayButton').show();
            }
            function videoPause(tempVideo) {
                if (tempVideo){
                    video = tempVideo;
                }
                if (video === undefined) return;
                video.pause(); //暂停控制
                videoPauseAfter();
            }

            $(document).keydown(function (e) {
                if (!e) e = window.event;
                if (video !== undefined && e.keyCode === 32) {
                    video.paused ? videoPlay() : videoPause();
                    return false
                }
            });

            $(function () {
                //banner
                let banner = new Swiper('#banner-box', {
                    effect: 'fade',
                    centeredSlides: true,
                    autoplay: {
                        disableOnInteraction: false,
                        delay: 3000
                    },
                    speed: 500,
                    slidesPerView: 1,
                    loop: true,
                    pagination: {
                        el: '.banner-pagination',
                        clickable: true,
                        bulletClass: 'lianxin-bullet',
                        bulletActiveClass: 'lianxin-bullet-active',
                    },
                    on: {
                        slideChangeTransitionEnd: function () {
                            //切换slide后暂停视频
                            if (video !== undefined && !video.paused) video.pause();

                            //切换到video slide后关联控制
                            if (document.querySelectorAll('.banner-video.swiper-slide-active')[0])
                                video = document.querySelectorAll('.banner-video.swiper-slide-active')[0].firstElementChild;
                            else video = undefined
                        },
                        autoplayStart:function(){
                            if (video !== undefined && !video.paused) banner.autoplay.stop();
                        },
                    },
                });

                /*鼠标移入停止轮播，鼠标离开 继续轮播*/
                let bannerBox = document.getElementById('banner-box');
                bannerBox.onmouseover = function () {
                    banner.autoplay.stop();
                };
                bannerBox.onmouseleave = function () {
                    if (video !== undefined && !video.paused) return;
                    banner.autoplay.start();
                };

                //news
                let news = new Swiper('#news-box', {
                    // centeredSlides: true,
                    autoplay: {
                        disableOnInteraction: false,
                        delay: 5000
                    },
                    speed: 500,
                    slidesPerView: 3,
                    loop: true,
                    pagination: {
                        el: '.news-pagination',
                        clickable: true,
                        bulletClass: 'lianxin-bullet',
                        bulletActiveClass: 'lianxin-bullet-active',
                    },
                });

                /*鼠标移入停止轮播，鼠标离开 继续轮播*/
                let newsBox = document.getElementById('news-box');
                newsBox.onmouseover  = function () {
                    news.autoplay.stop();
                };
                newsBox.onmouseleave = function () {
                    news.autoplay.start();
                };

                $(".services-item").hover(function () {
                    $(this).find(".services-hide").addClass("divAni");
                }, function () {
                    $(this).find(".services-hide").removeClass("divAni");
                });


                $(".two-inner .two-gray").each(function () {
                    var divH = $(this).height();
                    var img = $(this).find('img');
                    if (img.length > 0) {
                        img.remove();
                    }
                    var $p = $(this).find('p');
                    if ($p.text().length > 40) {
                        $p.text($p.text().substr(0, 40) + '...');
                    }
                });
                $('.two-bg .two-hide .two-gray').each(function () {
                    var divH = $(this).height();
                    var img = $(this).find('img');
                    if (img.length > 0) {
                        img.remove();
                    }
                    var $p = $(this).find('p');
                    if ($p.text().length > 116) {
                        $p.text($p.text().substr(0, 116) + '...');
                    }
                });
                $('.news-box .tab-show > .grayfont').each(function () {
                    var divH = $(this).height();
                    var img = $(this).find('img');
                    if (img.length > 0) {
                        img.remove();
                    }
                    var $p = $(this).find('p');
                    while ($p.outerHeight() > divH) {
                        $p.text($p.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/, "..."));
                    }
                });
                $('.news-box .tab-hide .grayfont').each(function () {
                    var divH = $(this).height();
                    var img = $(this).find('img');
                    if (img.length > 0) {
                        img.remove();
                    }
                    var $div = $(this).find('div');
                    while ($div.outerHeight() > divH) {
                        $div.text($div.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/, "..."));
                    }
                });

                /*地图*/
                /* tab 部分 */
                $(".tab2").hide();
                var menuli = $(".tabMenu ul>li");
                menuli.click(function () {
                    //找到相应的div 显示出来
                    let indexNum = $(menuli).index(this);
                    $(".menuBox > div").eq(indexNum).css("display", "block")
                        .siblings().hide();
                    //li添加点击时的样式
                    $(this).addClass("selectLi")
                        .siblings().removeClass("selectLi");
                });

                $(".oneLi").click(function () {
                    $(this).children("img").attr("src", webRoot + "/images/index/6-2.png");
                    $(this).siblings().children("img").attr("src", webRoot + "/images/index/6-3.png")
                });

                //国际地图开始
                $(".twoLi").click(function () {
                    $(this).children("img").attr("src", webRoot + "/images/index/6-4.png");
                    $(this).siblings().children("img").attr("src", webRoot + "/images/index/6-1.png");
                    $("#main2").CSSMap({
                        "size": 650
                    });
                    $('.menu').css('width', 'calc(100% - 750px)');
                });
                var liActive = null;
                document.getElementById('main2').addEventListener('click', function (e) {
                    var objLi = $(this).find('ul li');
                    var index = 0;
                    objLi.each(function () {
                        liActive = $(this).attr('class').indexOf('active-region');
                        var liFocus = $(this).attr('class').indexOf('focus');
                        if (liFocus > 0) {
                            index = parseInt(this.classList[0].substring(1,2));
                            active(index-1);
                            active(index+6-1);
                            return false;
                        }
                    });
                }, true);
                $('.menuTitle').on('click', function () {
                    var index = parseInt($(this).attr('value'));
                    var act = $(this).hasClass('active1');
                    if (act) {
                        $(this).removeClass('active1');
                        $(this).children('i').removeClass('rotate').addClass('rotate1');
                        $(this).siblings('.menuCon').slideUp(500);
                    } else {
                        active(index-1);
                        active(index+6-1);
                        active1(index-1);
                        return false;
                    }
                });

                function active(index) {
                    $('.menu-item').eq(index).find('i').addClass('rotate').removeClass('rotate1');
                    $('.menu-item').eq(index).siblings().find('i').addClass('rotate1').removeClass('rotate');
                    $('.menu-item').eq(index).children('a').addClass('active1');
                    $('.menu-item').eq(index).siblings().children('a').removeClass('active1');
                    $('.menu-item').eq(index).children('.menuCon').slideDown(500);
                    $('.menu-item').eq(index).siblings().children('.menuCon').slideUp(500);
                    if (liActive > 0) {
                        $('.menu-item').eq(index).children('a').removeClass('active1');
                        $('.menu-item').eq(index).children('.menuCon').slideUp(500);
                        $('.menu-item').eq(index).find('i').addClass('rotate1');
                        $('.menu-item').eq(index).find('i').removeClass('rotate');
                    }
                }

                function active1(index) {
                    $(".continents li").eq(index).addClass("active-region").siblings().removeClass("active-region");
                }

                //$(".content").mCustomScrollbar();
                //国际地图 结束
            });
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>