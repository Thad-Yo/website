<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var
    /* 事件 */
            Events = {
                cancelAction:function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                },
                saveAction: function () {
                    if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                        var positionIntroduce=editor.getContent();
                        Common.confirm("保存", "确认要保存这条信息吗？", function (isConfirm) {
                            if (isConfirm) {
                            	
                            	var formData = [];
                                
                                formData.push({"name":"recruitType","value": $("input[name='recruitType']:checked").val()});
                                formData.push({"name":"positionType","value": $("#positionType option:selected").val()});
                                formData.push({"name":"positionTypeName","value": $("#positionType option:selected").text()});
                                formData.push({"name":"recruitPositionId","value": $("#recruitPosition option:selected").val()});
                                formData.push({"name":"recruitPosition","value": $("#recruitPosition option:selected").text()});
                                formData.push({"name":"salary","value": $("#salary").val()});
                                formData.push({"name":"recruitCity","value": $("#department_id").val()});
                                formData.push({"name":"recruitCityName","value": $("#recruitDepartment").val()});
                                formData.push({"name":"positionIntroduce","value": positionIntroduce});
                                
                                var id = $("#id").val();
                                var action = "insertAction.json";
                                if(id !=null && id !=""){
                                	formData.push({"name":"id","value": id});
                                    action = "updateAction.json";
                                }
                                $.post(action, formData, function (ret) {
                                    if (ret.success) {
                                        Common.alert("保存成功", function () {
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
                
                publishAction: function () {
                    if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                        Common.confirm("发布", "确认要发布该招聘岗位吗？", function (isConfirm) {
                            if (isConfirm) {
                                var id = $("#id").val();
                                var formData = [];
                                
                                formData.push({"name":"recruitType","value": $("input[name='recruitType']:checked").val()});
                                formData.push({"name":"positionType","value": $("#positionType option:selected").val()});
                                formData.push({"name":"positionTypeName","value": $("#positionType option:selected").text()});
                                formData.push({"name":"recruitPositionId","value": $("#recruitPosition option:selected").val()});
                                formData.push({"name":"recruitPosition","value": $("#recruitPosition option:selected").text()});
                                formData.push({"name":"salary","value": $("#salary").val()});
                                formData.push({"name":"recruitCity","value": $("#department_id").val()});
                                formData.push({"name":"recruitCityName","value": $("#recruitDepartment").val()});
                                formData.push({"name":"positionIntroduce","value": $("#positionIntroduce").val()});
                                
                                formData.push({"name":"id","value": id});
                                
                                $.post("publishAction.json", formData , function (ret) {
                                    if (ret.success) {
                                        Common.alert("发布成功", function () {
                                            parent.Events.searchAction();
                                            var index = parent.layer.getFrameIndex(window.name);
                                            parent.layer.close(index);
                                        });
                                    } else {
                                        var msg = (ret.result && ret.result.msg) || "发布失败";
                                        Common.error(msg);
                                        Page.validform.check();
                                    }
                                }).error(function (e) {
                                    Common.error("发布失败");
                                });
                            }
                        });
                    }
                },
              	//得到查询的参数
                tableParams: function (params) {
                    params.positionType = $("#positionType").val();
                    params.recruitPosition = $("#recruitPosition").val();
                    params.salary = $("#salary").val();
                    params.recruitCity = $("#department_id").val();
                    params.positionIntroduce = $("#positionIntroduce").val();
                    return params;
                },
                
                
            },
    /* 画面对象 */
            Page = {
                validform: {},
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
                    $(".fn-Save").click(Events.saveAction);
                    $(".fn-Cancel").click(Events.cancelAction);
                    $(".fn-Publish").click(Events.publishAction);
                },

                // 画面初始化fileList
                initialize: function () {
                	
                	$("#positionType").change(function () {
                		var selRecruitPosition = $("#recruitPosition");
                		$.ajax({
                            type: "POST",
                            url: webRoot + "/system/recruitPosition/getPositionList.json",
                            data: JSON.stringify({positionType: $(this).val()}),
                            contentType: "application/json; charset=utf-8",
                            dataType: "json",
                            success: function (rs) {
                            	selRecruitPosition.empty().append('<option value="">请选择</option>').trigger("change");
                                if (rs.result != null) {
                                    $.each(rs.result, function (idx, obj) {
                                        var option = '<option value="' + obj.key + '" ' + '>' + obj.value + '</option>';
                                        selRecruitPosition.append(option);
                                    });
                                }
                            }
                        });
                    });
                    
                	
                	// 根据招聘岗位展示办公城市树
                    Page.MenuTree = $('#menuTreeDepartment');
                	var arr = [];
                	var idStr = $("#department_id").val();
                	if(idStr !=''){
                		 $("#recruitDepartment").focus(function () {
                     		arr = idStr.split(',');
                     		var arrId = null;
                     		var objId = null;
                     		for(var i = 0; i < arr.length; i++){
                         		$('#menuTreeDepartment ul li').each(function(){
                         			objId = $(this).children('a').attr('id').indexOf($.trim(arr[i]));
                         			if(objId > -1){
                         				var text = $(this).children('a').text();
                         				$(this).children('a').addClass('jstree-clicked');
                         			}
                         		})
                     		}
                             Page.MenuTree.show();
                         });
                     	var arrId = [];
                     	var arrText = [];
                         $("#menuTreeDepartment").on('click',function(){
                         	arrId = [];
                         	arrText = [];
                         	$('#menuTreeDepartment > ul > li').find('ul li').each(function(){
                         		var aObj = $(this).children('a');
                         		if(aObj.hasClass('jstree-clicked')){
                         			var liId = $(this).attr('id');
                         			var text = $.trim(aObj.text());
                         			arrId.push(liId);
                         			arrText.push(text);
                         		}
                         	});
                         	var strId = arrId.join(',');
                         	var strText = arrText.join(',');
                         	$('#department_id').val(strId);
                         	$('#recruitDepartment').val(strText);
                         	
                         });
                	}
                	else{
                		$("#recruitDepartment").focus(function () {
                			Page.MenuTree.show();
                		})
                        
                	}

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
                        //console.log(department_names+';'+department_ids);
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
</script>