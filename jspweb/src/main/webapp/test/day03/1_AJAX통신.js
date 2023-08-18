/**
 * 
 */
console.log("1_AJAX통신.js 연결");
function 예제1(){
	$.ajax({
		url:"http://localhost/jspweb/Test06",
		data:{'value1':'jsdata'},
		method:"get",
		success:function 함수 (result){
			console.log( " result : "+result);},
		error:function 함수 (result){console.log( " result : "+result);},
	
		
		
	});
}	
	/*	[원형]
		$.ajax({
			url:"" ,	 									# 통신할  HTTP주소
			data:{},										# 보내는 데이터
			method:"",										# POST GET PUT DELETE
			success: function 함수 (result){return result;} ,	# 통신에 성공했을 때
			error: function 함수 (result){return result;}, 	# 통신에 실패했을 때
		});
	 */
	
	function 예제2(){
		let nameData= document.querySelector('.name').value;
		let ageData= document.querySelector('.age').value;
		let info = {
			name: nameData,
			age : ageData
		}
		
		$.ajax({
			url:"http://localhost/jspweb/Test07" ,	
			data: info, 										
			method:"get",										
			success: function 함수(result){
				console.log('통신 성공 >ㅂ<');
			} ,	
		});
	}
	

	
