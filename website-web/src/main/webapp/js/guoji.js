		var dom = document.getElementById("main2");
		var myChart = echarts.init(dom);
		var app = {};
		option = null;
		var data = [
			{ name: '海门', value: 9 },
			{ name: 'beijing', value: 12 },
			{ name: "加拿大", value: 30 },
			{ name: "美国", value: 100 },
			{ name: "澳大利亚", value: 95},
			{ name: "瑞士", value: 60 },
			{ name: "日本", value: 30}
		];
		var geoCoordMap = {
			'海门': [121.15, 31.89],
			'beijing': [120.38, 37.35],

			'美国': [-100.696295, 33.679979],
			'日本': [139.710164, 35.706962],
			'瑞士': [7.445147, 46.956241],
			'澳大利亚': [135.193845, -25.304039],
			'加拿大': [-102.646409, 59.994255]
		};

		var convertData = function(data) {
			var res = [];
			for(var i = 0; i < data.length; i++) {
				var geoCoord = geoCoordMap[data[i].name];
				if(geoCoord) {
					res.push({
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
			backgroundColor: '#f9f9f9',
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
		            /*var res = '<h3 style="font-size:14px;">'+ params.name +'</h3>'
		                    + '<p style="width:5px;height:5px;background:red;display:inline-block;border-radius:50%;margin-right:5px;"></p><span style="color:#656460;">电话：' + params.data.phone + '</span><br/> ' 
		                    + '<p style="width:5px;height:5px;background:red;display:inline-block;border-radius:50%;margin-right:5px;"></p><span style="color:#656460;">地址：' + params.data.adress+ '</span>';*/
		            var res = params.name;
		            return res;
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
				map: 'world',
				label: {
					emphasis: {
						show: false
					}
				},
				roam: false,
				itemStyle: {
					normal: {
						areaColor: '#e8e8e8',
						borderColor: '#999'
					},
					emphasis: {
						areaColor: '#aaaaaa'
					}
				},
				/*regions: [{ // 选中的区域
					name: 'China',
					selected: true,
					itemStyle: { // 高亮时候的样式
						emphasis: {
							areaColor: '#cd2e33'
						},

					},
					label: { // 高亮的时候不显示标签
						emphasis: {
							show: true
						}
					}
				}]*/
			},
			series: [{
					name: '',
					type: 'scatter',
					coordinateSystem: 'geo',
					data: convertData(data),
					symbolSize: 20,
					symbol:'image://'+webRoot+'/images/contactUs/map.png',
    				roam: true,//是否滚动拖放
					label: {
						normal: {
							formatter: '{b}',
							position: 'right',
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
		};;
		if(option && typeof option === "object") {
			myChart.setOption(option, true);
		}