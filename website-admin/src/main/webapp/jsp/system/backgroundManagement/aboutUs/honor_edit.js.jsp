<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
//--------------------------------------------------------------------------------------------------------------------------------
var
/* 事件 */
    Events = {
        saveAction: function () {
        	if($("#imgAddress").val()!=""){
                $("#imgAddress").removeClass("Validform_error");
				$("#imgAddressVol").removeClass("Validform_wrong");
    			$("#imgAddressVol").addClass("Validform_right");
    			$("#imgAddressVol").text("上传图片成功");
    		}else{
                $("#imgAddress").addClass("Validform_error");
				$("#imgAddressVol").addClass("Validform_wrong");
    			$("#imgAddressVol").removeClass("Validform_right");
    			$("#imgAddressVol").text("上传图片失败");
    		}
        	 if($("#honorNumber").val()=="" ){
        		 Common.error("请输入荣誉归属年份！");
        		 return;
        	 }
            if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                Common.confirm("保存", "确认要保存发展历程吗？", function (isConfirm) {
                    if (isConfirm) {
                    	var formData = [];
                    	formData.push({
                            "name": "honorNumber",
                            "value": $("#honorNumber").val()
                        });
                    	formData.push({
                            "name": "id",
                            "value": $("#id").val()
                        });
                    	formData.push({
                            "name": "honorName",
                            "value": $("#honorName").val()
                        });
                    	formData.push({
                            "name": "isEng",
                            "value": $("#isEng").val()
                        });
                    	/* formData.push({
                            "name": "honorState",
                            "value": $("#honorState").val()
                        }); */
                    	formData.push({
                            "name": "honorDetails",
                            "value": $("#honorDetails").val()
                        });
                    	formData.push({
                            "name": "imgAddress",
                            "value": $("#imgAddress").val()
                        });
                        $("[name='dropImg']").each(function(){
	                        formData.push({
	                            "name": "dropImg",
	                            "value": $(this).val()
	                        });
                        	
                        });
                        //alert(JSON.stringify(formData));
                        //return;
                        $.post("saveAction.json", formData, function (ret) {
                            if (ret.success) {
                                Common.alert("保存成功", function () {
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.Events.searchAction();
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
        upLoadImage: function($upLoadId,$image,$imgAdress){
        	 // 初始化上传控件
            var uploaderImage = WebUploader.create({
                swf: webRoot + '/js/plugins/webuploader/Uploader.swf',// 文件接收服务端
                server: webRoot + '/system/backgroundManageMent/aboutUsController/uploadImageAction',
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
                    title: 'Images',
                    extensions: 'jpg,jpeg,bmp,png',
                    mimeTypes: 'image/*'
                },
             // 只允许图片文件。
                fileSingleSizeLimit: 1 * 1024 * 1024,//限制大小1M，单文件
            });
            uploaderImage.on("error", function (type) {
                if (type == "F_EXCEED_SIZE") {
                    Common.error("上传文件不能超过1M");
                }
            });
            // 当有文件被添加进队列的时候
            uploaderImage.on('fileQueued', function (file) {
            	if($($imgAdress).val()!=""){
            		$("#hidePlace").append("<input type='hidden' name='dropImg' value='"+$($imgAdress).val()+"'>");
	                $($imgAdress).val("");//清空图片自定义校验
	                $($imgAdress).removeClass("Validform_error");
					$($imgAdress+"Vol").removeClass("Validform_wrong");
	    			$($imgAdress+"Vol").removeClass("Validform_right");
	    			$($imgAdress+"Vol").text("请选择上传图片");
            	}
                var $img = $($image);
                // 创建缩略图
                // 如果为非图片文件，可以不用调用此方法。
                uploaderImage.makeThumb(file, function (error, src) {
                    if (error) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }
                    $img.attr('src', src);
                }, 200, 100); // thumbnailWidth x thumbnailHeight 为 200 x 100
            });

            // 文件上传前
            uploaderImage.on('uploadBeforeSend', function (block, data, headers) {
                if (WebUploader.browser.ie) {
                    headers['Access-Control-Allow-Origin'] = '*';
                    headers['Access-Control-Request-Headers'] = 'content-type';
                    headers['Access-Control-Request-Method'] = 'POST';
                }
                var file = block.file; // file为分块对应的file对象。
                // 修改data可以控制发送哪些携带数据。
                //data.fileBasicId = $("#IdHidden").val();
                //data.fileBasicUserId = $("#useIdHidden").val();
            });
       /*   // 文件上传过程中创建进度条实时显示。    
            uploaderImage.on( 'uploadProgress', function( file, percentage ) {    
                var $li = $( '#'+file.id ),    
                    $percent = $li.find('.progress span');    
                
                // 避免重复创建    
                if ( !$percent.length ) {    
                    $percent = $('<p class="progress"><span></span></p>')    
                            .appendTo( $li )    
                            .find('span');    
                }    
                $percent.css( 'width', percentage * 100 + '%' );    
            });  */
            
            //上传成功
            uploaderImage.on('uploadSuccess', function (file, json) {
                if (json.success) {
                	
                	$($imgAdress).val(json.result);
                    layer.msg("上传成功");
                    if($($imgAdress).val()!=""){
	                    $($imgAdress).removeClass("Validform_error");
	    				$($imgAdress+"Vol").removeClass("Validform_wrong");
	        			$($imgAdress+"Vol").addClass("Validform_right");
	        			$($imgAdress+"Vol").text("上传图片成功");
            		}else{
	                    $($imgAdress).addClass("Validform_error");
	    				$($imgAdress+"Vol").addClass("Validform_wrong");
	        			$($imgAdress+"Vol").removeClass("Validform_right");
	        			$($imgAdress+"Vol").text("上传图片失败");
            		}
                } else {
                    layer.msg("上传失败");
                    $($imgAdress).addClass("Validform_error");
    				$($imgAdress+"Vol").addClass("Validform_wrong");
        			$($imgAdress+"Vol").removeClass("Validform_right");
        			$($imgAdress+"Vol").text("上传图片失败");
                }
            });

            //  当文件上传出错时触发。
            uploaderImage.on("uploadError", function (type) {
                layer.msg("上传失败");
            });
            // 不管成功或者失败，文件上传完成时触发。
            uploaderImage.on("uploadComplete", function () {
                uploaderImage.reset();
            }); 

        },
        
        // 取消按键单击事件绑定
        returnAction: function () {
            parent.layer.closeAll();
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
        },
        

        // 事件初期化
        initEvents: function () {
        	
        	laydate.render({
				elem:'#honorNumber'
			})
        	
        	$("select[name=imageLink]").change(Events.linksChange);
            $('.yearpicker').datepicker({
    			startView: 'decade',
    			 minView: 'decade',
    			 format: 'yyyy',
    			 maxViewMode: 2,
    			 minViewMode:2,
    			  autoclose: true
    			});
        	Events.upLoadImage("#uploadimgAddress","#img","#imgAddress");
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

$(document).ready(function () {
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
