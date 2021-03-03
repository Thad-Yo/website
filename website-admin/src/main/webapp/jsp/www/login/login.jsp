<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>${programName}</title>
    <meta name="keywords" content="${programName}">
    <meta name="description" content="${programName}">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${webRoot}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="${webRoot}/css/login.css?v=4.1.0" rel="stylesheet">

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
    	<style type="text/css">
			*{
				margin:0;
				padding: 0;
			}
			ul{
				list-style: none;
			}
			input{
				outline: none;
				font-size:16px;
				color:#999;
			}
			.top,.mid,.bottom{
				width:100%;
				min-width: 1000px;
			}
			.top{
				background: url(${webRoot}/img/login_01.png) no-repeat center;
				height:254px;
			}
			.mid{
				background: url(${webRoot}/img/login_02.png) no-repeat center;
				height: 360px;
			}
			.bottom{
				background: url(${webRoot}/img/login_03.png) no-repeat center;
				height: 466px;
			}
			.mid .content{
				background: url(${webRoot}/img/loginContent.png) no-repeat center;
				width:576px;
				height: 324px;
				margin:0 auto;
			}
			.mid .joinIn{
				background: #f74e60;
				width:100%;
				height:40px;
				line-height: 40px;
				letter-spacing: 5px;
				font-size:16px;
				color:#fff;
				border-radius: 5px;
				border:none;
				padding:0;
			}
			.content ul{
				width:370px;
				height: 100%;
				margin:0 auto;
				padding: 50px 50px 50px 0;
			}
			.content ul li .userName,.content ul li .password{
				display: block;
				width:320px;
				height: 40px;
				line-height: 40px;
				outline: none;
				border: 1px solid #fff;
				border-radius: 5px;
				margin:15px 0;
				padding-left:30px;
			}
			.content ul li .code{
				height: 40px;
				line-height: 40px;
				border: 1px solid #fff;
				border-radius: 5px;
				margin:8px 0 15px 0;
				float: left;
				width:190px;
			}
			.content ul li .codeImg{
				width:76px;
				height:40px;
				margin:5px 0 0 10px;
				display: block;
				float: left;
			}
			.content ul li .changeCode{
				display: block;
				float: left;
				margin:9px 0px 15px 5px;
				height:40px;
				line-height:40px;
				text-decoration: none;
				cursor: pointer;
			}
			.content ul li .changeCode span{
				color:#999;
				font-size:14px;
				letter-spacing: 2px;
			}
			.content ul li .changeCode img{
				width:15px;
				height: 13px;
				padding: 0 0 0 5px;
			}
			.content ul li.userContainer,.content ul li.pwdContainer{
				position: relative;
			}
			.content ul li.userContainer .icon-user{
				background: url(${webRoot}/img/user-gray.png) no-repeat;
			}
			.content ul li.pwdContainer .icon-pwd{
				background: url(${webRoot}/img/pwd-gray.png) no-repeat;
			}
			.content ul li.focus input{
				border-color: #f07b8a;
			}
			.content ul li.userContainer.focus .icon-user{
				background: url(${webRoot}/img/user-red.png) no-repeat;
			}
			.content ul li.pwdContainer.focus .icon-pwd{
				background: url(${webRoot}/img/pwd-red.png) no-repeat;
			}
			
			.content ul li.userContainer .icon-user,.content ul li.pwdContainer .icon-pwd{
				display: block;
				width:16px;
				height:16px;
				position:absolute;
				top:12px;
				left:8px;
			}
			.content form{
				margin:0 auto;
			}
			.m-t{
				margin:0;
			}
			
		</style>
</head>

<body >
<div class="top"></div>
		<div class="mid">
			<div class="content">
			  <form class="m-t" role="form" id="mainForm" action="${webRoot}/www/login/loginAction" method="post" style="width:320px;max-width:320px;">
				<ul>
					<li class = "userContainer focus">
						 <input type="text" id="username" name="username" class="form-control uname userName" autocomplete="off" placeholder="请输入账户"
                               value="admin"/>
						<span class="icon-user"></span>
					</li>
					<li class = "pwdContainer">
						<input type="password" id="password" name="password" class="form-control pword m-b password" value="123456" placeholder="请输入密码"/>
						<span class="icon-pwd"></span>
					</li>
<%-- 					<li>
					     <input type="text" id="randomcode" name="randomcode" class="form-control code m-b code" placeholder="请输入验证码"
                                   maxlength="4"
                                   value=""/>
                            <img alt="" src="${webRoot}/www/login/registRandomcode" class="codeImg" style="cursor: pointer;width:100px;padding-top:10px;height:40px;" onclick="javascript:this.src=webRoot + '/www/login/registRandomcode?a='+Math.random()">
					</li> --%>
					<li>
					   <button class="btn btn-warning btn-block btn-Login joinIn">登&nbsp;录</button>
					</li>
				</ul>
				</form>
				
			</div>
			
		</div>		
		<div class="bottom">
<!-- 		 <div class="row footer-copy text-center" style="color:#838383;font-size:10px;position:fixed;bottom:10px;width:100%"> -->
<!--                     <div class="col-xs-12" style="margin-top: 15px">版权所有Copyright © 2016 Gration</div> -->
<!--                     <div class="col-xs-12" style="margin-top: 15px">工信部备案编号:<a href="http://www.beianbeian.com/beianxinxi/51f000b7-69fc-468a-a356-ff84e3d9c1ae.html">鲁ICP备0000000000号</a></div> -->
<!--             </div> -->
		</div>
                           
</body>

<script src="${webRoot}/jsp/www/login/login.js"></script>
<script>
    <c:if test="${not empty usererror}">
    layer.tips("${usererror}", "<c:out value="${not empty id ? id : '.btn-Login'}"></c:out>", {tips: [4, '#78BA32']});
    </c:if>
</script>
</body>

</html>
