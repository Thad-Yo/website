<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var
    /* 事件 */
            Events = {
                cancelAction:function () {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                },
                saveAction: function () {
                      if (Page.validform.check() && !($(".Validform_wrong").length > 0)) {
                          Common.confirm("保存", "确认要保存这条信息吗？", function (isConfirm) {
                              if (isConfirm) {
                                  var id = $("#id").val();
                                  var action = "insertAction.json";
                                  if(id !=null && id !=""){
                                      action = "updateAction.json";
                                  }
                                  $.post(action, $("#mainForm").serializeArray(), function (ret) {
                                      if (ret.success) {
                                          Common.alert("保存成功", function () {
                                              parent.Events.searchAction();
                                              var index = parent.layer.getFrameIndex(window.name);
                                              parent.layer.close(index);
                                          });
                                      } else {
                                          var msg = (ret.message) || "保存失败";
                                          Common.error(msg);
                                          Page.validform.check();
                                      }
                                  }).error(function (e) {
                                      Common.error("保存失败");
                                  });
                              }
                          });
                      }
                    

                },summaryCheck:function(){
                	var cnEnFlag = $("#cnEnFlag").val();
                	if(!cnEnFlag){
                		cnEnFlag = "0";
                	}
                	if($("#summary").val() != ""){
                		if(cnEnFlag == "0"){
                			if($("#summary").val().length > 120){
                    			$("#summaryCheck").text("最多输入120位字符").val('validError');	
                    			$("#summaryCheck").removeClass("Validform_right");
                    			$("#summaryCheck").addClass("Validform_wrong");
                    		}else{
                    			$("#summaryCheck").removeClass("Validform_wrong");
                    			$("#summaryCheck").addClass("Validform_right");
                    			$("#summaryCheck").text('输入字数正确').val('');
                    		}
                		}else{
                			if($("#summary").val().length > 550){
                    			$("#summaryCheck").text("最多输550位字符").val('validError');	
                    			$("#summaryCheck").removeClass("Validform_right");
                    			$("#summaryCheck").addClass("Validform_wrong");
                    		}else{
                    			$("#summaryCheck").removeClass("Validform_wrong");
                    			$("#summaryCheck").addClass("Validform_right");
                    			$("#summaryCheck").text('输入字数正确').val('');
                    		}
                		}
                		
                	}
                	
                },contentCheck:function(){
                	var cnEnFlag = $("#cnEnFlag").val();
                	if(!cnEnFlag){
                		cnEnFlag = "0";
                	}
                	if($("#content").val() != ""){
                		if(cnEnFlag == "0"){
                			if($("#content").val().length > 120){
                    			$("#contentCheck").text("最多输入120位字符").val('validError');	
                    			$("#contentCheck").removeClass("Validform_right");
                    			$("#contentCheck").addClass("Validform_wrong");
                    		}else{
                    			$("#contentCheck").removeClass("Validform_wrong");
                    			$("#contentCheck").addClass("Validform_right");
                    			$("#contentCheck").text('输入字数正确').val('');
                    		}
                		}else{
                			if($("#content").val().length > 550){
                    			$("#contentCheck").text("最多输入550位字符").val('validError');	
                    			$("#contentCheck").removeClass("Validform_right");
                    			$("#contentCheck").addClass("Validform_wrong");
                    		}else{
                    			$("#contentCheck").removeClass("Validform_wrong");
                    			$("#contentCheck").addClass("Validform_right");
                    			$("#contentCheck").text('输入字数正确').val('');
                    		}
                		}
                		
                	}
                	
                }
            },
    /* 画面对象 */
            Page = {
                validform: {},
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

                    $(".fn-Save").click(Events.saveAction);
                    $(".fn-Cancel").click(Events.cancelAction);
                    $("#summary").blur(Events.summaryCheck);
                    $("#content").blur(Events.contentCheck);
                },

                // 画面初始化fileList
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
</script>