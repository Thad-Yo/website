	var
		//页面的静态变量声名，声名完以逗号结束																									
		/* Action名称 */
		Actions = {
			//画面表单提交的Action名集合																							
		},
		/* 事件动作处理 */
		Events = {
			// 画面尺寸调整动作事件																								
			resizeAct: function(event) {
				//画面的resize事件，画面框架会自动调用本方法，无处理时可不写本方法																						
			},
			menuFunctions: function() {
				$(this).addClass("nav-active");
				$(this).siblings().removeClass("nav-active");
			},
			topFunction: function() {
				$(this).hide()
			}
		};
	var Page = {
		initEvents: function() {
			/*	$(window).scroll(Events.menuFunction);*/
			$(".topImg").click(Events.topFunction);
			$(".topImg").hide();
			//联信动态
			var _length = $('.dongtai .swiper-wrapper .swiper-slide').length;
			if(_length > 3){
				_length = 3;
			}
			else if(_length == 1){
				$('.section5 .swiper-container').css('width','50%');
			}
			var swiper = new Swiper('.dongtai', {
				slidesPerView: _length,
				loop: false,
				autoplay: true,
				pagination: {
					el: '.dongtai .swiper-pagination',
					clickable: true,
				},
				/*navigation: {
					nextEl: '.swiper-button-next',
					prevEl: '.swiper-button-prev',
				},*/
			});
			$(".dongtai").mouseenter(function() {
				swiper.autoplay.stop();
			});
			$(".dongtai").mouseleave(function() {
				swiper.autoplay.start();
			});

			$(".two-bg").hide();

			//公司动态
			$(".tab-hide").css('visibility','hidden');
			$(".tab-show").hover(function() {
				$(this).find(".tab-hide").css('visibility','visible');
				$(this).find(".tab-hide").show(100);

			}, function() {
				$(this).find(".tab-hide").css('visibility','hidden');
			});

			/*	$navs.on('click', function(e) {
					e.preventDefault();
					$('html, body').animate({
						'scrollTop': $($(this).attr('href')).offset().top
					}, 400);
				});*/


		}
	};

	$(function() {
		Page.initEvents();
	});