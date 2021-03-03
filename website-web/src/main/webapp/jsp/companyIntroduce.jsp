<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="企业介绍"/>
    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="company-introduce gray">
            <div class="index-main">
                <div id="main-one" class="section1">
                    <div class="company-introduce-banner"></div>
                </div>
                <section id="main-two" class="section section2">
                    <div class="section-body">
                        <div class="section-title">
                            <p class="section-title-EN">who we are</p>
                            <p class="section-title-CN">企业介绍</p>
                        </div>
                            ${websiteIntroduce.introduce }
                        <ul class="culture-content">
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
                        </ul>
                    </div>
                </section>
            </div>
        </div>
    </tiles:putAttribute>
    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <style type="text/css">
            .company-introduce-banner {
                width: 100%;
                height: 470px;
                background: url("${webRoot}/images/aboutUs/banner.jpg") center no-repeat;
            }

            .company-introduce .culture-content {
                display: flex;
                width: 800px;
                margin: 0 auto;
                padding-top: 40px;
                cursor: default;
                font-size: 2.4rem;
                text-align: center;
            }

            .company-introduce .culture-content li:hover .CN {
                text-shadow: rgba(0, 0, 0, 0.51) 0 0 5px;
                transition: text-shadow .5s;
            }

            .company-introduce .culture-content li:hover .EN {
                text-shadow: rgba(187, 3, 39, 0.51) 0 0 5px;
                transition: text-shadow .5s;
            }

            .company-introduce .culture-content li {
                flex: 1;
                position: relative;
            }

            .company-introduce .culture-content li:nth-of-type(-n+5)::after {
                display: block;
                content: '';
                height: 80%;
                width: 1px;
                background: gainsboro;

                /* 定位 */
                position: absolute;
                right: 0;
                top: 10%;
            }

            .company-introduce .culture-content li .EN {
                padding-top: 5px;
                color: #bb0327;
                font-size: 1rem;
                font-weight: bold;
            }
        </style>
    </tiles:putAttribute>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type="text/javascript">
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>
