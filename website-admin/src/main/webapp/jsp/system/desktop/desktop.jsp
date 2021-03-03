<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cola" uri="cola" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>${programName}</title>

    <meta name="keywords" content="${programName}-内部网站管理系统">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link rel="shortcut icon" href="${webRoot}/favicon.ico">
    <link href="${webRoot}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css?v=4.1.0" rel="stylesheet">
    <style>
    /* 有效区域的展示 */
   /*  #content-main{
    height:calc(100% - 0px) !important;
    } */
    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header" style="height: 95px;background-color: #f3f3f4 !important;">
                    <div class="dropdown profile-element text-center">
                        <span><img alt="image" class="img-circle" src="${webRoot}/img/logo-element.png" style="max-width: 34px;"></span>
                        <a data-toggle="dropdown" class="dropdown-toggle pt10" href="#">
                            <span class="clear">
                            <span class="text-xs block" style="font-size:16px;">${sessionScope.LOGIN_USER_INFO.realName}</span>
                            </span>
                        </a>
                    </div>
                    <div class="logo-element">
                        <span><img alt="image" class="img-circle" src="${webRoot}/img/logo-element.png" style="width:30px;"></span>
                    </div>
                </li>

                <!-- 菜单 -->
                <cola:main-menu urlPrefix="${webRoot}"></cola:main-menu>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header pl5">
                    <div class=" col-sm-1 text-left p0 m0">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary m0 mt15" href="#"><i class="fa fa-angle-left"></i> </a>
                    </div>
                    <div class=" col-sm-11 text-left pt10" style="line-height:30px;color:#2f4050;font-size:28px;left:-15px;">
                        ${programName}
                    </div>
                </div>

                <ul class="nav navbar-top-links navbar-right  hidden-xs">
                    <li class="">
                        <%--<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">--%>
                        <%--<i class="fa fa-bell"></i> <span class="label label-danger"><span id="unreadMsgCnt1" class="unread-msg-cnt">0</span></span>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu dropdown-alerts">--%>
                        <%--<li>--%>
                        <%--<a href="${webRoot}/system/message/init" class="J_menuItem" data-name="我的消息">--%>
                        <%--<div>--%>
                        <%--<i class="fa fa-envelope fa-fw"></i>您有<span id="unreadMsgCnt2" class="unread-msg-cnt">0</span>条未读消息--%>
                        <%--<span class="pull-right text-muted small"><span id="unreadMsgTime" class="unread-msg-time">0</span>分钟前</span>--%>
                        <%--</div>--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--</ul>--%>
                        <%--<img src="${webRoot}/img/logo-right.png">--%>
                    </li>
                </ul>
                <div class="change">
                    <button class="btns" style = "margin-top:5">更换主题</button>
                    <div class="qiehuan" style = "margin-top:5">
                        <div class="liebiao bgs1"><div class="yanse1" ></div><span>高级灰</span></div>
                        <div class="liebiao bgs2"><div class="yanse2" ></div><span>清新绿</span></div>
                        <div class="liebiao bgs3"><div class="yanse3" ></div><span>蔷薇粉</span></div>
                        <div class="liebiao bgs4"><div class="yanse4" ></div><span>孔雀绿</span></div>
                        <div class="liebiao bgs5"><div class="yanse5" ></div><span>商务紫</span></div>
                        <div class="liebiao bgs6"><div class="yanse6" ></div><span>雾霾蓝</span></div>
                        <div class="liebiao bgs7"><div class="yanse7" ></div><span>太空蓝</span></div>
                        <div class="liebiao bgs8"><div class="yanse8" ></div><span>西瓜红</span></div>
                        <div class="liebiao bgs9"><div class="yanse9" ></div><span>旧主题</span></div>
                    </div>

                </div>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="${webRoot}/system/desktop/initHome">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <%--<button class="roll-nav roll-right J_refreshRight" onclick="refreshTab($('.active.J_menuTab'));"><i class="fa fa-refresh"></i>--%>
            <%--刷新--%>
            <%--</button>--%>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="${webRoot}/www/login/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i>
                退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%"
                    src="${webRoot}/system/desktop/initHome" frameborder="0" data-id="${webRoot}/system/desktop/initHome"
                    seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->

</div>

<!-- 全局js -->
<script src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
<script src="${webRoot}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${webRoot}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${webRoot}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${webRoot}/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${webRoot}/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="${webRoot}/js/contabs.js"></script>
<script type="text/javascript" src="${webRoot}/jsp/system/desktop/desktop.js?v=0.01"></script>

<!-- 第三方插件 -->
<%--<script src="${webRoot}/js/plugins/pace/pace.min.js"></script>--%>
<script>
    $(".btns").click(function(){
        $(".qiehuan").show();
    });
    $(".change").mouseleave(function(){
        $(".qiehuan").hide();
    });
    //8种主题
    var colors = ["gray","green","pink","greenKQ","purple","blueWM","blueTK","redXG"];
    $(function(){
        for(var i = 0;i<8;i++){
            var j = parseInt(i)+1;
            j = j.toString();
            (function(i){
                $(".bgs"+j).on("click",function(){
                    $("#wrapper").attr("class",colors[i]);
                    setCookie("theme",colors[i]);
                });
            })(i);
        };
    });


    //重置
    $(".bgs9").on("click",function(){
        $("#wrapper").attr("class","");
        deleteCookie("theme");
    });

    function setCookie(_name,_val){
        var _day = 360;//保存一年
        var _date = new Date();
        var _time = Date.parse(_date);
        var _lastTime = 30*24*60*60*1000;
        _date.setTime(_time+_lastTime);
        document.cookie = _name + "=" +escape(_val) + ";expires ="+_date.toGMTString();

    };

    function getCookie(_name){
        if(document.cookie.length > -1){
            if(document.cookie.indexOf(_name + "=")>-1){
                var _indexStart = document.cookie.indexOf(_name + "=");
                _indexStart = _indexStart + _name.length + 1;
                _indexEnd = document.cookie.indexOf(";",_indexStart);
                if(-1 == _indexEnd) _indexEnd = document.cookie.length;
                return unescape(document.cookie.substring(_indexStart,_indexEnd));
            }
        }
    };
    function deleteCookie(_name){
        var _date = new Date();
        _date.setTime(_date.getTime()-1);
        if(getCookie(_name)){
            document.cookie = _name + "=" +escape(getCookie(_name)) + ";expires = "+_date.toGMTString();
        }
    };
    function checkCookie(){
        if(getCookie("theme")){
            $("#wrapper").attr("class",getCookie("theme"));
        }
    };
    checkCookie();//首次加载缓存中的主题
</script>

</body>

</html>