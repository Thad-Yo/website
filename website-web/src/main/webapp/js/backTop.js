//返回顶部
$(function () {
    $(document).on('scroll', function () {
        var top = document.documentElement.scrollTop || document.body.scrollTop;
        if (top > 1000) {
            $('.backTop').show();
        } else {
            $('.backTop').hide();
        }
        if (top > 0) {
            $('#main-one .arrowDown').hide();
        } else {
            $('#main-one .arrowDown').show();
        }
    });
    $('.backTop').on('click', function () {
        scrollTop();
    });
});