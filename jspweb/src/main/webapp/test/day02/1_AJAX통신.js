/**
 * 
 */
console.log("JS연결");
//예제1
function 예제1(){
	$.ajax({
		//url:"http://localhost/jspweb/Test02",
		url:"/jspweb/Test02",
		method:"get",
		success:function 함수명(result){console.log(result)}	
	});
}
function 예제2(){
	$.ajax({
		//url:"http://localhost/jspweb/Test03",
		url:"/jspweb/Test03",
		method:"get",
		success:function 함수명(result){console.log(result)}
		
	});
}

function 예제3(){
	$.ajax({
		//url:"http://localhost/jspweb/Test04",
		url:"/jspweb/Test04",
		method:"get",
		success:function 함수명(result){console.log(result)}
		
	});
}

function 예제4(){
	$.ajax({
		//url:"http://localhost/jspweb/Test05",
		url:"/jspweb/Test05",
		method:"get",
		success:function 함수명(result){console.log(result)}
		
	});
}
/*
	$.ajax({
		url : "",
		method : "통신방법 : get,post, put, delete 선택",
		success: function 함수명(통신반환변수){통신성공했을때 실행코드}
	});
	-1. success/error 속성에서 반환함수 작성방법
		1.success: funtion함수명 (통신반환변수){통신성공했을때 실행코드}
		2.success: funtion(통신반환변수){통신성공했을때 실행코드}
		3.success: (통신반환변수)=>{통신성공했을때 실행코드}
		
---------------------------------------------------------------------
서블릿
		- 응답객체 " 요청겍체"
		-response " 응답객체"
			- response.getWriter().append(데이터)
			response.setContentType(타입명;incofrding tyeoe);
			- 문자전종[default]
			 response.setContentTyle("text/html;charset=UTF-8"")
			 
---------------------------------------------------------------------
JACJSON : 자바객체를 제이슨혀잇ㄱ에 대한 다양한 클레스 제공 라이브러리
	ObjectMapper클래스 : JAVA객체를  Json형식으로 변환해주는 
*/