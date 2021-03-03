<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var layerIndex,
    /* 事件 */
            Events = {
                addAction: function () {
                    layerIndex = layer.open({
                        type: 2,
                        title: '添加招聘岗位',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['850px', '550px'],
                        maxmin: true,
                        content: [webRoot + '/system/recruitPosition/infoAction']
                    });
                    layer.full(layerIndex);//全屏幕显示
                },
                modifyAction: function (selects) {
                    layerIndex = layer.open({
                        type: 2,
                        title: '编辑招聘岗位',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['800px', '500px'],
                        maxmin: true,
                        content: [webRoot + '/system/recruitPosition/infoAction?id=' + selects[0].id]
                    });
                    layer.full(layerIndex);//全屏幕显示
                },
                
                
              	//重置查询表单
                resetValue: function () {
                    // 招聘岗位
                    $("#recruitPosition").val("");
                    // 岗位状态
                    $("#status").val("");
                    // 办公城市
                    $("#recruitDepartment").val("");
                    $("#department_id").val("");
                    // 招聘类型
                    $("#recruitType").val("");
                    $("department_id").val("");
                    
                },
                
                removeAction: function(selects){
                    var id=selects[0].id;
                    Common.confirm("删除", "确认要删除吗？", function (isConfirm) {
                        if (isConfirm) {
                            $.ajax({
                                type: "POST",
                                url: webRoot + "/system/recruitPosition/removeOrderAction.json",
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
                cancelAction: function(selects){
                    var id=selects[0].id;
                    var status = selects[0].status;
                    console.log(id +';'+status);
                    var content1 = '';
                    var content2 = '';
                    if('y' == status){
                    	content1 = '取消发布';
                    	content2 = '确认要取消发布吗？';
                    }else if('n' == status){
                    	content1 = '发布';
                    	content2 = '确认要发布吗？';
                    }
                    Common.confirm(content1, content2, function (isConfirm) {
                        if (isConfirm) {
                            $.ajax({
                                type: "POST",
                                url: webRoot + "/system/recruitPosition/cancelAction.json",
                                data: JSON.stringify({"id": id}),
                                contentType: "application/json; charset=utf-8",
                                dataType: "json",
                                success: function (result) {
                                    var rs =result.serviceResult;
                                    var ms='';
                                    if(rs.success) {
                                        if(rs.message==null || rs.message=="" || rs.message=="成功"){
                                            ms = content1 + "成功";
                                        }else{
                                            ms = rs.message;
                                        }
                                        Common.alert(ms,function (){
                                            Events.searchAction();
                                        });
                                    }else{
                                        var ms = "";
                                        if(rs.message==null || rs.message==""){
                                            ms = content1 + "失败";
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
                                        ms = content1 + "失败";
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
                	
                    params.recruitPosition = $("#recruitPosition").val();
                    params.status = $("#status").val();
                    params.recruitCity = $("#department_id").val();
                    params.recruitType = $("#recruitType").val();
                    console.log(params);
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
                'click .fn-cancel': function (e, value, row, index) {
                    Events.cancelAction([row]);
                },
                'click .fn-remove': function(e,value,row,index){
                    Events.removeAction([row]);
                },
                actionFormatter: function (value, row) {
                    var content = [];
                    <shiro:hasPermission name="recruitPosition:EDIT">
                    content.push('<button type="button" title="编辑" class="btn btn-info btn-xs list-btn fn-modify">编辑</button>');
                    </shiro:hasPermission>
                    if('n' == row.status){
                    	<shiro:hasPermission name="recruitPosition:PUBLISE">
                    		content.push('<button type="button" title="发布" class="btn btn-warning btn-xs list-btn fn-cancel">发布</button>');
                    	</shiro:hasPermission>
                    }
                    if('y' == row.status){
                    	<shiro:hasPermission name="recruitPosition:CANCELPUB">
                    		content.push('<button type="button" title="取消发布" class="btn btn-warning btn-xs list-btn fn-cancel">取消发布</button>');	
                    	</shiro:hasPermission>
                    }
                    <shiro:hasPermission name="recruitPosition:DELETE">
                    content.push('<button type="button" title="删除" class="btn btn-danger btn-xs list-btn fn-remove">删除</button>');
                    </shiro:hasPermission>
                    return content.join('');
                },
                recruitTypeFormatter: function (value, row) {
                	if (value == "1")
                        return "校园招聘";
                    if (value == "2")
                        return "社会招聘";
				},
                statusFormatter: function (value, row) {
                	if (value == "y")
                        return "已发布";
                    if (value == "n")
                        return "未发布";
				},
               
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

                    $(window).resize(function () {
                        Page.Table.bootstrapTable("resetView", {
                            height: TableCommon.getHeight()
                        });
                    });
                    
                    // 根据招聘岗位展示办公城市树
                    Page.MenuTree = $('#menuTreeDepartment');
                    $("#recruitDepartment").focus(function () {
                        Page.MenuTree.show();
                    });


                    Page.MenuTree.jstree({
                        'core': {
                            'data': {
                                'url': webRoot + '/system/maintenance/department/getDepartmentByDepartmentPCd.json'
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
                        "check_callback": true,
                        'plugins': ['search', 'types', 'checkbox'],
                        'checkbox': {
                            "keep_selected_style": false,//是否默认选中
                            "three_state": false//父子级别级联选择
                        },
                    }).bind("loaded.jstree", function (e, data) {
                        Page.MenuTree.jstree("open_all");
                    }).bind("changed.jstree", function (node, data) {
                        $("#recruitDepartment").val("");
                        $("#department_id").val("");
                        var department_names = "";
                        var department_ids = "";
                        var ref = Page.MenuTree.jstree(true);
                        var nodes = ref.get_checked();
                        $.each(nodes, function (i, nd) {
                        	if(nd != "f9358fba-c335-4e56-ada5-5b8ea6d5c57a"){
                            	department_names += $("#" + nd).attr("areas") + ",";
                            	department_ids += $("#" + nd).attr("id") + ",";
                        	}
                        });
                        console.log(department_names+';'+department_ids);
                        $("#recruitDepartment").val(department_names.substr(0, department_names.length - 1));
                        $("#department_id").val(department_ids.substr(0, department_ids.length - 1));

                        //Page.MenuTree.hide();
                    }).bind("activate_node.jstree", function(node, data) {
                    	//console.log(data);
                    	if(Page.MenuTree.jstree(true).is_checked(data.node)){
                    		Page.MenuTree.jstree(true).check_node(data.node.children_d);
                    		Page.MenuTree.jstree(true).check_node(data.node.parents);
                    	}else{
                    		Page.MenuTree.jstree(true).uncheck_node(data.node.children_d);
                    	}
                    	
                    });
                    var to = false;
                    $('#recruitDepartment').keyup(function () {
                        if (to) {
                            clearTimeout(to);
                        }
                        to = setTimeout(function () {
                            var v = $('#recruitDepartment').val();
                            Page.MenuTree.jstree(true).search(v);
                            Common.filterTree(Page.MenuTree, v.length > 0);
                        }, 250);
                    });
                    Page.MenuTree.hide();
                },

                init: function () {
                    Page.initialize();
                    Page.initEvents();
                    Page.initValidator();
                }
            };

    jQuery(document).ready(function () {
        Page.init();
        
        $("body").click(function (e) {
            var target = $(e.target);
            if ($('#menuTreeDepartment').is(':visible')) {
                if (target.closest("#menuTreeDepartment").length == 0 && target.closest("#recruitDepartment").length == 0) {
                    $("#menuTreeDepartment").fadeOut();
                }
            }

            if ($('#menuTreeDepartment').is(':hidden')) {
                $("#department_name").click(function (e) {
                    $("#menuTreeDepartment").fadeIn();
                    return false;
                });
            }
        })
    
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