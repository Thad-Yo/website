<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    //--------------------------------------------------------------------------------------------------------------------------------
    var
        /* 事件 */
        Events = {
            saveBasicAction: function (flag) {
                if($("#xxx0").is(":checked")||$("#xxx1").is(":checked")||$("#xxx2").is(":checked")){
                    if($("#xxx2").is(":checked")){
                        var aaa = $('#videoEnglishAdress').val()
                        var bbb = $('#videoChineseAdress').val()
                        if(aaa==null || aaa==''){
                            Common.alert("请上传英文视频！");
                            return;
                        }
                        if(bbb==null || bbb==''){
                            Common.alert("请上传中文视频！");
                            return;
                        }

                    }
                    if($("#xxx1").is(":checked")){
                        var aaa = $('#videoShareAdress').val()
                        if(aaa==null || aaa==''){
                            Common.alert("请上传共享视频！");
                            return;
                        }

                    }
                    if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                        Common.confirm("保存", "确认要保存banner信息吗？", function (isConfirm) {
                            if (isConfirm) {
                                var formData = [];
                                formData.push({
                                    "name": "videoEnglishAdress",
                                    "value": $("#videoEnglishAdress").val()
                                });
                                formData.push({
                                    "name": "videoChineseAdress",
                                    "value": $("#videoChineseAdress").val()
                                });
                                formData.push({
                                    "name": "videoShareAdress",
                                    "value": $("#videoShareAdress").val()
                                });
                                formData.push({
                                    "name": "fgsCount",
                                    "value": $("#fgsCount").val()
                                });
                                formData.push({
                                    "name": "ryCount",
                                    "value": $("#ryCount").val()
                                });
                                formData.push({
                                    "name": "time",
                                    "value": $("#time").val()
                                });
                                formData.push({
                                    "name": "khCount",
                                    "value": $("#khCount").val()
                                });
                                formData.push({
                                    "name": "checked",
                                    "value": $("#checked").val()
                                });
                                $("[name='dropImg']").each(function(){
                                    formData.push({
                                        "name": "dropImg",
                                        "value": $(this).val()
                                    });

                                });
                                //alert(JSON.stringify(formData));
                                //return;
                                $.post("saveBasicAction.json", formData, function (ret) {
                                    if (ret.success) {
                                        Common.alert("保存成功", function () {
                                            var index = parent.layer.getFrameIndex(window.name);
                                            //parent.Events.saveBasicAction();
                                            parent.layer.close(index);
                                        });
                                    } else {
                                        var msg = ret.message || "保存失败";
                                        Common.error(msg);
                                        Page.validform.check();
                                    }
                                }).error(function () {
                                    Common.error("保存失败");
                                });
                            }
                        });
                    }
                }else{
                    Common.alert("请选择是否有视频！");
                    return;
                }
            },
            linksChange:function(){
                var $li = $("select[name=imageLink]").val();
                Page.validform.eq(1).resetForm();
                if($li == 0){
                    $("#linkShare_show,#linkChinese_show,#linkEnglish_show").hide();
                    $("#linkShare_show,#linkChinese_show,#linkEnglish_show").find("input").attr("dataType","*");
                } else if($li == 1){
                    $("#linkShare_show").show();
                    $("#linkChinese_show,#linkEnglish_show").hide();
                    $("#linkShare_show").find("input").attr("dataType","*");
                    $("#linkChinese_show,#linkEnglish_show").find("input").removeAttr("dataType");
                } else if($li == 2){
                    $("#linkShare_show").hide();
                    $("#linkChinese_show,#linkEnglish_show").show();
                    $("#linkShare_show").find("input").removeAttr("dataType");
                    $("#linkChinese_show,#linkEnglish_show").find("input").attr("dataType","*");
                }
            },
            upLoadVideo: function($upLoadId,$videoAdress){
                // 初始化上传控件
                var upLoaderVideo = WebUploader.create({
                    swf: webRoot + '/js/plugins/webuploader/Uploader.swf',// 文件接收服务端
                    server: webRoot + '/system/backgroundManageMent/homePageController/uploadVideoAction',
                    auto: true, // 设置为 true 后，不需要手动调用上传，有文件选择即开始上传
                    // 选择文件的按钮。可选
                    pick: {// 内部根据当前运行是创建，可能是input元素，也可能是flash
                        id: $upLoadId,
                        multiple: false //只能选择一个文件上传
                    },
                    resize: false, // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传
                    duplicate: true, // 去重
                    timeout: 0, // 超时
                    accept: {// 接受哪些类型的文件
                        title: 'Video',
                        extensions: 'mp4,WMV,MKV,MOV',
                        mimeTypes: 'video/*'
                    }
                });

                // 当有文件被添加进队列的时候
                upLoaderVideo.on('fileQueued', function (file) {
                    var $li = $( $upLoadId+'Progress' ),
                        $percent = $li.find('span');
                    $li.css( 'width', '0%' );
                    $percent.html('0%');
                });

                // 文件上传前
                upLoaderVideo.on('uploadBeforeSend', function (block, data, headers) {
                    if (WebUploader.browser.ie) {
                        headers['Access-Control-Allow-Origin'] = '*';
                        headers['Access-Control-Request-Headers'] = 'content-type';
                        headers['Access-Control-Request-Method'] = 'POST';
                    }
                    var file = block.file; // file为分块对应的file对象。
                });
                // 文件上传过程中创建进度条实时显示。
                upLoaderVideo.on( 'uploadProgress', function( file, percentage ) {
                    var $li = $( $upLoadId+'Progress' ),
                        $percent = $li.find('span');
                    $li.css( 'width', percentage * 100 + '%' );
                    $percent.html((percentage * 100+"").substr(0,5)+ '%');
                    $($videoAdress).val("");//清空图片自定义校验
                    $($videoAdress).removeClass("Validform_error");
                    $($videoAdress+"Vol").removeClass("Validform_wrong");
                    $($videoAdress+"Vol").removeClass("Validform_right");
                    $($videoAdress+"Vol").text("请选择上传视频");
                });

                //上传成功
                upLoaderVideo.on('uploadSuccess', function (file, json) {
                    if (json.success) {

                        $($videoAdress).val(json.result);
                        layer.msg("上传成功");
                        if($($videoAdress).val()!=""){
                            $($videoAdress).removeClass("Validform_error");
                            $($videoAdress+"Vol").removeClass("Validform_wrong");
                            $($videoAdress+"Vol").addClass("Validform_right");
                            $($videoAdress+"Vol").text("上传成功");
                        }else{
                            $($videoAdress).addClass("Validform_error");
                            $($videoAdress+"Vol").addClass("Validform_wrong");
                            $($videoAdress+"Vol").removeClass("Validform_right");
                            $($videoAdress+"Vol").text("上传失败");
                        }
                    } else {
                        layer.msg("上传失败");
                        $($videoAdress).addClass("Validform_error");
                        $($videoAdress+"Vol").addClass("Validform_wrong");
                        $($videoAdress+"Vol").removeClass("Validform_right");
                        $($videoAdress+"Vol").text("上传失败");
                    }
                });

                //  当文件上传出错时触发。
                upLoaderVideo.on("uploadError", function (type) {
                    layer.msg("上传失败");
                });
                // 不管成功或者失败，文件上传完成时触发。
                upLoaderVideo.on("uploadComplete", function () {
                    upLoaderVideo.reset();
                });

            },
        },
        /* 画面对象 */
        Page = {
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

                laydate.render({
                    elem:'#time',
                    type: 'datetime'
                })

                var aaa = $('#videoChineseAdress').val();
                if(aaa!=null && aaa!=''){
                    var $li =$('#uploadVideoChineseProgress'),
                        $percent = $li.find('span');
                    $li.css( 'width', '100%' );
                    $percent.html('100%');
                }
                var bbb = $('#videoShareAdress').val();
                if(bbb!=null && bbb!=''){
                    var $li =$('#uploadVideoShareProgress'),
                        $percent = $li.find('span');
                    $li.css( 'width', '100%' );
                    $percent.html('100%');
                }
                var ccc = $('#videoEnglishAdress').val();
                if(ccc!=null && ccc!=''){
                    var $li =$('#uploadVideoEnglishProgress'),
                        $percent = $li.find('span');
                    $li.css( 'width', '100%' );
                    $percent.html('100%');
                }
            },

            // 事件初期化
            initEvents: function () {
                $("select[name=imageLink]").change(Events.linksChange);
                Events.upLoadVideo("#uploadVideoShare","#videoShareAdress");
                Events.upLoadVideo("#uploadVideoChinese","#videoChineseAdress");
                Events.upLoadVideo("#uploadVideoEnglish","#videoEnglishAdress");

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

    function divClick(){

        var show="";
        var apm = document.getElementsByName("videoConfig");
        for(var i=0;i<apm.length;i++){
            if(apm[i].checked)
                show = apm[i].value;
        }
        if($("#xxx0").is(":checked")){
            $("#xxx0").val("1");
            $("#xxx1").val("");
            $("#xxx2").val("");
            $("#gyVideo").hide();
            $("#zwVideo").hide();
            $("#ywVideo").hide();
            //document.getElementById("gyVideo").style.display="none";
            //document.getElementById("zwVideo").style.display="none";
            //document.getElementById("ywVideo").style.display="none";
            $("#videoShareAdress").val("");
            $("#videoChineseAdress").val("");
            $("#videoEnglishAdress").val("");
            $("#checked").val("0");
        }
        if($("#xxx1").is(":checked")){
            $("#xxx0").val("");
            $("#xxx1").val("1");
            $("#xxx2").val("");
            $("#gyVideo").show();
            $("#zwVideo").hide();
            $("#ywVideo").hide();
            //document.getElementById("gyVideo").style.display="block";
            //document.getElementById("zwVideo").style.display="none";
            //document.getElementById("ywVideo").style.display="none";
            Events.upLoadVideo("#uploadVideoShare","#videoShareAdress");
            $("#videoChineseAdress").val("");
            $("#videoEnglishAdress").val("");
            $("#checked").val("1");
        }
        if($("#xxx2").is(":checked")){
            $("#xxx0").val("");
            $("#xxx1").val("");
            $("#xxx2").val("1");
            $("#gyVideo").hide();
            $("#zwVideo").show();
            $("#ywVideo").show();
            //document.getElementById("gyVideo").style.display="none";
            //document.getElementById("zwVideo").style.display="block";
            //document.getElementById("ywVideo").style.display="block";
            Events.upLoadVideo("#uploadVideoChinese","#videoChineseAdress");
            Events.upLoadVideo("#uploadVideoEnglish","#videoEnglishAdress");
            $("#videoShareAdress").val("");
            $("#checked").val("2");
        }
    }

    jQuery(document).ready(function () {
        Page.init();
        //数据范围更改时触发事件
        jQuery("#dataScope").change(function(){
            if(jQuery(this).val()=="7"){
                jQuery("#departmentTree").parent(".col-sm-3").show();
            }else{
                jQuery("#departmentTree").parent(".col-sm-3").hide();
            }
        })
    });
    // --------------------------------------------------------------------------------------------------------------------------------
</script>
