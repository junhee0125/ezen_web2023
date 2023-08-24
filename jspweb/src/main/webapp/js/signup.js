/**
 * 
 */
/*
	onchange : 포커스(커서) 변경될때 값이 다르면
	onkeyup : 키보드에서 키를 누르고 떼었을때
	onkeydown : 키보으에서 키를 눌렀을때
*/ 
/*

	정규표현식 : 문자열에 특정규칙 / 패턴 집합 표현할때 사용되는 언어
		문법 : 
		/^ : 정규표현식 시작 알림
		$/ : 정규표현식 끝 알림
		[a-z] : 소문자  a- z패턴 검색
		[A-Z] : 대문자 A-Z패턴 검색
		[0-9] "숫자" 0~9 패턴 검색
		[가~힣]: 한글패턴 
		{ 최소길이, 최대길이} : 문자열 길이 패턴
		
		예시]
			1. [a-z]	: 소문자 A-z 패턴
			2. [a-zA-Z]	: 영문자(대, 소)voxjs
		
		/^[a-z0-9]{5,30} $/  // 영문(소) + 숫자조합 5-30자 패턴
		
		패턴검사
		"패턴".test(검사할데이터)  : 해당 데이터

*/

console.log('1. 연결');
function idcheck(){
	console.log("");
	//입력값 가져오기
	let mid = document.querySelector('.mid').value;
	let idcheck = document.querySelector('.idcheckbox');
	//유효성검사
		//if (mid.length <=5 || mid.length > 30){}
		// 1. 아이디, 영문(소문만)숫자 조합의 5~30자 사이면
		let midj = /^[a-z0-9]{5,30}$/  //
		console.log("mid :  "+ midj.test(mid))
		if(midj.test(mid)){
			idcheck.innerHTML ='패턴성공';
			//패턴일치하면 아이디 중복검사
			$.ajax({
				url: "/jspweb/MemberFindController",
				method:"get",
				data:{mid:mid},
				success: r=>{
					console.log('통신성공'+r);
					
					if(r){idcheck.innerHTML= '사용중인 아이디입니다.'}
					else {idcheck.innerHTML= '사용가능한 아이디입니다.'}
				},	
				error: e =>{console.log('실패');},		
				
			});
		} else {
			idcheck.innerHTML = '영문(소문자) + 숫자조합이 5-30글자만 가능합니다.';
		}
		//2.  정규표현식 검사 
	//결과출력
	
}

function signup(){
	
	//1. html애 가져올 데이터의 Tag객체 호출 [Dom객체:html태극ㄱ체ㅐ화]

	let midInput = document.querySelector('.mid');	
	let mpwdInput = document.querySelector('.mpwd');	
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm');	
	let memailInput = document.querySelector('.memail');	
	let emailconfirmInput = document.querySelector('.emailconfirm');	
	let mfileInput = document.querySelector('.mfile');	
	
	// 2객체화
	let info = {
		mid:midInput.value,
		mpwd:mpwdInput.value, 
		memail:memailInput.value ,
		mfile:mfileInput.value
	}
	//유효성검사
	$.ajax({
		
		url: "/jspweb/MemberInfoController",
		method:"post",
		data:info,
		success: r=>{console.log('통신성공')},
		error:r=> {console.log ('통신실패')}
		
	});
	
	//응답에 따른 제어ㅗ
	
	
	
	
}