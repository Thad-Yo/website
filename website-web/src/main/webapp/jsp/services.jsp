<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="产品服务"/>
    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="services-Page">
            <ul class="nav-ul">
                <li class="nav-domestic" value="#main-two">
                    <p class="textCN">业务概况</p>
                    <p class="textEN">our services</p>
                </li>
                <li class="nav-domestic" value="#main-three">
                    <p class="textCN">业务类别</p>
                    <p class="textEN">business category</p>
                </li>
                <li class="nav-domestic" value="#main-four">
                    <p class="textCN">业务优势</p>
                    <p class="textEN">our advantages</p>
                </li>
                <li class="nav-international" value="#main-five">
                    <p class="textCN">业务概况</p>
                    <p class="textEN">our services</p>
                </li>
                <li class="nav-international" value="#main-six">
                    <p class="textCN">全球服务网络</p>
                    <p class="textEN">global service network</p>
                </li>
                <li class="nav-international" value="#main-seven">
                    <p class="textCN">世界网点分布</p>
                    <p class="textEN">choose your location</p>
                </li>
                <li class="nav-international" value="#main-eight">
                    <p class="textCN">业务类别</p>
                    <p class="textEN">business category</p>
                </li>
                <li class="nav-international" value="#main-nine">
                    <p class="textCN">业务优势</p>
                    <p class="textEN">our advantages</p>
                </li>
                <li class="nav-international" value="#main-ten">
                    <p class="textCN">免费咨询</p>
                    <p class="textEN">free consultation</p>
                </li>
                <li class="nav-credit" value="#main-eleven">
                    <p class="textCN">国内外企业信息服务</p>
                    <p class="textEN">Business Information Services</p>
                </li>
                <li class="nav-credit" value="#main-twelve">
                    <p class="textCN">国内外尽职调查</p>
                    <p class="textEN">due diligence</p>
                </li>
                <li class="nav-credit" value="#main-thirteen">
                    <p class="textCN">业务类别</p>
                    <p class="textEN">business category</p>
                </li>
                <li class="nav-credit" value="#main-fourteen">
                    <p class="textCN">业务优势</p>
                    <p class="textEN">our advantage</p>
                </li>
            </ul>
            <div class="index-main">
                <div id="main-one" class="section1">
                    <div class="services-banner">
                        <div class="services-tabs">
                            <div class="tabs-box">
                                <div class="services-tab" id="domestic">
                                    <a href='${webRoot}/system/produce/init#1'>
                                        <span class="services-tab-CN">国内逾期账款管理</span>
                                        <span class="services-tab-EN">domestic debt collection</span>
                                    </a>
                                </div>
                                <div class="services-tab" id="international">
                                    <a href='${webRoot}/system/produce/init#2'>
                                        <span class="services-tab-CN">国际逾期账款管理</span>
                                        <span class="services-tab-EN">international debt collection</span>
                                    </a>
                                </div>
                                <div class="services-tab" id="credit">
                                    <a href='${webRoot}/system/produce/init#3'>
                                        <span class="services-tab-CN">征信业务</span>
                                        <span class="services-tab-EN">credit services</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panels">
                    <div class="panel-domestic">
                        <section id="main-two" class="section2">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">our services</p>
                                    <p class="section-title-CN">业务概况</p>
                                </div>
                                <div class="services-box" style="text-align: justify;">
                                    <p class="textCN" style="text-indent: 2em;">联信集团20多年来专注于<span>金融风控领域</span>，以客户需求为导向，依托覆盖全国的服务网络、先进的互联网服务平台和强大的计算机技术支持，为客户提供专业的逾期账款管理服务。
                                    </p>
                                    <p class="textEN">Inter-Credit has been focusing on the field of <span>financial risk control</span>
                                        for more than 20 years. Oriented to clients’ needs and relying on the nationwide service network, advanced Internet service platform and powerful computer technology support, Inter-Credit provides our clients with professional services of overdue account management.</p><br/>
                                    <p class="textCN" style="text-indent: 2em;">
                                        联信集团遵循超越客户期望，提高服务质量，严控信息安全，持续追求服务品质的原则，基于6sigma、ISO9001以及ISO27001建立了标准的作业流程、高效的管理模式、严格的信息安全服务以及完善的品质管理，通过电话、信函、上门等多种的合法作业方式，协助委托人有效降低不良逾期压力，减少损失。</p>
                                    <p class="textEN">Inter-Credit adheres to the principles of exceeding customer expectations, ensuring information security, improving the quality of service, and maintaining outstanding services. Based on the 6Sigma, ISO9001 (quality management) system, and ISO27001 (information security management) system, we have established a standard operation process, efficient management model, strict information security services and comprehensive quality management.</p><br/>
                                    <p class="textCN" style="text-indent: 2em;">
                                        我们为客户提供的逾期账款催收服务旨在维护客户的权益的同时，善意地提醒欠款人在案件移交司法机关之前尽快缴清所欠款项，以免法律措施给欠款人带来更加严重的损失和后果。我们的逾期账款催收服务能够更好地避免客户和欠款人之间出现紧张的对立关系，对于维护客户业务的可持续发展具有重要意义。
                                    </p>
                                    <p class="textEN">Our amicable collection service aims to protect clients’ rights and interests while reminding debtors in good faith before taking legal actions in case of further losses and harmful results. It avoids tension between clients and debtors, which is of great significance for our clients to boost sustainable development.</p><br/>
                                    <p class="textCN" style="text-indent: 2em;">我们的员工作为公司的核心资产之一，其对公司的奉献以及对工作付出的努力和热忱超越了大多数其它同业，我们认为这是我们取得成功的一个重要因素。因此，我们精心挑选最好的员工，并通过持续的培训让他们成为该领域的专家，我们认为在此服务领域，员工的素质和能力决定着服务的品质和价值。</p>
                                    <p class="textEN">Our employees are one of the company's core assets. Their dedication to the company and their hard work and enthusiasm for work exceed most other peers. We believe this is an important factor in our success. Therefore, we carefully select the best employees and make them experts in the field through continuous training. We believe that in this industry, the quality and ability of employees determine the quality and value of the service.</p>
                                </div>
                            </div>
                        </section>
                        <section id="main-three" class="section3 gray">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">business category</p>
                                    <p class="section-title-CN">业务类别</p>
                                </div>
                                <div class="category-box">
                                    <ul>
                                        <c:forEach var="category" items="${categoriesList}" varStatus="s">
                                            <li>
                                                <div class="CN">${category.titleCN}</div>
                                                <div class="EN">${category.titleEN}</div>
                                                <img src="${webRoot}/images/services/business_category-${s.count}.png"/>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </section>
                        <section id="main-four" class="section4">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">our advantages</p>
                                    <p class="section-title-CN">业务优势</p>
                                </div>
                                <div class="advantages-box">
                                    <c:forEach var="advantages" items="${advantagesList}" varStatus="s">
                                        <div class="advantage-item">
                                            <div class="advantage-num">${s.count}</div>
                                            <img  class="advantage-img"src="${webRoot}/images/services/advantage-img-${s.count}.png"/>
                                            <div class="advantage-text">
                                                <div class="advantage-title">${advantages.title}</div>
                                                <div class="advantage-content">${advantages.text}</div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="panel-international">
                        <section id="main-five" class="section5">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">our services</p>
                                    <p class="section-title-CN">业务概况</p>
                                </div>
                                <div class="international-services-box" style="text-align:justify;">
                                    <p class="textCN" style="text-indent: 2em;">
                                        联信集团自成立之初即从事<span>全球账款催收</span>业务，旨在为国内外企业提供逾期账款友好提醒至法律诉讼的一站式服务。我们倾听客户的不同诉求，重视客户的意见反馈，从真正意义上帮助客户减少呆坏账的比率，防范财务风险，实现企业的长期稳定盈利。
                                    </p>
                                    <p class="textEN">
                                        Inter-Credit Group has been engaged in <span>global debt collection</span> business since its inception, aiming to provide domestic and foreign companies with one-stop service for overdue accounts from friendly reminders to legal proceedings. We pay attention to your different demands, value your feedbacks and help you reduce the ratio of bad debts. Our goal is to protect your company from financial risks, and achieve long-term and stable profitability. </p>
                                    <br/>
                                    <p class="textCN" style="text-indent: 2em;">
                                        多年来，联信集团一直致力于构建安全可靠、高效便捷的国际催收服务网络。截至目前为止，我们的全球网络覆盖率达98%，无论您的债务人在何地，我们都能为您提供专业、高效以及本地化的逾期账款管理服务。
                                    </p>
                                    <p class="textEN">Over the years, Inter-Credit Group has been committed to building a reliable and high-efficient global collection network. With a global coverage of 98%, we can provide you with professional, efficient and localized management services for the overdue accounts wherever your debtor is located.</p>
                                </div>
                            </div>
                        </section>
                        <section id="main-six" class="section6">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">global service network</p>
                                    <p class="section-title-CN">全球服务网络</p>
                                </div>
                                <div class="global-box">
                                    <div class="global-content">
                                        <div class="global-text textCN">
                                            <p><span>TCM Group International（全面信用管理集团）</span>
                                                成立于1987年，是由世界领先的国际商账管理机构和专业律师事务所组成的全球收账联盟。
                                            </p>
                                            <p class="textCN">
                                                2008年，联信集团成为TCM集团的唯一中方股东。目前在全球拥有153家合作伙伴，服务网络覆盖140多个国家和地区。通过统一的质量管理，无缝的业务衔接，高效的操作平台，我们能够为您提供专业而卓越的一站式国际逾期账款管理服务。
                                            </p>
                                        </div>
                                        <div class="global-text textEN" style="text-align: justify;">
                                            <p><span>TCM Group International</span>, established in 1987, is a global alliance of carefully selected and strategically placed debt collection agencies and specialized law firms.</p>

                                            <p>In 2008, Inter-Credit became the sole Chinese shareholder of TCM Group. Our international service network covers more than 140 countries, consisting of 153 global partners. Through unified quality management, seamless business connection and efficient operation platform, we provide you with superior one-stop solutions of international debt collection.</p>
                                        </div>
                                        <div class="global-link">
                                            <a class="link-btn" href="https://www.tcmgroup.com/" target="_blank">
                                                <i class="iconfont"></i>
                                                <span class="textCN">友情链接</span><span class="textEN">Link</span>
                                            </a>
                                        </div>
                                        <div class="global-video">
                                           	<video id="video" src="${webRoot}/assets/tcm.mp4"
                                                  poster="${webRoot}/images/credit/tcm.jpg" controls preload='metadata' controlslist='nodownload'> 
                                            </video>
                                            <!-- <div class="global-video-btn" onclick="videoPlay()"></div> -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <section id="main-seven" class="section7">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">choose your location</p>
                                    <p class="section-title-CN">世界网点分布</p>
                                </div>
                                <div class="world-network-box">
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
                                                <a class="menuTitle" value="2">Asia<i
                                                        class="iconfont icon-icon"></i></a>
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
                                                <a class="menuTitle" value="3">Australia<i
                                                        class="iconfont icon-icon"></i></a>
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
                                                <a class="menuTitle" value="5">North America<i
                                                        class="iconfont icon-icon"></i></a>
                                                <div class="menuCon">
                                                    <ol>
                                                        <li>Canada、</li>
                                                        <li>Saint pierre、</li>
                                                        <li>USA</li>
                                                    </ol>
                                                </div>
                                            </div>
                                            <div class="menu-item">
                                                <a class="menuTitle" value="6">South America<i
                                                        class="iconfont icon-icon"></i></a>
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
                        </section>
                        <section id="main-eight" class="section8">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">business category</p>
                                    <p class="section-title-CN">业务类别</p>
                                </div>
                                <div class="international-category-box">
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">国际贸易</span>
                                            <span class="international-category-EN">international trade</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">制造业</span>
                                            <span class="international-category-EN">manufacture</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">银行</span>
                                            <span class="international-category-EN">banking</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">医疗</span>
                                            <span class="international-category-EN">healthcare</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">教育</span>
                                            <span class="international-category-EN">education</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">电子商务</span>
                                            <span class="international-category-EN">E-Commerce</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">政府</span>
                                            <span class="international-category-EN">government</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">工程建设</span>
                                            <span class="international-category-EN">engineering construction</span>
                                        </div>
                                    </div>
                                    <div class="international-category-item">
                                        <div class="international-category-text">
                                            <span class="international-category-CN">旅游</span>
                                            <span class="international-category-EN">tourism</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <section id="main-nine" class="section9">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">our advantages</p>
                                    <p class="section-title-CN">业务优势</p>
                                </div>
                                <div class="international-advantages-box">
                                    <div class="swiper-container" id="swiper-international-advantages">
                                        <div class="swiper-wrapper">
                                            <c:forEach var="advantages" items="${internationalAdvantagesList}"
                                                       varStatus="s">
                                                <div class="swiper-slide">
                                                    <img class="international-advantages-img"
                                                         src="${webRoot}${advantages.src}"/>
                                                    <div class="international-advantages-content">
                                                        <div class="international-advantages-title">${advantages.title}</div>
                                                        <div class="international-advantages-text">${advantages.text}</div>
                                                        <div class="international-advantages-mark">
                                                            <c:forEach var="num" items="${internationalAdvantagesList}"
                                                                       varStatus="i">
                                                                <c:choose>
                                                                    <c:when test="${s.index eq i.index}">
                                                                        <span class="active"></span>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <span></span>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="swiper-advantages-prev"></div>
                                    <div class="swiper-advantages-next"></div>
                                </div>
                            </div>
                        </section>
                        <section id="main-ten" class="section10">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">free consultation</p>
                                    <p class="section-title-CN">免费咨询</p>
                                </div>
                                <div class="consultation-box">
                                    <div class="consultation-info">
                                        <ul>
                                            <li>
                                                <i class="iconfont icon-name"></i>
                                                <input class="textCN" id="ContactCN" placeholder="联系人(必填)"/>
                                                <input class="textEN" id="ContactEN" placeholder="Contact(Required)"/>
                                            </li>
                                            <li>
                                                <i class="iconfont icon-shouji"></i>
                                                <input class="textCN" id="TelephoneCN" placeholder="联系电话(必填)" type="tel" maxlength="11"/>
                                                <input class="textEN" id="TelephoneEN" type="tel"
                                                       placeholder="Telephone(Required)" maxlength="50"/>
                                            </li>
                                            <li>
                                                <i class="iconfont icon-gongsimingcheng"></i>
                                                <input class="textCN" id="CompanyCN" placeholder="公司名称(必填)"/>
                                                <input class="textEN" id="CompanyEN"
                                                       placeholder="Your Company(Required)"/>
                                            </li>
                                            <li>
                                                <i class="iconfont icon-youxiang"></i>
                                                <input class="textCN" type="email" id="EmailCN" placeholder="邮箱"/>
                                                <input class="textEN" type="email" id="EmailEN" placeholder="Email"/>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="consultation-info">
                                        <ul>
                                            <li>
                                                <input class="textCN" id="NameCN" placeholder="债务公司名称(必填)"/>
                                                <input class="textEN" id="NameEN"
                                                       placeholder="Debtor's Name(Required)"/>
                                            </li>
                                            <li>
                                                <input class="textCN" id="CountryCN" placeholder="所在国家(必填)"/>
                                                <input class="textEN" id="CountryEN"
                                                       placeholder="Debtor's Country(Required)"/>
                                            </li>
                                            <li style="position:relative;">
                                                <input class="textCN" id="DayCN" placeholder="逾期天数"/>
                                                <input class="textEN" id="DayEN" placeholder="Overdue Days"/>
                                                <p class="textCN">天</p>
                                                <p class="textEN">Days</p>
                                            </li>
                                            <li>
                                                <input class="textCN" id="AmountCN" placeholder="币种和金额(必填)" maxlength="120"/>
                                                <input class="textEN" id="AmountEN"
                                                       placeholder="Currency & Amount(Required)"/>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="consultation-content">
                                        <textarea class="textCN" name="content" id="contentCN"
                                                  placeholder="其他说明"></textarea>
                                        <textarea class="textEN" name="content" id="contentEN"
                                                  placeholder="Other Information"></textarea>
                                    </div>
                                    <div class="consultation-btn">
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
                                            <%--<p class="resetCNContent">*请填写咨询内容！</p>--%>
                                            <p class="successCN">*提交成功</p>
                                            <p class="resetEN">*Please fill in the contact!</p>
                                            <p class="resetENPhone">*Please fill in the contact number!</p>
                                            <p class="resetENGSName">*Please fill in the company name!</p>
                                            <p class="resetENZWGSName">*Please fill in the debt company name!</p>
                                            <p class="resetENGJ">*Please fill in the country!</p>
                                            <p class="resetENMoney">*Please fill in the currency and amount!</p>
                                            <%--<p class="resetENContent">*Please fill in the consulting content!</p>--%>
                                            <p class="successEN">*Submitted successfully</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="panel-credit">
                        <section id="main-eleven" class="section11">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">BUSINESS INFORMATION SERVICES</p>
                                    <p class="section-title-CN">国内外企业信息服务</p>
                                </div>
                                <div class="service-box">
                                    <div class="service-tabs">
                                        <div class="tabs-box">
                                            <a href='${webRoot}/system/produce/init#4' class="service-tab" id="report">
                                                <span class="textCN">国内外企业征信报告</span>
                                                <span class="textEN">Business Credit Reports</span>
                                            </a>
                                            <a href='${webRoot}/system/produce/init#5' class="service-tab"
                                               id="authentication">
                                                <span class="textCN">企业信息认证</span>
                                                <span class="textEN">Enterprise Verification</span>
                                            </a>
                                            <a href='${webRoot}/system/produce/init#6' class="service-tab" id="system">
                                                <span class="textCN">企业信息系统</span>
                                                <span class="textEN">Information system</span>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="service-panels">
                                        <div class="service-panel" id="report-panel">
                                            <div class="panel-content">${reportContent}</div>
                                            <div class="report-content">
                                                <div class="report-content-type">
                                                    <span class="textCN">国内</span>
                                                    <span class="textEN">China</span>
                                                    <span class="textCN">国外</span>
                                                    <span class="textEN">Global</span>
                                                </div>
                                                <div class="chinese-report-title">${chineseReportTitle}</div>
                                                <div class="international-report-title">${internationalReportTitle}</div>
                                                <div>
                                                    <c:forEach var="report" items="${reportList}" varStatus="s">
                                                        <div class="report-content-box">
                                                            <div class="report-content-title">${report.text}</div>
                                                            <div class="report-content-items">
                                                                <c:forEach var="item" items="${report.childList}"
                                                                           varStatus="i">
                                                                    <div class=report-content-item">${item.text}</div>
                                                                </c:forEach>
                                                            </div>
                                                        </div>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="service-panel" id="authentication-panel">
                                            <div class="panel-content authentication-content">
                                                <img class="" src="${webRoot}${authenticationContent.src}"/>
                                                <div class="authentication-text">${authenticationContent.text}</div>
                                            </div>
                                        </div>
                                        <div class="service-panel" id="system-panel">
                                            <div class="panel-content system-content">
                                                <img class="" src="${webRoot}${systemContent.src}"/>
                                                <div class="system-text">${systemContent.text}
                                                    <div class="system-link">
                                                        <a class="link-btn" href="${systemContent.href}"
                                                           target="_blank">
                                                            <i class="iconfont"></i>
                                                            <span class="textCN">查看详情</span><span class="textEN">View Details</span>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <section id="main-twelve" class="section12">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">due diligence</p>
                                    <p class="section-title-CN">国内外尽职调查</p>
                                </div>
                                <div class="diligence-box">
                                    <div class="diligence-content">${diligenceContent}
                                        <div class="diligence-process textCN">
                                            <div class="diligence-process-item"><span>中小企业<br/>贷前调查</span></div>
                                            <div class="diligence-process-item"><span>中小企业<br/>贷中调查</span></div>
                                            <div class="diligence-process-item"><span>中小企业<br/>贷后调查</span></div>
                                            <div class="diligence-process-item"><span>反欺诈调查</span></div>
                                            <div class="diligence-process-item"><span>简单版</span></div>
                                            <div class="diligence-process-item"><span>标准版</span></div>
                                            <div class="diligence-process-item"><span>深度版</span></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <section id="main-thirteen" class="section13">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">business category</p>
                                    <p class="section-title-CN">业务类别</p>
                                </div>
                                <div class="category-box">
                                    <c:forEach var="category" items="${categoryList}" varStatus="s">
                                        <div class="category-item">
                                            <img class="category-bg"
                                                 src='${webRoot}/images/services/category-${s.count}.png'/>
                                            <div class="category-title"><span>${category}</span></div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </section>
                        <section id="main-fourteen" class="section14">
                            <div class="section-body">
                                <div class="section-title">
                                    <p class="section-title-EN">our advantage</p>
                                    <p class="section-title-CN">业务优势</p>
                                </div>
                                <div class="advantage-box">
                                    <c:forEach var="advantage" items="${advantageList}" varStatus="s">
                                        <div class="advantage-item">
                                            <div class="advantage-title-CN">${advantage.titleCN}</div>
                                            <div class="advantage-title-EN">${advantage.titleEN}</div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link rel="stylesheet" href="${webRoot}/js/plugins/cssmap-continents/cssmap-continents.css">
        <style type="text/css">
            .services-Page .section1 .services-banner {
                width: 100%;
                height: 470px;
                background: url("${webRoot}/images/services/banner.jpg") center no-repeat;
                position: relative;
            }

            .services-Page .section1 .services-tabs {
                width: 100%;
                position: absolute;
                bottom: 1px;
                left: 0;
            }

            .services-Page .section1 .tabs-box {
                width: 1100px;
                height: 94px;
                margin: 0 auto;
                text-align: center;
                display: flex;
            }

            .services-Page .section1 .services-tab {
                flex: 1;
            }
            .services-Page .section1 .services-tab a{
                display: block;
                width: 340px;
                height: 94px;
                margin: 0 auto;
            }
            .services-Page .section1 .services-tab .services-tab-CN {
                display: block;
                color: #000;
                padding-top: 27px;
                font-size: 2.2rem;
            }

            .services-Page .section1 .services-tab .services-tab-EN {
                display: block;
                color: #bb0327;
                font-size: 1.6rem;
                text-transform: capitalize;
            }
            .services-Page .section1 .services-tab:nth-of-type(1) a{
                background: url("${webRoot}/images/services/services-tab-01.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(2) a{
                background: url("${webRoot}/images/services/services-tab-02.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(3) a{
                background: url("${webRoot}/images/services/services-tab-03.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(1).active a{
                background: url("${webRoot}/images/services/services-tab-1.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(2).active a{
                background: url("${webRoot}/images/services/services-tab-2.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(3).active a{
                background: url("${webRoot}/images/services/services-tab-3.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(1):hover a{
                background: url("${webRoot}/images/services/services-tab-1.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(2):hover a{
                background: url("${webRoot}/images/services/services-tab-2.png") center no-repeat;
            }
            .services-Page .section1 .services-tab:nth-of-type(3):hover a{
                background: url("${webRoot}/images/services/services-tab-3.png") center no-repeat;
            }
            .services-Page .section1 .services-tabs .services-tab.active span{
                color: #fff;
            }

            .services-Page .section1 .services-tabs .services-tab:hover span{
                color: #fff;
            }


            .services-Page .section2 .services-box p {
                font-size: 1.6rem;
                color: #616161;
                line-height: 2.2rem;
                /*text-indent: 2em;*/
            }

            .services-Page .section2 .services-box span {
                color: #bb0327;
            }

            .services-Page .section3 .section-body{
                padding-bottom: 0;
            }
            .services-Page .section3 .category-box {
                cursor: default;
                height: 450px;
                background: url("${webRoot}/images/services/business_category.png") 0 -35px no-repeat;
                position: relative;
            }

            .services-Page .section3 .category-box li {
                position: absolute;
            }

            .services-Page .section3 .category-box li:hover {
                color: #bb0327;
            }

            .services-Page .section3 .category-box li .CN {
                font-size: 2rem;
            }

            .services-Page .section3 .category-box li .EN {
                font-size: 1rem;
                text-transform: capitalize;
            }

            .services-Page .section3 .category-box li img {
                width: 80px;
                height: 80px;
                position: absolute;
            }

            .services-Page .section3 .category-box li:nth-of-type(1) {
                text-align: right;
                left: 15px;
                bottom: 70px;
            }
            
            .services-Page .section3 .category-box li:nth-of-type(1) .EN{
            	width: 120px;
            }

            .services-Page .section3 .category-box li:nth-of-type(1) img {
                left: 146px;
                bottom: -17px;
            }

            .services-Page .section3 .category-box li:nth-of-type(2) {
                text-align: right;
                left: 137px;
                bottom: 250px;
            }

            .services-Page .section3 .category-box li:nth-of-type(2) img {
                left: 144px;
                bottom: -17px;
            }

            .services-Page .section3 .category-box li:nth-of-type(3) {
                left: 625px;
                bottom: 345px;
            }
            .services-Page .section3 .category-box li:nth-of-type(3) img {
                left: -116px;
                bottom: -29px;
            }

            .services-Page .section3 .category-box li:nth-of-type(4) {
                left: 848px;
                bottom: 250px;
            }
            .services-Page .section3 .category-box li:nth-of-type(4) img {
                left: -115px;
                bottom: -18px;
            }

            .services-Page .section3 .category-box li:nth-of-type(5) {
                left: 965px;
                bottom: 70px;
            }
            
            .services-Page .section3 .category-box li:nth-of-type(5) .EN{
           	    width: 155px;
            }
            
            .services-Page .section3 .category-box li:nth-of-type(5) img {
                left: -117px;
                bottom: -15px;
            }
            .services-Page .section4 .section-body{
                height: 672px;
                position: relative;
                padding-bottom: 0;
            }
            .services-Page .section4 .section-body::before {
                content: '';
                width: 1920px;
                height: 712px;
                background: url(${webRoot}/images/services/advantage-img-bg.png) center no-repeat;
                z-index: -1;

                /* 定位 */
                position: absolute;
                top: -40px;
                left: -410px;
            }
            .services-Page .section4 .advantages-box {
                height: auto;
                font-size: 0;
            }

            .services-Page .section4 .advantages-box .advantage-item {
                display: inline-block;
                vertical-align: top;
                width: 260px;
                height: 212px;
                margin-bottom: 40px;
                position: relative;
                transition: transform .3s;
            }

            .services-Page .section4 .advantages-box .advantage-item:hover {
                transform: translateY(-10px);
            }

            .services-Page .section4 .advantage-item:nth-of-type(odd) {
                background: url("${webRoot}/images/services/advan1.png") center center;
            }

            .services-Page .section4 .advantage-item:nth-of-type(even) {
                background: url("${webRoot}/images/services/advan2.png") center center;
            }

            .services-Page .section4 .advantage-item:nth-of-type(8n+5) {
                margin-left: 60px;
            }

            .services-Page .section4 .advantage-item .advantage-num {
                font-size: 4.2rem;
                cursor: default;
                position: absolute;
                top: 0;
                left: 13px;
            }

            .services-Page .section4 .advantage-item .advantage-img {
                width: 45px;
                height: 45px;
                position: absolute;
                top: 18px;
                left: 51px;
            }

            .services-Page .section4 .advantage-item:nth-of-type(odd) .advantage-num {
                color: #bb0327;
            }

            .services-Page .section4 .advantage-item:nth-of-type(even) .advantage-num {
                color: #000;
            }

            .services-Page .section4 .advantages-box .advantage-text {
                width: 238px;
                padding-left: 38px;
                padding-top: 90px;
            }

            .services-Page .section4 .advantages-box .advantage-title {
                font-size: 1.6rem;
                font-weight: bolder;
                padding-bottom: 28px;
                position: relative;
            }

            .services-Page .section4 .advantages-box .advantage-title::after {
                display: block;
                content: '';
                height: 4px;
                width: 30px;
                background: #bb0327;

                /* 定位 */
                position: absolute;
                left: 0;
                bottom: 7px;
            }

            .services-Page .section4 .advantages-box .advantage-content {
                font-size: 1.2rem;
                line-height: 1.4rem;
                color: #656460;
                width: 90%;
            }
        </style>
        <style type="text/css">
            .services-Page .section5 .international-services-box p {
                font-size: 1.6rem;
                color: #616161;
                line-height: 2.2rem;
                /*text-indent: 2em;*/
            }

            .services-Page .section5 .international-services-box span {
                color: #bb0327;
            }

            .services-Page .section6 {
                height: 612px;
                background: url(${webRoot}/images/credit/globalBg.png) center no-repeat;
            }

            .services-Page .section6 .global-box {
                width: 870px;
                height: 335px;
                margin-left: auto;
                position: relative;
            }

            .services-Page .section6 .global-box::before {
                content: '';
                height: 100%;
                width: 100%;
                background: url(${webRoot}/images/credit/globalBg1.png) center no-repeat;
                z-index: 9;

                /* 定位 */
                position: absolute;
                left: 22px;
                top: 22px;
            }

            .services-Page .section6 .global-box .global-content {
                height: 100%;
                width: 100%;
                background: #fff;
                z-index: 10;

                /* 定位 */
                position: absolute;
                left: 0;
                top: 0;
            }

            .services-Page .section6 .global-box .global-content .global-text {
                padding: 90px 10px 0 250px;
            }

            .services-Page .section6 .global-box .global-content .global-text p {
                font-size: 1.5rem;
                line-height: 1.7;
                padding-bottom: 25px;
            }

            .services-Page .section6 .global-box .global-content .global-text span {
                color: #bb0327;
            }

            .services-Page .section6 .global-box .global-content .global-link {
                position: absolute;
                bottom: 20px;
                right: 10px;
            }

            .services-Page .section6 .global-box .global-content .global-video {
                width: 400px;
                height: 300px;
                border: 1px #bb0327 solid;
                /* 定位 */
                position: absolute;
                left: -178px;
                top: 11px;
            }

            .services-Page .section6 .global-box .global-content .global-video video {
                background: url(${webRoot}/images/credit/videoBg.png) center no-repeat;
                width: 100%;
                height: 100%;
                /* 定位 */
                position: absolute;
                left: -15px;
                top: 15px;
            }

            .services-Page .section6 .global-box .global-content .global-video .global-video-btn {
                border-radius: 50%;
                width: 40px;
                height: 40px;
                background: #ba0c2f;
                cursor: pointer;
                /* 定位 */
                position: absolute;
                left: 165px;
                top: 145px;
            }

            .services-Page .section6 .global-box .global-content .global-video .global-video-btn::after {
                content: '';
                border-top: 10px solid transparent;
                border-bottom: 10px solid transparent;
                border-left: 17px solid white;
                /* 定位 */
                position: absolute;
                left: 14px;
                top: 10px;
            }

            .services-Page .section6 .global-box .global-content .global-video .global-video-btn:active {
                background: #fff
            }

            .services-Page .section6 .global-box .global-content .global-video .global-video-btn:active::after {
                border-left: 17px solid #ba0c2f;
            }

            .services-Page .section7 .section-title {
                transform: translate(666px, -12px);
                margin: 0;
            }

            .services-Page .section7 .section-title-EN {
                padding-left: 0;
                padding-right: 0;
            }

            .services-Page .section7 .section-title-EN::after {
                display: none;
            }

            .services-Page .section7 .section-title-EN::before {
                display: none;
            }

            .services-Page .section7 #main2 {
                position: relative;
                width: 100%;
            }

            .services-Page .section7 .menu {
                padding-left: 100px;
                z-index: 999;
                float: right;
                padding-top: 23px;
            }

            .services-Page .section7 .menu-item {
                font-size: 1.2rem;
            }

            .services-Page .section7 .menuTitle {
                text-decoration: none;
                color: #0d0d0d;
                display: block;
                border-top: 1px solid #000;
                padding: 8px 14px;
                cursor: pointer;
            }

            .services-Page .section7 .menuTitle i {
                float: right;
                font-size: 1.4rem;
            }

            .services-Page .section7 .menuTitle.active1 {
                background: #D20814 !important;
                color: #fff;
            }

            .services-Page .section7 .menuTitle:hover {
                background: #D20814 !important;
                color: #fff;
            }

            .services-Page .section7 .menuCon {
                padding: 14px 0 14px 14px;
                overflow: hidden;
                display: none;
            }

            .services-Page .section7 .menuCon ol li {
                float: left;
                margin-bottom: 5px;
            }

            .services-Page .section7 .rotate {
                transform-origin: center center;
                -webkit-transform: rotate(90deg);
                -moz-transform: rotate(90deg);
                -ms-transform: rotate(90deg);
                -o-transform: rotate(90deg);
                transition: transform 0.2s;
                -webkit-transition: -webkit-transform 0.2s;
                -moz-transition: -moz-transform 0.2s;
                -o-transition: -o-transform 0.2s;
            }

            .services-Page .section7 .rotate1 {
                transform-origin: center center;
                -webkit-transform: rotate(0deg);
                -moz-transform: rotate(0deg);
                -ms-transform: rotate(0deg);
                -o-transform: rotate(0deg);
                transition: transform 0.2s;
                -webkit-transition: -webkit-transform 0.2s;
                -moz-transition: -moz-transform 0.2s;
                -o-transition: -o-transform 0.2s;
            }

            .services-Page .section8 {
                height: 598px;
                background: url(${webRoot}/images/credit/category-bg.jpg) center no-repeat;
            }

            .services-Page .section8 .international-category-box {
                height: 400px;
                width: 100%;
                position: relative;
            }

            .services-Page .section8 .international-category-box .international-category-item {
                height: 151px;
                width: 151px;
                color: #fff;
                position: absolute;
                cursor: default;
            }

            .services-Page .section8 .international-category-box .international-category-item::after {
                content: '';
                display: block;
                height: 100%;
                width: 100%;
                background: #000;
                opacity: .6;
                z-index: 9;
                transform: rotate(45deg);
                position: absolute;
                top: 0;
                left: 0;
            }

            .services-Page .section8 .international-category-box .international-category-item:hover::after {
                background: #ba0c2f;
                opacity: 1;
            }

            .services-Page .section8 .international-category-box .international-category-item .international-category-text {
                z-index: 10;
                width: 100%;
                text-align: center;
                position: absolute;
                top: 55px;
                left: 0;
            }

            .services-Page .section8 .international-category-box .international-category-item .international-category-CN {
                display: block;
                font-size: 2rem;
            }

            .services-Page .section8 .international-category-box .international-category-item .international-category-EN {
                font-size: 1.2rem;
                text-transform: capitalize;
                padding-top: 3px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(-n+6) {
                top: 50px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(n+6) {
                top: 160px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(1) {
                left: 32px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(2) {
                left: 252px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(3) {
                left: 472px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(4) {
                left: 692px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(5) {
                left: 912px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(6) {
                left: 142px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(7) {
                left: 362px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(8) {
                left: 582px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(9) {
                left: 802px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(1)::before {
                content: '';
                display: block;
                height: 40px;
                width: 100%;
                background: transparent;
                border-left: 6px #ba0c2f solid;
                border-right: 6px #ba0c2f solid;
                border-bottom: 6px #ba0c2f solid;
                z-index: 9;
                transform: rotate(45deg);
                position: absolute;
                bottom: -74px;
                left: -22px;
            }

            .services-Page .section8 .international-category-box .international-category-item:nth-of-type(5)::before {
                content: '';
                display: block;
                height: 40px;
                width: 100%;
                background: transparent;
                border-left: 6px #ba0c2f solid;
                border-right: 6px #ba0c2f solid;
                border-bottom: 6px #ba0c2f solid;
                z-index: 9;
                transform: rotate(-45deg);
                position: absolute;
                bottom: -74px;
                left: 9px;
            }

            .services-Page .section9 .section-body {
                padding-bottom: 0;
            }

            .services-Page .section9 .international-advantages-box {
                position: relative;
            }

            .services-Page .section9 .international-advantages-box .swiper-advantages-prev {
                position: absolute;
                top: 75px;
                left: 60px;
                width: 35px;
                height: 35px;
                cursor: pointer;
                background: url(${webRoot}/images/services/prev-btn.png) no-repeat;
            }

            .services-Page .section9 .international-advantages-box .swiper-advantages-next {
                position: absolute;
                top: 75px;
                right: 60px;
                width: 35px;
                height: 35px;
                cursor: pointer;
                background: url(${webRoot}/images/services/next-btn.png) no-repeat;
            }

            .services-Page .section9 #swiper-international-advantages {
                height: 300px;
                width: 830px;
                margin: 0 auto;
            }

            .services-Page .section9 .international-advantages-img {
                width: 420px;
                height: 300px;
                display: inline-block;
            }

            .services-Page .section9 .international-advantages-content {
                width: 300px;
                height: 300px;
                display: inline-block;
                vertical-align: top;
                padding-left: 50px;
                font-size: 1.8rem;
            }

            .services-Page .section9 .international-advantages-title {
                padding-top: 67px;
                padding-bottom: 17px;
                color: black;
                font-weight: bolder;
                position: relative;
            }

            .services-Page .section9 .international-advantages-title span {
                color: #ba0c2f;
                font-size: 2.0rem;
            }

            .services-Page .section9 .international-advantages-title::after {
                content: '';
                display: block;
                height: 4px;
                width: 30px;
                background: #ba0c2f;
                /*定位*/
                position: absolute;
                bottom: 7px;
                left: 0;
            }

            .services-Page .section9 .international-advantages-mark {
                padding-top: 6px;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            .services-Page .section9 .international-advantages-mark span {
                display: inline-block;
                height: 10px;
                width: 10px;
                background: #999;
                margin-right: 4px;
                border-radius: 50%;
            }

            .services-Page .section9 .international-advantages-mark span.active {
                background: #ba0c2f;
            }

            .services-Page .section10 {
                background: #f7f7f7;
            }

            .services-Page .section10 .consultation-info {
                overflow: hidden;
                margin: 15px 0;
            }

            .services-Page .section10  input, .services-Page .section10 textarea {
                font-family: 'Microsoft YaHei';
                font-size: 1.4rem;
            }

            .services-Page .section10 .consultation-info ul li {
                width: 260px;
                height: 40px;
                margin-right: 20px;
                border: 1px solid #E1DFDA;
                float: left;
                position: relative;
                box-sizing: border-box;
                background: #fff;
            }

            .services-Page .section10 .consultation-info ul li:last-child {
                margin-right: 0;
            }

            .services-Page .section10 .consultation-info ul li span {
                display: inline-block;
                font-size: 1.4rem;
                margin-left: 20px;
                margin-top: 9px;
            }

            .services-Page .section10 .consultation-info ul li input {
                border: none;
                height: 37px;
                display: inline-block;
                padding-left: 20px;
                width: calc(100% - 31px);
            }

            .services-Page .section10 .consultation-info:nth-of-type(1) li::before {
                display: block;
                content: '';
                width: 2px;
                height: 20px;
                background: #ba0c2f;
                position: absolute;
                left: -1px;
                top: 11px;
            }

            .services-Page .section10 .consultation-info ul li i {
                color: #ba0c2f;
                margin-left: 8px;
                font-size: 20px;
                display: inline-block;
                vertical-align: middle;
                float: left;
                margin-top: 6px;
            }

            .services-Page .section10 .consultation-content {
                margin-top: 20px;
                border: 1px solid #E1DFDA;
            }

            .services-Page .section10 .consultation-content textarea {
                width: 100%;
                min-height: 100px;
                resize: none;
                border: none;
                padding: 10px;
                line-height: 20px;
            }

            .services-Page .section10 .consultation-btn {
                text-align: center;
                margin-top: 40px;
            }
            .services-Page .section10 .section-body {
                padding-bottom: 40px;
            }

            .services-Page .section10 .consultation-btn button {
                width: 260px;
                height: 40px;
                color: #fff;
                background: #ba0c2f;
                line-height: 40px;
                border: none;
                cursor: pointer;
                border-radius: 5px;
            }

            .services-Page .section10 .consultation-btn p {
                display: none;
                color: #ba0c2f;
                margin: 7px 0;
            }

            .services-Page .section10 .consultation-btn .successCN, .services-Page .section10 .consultation-btn .successEN {
                color: #6CB346 !important;
            }

            .services-Page .section10 .consultation-info ul li > p {
                position: absolute;
                right: 10px;
                top: 10px;
                font-size: 1.3rem;
                color: #777;
            }
        </style>
        <style type="text/css">
            .services-Page .section11 .section-body {
                cursor: default;
                padding-bottom: 0;
            }

            .services-Page .section11 .service-box .service-tabs {
                width: 550px;
                margin: 0 auto;
                text-align: center;
            }

            .services-Page .section11 .service-box .service-tabs .tabs-box {
                display: flex;
                border: 1px #bb0327 solid;
                box-sizing: border-box;
                border-radius: 5px;
            }

            .services-Page .section11 .service-box .service-tabs .service-tab {
                display: block;
                flex: 1;
                font-size: 1.5rem;
                line-height: 33px;
                color: #bb0327;
                cursor: pointer;
                position: relative;
            }

            .services-Page .section11 .service-box .service-tabs .service-tab .textEN {
                text-transform: capitalize;
                font-size: 1rem;
            }

            .services-Page .section11 .service-box .service-tabs .service-tab:nth-of-type(-n+2)::after {
                display: block;
                content: '';
                height: 100%;
                width: 1px;
                background: #bb0327;

                /* 定位 */
                position: absolute;
                right: 0;
                top: 0;
            }

            .services-Page .section11 .service-box .service-tabs .service-tab.active {
                color: #fff;
                background-color: #bb0327;
            }

            .services-Page .section11 .service-box .service-tabs .service-tab.active::before {
                content: '';
                border-top: 10px solid #bb0327;
                border-right: 10px solid transparent;
                border-left: 10px solid transparent;

                /* 定位 */
                position: absolute;
                right: 80px;
                bottom: -7px;
            }

            .services-Page .section11 .service-box .service-tabs .service-tab:hover {
                color: #fff;
                background-color: #bb0327;
            }

            .services-Page .section11 .service-box .service-panel {
                display: none;
            }

            .services-Page .section11 .service-box .service-panel .panel-content {
                color: #666;
                font-size: 1.5rem;
                padding: 40px 0;
                line-height: 2;
                text-align: justify;
            }

            .services-Page .section11 .service-box #report-panel .panel-content span {
                color: #bb0327;
                font-size: 2rem;
            }

            .services-Page .section11 .service-box #report-panel .report-content::before {
                content: "";
                background: url("${webRoot}/images/services/report-bg.png") center no-repeat;
                width: 1920px;
                height: 500px;
                position: absolute;
                z-index: -1;
                left: -410px;
            }

            .services-Page .section11 .service-box #report-panel .report-content {
                background: url("${webRoot}/images/services/report-bg-2.png") center no-repeat;
                height: 500px;
                position: relative;
            }

            .services-Page .section11 .service-box #report-panel .report-content-type {
                color: #fff;
                font-size: 1.8rem;
                position: absolute;
                top: 235px;
                left: 464px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-type span:nth-of-type(1) {
                margin-left: 15px;
                margin-right: 78px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-type span:nth-of-type(2) {
                margin-left: 8px;
                margin-right: 64px;
            }

            .services-Page .section11 .service-box #report-panel .chinese-report-title {
                color: #fff;
                font-size: 2.2rem;
                position: absolute;
                top: 29px;
                left: 17px;
            }

            .services-Page .section11 .service-box #report-panel .chinese-report-title::before {
                content: "";
                width: 6px;
                height: 19px;
                background: #bb0327;
                position: absolute;
                top: 5px;
                left: -10px;
            }

            .services-Page .section11 .service-box #report-panel .international-report-title {
                color: #fff;
                font-size: 2.2rem;
                position: absolute;
                top: 29px;
                right: 17px;
            }

            .services-Page .section11 .service-box #report-panel .international-report-title::before {
                content: "";
                width: 6px;
                height: 19px;
                background: #1a73e1;
                position: absolute;
                top: 5px;
                right: -10px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box {
                width: 350px;
                height: 85px;
                text-align: right;
                position: absolute;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(1) {
                top: 116px;
                right: 736px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(2) {
                top: 234px;
                right: 786px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(3) {
                top: 347px;
                right: 735px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(4) {
                text-align: left;
                top: 231px;
                left: 787px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box .report-content-title {
                color: #bb0327;
                font-size: 2rem;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box .report-content-title::after {
                content: "";
                width: 4px;
                height: 17px;
                background: #bb0327;
                position: absolute;
                top: 5px;
                right: -12px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box .report-content-title::before {
                content: "";
                width: 6px;
                height: 6px;
                background: #bb0327;
                border-radius: 10px;
                position: absolute;
                top: 11px;
                right: -24px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box .report-content-items {
                font-size: 0;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box .report-content-items div {
                color: #fff;
                font-size: 1.4rem;
                display: inline-block;
                margin-left: 15px;
                position: relative;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box .report-content-items div::after {
                content: "";
                width: 2px;
                height: 13px;
                position: absolute;
                top: 3px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box .report-content-items div:hover {
                color: #bb0327;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(4) .report-content-title {
                color: #1a73e1;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(4) .report-content-title::after {
                background: #1a73e1;
                left: -12px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(4) .report-content-title::before {
                background: #1a73e1;
                left: -24px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(4) .report-content-items div {
                margin-left: 0;
                margin-right: 15px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(-n+3) .report-content-items div::after {
                background: #bb0327;
                left: -8px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(4) .report-content-items div::after {
                background: #1a73e1;
                right: -8px;
            }

            .services-Page .section11 .service-box #report-panel .report-content-box:nth-of-type(4) .report-content-items div:hover {
                color: #1a73e1;
            }

            .services-Page .section11 .service-box .service-panel .authentication-content {
                height: 220px;
                width: 730px;
                margin: 0 auto;
                position: relative;
                text-align: left;
            }

            .services-Page .section11 .service-box .service-panel .authentication-content img {
                height: 220px;
                width: 270px;
            }

            .services-Page .section11 .service-box .service-panel .authentication-content .authentication-text {
                width: 400px;
                font-size: 1.6rem;
                line-height: 1.6;
                position: absolute;
                top: 50%;
                left: 270px;
                transform: translateY(-50%);
                text-align: justify;
            }

            .services-Page .section11 .service-box .service-panel .system-content {
                height: 260px;
                width: 850px;
                margin: 0 auto;
                position: relative;
                text-align: left;
            }

            .services-Page .section11 .service-box .service-panel .system-content img {
                height: 260px;
                width: 440px;
            }

            .services-Page .section11 .service-box .service-panel .system-content .system-text {
                width: 375px;
                font-size: 1.6rem;
                line-height: 1.6;
                position: absolute;
                top: 50%;
                left: 470px;
                transform: translateY(-50%);
                text-align: justify;
            }

            .services-Page .section11 .service-box .service-panel .system-content .system-link {
                padding-top: 20px;
            }
        </style>
        <style type="text/css">
            .services-Page .section12 .section-body {
                cursor: default;
                padding-bottom: 0;
                height: 414px;
                position: relative;
            }

            .services-Page .section12 .section-body::before {
                content: '';
                width: 1920px;
                height: 414px;
                background: url(${webRoot}/images/services/diligence-bg.jpg) center no-repeat;
                z-index: -1;

                /* 定位 */
                position: absolute;
                top: -40px;
                left: -410px;
            }

            .services-Page .section12 .diligence-box {
                width: 100%;
                height: 245px;
                position: relative;
            }

            .services-Page .section12 .diligence-content {
                width: 100%;
                position: absolute;
                left: 0;
                top: 50%;
                transform: translateY(-50%);
                color: #666;
                text-align: center;
                line-height: 1.8;
                font-size: 1.5rem;
            }

            .services-Page .section12 .diligence-process {
                width: 700px;
                height: 145px;
                padding-top: 40px;
                margin: 0 auto;
                position: relative;
            }

            .services-Page .section12 .diligence-process-item {
                width: 100px;
                height: 100px;
                border-radius: 100%;
                background: #282d40;
                position: absolute;
                top: 40px;
                color: #fff;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(1) {
                left: 37px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(2) {
                left: 225px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(3) {
                left: 413px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(4) {
                left: 600px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(n+5) {
                width: 40px;
                height: 40px;
                background: #bb0327;
                font-size: 1rem;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(5) {
                left: 5px;
                top: 127px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(6) {
                left: 67px;
                top: 146px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(7) {
                left: 129px;
                top: 127px;
            }

            .services-Page .section12 .diligence-process-item span {
                width: 100%;
                position: absolute;
                top: 50%;
                left: 0;
                transform: translateY(-50%);
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(-n+4)::before {
                content: '';
                width: 110px;
                height: 60px;
                background: url(${webRoot}/images/services/diligence-line.png) center no-repeat;
                z-index: -1;

                /* 定位 */
                position: absolute;
                top: 0;
                left: -98px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(1)::before {
                content: '';
                width: 140px;
                height: 90px;
                background: url(${webRoot}/images/services/diligence-line2.png) center no-repeat;
                z-index: -1;

                /* 定位 */
                position: absolute;
                top: 44px;
                left: -20px;
            }

            .services-Page .section12 .diligence-process-item:nth-of-type(3)::before {
                transform: rotate(180deg);
                /* 定位 */
                position: absolute;
                top: 44px;
                left: -98px;
            }

            .services-Page .section13 .section-body {
                cursor: default;
            }

            .services-Page .section13 .category-box {
                height: 330px;
                width: 750px;
                margin: 0 auto;
                display: flex;
            }

            .services-Page .section13 .category-box .category-item {
                height: 220px;
                width: 150px;
                position: relative;
            }

            .services-Page .section13 .category-box .category-item:nth-of-type(even) {
                transform: translateY(50%);
            }

            .services-Page .section13 .category-box .category-bg {
                height: 220px;
                width: 150px;
            }

            .services-Page .section13 .category-box .category-title {
                color: #fff;
                position: absolute;
                bottom: 25%;
                transform: translateY(50%);
                width: 150px;
            }

            .services-Page .section13 .category-box .category-title span {
                display: block;
                width: 90px;
                font-size: 1.6rem;
                line-height: 1.4;
                text-align: center;
                margin: 0 auto;
            }

            .services-Page .section14 .section-body {
                cursor: default;
                padding-bottom: 0;
                height: 508px;
                position: relative;
            }

            .services-Page .section14 .section-body::before {
                content: '';
                width: 1920px;
                height: 548px;
                background: url(${webRoot}/images/services/advantage-bg.jpg) center no-repeat;
                z-index: -1;

                /* 定位 */
                position: absolute;
                top: -40px;
                left: -410px;
            }

            .services-Page .section14 .advantage-box {
                width: 760px;
                height: 380px;
                margin: 0 auto;
                position: relative;
            }

            .services-Page .section14 .advantage-box::before {
                content: '';
                width: 760px;
                height: 380px;
                background: url(${webRoot}/images/services/advantage-bg2.png) center no-repeat;
                z-index: -1;

                /* 定位 */
                position: absolute;
                top: -40px;
                left: 0;
            }

            .services-Page .section14 .advantage-item {
                width: 100px;
                height: 70px;
                position: absolute;
                color: #fff;
                line-height: 1.6;
                text-align: center;
            }

            .services-Page .section14 .advantage-item:hover {
                font-weight: bolder;
            }

            .services-Page .section14 .advantage-title-CN {
                font-size: 2rem;
            }

            .services-Page .section14 .advantage-title-EN {
                font-size: 1.4rem;
            }

            .services-Page .section14 .advantage-item:nth-of-type(2) .advantage-title-CN,
            .services-Page .section14 .advantage-item:nth-of-type(4) .advantage-title-CN,
            .services-Page .section14 .advantage-item:nth-of-type(5) .advantage-title-CN {
                color: #000;
            }

            .services-Page .section14 .advantage-item:nth-of-type(2) .advantage-title-EN,
            .services-Page .section14 .advantage-item:nth-of-type(4) .advantage-title-EN,
            .services-Page .section14 .advantage-item:nth-of-type(5) .advantage-title-EN {
                color: #bb0327;
            }

            .services-Page .section14 .advantage-item:nth-of-type(1) {
                top: 82px;
                left: 33px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(2) {
                top: 148px;
                left: 147px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(3) {
                top: 82px;
                left: 264px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(4) {
                top: 148px;
                left: 381px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(5) {
                top: 82px;
                left: 500px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(6) {
                top: 14px;
                left: 616px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(7) {
                top: 207px;
                left: 264px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(8) {
                top: 210px;
                left: 500px;
            }

            .services-Page .section14 .advantage-item:nth-of-type(9) {
                top: 148px;
                left: 616px;
            }
        </style>
        
    </tiles:putAttribute>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type="text/javascript" src="${webRoot}/js/plugins/cssmap-continents/jquery.cssmap.min.js"></script>
        <script type="text/javascript">
            //国际地图开始
            $('.menu').css('width', 'calc(100% - 750px)');
            var liActive = null;
            document.getElementById('main2').addEventListener('click', function (e) {
                var objLi = $(this).find('ul li');
                var index = 0;
                objLi.each(function () {
                    liActive = $(this).attr('class').indexOf('active-region');
                    var liFocus = $(this).attr('class').indexOf('focus');
                    if (liFocus > 0) {
                        index = parseInt(this.classList[0].substring(1, 2));
                        active(index - 1);
                        active(index + 6 - 1);
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
                    active(index - 1);
                    active(index + 6 - 1);
                    active1(index - 1);
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
        </script>
        <script type="text/javascript">

            // 国内外企业信息服务切换
            $('.service-tab').on('click', function () {
                $(this).addClass('active').siblings().removeClass('active');
                let index = $(this).index(),
                    $panel = $('.service-panel'); // 模块
                $panel.eq(index).show().siblings().hide();
            });

            //切换业务tab
            $('.services-tab').on('click', function () {
                $(this).addClass('active').siblings().removeClass('active');
                let id = $(this).attr('id'),
                    $navs = $('.nav-ul li'), // 总导航
                    $subNavs = $('.nav-' + id), // 模块导航
                    $panel = $('.panel-' + id); // 模块
                $navs.hide();
                $subNavs.show();
                $subNavs.eq(0).addClass('active').siblings().removeClass('active');
                $panel.show().siblings().hide();
                if (id === 'international') {
                    $("#main2").CSSMap({
                        "size": 650
                    })
                    //国际优势轮播
                    let internationalAdvantagesSwiper = new Swiper('#swiper-international-advantages', {
                        slidesPerView: 1,
                        loop: true,
                        autoplay: {
                            disableOnInteraction: false,
                            delay: 5000
                        },
                        navigation: {
                            nextEl: '.swiper-advantages-next',
                            prevEl: '.swiper-advantages-prev',
                        }
                    });

                    /*鼠标移入停止轮播，鼠标离开 继续轮播*/
                    let internationalAdvantages = document.getElementById('swiper-international-advantages');
                    internationalAdvantages.onmouseover = function () {
                        internationalAdvantagesSwiper.autoplay.stop();
                    };
                    internationalAdvantages.onmouseleave = function () {
                        internationalAdvantagesSwiper.autoplay.start();
                    };
                }
                if (id === 'credit') {
                    if (window.location.hash === '#4') $("#report").click();
                    else if (window.location.hash === '#5') $("#authentication").click();
                    else if (window.location.hash === '#6') $("#system").click();
                    else $("#report").click()
                }
            });

            //切换业务tab
            function changeServices(mark) {
                if (mark === '#1') {
                    $("#domestic").click();
                } else if (mark === '#2') {
                    $("#international").click();
                } else if (mark === '#3' || mark === '#4' || mark === '#5' || mark === '#6') {
                    $("#credit").click();
                } else {
                    $("#domestic").click();
                }
            }

            //根据url跳转相应位置
            changeServices(window.location.hash);
            // 联动header和footer
            $('.services-link').on('click', function () {
                let mark = $(this).attr('href') || $(this).attr('value');
                mark = mark.substring(mark.length - 2);
                scrollTop();
                changeServices(mark)
            });

            //视频播放机制
            let video = document.getElementById('global-video');

            function videoPlay() {
                video.play(); //播放控制
                $('.global-video-btn').hide();
                video.addEventListener("pause", function () {
                    videoPause();
                }, false);
            }

            function videoPause() {
                if (video === undefined) return;
                video.pause(); //暂停控制
                $('.global-video-btn').show();
            }

            $(document).keydown(function (e) {
                if (!e) e = window.event;
                if (video !== undefined && e.keyCode === 32) {
                    video.paused ? videoPlay() : videoPause();
                    return false
                }
            });


            //免费咨询
            $("#sendBtn").on("click", function () {
                sendBtn();
            });

            function sendBtn() {
                redisFlag = cookie.get("redisFlag");
                if (redisFlag === undefined) {
                    redisFlag = '0';
                }
                let languageMark = redisFlag !== '1' ? 'CN' : 'EN',
                name = $('#Contact' + languageMark).val(),
                tel = $('#Telephone' + languageMark).val(),
                company = $('#Company' + languageMark).val(),
                mailbox = $('#Email' + languageMark).val(),
                debtorName = $('#Name' + languageMark).val(),
                debtorCountry = $('#Country' + languageMark).val(),
                overdueDays = $('#Day' + languageMark).val(),
                amount = $('#Amount' + languageMark).val(),
                content = $('#content' + languageMark).val();
                if (name === '') {
                    $('.reset' + languageMark).show().siblings().hide();
                    return false;
                }else if (tel === '') {
                    $('.reset' + languageMark + 'Phone').show().siblings().hide();
                    return false;
                } else if (languageMark==='CN'&&!/^1[34578]\d{9}$/.test(tel)) {
                    $('.reset' + languageMark + 'Phone').show().siblings().hide();
                    return false;
                } else if (company === '') {
                    $('.reset' + languageMark + 'GSName').show().siblings().hide();
                    return false;
                } else if (debtorName === '') {
                    $('.reset' + languageMark + 'ZWGSName').show().siblings().hide();
                    return false;
                } else if (debtorCountry === '') {
                    $('.reset' + languageMark + 'GJ').show().siblings().hide();
                    return false;
                } else if (amount === '') {
                    $('.reset' + languageMark + 'Money').show().siblings().hide();
                    return false;
                // } else if (content === '' || strlen(content) > 1000) {
                //     $('.reset' + languageMark + 'Content').show().siblings().hide();
                //     return false;
                }
                $.post("saveAction.json", {
                    "name": name,
                    "tel": tel,
                    "company": company,
                    "mailbox": mailbox,
                    "debtorName": debtorName,
                    "debtorCountry": debtorCountry,
                    "overdueDays": overdueDays,
                    "amount": amount,
                    "content": content
                }, function (ret) {
                    if (ret.serviceResult.success) {
                        $('.success' + languageMark).show().siblings().hide();
                        $('.consultation-info ul li input').val('');
                        $(".consultation-content textarea").val('');
                    }
                })/*.error(function () {
                    Common.error(redisFlag !== '1' ?"发送失败，请稍后再试":"Failed to send, please try again later", function () {});
                })*/;
            }

        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>