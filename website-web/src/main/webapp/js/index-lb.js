;(function (window,document){
           function WySlider(eles,options){
               if(!eles){
                   throw "轮播图元素必须传递";
               }
               this._init(eles,options);
   
           }
           WySlider.prototype._init = function (eles,options){
               /*将传递的元素全部添加到对象本身，这样使用时就可以多个元素了*/
               if(eles && (typeof eles !== "string") && eles.length && eles[eles.length - 1]){
                   [].push.apply(this, eles);
               }else if(eles && (typeof eles !== "string")){
                   [].push.apply(this, [eles]);
               }
               if(options && ({}).toString.call(options) === "[object Object]"){
                    this.options = options;
               }
               //遍历所有的元素
               for(var i = 0,len = this.length; i < len; i ++){
                   var currentSlideBox = this[i];
                   if(!currentSlideBox && (currentSliderBox.nodeType !== 1) && (!currentSliderBox.nodeName)){
                       continue;
                   }
                   currentSlideBox.index = 0;//当前索引
                   currentSlideBox.silder_main = currentSlideBox.getElementsByTagName("*");
                   for(var j = 0,len2 = currentSlideBox.silder_main.length; j < len2; j ++){
                       var ele = currentSlideBox.silder_main[j];
                       if (WySlider.hasClass(ele,'silder-main')){
                           currentSlideBox.silder_main = ele;
                           break;
                       }
                   }
                   currentSlideBox.silder_main_imgs = currentSlideBox.silder_main.children;
                   currentSlideBox.imgs_len = currentSlideBox.silder_main_imgs.length;
                   currentSlideBox.imgs_width = currentSlideBox.silder_main_imgs[0].offsetWidth;
                   currentSlideBox.js_silder_ctrl = currentSlideBox.children[1];
   
                   var slider_ctrl_children = currentSlideBox.js_silder_ctrl.children;
                   for(var k = 0,len3 = slider_ctrl_children.length; k < len3; k ++){
                       //上一张、下一张按钮绑定点击事件
                       this._samllControllBtnBindEvent(slider_ctrl_children[k],currentSlideBox);
                   }
                   //生成小的控制按钮
                   this._createSmallControllBtn(currentSlideBox);
                   if(this.options && this.options.auto){
                        this._autoPlay(currentSlideBox);
                   }
               }
           }
           /*生成小的控制按钮*/
           WySlider.prototype._createSmallControllBtn = function (currentSlideBox){
               for(var i = 0,len2 = currentSlideBox.imgs_len;i < len2;i ++){
                   var silder_main_imgs = currentSlideBox.silder_main_imgs;
                   silder_main_imgs[i].index = i;
   
                   //将除第一张之外的全部图片都移到右边
                   if(i != 0){
                       silder_main_imgs[i].style.left = currentSlideBox.imgs_width + "px";
                   }
   
                   var span = document.createElement("span"),
                       js_silder_ctrl = currentSlideBox.js_silder_ctrl;
                   span.className = "silder-ctrl-con";
                   if(i == 0){
                       span.className = "silder-ctrl-con current";
                   }
                   span.innerHTML = i+1;
                   //给新生成的span绑定点击事件
                   this._samllControllBtnBindEvent(span,currentSlideBox);
                   //将生成的span插入到最后一个元素的前面
                   js_silder_ctrl.insertBefore(span, js_silder_ctrl.children[js_silder_ctrl.children.length - 1]);
               }
           }
           /*给小的控制按钮添加点击事件*/
           WySlider.prototype._samllControllBtnBindEvent = function (samllControllBtn,currentSlideBox){
               //获取所有的点击按钮
               var that = this,
                   iNow = currentSlideBox.index;//控制图片播放
                   samllControllBtn.onclick = function (){
                       var classname = this.className,
                           thatNum = this.innerHTML - 1,
                           silder_main_imgs = currentSlideBox.silder_main_imgs,
                           imgs_len = currentSlideBox.imgs_len;
                           imgs_width = currentSlideBox.imgs_width;
                       if(/silder-ctrl-prev/g.test(classname)){//左边按钮，即上一张按钮
                            //当前这张图片往右边边出去
                           WySlider.animate(silder_main_imgs[currentSlideBox.index], {"left": imgs_width});
   
                           currentSlideBox.index--;
                           if(currentSlideBox.index < 0){
                              currentSlideBox.index = imgs_len - 1;
                           }
                           /*上一张图片进来之前先将它移到最左边，这样就能保证无限循环，如果不这样设置，那么第一次到头后就不会有从左边出来的效果了。
                           */
                           silder_main_imgs[currentSlideBox.index].style.left = -imgs_width + "px";
                           //上一张图片进来
                           WySlider.animate(silder_main_imgs[currentSlideBox.index], {"left": 0});
                       }else if(/silder-ctrl-next/g.test(classname)){//右边按钮，即下一张按钮
                           that._play(currentSlideBox);
                       }else{
                           /*如果点击的这个数字按钮的数值大于当前图片的索引，那么图片应该从右边出来*/
                           if(thatNum > currentSlideBox.index){
                               WySlider.animate(silder_main_imgs[currentSlideBox.index], {"left": -imgs_width});
                               silder_main_imgs[thatNum].style.left = imgs_width + "px";
                           }else if(thatNum < currentSlideBox.index){
                               WySlider.animate(silder_main_imgs[currentSlideBox.index], {"left": imgs_width});
                               silder_main_imgs[thatNum].style.left = -imgs_width + "px";
                           }

                           WySlider.animate(silder_main_imgs[thatNum], {"left": 0});
                           currentSlideBox.index = thatNum;
                       }
                       that._setCtrlBtnStyle(currentSlideBox.index+1,currentSlideBox);
                   }
           }
           /*设置图片运动*/
           WySlider.prototype._play = function (currentSlideBox){
               var silder_main_imgs = currentSlideBox.silder_main_imgs,
                   iNow = currentSlideBox.index,
                   imgs_width = currentSlideBox.imgs_width,
                   imgs_len = currentSlideBox.imgs_len;
   
               //当前这张图片往左边出去
               WySlider.animate(silder_main_imgs[iNow], {"left": -imgs_width});
   
               currentSlideBox.index = ++iNow;
               if(iNow > imgs_len - 1){
                   currentSlideBox.index = iNow = 0;
               }
               /*下一张图片进来之前先将它移到最右边，这样就能保证无限循环，如果不这样设置，那么第一次到尾后就不会有从右边出来的效果了。
               */
               silder_main_imgs[iNow].style.left = imgs_width + "px";
               //下一张图片进来
               WySlider.animate(silder_main_imgs[iNow], {"left": 0});
           }
           /*设置当前点击按钮的样式，不包括左、右按钮*/
           WySlider.prototype._setCtrlBtnStyle = function (num,currentSlideBox){
               var silder_ctrl_spans = currentSlideBox.js_silder_ctrl.children;
               for(var k = 1,len = silder_ctrl_spans.length;k <= len - 2;k ++){
                   silder_ctrl_spans[k].className = "silder-ctrl-con";
               }
   
                silder_ctrl_spans[num].className = "silder-ctrl-con current";
           }
           /*//自动播放*/
           WySlider.prototype._autoPlay = function (currentSlideBox){
                var that = this,
                    interval = this.options ? (this.options.time ? this.options.time : 2000) : 2000;
               currentSlideBox.timer = null;
               currentSlideBox.timer = setInterval(function (){
                   that._play(currentSlideBox);
                   that._setCtrlBtnStyle(currentSlideBox.index+1,currentSlideBox);
               }, interval);
   
               //当鼠标放在图片上的时候停止自动播放
               currentSlideBox.onmouseover = function (){
                   clearInterval(currentSlideBox.timer);
               }
               //当鼠标离开图片的时候自动播放
               currentSlideBox.onmouseleave = function (){
                   clearInterval(currentSlideBox.timer);
                   currentSlideBox.timer = setInterval(function (){
                        that._play(currentSlideBox);
                        that._setCtrlBtnStyle(currentSlideBox.index+1,currentSlideBox);
                   }, interval);
               }
           }
           /*获取元素*/
           WySlider.$ = function (selector){
               var classSelectSign = selector.indexOf("."),
                   idSelectSign = selector.indexOf("#");
   
               //id选择器
               if(idSelectSign > -1){
                   return document.getElementById(selector.substr(1));
               }
   
               //class选择器
               if(classSelectSign > -1){
                   var classSelect = selector.substr(classSelectSign+1);
   
                   //支持通过class获取元素的浏览器
                   if(document.getElementsByClassName){
                       var eles = document.getElementsByClassName(classSelect);
                       if(eles.length == 1){
                           return eles[0];
                       }else{
                           return eles;
                       }
                   }else{
                       var baseEleName = classSelectSign > 0 ? selector.substr(0,classSelectSign) : "*",
                           eles = document.getElementsByTagName(baseEleName),
                           elesResult = [];
   
                       for(var i = 0,len = eles.length; i < len; i ++){
                           if(WySlider.hasClass(eles[i],classSelect)){
                               elesResult.push(eles[i]);
                           }
                       }
                       if(elesResult.length == 1){
                           return elesResult[0];
                       }else{
                           return elesResult;
                       }
                   }
               }
   
               //标签选择器
               return document.getElementsByTagName(selector);           
           }
   
           /*判断元素是否有某个class*/
           WySlider.hasClass = function (ele,classnameparam){
               var classname = ele.className
                   classArr = classname.split(" ");
               for(var i in classArr){
                   if(classArr[i] == classnameparam){
                       return true;
                   }
               }
               return false;
           }
   
           /*获取样式*/
           WySlider.getStyle = function (ele,attr){
               if(ele.currentStyle){
                   return ele.currentStyle[attr];
               }else{
                   return ele.ownerDocument.defaultView.getComputedStyle(ele,null)[attr];
               }
           }
           /*动画函数*/
           WySlider.animate = function (ele,attrsJson,fn){
               clearInterval(ele.timer);
   
               ele.timer = setInterval(function (){
                   var flag = true;
                   for(var attr in attrsJson){
                       var curStyle = parseInt(WySlider.getStyle(ele,attr)),
                           step = (parseInt(attrsJson[attr]) - curStyle) / 10;
   
                       step = step > 0 ? Math.ceil(step) : Math.floor(step);
   
                       if(curStyle != attrsJson[attr]){
                           flag = false;
                       }
   
                       if(attr == "zIndex"){
                           ele.style.zIndex = attrsJson[attr];
                       }else{
                           ele.style[attr] = curStyle + step + "px";
                       }
                   }
                   if(flag){
                       clearInterval(ele.timer);
                       if(fn){
                           fn.call(window);
                       }
                   }
               }, 20);
           }
           window.WySlider = WySlider;
       })(window,document);
   
      window.onload = function (){
           /*
                参数一：参数一为包裹轮播图的元素，该参数可以为一个元素，也可以为一个包裹多个元素的数组或伪数组
                参数二：参数二为配置参数，可以传递auto，auto的值若为false则不自动轮播，反之，默认为false。time为轮播的时间，默认为2000毫秒
            */
          
      } 