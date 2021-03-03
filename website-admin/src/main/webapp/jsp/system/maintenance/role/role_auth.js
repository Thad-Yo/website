//--------------------------------------------------------------------------------------------------------------------------------
var
/* 事件 */
    Events = {
        // 确认按键单击事件绑定
        confirmClkAct: function () {
            Page.MenuTree.jstree("open_all");
            var perms = [];
            var checkedNodesIds = Page.MenuTree.jstree("get_checked");
            for (var i = 0, j = checkedNodesIds.length; i < j; i++) {
                checkedNodesIds = checkedNodesIds.concat(Events.getParent(checkedNodesIds[i]));
            }
            var map = [];
            $.each(checkedNodesIds, function (idx, nodeId) {
                var obj = $("#" + nodeId);
                var key = Page.roleId.val() + "_" + obj.attr("parentmenuid") + "_VIEW";
                if (obj.attr("flag") == "2") {
                    key = Page.roleId.val() + "_" + obj.attr("parentmenuid") + "_" + obj.attr("menuid");
                }
                if ($.inArray(key, map) < 0) {
                    if (obj.attr("flag") == "2") {
                        var perm = {};
                        perm.roleId = Page.roleId.val();
                        perm.menuId = obj.attr("parentmenuid");
                        perm.permission = obj.attr("menuid");
                        perms.push(perm);
                    } else if (obj.attr("flag") == "1") {
                        if("00000000-0000-0000-0000-000000000000" != obj.attr("parentmenuid")) {
                            var perm = {};
                            perm.roleId = Page.roleId.val();
                            perm.menuId = obj.attr("parentmenuid");
                            perm.permission = "VIEW";
                            perms.push(perm);
                        }
                    }
                    map.push(key);
                }
            });

            Common.confirm("确认", "确定要保存当前的权限信息吗？", function (isConfirm) {
                if (isConfirm) {
                    $.post("modifyPermissionAction.json", {
                        roleId: Page.roleId.val(),
                        param: JSON.stringify(perms)
                    }, function (data) {
                        if (data.success) {
                            setTimeout(function () {
                                Common.alert("权限修改成功", function () {
                                    parent.layer.closeAll();
                                })
                            }, 100);
                        } else {
                            setTimeout(function () {
                                Common.warning(data.message, function () {
                                    parent.layer.closeAll();
                                })
                            }, 100);
                        }
                    }).error(function () {
                        alert();
                        Common.error("操作失败!", function () {
                            parent.layer.closeAll();
                            parent.Events.refreshClkAct();
                        });
                    });
                }
            })
        },
        // 取消按键单击事件绑定
        cancelClkAct: function () {
            parent.layer.closeAll();
        },
        // 刷新菜单树
        refreshTreeAct: function () {
            Page.MenuTree.jstree("refresh");
        },
        getParent: function (id) {
            var plist = [];
            if (Page.MenuTree.jstree(true).get_parent(id) != '' && Page.MenuTree.jstree(true).get_parent(id) != '#') {
                var p = Page.MenuTree.jstree(true).get_parent(id);
                plist.push(p);
                var pp = Events.getParent(p);
                if (pp && pp.length > 0) {
                    for (var i = 0; i < pp.length; i++) {
                        if (pp[i] != '' && pp[i] != '#') {
                            plist.push(pp[i]);
                        }
                    }
                }
            }
            return plist;
        }
    },
/* 画面对象 */
    Page = {
        // 树
        MenuTree: {},

        // 画面的主键
        roleId: $("#roleId"),

        // 选中的权限
        selectedNode: {},

        // 初始化Validator
        initValidator: function () {
        },

        // 事件初期化
        initEvents: function () {
            // 确认按键单击事件绑定
            $(".fn-Confirm").click(Events.confirmClkAct);
            $(".fn-Cancel").click(Events.cancelClkAct);
        },

        // 画面初始化
        initialize: function () {
            Page.MenuTree = $('#menuTree');
            Page.MenuTree.jstree({
                'core': {
                    "themes": {
                        "responsive": false
                    },
                    "check_callback": true,
                    "data": {
                        "url": "menuInfoAction/" + Page.roleId.val() + ".json",
                        'data': function (node) {// 用户jsTree与普通返回对象的映射
                            return {'id': node.id};
                        }
                    }
                },
                'types': {
                    "default": {
                        "icon": false
                    },
                    "type0": {
                        "icon": "fa fa-cubes text-primary"
                    },
                    "item": {
                        "icon": false
                    }
                },
                'plugins': ["wholerow", "checkbox", "types"],
                "checkbox": {
                    "keep_selected_style": false,
                },
            }).bind("ready.jstree", function (node, data) {
                // var tree = $('#tree_menu').jstree(true);
                // var selectedNodes = Page.TREE.get_selected();
                // if(selectedNodes && selectedNodes.length > 0) {
                //     for (var i = 0;i<selectedNodes.length;i++) {
                //         var n = tree.get_node(selectedNodes[i]);
                //         if(!n.li_attr.selected) {
                //             tree.uncheck_node(selectedNodes[i]);
                //         }
                //     }
                // }
            }).bind("loaded.jstree", function (e, data) {
                Page.MenuTree.jstree("open_all");
            }).bind("changed.jstree", function (node, data) {
                // 保存选中的子节点
                Page.selectedNode = data;
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