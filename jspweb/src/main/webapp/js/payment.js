/**
 * 
 */
console.log("연결");

//setPoint(1000, '회원가입축하');
//setPoint(-500, '이모티콘 구매');
getPoint();
getPointList();
//1. 포인트 사용 함수[mno는 서블릿이(로그인 세션이ㅣ 알고 있다)]
function setPoint(mpamount, mpcomment){
	console.log("setPoint");
	
	//로그인 안한경우
	if( loginState == false ){
		alert('로그인후 가능한 기능입니다.'); 
		location.href='/jspweb/member/login.jsp' 
	}

	
	$.ajax({
		url:"/jspweb/MpointController",
		method:"post",
		data: {mpamount:mpamount, mpcomment:mpcomment},
		success: r => {console.log( "서블릿결과" + r)},
		error : e => {console.log( "에러" + e)} 
	});
	
	
}
//2. 내 포인트 확인함수
function getPoint(mpamount, mpcomment){
	//로그인 안한경우
	if( loginState == false ){
		alert('로그인후 가능한 기능입니다.'); 
		location.href='/jspweb/member/login.jsp' 
	}
	
	$.ajax({
		url:"/jspweb/MpointController",
		method:"get",
		data: {type:'getPoint'},
		success: r => {console.log( "서블릿결과" + r)},
		error : e => {console.log( "에러" + e)} 
	});
	
	
}

//3. 내 포인트 내역 전체 출력 함수
function getPointList(mpamount, mpcomment){
	//로그인 안한경우
	if( loginState == false ){
		alert('로그인후 가능한 기능입니다.'); 
		location.href='/jspweb/member/login.jsp' 
	}
	
	$.ajax({
		url:"/jspweb/MpointController",
		method:"get",
		data: {type:'getList'},
		success: r => {console.log( r)},
		error : e => {console.log( "에러" + e)} 
	});
	
	
}