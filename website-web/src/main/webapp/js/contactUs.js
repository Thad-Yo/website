var province = '';
// 路径配置
require.config({
    paths: {
        echarts: 'http://echarts.baidu.com/build/dist'
    }
});
// 使用
require(['echarts','echarts/chart/map'],function (ch) {
	var ecConfig = require('echarts/config');
    // 基于准备好的dom，初始化echarts图表
    var myChart = ch.init(document.getElementById('mapMain'));  
    option = {
	    tooltip : {
	        trigger: 'item',
			formatter: function (params,ticket,callback) {
				console.log(params);
				var res = params.data.show;
				return res;
			},
	    },
	    legend: {
	        x:'',
	        data:['中国']
	    },
	    series : [{
            name: '中国',
            type: 'map',
            mapType: 'china',
            selectedMode : 'single',
    		roam: false,//是否滚动拖放
            itemStyle:{
                normal:{
                	label:{
                		show:true,
                        textStyle: {
                           color: "#ba0c2f"
                        }
                	},
	                borderWidth: 1,//区域边框宽度
	                borderColor: '#D1CDC8',//区域边框颜色
	                areaStyle:{//未选中区域背景颜色
	                	color:'#F7F7F6'
	                }
                },
                emphasis:{
                	label:{
                		show:true
                	},
	                areaStyle:{//选中区域背景颜色
	                	color:'#F1A0A6'
	                }
                }
            },
            data:[
        	{//隐藏南海诸岛
		        name:"南海诸岛",value:0,  
		        itemStyle:{  
		            normal:{opacity:0,label:{show:false}}  
		        }  
		    },
            {name: '北京',"show": '北京/Beijing'},
            {name: '天津',"show": '天津/Tianjing'},
            {name: '上海',"show": '上海/Shanghai'},
            {name: '重庆',"show": '重庆/Chongqing'},
            {name: '河北',"show": '河北/Hebei'},
            {name: '河南',"show": '河南/Henan'},
            {name: '云南',"show": '云南/Yunnan'},
            {name: '辽宁',"show": '辽宁/Liaoning'},
            {name: '黑龙江',"show": '黑龙江/Heilongjiang'},
            {name: '湖南',"show": '湖南/Hunan'},
            {name: '安徽',"show": '安徽/Anhui'},
            {name: '山东',"show": '山东/Shandong'},
            {name: '新疆',"show": '新疆/Xinjiang'},
            {name: '江苏',"show": '江苏/Jiangsu'},
            {name: '浙江',"show": '浙江/Zhejiang'},
            {name: '江西',"show": '江西/Jiangxi'},
            {name: '湖北',"show": '湖北/Hubei'},
            {name: '广西',"show": '广西/Guangxi'},
            {name: '甘肃',"show": '甘肃/Gansu'},
            {name: '山西',"show": '山西/Shanxi'},
            {name: '内蒙古',"show": '内蒙古/Inner Mongoria'},
            {name: '陕西',"show": '陕西/Shaanxi'},
            {name: '吉林',"show": '吉林/Jilin'},
            {name: '福建',"show": '福建/Fujian'},
            {name: '贵州',"show": '贵州/Guizhou'},
            {name: '广东',"show": '广东/Guangdong'},
            {name: '青海',"show": '青海/Qinghai'},
            {name: '西藏',"show": '西藏/Tibet'},
            {name: '四川',"show": '四川/Sichuan'},
            {name: '宁夏',"show": '宁夏/Ningxia'},
            {name: '海南',"show": '海南/Hainan'},
            {name: '台湾',"show": '台湾/Taiwan'},
            {name: '香港',"show": '香港/Hong Kong'},
            {name: '澳门',"show": '澳门/Macao'}
            ]
        }]
	};
    // 为echarts对象加载数据 
    myChart.setOption(option); 
    myChart.on(ecConfig.EVENT.CLICK, eConsole);
    function eConsole(param) {
    	province = param.data.name;
    	if(province !== "南海诸岛"){
    		zhezhao(province);
    	}
	}
});

