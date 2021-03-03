<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/base/pageBase.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
<%  
	 
%>
		<title>Inter-Credit | About Us</title>
		 <%-- <script src="${webRoot}/js/common/common.js" type="text/javascript" charset="utf-8"></script>
		<script src="${webRoot}/js/libs/jquery.min.js" type="text/javascript" charset="utf-8"></script> --%>
	</head>
	<body>
	      
		<div class="CXCtitle">
			<div>
				<p class="TitleTop">ABOUT US</p>
				
				<p class="TitleFoot">China's leading Credit Management Services (CMS) company</p>
			</div>
		</div>
		<div class="CXCMainBody3">
			<div>
			    <p id="lif">下面是样式展示：</p>
			    <p id="text"></p>
			    <p id="tt">44</p>
			    <button type="submit" onclick="switchLang();" id="lang">点击</button>
			</div>			
		</div>
		 
		<script src="${webRoot}/js/lib/jquery/jquery-3.2.1.min.js"></script>  
		<%-- <script src="${webRoot}/js/libs/jquery.min.js" type="text/javascript" charset="utf-8"></script> --%>
		<script src="${webRoot}/js/common.js" type="text/javascript" charset="utf-8"></script>
		
		<script src="${webRoot}/js/lib/i18n/jquery.json.min.js"></script>
		<script src="${webRoot}/js/lib/i18n/jquery.i18n.properties.js"></script>
		
		<script type="text/javascript" charset="utf-8">
			var LANGUAGE_CODE = "en_US"; //标识语言
	
			function loadProperties(type) {
				jQuery.i18n.properties({
			        name: 'msg', // 资源文件名称
			        path: "language/", // 资源文件所在目录路径  "${webRoot}/WEB-INF/conf/"
			        mode: 'map', // 模式：变量或 Map 
			        language: type, // 对应的语言
			        cache: false,
			        encoding: 'UTF-8',
			        callback: function () { // 回调方法    
			            $('#text').html($.i18n.prop('user_name'));
			            $('#lang').html($.i18n.prop('user_pwd'));
			            $('#tt').html($.i18n.prop('about_us'));
			        }
			    });
			}
	
			function switchLang() {
			    LANGUAGE_CODE = LANGUAGE_CODE == 'zh_CN' ? 'en_US' : 'zh_CN';
			    loadProperties(LANGUAGE_CODE);
			}
	
			$(document).ready(function () {
			    LANGUAGE_CODE = jQuery.i18n.normaliseLanguageCode({}); //获取浏览器的语言   
			    loadProperties(LANGUAGE_CODE);
			})		
		</script>
	</body>
</html>
