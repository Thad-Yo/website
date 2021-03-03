//--------------------------------------------------------------------------------------------------------------------------------
var
/* 事件 */
    Events = {
        saveAction: function () {
            if (Page.validform.check() && !($(".Validform_error").length > 0)) {
            	//判断用户部门是否重复
            	var departmentCdArr = [];
            	jQuery("input[name='listDepartmentCd']").each(function(index, element){
            		if(jQuery(element).val()!=null && jQuery(element).val()!=""){
            			departmentCdArr.push(jQuery(element).val());
            		}
            	})
            	if(departmentCdArr.length>0){
            		if(departmentCdArr.length!=jQuery.unique(departmentCdArr).length){
            			Common.error("所选部门存在重复区间，请检查部门选择");
            			return false;
            		}
            	}
                var successMessage = "用户添加成功，默认密码a123456";
                var action = "insertAction.json";
                if ($("#userId").val() != "") {
                    action = "updateAction.json";
                    successMessage = "用户修改成功!";
                }

                Common.confirm("保存", "确认要保存这条信息吗？", function (isConfirm) {
                    if (isConfirm) {
                        $.post(action, $("#mainForm").serializeArray(), function (ret) {
                            if (ret.success) {
                                Common.alert(successMessage, function () {
                                    parent.Events.searchAction();
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.layer.close(index);
                                });
                            } else {
                                var msg = (ret.result && ret.result.msg) || "保存失败";
                                Common.error(msg);
                                Page.validform.check();
                            }
                        }).error(function (e) {
                            Common.error("保存失败");
                        });
                    }
                });
            }
        },

        // 刷新树
        refreshClkAct: function () {
            Page.MenuTree.jstree("refresh");
        },

        addRowAction: function (row) {
            var flag = true;
            $("#departmentDiv").find("input[name='listDepartmentCd']").each(function (index,element){
                if(jQuery(element).val()==null || jQuery(element).val()==""){
                	Common.error("请先选择完成该行部门信息后再添加下一行");
                	flag = false;
                }
            });
            if (!flag) {
                return false;
            }
            row = Page.RowTempltsNew.clone();
            $("#departmentDiv").append(row.html());
        },
        
        deleteRowAction: function (row) {
            $(this).parent().parent().parent().remove();
        },

    },
    
    /* 画面对象 */
    Page = {
        // 树
        MenuTree: {},
        validform: {},
        RowTempltsNew: $("#rowTemplts2:eq(0)"),
        // 初始化Validator
        initValidator: function () {
            Page.validform = $(".registerform").Validform({
                tiptype: function (msg, o, cssctl) {
                	debugger;
                    if (o.obj.attr("name") == "userFlag" || o.obj.attr("name") == "departmentName" || o.obj.attr("name") == "customType") {
                        var objtip = o.obj.parent().next();
                        cssctl(objtip, o.type);
                        objtip.text(msg);
                    } else if (!o.obj.is("form")) {
                        var objtip = o.obj.siblings(".Validform_checktip");
                        cssctl(objtip, o.type);
                        objtip.text(msg);
                    }
                },
                datatype: {
                    "username": function (gets, obj, curform, regxp) {
                        return /^[0-9a-zA-Z]{3,20}$/.test(gets)
                    },
                },
                ajaxPost: true,
            });
        },

        // 事件初期化
        initEvents: function () {
            $(".fn-Save").click(Events.saveAction);
            // 拆标行的添加、删除事件
            $("#departmentDiv").on("click", ".fn-addRow", Events.addRowAction).on("click", ".fn-removeRow", Events.deleteRowAction);
            //点击选择部门
            $("#departmentDiv").on("click", "select[name='departmentPCd']", function(){
            	var this_ = jQuery(this);
            	if(jQuery(this_).attr("readonly")!=null && jQuery(this_).attr("readonly")!=""){
                	//获取上一级的部门ID
                	var departmentPCd = jQuery(this_).prev("select").val();
                	var departmentCd = jQuery(this_).val();
                	if(departmentPCd!=null && departmentPCd!=""){
                		//后台获取该父级部门的所有子级部门
                		$.post( webRoot +"/system/maintenance/department/getDepartmentByParam.json", {departmentPCd:departmentPCd}, function (ret) {
                            if(ret.success){
                            	var optionStr = '<option value="">请选择</option>';
                                if(ret.result!=null && ret.result.length>0){
                                	for(var i=0;i<ret.result.length;i++){
                                		if(ret.result[i].departmentCd == departmentCd){
                                    		optionStr += '<option value="'+ret.result[i].departmentCd+'" selected="selected">'+ret.result[i].departmentName+'</option>';
                                		}else{
                                    		optionStr += '<option value="'+ret.result[i].departmentCd+'">'+ret.result[i].departmentName+'</option>';
                                		}
                                	}
                                	//重新选择该部门列表
                                	jQuery(this_).html(optionStr);
                                	jQuery(this_).removeAttr("readonly");
                                }
                            }
                        }).error(function (e) {
                            Common.error("部门查询失败");
                        });
                	}
            	}
            })
            //添加或是更改部门时
            $("#departmentDiv").on("click", "select option", function(){
            	var this_ = jQuery(this).parent("select");
            	jQuery(this_).nextAll("select").remove();
            	if(jQuery(this_).val()!=null && jQuery(this_).val()!=""){
                	jQuery(this_).next("input[name='listDepartmentCd']").val(jQuery(this_).val());
            	}else{
            		jQuery(this_).next("input[name='listDepartmentCd']").val(jQuery(this_).prev("select").val())
            	}
            	var departmentCd = jQuery(this_).val();
            	//根据是否有下一级来显示
            	if(departmentCd!=null && departmentCd!=""){
            		//后台获取该父级部门的所有子级部门
            		$.post( webRoot +"/system/maintenance/department/getDepartmentByParam.json", {departmentPCd:departmentCd}, function (ret) {
                        if(ret.success){
                            if(ret.result!=null && ret.result.length>0){
                            	var optionStr = '<select name="departmentTopCd" style="width: 150px;" class="form-control">';
                            	optionStr += '<option value="">请选择</option>';
                            	for(var i=0;i<ret.result.length;i++){
                            		if(ret.result[i].departmentCd == departmentCd){
                                		optionStr += '<option value="'+ret.result[i].departmentCd+'">'+ret.result[i].departmentName+'</option>';
                            		}else{
                                		optionStr += '<option value="'+ret.result[i].departmentCd+'">'+ret.result[i].departmentName+'</option>';
                            		}
                            	}
                            	optionStr += '</select>';
                            	jQuery(this_).after(optionStr);
                            }
                        }
                    }).error(function (e) {
                        Common.error("部门查询失败");
                    });
            	}
            })
        },

        // 画面初始化
        initialize: function () {

            Page.MenuTree = $('#menuTree');
            Page.MenuTree.jstree({
                'core': {
                    'data': {
                        'url': webRoot + '/system/maintenance/department/departmentTree.json?selectedNode=' + $("#departmentCd").val(),  //异步加载jstree html格式的数据地址
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
                'plugins': ["search", 'types']
            }).bind("loaded.jstree", function (e, data) {
                Page.MenuTree.jstree("open_all");
            }).bind("changed.jstree", function (node, data) {
                // 保存选中的子节点
                var thisNode = data.instance.get_node(data.selected);
                if (thisNode) {
                    $("#departmentCd").val(thisNode.li_attr.departmentCd);
                    $("#departmentName").val(thisNode.li_attr.departmentName);
                }
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