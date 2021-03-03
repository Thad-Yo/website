<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var layerIndex,
    /* 事件 */
            Events = {
                addAction: function () {
                    layerIndex = layer.open({
                        type: 2,
                        title: '添加产品详情',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['850px', '550px'],
                        maxmin: true,
                        content: [webRoot + '/system/product/infoAction']
                    });
                    layer.full(layerIndex);//全屏幕显示
                },
                modifyAction: function (selects) {
                	 selects[0].cnEnFlag='0';
                    layerIndex = layer.open({
                        type: 2,
                        title: '编辑产品详情',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/product/infoAction?id=' + selects[0].id+'&cnEnFlag='+selects[0].cnEnFlag+'&hasEnFlag='+selects[0].hasEnFlag+'&productType='+selects[0].productType]
                    });
                    layer.full(layerIndex);//全屏幕显示
                },
                enmEdifyAction: function (selects) {
                    selects[0].cnEnFlag='1';
                    layerIndex = layer.open({
                        type: 2,
                        title: '编辑产品详情',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/product/infoAction?id=' + selects[0].id+'&cnEnFlag='+selects[0].cnEnFlag+'&hasEnFlag='+selects[0].hasEnFlag+'&productType='+selects[0].productType]
                    });
                    layer.full(layerIndex);//全屏幕显示
                },
                // 序号格式化
                indexFormat: function (value, row, index) {
                    return index + 1;
                },
                // 查询数据
                searchAction: function () {
                    //初始化table上面的工具组
                    Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:20});
                },
                //得到查询的参数
                tableParams: function (params) {
                    params.newsTitle = $("#newsTitle").val();
                    params.publishTime = $("#publishTime").val();
                    params.type = $("#type").val();
                    params.hasEnFlag = $("#hasEnFlag").val();
                    return params;
                },
                getHeight: function () {
                    return $(window).height() - 100;
                }
            },
            ActionEvents = {
                'click .fn-modify': function (e, value, row, index) {
                    Events.modifyAction([row]);
                },
                'click .fn-enModify': function (e, value, row, index) {
                    Events.enmEdifyAction([row]);
                },
                imgFormatter:function (value,row)
                {
                    var content = [];
                    content.push('<img border="1" width="200px" height="100px" src="'+imgServer+row.coverPageUrl+'">');
                    return content.join(' ');
                },
                hasEnAction:function(value,row){
                    var content = [];
                    if(row.hasEnFlag=='1'){
                        content.push('有');
                    }else if(row.hasEnFlag=='0'){
                        content.push('无');
                    }
                    return content.join(' ');
                },
                actionFormatter: function (value, row) {
                    var content = [];
                    <shiro:hasPermission name="product:EDIT">
                    content.push('<button type="button" title="编辑" class="btn btn-info btn-xs list-btn fn-modify">编辑</button>');
                    </shiro:hasPermission>
                    <shiro:hasPermission name="product:EDITEN">
                    if (row.hasEnFlag == "0") {
                        content.push('<button type="button" title="添加英文版" class="btn btn-primary btn-xs list-btn fn-enModify">添加英文版</button>');
                    } else {
                        content.push('<button type="button" title="编辑英文版" class="btn btn-warning btn-xs list-btn fn-enModify">编辑英文版</button>');
                    }
                    </shiro:hasPermission>
                    return content.join('');
                },
                /* notesAction:function(value){
                    if(value!=null){
                        var valueStr = value.length>10?value.substring(0,15)+'......':value;
                        var str = '<span title="'+value+'">'+valueStr+'</span>';
                    return str;
                    }
                } */
            },
    /* 画面对象 */
            Page = {
                // 表格
                Table: $("#listTable"),

                // 初始化Validator
                initValidator: function () {

                },

                // 事件初期化
                initEvents: function () {
                    // 查询按钮按下事件
                    $(".fn-add").click(Events.addAction);
                    $(".fn-refresh").click(Common.refreshClkAct);
                    $(".fn-search").click(Events.searchAction);
                },

                // 画面初始化
                initialize: function () {
                    Page.Table.bootstrapTable({
                    	cache:false,
                        height: Events.getHeight(),
                        method: 'get', //这里要设置为get，不知道为什么 设置post获取不了
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
                        onSort: function (name, order) {
                            Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:20});
                        }
                    });

                    $(window).resize(function () {
                        Page.Table.bootstrapTable("resetView", {
                            height: TableCommon.getHeight()
                        });
                    });
                },

                init: function () {
                    Page.initialize();
                    Page.initEvents();
                    Page.initValidator();
                }
            };

    jQuery(document).ready(function () {
        Page.init();
    });
    document.onkeydown = function(event) {
    	if(event.keyCode == 13){ //$("#searchForm").hasClass("active") && 
    		// 执行的方法
    		$("#searchForm").attr("target", "");
    		//$("#paginator-page").val(1);
    		Events.searchAction();
    	}
    }
</script>