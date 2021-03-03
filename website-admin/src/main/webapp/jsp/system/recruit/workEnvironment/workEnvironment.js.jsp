<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
var ActionEvents = {
       
    },
	Events = {
        // 查询数据
        searchAction: function () {
        	  //初始化table上面的工具组
            Page.Table.bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 20});
        },
        //得到查询的参数
        tableParams: function (params) {
        	/*  params.issue = $("#issue").val();
             Page.sort = params.sort;
             Page.order = params.order;
             return params; */
        },
        getHeight: function () {
            return $(window).height() - ($(".search-panel").outerHeight() || 60) - 45;
        },
        imgDeleteMore: function () {
            var $thisCheckbox = $(".checkList input:checked");
            var $next = $thisCheckbox.parent().parent().parent().parent().next();
            var $this = $thisCheckbox.parent().parent().parent().parent();
            if (0 == $thisCheckbox.length) {
                alert("请选择复选框！");
                return false;
            }
            var id = "";
            $thisCheckbox.each(function () {
                id = id + $(this).attr("tid") + ',';
            });
            id = id.substring(0,id.length-1);
            Common.confirm("您确定要删除图片么", "删除后将无法恢复，请谨慎操作！",function (isConfirm) {
          		    if (isConfirm) {
               			$.post("imgDelete.json",{"id": id},function (ret) {
               				console.log(JSON.stringify(ret));
               				if (ret.success) {
               					Common.alert("删除成功!",function(v){
               						if(v){
		                                window.location.reload();//刷新当前页面.
		                                window.opener.location.reload(); 
               						}
               					});
                             } else {
                            	Common.error("删除失败!");
                             }
               			});
          		    } else {
          				Common.error("您取消了操作！");
          		    }
           	});
        },
        imgAllSelect:function(){
        	var $thisCheckboxAll = $(".checkList input");
       		$thisCheckboxAll.each(function(){
       			$(this).prop("checked",true);
       		});
        }
	},
    Page = {
			uploader: {},
            // 事件初期化
            initEvents: function () {
            	
            },

            // 画面初始化
            initialize: function () {
            	var ratio = window.devicePixelRatio || 1;
            	var thumbnailWidth = 240 * ratio;
                var thumbnailHeight = 151 * ratio;
            	uploader = WebUploader.create({
                    swf: webRoot + '/js/plugins/webuploader/Uploader.swf',
                    // 文件接收服务端。
                    server: webRoot + '/system/recruit/workEnvironment/importAction.json',
                    // 设置为 true 后，不需要手动调用上传，有文件选择即开始上传。
                    auto: true,
                    // 选择文件的按钮。可选。
                    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                    pick: {
                        id: '.fn-upload',
                        // 按钮的名称
//                             innerHTML: '&nbsp;上传截图',
                        //只能选择一个文件上传 */
                        /* multiple: false */
                    },
                    thumb: {
                        // 不允许裁剪
                        crop: false,

                    },
                    // 图片上传前不进行压缩
                    compress: false,
                    // 与multiple并用，设置只能选择一个文件
                    // fileNumLimit: 2, 取消只能设置一张图片
                    // 不压缩image, 默认如果是jpeg，文件上传前会压缩再上传！
                    resize: false,
                    // 去重
                    duplicate: true,
                    // 只允许图片文件。
                    fileSingleSizeLimit: 20 * 1024 * 1024,//限制大小3M，单文件
                    accept: {
                        title: 'Images',
                        extensions: 'jpg,png,bmp,jpeg,psd,tif',
                        mimeTypes: 'image/*'
                    },
                    // 只允许图片文件。
                    fileSingleSizeLimit: 1 * 1024 * 1024,//限制大小1M，单文件
                });
            	uploader.on("error", function (type) {
                    if (type == "F_EXCEED_SIZE") {
                        Common.error("上传文件不能超过1M");
                    }
                });
                // 当有文件添加进来的时候
                uploader.on('fileQueued', function (file) {
                    $li = $('<div id="' + file.id + '" style="width: 100px;height: 50px;margin-left: 40px;" class=" file-item thumbnails"><div class = "imgContainer">'
                        + '<img>'
                        + '<input type= "checkbox" name = "checkboxName" style="position: absolute;top:5px;left:15px;z-index:3;"/></div></div>'
                    ),
                        $img = $li.find('img');
                    // $list为容器jQuery实例
                    $('#fileList' + window.id).empty();
                    $('#fileList' + window.id).append($li);
                    // 创建缩略图
                    // 如果为非图片文件，可以不用调用此方法。
                    // thumbnailWidth x thumbnailHeight 为 100 x 100
                    uploader.makeThumb(file, function (error, src) {
                        if (error) {
                            $img.replaceWith('<span>不能预览</span>');
                            return;
                        }
                        $img.attr('src', src);
                        $img.click(function () {
                            var _this = $(this);//将当前的pimg元素作为_this传入函数
                            Events.imgShow(".outerdiv", ".innerdiv", ".bigimg", _this);
                        })
                    }, thumbnailWidth, thumbnailHeight);
                });

                uploader.on('uploadBeforeSend', function (block, data) {
                    // file为分块对应的file对象。
                    var file = block.file;
                });
                // 上传开始
                uploader.on('uploadStart', function (file) {
                    $("#progressBar").css('width', '0%').parent().addClass("active");
                    $("#progressBar").find("span").text('0% Complete (success)');
                });
                // 上传进度
                uploader.on('uploadProgress', function (file, percentage) {
                    $("#progressBar").css('width', percentage * 100 + '%').parent().removeClass("active");
                    $("#progressBar").find("span").text(percentage * 100 + '% Complete (success)');
                });
                //上传成功
                uploader.on('uploadSuccess', function (file, ret) {
                    if (!ret.success && ret.error) {
                        var html = [];
                        html.push('<div class="alert alert-danger">');
                        html.push('上传图片时发生错误，请重新上传！');
                        html.push('</div>');
                        $("#errorDiv").html(html.join("")).show();
                    } else {
                        $("#errorDiv").html("").hide();
                        Common.alert("上传完成", function(v){
                        	if(v){
                        		 window.location.reload();//刷新当前页面.
	                             window.opener.location.reload(); 
                        	}
                        });
                    }
                });
            },
            
            init: function () {
                Page.initEvents();
                Page.initialize();
                $("#imgDeleteMore").click(function () {
                	Events.imgDeleteMore();
                });
                $("#imgAllSelect").click(function () {
                	Events.imgAllSelect();
                });
            }
        };
	jQuery(document).ready(function () {
	    Page.init();
	}); 
	document.onkeydown = function(event) {
		if(event.keyCode == 13){ //$("#searchForm").hasClass("active") && 
			// 执行的方法
			event.preventDefault();
			$("#searchForm").attr("target", "");
			//Events.searchAction();
	
		}
	}
</script>