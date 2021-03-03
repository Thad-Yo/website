var ActionsHeader = {},
/* 事件动作处理 */
EventsHeader = {
	resizeAct: function(event) {},
	menuFunction: function() {
		var gun = document.documentElement.scrollTop || document.body.scrollTop;
		/*redisFlag = cookie.get("redisFlag");
		if(redisFlag == undefined){
			redisFlag = 0;
		}	*/
		if(gun > 0) {
			/*if(redisFlag == '0'){//中文*/				
				$(".imgBoxlogo img").attr("src",webRoot+"/images/index/logo2.png");
			/*}
			else if(redisFlag == '1'){//英文
				$(".imgBoxlogo img").attr("src",webRoot+"/images/index/logo2-EN.png");
			}*/
			$(".header").css("background", "#ffffff");
			$(".header .nav li .second-nav li").css("background", "#ffffff");
			$(".header .nav li a").css("color", "#333");	
		 	$(".language a").css("color", "#333");
		 	$(".languageLine").css("background", "#333");
		 	$(".language a ul li").css("background", "#fff");
		 	$(".language a ul li").css("color", "#333");
			if(gun > 600) {
				$(".topImg").show();
			} else {
				$(".topImg").hide();
			}
			$('.language a ul li').hover(function(){
				$(this).css({
					'background':'#ba0c2f',
					'color':'#fff'
				})
			},function(){
				$(this).css({
					'background':'#fff',
					'color':'#333'
				})
			});
		} else {
			/*if(redisFlag == '0'){//中文*/
				$(".imgBoxlogo img").attr("src",webRoot+"/images/index/logo1.png");
			/*}
			else if(redisFlag == '1'){//英文
				$(".imgBoxlogo img").attr("src",webRoot+"/images/index/logo1-EN.png");
			}*/
			$(".header").css("background", "rgba(0,0,0,0.15)");
			$(".header .nav li .second-nav li").css("background", "rgba(0,0,0,0.15)");
			$(".header .nav li a").css("color", "#fff");
		 	$(".language a").css("color", "#fff");
		 	$(".languageLine").css("background", "#fff");
		 	$(".language a ul li").css("background", "rgba(0, 0, 0, 0.15)");
		 	$(".language a ul li").css("color", "#fff");
			$('.language a ul li').hover(function(){
				$(this).css({
					'background':'#ba0c2f',
					'color':'#fff'
				})
			},function(){
				$(this).css({
					'background':'rgba(0, 0, 0, 0.15)',
					'color':'#fff'
					})
				});
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

//默认高亮当前页
var url = document.location.href;
url = url.split('/');
var html = url[url.length - 2];
if(html.indexOf('desktop') > -1){
	$('.nav li').removeClass('active');
	$('.nav').children('li').eq(0).addClass('active');
}
else if(html.indexOf('aboutUs') > -1){
	$('.nav li').removeClass('active');
	$('.nav').children('li').eq(1).addClass('active');
}
else if(html.indexOf('produce') > -1){
	$('.nav li').removeClass('active');
	$('.nav').children('li').eq(2).addClass('active');
}
else if(html.indexOf('companyDynamic') > -1){
	$('.nav li').removeClass('active');
	$('.nav').children('li').eq(3).addClass('active');
}
else if(html.indexOf('social') > -1){
	$('.nav li').removeClass('active');
	$('.nav').children('li').eq(4).addClass('active');
}
else if(html.indexOf('recruit') > -1){
	$('.nav li').removeClass('active');
	$('.nav').children('li').eq(5).addClass('active');
}
else if(html.indexOf('contactUs') > -1){
	$('.nav li').removeClass('active');
	$('.nav').children('li').eq(6).addClass('active');
	}
	
});
$('.language a').hover(function(){
$(this).children('ul').show();
},function(){
	$(this).children('ul').hide();
});


$('.language a ul li').hover(function(){
$(this).css({
	'background':'#ba0c2f'
	})
},function(){
	$(this).css({
		'background':'rgba(0, 0, 0, 0.15)'
	})
});



/*var cookie = {
set:function(key,val,time){//设置cookie方法
var date=new Date(); //获取当前时间
var expiresDays=time;  //将date设置为n天以后的时间
date.setTime(date.getTime()+expiresDays*24*3600*1000); //格式化为cookie识别的时间
document.cookie=key + "=" + val +"; expires="+date.toGMTString()+"; path=/";  //设置cookie
},
get:function(key){//获取cookie方法
获取cookie参数
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

redisFlag = cookie.get("redisFlag");
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
}*/

$('.language a ul li').on('click',function(){
var text = $(this).text();
if(text == 'ENGLISH'){
		ajax(1);
	}
	else{
		ajax(0);
	} 
});
function ajax(num){
	$.ajax({
        type: "GET",
    cache: false,
    url: webRoot+"/system/language/init.json?redisFlag="+num+"&ran="+ Math.random(),
    dataType: "json",
    success: function(data){
       	 var state = data.serviceResult.success;
       	 if(state){
       		 var popped = data.serviceResult.result;
       		 cookie.set("redisFlag",popped,10);
           		 location.reload();
           	 }
        }	
    });
};

var act = $('#proType').val();
var yqType = $('#yqType').val();
var $navs = $('.nav-ul li a'), // 导航
$navs2 = $('.nav-ul2 li a'),
$navs3 = $('.nav-ul3 li a'),
$sections = $('.section1'),
$sections2 = $('.section2'),
$sections3 = $('.section3'); // 模块
scrollWay();
function scrollWay(){
	if(act == 0){
		$(document).off('.myScroll2');
		$(document).off('.myScroll3');
		_scroll($navs,$sections,1);
	}
	else if(act == 1){
		if(yqType == 0){
			$(document).off('.myScroll1');
			$(document).off('.myScroll3');
			_scroll($navs2,$sections2,2);
		}
		else if(yqType == 1){
			$(document).off('.myScroll1');
			$(document).off('.myScroll2');
			_scroll($navs3,$sections3,3);
		}
	}
	
};
function _scroll(obj1,obj2,num){
	$(document).on('scroll.myScroll'+num, function() {
		navLength = obj1.length - 1;
		var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
		var len = navLength;
		for(; len > -1; len--) {
			var that = obj2.eq(len);
			if(scrollTop + 5 >= that.offset().top) {
				obj1.removeClass('active').eq(len).addClass('active');
				break;
			}
		}
	});
}
//锚点
$navs.on('click',function(){
	_click(this,scrollWay,1);
});
$navs2.on('click',function(){
	_click(this,scrollWay,2);
});
$navs3.on('click',function(){
	_click(this,scrollWay,3);
});
$navs.hover(function(){
	_hover(this);
},function(){
	$(this).removeClass('a-active');
	$(this).siblings().fadeOut(200);
});
$navs2.hover(function(){
	_hover(this);
},function(){
	$(this).removeClass('a-active');
	$(this).siblings().fadeOut(200);
});
$navs3.hover(function(){
	_hover(this);
},function(){
	$(this).removeClass('a-active');
	$(this).siblings().fadeOut(200);
});
function _hover(_this){
	/*redisFlag = cookie.get("redisFlag");
	if(redisFlag == undefined){
		redisFlag = 0;
	}*/
	$(_this).addClass('a-active').parent().siblings().children('a').removeClass('a-active');
	/*if(redisFlag == '0'){//中文*/		
		$(_this).siblings('.textDisCN').fadeIn(200);
	/*}
	else if(redisFlag == '1'){//英文
		$(_this).siblings('.textDisEN').fadeIn(200);
	}*/
};
function _click(_this,fun,num){
	var scroll = '.myScroll'+num;
	$(document).off(scroll);
	var $this = $(_this);
	var thisId = $this.attr('href');
	var thisScrollTop = $(thisId).offset().top - 53;
	setTimeout(function(){
		$this.addClass('active').parent().siblings().children('a').removeClass('active');
		$(document).scrollTop(thisScrollTop);
	},50);
	setTimeout(function(){
		fun();
	},100);
};
	
var tabLiObj = $('.banner-tab ul li');
if(act == 0){
	_act(0);
	$('.creditOne').show();
	$('.creditTwo').hide();
}
else if(act == 1){
	_act(1);
	$('.creditOne').hide();
	$('.creditTwo').show();
};
function _act(index){
	tabLiObj.eq(index).addClass('active');
	tabLiObj.eq(index).children('img').attr('src',webRoot+'/images/credit/tab'+(index + 1)+'-active.png');
};
tabLiObj.on('click',function(){
	if($(this).index() != 2){
		tabLiObj.each(function(){
			if($(this).hasClass('active')){
				var index = $(this).index() + 1;
				$(this).children('img').attr('src',webRoot+'/images/credit/tab'+index+'.png');
			}
		});
		$(this).addClass('active').siblings().removeClass('active');
		var _index = $(this).index();
		act = _index;
		scrollWay();
		$(this).children('img').attr('src',webRoot+'/images/credit/tab'+(_index + 1)+'-active.png');
		$('.creditAll').eq(_index).show().siblings('.creditAll').hide();
	}
	
});

var companyTabObj = $('.creditOne .companyTab ul li');
companyTabObj.on('click',function(){
	var index = $(this).index();
	$(this).addClass('active').siblings().removeClass('active');
	if(index == 0){
		$('.companyTabCon-first').show();
		$('.companyTabCon-first').siblings().hide();
		$('.panel-report').show();
	}
	else if(index == 1){
		$('.companyTabCon-second').show();
		$('.companyTabCon-second').siblings().hide();
		$('.panel-report').hide();
	}
	else if(index == 2){
		$('.companyTabCon-third').show();
		$('.companyTabCon-third').siblings().hide();
		$('.panel-report').hide();
	}
});

var panelTab = $('.panel-tab ul li');
panelTab.on('click',function(){
	$(this).children('span').addClass('active');
	$(this).siblings().children('span').removeClass('active');
});

//逾期账款管理
var companyTabObj = $('.creditTwo .companyTab ul li');
var yqType = $('#yqType').val();
if(yqType == 0){
	$('.chinese').show();
	companyTabObj.eq(0).addClass('active').siblings().removeClass('active');
}
else if(yqType == 1){
	$('.international').show();
	companyTabObj.eq(1).addClass('active').siblings().removeClass('active');
};
companyTabObj.on('click',function(){
	var index = $(this).index();
	$(this).addClass('active').siblings().removeClass('active');
	if(index == 0){
		$('.chinese').show();
		$('.international').hide();
		yqType = 0;
		scrollWay();
	}
	else if(index == 1){
		$('.chinese').hide();
		$('.international').show();
		yqType = 1;
		scrollWay();
	}
});
//免费咨询
$("#sendBtn").on("click",function(){
	sendBtn();
});
function sendBtn(){
	var name,company,tel,mailbox,debtorName,debtorCountry,overdueDays,amount,content,str;
	/*redisFlag = cookie.get("redisFlag");
	if(redisFlag == undefined){
		redisFlag = 0;
	};*/
	/*if(redisFlag == '0'){//中文*/
		str = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199)\d{8}$/;
		name = $('#ContactCN').val();
		tel = $('#TelephoneCN').val();
		company = $('#CompanyCN').val();
		mailbox = $('#EmailCN').val();
		debtorName = $('#NameCN').val();
		debtorCountry = $('#CountryCN').val();
		overdueDays = $('#DayCN').val();
		amount = $('#AmountCN').val();
		content = $("#contentCN").val();
		if(name == ''){
			$('.resetCN').show();
			$('.resetCN').siblings().hide();
			return false;
		}
		else if(!str.test(tel)){
			$('.resetCNPhone').show();
			$('.resetCNPhone').siblings().hide();
			return false;
		}
		else if(company == ''){
			$('.resetCNGSName').show();
			$('.resetCNGSName').siblings().hide();
			return false;
		}
		else if(debtorName == ''){
			$('.resetCNZWGSName').show();
			$('.resetCNZWGSName').siblings().hide();
			return false;
		}
		else if(debtorCountry == ''){
			$('.resetCNGJ').show();
			$('.resetCNGJ').siblings().hide();
			return false;
		}
		else if(amount == ''){
			$('.resetCNMoney').show();
			$('.resetCNMoney').siblings().hide();
			return false;
		}
		else if(content == ''){
			$('.resetCNContent').show();
			$('.resetCNContent').siblings().hide();
			return false;
		}
	    $.post("saveAction.json", {
	    	"name":name,
	    	"tel":tel,
	    	"company":company,
	    	"mailbox":mailbox,
	    	"debtorName":debtorName,
	    	"debtorCountry":debtorCountry,
	    	"overdueDays":overdueDays,
	    	"amount":amount,
	    	"content":content
	    	}, function (ret) {
	        if (ret.serviceResult.success) {
				$('.successCN').show();
				$('.successCN').siblings().hide();
	            $('.suggestionsInfor ul li input').val('');
	            $(".suggestionsContent textarea").val('');
	        }
	    }).error(function () {
	        Common.error("发送失败，请稍后再试", function () {
	        });
	    });
	/*}
	else if(redisFlag == '1'){//英文
		str = /^[0-9]+$/;
		name = $('#ContactEN').val();
		tel = $('#TelephoneEN').val();
		company = $('#CompanyEN').val();
		mailbox = $('#EmailEN').val();
		debtorName = $('#NameEN').val();
		debtorCountry = $('#CountryEN').val();
		overdueDays = $('#DayEN').val();
		amount = $('#AmountEN').val();
		content = $("#contentEN").val();
		if(name == '' || tel == '' || company == '' || debtorName == '' || debtorCountry == '' || amount == '' || !str.test(tel)){
			$('.resetEN').show();
			$('.successEN').hide();
			return false;
		}
	    $.post("saveAction.json", {
	    	"name":name,
	    	"tel":tel,
	    	"company":company,
	    	"mailbox":mailbox,
	    	"debtorName":debtorName,
	    	"debtorCountry":debtorCountry,
	    	"overdueDays":overdueDays,
	    	"amount":amount,
	    	"content":content
	    	}, function (ret) {
	        if (ret.serviceResult.success) {
				$('.successEN').show();
				$('.resetEN').hide();
	            $('.suggestionsInfor ul li input').val('');
	            $(".suggestionsContent textarea").val('');
	        }
	    }).error(function () {
	        Common.error("发送失败，请稍后再试", function () {
	        });
	    });
	};*/
};

