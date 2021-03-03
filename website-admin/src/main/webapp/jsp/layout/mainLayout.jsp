<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <%-- 画面的共通MATE --%>
    <%@include file="/jsp/common/headMetas.jsp" %>
    <%-- 浏览器左上角显示的文字 --%>
    <title><tiles:getAsString name="pageTitle"/> - 联信集团网站后台管理系统</title>
    <%-- 画面的共通CSS --%>
    <%@include file="/jsp/common/headCss.jsp" %>
    <%-- 各个画面的CSS --%>
    <tiles:insertAttribute name="pageCss" ignore="true"/>
    <%-- 上部分共通的JS --%>
    <%@include file="/jsp/common/headJavascript.jsp" %>
    <%-- 上部分的JS --%>
    <tiles:insertAttribute name="pageGlobalImport" ignore="true"/>
</head>
<body class="gray-bg">
    <%@include file="/jsp/common/pageContent.jsp" %>
</body>

<!-- Javascripts required for this page only -->
<tiles:insertAttribute name="pageJavaScript" ignore="true"/>
<script type = "text/javascript">
    $(function(){
        var altCheck='0';
        /* 搜索条件的展开和收起开始 */
        $(".ibox-title").click(function(){
            var $this = $(this).parent().find(".search-content");
            var $other = $(this).find(".ibox-tools").find("i.fa");
            $this.toggle("fast",function(){
                if($other.hasClass("fa-chevron-up")){
                    $other.removeClass("fa-chevron-up").addClass("fa-chevron-down");
                }else if($other.hasClass("fa-chevron-down")){
                    $other.removeClass("fa-chevron-down").addClass("fa-chevron-up");
                }

                Page.Table && Page.Table.bootstrapTable("resetView", {
                    height: TableCommon.getHeight()
                }); 
            });
        });
        console.info($("table").hasClass("grateTable"));
        if(!$("table").hasClass("grateTable") && !$("table").hasClass("interview_process_list")){
        	$("tbody").delegate("tr","click",function(){
            	var $this = $(this);
            	$this.css("background-color","#4bbcdb").siblings().css("background-color","white");
            })
        }
    });
</script>

</html>
