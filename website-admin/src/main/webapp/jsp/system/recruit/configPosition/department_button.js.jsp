<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script>
    var layerIndex,
    /* 事件 */
            Events = {addRowAction: function (row) {
                row = Page.RowTemplts.clone();
                row.appendTo("#permissionTable");
            },
            deleteRowAction: function (row) {
                $(this).closest("tr").remove();
            },
            submitAction: function () {
            	var appen = "";
            	var positionName= '';
            	var positionIds = '';
            	//var selected = $("#sel_menu2").val();//éæ©çå¼  
            	var i = 0;
            	$(".fn-check:checked").each(function(){
            	    var departments = $(this).val().split("-;-");
            	    /*appen += "<input type='hidden' name='departmentPositionList["+i+"].positionId' value='"+departments[0]+"' />" +
        			"<input type='hidden' name='departmentPositionList["+i+"].positionTypeId' value='"+departments[1]+"' />" +
        			"<input type='hidden' name='departmentPositionList["+i+"].positionName' value='"+departments[2]+"' />" +
        			"<input type='hidden' name='departmentPositionList["+i+"].positionCode' value='"+departments[3]+"' />";*/
                    positionName=positionName+departments[2]+',';
                    positionIds=positionIds+';'+departments[0];
            	});
            	
                parent.Events.setForPermission(positionIds,positionName);
                var index = parent.layer.getFrameIndex(window.name); //åå¾å°å½åiframeå±çç´¢å¼
                parent.layer.close(index); //åæ§è¡å³é­
            },
            checkedClick : function(obj){
            	var name = $(obj).val();
            	if($(obj).is(':checked')){      
            		$("input[name='"+name+"']").prop("checked",true);
            	}else{
            		$("input[name='"+name+"']").prop("checked",false);
            	}
            },
            fncheck : function(boj){
            	//点击岗位，岗位类别需要被选中
            	var check = 0;
            	$(boj).parent().parent().find(".fn-check").each(function(){
            		if($(this).is(":checked")){
            			check++;
            		}
            	});
            	var cla= $(boj).attr("name");
            	if(check > 0){
            		$("#" + cla).prop("checked",true);
            	}else{
            		$("#" + cla).prop("checked",false);
            	}
            }
            },
            ActionEvents = {},
    /* 画面对象 */
            Page = {
    		 RowTemplts: $("#rowTemplts tr:eq(0)"),


    	        // åå§åValidator
    	        initValidator: function () {

    	        },

    	        // 
    	        initEvents: function () {
    	            // 
    	            $(".dep-submit").click(Events.submitAction);
    	            // 
    	            $("#permissionTable").on("click", ".fn-addRow", Events.addRowAction)
    	                .on("click", ".fn-removeRow", Events.deleteRowAction);
    	            
    	           // $(".checkId").click(Events.checkedClick);
    	            //$(".fn-check").click();
    	          
    	            
    	            
    	        },

    	        // 
    	        initialize: function () {
    	        	$(".fn-check").each(function(){
    	        		if($(this).is(":checked")){
    	        			$("#" + $(this).attr("name")).prop("checked",true);
    	        		}
    	        	});
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