var map = new AMap.Map('container', {
    resizeEnable: true,
    zoom:17,
    center: [120.318105,36.066203]
});
$(document).ready(function(){
  	var button = document.getElementById("zh_en");
	AMap.event.addDomListener(button,'click',clickListener);
    function clickListener() {
        map.setLang(this.id);
    }
	$("#zh_en").trigger("click"); 		
})
 
var marker = new AMap.Marker({
    map: map,
	position: [120.318105,36.066203],
	offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
    icon: new AMap.Icon({            
        image: webRoot+"/images/contactUs/map.png",
    })        
});
//鼠标点击marker弹出自定义的信息窗体
AMap.event.addListener(marker, 'click', function() {
    infoWindow.open(map, marker.getPosition());
});       

//实例化信息窗体
var title = '<div style="font-size:16px;color:#F00;">联信集团总部地址<br/>Inter Credit headquarters</div>',
    content = [];
content.push("地址：山东省青岛市市南区中山路44-60号百盛商务中心18楼<br/>Addr: Parkson international business center 18th floor, 44-60# zhong shan road,qingdao,Shandong");
var infoWindow = new AMap.InfoWindow({
    isCustom: true,  //使用自定义窗体
    content: createInfoWindow(title, content.join("<br/>")),
    offset: new AMap.Pixel(16, -60)
});

//构建自定义信息窗体
function createInfoWindow(title, content) {
    var info = document.createElement("div");
    info.className = "info";

    //可以通过下面的方式修改自定义窗体的宽高
    info.style.width = "340px";
    // 定义顶部标题
    var top = document.createElement("div");
    var titleD = document.createElement("div");
    var closeX = document.createElement("img");
    top.className = "info-top";
    titleD.innerHTML = title;
    closeX.src = "http://webapi.amap.com/images/close2.gif";
    closeX.onclick = closeInfoWindow;

    top.appendChild(titleD);
    top.appendChild(closeX);
    info.appendChild(top);

    // 定义中部内容
    var middle = document.createElement("div");
    middle.className = "info-middle";
    middle.style.backgroundColor = 'white';
    middle.innerHTML = content;
    info.appendChild(middle);

    // 定义底部内容
    var bottom = document.createElement("div");
    bottom.className = "info-bottom";
    bottom.style.position = 'relative';
    bottom.style.top = '0px';
    bottom.style.margin = '0 auto';
    var sharp = document.createElement("img");
    sharp.src = "http://webapi.amap.com/images/sharp.png";
    bottom.appendChild(sharp);
    info.appendChild(bottom);
    return info;
}

//关闭信息窗体
function closeInfoWindow() {
    map.clearInfoWindow();
}

//遮罩框
$("#panel-btn").on("click",function(){
	zhezhao('');
})
$(document).on("click",".maskBoxClose",function(){
	$("body").css("overflow","auto");
	$(".maskBox").hide();
})

//发送建议
$("#sendBtn").on("click",function(){
	sendBtn();
})

function sendBtn(){
	redisFlag = cookie.get("redisFlag");
	if(redisFlag === undefined){
		redisFlag = '0';
	}
	let languageMark = redisFlag !== '1' ? 'CN' : 'EN',
	name = $('#Name' + languageMark).val(),
	tel = $('#Telephone' + languageMark).val(),
	mailbox = $('#Email' + languageMark).val(),
	content = $('#content' + languageMark).val();
	if (name === '') {
		$('.reset' + languageMark).show().siblings().hide();
		return false;
	}else if (tel === '') {
		console.log(1);
		$('.reset' + languageMark + 'Phone').show().siblings().hide();
		return false;
	} else if (languageMark==='CN'&&!/^1[34578]\d{9}$/.test(tel)) {
		console.log(2);
		$('.reset' + languageMark + 'Phone').show().siblings().hide();
		return false;
	} else if (content === '' || strlen(content) > 1000) {
		$('.reset' + languageMark + 'Suggest').show().siblings().hide();
		return false;
	}
	$.post("saveAction.json", {"name": name,"tel":tel,"mailbox":mailbox,"content":content}, function (ret) {
		if (ret.serviceResult.success) {
			$('.success' + languageMark).show().siblings().hide();
			$('.suggestionsInfor ul li input').val('');
			$(".suggestionsContent textarea").val('');
		}
	});
}
function strlen(str){
    var len = 0;
    for (var i=0; i<str.length; i++) { 
      var c = str.charCodeAt(i); 
      //单字节加1 
      if ((c >= 0x0001 && c <= 0x007e) || (0xff60<=c && c<=0xff9f)) { 
    	  len++; 
      } 
      else { 
    	  len+=2; 
      } 
	} 
    return len;
}

