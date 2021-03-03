<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
var ActionEvents = {
        imgFormatter:function (value,row)
        {
            	var content = [];
	            content.push('<img border="1" width="200px" height="100px" src="'+imgServer+row.imgChineseAdress+'">');
	            return content.join(' ');
        },
        linkFormatter:function (value,row)
        {
            if(value=="0"){
            	return "-";
            }
        	if(value=="1"){
            	var content = [];
	            content.push('<span>共有链接：'+row.linkShare+'</span>');
	            return content.join(' ');
        	}
            if(value=="2"){
            	var content = [];
	            content.push('<span>中文链接：'+row.linkChinese+'</span></br>');
	            content.push('<span>英文链接：'+row.linkEnglish+'</span>');
	            return content.join(' ');
            }
        },
        issueStatusFormatter:function (value,row)
        {
        	if(value=="0")
            	return "未发布";
            if(value=="1")
            	return "已发布";
        },
        actionFormatter: function (value, row) {
            var content = [];
            if(row.issue=='1'){
            	content.push('<button type="button" title="查看" class="btn btn-primary btn-xs list-btn fn-check">查看</button>');
            	 <shiro:hasPermission name="pageHome_banner:SHOW">
            	content.push('<button type="button" title="取消发布" class="btn btn-primary btn-xs list-btn fn-issue-no">取消发布</button>');
            	</shiro:hasPermission>
            }else{
            	<shiro:hasPermission name="pageHome_banner:EDIT">
            	content.push('<button type="button" title="编辑" class="btn btn-primary btn-xs list-btn fn-edit">编辑</button>');
            	</shiro:hasPermission>
            	<shiro:hasPermission name="pageHome_banner:SHOW">
            	content.push('<button type="button" title="发布" class="btn btn-primary btn-xs list-btn fn-issue-yes">发布</button>');
            	</shiro:hasPermission>
            }
            <shiro:hasPermission name="pageHome_banner:DELET">
            content.push('<button type="button" title="删除" class="btn btn-primary btn-xs list-btn fn-delete">删除</button>');
            </shiro:hasPermission>
            return content.join(' ');
        },
        'click .fn-edit': function (e, value, row, index) {
            Events.editAction([row]);
        },
        'click .fn-check': function (e, value, row, index) {
            Events.checkAction([row]);
        },
        'click .fn-issue-yes': function (e, value, row, index) {
            Events.updateIssue([row],"1");
        },
        'click .fn-issue-no': function (e, value, row, index) {
            Events.updateIssue([row],"0");
        },
        'click .fn-delete': function (e, value, row, index) {
            Events.deleteAction([row]);
        },
    },
	Events = {
		addAction:function (selects) {
            layerIndex = layer.open({
                type: 2,
                title: '新增Banner图片',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['800px', '400px'],
                maxmin: true,
                content: [webRoot + '/system/backgroundManageMent/homePageController/addInfo']
            });
            layer.full(layerIndex);
        },
		editAction:function (selects) {
            layerIndex = layer.open({
                type: 2,
                title: '编辑Banner图片',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['800px', '400px'],
                maxmin: true,
                content: [webRoot + '/system/backgroundManageMent/homePageController/editInfo?id='+selects[0].id]
            });
            layer.full(layerIndex);
        },
        checkAction:function (selects) {
            layerIndex = layer.open({
                type: 2,
                title: '查看Banner图片',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['800px', '400px'],
                maxmin: true,
                content: [webRoot + '/system/backgroundManageMent/homePageController/checkInfo?id='+selects[0].id]
            });
            layer.full(layerIndex);
        },
        updateIssue:function (selects,flag) {
			Common.confirm("修改", "确认要修改banner发布状态吗？", function (isConfirm) {
                if (isConfirm) {
                	var formData = [];
                	formData.push({
                        "name": "id",
                        "value": selects[0].id
                    });
                	formData.push({
                        "name": "issue",
                        "value": flag
                    });
                    $.post("updateIssue.json", formData, function (ret) {
                        if (ret.success) {
                            Common.alert("修改成功", function () {
                                Events.searchAction();
                            });
                        } else {
                            var msg = ret.message || "修改失败";
                            Common.error(msg);
                        }
                    }).error(function () {
                        Common.error("修改失败");
                    });
                }
            });
        },
		deleteAction:function (selects) {
			Common.confirm("删除", "确认要删除该banner信息吗？", function (isConfirm) {
                if (isConfirm) {
                	var formData = [];
                	formData.push({
                        "name": "id",
                        "value": selects[0].id
                    });
                    $.post("deleteAction.json", formData, function (ret) {
                        if (ret.success) {
                            Common.alert("删除成功", function () {
                                Events.searchAction();
                            });
                        } else {
                            var msg = ret.message || "删除失败";
                            Common.error(msg);
                        }
                    }).error(function () {
                        Common.error("删除失败");
                    });
                }
            });
        },
        // 查询数据
        searchAction: function () {
        	  //初始化table上面的工具组
            Page.Table.bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 20});
        },
        //得到查询的参数
        tableParams: function (params) {
        	 params.issue = $("#issue").val();
             Page.sort = params.sort;
             Page.order = params.order;
             return params;
        },
        getHeight: function () {
            return $(window).height() - ($(".search-panel").outerHeight() || 60) - 45;
        },
	},
    Page = {
            // 表格
            Table: $("#listTable"),
            // 初始化Validator
            initValidator: function () {
            },
            
            // 事件初期化
            initEvents: function () {
            	$(".fn-add").click(Events.addAction);
    			$(".fn-search").click(Events.searchAction);
            	
            },

            // 画面初始化
            initialize: function () {
            	Page.Table.bootstrapTable({
                    cache: false,
                    height: Events.getHeight(),
                    method: 'post', //这里要设置为get，不知道为什么 设置post获取不了(加上下一句就可以用post了)
                    contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    url: "searchAction.json",
                    dataType: "json",
                    search: false,
                    iconSize: 'outline',
                    sortable: true,
                    pagination: true,
                    pageSize: 20,
                    pageNumber: 1,
                    sidePagination: 'server',//设置为服务器端分页
                    queryParams: Events.tableParams, //参数
                    queryParamsType: 'limit',
                    //toolbar: '#TableEventsToolbar',  //将div exampleTableEventsToolbar的内容作为该table的工具栏
                    //onSort: function (name, order) {
                    //    Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:10});
                    //}
                });
            	
            },
            
            init: function () {
                Page.initEvents();
                Page.initialize();
                Page.initValidator();
            }
        };
jQuery(document).ready(function () {
    Page.init();
}); 

document.onkeydown = function(event) {
	if(event.keyCode == 13){ //$("#searchForm").hasClass("active") && 
		// 执行的方法
		event.preventDefault();
		$("#searchForm").attr("target", "");
		//Events.searchAction();

	}
}
</script>