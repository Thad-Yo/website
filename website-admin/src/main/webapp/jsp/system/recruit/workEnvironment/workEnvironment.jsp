<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><html>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tiles:insertTemplate template="/jsp/layout/mainLayout.jsp" flush="true">
	<%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="合作伙伴"/>
    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
    	<div class="wrapper wrapper-content  fadeInRight">
    		<div class="row">
                <div class="panel-body">
                    <div class="alert alert-warning" style = "float:left;margin:-8px 10px;">共${count}张</div>
                    <div class="input-group" style="width: 700px;">
                        <span class="input-group-btn">
                            <button type="button" class="btn" style="margin-left: 20px;">图片尺寸不可超过1M，推荐比例:800x340</button>
                            <button type="button" id="imgAllSelect" class="btn btn-danger" style="margin-left: 550px;">全选</button>
                            <shiro:hasPermission name="workEnvironment:DELET">
                            <button type="button" id="imgDeleteMore" class="btn btn-danger" style="margin-left: 10px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;删除</button>
                        	</shiro:hasPermission>
                        </span>
                </div>
                </div>
                <div class="col-sm-12 disTop">
                    <c:forEach items="${listCtattchment}" var="attchment" begin="0" step="1" varStatus="status">
                        <div class="file-box checkList" style="width:153px;" id="${attchment.id}">
                            <div class="file">
                                <div class="action" style="margin: 0px 0px 0px 5px">
                                    <div class="checkbox clip-check check-primary ">
                                        <input type="checkbox" name="${attchment.fileName}" id="image_${attchment.id}" tid="${attchment.id}" value="${attchment.id}" /> <label  for="image_${attchment.id}"> 
                                    </div>
                                </div>
                                <div class="image" style="height: 120px;">
                                    <%-- <a  onclick="imgBigAction('${attchment.itemId}','${attchment.id}','${topid}','${workorderId}','${orderId}','${attchment.id}')"> --%>
                                    <c:if test="${not empty attchment.savePath}">
                                    	<img alt="image" style="width: 100%" class="" src="${webRoot}${attchment.savePath}">
                                    </c:if>
                                    <%-- <c:if test="${empty attchment.savePath}">
                                    	<img alt="image" style="width: 100%" class="" src="${imgServer}${attchment.savePath}?${time}">
                                    </c:if> --%>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <shiro:hasPermission name="workEnvironment:UPLOAD">
                    <div class="image" style="height: 120px;">
                       <span class="fn-upload btn btn-primary1">&nbsp;点击上传</span>
							<div style="margin-top: 5px;">
							</div>
					   </div>
					   </shiro:hasPermission>
                   </div>
                </div>
            </div>
    	</div>
    </tiles:putAttribute>
     <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
    </tiles:putAttribute>
    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
        <link href="${webRoot}/css/plugins/webuploader/webuploader.css" rel="stylesheet">
        <style type="text/css">
            * {
                margin: 0;
                padding: 0
            }

            ul {
                margin: 50px;
                list-style: none;
            }

            ul li {
                margin: 10px 0;
                display: block;
                float: left;
            }

            ul li img {
                display: inline-block;
                margin: 5px 0 5px 10px;
                width: 50px;
            }

            ul li a {
                font-size: 16px;
                display: inline-block;
                border: 1px solid #ccc;
                padding: 3px 5px;
                border-radius: 5px;
                margin: 0 5px;
            }

            .btns {
                margin: 25px 50px 0 50px;
                width: 365px;
            }

            .btns button {
                margin: 0 3px;

            }

            .btns select {
                margin: 5px 0 0 0;
            }

            button {
                padding: 5px 15px;

            }
            .panel-body{
            	position:fixed;
            	top:0;
            	left:0;
            	background:#fff;
            	z-index:999;
            	opacity:0.7;
            }
            .disTop{
            	padding-top:70px;
            }
            .panel-body{
                opacity:1;
            }
            .panel-body.show{
                opacity:.7;
            }
            .btn-primary1 {
	            width:132px;
	            height:162px;
			    background-color: #FCFCFC;
			    border-color: #1ab394;
			    color: #3B3B3B;
			    font-size:22px;
			    line-height:130px;
			    text-align: center;
			}
        </style>
    </tiles:putAttribute>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/layer/laydate/laydate.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <script src="${webRoot}/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/webuploader/webuploader.js"></script>
        <jsp:include page="workEnvironment.js.jsp"/>
        <script type="text/javascript">
            //实现页面滑动 导航透明度
            var _scrollTop = 100;//内容距离顶部的高度
            $(window).scroll(function() {
                if ($(this).scrollTop() >= _scrollTop) {
                $(".panel-body").addClass("show");
            }else {
                $(".panel-body").removeClass("show");                                                           
                }     
                    
            });
            $(function () {
                var EVENT = {
                    moveUp: function () {
                        var $thisCheckbox = $(".checkList input:checked");
                        var $prev = $thisCheckbox.parent().parent().parent().parent().prev();
                        var $this = $thisCheckbox.parent().parent().parent().parent();
                        if (0 == $thisCheckbox.length) {
                            alert("请选择复选框！");
                            return false;
                        } else if ($thisCheckbox.length > 1) {
                            alert("只能选择一个复选框！");
                            return false;
                        }
                        var id = $this.attr("id");
                        $.post("imgModify.json", {
                            "id": id,
                            "upOrLow": "1"
                        }, function (ret) {
                            if (ret.success) {
                                if ($prev.length) {
                                    $prev.before($this);
                                }
                            } else {
                            	 var message = ret.message==""? "更新失败":ret.message;
                                 Common.alert(message);
                            }
                        })
                    },
                    moveDown: function () {
                        var $thisCheckbox = $(".checkList input:checked");
                        var $next = $thisCheckbox.parent().parent().parent().parent().next();
                        var $this = $thisCheckbox.parent().parent().parent().parent();
                        if (0 == $thisCheckbox.length) {
                            alert("请选择复选框！");
                            return false;
                        } else if ($thisCheckbox.length > 1) {
                            alert("只能选择一个复选框！");
                            return false;
                        }
                        var id = $this.attr("id");
                        $.post("imgModify.json", {
                            "id": id,
                            "upOrLow": "0"
                        }, function (ret) {
                            if (ret.success) {
                                if ($next.length) {
                                    $next.after($this);
                                }
                            } else {
                                var message = ret.message==""? "更新失败":ret.message;
                                Common.alert(message);
                            }
                        })
                    },
                    
                    trunsf: function () {
                        var $thisCheckbox = $(".checkList input:checked");
                        var $next = $thisCheckbox.parent().parent().parent().parent().next();
                        var $this = $thisCheckbox.parent().parent().parent().parent();
                        if (0 == $thisCheckbox.length) {
                            alert("请选择复选框！");
                            return false;
                        }
                        var id = "";
                        $thisCheckbox.each(function () {
                            id = id + $(this).attr("tid") + ',';
                        });
                        var moveId = $("#moveId").val();
                        if (moveId == null || moveId == "") {
                            alert("请选择转移目录后再操作!");
                            return false;
                        }
                        $.post("imgModify.json", {
                            "id": id,
                            "moveId": moveId,
                            "trunsf":"trunsf"
                        }, function (ret) {
                            if (ret.success) {
                                alert("转移成功!");
                                window.location.reload();//刷新当前页面.
                            } else {
                                alert("转移失败!");
                            }
                        })
                    },
                    download: function () {
                        var $thisCheckbox = $(".checkList input:checked");
                        var $next = $thisCheckbox.parent().parent().parent().parent().next();
                        var $this = $thisCheckbox.parent().parent().parent().parent();
                        if (0 == $thisCheckbox.length) {
                            alert("请选择复选框！");
                            return false;
                        }
                        var id = "";
                        $thisCheckbox.each(function () {
                            id = id + $(this).attr("id") + ',';
                        });
                        window.location.href = "imgDownload?id=" + id;
                    },
                    imgSingleDelete: function (id) { 
                        Common.confirm("您确定要删除图片么", "删除后将无法恢复，请谨慎操作！",
                           		function (isConfirm) {
                           		    if (isConfirm) {
                           			$.post("imgModify.json", {
                           			    "id": id,
                           			    }, function (ret) {
                           				if (ret.success) {
                                            alert("删除成功!");
                                            window.location.reload();//刷新当前页面.
                                        } else {
                                            alert("删除失败!");
                                        }
                           			})
                           		    } else {
                           				Common.error("您取消了操作！");
                           		    }
                            });
                    },
                }
                $("#upId").click(function () {
                    EVENT.moveUp();
                });
                $("#downId").click(function () {
                    EVENT.moveDown();
                });
                $("#trunsf").click(function () {
                    EVENT.trunsf();
                });
                $("#download").click(function () {
                    EVENT.download();
                });
                $(".imgSingleDelete").click(function () {
                    var id = $(this).attr("data-id");
                    EVENT.imgSingleDelete(id);
                });
            })
            function imgBigAction(id,nowId,topid,workorderId,orderId,attchmentId){
            	window.open('imgBigAction?id='+id+'&nowId='+nowId+'&topid='+topid+'&workorderId='+workorderId+'&orderId='+orderId+'&attchmentId='+attchmentId);
            }
            
            $(".layui-layer-close").click(function(){
            	//刷新父级窗口
                window.parent.location.reload();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.open(index);
            });
            $(function(){
            	$(".refresh").click(function(){
                	window.location.reload();
                })
            })
        </script>
    </tiles:putAttribute>
</tiles:insertTemplate>