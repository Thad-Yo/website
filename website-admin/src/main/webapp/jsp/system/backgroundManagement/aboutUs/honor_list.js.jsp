<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
var ActionEvents = {
        imgFormatter:function (value,row)
        {
            	var content = [];
	            content.push('<img border="1" width="200px" height="100px" src="'+imgServer+row.imgAddress+'">');
	            return content.join(' ');
        },
        linkFormatter:function (value,row)
        {
        },
        issueStatusFormatter:function (value,row)
        {
        	if(value=="0")
            	return "无";
            if(value=="1")
            	return "有";
        },
        actionFormatter: function (value, row) {
            var content = [];
            <shiro:hasPermission name="honor:EDIT">
            content.push('<button type="button" title="编辑" class="btn btn-info btn-xs list-btn fn-edit">编辑</button>');
            </shiro:hasPermission>
            if(row.hasEng=="1"){
            	 <shiro:hasPermission name="honor:EDIT_ENG">
            	content.push('<button type="button" title="编辑英文" class="btn btn-warning btn-xs list-btn fn-edit-en">编辑英文版</button>');
            	</shiro:hasPermission>
            }else{
            	 <shiro:hasPermission name="honor:EDIT_ENG">
            	content.push('<button type="button" title="添加英文" class="btn btn-primary btn-xs list-btn fn-edit-en">添加英文版</button>');
            	</shiro:hasPermission>
            }
            <shiro:hasPermission name="honor:DELET">
            content.push('<button type="button" title="删除" class="btn btn-danger btn-xs list-btn fn-delete">删除</button>');
            </shiro:hasPermission>
            return content.join(' ');
        },
        'click .fn-edit': function (e, value, row, index) {
            Events.editAction([row],"0");
        }, 
        'click .fn-edit-en': function (e, value, row, index) {
            Events.editAction([row],"1");
        },
        'click .fn-delete': function (e, value, row, index) {
            Events.deleteAction([row]);
        },
    },
	Events = {
		addAction:function (selects,flag) {
            layerIndex = layer.open({
                type: 2,
                title: '新增资质荣誉',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['800px', '400px'],
                maxmin: true,
                content: [webRoot + '/system/backgroundManageMent/honorController/addInfo']
            });
            layer.full(layerIndex);
        },
		editAction:function (selects,flag) {
            layerIndex = layer.open({
                type: 2,
                title: '编辑资质荣誉',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['800px', '400px'],
                maxmin: true,
                content: [webRoot + '/system/backgroundManageMent/honorController/editInfo?id='+selects[0].id+"&isEng="+flag]
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
        clearAction: function () {
            var form = $(this).parents("form");
            form.find("input, select").val("");
        },
        //得到查询的参数
        tableParams: function (params) {
        	 params.honorNumber = $("#honorNumber").val();
        	 params.hasEng = $("#hasEng").val();
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
    			$(".fn-clear").click(Events.clearAction);
            	
    			
    			laydate.render({
    				elem:'#honorNumber'
    			})
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
$(document).ready(function () {
    Page.init();
}); 

document.onkeydown = function(event) {
	if(event.keyCode == 13){ //$("#searchForm").hasClass("active") && 
		// 执行的方法
		event.preventDefault();
		$("#searchForm").attr("target", "");
		Events.searchAction();

	}
}
</script>