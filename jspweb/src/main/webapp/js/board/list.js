/**
 *
 */
function onWrite(){
	console.log('글쓰기 ');

	console.log("loginState:: "+loginState);
	if(loginState){
		//로그인이면 글쓰기 화면
		location.href="write.jsp";
	} else{ // 만약 비로그인이면 로그인페이지로 이동
		location.href="/jspweb/member/login.jsp"
	}


}