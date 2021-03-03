//let redisFlag = undefined;
//声明cookie
var cookie = {
    set: function (key, val, time) {//设置cookie方法
        var date = new Date(); //获取当前时间
        var expiresDays = time;  //将date设置为n天以后的时间
        date.setTime(date.getTime() + expiresDays * 24 * 3600 * 1000); //格式化为cookie识别的时间
        document.cookie = key + "=" + val + "; expires=" + date.toGMTString() + "; path=/";  //设置cookie
    },
    get: function (key) {//获取cookie方法
        // 获取cookie参数
        var getCookie = document.cookie.replace(/[ ]/g, "");  //获取cookie，并且将获得的cookie格式化，去掉空格字符
        var arrCookie = getCookie.split(";")  //将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
        var tips;  //声明变量tips
        for (var i = 0; i < arrCookie.length; i++) {   //使用for循环查找cookie中的tips变量
            var arr = arrCookie[i].split("=");   //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            if (key == arr[0]) {  //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                tips = arr[1];   //将cookie的值赋给变量tips
                break;   //终止for循环遍历
            }
        }
        return tips;
    },
    del: function (key) { //删除cookie方法
        var date = new Date(); //获取当前时间
        date.setTime(date.getTime() - 10000); //将date设置为过去的时间
        document.cookie = key + "=v; expires =" + date.toGMTString();//设置cookie
    }
};
let isScrolling = false;
let scrollSpeed=10;//越大越慢

// 滚动页面
function scrollBySelector(id) {
    let top = $(id).offset().top;
    scrollTo(top);
}
let timer;
function scrollTo(target) {// 滚动至指定位置
    if(isScrolling) return;
    isScrolling=true;
    let nowHeight = 0,surplus = 0;
    clearInterval(timer);
    timer = setInterval(function () {
        nowHeight = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
        surplus = nowHeight-target;
        if(surplus<0)surplus -= Math.floor(surplus/scrollSpeed);//做减速运动
        else if(surplus<1) surplus = 0;
        else surplus -= Math.ceil(surplus/scrollSpeed);//做减速运动
        window.scroll(0, target+surplus);
        if (surplus === 0) {
            isScrolling=false;
            clearInterval(timer);
        }
    }, 10);
}
document.onmousewheel=function(){
    clearInterval(timer);
};
function scrollTop() {// 滚动到顶部
    scrollTo(0)
}

$(function () {

//标题加线
    let $sectionTitleEN = $('.section-title-EN');
    $sectionTitleEN.each(function () {
        $(this).append("<span class=\"section-title-line\"></span>");
    });

//侧边导航条
    var $navs = $('.nav-ul li'), // 导航
        $sections = $('section'), // 模块
        navLength = $navs.length - 1;
    scrollWay();

    function scrollWay() {
        $(document).scroll(function () {
            var scrollTop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
            var len = navLength;
            for (; len > -1; len--) {
                var that = $sections.eq(len);
                if (that.offset()!==undefined&&that.offset().top!==0&&scrollTop + 100 >= that.offset().top) {
                    $navs.removeClass('active').eq(len).addClass('active');
                    break;
                }
            }
        });
    }
    //锚点
    $navs.on('click', function () {
        let thisId = $(this).attr('value');
        let top = $(thisId).offset().top;
        scrollTo(top-53);
    });

//初始化语言标志
    if (redisFlag === '0') {//中文
        $('.textCN').show();
        $('.textEN').hide();
        $('.tabCN').show();
        $('.tabEN').hide();
    } else if (redisFlag === '1') {//英文
        $('.textCN').hide();
        $('.textEN').show();
        $('.tabCN').hide();
        $('.tabEN').show();
    }
    else {
        $('.textCN').show();
        $('.textEN').hide();
    }
});


//animation.css
function animationHover(element, animation) {
    element = $(element);
    element.hover(
        function () {
            element.addClass('animated ' + animation);
        },
        function () {
            //动画完成之前移除class
            window.setTimeout(function () {
                element.removeClass('animated ' + animation);
            }, 2000);
        });
}
