<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
//--------------------------------------------------------------------------------------------------------------------------------
var
/* 事件 */
    Events = {
		//JSON化评分选项
		getConfigVisitJson:function(){
			var arr = [];
			var titleSize=0;
			var tableSize= $(".titleModel").length;
				$(".titleModel").each(function(j){
				    //console.log('==='+j+$(this).find(".yearpicker").val());
                        var year= $(this).find(".yearClass").val();
                        var fgsCount= $(this).find(".fgsCountClass").val()
                        var khCount= $(this).find(".khCountClass").val()
                        var ryCount= $(this).find(".ryCountClass").val()
                        arr.push({
                            "year": year,
                            "fgsCount": fgsCount,
                            "khCount": khCount,
                            "ryCount": ryCount
                        });
				});
			$("#titleSize").val(titleSize);
		 return arr;
       },
        saveAction: function (flag) {
            if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                Common.confirm("保存", "确认要保存企业介绍吗？", function (isConfirm) {
                	if (isConfirm) {
                        $.post("saveAction.json",$("#mainForm").serializeArray(), function (ret) {
                            if (ret.success) {
                                Common.alert("保存成功", function () {
                                    /* parent.Events.searchAction(); */
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.layer.close(index);
                                });
                            } else {
                                var msg = (ret.result && ret.result.msg) || "保存失败";
                                Common.error(msg);
                                Page.validform.check();
                            }
                        }).error(function (e) {
                            Common.error("保存失败");
                        });
                    }
                });
            }
        },
        saveScoAction: function (flag) {
        	
             if (Page.validform.check() && !($(".Validform_error").length > 0)) {
                Common.confirm("保存", "确认要保存发展规模吗？", function (isConfirm) {
                	if (isConfirm) {
                		$("#configVisitJson").val(JSON.stringify(Events.getConfigVisitJson()));
                		//alert(JSON.stringify($("#configVisitJson").serializeArray()));
                        $.post("saveScoAction.json",$("#mainFormSco").serializeArray(), function (ret) {
                            if (ret.success) {
                                Common.alert("保存成功", function () {
                                    // parent.Events.searchAction();
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.layer.close(index);
                                });
                            } else {
                                var msg = (ret.result && ret.result.msg) || "保存失败";
                                Common.error(msg);
                                Page.validform.check();
                            }
                        }).error(function (e) {
                            Common.error("保存失败");
                        });
                    }
                });
            } 
        },
        removeButtonAction : function(obj){
        	var cloneHtml = '';
			var number = $(".titleModel").length;
			//alert(number);
			if(number<6){
				Common.alert("发展规模至少有5条！");
			}else{
				$(obj.parentNode.parentNode).remove();
			}	
        },
        addButtonAction : function(obj){
			var cloneHtml = '';
			var number = $(".titleModel").length + 1;
			if(number < 9){
				cloneHtml = $(".cloneModel").clone(true);
				$(obj.parentNode.parentNode).after(cloneHtml);
				$(".markmodeloption .cloneModel").show();  
				$(".markmodeloption .cloneModel").addClass("titleModel");
				$(".markmodeloption .cloneModel").removeClass("cloneModel"); 
	            Page.initEvents();
				//alert(number)
			}
			else{
				Common.alert("发展规模最多为8条！");
			}
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
        	/* $('.yearpicker').datepicker({
    			startView: 'decade',
    			 minView: 'decade',
    			 format: 'yyyy',
    			 maxViewMode: 2,
    			 minViewMode:2,
    			  autoclose: true
    			}); */
    			$('#mainFormSco .yearpicker').each(function(){
    				laydate.render({
        				elem: this,
        				type: 'year',
        				done: function(value){
        					var that = $(this)[0].elem[0];
	       				    $.ajax({
	       				    	type:'post',
	       				    	url:'ajaxCheckAction',
	       				    	 data:{"year":value} ,
	       				    	 success:function(result){
	       				    		 if(result!=0){
	       				    			 Common.alert("年份重复，请重新输入");
	       				    			 that.value = '';
	       				    		 }
	       				    		
	       				    	 }
	       				    })
	       				}
        			});
    			});
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
    //数据范围更改时触发事件
    jQuery("#dataScope").change(function(){
    	if(jQuery(this).val()=="7"){
    		jQuery("#departmentTree").parent(".col-sm-3").show();
    	}else{
    		jQuery("#departmentTree").parent(".col-sm-3").hide();
    	}
    })
   /*  $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    }); */
});

// --------------------------------------------------------------------------------------------------------------------------------
</script>
