/**
 * 
 */
console.log("JS실행")
function 예제(){
	console.log("함수 연결");
	
	/*
		https://jsonplaceholder.typicode.com/
		
		외부링크 사이트Json 데이터통신
		AJAX : jQuery라이브러리에서 통신  HTTP합수 제공
			jQuery : JS언어에서 외부와 통신하는 목적
		1. 정의 :JS언어에서 외부와 통신하는 목적
		2. 형태: $.ajax();
		3.필수!!: jQuery라이브러리
		4.매개변수 : 객체{속성 : 값, 속성 : 값... 
			
			1.url속성 :  통신할 대상/링크/ 주소
			2.HTTP통신메소드 : post, get, put, delete 등등
			
	 */
	$.ajax( { 
		url : "https://jsonplaceholder.typicode.com/posts",
		method:"get",
		success:function(result){console.log(result);}
		});
	
}

function 예제2(){
	$.ajax( { 
      url : "/jspweb/Test01"  ,    // 1. 통신할 경로
      method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      success : function 결과( result ){ console.log(result); }   // 3. 통신을 성공했을때 반환된 데이터
   });
}