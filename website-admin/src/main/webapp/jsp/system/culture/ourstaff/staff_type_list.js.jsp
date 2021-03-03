<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var layerIndex,
    /* 事件 */
            Events = {
                addAction: function () {
                    layerIndex = layer.open({
                        type: 2,
                        title: '添加员工类型',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['850px', '550px'],
                        maxmin: true,
                        content: [webRoot + '/system/ourstaffTypeController/infoAction']
                    });
                    layer.full(layerIndex);//全屏幕显示
                },
                modifyAction: function (selects) {
                    layerIndex = layer.open({
                        type: 2,
                        title: '编辑员工类型',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/ourstaffTypeController/infoAction?id=' + selects[0].id]
                    });
                    layer.full(layerIndex);//全屏幕显示
                },
                
                
              	//重置查询表单
                resetValue: function () {
                    // 类型名称
                    $("#cultureTypeName").val("");
                },
                
                removeAction: function(selects){
                    var id=selects[0].id;
                    Common.confirm("删除", "确认要删除吗？", function (isConfirm) {
                        if (isConfirm) {
                            $.ajax({
                                type: "POST",
                                url: webRoot + "/system/ourstaffTypeController/removeOrderAction.json",
                                data: JSON.stringify({"id": id}),
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success: function (result) {
                                    var rs =result.serviceResult;
                                    var ms='';
                                    if(rs.success) {
                                        if(rs.message==null || rs.message=="" || rs.message=="删除成功"){
                                            ms = "删除成功";
                                        }else{
                                            ms = rs.message;
                                        }
                                        Common.alert(ms,function (){
                                            Events.searchAction();
                                        });
                                    }else{
                                        var ms = "";
                                        if(rs.message==null || rs.message==""){
                                            ms = "删除失败";
                                        }else{
                                            ms = rs.message;
                                        }
                                        Common.alert(ms, function () {
                                            Events.searchAction();
                                        });
                                    }
                                },
                                error:function(result){
                                    var rs =result.serviceResult;
                                    var ms = "";
                                    if(rs.message==null || rs.message==""){
                                        ms = "删除失败";
                                    }else{
                                        ms = rs.message;
                                    }
                                    Common.alert(ms, function () {
                                        Events.searchAction();
                                    });
                                }
                            });
                        }
                    });
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
                    params.staffTypeName = $("#cultureTypeName").val();
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
                'click .fn-remove': function(e,value,row,index){
                    Events.removeAction([row]);
                },
                actionFormatter: function (value, row) {
                    var content = [];
                    <shiro:hasPermission name="stafftype:EDIT">
                    content.push('<button type="button" title="编辑" class="btn btn-info btn-xs list-btn fn-modify">编辑</button>');
                    content.push('<button type="button" title="删除" class="btn btn-danger btn-xs list-btn fn-remove">删除</button>');
                    </shiro:hasPermission>
                    return content.join('');
                }
               
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
                    $(".fn-reset").click(Events.resetValue);
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