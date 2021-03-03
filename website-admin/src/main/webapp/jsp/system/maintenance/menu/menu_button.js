//--------------------------------------------------------------------------------------------------------------------------------
var layerIndex,
/* 事件 */
    Events = {
        addRowAction: function (row) {
            row = Page.RowTemplts.clone();
            row.appendTo("#permissionTable");
        },
        deleteRowAction: function (row) {
            $(this).closest("tr").remove();
        },
        submitAction: function () {
            var rs = [];
            $("#permissionTable").find("tr").each(function (idx, obj) {
                if (idx != 0) {
                    var row = {};
                    $(this).find("td").each(function (cell, val) {
                        $("input", this).each(function () {
                            row[$(this).attr("name")] = $(this).val();
                        })
                    });
                    rs.push(row);
                }
            });
            parent.Events.setForPermission(rs);
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        }
    },
/* 画面对象 */
    Page = {
        RowTemplts: $("#rowTemplts tr:eq(0)"),


        // 初始化Validator
        initValidator: function () {

        },

        // 事件初期化
        initEvents: function () {
            // 查询按钮按下事件
            $(".fn-submit").click(Events.submitAction);
            // 拆标行的添加、删除事件
            $("#permissionTable").on("click", ".fn-addRow", Events.addRowAction)
                .on("click", ".fn-removeRow", Events.deleteRowAction);
        },

        // 画面初始化
        initialize: function () {
            var menuPermissions = window.parent.Events.getForPermission();
            if (menuPermissions) {
                menuPermissions = JSON.parse(menuPermissions);
                for (var i in menuPermissions) {
                    var row = Page.RowTemplts.clone();
                    row.find("input[name='permissionName']").val(menuPermissions[i].permissionName);
                    row.find("input[name='permission']").val(menuPermissions[i].permission);
                    row.appendTo("#permissionTable");
                }
            }

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