//--------------------------------------------------------------------------------------------------------------------------------
var
/* 事件 */
    Events = {
        saveAction: function () {
            if (Page.validform.check()) {
                $.post(webRoot + '/system/modpwd/ajaxCheckAction.json', {'param': $("#oldPassword").val()}, function (result) {
                    if(result.status != 'y') {
                        return;
                    }
                    Common.confirm("确认", "确认要修改密码吗？", function (isConfirm) {
                        if (isConfirm) {
                            var action = "updateAction.json";
                            $.post(action, $("#mainForm").serialize(), function (data) {
                                if (data.success == "0") {
                                    swal({
                                            title: "密码修改成功！",
                                            type: "success",
                                            showCancelButton: false,
                                            closeOnConfirm: true,
                                            closeOnCancel: false
                                        },
                                        function (isConfirm) {
                                            if (isConfirm) {
                                                Page.validform.resetForm();
                                            }
                                        });
                                } else {
                                    Page.validform.check();
                                }
                            });
                        }
                    });
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