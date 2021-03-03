<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="关于我们"/>
    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="culturePage">
            <ul class="nav-ul">
                <li value="#main-two" class="active" id="our-culture">
                    <p class="textCN">我们的文化</p>
                    <p class="textEN">Our Culture</p>
                </li>
                <li value="#main-three">
                    <p class="textCN">我们的员工</p>
                    <p class="textEN">Our Staff</p>
                </li>
                <li value="#main-four">
                    <p class="textCN">联信社区</p>
                    <p class="textEN">Community</p>
                </li>
                <li value="#main-five">
                    <p class="textCN">艺术品鉴</p>
                    <p class="textEN">Art Appreciation</p>
                </li>
                <li value="#main-six">
                    <p class="textCN">企业标志</p>
                    <p class="textEN">Logo</p>
                </li>
            </ul>
            <div class="index-main">
                <div id="main-one" class="section1">
                    <div class="company-banner"></div>
                </div>
                <section id="main-two" class="section2">
                    <div class="section-body">

                        <div class="section-title">
                            <p class="section-title-EN">our culture</p>
                            <p class="section-title-CN">我们的文化</p>
                        </div>
                        <div class="culture-box">
                            <div class="culture-tab">
                                <img class="culture-bg" src="${webRoot}/images/aboutUsAll/culture/box-bg.png"/>
                                <div class="culture-item item01">
                                    <div class="culture-item-active"></div>
                                    <div class="culture-item-con">
                                        <span class="textCN">核心<br>价值观</span>
                                        <span class="textEN">Core<br>Value</span>
                                    </div>
                                </div>
                                <div class="culture-item item02">
                                    <div class="culture-item-active"></div>
                                    <div class="culture-item-con">
                                        <span class="textCN">企业<br>愿景</span>
                                        <span class="textEN">Company<br>Vision</span>
                                    </div>
                                </div>
                                <div class="culture-item item03">
                                    <div class="culture-item-active"></div>
                                    <div class="culture-item-con">
                                        <span class="textCN">业务<br>定位</span>
                                        <span class="textEN">Business<br>Positioning</span>
                                    </div>
                                </div>
                                <div class="culture-item item04">
                                    <div class="culture-item-active"></div>
                                    <div class="culture-item-con">
                                        <span class="textCN">我们<br>的准则</span>
                                        <span class="textEN">Our<br>Principle</span>
                                    </div>
                                </div>
                                <div class="culture-item item05">
                                    <div class="culture-item-active"></div>
                                    <div class="culture-item-con">
                                        <!-- <span class="textCN">联信<br>Style</span>
                                        <span class="textEN">INTER-CREDIT<br>Style</span> -->
                                        <span class="textCN">企业<br>灵魂</span>
                                        <span class="textEN">Spirit of<br>Inter-Credit</span>
                                    </div>
                                </div>
                            </div>
                            <div class="culture-tab-con">
                                <div class="item01">
                                    <div class="culture-title">
                                        <div class="EN">CORE VALUE</div>
                                        <div class="CN">核心价值观</div>
                                    </div>
                                    <div class="culture-content">
                                        <p class="textCN">对客户、债务人、员工有价值</p>
                                        <p class="textEN">Be Valuable to Clients, Debtors and Colleagues</p>
                                        <p class="our-principle textCN">我们秉持着像管理自己的资产一样管理客户资产的理念。我们为客户提供的逾期账款催收服务能够在维护客户权益的同时更好地避免客户和欠款人之间出现紧张的对立关系，对于维护客户业务的可持续发展具有重要意义。</p>
                                        <p class="our-principle textEN">Inter-Credit has been always upholding the belief of "Manage clients' assets like managing our own”. Our amicable collection service protects clients’ rights and interests while avoiding the tension between clients and debtors, which is of great significance for our clients to boost sustainable development.</p>
                                        <p class="our-principle textCN">在工作中秉持着较高的职业道德和人文精神。在面对债务人时，我们做到尊重债务人的人格尊严和基本人权，不对债务人的工作、生活造成不良影响，通过非诉的方式，以电话、传真、信函、拜访、会面等合法的手段，对债务人进行谈判施压，以追回欠款、挽回损失。</p>
                                        <p class="our-principle textEN">We uphold a high professional ethics and humanistic spirit at work. In the face of the debtors, we respect their personal dignity and human rights and do not bring bad influence on their work and life. Through non-litigation means, such as phone calls, fax, letters, on-site visit, meeting and other legal means, we negotiate with the debtors to recover the arrears.</p>
                                        <p class="our-principle textCN">员工作为公司的核心资产之一，我们为其创造积极、放松、注意力高度集中的工作氛围以及为其提供贴心的员工福利，激发员工的工作激情。同时，我们注重员工职业素养及个人能力提升，为其提供培训机会及平台，帮助员工自我成长，实现自我价值。</p>
                                        <p class="our-principle textEN">As one of the company's core assets, we create a positive, relaxing and highly focused working atmosphere for our employees, and provide considerate benefits to inspire their passion. At the same time, we focus on the improvement of employees' professional quality and personal ability, providing training opportunities to help them improve and achieve their self-worth.</p>
                                    </div>
                                </div>
                                <div class="item02">
                                    <div class="culture-title">
                                        <div class="EN">COMPANY VISION</div>
                                        <div class="CN">企业愿景</div>
                                    </div>
                                    <div class="culture-content">
                                        <p class="textCN">成为金融领域最值得信赖的企业</p>
                                        <p class="textEN">Becoming the most Trustworthy Enterprise in the Financial Field</p>
                                    </div>
                                </div>
                                <div class="item03">
                                    <div class="culture-title">
                                        <div class="EN">BUSINESS POSITIONING</div>
                                        <div class="CN">业务定位</div>
                                    </div>
                                    <div class="culture-content">
                                        <p class="textCN">联信致力于为金融、保险、投资和国际贸易等高端客户提供专业性很强的风险管理服务</p>
                                        <p class="textEN">Inter-Credit devotes to providing professional risk management services for high-end customers, like banks, insurance companies, investors & international traders.</p>
                                    </div>
                                </div>
                                <div class="item04">
                                    <div class="culture-title">
                                        <div class="EN">OUR PRINCIPLE</div>
                                        <div class="CN">我们的准则</div>
                                    </div>
                                    <div class="culture-content">
                                        <p class="our-principle textCN">
                                            要忠实的维护客户的长远利益，必要时应当放弃自身的短期利益。客户不仅仅是我们长期的商业伙伴，还是终生的朋友和姐妹。</p>
                                        <p class="our-principle textEN">We protect our clients' long-term interests, even if it means to give up our own.
                                            We consider our clients not only as business partners, but also as sisters and friends.
                                        </p>
                                        <p class="our-principle textCN">
                                            员工、资本和公司声誉是公司的核心资产。而公司声誉是建立困难但折损容易的。我们切实承诺，工作中的每项言行都坚决的遵循法律、法规和职业道德的约束以及社会和谐发展的需要。</p>
                                        <p class="our-principle textEN">The staff, capital and reputation are our core assets. Among those, reputation is the most vulnerable and most difficult to restore. We shall always honor our commitment to fully comply with the laws, rules, professional ethics and the needs of social development.</p>
                                        <p class="our-principle textCN">
                                            盈利能力对于我们实现更高的回报，积累资本，吸引和留住人才至关重要。但追求利润的同时，我们要谨防『见利忘义』的情况产生。</p>
                                        <p class="our-principle textEN">Profitability is critical in achieving superior returns, accumulating capital and attracting talents. However, we shall never disregard moral principles in pursuit of profit.</p>
                                        <p class="our-principle textCN">我们的专业化程度和业内经验是我们引以为荣的。追求卓越是我们坚定的、从不犹豫的诉求。</p>
                                        <p class="our-principle textEN">We take great pride in our professionalism and rich experience in the industry. It is our uncompromising determination to achieve excellence and sustainable growth in everything we undertake.</p>
                                        <p class="our-principle textCN">
                                            我们一惯强调团队精神。在不断鼓励个人创新的同时，我们认为团队合作往往能带来最理想的效果。我们不会容忍那些置个人利益于公司和客户利益之上的人。</p>
                                        <p class="our-principle textEN">We value teamwork in everything we do. While encouraging individual innovation, we believe that team effort often produces the best results. We have no room for those who put their personal interests ahead of the interests of the company and its clients.</p>
                                        <p class="our-principle textCN">
                                            我们的员工对公司的奉献以及对工作付出的努力和热忱超越了大多数其他同业。我们认为这是我们成功的一个重要因素。</p>
                                        <p class="our-principle textEN">Our colleagues' dedication to the company and their commitments to the work are greater than one could find in most other peer companies. We believe this is an important factor of our success.</p>
                                        <p class="our-principle textCN">
                                            维护公平、正义和诚信体现着我们服务的价值。面对任何人和任何事我们都要保持较高的道德准则。不管是债务人还是受调查公司，他们的尊严和利益必须得到尊重。</p>
                                        <p class="our-principle textEN">Fairness, Integrity and honesty reflects the value of our service. We expect our colleagues to maintain high ethical standards in everything they do. Whether it's a debtor or a company under investigation, their interests and integrity must be respected.</p>
                                    </div>
                                </div>
                                <div class="item05">
                                    <div class="culture-title">
                                        <div class="EN">SPIRIT OF INTER-CREDIT</div>
                                        <div class="CN">企业灵魂</div>
                                    </div>
                                    <div class="culture-content">
                                    	<ul>
                                    		<li>
                                                <div class="EN">LOVE</div>
                                            </li>
                                            <li>
                                                <div class="EN">PASSION</div>
                                            </li>
                                            <li style="flex: 1.2;">
                                                <div class="EN">LIGHTNESS</div>
                                            </li>
                                    	</ul>
                                        <!-- <ul>
                                            <li>
                                                <div class="CN">团结</div>
                                                <div class="EN">SOLIDARITY</div>
                                            </li>
                                            <li>
                                                <div class="CN">友爱</div>
                                                <div class="EN">FRIENDSHIP</div>
                                            </li>
                                            <li>
                                                <div class="CN">坚毅</div>
                                                <div class="EN">PERSEVERANCE</div>
                                            </li>
                                            <li>
                                                <div class="CN">高效</div>
                                                <div class="EN">EFFICIENCY</div>
                                            </li>
                                            <li>
                                                <div class="CN">热情</div>
                                                <div class="EN">ENTHUSIASM</div>
                                            </li>
                                            <li>
                                                <div class="CN">挑战</div>
                                                <div class="EN">CHALLENGE</div>
                                            </li>
                                        </ul> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="main-three" class="section3 gray">
                    <div class="section-body">

                        <div class="section-title">
                            <p class="section-title-EN">our staff</p>
                            <p class="section-title-CN">我们的员工</p>
                        </div>
                        <div class="our-staff-box">
                            <c:forEach var="ourStaff" items="${ourStaffList}" varStatus="s">
                                <div class="our-staff-box-item">
                                    <div class="our-staff-title <c:if test="${s['index']%2 != 0}">right</c:if><c:if test="${s['index']%2 == 0}">left</c:if>">
                                        <img src="${webRoot}/images/aboutUsAll/our-staff/our-staff-title.png"/>
                                        <div class="our-staff-id">${ourStaff.id}</div>
                                        <div class="our-staff-text">
                                            <p class="CN">${ourStaff.titleCN}</p>
                                            <p class="EN">${ourStaff.titleEN}</p>
                                        </div>
                                    </div>
                                    <div class="our-staff-btn <c:if test="${s['index']%2 != 0}">left</c:if>"
                                         id="our-staff-btn-${s['index']}"></div>
                                    <div class="our-staff-content <c:if test="${s['index']%2 != 0}">left</c:if>"
                                         id="our-staff-content-${s['index']}">
                                        <div class="swiper-wrapper">
                                            <c:forEach var="img" items="${ourStaff.childList}" varStatus="s">
                                                <div class="swiper-slide">
                                                    <img src="${imgServer}${img.src}">
                                                    <div class="our-staff-mask">
                                                        <span>${img.title}</span>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </section>
                <section id="main-four" class="section4">
                    <div class="section-body">

                        <div class="section-title">
                            <p class="section-title-EN">community</p>
                            <p class="section-title-CN">联信社区</p>
                        </div>
                        <div class="community" id="community">
                            <div class="community-title">
                                <div class="EN">READING CORNER .</div>
                                <div class="CN">联信角</div>
                            </div>
                            <div class="community-box">
                                <div class="community-box-l" id="community-box-l">
                                    <div class="swiper-wrapper">
                                        <c:forEach var="community" items="${communityList}" varStatus="s">
                                            <div class="swiper-slide">
                                                <img src="${imgServer}${community.subSrc}">
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="community-box-m">
                                    <div class="swiper-wrapper">
                                        <c:forEach var="community" items="${communityList}" varStatus="s">
                                            <div class="swiper-slide swiper-no-swiping">
                                                <img src="${imgServer}${community.src}">
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="community-box-r">
                                    <div class="community-box-r-body">
                                        <div class="swiper-wrapper">
                                            <c:forEach var="community" items="${communityList}" varStatus="s">
                                                <div class="swiper-slide community-content swiper-no-swiping">
                                                    <h3>${community.title}</h3>
                                                    <div class="community-box-r-text">${community.text}</div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="community-box-r-foot">
                                        <div class="community-next-btn"><span class="textCN">下一篇</span><span
                                                class="textEN">Next</span></div>
                                        <div class="community-prev-btn"><span class="textCN">上一篇</span><span
                                                class="textEN">Prev</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="main-five" class="section5">
                    <div class="section-body">
                        <div class="art-content">
                            <div class="art-title">
                                <div class="art-title-EN">.ART APPRECIATION</div>
                                <div class="art-title-CN">艺术鉴赏</div>
                            </div>
                            <div id="art-box">
                                <div>
                                    <c:forEach var="art" items="${artList}" varStatus="s">
                                        <div class="swiper-container" id="swiper-${art.id}">
                                            <div class="swiper-wrapper">
                                                <c:forEach var="img" items="${art.childList}" varStatus="s">
                                                    <div class="swiper-slide">
                                                        <div class="art-border">
                                                            <div class="art-magnifier" value="${imgServer}${img.src}"></div>
                                                            <img src="${imgServer}${img.subSrc}"/>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="swiper-art-prev"></div>
                                <div class="swiper-art-next"></div>
                            </div>
                            <div class="art-tabs">
                                <c:forEach var="art" items="${artList}" varStatus="s">
                                    <div class="art-tab" id="art-tab-${art.id}">
                                        <span class="textCN">${art.titleCN}</span>
                                        <span class="textEN">${art.titleEN}</span>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="main-six" class="section6 gray">
                    <div class="section-body">

                        <div class="section-title">
                            <p class="section-title-EN">logo</p>
                            <p class="section-title-CN">企业标志</p>
                        </div>
                        <div class="qybzcontent" style="text-align: justify;">
                            <div class="qybz-img"><img src="${webRoot}/images/aboutUsAll/qybzlogo.jpg"></div>
                            <p class="textCN">
                                联信集团标识设计方案以一对方孔圆钱相互联结叠加而成，形象而直接的传递出公司的服务内容行业特征。设计上以联结的造型对应“联”字，钱币的造型对应“信”字。</p>
                            <p class="textEN" style="text-indent: inherit;">The logo of Inter-Credit group is the intersection of a pair of circular
                                coin with a
                                square hole, which vividly represents the company's services and the industry's
                                characteristics.
                                Regarding its design, intersection indicates 'Lian' (which means unity in Chinese) and
                                the coins
                                symbolize 'Xin' (which means credit in Chinese).</p>
                            <br/>
                            <p class="textCN">
                                同时标识图形还是佛教图案中的佛教字“卍”造型，意为吉祥海云，吉祥喜旋。寓意光明、无畏和永恒。旋转的图形形态表示的无限运作，无边延伸和无尽展现。象征企业如日月永生，如流水恒长一般无有穷尽。</p>
                            <p class="textEN" style="text-indent: inherit;">The logo can also be viewed as svastika '卍' in Buddhism, an implication of
                                brightness,
                                fearlessness and eternity. Its visual rotation conveys infinite operation, boundless
                                extension and
                                endless display. As the logo indicates, the company will keep shining like the sun and
                                march forward
                                like flowing water.</p>
                            <br/>
                            <p class="textCN">
                                标志被2个联合的“卍”字分割成数块，如同联信集团下的各个业务板块，在整个象征企业精神的“卍”字核心的引导下，协作一致，集团中各个部分业有专攻且完整如同一个整体。</p>
                            <p class="textEN" style="text-indent: inherit;">The logo is divided into several parts by the two joint '卍' . Under the
                                spiritual
                                guidance of '卍' , various business segments of Inter-Credit operate independently and
                                collaborate as
                                a whole. </p>
                            <br/>
                            <p class="textCN">标志造型又如同一对相联的旋转风火轮，体现无论何时何地，始终有神器辅佐着联信飞速奔向目标。</p>
                            <p class="textEN" style="text-indent: inherit;">The logo is also like a pair of spinning wheels, whenever and wherever,
                                assisting
                                Inter-Credit in moving forward as an engine. </p>
                            <br/>
                            <p class="textCN">标志色彩采用暗红色，体现公司充满着生机活力而有有适度的沉着与稳重。深沉的红色同样体现了联信的专业的服务能力和出众的综合实力。</p>
                            <p class="textEN" style="text-indent: inherit;">The color of the logo is dark red, a colour reflecting a vigorous and
                                steady company.
                                It also implicates the professional services and outstanding overall strength of
                                inter-credit.</p>
                        </div>
                    </div>
                </section>
                <div class="image-viewer">
                    <div class="image-viewer-bg"></div>
                    <div class="image-viewer-border">
                        <img id="image-viewer-img" src=""/>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link rel="stylesheet" href="${webRoot}/css/company.css?${now}"/>
        <%--<link rel="stylesheet" href="${webRoot}/css/scroll.css"/>--%>
        <%--<link rel="stylesheet" href="${webRoot}/css/iconfont.css"/>--%>
        <link rel="stylesheet" href="${webRoot}/js/plugins/swiper/css/swiper.min.css"/>
        <link rel="stylesheet" href="${webRoot}/js/plugins/mCustomScrollbar/jquery.mCustomScrollbar.css"/>
        <style type="text/css">
			.item05 > .culture-content > p.textCN:not(:first-child){
    			text-indent: 2em;
    			text-align:left;
    			font-size:1.6rem;
			    color: #616161;
			    line-height: 1.4em;
			    margin-bottom: 10px;
			}
			.item05 > .culture-content > p.textCN:first-child{
				margin-bottom: 10px;
			}
            .qybzcontent p{
                margin-bottom: 0;
            }
            .culture-tab-con .culture-content .our-principle{
                text-align: justify;
            }
            .art-title{
                width:225px;
            }
        </style>
    </tiles:putAttribute>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type="text/javascript" src="${webRoot}/js/plugins/swiper/js/swiper.min.js"></script>
        <script type="text/javascript"
                src="${webRoot}/js/plugins/mCustomScrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
        <script type="text/javascript">
            //我们的文化
            cultureItem = $(".culture-item");
            let cultureSelectItem=0;
            cultureItem.on('click', function () {
                cultureSelectItem = $(this).index();
                $(this).addClass('select').siblings().removeClass('select');
                $('.culture-tab-con .item0' + cultureSelectItem).show().siblings().hide();
            });
            cultureItem.hover(function () {
                $(this).find(".culture-item-active").addClass("rotateOut");
                cultureSelectItem = $(".culture-item.select").index();
                cultureItem.eq(cultureSelectItem-1).removeClass('select');
                // $(this).find(".culture-item-con").addClass("rotateBg");
            }, function () {
                $(this).find(".culture-item-active").removeClass("rotateOut");
                cultureItem.eq(cultureSelectItem-1).addClass('select');
                // $(this).find(".culture-item-con").removeClass("rotateBg");
            });

            //根据url跳转相应位置
            let mark = window.location.hash;
            if(mark==='#1'){
                $(".culture-item.item01").click();
                scrollBySelector("#our-culture");
            } else if(mark==='#2'){
                $(".culture-item.item04").click();
                scrollBySelector("#our-culture");
            }else {
                $(".culture-item.item05").click();
            }

            //我们的成员
            $(".our-staff-content").each(function (n) {
                // let num = $(this).find('img').length/2;
                new Swiper('#our-staff-content-' + n, {
                    slidesPerView: n % 2 === 0 ? 2 : 3,
                    spaceBetween: 3,
                    navigation: {
                        prevEl: n % 2 === 0 ? '#our-staff-btn-' + n : '',
                        nextEl: n % 2 !== 0 ? '#our-staff-btn-' + n : '',
                    },
                    loop: true,
                });
            });

            //我们的社区
            communityL = new Swiper('.community-box-l', {
                direction: 'vertical',
                slideToClickedSlide: true,
                height: 330,
                centeredSlides: true,
                autoplay: {
                    disableOnInteraction: false,
                    delay: 5000
                },
                speed: 500,
                slidesPerView: 3,
                loop: true,
                /*        navigation: {
                            prevEl: '.community-prev-btn',
                            nextEl: '.community-next-btn',
                        },*/
            });

            communityM = new Swiper('.community-box-m', {
                direction: 'vertical',
                speed: 500,
                slidesPerView: 1,
                spaceBetween: 5,
                noSwiping: true,
                loop: true,
                loopAdditionalSlides: 2,
            });

            communityR = new Swiper('.community-box-r-body', {
                direction: 'vertical',
                speed: 500,
                slidesPerView: 1,
                spaceBetween: 5,
                noSwiping: true,
                loop: true,
                loopAdditionalSlides: 2,
            });
            $(".community-box-r-text").mCustomScrollbar({theme:"dark"});
            communityBoxL = $('#community-box-l');
            num = communityL.slides.length - 6;
            let activeIndex = 0;

            function communitySlideTo() {
                communityBoxL.find('.swiper-slide').removeClass('select');
                communityBoxL.find("[data-swiper-slide-index='" + activeIndex + "']").each(function () {
                    $(this).addClass('select')
                });
                communityL.slideTo(activeIndex + 3);
                communityM.slideTo(activeIndex + 3);
                communityR.slideTo(activeIndex + 3);
            }

            communityBoxL.find('.swiper-slide').on('click', function () {
                activeIndex = parseInt($(this).attr("data-swiper-slide-index"));
                communitySlideTo();
            });
            $(".community-prev-btn").on('click', function () {
                activeIndex = ((activeIndex + num - 1) % num);
                communitySlideTo();
            });
            $(".community-next-btn").on('click', function () {
                activeIndex = ((activeIndex + num + 1) % num);
                communitySlideTo();
            });
            communitySlideTo();

            /*鼠标移入停止轮播，鼠标离开 继续轮播*/
            community = document.getElementById('community-box-l');
            community.onmouseover  = function () {
                communityL.autoplay.stop();
            };
            community.onmouseleave = function () {
                communityL.autoplay.start();
            };

            //艺术鉴赏
            let artSwiper;
            artTab = $(".art-tab");
            artTab.on('click', function () {
                let id = $(this).attr("id").split("-")[2];
                let swiper = $('#swiper-' + id);
                if (swiper.hasClass("active")) return;
                swiper.addClass("active").siblings().removeClass("active");
                if (artSwiper !== undefined) artSwiper.destroy();
                artSwiper = new Swiper('#swiper-' + id, {
                    slidesPerView: 3,
                    centeredSlides: true,
                    slideToClickedSlide:true,
                    loop: true,
                    autoplay: {
                        disableOnInteraction: false,
                        delay: 3000
                    },
                    navigation: {
                        nextEl: '.swiper-art-next',
                        prevEl: '.swiper-art-prev',
                    },
                    on: {
                        slideChangeTransitionEnd: function () {
                            $(".swiper-slide-active .art-magnifier").on('click', function () {
                                let img = document.getElementById('image-viewer-img');
                                img.src = $(this).attr("value");
                                /*img.onload = function () {
                                    $(".image-viewer-border").css("transform", "translate(-" + img.width / 2 + "px,-" + img.height / 2 + "px)");
                                };*/
                                $(".image-viewer").show();
                                $(".image-viewer-bg").on('click', function () {
                                    $(".image-viewer").hide();
                                });
                            });
                        }
                    }
                });
                $(this).addClass('art-tab-active').siblings().removeClass('art-tab-active');
            });
            artTab[0].click();

            /*鼠标移入停止轮播，鼠标离开 继续轮播*/
            artBoxs = document.getElementById('art-box');
            artBoxs.onmouseover  = function () {
                artSwiper.autoplay.stop()
            };
            artBoxs.onmouseleave = function () {
                artSwiper.autoplay.start()
            };

        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>