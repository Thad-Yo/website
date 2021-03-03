var dom = document.getElementById("main1");
var myChart = echarts.init(dom);
var app = {};
option = null;
var data = [//{ name: '青岛', value: 0, phone: '0532-86868866', adress: '青岛市市南区百盛21楼'},
	{ name: '乌鲁木齐\nUrumqi', value: 84 },
	{ name: '重庆\nChongqing', value: 61 },
	{ name: '西安\nXi\'an', value: 61 },
	{ name: '哈尔滨\nHarbin', value: 114 },
	{ name: '长春\nChangchun', value: 51 },
	{ name: '沈阳\nShenyang', value: 50 },
	{ name: '北京\nBeijing', value: 79 },
	{ name: '天津\nTianjin', value: 105 },
	{ name: '石家庄\nShijiazhuang', value: 147 },
	{ name: '济南\nJinan', value: 92 },
	{ name: '青岛\nQingdao', value: 0},
	{ name: '太原\nTaiyuan', value: 39 },
	{ name: '郑州\nZhengzhou', value: 113 },
	{ name: '成都\nChengdu', value: 59 },
	{ name: '长沙\nChangsha', value: 59 },
	{ name: '大连\nDalian', value: 59 },
	{ name: '东莞\nDongguan', value: 59 },
	{ name: '福州\nFuzhou', value: 59 },
	{ name: '广州\nGuangzhou', value: 59 },
	{ name: '佛山\nFoshan', value: 59 },
	{ name: '贵阳\nGuiyang', value: 59 },
	{ name: '海口\nHaikou', value: 59 },
	{ name: '杭州\nHangzhou', value: 59 },
	{ name: '绍兴\nShaoxing', value: 59 },
	{ name: '合肥\nHefei', value: 59 },
	{ name: '呼和浩特\nHohhot', value: 59 },
	{ name: '泰安\nTai\'an', value: 59 },
	{ name: '昆明\nKunming', value: 59 },
	{ name: '曲靖\nQujing', value: 59 },
	{ name: '兰州\nLanzhou', value: 59 },
	{ name: '南昌\nNanchang', value: 59 },
	{ name: '南京\nNanjing', value: 59 },
	{ name: '南宁\nNanning', value: 59 },
	{ name: '宁波\nNingbo', value: 59 },
	{ name: '厦门\nXiamen', value: 59 },
	/*{ name: '泉州\nQuanzhou', value: 59 },*/
	{ name: '上海\nShanghai', value: 59 },
	{ name: '深圳\nShenzhen', value: 59 },
	{ name: '苏州\nSuzhou', value: 59 },
	{ name: '武汉\nWuhan', value: 59 },
	{ name: '银川\nYinchuan', value: 59 },
	{ name: '烟台\nYantai', value: 59 },
    { name: '西宁\nXining', value: 59 },
    { name: '大理\nDali', value: 59 }

];
var geoCoordMap = {
	'乌鲁木齐\nUrumqi': [87.68, 43.77],
	'重庆\nChongqing': [106.55, 29.57],
	'西安\nXi\'an': [108.95, 34.27],
	'哈尔滨\nHarbin': [126.63, 45.75],
	'长春\nChangchun': [125.35, 43.88],
	'沈阳\nShenyang': [123.38, 41.8],
	'北京\nBeijing': [116.3, 39.9],
	'天津\nTianjin': [117.2, 39.13],
	'石家庄\nShijiazhuang': [114.26, 38.03],
	'济南\nJinan': [116.98, 36.67],
	'青岛\nQingdao': [120.38, 36.07],
	'太原\nTaiyuan': [112.53, 37.87],
	'郑州\nZhengzhou': [113.65, 34.76],
	'成都\nChengdu': [104.07, 30.67],
	'长沙\nChangsha': [112.59, 28.12],
	'大连\nDalian': [121.62, 38.92],
	'东莞\nDongguan': [113.23, 23.16],
	'福州\nFuzhou': [119.30, 26.08],
	'广州\nGuangzhou': [113.27, 23.13],
	'佛山\nFoshan': [113.12, 23.02],
	'贵阳\nGuiyang': [106.63, 26.65],
	'海口\nHaikou': [110.32, 20.03],
	'杭州\nHangzhou': [120.15, 30.28],
	'绍兴\nShaoxing': [120.57, 30.0],
	'合肥\nHefei': [117.27, 31.86],
	'呼和浩特\nHohhot': [111.65, 40.82],
	'泰安\nTai\'an': [117.13, 36.18],
	'昆明\nKunming': [102.72, 25.05],
	'曲靖\nQujing': [103.79, 25.51],
	'兰州\nLanzhou': [103.49, 36.03],
	'南昌\nNanchang': [115.89, 28.68],
	'南京\nNanjing': [118.78, 32.04],
	'南宁\nNanning': [108.19, 22.48],
	'宁波\nNingbo': [121.56, 29.86],
	'厦门\nXiamen': [118.10, 24.46],
	/*'泉州\nQuanzhou': [118.37, 24.54],*/
	'上海\nShanghai': [121.48, 31.22],
	'深圳\nShenzhen': [114.09, 22.63],
	'苏州\nSuzhou': [120.62, 31.32],
	'武汉\nWuhan': [114.30, 30.60],
	'银川\nYinchuan': [106.27, 38.47],
	'烟台\nYantai': [121.391, 37.5393],
    '西宁\nXining': [101.779, 36.6232],
    '大理\nDali': [100.23, 25.5916]
};

