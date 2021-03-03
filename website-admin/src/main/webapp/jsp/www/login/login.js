$(document).ready(function () {
    $(".btn-Login").click(function (event) {
        if($("#username").val() == "") {
            layer.tips("请输入用户名", '#username', {tips: [4, '#78BA32']});
            return false;
        }
        if($("#password").val() == "") {
            layer.tips("请输入密码", '#password', {tips: [4, '#78BA32']});
            return false;
        }
        if($("#randomcode").val() == "") {
            layer.tips("请输入验证码", '#randomcode', {tips: [4, '#78BA32']});
            return false;
        }
        if (event) {
            $("#mainForm").submit();
        }
    });

    $("#randomcode").change(function () {
        var code = $(this).val();
        if (code != '' && code.length == 4) {
            $.get(webRoot + '/www/login/registCheckRandomcode.json', {'randomcode': $(this).val()}, function (result) {
                if (result && result.success == '0') {
                } else {
                    layer.tips(result.msg, '#randomcode', {tips: [4, '#78BA32']});
                }
            });
        }
    });
});