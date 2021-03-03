//--------------------------------------------------------------------------------------------------------------------------------
var layerIndex,
/* 事件 */
    Events = {
        addAction: function () {
            layerIndex = layer.open({
                type: 2,
                title: '新增用户',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['800px', '500px'],
                maxmin: true,
                content: [webRoot + '/system/maintenance/adminuser/infoAction']
            });
            layer.full(layerIndex);
        },
        deleteAction: function (selects) {
            Common.confirm("您确定要删除这条信息吗", "删除后将无法恢复，请谨慎操作！",
                function (isConfirm) {
                    if (isConfirm) {
                        $.post("deleteAction.json", {"userId": selects[0].userId}, function (ret) {
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
                title: '修改用户信息',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['800px', '500px'],
                maxmin: true,
                content: [webRoot + '/system/maintenance/adminuser/infoAction?userId=' + selects[0].userId]
            });
            layer.full(layerIndex);
        },

        // 重置密码
        resetAction: function (selects) {
            Common.confirm("您确定要重置密码吗", "重置密码后将无法恢复，请谨慎操作！",
                function (isConfirm) {
                    if (isConfirm) {
                        $.post("resetAction.json", {userId : selects[0].userId} , function (ret) {
                            if (ret.success) {
                                Common.alert("操作成功，密码重置为 a123456", function () {
                                    Events.searchAction();
                                });
                            } else {
                                var msg = (ret.result && ret.result.msg) || "操作失败";
                                Common.error(msg, function () {
                                    Events.searchAction();
                                });
                            }
                        }).error(function () {
                            Common.error("操作失败", function () {
                                Events.searchAction();
                            });
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
            $("#rightPanel").show();
            //初始化table上面的工具组
            Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:10});
        },
        //得到查询的参数
        tableParams: function (params) {
            var ids = [];
            if (Page.currNode) {
                if ("00000000-0000-0000-0000-000000000000" == Page.currNode.id) {

                } else {
                    if (Page.currNode.children_d && Page.currNode.children_d.length > 0) {
                        for (var i = 0; i < Page.currNode.children_d.length; i++) {
                            ids.push(Page.currNode.children_d[i]);
                        }
                    }
                    if (Page.currNode.id) {
                        ids.push(Page.currNode.id);
                    }
                    params.ids = JSON.stringify(ids);
                }
            } else {
                params.ids = "";
            }
            params.realName = $("#realName").val();
            params.mobileNumber = $("#mobileNumber").val();
            params.roleName = $("#roleName").val();
            params.userName = $("#userName").val();
            return params;
        },

        getHeight: function () {
            return $(window).height() - ($(".search-panel").outerHeight() || 60) - 45;
        },

        // 刷新树
        refreshClkAct: function () {
            Page.MenuTree.jstree("refresh");
        },

        // 展开树
        openAllClkAct: function () {
            Page.MenuTree.jstree("open_all");
        },

        // 收起树
        closeAllClkAct: function () {
            Page.MenuTree.jstree("close_all");
        },
    },
    ActionEvents = {
        'click .fn-reset': function (e, value, row, index) {
            Events.resetAction([row]);
        },
        'click .fn-modify': function (e, value, row, index) {
            Events.modifyAction([row]);
        },
        'click .fn-delete': function (e, value, row, index) {
            Events.deleteAction([row]);
        },

        actionFormatter: function (value, row) {
            var content = [];
            content.push('<button type="button" title="重置密码" class="btn btn-info btn-xs list-btn fn-reset">重</button>');
            content.push('<button type="button" title="编辑" class="btn btn-primary btn-xs list-btn fn-modify">编</button>');
            content.push('<button type="button" title="删除" class="btn btn-danger btn-xs list-btn fn-delete">删</button>');
            return content.join('');
        },
    },
/* 画面对象 */
    Page = {
        // 表格
        Table: $("#listTable"),
        // 树
        MenuTree: {},
        // 当前结点
        currNode: {},

        // 初始化Validator
        initValidator: function () {

        },

        // 事件初期化
        initEvents: function () {
            // 查询按钮按下事件
            $(".fn-search").click(Events.searchAction);
            $(".fn-modify").click(Events.modifyAction);
            $(".fn-add").click(Events.addAction);
            $(".fn-refresh").click(Events.refreshClkAct);
            $(".fn-expandAllBtn").click(Events.openAllClkAct);
            $(".fn-collapseAllBtn").click(Events.closeAllClkAct);
        },

        // 画面初始化
        initialize: function () {
            Page.Table.bootstrapTable({
                height: Events.getHeight(),
                method: 'get', //这里要设置为get，不知道为什么 设置post获取不了
                url: "searchAction.json",
                dataType: "json",
                search: false,
                sortable: true,
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

            Page.MenuTree = $('#menuTree');
            Page.MenuTree.jstree({
                'core': {
                    'data': {
                        'url': webRoot + '/system/maintenance/department/departmentTree.json',  //异步加载jstree html格式的数据地址
                        'data': function (node) {// 用户jsTree与普通返回对象的映射
                            return {'id': node.id};
                        }
                    },
                },
                'types': {
                    "default": {
                        "icon": false
                    },
                    "item": {
                        "icon": false
                    }
                },
                'plugins': ['search', 'types']
            }).bind("loaded.jstree", function (e, data) {
                Page.MenuTree.jstree("open_all");
            }).bind("changed.jstree", function (node, data) {
                // 保存选中的子节点
                var thisNode = data.instance.get_node(data.selected);
                Page.currNode = thisNode;
                Page.currNode.trueId = (Page.currNode.id || "").replace("attv", "");
                Events.searchAction();
            });

            var to = false;
            $('#tree_search').keyup(function () {
                if (to) {
                    clearTimeout(to);
                }
                to = setTimeout(function () {
                    var v = $('#tree_search').val();
                    Page.MenuTree.jstree(true).search(v);
                    Common.filterTree(Page.MenuTree, v.length > 0);
                }, 250);
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