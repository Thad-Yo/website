//--------------------------------------------------------------------------------------------------------------------------------
var layerIndex,
/* 事件 */
    Events = {
        openAddButtonPage: function () {
            layerIndex = layer.open({
                type: 2,
                title: '添加菜单对应的权限',
                maxmin: true,
                shadeClose: true, // 开启点击遮罩关闭层
                area: ['500px', '400px'],
                maxmin: true,
                content: [webRoot + '/system/maintenance/menu/openMenuButton']
            });
        },
        addAction: function () {
            if(Page.validform.check()) {
                var menuId = $("#menuId").val();
                var action = "insertAction.json";
                if (menuId != "") {
                    action = "updateAction.json";
                }
                $.post(action, $("#mainForm").serializeArray(), function (result) {
                    if (result.success) {
                        if (menuId == "") {
                            $("#menuId").val(result.result);
                        }
                        Common.alert("保存成功!");
                        Page.MenuTree.jstree("refresh");
                        Events.cleanMenuForm();
                    } else {
                        Common.error(result.message);
                    }
                });
            }
        },
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
        modifyMenu: function (node, data) {
            $.post("getMenuPermissionsList.json", {menuId: node.id}, function (rs) {
                Events.cleanMenuForm();
                $("#menuInfo").show();
                $("#parentMenuId").val(node.parent);
                $("#parentMenuName").val(node.li_attr.parentMenuNm);
                $("#menuId").val(node.id);
                $("#menuName").val(node.text);
                $("#menuIcon").val(node.icon);
                $("#menuIconMark").removeClass().addClass($("#menuIcon").val());
                $("#menuUrl").val(node.li_attr.menuUrl);
                $("#menuControllor").val(node.li_attr.menuControllor);
                $("#sort").val(node.li_attr.sortKey);
                $("#delFlag").iCheck(node.li_attr.delFlag == "1" ? "check" : "uncheck");
                // 菜单的权限
                Events.setForPermission(rs.result);
            });
        },
        createMenu: function (node, data) {
            Events.cleanMenuForm();
            $("#menuInfo").show();
            $("#parentMenuId").val(node.id);
            $("#parentMenuName").val(node.text);
        },
        changeMenuIcon: function (item) {
            $("#menuIconMark").removeClass().addClass($(item).val() || "fa fa-list-ul")
        },
        cleanMenuForm: function () {
            $("#mainForm").find("input[type='text']").val("");
            $("#mainForm").find("input[type='hidden']").val("");
            $("#menuIcon").val("fa fa-list-ul");
            $("#menuIconMark").removeClass().addClass($("#menuIcon").val());
            $("#delFlag").iCheck("uncheck");
            $(".Validform_checktip ").removeClass("Validform_right");
            Page.validform.resetForm();
        },
        getForPermission: function () {
            return $("#menuPermissionJson").val();
        },
        setForPermission: function (rs) {
            $("#menuPermissionJson").val(JSON.stringify(rs));
            Events.createMenuBtns(rs);

        },
        createMenuBtns: function (datas) {
            var permissionNames = [];
            if (datas) {
                for (var i in datas) {
                    permissionNames.push(datas[i].permissionName);
                }
                $("#menuBtns").val(permissionNames.join(","));
            }

        }
    },
    ActionEvents = {},
/* 画面对象 */
    Page = {
        validform: {},

        // 画面的主键
        primaryKey: $("#ids"),

        // 表格
        Table: $("#listTable"),

        // 表格
        MenuTree: {},

        // 初始化Validator
        initValidator: function () {
            Page.validform = $(".registerform").Validform({
                datatype:{
                    "menuControllor":function(gets,obj,curform,regxp){
                        //参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
                        var reg1=/[a-z_]{1,100}$/;
                        if(reg1.test(gets)){return true;}
                        return "由1-100位的字母和下划线组成！";
                        //注意return可以返回true 或 false 或 字符串文字，true表示验证通过，返回字符串表示验证失败，字符串作为错误提示显示，返回false则用errmsg或默认的错误提示;
                    }
                },
                tiptype: function (msg, o, cssctl) {
                    if (!o.obj.is("form")) {
                        var objtip = o.obj.siblings(".Validform_checktip");
                        cssctl(objtip, o.type);
                        objtip.text(msg);
                    }
                },
                ajaxPost: true,
            });
        },

        // 事件初期化
        initEvents: function () {
            // 查询按钮按下事件
            $(".fn-add").click(Events.addAction);
            $(".fn-refresh").click(Events.refreshClkAct);
            $(".fn-AddButton").click(Events.openAddButtonPage);
            $(".fn-expandAllBtn").click(Events.openAllClkAct);
            $(".fn-collapseAllBtn").click(Events.closeAllClkAct);
        },

        // 画面初始化
        initialize: function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-red',
            });

            Page.MenuTree = $('#menuTree');
            Page.MenuTree.jstree({
                'core': {
                    'data': {
                        'url': 'menuTree.json',  //异步加载jstree html格式的数据地址
                        'data': function (node) {// 用户jsTree与普通返回对象的映射
                            return {'id': node.id};
                        }
                    },
                },
                'contextmenu': {
                    'items': function (node) {
                        var tmp = $.jstree.defaults.contextmenu.items();
                        delete tmp.create;
                        delete tmp.rename;
                        delete tmp.remove;
                        delete tmp.ccp;
                        tmp.createMenu = {
                            "label": "新建子菜单",
                            "icon": "fa fa-plus",
                            "action": function (data) {
                                Events.createMenu(node, data);
                            }
                        };

                        tmp.editMenu = {
                            "label": "编辑菜单",
                            "icon": "fa fa-pencil",
                            "action": function (data) {
                                Events.modifyMenu(node, data);
                            }
                        };

                        if (node.li_attr.contextmenu == "create_menu") {
                            delete tmp.editMenu;
                        } else if (node.li_attr.contextmenu == "modify_page") {
                            //delete tmp.createMenu;
                        }
                        return tmp;
                    }
                },
                'types': {
                    'default': {'icon': 'fa fa-list-ul'},
                },
                'plugins': ['types', 'contextmenu']
            }).bind("loaded.jstree", function (e, data) {
                Page.MenuTree.jstree("open_all");
            }).bind("select_node.jstree", function (event, data) {//#jtree  是jstree的Id,还有必须设置每个节点的id
                //Page.MenuTree.jstree("toggle_node", "#" + data.node.id);//zjd点击节点显示下级节点
                if(data.node.id != "00000000-0000-0000-0000-000000000000") {
                    Events.modifyMenu(data.node, data);
                }
            }).on("changed.jstree", function (e, data) {
                // if (!(data.node && data.node.children && data.node.children.length > 0)) { // 最后一层节点
                //     if(data.node.id != "00000000-0000-0000-0000-000000000000") {
                //         Events.modifyMenu(data.node, data);
                //     }
                // }
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