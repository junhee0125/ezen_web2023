/**
 *
 */
console.log("js파일연결");


/* 원그래프 */
var pieData = {
	labels:['웹디자인','웹개발자','서버엔지니어','영업직'],
	series:[14,9,,8,6]
}

var pieOptions={
		width:'100%',
		height:'440px'
};

new Chartist.Pie('.pie-chart',pieData,pieOptions);

/*막대 그래프*/
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