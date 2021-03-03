<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    //--------------------------------------------------------------------------------------------------------------------------------
    var
    /* 事件 */
            Events = {
                saveAction: function () {
                    if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                        var action = "insertAction.json";
                        if ($("#id").val() != "") {
                            action = "updateAction.json";
                        }
                        Common.confirm("保存", "确认要保存这条信息吗？", function (isConfirm) {
                            if (isConfirm) {
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
                                }).error(function () {
                                    Common.error("保存失败");
                                });
                            }
                        });
                    }
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
                },

                // 画面初始化
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
    // --------------------------------------------------------------------------------------------------------------------------------
</script>