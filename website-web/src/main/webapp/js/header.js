/* 事件动作处理 */
EventsHeader = {
    resizeAct: function (event) {
    },
    menuFunction: function () {
        var gun = document.documentElement.scrollTop || document.body.scrollTop;
        if (gun > 0) {
            $("header").addClass('scroll');
        } else {
            $("header").removeClass('scroll');
        }
    },
};
var PageHeader = {
    initEventsHeader: function () {
        $(document).scroll(EventsHeader.menuFunction);
    }
};
PageHeader.initEventsHeader();

function ajax(num, text) {
    $.ajax({
        type: "GET",
        cache: false,
        url: webRoot + "/system/language/init.json?redisFlag=" + num + "&ran=" + Math.random(),
        dataType: "json",
        success: function (data) {
            var state = data.serviceResult.success;
            if (state) {
                var popped = data.serviceResult.result+'';
                //cookie.set("redisFlag", popped, 10);
                if(text == '加入联信' && num == '1'){
                    window.location.href = webRoot + '/system/desktop/init';
                }
                setTimeout(function(){
                    location.reload();
                },500);
            }
        }
    });
}
$(function() {
    //默认高亮当前页
    var url = document.location.href;
    url = url.split('/');
    var html = url[url.length - 2];
    let $nav = $('.lx-nav-link>.lx-nav-link-btn');
    let nowNav = 0;
    $nav.removeClass('active');
    if(html.indexOf('desktop') > -1){
        $nav.eq(0).addClass('active');
        nowNav=0;
    }
    else if(html.indexOf('company') > -1){
        $nav.eq(1).addClass('active');
        nowNav=1;
    }
    else if(html.indexOf('produce') > -1){
        $nav.eq(2).addClass('active');
        nowNav=2;
    }
    else if(html.indexOf('social') > -1){
        $nav.eq(3).addClass('active');
        nowNav=3;
    }
    else if(html.indexOf('recruit') > -1){
        $nav.eq(4).addClass('active');
        nowNav=4;
    }
    else if(html.indexOf('contactUs') > -1){
        $nav.eq(5).addClass('active');
        nowNav=5;
    }
    let $navLink = $('.lx-nav-link .lx-nav-link-btn');
    $navLink.on('click', function () {
        let href = $(this).attr('value');
        if(href) window.location.href=href;
    });
    $nav.hover(function () {
        $nav.removeClass('active');
    },function () {
        $nav.eq(nowNav).addClass('active')
    });

    // 切换语言
    $('.language-item').one('click', function () {
        var actText = '';
        var act = $('.header .lx-nav-link').children('.lx-nav-link-btn');
        for(var i = 0; i < act.length; i++){
            if($(act[i]).hasClass('active')){
                actText = $(act[i]).find('span').text();
            }
        }
        ajax($(this).attr("id").replace(/[^0-9]/ig,""), actText);
    });
});