//--------------------------------------------------------------------------------------------------------------------------------
var
/* 事件 */
    Events = {
        //refreshMsgCnt: function () {
        //    $.post(webRoot + '/system/desktop/getUnreadMsgCnt.json', {}, function (result) {
        //        if (result.success == "0") {
        //            $(".unread-msg-cnt").html(result.result.total || '0');
        //            var rows = result.result.rows || [];
        //            if (rows.length > 0) {
        //                var msgs = [];
        //                $(rows).each(function (index, element) {
        //                    msgs.push(element.messageContent || '');
        //                });
        //                $("#unreadMsg").html('<b>最新消息：</b>' + msgs.join('&nbsp;&nbsp;|&nbsp;&nbsp;'));
        //            } else {
        //                $("#unreadMsg").html('');
        //            }
        //            Page.time = new Date();
        //        }
        //    });
        //
        //    setTimeout(Events.refreshMsgCnt, 1000 * 60 * 2);
        //}
    },
/* 画面对象 */
    Page = {
        time: new Date(),
        // 初始化Validator
        initValidator: function () {

        },

        // 事件初期化
        initEvents: function () {
        },

        // 画面初始化
        initialize: function () {
            //Events.refreshMsgCnt();

            //$(".count-info").click(function () {
            //    var result = parseInt((new Date() - Page.time) / (60 * 1000));
            //    $(".unread-msg-time").html(result);
            //});
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