//英文版上线删除
jwplayer('mediaplayer').setup({
    'flashplayer': 'jwplayer/jwplayer.flash.swf',
	'image': webRoot+'/images/credit/tcm.jpg',
    'id': 'playerID',
    'width': '400px',
    'height':'300px',
    'file': webRoot+'/websitedata/uploadFiles/video/chinese.mp4'
});
/*if(redisFlag == '0' || redisFlag == undefined){//中文
	jwplayer('mediaplayer').setup({
	    'flashplayer': 'jwplayer/jwplayer.flash.swf',
		'image': webRoot+'/images/credit/tcm.jpg',
	    'id': 'playerID',
	    'width': '400px',
	    'height':'300px',
	    'file': webRoot+'/websitedata/uploadFiles/video/chinese.mp4'
	});
}
else if(redisFlag == '1'){//英文
	jwplayer('mediaplayer').setup({
	    'flashplayer': 'jwplayer/jwplayer.flash.swf',
		'image': webRoot+'/images/credit/tcm.jpg',
	    'id': 'playerID',
	    'width': '400px',
	    'height':'300px',
	    'file': webRoot+'/websitedata/uploadFiles/video/english.mp4'
	});
};*/
window.onload = function () {
	//国际地图开始
	var screen = window.screen.width;
	if(screen <= 1440){
		$("#main2").CSSMap({
			"size":540
		});
		$('.companyInfor').css('width','calc(100% - 540px)');
	}
	else if(screen == 1920){
		$("#main2").CSSMap({
			"size":650
		});
		$('.companyInfor').css('width','calc(100% - 750px)');
	}
	else{
		$("#main2").CSSMap({
			"size":650
		});
		$('.companyInfor').css('width','calc(100% - 650px)');
	};
	var liActive = null;
	/*redisFlag = cookie.get("redisFlag");
	if(redisFlag == undefined){
		redisFlag = 0;
	}*/
	document.getElementById('main2').addEventListener('click',function(e){
		var objLi = $(this).find('ul li');
		var name = '';
		objLi.each(function(){
			liActive = $(this).attr('class').indexOf('active-region');
			var liFocus = $(this).attr('class').indexOf('focus');
			if(liFocus > 0){
				name = $(this).children('a').text();
				//英文版上线删除
				ifElse1(name);
				/*if(redisFlag == '0'){
					ifElse1(name);
				}
				else if(redisFlag == '1'){
					ifElse(name);
				}*/
			};
	  	});
	},true);
	
	$('.menuTitle').hover(function(){
		$(this).addClass('active').parent().siblings().children('a').removeClass('active');
	},function(){
		$(this).removeClass('active');
	});
	
	//英文版上线删除
	$('.menuTitle').on('click',function(){
		var name = $(this).text();
		var act = $(this).hasClass('active1');
		if(act){
			$(this).removeClass('active1');
			$(this).children('i').removeClass('rotate').addClass('rotate1');
			$(this).siblings('.menuCon').slideUp(500);
		}
		else{
			if(name == '非洲'){
				active1(0);
				return false;
			}
			else if(name == '亚洲'){
				active1(1);
				return false;
			}
			else if(name == '大洋洲'){
				active1(2);
				return false;
			}
			else if(name == '欧洲'){
				active1(3);
				return false;
			}
			else if(name == '北美洲'){
				active1(4);
				return false;
			}
			else if(name == '南美洲'){
				active1(5);
				return false;
			}
		};
	});

	/*if(redisFlag == '0'){
		$('.menuTitle').on('click',function(){
			var name = $(this).text();
			var act = $(this).hasClass('active1');
			if(act){
				$(this).removeClass('active1');
				$(this).children('i').removeClass('rotate').addClass('rotate1');
				$(this).siblings('.menuCon').slideUp(500);
			}
			else{
				if(name == '非洲'){
					active1(0);
					return false;
				}
				else if(name == '亚洲'){
					active1(1);
					return false;
				}
				else if(name == '大洋洲'){
					active1(2);
					return false;
				}
				else if(name == '欧洲'){
					active1(3);
					return false;
				}
				else if(name == '北美洲'){
					active1(4);
					return false;
				}
				else if(name == '南美洲'){
					active1(5);
					return false;
				}
			};
		});
	}
	else if(redisFlag == '1'){
		$('.menuTitle').on('click',function(){
			var name = $(this).text();
			var act = $(this).hasClass('active1');
			if(act){
				$(this).removeClass('active1');
				$(this).children('i').removeClass('rotate').addClass('rotate1');
				$(this).siblings('.menuCon').slideUp(500);
			}
			else{
				ifElse(name);
			}
		});	
	};*/
	function ifElse1(a){
		if(a == 'Africa'){
			active1(0);
		}
		else if(a == 'Asia'){
			active1(1);
		}
		else if(a == 'Australia'){
			active1(2);
		}
		else if(a == 'Europe'){
			active1(3);
		}
		else if(a == 'North America'){
			active1(4);
		}
		else if(a == 'South America'){
			active1(5);
		}
	};
	function ifElse(a){
		if(a == 'Africa'){
			active(0);
		}
		else if(a == 'Asia'){
			active(1);
		}
		else if(a == 'Australia'){
			active(2);
		}
		else if(a == 'Europe'){
			active(3);
		}
		else if(a == 'North America'){
			active(4);
		}
		else if(a == 'South America'){
			active(5);
		}
	};
	function active1(index){
		$('.chineseItem .menu-item').eq(index).find('i').addClass('rotate').removeClass('rotate1');
		$('.chineseItem .menu-item').eq(index).siblings().find('i').addClass('rotate1').removeClass('rotate');
		$('.chineseItem .menu-item').eq(index).children('a').addClass('active1');
		$('.chineseItem .menu-item').eq(index).siblings().children('a').removeClass('active1');
		$('.chineseItem .menu-item').eq(index).children('.menuCon').slideDown(500);
		$('.chineseItem .menu-item').eq(index).siblings().children('.menuCon').slideUp(500);
		if(liActive > 0){
			$('.chineseItem .menu-item').eq(index).children('a').removeClass('active1');
			$('.chineseItem .menu-item').eq(index).children('.menuCon').slideUp(500);
			$('.chineseItem .menu-item').eq(index).find('i').addClass('rotate1');
			$('.chineseItem .menu-item').eq(index).find('i').removeClass('rotate');
		};
	};
	function active(index){
		$('.englishItem .menu-item').eq(index).find('i').addClass('rotate').removeClass('rotate1');
		$('.englishItem .menu-item').eq(index).siblings().find('i').addClass('rotate1').removeClass('rotate');
		$('.englishItem .menu-item').eq(index).children('a').addClass('active1');
		$('.englishItem .menu-item').eq(index).siblings().children('a').removeClass('active1');
		$('.englishItem .menu-item').eq(index).children('.menuCon').slideDown(500);
		$('.englishItem .menu-item').eq(index).siblings().children('.menuCon').slideUp(500);
		if(liActive > 0){
			$('.englishItem .menu-item').eq(index).children('a').removeClass('active1');
			$('.englishItem .menu-item').eq(index).children('.menuCon').slideUp(500);
			$('.englishItem .menu-item').eq(index).find('i').addClass('rotate1');
			$('.englishItem .menu-item').eq(index).find('i').removeClass('rotate');
		};
	};
	//$(".content").mCustomScrollbar();
	//国际地图 结束
}

