	var 																									
	//页面的静态变量声名，声名完以逗号结束																									
	/* Action名称 */																									
	Actions = {																									
			//画面表单提交的Action名集合																							
	},																									
	/* 事件动作处理 */																									
	Events = {																									
		// 画面尺寸调整动作事件																								
		resizeAct:function(event) {																								
				//画面的resize事件，画面框架会自动调用本方法，无处理时可不写本方法																						
		},	
		clickBtn:function(){
			alert("11");
		}
	};
	var Page = {
		initEvents:function(){
			$(".box").click(Events.clickBtn);
		}
	};
			
	$(function(){
		Page.initEvents();
	});
	
	
	
	
	/*$.extend(Page, {																									
		// 自动执行画面处理，默认值：true												
		auto: false,																								
		// 画面布局																								
		doLayout:function() {																								
				//画面布局初始化方法，无处理里可不写本方法																						
			
		},																								
		// 初始化画面事件处理																								
		initEvents:function() {																								
				//画面业务逻辑事件初始化方法，无处理里可不写本方法																						
		},																								
		// 画面初始化																								
		initialize:function() {																								
				//画面初始化方法，相关的全局变量声名等，写在这里，无处理里可不写本方法																						
			
			
		},																								
		// 画面初始化完成																								
		ready:function() {																								
				//画面初始化完成时会自动调用的方法，无处理里可不写本方法																						
				
		}																								
	}),																									
																										
	Page.initialize();*/																									
																										


