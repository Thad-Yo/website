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
        <div class="CSR gray">
            <div class="banner">
                <img src="${webRoot}/images/social/banner.jpg" width="100%">
            </div>
            <div class="CSR-content">
                <div class="content-box">
                    <div id="newsDiv" class="tab1 tab">
                    </div>
                    <div style="text-align: center;">
                        <ul class="pagination" id="pagination">
                        </ul>
                        <!--PageCount是一共多少条数据-->
                        <input type="hidden" id="PageCount" runat="server"/>
                        <!--PageSize是页面显示多少条数据-->
                        <input type="hidden" id="PageSize" runat="server"/>
                        <!--countindex这个参数是通过上面的PageCount与PageSize计算出来的分多少页-->
                        <!--js中是自动计算的，可默认也可以自己填-->
                        <input type="hidden" id="countindex" runat="server"/>
                        <!--上一页与下一页中间的数字框，要显示几个就value多少个-->
                        <input type="hidden" id="visiblePages" runat="server" value="7"/>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link rel="stylesheet" href="${webRoot}/css/bootstrap.min.css"/>
        <style type="text/css">

            /*抵消Bootstrap*/
            * {
                -webkit-box-sizing: content-box;
                -moz-box-sizing: content-box;
                box-sizing: content-box;
            }

            .arrow2 {
                margin: 3px 8px 4px 0;
                border-left: 5px dashed transparent;
                border-bottom: 5px dashed transparent;
                border-top: 5px dashed transparent;
                border-right: 5px solid #ccc;
                display: inline-block;
                vertical-align: middle;
            }

            .arrow3 {
                margin: 3px 0 4px 8px;
                border-top: 5px dashed transparent;
                border-bottom: 5px dashed transparent;
                border-right: 5px dashed transparent;
                border-left: 5px solid #ccc;
                display: inline-block;
                vertical-align: middle;
            }

            .CSR .CSR-content {
                width: 1100px;
                margin: auto;
                padding-bottom: 40px;
                position: relative;
            }

            .CSR .content-box {
                margin: 40px auto;
                background: white;
                padding: 0 40px;
                position: relative;
                box-sizing: border-box;
                box-shadow: 0 0 6px 1px rgba(0, 0, 0, 0.1);
            }

            .CSR.content-box .lineOne {
                overflow: hidden;
            }

            .CSR .content-box .left {
                float: left;
                width: 100px;
                height: 100px;
                margin-top: 30px;
            }

            .CSR .content-box .left .outBox {
                height: 60px;
                width: 60px;
                border: 1px solid #e8e8e8;
                border-top: 2px solid #b90b2c;
                padding-top: 6px;
                box-sizing: border-box;
                text-align: center;
            }

            .CSR .content-box .left .dayBox {
                font-size: 23px;
                color: #000000;
                font-weight: bold;
            }

            .CSR .content-box .left .monthDiv {
                color: #999999;
                font-size: 12px;
            }

            .CSR .content-box .mid {
                float: left;
                width: calc(100% - 100px);
                overflow: hidden;
                text-align: justify;
                border-bottom: 1px solid #dddddd;
            }

            .CSR .content-box .mid .right {
                float: right;
                margin-bottom: 10px;
            }

            .CSR .content-box .mid .midTitle {
                font-size: 1.8rem;
                font-weight: bold;
                color: #2b2b2f;
            }

            .CSR .content-box .mid .midGray {
                font-size: 1.2rem;
                color: #a0a0a0;
                margin: 16px auto;
                line-height: 20px;
            }

            .CSR .content-box .mid .midGray img {
                width: 100%;
            }

            .CSR .content-box .mid .left {
                float: left;
                width: 100%;
            }
        </style>
    </tiles:putAttribute>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type="text/javascript" src="${webRoot}/js/jqPaginator.min.js"></script>
        <script type="text/javascript" src="${webRoot}/js/socialList.js?${now}"></script>
        <script type="text/javascript">

            $(function () {
                var num = 1;
                loadData(num);
            });

            function loadpage(count, size, on) {
                var myPageCount = parseInt(count);
                var myPageSize = parseInt(size);
                var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1 : (myPageCount / myPageSize);
                //redisFlag = cookie.get("redisFlag");
                /*if (redisFlag == undefined) {
                    redisFlag = 0;
                }*/
                if (redisFlag == '0') {//中文
                    $.jqPaginator('#pagination', {
                        totalPages: parseInt(countindex),
                        visiblePages: parseInt($("#visiblePages").val()),
                        currentPage: on,
                        first: '<li class="first"><a href="javascript:;">首页</a></li>',
                        prev: '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>上一页</a></li>',
                        next: '<li class="next"><a href="javascript:;">下一页<i class="arrow arrow3"></i></a></li>',
                        last: '<li class="last"><a href="javascript:;">尾页</a></li>',
                        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
                        onPageChange: function (num, type) {
                            if (type == "change") {
                                loadData(num);
                            }
                        }
                    });
                } else if (redisFlag == '1') {//英文
                    $.jqPaginator('#pagination', {
                        totalPages: parseInt(countindex),
                        visiblePages: parseInt($("#visiblePages").val()),
                        currentPage: on,
                        first: '<li class="first"><a href="javascript:;">First</a></li>',
                        prev: '<li class="prev"><a href="javascript:;"><i class="arrow arrow2"></i>Prev</a></li>',
                        next: '<li class="next"><a href="javascript:;">Next<i class="arrow arrow3"></i></a></li>',
                        last: '<li class="last"><a href="javascript:;">Last</a></li>',
                        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
                        onPageChange: function (num, type) {
                            if (type == "change") {
                                loadData(num);
                            }
                        }
                    });
                }
                ;
            };

            function loadData(num) {
                $.ajax({
                    type: 'get',
                    async: false,
                    url: webRoot + "/system/social/searchAction.json",
                    data: {
                        'limitEnd': 5,
                        'limitStart': (num - 1) * 5
                    },
                    success: function (data) {
                        var html = '';
                        var pageLength = data.serviceResult.result.total;//总条数
                        var _data = data.serviceResult.result.websiteDonationInstancelist;
                        /*redisFlag = cookie.get("redisFlag");
                        if(redisFlag == undefined){
                            redisFlag = 0;
                        }*/
                        if (_data.length == 0) {
                            /*if(redisFlag == 0){*/
                            $('#newsDiv').html('暂无数据');
                            /*}
                            else if(redisFlag == 1){
                                $('#newsDiv').html('No Data');
                            }*/
                            $('#newsDiv').css({
                                'font-size': '1.6rem',
                                'text-align': 'center',
                                'font-weight': '600',
                                'padding': '60px 0'
                            });
                            $('#pagination').hide();
                        } else {
                            for (var key in _data) {
                                html += '<div class="lineOne">'
                                    + '<div class="left">'
                                    + '<div class="outBox">'
                                    + '<div class="dayBox">' + _data[key].showDay + '</div>'
                                    + '<div class="monthDiv">' + _data[key].showMonth + '</div>'
                                    + '</div>'
                                    + '</div>'
                                    + '<div class="mid">'
                                    + '<div class="left">'
                                    + '	<div class="midTitle">' + _data[key].newsTitle + '</div>'
                                    + '<div class="midGray">' + _data[key].content + '</div>'
                                    + '</div>'
                                    + '<div class="right hide">'
                                    + '<a class="link-btn" href="' + webRoot + '/system/social/detail?id=' + _data[key].id + '">'
                                    + '<i class="iconfont"></i>'
                                    + '<span class="textCN">查看详情</span>'
                                    + '<span class="textEN">View Details</span>'
                                    + '</a>'
                                    + '</div>'
                                    + '</div>'
                                    + '</div>';
                            }
                            $('#newsDiv').html(html);
                            $('#newsDiv').css({
                                'font-size': '1.4rem',
                                'text-align': 'initial',
                                'font-weight': 'normal',
                                'padding': '0'
                            });
                            $('#pagination').show();
                            loadpage(pageLength, 5, num);
                        }
                        ;
                        Hover();
                        $('#newsDiv .midGray').each(function () {
                            var text = $(this).text();
                            var img = $(this).find('img');
                            if (img.length > 0) {
                                img.remove();
                            }
                            if (text.length > 150) {
                                text = text.slice(0, 150) + '...';
                                $(this).text(text);
                            }
                        });
                        if (redisFlag == '0') {//中文
                            $('.textCN').show();
                            $('.textEN').hide();
                        } else if (redisFlag == '1') {//英文
                            $('.textCN').hide();
                            $('.textEN').show();
                        }
                        ;
                    }
                });
            };

            function Hover() {
                $(".lineOne").hover(function () {
                    $(this).find(".outBox").css("background", "#b90b2c");
                    $(this).find(".outBox").css("border", "1px solid #b90b2c");
                    $(this).find(".outBox").css("border", "1px solid #b90b2c");
                    $(this).find(".dayBox").css("color", "white");
                    $(this).find(".monthDiv").css("color", "white");
                    $(this).find(".midTitle").css("color", "#b90b2c");
                    $(this).find(".mid .right").removeClass("hide");
                }, function () {
                    $(this).find(".outBox").css("background", "white");
                    $(this).find(".outBox").css("border", "1px solid #e8e8e8");
                    $(this).find(".outBox").css("border-top", "2px solid #b90b2c");

                    $(this).find(".dayBox").css("color", "#000000");
                    $(this).find(".monthDiv").css("color", "#999999");
                    $(this).find(".midTitle").css("color", "#000000");
                    $(this).find(".mid .right").addClass("hide");
                });
            };
        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>