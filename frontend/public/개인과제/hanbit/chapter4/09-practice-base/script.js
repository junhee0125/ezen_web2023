/*
- 고양이 35%, 개 30%, 기린 20%, 그 외 15%
- 원 그래프 옵션에는 폭 100%, 높이 300px 로 설정
*/

/*
PIE CHART
================================================ */
var pieData = {
  labels: ['고양이', '개', '기린', '그외'],
  series: [35, 30, 20, 15]
};

var pieOptions = {
  width: '100%',
  height: '300px'
};

new Chartist.Pie('.animal-chart', pieData, pieOptions);

