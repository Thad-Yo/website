<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="动态详情"/>
    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="company">
            <input hidden id="type" value="${newsRecord.type}">
            <div class="banner">
                <img src="${webRoot}/images/companyDynamic/banner.jpg" width="100%">
            </div>
            <div class="breadNav">
                <ul>
                    <li><img src="${webRoot}/images/companyNew/house.png"></li>
                    <li>
                        <a href="" class="textCN">联信动态 > </a>
                        <a href="" class="textEN">News > </a>
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
                <div class="zhayaobox gray">
                        ${newsRecord.summary}
                    <div class="fuhao"><img src="${webRoot}/images/companyNew/f1.png"></div>
                    <div class="fuhao2"><img src="${webRoot}/images/companyNew/f2.png"></div>
                </div>
                <div class="detailBox wow fadeIn">
                        ${newsRecord.content}
                </div>
            </div>
        </div>
    </tiles:putAttribute>
    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css"/>
        <style type="text/css">
            .company .banner img {
                display: block;
            }

            .company .breadNav {
                border-bottom: 1px solid #dddddd;
                height: 52px;
                box-sizing: border-box;
            }

            .company .breadNav ul {
                width: 60%;
                margin: auto;
            }

            .company .breadNav li {
                float: left;
                font-size: 1.4rem;
                line-height: 52px;
                color: #666666;
                cursor: pointer;
            }

            .company .breadNav li img {
                margin-right: 10px;
            }

            .company .breadNav .currentColor {
                color: #000;
            }

            .company .breadNav .currentColor a {
                cursor: default;
            }

            .company .breadNav ul li:nth-of-type(2) a, .company .breadNav ul li:nth-of-type(3) a {
                color: #666;
            }

            .company .conentDiv {
                width: 60%;
                margin: auto;
            }

            .company .conentDiv img {
                max-width: 100%;
            }

            .company .conentDiv .title-text {
                font-size: 3rem;
                color: #2b2b2f;
                font-weight: bold;
                text-align: center;
                margin-top: 52px;
            }

            .company .conentDiv .grayBox ul {
                overflow: hidden;
                text-align: center;
                color: #adadad;
                width: 210px;
                margin: 20px auto;
            }

            .company .conentDiv .grayBox li {
                float: left;
                line-height: 22px;
                font-size: 1.2rem;
            }

            .company .conentDiv .grayBox .borderBox {
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

            .company .conentDiv .zhayaobox {
                font-size: 1.4rem;
                color: #737373;
                padding: 30px 50px;
                box-sizing: border-box;
                text-align: center;
                position: relative;
            }

            .company .conentDiv .zhayaobox .fuhao {
                position: absolute;
                left: 20px;
                top: 10px;
            }

            .company .conentDiv .zhayaobox .fuhao2 {
                position: absolute;
                right: 20px;
                bottom: 10px;
            }

            .company .conentDiv .blackText {
                padding: 30px 50px;
                box-sizing: border-box;
                text-align: justify;
                color: #2b2b2f;
                font-size: 1.4rem;
                font-weight: bold;
            }

            .company .conentDiv .imgbox {
                text-align: center;
                padding: 0 130px;
                margin-bottom: 10px;
            }

            .company .conentDiv .imgbox .imgtext img {
                margin-right: 10px;
            }

            .company .conentDiv .detailBox {
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
            var val = $('#type').val();
            var obj = $('.breadNav').find('ul li');
            var url = webRoot + '/system/companyDynamic/init?type=';
            if (val == 0) {//联信时讯
                obj.eq(1).children('.textCN').attr('href', url + val);
                obj.eq(1).children('.textEN').attr('href', url + val);
                obj.eq(2).children('.textCN').text('联信时讯>');
                obj.eq(2).children('.textEN').text('Company News Headlines>');
                obj.eq(2).children('.textCN').attr('href', url + val);
                obj.eq(2).children('.textEN').attr('href', url + val);
                obj.eq(3).children('.textCN').text('时讯详情');
                obj.eq(3).children('.textEN').text('Newsletter Details');
                $('.borderBox.textCN').text('联信时讯');
                $('.borderBox.textEN').text('Latest News');
            } else if (val == 1) {//行业新闻
                obj.eq(1).children('.textCN').attr('href', url + val);
                obj.eq(1).children('.textEN').attr('href', url + val);
                obj.eq(2).children('.textCN').text('行业新闻>');
                obj.eq(2).children('.textEN').text('Industry News>');
                obj.eq(2).children('.textCN').attr('href', url + val);
                obj.eq(2).children('.textEN').attr('href', url + val);
                obj.eq(3).children('.textCN').text('新闻详情');
                obj.eq(3).children('.textEN').text('News Details');
                $('.borderBox.textCN').text('行业新闻');
                $('.borderBox.textEN').text('Industry News');
            } else if (val == 2) {//联信Style
                obj.eq(1).children('.textCN').attr('href', url + val);
                obj.eq(1).children('.textEN').attr('href', url + val);
                obj.eq(2).children('.textCN').text('联信Style>');
                obj.eq(2).children('.textEN').text('Views & Insights>');
                obj.eq(2).children('.textCN').attr('href', url + val);
                obj.eq(2).children('.textEN').attr('href', url + val);
                obj.eq(3).children('.textCN').text('Style详情');
                obj.eq(3).children('.textEN').text('Style Details');
                $('.borderBox.textCN').text('联信Style');
                $('.borderBox.textEN').text('Style News');
            }
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>