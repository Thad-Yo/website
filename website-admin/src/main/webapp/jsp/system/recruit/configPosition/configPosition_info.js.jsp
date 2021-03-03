<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var
    /* 事件 */
            Events = {
                AddButton : function () {
                    var form = "";
                    /*$("#menuPermissionJson" + " :input").each(function () {
                        var name = $(this).attr("name");
                        if(name.indexOf('positionId') > 0){
                            form += $(this).val() + ";";
                        }

                    });*/
                    layerIndex = layer.open({
                        type: 2,
                        title: '添加岗位',
                        maxmin: true,
                        shadeClose: true, // 开启点击遮罩关闭层
                        area: ['500px', '400px'],
                        maxmin: true,
                        content: [webRoot + '/system/configPosition/openPositionButton?id='+$('#id').val() +"&form="+form+"&matchingPositionIds="+$("#matchingPositionIds").val()],
                    });


                },
                cancelAction:function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                },
                saveAction: function () {
                    if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                        Common.confirm("保存", "确认要保存这条信息吗？", function (isConfirm) {
                            if (isConfirm) {
                                var id = $("#id").val();
                                var action = "insertAction.json";
                                if(id !=null && id !=""){
                                    action = "updateAction.json";
                                }
                                $.post(action, $("#mainForm").serializeArray(), function (ret) {
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
                setForPermission: function (positionIds,positionName) {
                    //$("#menuPermissionJson").val(JSON.stringify(rs));
                    //Events.createMenuBtns(rs);
                    $("#matchingPosition").val(positionName);
                    $("#matchingPositionIds").val(positionIds);
                }
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
                    $(".fn-AddButton").click(Events.AddButton);

                },

                // 画面初始化fileList
                initialize: function () {

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