var convertData = function(data) {
	var res = [];
	for(var i = 0; i < data.length; i++) {
		var geoCoord = geoCoordMap[data[i].name];
		var src = 'image://'+webRoot+'/images/contactUs/map.png';
		var size = 20;
		if(data[i].name.indexOf('青岛') > -1){
			src = 'image://'+webRoot+'/img/logo-element.png';
			size = 30;
		}
		if(geoCoord) {
			res.push({
				symbol:src,
				symbolSize: size,
				name: data[i].name,
				value: geoCoord.concat(data[i].value),
				phone: data[i].phone,
				adress: data[i].adress
			});
		}
	}
	return res;
};

option = {
	backgroundColor: '#f9f9f9',//图标背景色
	title: {
		text: ''
	},
	tooltip: {
		trigger: 'item',
		backgroundColor:'#fff',
		borderColor:'#E5E3E0',
		borderWidth:'2',
		padding:'45',
		formatter: function (params,ticket,callback) {
            //console.log(params);
            /*if(params.name == '青岛'){
            	params.name = '青岛总公司';
            }
            else{
            	params.name = params.name + '分公司';
            }
            var res = '<h3 style="font-size:14px;">'+ params.name +'</h3>'
                    + '<p style="width:5px;height:5px;background:red;display:inline-block;border-radius:50%;margin-right:5px;"></p><span style="color:#656460;">电话：' + params.data.phone + '</span><br/> ' 
                    + '<p style="width:5px;height:5px;background:red;display:inline-block;border-radius:50%;margin-right:5px;"></p><span style="color:#656460;">地址：' + params.data.adress+ '</span>';*/
			var res = params.name;
			if(params.name.indexOf('青岛') > -1){
				res = '<h3 style="font-size:14px;">'+ params.name +'</h3>'
                + '<p style="width:5px;height:5px;background:red;display:inline-block;border-radius:50%;margin-right:5px;"></p><span style="color:#656460;">电话/Tel：0532-82881676</span><br/> '
                + '<p style="width:5px;height:5px;background:red;display:inline-block;border-radius:50%;margin-right:5px;"></p><span style="color:#656460;">地址：山东省青岛市市南区中山路44-60号百盛18楼</span><br/>'
                + '<p style="width:5px;height:5px;background:red;display:inline-block;border-radius:50%;margin-right:5px;"></p><span style="color:#656460;">Address: Parkson international business center 18th floor, <br/> &nbsp;&nbsp;44-60# zhong shan road,qingdao,Shandong</span>';
            }
            return res;
        },
		position:function(p){
			return [p[0] + 20, p[1] - 10];
		},
		textStyle:{
			color:'#000',
		}
	},
	legend: {
		orient: 'vertical',
		y: 'bottom',
		x: 'right',
		data: [''],
		textStyle: {
			color: '#fff'
		}
	},
	geo: {
		map: 'china',
		label: {
			emphasis: {
				show: false //国家、省份名称
			}
		},
		roam: false,
		itemStyle: {
			normal: {
				areaColor: '#e8e8e8',
				borderColor: '#999'
			},
			emphasis: {
				areaColor: '#aaa'//高亮背景色
			}
		}
	},
	series: [{
			name: '',
			type: 'scatter',
			coordinateSystem: 'geo',
			data: convertData(data),
			roam: true,//是否滚动拖放
			label: {
				normal: {
					formatter: '{b}',
					position:'bottom',
					show: false
				},
				emphasis: {
					show: true
				}
			},
			itemStyle: {
				normal: {
					color: '#cd2e33'
				}
			}
	}]
};
if(option && typeof option === "object") {
	myChart.setOption(option, true);
}