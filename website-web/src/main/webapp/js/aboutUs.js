
//返回顶部
$(document).on('scroll',function(){
	var top = document.documentElement.scrollTop || document.body.scrollTop;
	if(top > 1000){
		$('.backTop').show();
	}
	else{
		$('.backTop').hide();
	}
});
$('.backTop').on('click',function(){
	scrollToptimer = setInterval(function () {
    	var top = document.documentElement.scrollTop || document.body.scrollTop;
	    var speed = top / 4;
	    if (document.body.scrollTop != 0) {
	        document.body.scrollTop -= speed;
	    }else {
	        document.documentElement.scrollTop -= speed;
	    }
	    if (top == 0) {
	        clearInterval(scrollToptimer);
	    }
	}, 50); 
});

//英文版上线删除此方法
$(".group-one").hover(function() {
	$(this).find(".group-hide2").eq(0).removeClass("hide");
}, function() {
	$(this).find(".group-hide2").eq(0).addClass("hide");
});

/*redisFlag = cookie.get("redisFlag");
if(redisFlag == undefined){
	redisFlag = 0;
}
if(redisFlag == '0'){//中文
	$(".group-one").hover(function() {
		$(this).find(".group-hide2").eq(0).removeClass("hide");
	}, function() {
		$(this).find(".group-hide2").eq(0).addClass("hide");
	});
}
else if(redisFlag == '1'){//英文
	$(".group-one").hover(function() {
		$(this).find(".group-hide2").eq(1).removeClass("hide");
	}, function() {
		$(this).find(".group-hide2").eq(1).addClass("hide");
	});
};*/
window.onload = function(){
	//合作伙伴轮播
	$(".box").superSlider({
		prevBtn: 	 ".prev",//左按钮
		nextBtn: 	 ".next",//右按钮
		listCont:    "#roll",//滚动列表外层
		scrollWhere: "next",//自动滚动方向next
		delayTime: 	 1000,//自动轮播时间间隔
		speed: 		 1200,//滚动速度
		amount: 	 1,//单次滚动数量
		showNum: 	 5,//显示数量
		autoPlay: 	 true//自动播放
	});
	var length = $('.swiper3 .swiper-slide').length;
	var swiper = new Swiper('.swiper3.swiper-container', {
		spaceBerween: 30,
		loop: true,
		/*autoplay: true,*/
		navigation: {
			nextEl: '.swiper-btn .swiper-button-next',
			prevEl: '.swiper-btn .swiper-button-prev',
		},
		initialSlide:length - 1
	});
	
	_swiper();
	function _swiper(){
		var num = 0;
		var index = $('.swiper-top .swiper3 .swiper-wrapper').children('.swiper-slide-active').attr('data-swiper-slide-index');
		$('.swiper-bottom .swiper2').hide();
		$('.swiper-bottom .swiper2').eq(index).show();
		var conLength = $('.swiper-top .swiper3 .swiper-wrapper').children('.swiper-slide-active').find('.year-index').val();
		if(conLength >= 5){
			conLength = 5;
		}
		var swiper = new Swiper('.swiper2.swiper-container', {
			slidesPerView: conLength,
			direction: 'vertical',
			loop: true,
			navigation: {
				nextEl: '.swiper2 .swiper-button-next',
				prevEl: '.swiper2 .swiper-button-prev',
			},
			autoplayDisableOnInteraction: false,
			on: {
			    init: function(){
			      var numAll = $('.swiper-bottom .swiper2').length - 1;
			      var slideObj = $('.swiper2').eq(index).find('.swiper-wrapper .swiper-slide').eq(0);
			      var slideH = slideObj.height();
				  var slideTitleH = slideObj.find('.swiper-title').outerHeight() + 10;
				  var detailsObj = $('.swiper2').eq(index).find('.swiper-wrapper .swiper-slide .swiper-details');
				  detailsObj.css({
					  'height':(slideH - slideTitleH - 10)
				  });
				  if(num == numAll){
					  detailsObj.each(function() {
						  var divH = $(this).height();
						  console.log(divH)
						  var $p = $(this).find('p');
						  while ($p.outerHeight() > divH) {
							  $p.text($p.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/, "..."));
						  }; 
					  });
				  }
				  num++;
			    }, 
		    },
		});
	}
	
	
	hover();
	function hover(){
		$('.swiper2 .swiper-slide').hover(function(){
			$(this).find('.swiper-title').css({
				'color':'#bc1736',
				'border-bottom':'1px solid #bc1736'
			});
			$(this).find('.swiper-circle').css({
				'border':'3px solid #bc1736',
				'top':'19px',
				'left':'-16px'
			});
		},function(){
			$(this).find('.swiper-title').css({
				'color':'#2b2b2f',
				'border-bottom':'1px solid #ddd'
			});
			$(this).find('.swiper-circle').css({
				'border':'1px solid #bc1736',
				'top':'20px',
				'left':'-15px'
			});
		})
	}

	var _length = $('.swiper4 .swiper-wrapper .swiper-slide').length;
	if(_length > 4){
		_length = 4;
	}
	var swiper = new Swiper('.swiper4.swiper-container', {
		slidesPerView: _length,
		spaceBerween: 30,
		loop: true,
		/*autoplay: true,*/
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		},
		autoplayDisableOnInteraction: false
	});
	
	$(".swiper-all").hover(function(){},function(){});
	
	$('.swiper-btn > div').on('click',function(){
		_swiper();
	});
	//滚动条
	$(".content").mCustomScrollbar();
};
