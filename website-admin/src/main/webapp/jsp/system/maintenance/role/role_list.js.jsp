<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var layerIndex,
    /* 事件 */
            Events = {
                addAction: function () {
                    layerIndex = layer.open({
                        type: 2,
                        title: '添加角色',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/maintenance/role/infoAction']
                    });
                    //layer.full(layerIndex);全屏幕显示
                },
                deleteAction: function (selects) {
                    Common.confirm("您确定要删除这条信息吗", "删除后将无法恢复，请谨慎操作！",
                            function (isConfirm) {
                                if (isConfirm) {
                                    $.post("deleteAction.json", {
                                        "roleId": selects[0].roleId,
                                        "delFlag": "1"
                                    }, function (ret) {
                                        Common.alert("删除成功！", function () {
                                            Events.searchAction();
                                        });
                                    })
                                } else {
                                    Common.error("您取消了删除操作！");
                                }
                            });
                },
                modifyAction: function (selects) {
                    layerIndex = layer.open({
                        type: 2,
                        title: '修改角色',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/maintenance/role/infoAction?roleId=' + selects[0].roleId]
                    });
                },
                // 授权按钮的单击动作事件
                authClkAct: function (selects) {
                    layerIndex = layer.open({
                        type: 2,
                        title: '授权',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/maintenance/role/authAction?roleId=' + selects[0].roleId]
                    });
                },
                // 序号格式化
                indexFormat: function (value, row, index) {
                    return index + 1;
                },

                // 查询数据
                searchAction: function () {
                    //初始化table上面的工具组
                    Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:10});
                },
                //得到查询的参数
                tableParams: function (params) {
                    params.role = $("#role").val();
                    params.roleName = $("#roleName").val();
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
                'click .fn-delete': function (e, value, row, index) {
                    Events.deleteAction([row]);
                },
                'click .fn-auth': function (e, value, row, index) {
                    Events.authClkAct([row]);
                },

                actionFormatter: function (value, row) {
                    var content = [];
                    <shiro:hasPermission name="sys_role:MODIFY">
                    content.push('<button type="button" title="编辑" class="btn btn-success btn-xs list-btn fn-modify">编</button>');
                    </shiro:hasPermission>
                    <shiro:hasPermission name="sys_role:AUTH">
                    content.push('<button type="button" title="授权" class="btn btn-info btn-xs list-btn fn-auth">权</button>');
                    </shiro:hasPermission>
                    <shiro:hasPermission name="sys_role:DELETE">
                    content.push('<button type="button" title="删除" class="btn btn-danger btn-xs list-btn fn-delete">删</button>');
                    </shiro:hasPermission>
                    return content.join('');
                },
            },
    /* 画面对象 */
            Page = {
                // 画面的主键
                primaryKey: $("#ids"),

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
                        height: Events.getHeight(),
                        method: 'get', //这里要设置为get，不知道为什么 设置post获取不了
                        url: "searchAction.json",
                        dataType: "json",
                        search: false,
                        iconSize: 'outline',
                        sortable: true,
                        pagination: true,
                        pageSize: 10,
                        pageNumber: 1,
                        sidePagination: 'server',//设置为服务器端分页
                        queryParams: Events.tableParams, //参数
                        queryParamsType: 'limit',
                        //toolbar: '#TableEventsToolbar',  //将div exampleTableEventsToolbar的内容作为该table的工具栏
                        onSort: function (name, order) {
                            Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:10});
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
</script>