function zhezhao(pro){
	var province = '';
	if(pro==''){
	    province= $("#panel-select option:selected").val();
    }else{
        province=pro;
    }
	if(province == 0){
	    //alert("请选择具体省份");
	    return false;
    }
	//后台接口获取数据
    $.post("getRecordAction.json", {"province": province}, function (ret) {
        var result = ret.serviceResult;
        if (result.success) {
        	$("body").css("overflow","hidden");
        	var height = $(".maskBoxContent").height();
        	$(".maskBoxContent").css({
        		"marginTop": -(height / 2)
        	});
            $(".maskBox").empty();
            var html= '';
            var record = result.result;
            if(record.length>0){
            	/*if(province == '北京'){
            		province = province + '市';
            	}
            	else if(province == '天津'){
            		province = province + '市';
            	}
            	else if(province == '重庆'){
            		province = province + '市';
            	}
            	else if(province == '上海'){
            		province = province + '市';
            	}
            	else if(province == '河北'){
            		province = province + '省';
            	}
            	else if(province == '山西'){
            		province = province + '省';
            	}
            	else if(province == '辽宁'){
            		province = province + '省';
            	}
            	else if(province == '吉林'){
            		province = province + '省';
            	}
            	else if(province == '黑龙江'){
            		province = province + '省';
            	}
            	else if(province == '江苏'){
            		province = province + '省';
            	}
            	else if(province == '浙江'){
            		province = province + '省';
            	}
            	else if(province == '安徽'){
            		province = province + '省';
            	}
            	else if(province == '福建'){
            		province = province + '省';
            	}
            	else if(province == '江西'){
            		province = province + '省';
            	}
            	else if(province == '山东'){
            		province = province + '省';
            	}
            	else if(province == '河南'){
            		province = province + '省';
            	}
            	else if(province == '湖北'){
            		province = province + '省';
            	}
            	else if(province == '湖南'){
            		province = province + '省';
            	}
            	else if(province == '广东'){
            		province = province + '省';
            	}
            	else if(province == '海南'){
            		province = province + '省';
            	}
            	else if(province == '四川'){
            		province = province + '省';
            	}
            	else if(province == '贵州'){
            		province = province + '省';
            	}
            	else if(province == '云南'){
            		province = province + '省';
            	}
            	else if(province == '陕西'){
            		province = province + '省';
            	}
            	else if(province == '甘肃'){
            		province = province + '省';
            	}
            	else if(province == '青海'){
            		province = province + '省';
            	}
            	else if(province == '台湾'){
            		province = province + '省';
            	}
            	else if(province == '新疆'){
            		province = province + '维吾尔自治区';
            	}
            	else if(province == '宁夏'){
            		province = province + '回族自治区';
            	}
            	else if(province == '西藏'){
            		province = province + '自治区';
            	}
            	else if(province == '广西'){
            		province = province + '壮族自治区';
            	}
            	else if(province == '内蒙古'){
            		province = province + '自治区';
            	}
            	else if(province == '香港'){
            		province = province + '特别行政区';
            	}
            	else if(province == '澳门'){
            		province = province + '特别行政区';
            	}*/
                html+='<div class="maskBoxContent"><div class="maskBoxClose"><i class="iconfont icon-guanbi"></i></div><div class="maskBoxTitle">'+
                    province+'</div><div class="bottomLine"><div><p></p></div><span></span><div><p></p></div></div><div class="maskBoxInfor"><ul>';
                for(var i=0;i<record.length;i++){
                    html+='<li><div class="liMark"><i class="iconfont icon-dianhua"></i></div><div class="liPhone">' +
                        record[i].filialeName+'：'+record[i].tel+'</div></li>';
                }
                html+='</ul></div></div>';
            }
            $(".maskBox").append(html);
            $(".maskBox").show();
        }
    });
	
}
