/**
 *
 */
function login(){
	console.log('로그인()');
	// 1. 입력받은 아이디와 비밀번호를 가져온다

	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	console.log(mid);
	// 2. ajax에게 전달해서 회원이 존재하는지 반환 받는다.

		// 로그인 성공시 : index.jsp로 이동
	$.ajax({
		url:"/jspweb/MemberFindController",
		method:"post",
		data:{mid:mid, mpwd:mpwd},
		success:r=>{
			console.log(r)
			if(r){
				location.href='/jspweb/index.jsp';

			}else{
				document.querySelector('.logincheckbox').innerHTML = '회원정보가 일치하지 않습니다. ';
			}
		},
		error:r=>{console.log(r)}

	})


		// 로그인 실패시 : c
}
/*
GET vs POST

	GET : http://localhost/jspweb/MemberFindController?mid=asdas&mpwd=asdasd;
		- 캐시(기록O)
		- 추후에 다시 전송시 속도 빠름
		- 보완 불가능
		- 매개변수 노출O
		- 개인정보 없는 데이터 정보 (권장)

	POST : http://localhost/jspweb/MemberFindController
		- 캐시(기록X)
		- 추후에 다시 전송시 속도 동일
		- 보안 가능
		- 매개변수 노출X
		- 로그인 , 회원가입 (권장)
*/