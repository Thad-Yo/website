<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    var layerIndex,
    /* 事件 */
            Events = {
                addRowAction: function (row) {
                    row = Page.RowTemplts.clone();
                    $("#positionDiv").append(row.html());
                },
                deleteRowAction: function (row) {
                    $(this).parent().parent().parent().remove();
                },
                addAction: function () {
                    if (Page.validform.check()) {
                        var action = "insertAction.json";
                        if ($("#departmentCd").val() != "") {
                            action = "updateAction.json";
                        }
                        Page.MenuTree.jstree('deselect_all');
                        $.post(action, $("#mainForm").serializeArray(), function (data) {
                            if (data.success) {
                                $("#departmentCd").val(data.result.departmentCd);
                                $("#id").val(data.result.id);
                                $("#departmentPCd").val(data.result.departmentPCd);
                                Common.alert("保存成功!");
                                if(data.result.delFlag!=null&&data.result.delFlag=="1"){
                                	  $("#departmentInfo").hide();
                                }
                                
                                Page.MenuTree.jstree("cal_refresh", function () {
                                    Page.MenuTree.jstree('select_node', Page.MenuTree.jstree("get_node", data.result.id));
                                });
                            } else {
                                Common.error(data.message);
                            }
                        });
                    }
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
                modifyMenu: function (node, data) {
                    $.post("geDepartment.json", {departmentCd: node.id}, function (rs) {
                        Events.cleanMenuForm();
                        $("#departmentInfo").show();
                        if (rs.success) {
                            var data = rs.result;
                            $("#id").val(data.id);
                            $("#departmentCd").val(data.departmentCd);
                            $("#departmentCdDisplay").val(data.departmentCd);
                            $("#departmentPCd").val(data.departmentPCd);
                            $("#departmentName").val(data.departmentName);
                            
                            $("#departmentIp").val(data.departmentIp);
                            $("#departmentPName").val(node.li_attr.departmentPName);
                            $("#sortKey").val(data.sortKey);
                            if (data.savePath) {
                                $("#deartmentImage").attr("src", webRoot + data.savePath);
                            }
                            $("#delFlag").iCheck(data.delFlag == "1" ? "check" : "uncheck");
                        }
                    });
                },
                createMenu: function (node, data) {
                    Events.cleanMenuForm();
                    $("#departmentInfo").show();
                    $("#departmentPCd").val(node.li_attr.departmentCd);
                    $("#departmentPName").val(node.text);

                    $("#positionDiv").html("");
                    if (node.parent != "#") {
                        var row = Page.RowTempltsNew.clone();
                        $("#positionDiv").append(row.html());
                    }
                },
                changeMenuIcon: function (item) {
                    $("#menuIconMark").removeClass().addClass($(item).val() || "fa fa-list-ul")
                },
                cleanMenuForm: function () {
                    $("#mainForm").find("input[type='text']").val("");
                    $("#mainForm").find("input[type='hidden']").val("");
                    $("#delFlag").iCheck("uncheck");
                    $(".Validform_checktip ").removeClass("Validform_right");
                    Page.validform.resetForm();
                }
            },
            ActionEvents = {},
    /* 画面对象 */
            Page = {
                RowTemplts: $("#rowTemplts:eq(0)"),
                RowTempltsNew: $("#rowTemplts2:eq(0)"),
                validform: {},
                // 表格
                MenuTree: {},
                // 初始化Validator
                initValidator: function () {
                    Page.validform = $(".registerform").Validform({
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
                    $("#deartmentImage").click(Events.uploadImageOne);
                    $(".fn-expandAllBtn").click(Events.openAllClkAct);
                    $(".fn-collapseAllBtn").click(Events.closeAllClkAct);

                    // 拆标行的添加、删除事件
                    $("#positionDiv").on("click", ".fn-addRow", Events.addRowAction)
                            .on("click", ".fn-removeRow", Events.deleteRowAction)
                            .on("change", "select[name='province']", Events.provinceChange);
                },

                // 画面初始化
                initialize: function () {
                    var nowDepartmentCd=$("#nowDepartmentCd").val();
                    $('.i-checks').iCheck({
                        checkboxClass: 'icheckbox_square-red',
                    });

                    Page.MenuTree = $('#menuTree');
                    Page.MenuTree.jstree({
                        'core': {
                            'data': {
                                'url': 'departmentTree.json',  //异步加载jstree html格式的数据地址
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
                                    "label": "新建",
                                    "icon": "fa fa-plus",
                                    "action": function (data) {
                                        Events.createMenu(node, data);
                                    }
                                };

                                tmp.editMenu = {
                                    "label": "编辑",
                                    "icon": "fa fa-pencil",
                                    "action": function (data) {
                                        Events.modifyMenu(node, data);
                                    }
                                };
								
                                if (node.li_attr.contextmenu == "create_menu") {
                                    delete tmp.editMenu;
                                   //if(node.li_attr.departmentCd!=$("#nowDepartmentCd").val()){
                                   //	delete tmp.createMenu;
                                   //} 
                                }
                                /*	无限添加子集部门
								else if (node.li_attr.level == 3) {
                                    delete tmp.createMenu;
                                }
                                if (node.li_attr.level == 2 && nowDepartmentCd!= "") {
                                    delete tmp.createMenu;
                                }
                                */
                                
                                return tmp;
                            }
                        },
                        'types': {
                            "default": {
                                "icon": false
                            },
                            "item": {
                                "icon": false
                            }
                        },
                        'plugins': ['search', 'types', 'contextmenu']
                    }).bind("loaded.jstree", function (e, data) {
                        Page.MenuTree.jstree("open_all");
                    }).bind("select_node.jstree", function (event, data) {//#jtree  是jstree的Id,还有必须设置每个节点的id
                        // Page.MenuTree.jstree("toggle_node", "#" + data.node.id);//zjd点击节点显示下级节点
                        if (data.node.id != "00000000-0000-0000-0000-000000000000") {
                            Events.modifyMenu(data.node, data);
                        }
                    }).on("changed.jstree", function (e, data) {

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
</script>