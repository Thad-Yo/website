<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="社会责任"/>
    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <ul class="nav-ul">
            <li class="active" value="#main-two">
                <p class="textCN">我们在做什么？</p>
                <p class="textEN">What are we doing?</p>
            </li>
            <li value="#main-three">
                <p class="textCN">我们在行动</p>
                <p class="textEN">We are in action</p>
            </li>
        </ul>
        <div class="socialPage">
            <div class="banner"><img src="${webRoot}/images/social/banner.jpg" width="100%"></div>
            <section id="main-two" class="panel1">
                <div class="section-body">
                    <div class="section-title">
                        <p class="section-title-EN">What are we doing?</p>
                        <p class="section-title-CN">我们在做什么？</p>
                    </div>
                    <div class="panel-detail textCN">公益，我们从“心”出发，用与他人平等的灵魂，给予爱和尊重。<br/>联信人在公益道路上，真实行动，真实付出，正在积极传递联信正能量。
                    </div>
                    <div class="panel-detail textEN">We care about public welfare by giving our love and respect to others.
                        <br/>
                        Taking actions, making contributions and sharing positive energy, the Inter-Credit people are in action!
                    </div>
                    <div class="panel-icon">
                        <div class="icon-one">
                            <div class="icon-img"><img src="${webRoot}/images/social/iconBg1.png"></div>
                            <div class="icon-title textCN">未来</div>
                            <div class="icon-title textEN">Future</div>
                            <div class="icon-detail textCN">联信公益，未来我们一路同行</div>
                            <div class="icon-detail textEN">Together, we could make a better future.</div>
                            <div class="line"><img src="${webRoot}/images/social/line.png"></div>
                        </div>
                        <div class="icon-one">
                            <div class="icon-img"><img src="${webRoot}/images/social/iconBg2.png"></div>
                            <div class="icon-title textCN">希望</div>
                            <div class="icon-title textEN">Hope</div>
                            <div class="icon-detail textCN">用爱心的沃土，助希望的青苗茁壮成长</div>
                            <div class="icon-detail textEN">With loving hearts, hope will thrive.</div>
                            <div class="line"><img src="${webRoot}/images/social/line.png"></div>
                        </div>
                        <div class="icon-one">
                            <div class="icon-img"><img src="${webRoot}/images/social/iconBg3.png"></div>
                            <div class="icon-title textCN">传递</div>
                            <div class="icon-title textEN">Sharing</div>
                            <div class="icon-detail textCN">爱心传递，托起明天的太阳</div>
                            <div class="icon-detail textEN">Sharing love warms you and me.</div>
                            <div class="line"><img src="${webRoot}/images/social/line.png"></div>
                        </div>
                        <div class="icon-one">
                            <div class="icon-img"><img src="${webRoot}/images/social/iconBg4.png"></div>
                            <div class="icon-title textCN">关爱</div>
                            <div class="icon-title textEN">Caring</div>
                            <div class="icon-detail textCN">当我们在一起就会了不起</div>
                            <div class="icon-detail textEN">Caring makes the world more beautiful.</div>
                        </div>
                    </div>
                </div>
            </section>
            <!--第二部分-->
            <section id="main-three" class="panel2 gray">
                <div class="section-body">
                    <div class="section-title">
                        <p class="section-title-EN">We are in action</p>
                        <p class="section-title-CN">我们在行动</p>
                        <a class="panel-title-more" href="${webRoot}/system/social/more">MORE ></a>
                    </div>
                    <div class="imgAll">
                        <c:forEach items="${record}" var="donation" begin="0" step="1" end="3" varStatus="status">
                            <div class="imgL">
                                <img src="${imgServer}${donation.coverPageUrl}" width="100%">
                                <div class="whiteBox">
                                    <div class="w-title">${donation.newsTitle}</div>
                                    <div class="w-line"></div>
                                    <div class="w-gray">${donation.content}</div>
                                    <div class="w-arrow "><img src="${webRoot}/images/index/more.png"></div>
                                    <div class="w-square"></div>
                                    <div class="w-arrowBig hide">
                                        <a href="${webRoot}/system/social/detail?id=${donation.id}">
                                            <i class="iconfont icon-icon"></i>
                                            <span class="textCN">查看详情</span>
                                            <span class="textEN">View Details</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
        </div>
    </tiles:putAttribute>
    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <style type="text/css">
            .socialPage .banner img {
                display: block;
                border: none;
            }

            .socialPage .panel1 .panel-detail {
                color: #2b2b2f;
                font-size: 1.6rem;
                line-height: 2.4rem;
                text-align: center;
            }

            .socialPage .panel1 .panel-icon {
                width: 100%;
                overflow: hidden;
                margin-top: 46px;
                padding-bottom: 20px;
            }

            .socialPage .panel1 .panel-icon .icon-one {
                width: 25%;
                float: left;
                text-align: center;
                padding: 0 2%;
                box-sizing: border-box;
                position: relative;
            }

            .socialPage .panel1 .panel-icon .icon-one .line {
                position: absolute;
                top: 15px;
                right: 0;
            }

            .icon-img img {
                width: 84px;
            }

            .socialPage .panel1 .panel-icon .icon-title {
                color: #111111;
                font-size: 1.8rem;
                margin: 26px auto;
            }

            .socialPage .panel1 .panel-icon .icon-detail {
                font-size: 1.4rem;
                color: #999999;
                line-height: 1.4rem;
            }

            .socialPage .panel2 .imgAll {
                overflow: hidden;
            }

            .socialPage .panel2 .imgAll .imgL {
                float: left;
                width: 50%;
                position: relative;
                margin-bottom: 20px;
            }

            .socialPage .panel2 .imgAll .imgL > img {
                height: 280px;
                display: block;
                border: none;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox {
                position: absolute;
                height: 100%;
                width: 50%;
                right: 0;
                top: 0;
                background: rgba(255, 255, 255, .8);
                padding: 20px;
                box-sizing: border-box;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-title {
                color: #2b2b2f;
                font-size: 1.8rem;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-line {
                width: 30px;
                height: 2px;
                background: #b90b2c;
                margin: 20px 0;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-gray {
                color: #2b2b2f;
                font-size: 1.4rem;
                max-height: 125px;
                overflow: hidden;
                text-align: justify;
                line-height: 21px;
                position: relative;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-arrow {
                margin-top: 12%;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-square {
                height: 16px;
                width: 16px;
                transform: rotate(45deg);
                background: rgba(255, 255, 255, .6);
                position: absolute;
                left: -8px;
                top: 50%;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-arrowBig {
                margin-top: 20px;
                color: white;
                height: 34px;
                border: 1px solid #cccccc;
                border-radius: 34px;
                text-align: center;
                line-height: 34px;
                position: relative;
                width: 130px;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-arrowBig a {
                color: #fff;
                margin-left: 15px;
                font-size: 1.4rem;
                position: relative;
                display: block;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-arrowBig a i {
                border-radius: 50%;
                width: 16px;
                height: 16px;
                background: #fff;
                color: #ba0c2f;
                font-size: 1rem;
                position: absolute;
                left: -3px;
                top: 9px;
                line-height: 16px;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-arrowBig:hover {
                background: #fff;
                color: #ba0c2f;
                border: 1px solid #ba0c2f;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-arrowBig:hover a {
                color: #ba0c2f;
            }

            .socialPage .panel2 .imgAll .imgL .whiteBox .w-arrowBig:hover a i {
                background: #ba0c2f;
                color: #fff;
            }

            .socialPage .panel2 .imgAll .imgR {
                float: left;
                width: 50%;
                position: relative;
            }

            .socialPage .panel2 .imgAll .imgR img {
                display: block;
                border: none;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox {
                position: absolute;
                height: 100%;
                width: 50%;
                left: 0;
                top: 0;
                background: white;
                padding: 4%;
                box-sizing: border-box;
                cursor: pointer;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox .w-title {
                color: #2b2b2f;
                font-size: 1.8rem;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox .w-line {
                width: 30px;
                height: 2px;
                background: #b90b2c;
                margin-top: 10%;
                margin-bottom: 10%;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox .w-gray {
                color: #2b2b2f;
                font-size: 1.4rem;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox .w-arrow {
                margin-top: 12%;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox .w-square {
                height: 16px;
                width: 16px;
                transform: rotate(45deg);
                background: white;
                position: absolute;
                right: -8px;
                top: 50%;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox .w-arrowBig {
                margin-top: 12%;
                color: white;
                height: 34px;
                border: 1px solid #cccccc;
                border-radius: 34px;
                text-align: center;
                line-height: 34px;
                position: relative;
                width: 68%;
            }

            .socialPage .panel2 .imgAll .imgR .whiteBox .w-arrowBig img {
                position: absolute;
                left: 10%;
                top: 26%;
            }

            .socialPage .panel2 .panel-title-more {
                position: absolute;
                right: -273px;
                bottom: -25px;
                font-size: 1.2rem;
                font-weight: bolder;
                color: #ba0c2f;
            }
        </style>
    </tiles:putAttribute>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type="text/javascript">
            window.onload = function () {
                $('.w-gray').each(function () {
                    var height = $(this).height();
                    var text = $(this).text();
                    var img = $(this).find('img');
                    if (img.length > 0) {
                        img.remove();
                    }
                    if (text.length > 50) {
                        text = text.slice(0, 50) + '...';
                        $(this).text(text);
                    }
                })
            };
            $(".imgL,.imgR").hover(function () {
                $(this).find(".whiteBox").css({"background": "rgba(185,11,44,.8)"});
                $(this).find(".w-title").css("color", "rgba(255,255,255,0.9)");
                $(this).find(".w-gray").css("color", "rgba(255,255,255,0.9)");
                $(this).find(".w-line").css("background", "rgba(255,255,255,0.9)");
                $(this).find(".w-square").css({"background": "rgba(185,11,44,1)"});
                $(this).find(".w-arrow").addClass("hide");
                $(this).find(".w-arrowBig").removeClass("hide");

            }, function () {
                $(this).find(".whiteBox").css({"background": "rgba(255,255,255,.8)"});
                $(this).find(".w-title").css("color", "#2b2b2f");
                $(this).find(".w-gray").css("color", "#2b2b2f");
                $(this).find(".w-line").css("background", "#b90b2c");
                $(this).find(".w-square").css({"background": "rgba(255,255,255,.6)"});
                $(this).find(".w-arrowBig").addClass("hide");
                $(this).find(".w-arrow").removeClass("hide");
            });

            $(".icon-one").hover(function () {
                $(this).find(".icon-detail").css("color", "#b90b2c");
                $(this).find(".icon-img").addClass("roateAni");
            }, function () {
                $(this).find(".icon-detail").css("color", "#999999");
                $(this).find(".icon-img").removeClass("roateAni");
            });

        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>