//--------------------------------------------------------------------------------------------------------------------------------
var
/* 事件 */
    Events = {

    },
/* 画面对象 */
    Page = {
        // 初始化Validator
        initValidator: function () {

        },

        // 事件初期化
        initEvents: function () {
            $('.J_menuItem').on('click', top.menuItem);
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