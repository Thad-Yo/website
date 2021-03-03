	var ActionsHeader = {},
		/* 事件动作处理 */
		EventsHeader = {
			resizeAct: function(event) {},
			menuFunction: function() {
				var gun = document.documentElement.scrollTop || document.body.scrollTop;
				var redisFlag = cookie.get("redisFlag");
				if(redisFlag == undefined){
					redisFlag = 0;
				}	
				if(gun > 0) {
					if(redisFlag == '0'){//中文
						$(".imgBoxlogo img").attr("src",webRoot+"/img/logo2.png");
					}
					else if(redisFlag == '1'){//英文
						$(".imgBoxlogo img").attr("src",webRoot+"/img/logo2-EN.png");
					}
					$(".header").css("background", "#ffffff");
					$(".header .nav li .second-nav li").css("background", "#ffffff");
					$(".header .nav li a").css("color", "#333");	
					if(gun > 600) {
						$(".topImg").show();
					} else {
						$(".topImg").hide();
					}
				} else {
					if(redisFlag == '0'){//中文
						$(".imgBoxlogo img").attr("src",webRoot+"/img/logo1.png");
					}
					else if(redisFlag == '1'){//英文
						$(".imgBoxlogo img").attr("src",webRoot+"/img/logo1-EN.png");
					}
					$(".header").css("background", "rgba(0,0,0,0.15)");
					$(".header .nav li .second-nav li").css("background", "rgba(0,0,0,0.15)");
					$(".header .nav li a").css("color", "#fff");
				}
			},
		};
	var PageHeader = {
		initEventsHeader: function() {
			$(document).scroll(EventsHeader.menuFunction);
		}
	};
	hover();
	function hover(){
		var _this1 = null;
		$('.nav>li').hover(function() {
			_this1 = $(this);
			_this1.addClass('active1').siblings().removeClass('active1');	
			_this1.find('.second-nav').show();
			var _this2 = null;
			_this1.find('.second-nav').find('li').hover(function() {
				_this2 = $(this);
				_this2.addClass('active1').siblings().removeClass('active1');
				_this2.find('.third-nav').show();
				_this2.find('.third-nav').hover(function() {
					$(this).show();
				}, function() {
					$('.nav>li').find('.second-nav li .third-nav li').removeClass('active1');
					$(this).hide();
				});
			}, function() {
				$('.nav>li').find('.second-nav li').removeClass('active1');
				_this2.find('.third-nav').hide();
			});
		}, function() {
			_this1 = $(this);
			$('.nav>li').removeClass('active1');
			_this1.find('.second-nav').hide();
		});
	}
	$(function() {
		PageHeader.initEventsHeader();
		$('.menu li').hover(function() {
			$(this).children('ul').show();
			//$(this).focus().addClass('focusa')
		}, function() {
			$(this).children('ul').hide();
			//$(this).focus().removeClass('focusa')
		});

		DD_belatedPNG.fix('ul,.more');
		
	});

	var cookie = {
    set:function(key,val,time){//设置cookie方法
        var date=new Date(); //获取当前时间
        var expiresDays=time;  //将date设置为n天以后的时间
        date.setTime(date.getTime()+expiresDays*24*3600*1000); //格式化为cookie识别的时间
        document.cookie=key + "=" + val +"; expires="+date.toGMTString()+"; path=/";  //设置cookie
    },
    get:function(key){//获取cookie方法
        /*获取cookie参数*/
        var getCookie = document.cookie.replace(/[ ]/g,"");  //获取cookie，并且将获得的cookie格式化，去掉空格字符
        var arrCookie = getCookie.split(";")  //将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
        var tips;  //声明变量tips
        for(var i=0;i<arrCookie.length;i++){   //使用for循环查找cookie中的tips变量
            var arr=arrCookie[i].split("=");   //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            if(key==arr[0]){  //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                tips=arr[1];   //将cookie的值赋给变量tips
                break;   //终止for循环遍历
            }
        }
        return tips;
      },
      del:function(key){ //删除cookie方法
         var date = new Date(); //获取当前时间
         date.setTime(date.getTime()-10000); //将date设置为过去的时间
         document.cookie = key + "=v; expires =" +date.toGMTString();//设置cookie
        }
    }

	var redisFlag = cookie.get("redisFlag");
	if(redisFlag == undefined){
		$('.textCN').show();
		$('.textEN').hide();
	}
	else{	
		if(redisFlag == '0'){//中文
			$('.textCN').show();
			$('.textEN').hide();
		}
		else if(redisFlag == '1'){//英文
			$('.textCN').hide();
			$('.textEN').show();
		};
	}

		
	