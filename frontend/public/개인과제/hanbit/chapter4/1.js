/**
 * 
 */
var ctx = document.getElementById('myChart')
var myDoughnutChart = new Chart(ctx, {
	
	type:'doughnut',
	data:{
		labels:["딸기","포도","바나나"],
		datasets:[
			{
				data:[300,100,80],
				backgroundColor:["#f66","#c7e","#fc2"]
			}
		]
	}
	
});