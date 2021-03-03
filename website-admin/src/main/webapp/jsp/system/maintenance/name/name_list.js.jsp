<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    //--------------------------------------------------------------------------------------------------------------------------------
    var layerIndex,
    /* 事件 */
            Events = {
                addAction: function () {
                    layerIndex = layer.open({
                        type: 2,
                        title: '新增数据字典',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/maintenance/name/infoAction']
                    });
                    layer.full(layerIndex);
                },
                deleteAction: function (selects) {
                    Common.confirm("您确定要删除这条信息吗", "删除后将无法恢复，请谨慎操作！",
                            function (isConfirm) {
                                if (isConfirm) {
                                    $.post("deleteAction.json", {"id": selects[0].id}, function (ret) {
                                        if (ret.success) {
                                            Common.alert("删除成功！", function () {
                                                Events.searchAction();
                                            });
                                        } else {
                                            var msg = (ret.result && ret.result.msg) || "删除失败";
                                            Common.error(msg, function () {
                                                Events.searchAction();
                                            });
                                        }
                                    }).error(function () {
                                        Common.error("删除失败", function () {
                                            Events.searchAction();
                                        });
                                    });
                                }
                            });
                },
                modifyAction: function (selects) {
                    layerIndex = layer.open({
                        type: 2,
                        title: '修改数据字典',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/maintenance/name/infoAction?id=' + selects[0].id]
                    });
                    layer.full(layerIndex);
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
                    var ids = [];
                    if (Page.currNode && Page.currNode.children_d && Page.currNode.children_d.length > 0) {
                        for (var i = 0; i < Page.currNode.children_d.length; i++) {
                            ids.push(Page.currNode.children_d[i]);
                        }
                    } else {
                        if (Page.currNode && Page.currNode.id) {
                            ids.push(Page.currNode.id);
                        }
                    }
                    params.ids = JSON.stringify(ids);
                    params.nameClass = $("#nameClass").val();
                    return params;
                },

                getHeight: function () {
                    return $(window).height() - ($(".search-panel").outerHeight() || 60) - 45;
                }
            },
            ActionEvents = {
                'click .fn-modify': function (e, value, row, index) {
                    Events.modifyAction([row]);
                },
                'click .fn-delete': function (e, value, row, index) {
                    Events.deleteAction([row]);
                },

                actionFormatter: function (value, row) {
                    var content = [];
                    <shiro:hasPermission name="sys_name:MODIFY">
                    content.push('<button type="button" title="编辑" class="btn btn-primary btn-xs list-btn fn-modify">编</button>');
                    </shiro:hasPermission>
                    <shiro:hasPermission name="sys_name:DELETE">
                    content.push('<button type="button" title="删除" class="btn btn-danger btn-xs list-btn fn-delete">删</button>');
                    </shiro:hasPermission>
                    return content.join('');
                },
            },
    /* 画面对象 */
            Page = {
                // 当前结点
                currNode: {},
                // 表格
                Table: $("#listTable"),

                // 初始化Validator
                initValidator: function () {

                },

                // 事件初期化
                initEvents: function () {
                    // 查询按钮按下事件
                    $(".fn-search").click(Events.searchAction);
                    $(".fn-modify").click(Events.modifyAction);
                    $(".fn-add").click(Events.addAction);

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

                    setTimeout(function () {
                        Page.Table.bootstrapTable('resetView');
                    }, 200);

                    $(window).resize(function () {
                        Page.Table.bootstrapTable("resetView", {
                            height: Events.getHeight()
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
    // --------------------------------------------------------------------------------------------------------------------------------
</script>