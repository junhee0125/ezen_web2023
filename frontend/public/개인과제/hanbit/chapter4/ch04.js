/**
 *
 */
console.log("js파일연결");

var pieData = {
		  labels: ['웹디자이너', '웹개발자', '서버 엔지니어', '영업직'],
		  series: [14, 9, 8, 6]
		};

		var pieOptions = {
		  width: '100%',
		  height: '440px'
		};

		new Chartist.Pie('.pie-chart', pieData, pieOptions);

		/*
		BAR CHART
		================================================ */
		var barData = {
		  labels: ['2018년', '2019년', '2020년'],
		  series: [[10, 16, 29]]
		};

		var barOptions = {
		    axisY: {
		        offset: 60,
		        scaleMinSpace: 50,
		        labelInterpolationFnc: function(value) {
		          return value + ' 명'
		        }
		    },
		    width: '100%',
		    height: '400px'
		};

		new Chartist.Bar('.bar-chart', barData, barOptions);/*막대 그래프*/
var barData = {
		lavels: ['2018년','2019년','2020년'],
		series: [[10,16,29]]
};
var barOptions = {
		axisY:{
			offset:60, 			/*막대사이 간격*/
			scaleMinSpace:50, 	/*그래프 선 간격*/
			labelInterpolationFnc : function(value){
				return value+' 명'
			}
		},
		width:'100%',
		height:'400px'
};

new Chartist.Bar('.bar-chart', barData, barOptions);