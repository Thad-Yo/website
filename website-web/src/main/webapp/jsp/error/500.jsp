<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>联信集团网站系统</title>
    <meta name="keywords" content="联信集团网站系统">
    <meta name="description" content="联信集团网站系统">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${webRoot}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${webRoot}/css/animate.min.css" rel="stylesheet">
    <link href="${webRoot}/css/style.min.css?v=4.1.0" rel="stylesheet">

    <!-- 全局js -->
    <script src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${webRoot}/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- layer javascript -->
    <script src="${webRoot}/js/plugins/layer/layer.js"></script>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="1;url=${webRoot}/ie.html"/>
    <![endif]-->
    <script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
</head>
<body>


<div class="middle-box text-center animated fadeInDown">
    <h1>500</h1>

    <h3 class="font-bold">服务器内部错误！</h3>

    <div class="error-desc">
        服务器好像出错了...
        <form class="form-inline m-t" role="form">
            <div class="form-group">
                <a href="/" class="btn btn-danger block">返回首页</a>
            </div>

        </form>
    </div>
</div>

<!-- 全局js -->
<script src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
<script src="${webRoot}/js/bootstrap.min.js?v=3.3.6"></script>

</body>
</html>