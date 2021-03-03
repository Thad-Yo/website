<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/12/10
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<header>
    <div class="header">
        <div class="logoBox">
            <a href='${webRoot}/system/desktop/init'>
                <div class="logo textCN"></div>
                <div class="logo textEN"></div>
            </a>
        </div>
        <div class="lx-nav">
            <div class="lx-nav-link">
                <div class="lx-nav-link-btn" value="${webRoot}/system/desktop/init">
                    <span class="textCN">首页</span>
                    <span class="textEN">Home</span>
                </div>
            </div>
            <div class="lx-nav-link">
                <div class="lx-nav-link-btn" value="${webRoot}/system/companyIntroduce/init">
                    <span class="textCN">关于联信</span>
                    <span class="textEN">About Us</span>
                </div>
                <div class="second-lx-nav">
                    <div class="second-lx-nav-box">
                        <div class="lx-nav-link-btn" value="${webRoot}/system/companyIntroduce/init">
                            <span class="textCN">企业介绍</span>
                            <span class="textEN">Who We Are</span>
                        </div>
                        <div class="lx-nav-link-btn" value="${webRoot}/system/companyCulture/init">
                            <span class="textCN">联信文化</span>
                            <span class="textEN">Our Culture</span>
                        </div>
                        <div class="lx-nav-link-btn" value="${webRoot}/system/companyDynamic/init">
                            <span class="textCN">联信动态</span>
                            <span class="textEN">News</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="lx-nav-link">
                <div class="lx-nav-link-btn" value="${webRoot}/system/produce/init">
                    <span class="textCN">联信业务</span>
                    <span class="textEN">Services</span>
                </div>
                <div class="second-lx-nav">
                    <div class="second-lx-nav-box">
                        <div class="lx-nav-link-btn services-link" value="${webRoot}/system/produce/init#1">
                            <span class="textCN" style="text-align:left">国内逾期账款管理</span>
                            <span class="textEN" style="text-align:left">Domestic Debt Collection</span>
                        </div>
                        <div class="lx-nav-link-btn services-link" value="${webRoot}/system/produce/init#2">
                            <span class="textCN" style="text-align:left">国际逾期账款管理</span>
                            <span class="textEN" style="text-align:left">International Debt Collection</span>
                        </div>
                        <div class="lx-nav-link-btn services-link" value="${webRoot}/system/produce/init#3">
                            <span class="textCN" style="text-align:left">征信业务</span>
                            <span class="textEN" style="text-align:left">Credit Investigation Services</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="lx-nav-link">
                <div class="lx-nav-link-btn" value="${webRoot}/system/social/init?isTop=0">
                    <span class="textCN">社会责任</span>
                    <span class="textEN">CSR</span>
                </div>
            </div>
            <div class='lx-nav-link textCN'>
                <div class='lx-nav-link-btn' value="${webRoot}/system/recruit/init">
                    <span>加入联信</span>
                </div>
            </div>
            <div class="lx-nav-link">
                <div class="lx-nav-link-btn" value="${webRoot}/system/contactUs/init">
                    <span class="textCN">联系我们</span>
                    <span class="textEN">Contact</span>
                </div>
            </div>
            <div class="language">
                <span class='textCN'>LANGUAGE</span>
                <span class='textEN'>LANGUAGE</span>
                <%--<span class='textEN'>语言</span>--%>
                <div class="second-lx-nav">
                    <div class="second-lx-nav-box">
                        <div class="language-item lx-nav-link-btn" id="language-1"><span>EN</span></div>
                        <div class="language-item lx-nav-link-btn" id="language-0"><span>中文</span></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
