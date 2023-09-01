/**
 *
 */
/* onchange : 포커스(커서) 변경될때 값이 다르면 */
/* onkeyup : 키보드에서 키를 누르고 떼었을때 */
/* onkeydown : 키보드에서 키를 눌렀을때 */

/*
	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 사용되는 언어
		패턴 문법
			/^		: 정규표현식 시작 알림.
			$/		: 정규표현식 끝 알림.
			[a-z] 	: 소문자 a-z 패턴
			[A-Z]	: 대문자 A-Z 패턴
			[0-9] 	: 숫자 0~9 패턴
			\d		:
			[가-힣]	: 한글 패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			+ : 앞 에 있는 패턴 1개 이상 반복
			? : 앞 에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞 에 있는 패턴 0개 반복

			예시]
				1. [a-z]			: 소문자A-Z 패턴
				2. [a-zA-Z]			: 영문(대,소) 패턴
				3. [a-zA-Z0-9] 		: 영문 + 숫자 조합 패턴
				4. [a-zA-Z0-9가-힣] 	: 영문 + 숫자 + 한글 조합 패턴
				5. [ac]				: a와c 패턴
				6. (?=.*[패턴문자])	: 해당 패턴문자가 한개 이상 포함 패턴
					(?=.*[a-z])		: 소문자 한개 이상 필수
					(?=.*[A-Z])		: 대문자 한개 이상 필수
					(?=.*[0-9])		: 숫자 한개 이상 필수
					(?=.*\d)		: 숫자 한개 이상 필수
					(?=.*[!@#$%^&*]): 패턴문자내 특수문자 한개 이상 필수

				/^[A-Za-z0-9]{5,20}$/
				영대소문자 + 숫자 조합의 5~20글자 사이

				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 이상 필수로 갖는 5~20글자 사이

				/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{5,20}$/
				영대문자1개 + 영소문자1개 + 숫자 1개 + 특수문자 1개 이상 필수로 갖는 5~20글자 사이

			1. 	/^[a-z0-9]{5,30}$/								: 영문(소) + 숫자 조합 5~30글자 패턴
			2. 	/^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/	: 영대소문자(1개이상필수) + 숫자(1개이상필수) 조합 5~20글자 패턴
				/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
			3.  /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/	: 패턴@패턴.패턴
					// itdanja@kakao.com
					// 1. itdanja  	: 이메일 아이디부분 은 영대소문자 , 숫자 , _- 패턴
					// 2. @ 		: +@   @ 앞에 패턴이 1개이상 필수
					// 3. 도메인
						// 회사명		: @ 뒤에 그리고 . 앞에 패턴은 a-zA-Z0-9_-
						// .		: +\. : . 앞에 패턴이 1개이상 필수
						// 도메인		: . 뒤에 패턴은 a-zA-Z

		패턴 검사
			"패턴".test( 검사할데이터 )	: 해당 데이터가 패턴에 일치하면 true / 아니면 false
*/
console.log('1. 연결');
function idcheck(){
	console.log('아이디첵');
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
				data:{type:"mid", data:mid},
				success: r=>{
					console.log('통신성공'+r);

					if(r){
						idcheck.innerHTML= '사용중인 아이디입니다.'
						checkList[0] = false;
					}else {
						idcheck.innerHTML= '사용가능한 아이디입니다.'
						checkList[0] = true;
					}
				},
				error: e =>{console.log('실패');},

			});
		} else {
			idcheck.innerHTML = '영문(소문자) + 숫자조합이 5-30글자만 가능합니다.';
			checkList[0] = false;
		}
		//2.  정규표현식 검사
	//결과출력
		console.log( checkList )
}

function pwcheck(){
	console.log('비번첵');
	let pwcheckbox = document.querySelector('.pwcheckbox');

	//1. 입력값 호출
	let mpwd = document.querySelector('.mpwd').value;
	console.log( " mpwd  : "+ mpwd );
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	console.log( " mpwdconfirm  : "+ mpwdconfirm );

	//2 유효성검사
		// 1.정규표현식 만들기 [영대소문자 (각각1개 필수) + 숫자 1개필수  조합 + 5-20글자 사이 ]
		//let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20)}$/
		let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
		console.log( " mpwdj   : " + mpwdj.test(mpwd));
		if(mpwdj.test(mpwd)){ //비밀번호 확인
			console.log("비밀번호 체크");
			if(mpwdj.test(mpwdconfirm)){ //비밀번호확인란
				console.log("비밀번호확인 체크");
				if(mpwd == mpwdconfirm){ //비밀번호란과 비밀번호 재확인용 란의 일치여부
					console.log("비밀번호 일치");

					pwcheckbox.innerHTML = `사용가능한 비밀번호`;
					checkList[1] = true;
				} else {
					pwcheckbox.innerHTML = `비밀번호가 일치하지 않습니다.`;
					checkList[1] = false;
				}
			} else{
				pwcheckbox.innerHTML = `영문 대문자1, 소문자 1개이상, 숫자 1개이상  조합 5-20자 이내로 입력하세요`
				checkList[1] = false;
			}
		}else{
			pwcheckbox.innerHtml = `영문 대문자1, 소문자 1개이상, 숫자 1개이상  조합 5-20자 이내로 입력하세요`
			checkList[1] = false;
		}
		console.log( checkList )
}

//3. 이메일 유효성 검사[1. 정규표현식, 2 중복검사]

function emailcheck(){
	console.log('이메일첵');
	let emailcheckbox = document.querySelector('.emailcheckbox');
	let authReqBtn = document.querySelector('.authReqBtn');

	//1. 입력된 이메일 정보 가져오기
	let memail = document.querySelector('.memail').value;

	// 2. 정규표현식 - 이메일 주소의 로컬 파트, @ 기호, 도메인 파트(1차 및 최상위 도메인)의 형식
    //let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/

	//3. 유효성검사
	if(memailj.test(memail)){ //정규표현식에 맞으면.

		$.ajax({
			url: "/jspweb/MemberFindController",
			method:"get",
			data:{type:"memail",data:memail},
			success: r=>{
				if(r){
					emailcheckbox.innerHTML = `사용중인  이메일입니다.`;
					authReqBtn.disabled = true;
					checkList[2] = false;
				}else{
					emailcheckbox.innerHTML = `사용가능한 이메일입니다.`
					authReqBtn.disabled = false;
					checkList[2] = false;
				}
			},
			error: r=>{
				console.log(" 통신실패 "+ r);
			}
		});

	} else {
		emailcheckbox.innerHTML = `이메일 형식에 맞게 입력해주세요`;
		authReqBtn.disabled=true;
		checkList[2] = false;
	}
	console.log( checkList )
}

/*4~  6번 함수에서 공통으로 사용할 변수선언*/
let authcode='';	//인증코드
let timer=0;		//인증시간
let timerInter;		//setInterval  함수를 가지고있는 변수 [ setInterval종료시 필요]

//4.  인증요청 버튼을 눌렀을 때
function authReq(){
	console.log('인증요청');

	// 1. authbox div 호출
	let authbox = document.querySelector('.authbox');

	// 2. authbox 안 html구성
	let html = `<span class="timebox">02:00</span>
		  		<input class="ecode" type="text">
		  		<button onclick="auth()" type="button" >인증</button>`

	// 3.authbox에 html대입
	authbox.innerHTML = html;

	// 4. 타이머 실행
	authcode = '1234' // 테스트용 인증코드 1234
	timer = 120;		//테스트용 제한시간 10초
	settimer();  	// 타이머함수 호출

	/*
	$.ajax({
		url:"/jspweb/AuthSendEmailController",
		method:"get",
		data:{memail : document.querySelector('.memail').value},
		success: r =>{
			console.log("통신성공 : " + r);
			// 1. authbox div 호출
			let authbox = document.querySelector('.authbox');

			// 2. authbox 안 html구성
			let html = `<span class="timebox">02:00</span>
				  		<input class="ecode" type="text">
				  		<button onclick="auth()" type="button" >인증</button>`

			// 3.authbox에 html대입
			authbox.innerHTML = html;

			// 4. 타이머 실행
			authcode = '1234' // 테스트용 인증코드 1234
			timer = 120;		//테스트용 제한시간 10초
			settimer();  	// 타이머함수 호출
		} ,
		error:e=>{
			console.log('통신실패 '+ e)
		}

	});
	*/
}

//5. 인증확인 제한시간 타이머
function settimer(){
	console.log('타이머호출');
	timerInter= setInterval(()=>{

		//시간형식 만들기
			//1 분만들기 [초 / 60] => qns / 초 % 60 => 나머지초
		let m = parseInt(timer / 60); //분
		let s = parseInt(timer % 60);  //초

		//두자리수 맞춤 3이면 03이 되게
		m = m < 10 ? "0" + m: m; //10보다 작으면 0을 덧붙임
		s = s < 10 ? "0" + s: s;

		//timebox에 00:00 형식으로 html작성
		document.querySelector('.timebox').innerHTML =`${m}:${s}`;
		timer--;

		//타이머가 0보다 작으면 종료
		if(timer < 0){
			//setInterval 종료  #clearInterval(종료할 식별자,변수)
			clearInterval(timerInter);

			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML =`인증실패`;
			checkList[2] = false;

			// 3. authbox구역 초기화
			document.querySelector('.authbox').innerHTML = ``;
		}
 	},1000)
 	console.log( checkList )
}

//6. 인증요청후 인증코드릉 입력하고 일치여부 확인 함수
function auth(){
	console.log('인증코드 체크');

	//1. 입력받은 인증코드
	let ecode = document.querySelector('.ecode').value;

	//2. 비교
	if(authcode == ecode){
		clearInterval(timerInter);
		document.querySelector('.emailcheckbox').innerHTML = `인증성공`;
		checkList[2] = true;
		document.querySelector('.authbox').innerHTML=``; //authbox초기화
	} else {
		document.querySelector('.emailcheckbox').innerHTML = `인증코드 불일치`;
		checkList[2] = false;
	}
	console.log( checkList )
}


// 7. 첨부파일에 사진 등록시 등록된 HTML사진을 띄우기 <등록사진 미리보기> 1개만 등록하고 1개만 미리보기
function preimg(object){
	console.log('바뀔때마다. 사진미리보기 preimg()호출됨');
	console.log(object);
	console.log(document.querySelector('.mfile'));

	//.files: input type:="file"에 선택한 파일 정보를 리스트로 받음
	console.log(object.files);
	console.log("object.files[0] >>>"+object.files[0]); // 리스트중 하나의 파일만 가져오기

	// 해당 파일을 바이트코드로 변환
	//2. JS파일클래스 선언
	let file = new FileReader(); //파일 읽기
	file.readAsDataURL(object.files[0]);
	console.log(object.files[0]);
	//읽어온 파일 해당 html에 img태그에  load
	file.onload = e=>{
		console.log('e  : >>> '+ e);
		console.log('e.target  : >>> '+ e.target);
		console.log(".target.result >>>" + e.target.result);
		document.querySelector('.preimg').src = e.target.result;
	}
}


//8. 회원가입메소드
/*
 	아이디 = 사용가능한 ~
 	비밀번호 : 사용가능한~
 	이메일: 인증성공~
 	위 세가지 충족해야.
 */
// [0] : 아이디통과여부 , [1] : 패스워드통과여부 , [2] : 이메일통과여부
let checkList = [false, false, false]

function signup(){
	console.log('signup');
	console.log("[  checkList ] :  " + checkList[0] +"  |  "+checkList[1] +"  |  "+checkList[2]);

	if(checkList[0] && checkList[1]&& checkList[2]){
		console.log(' 회원가입 진행 가능');
		//2. 입력받은 데이터를 한번에 가져오기 form태그이요
		// <form>	~ </form>
		//document.querySelectorAll('폼 식별자');
		let signupForm= document.querySelectorAll('.signupForm')[0];
		//console.log("signupForm : "+ signupForm);
		//let signupForm0 = signupForm[0]; //폼 자기자신을 가져옴.

		//2. 폼데이터 객체화 = ajax는  json형식으로 해야하기 때문에
			// 일반객체로는 첨부파일을 전송할 수 없어. FormData() 객체이용시 첨부파일 전송가능
		let signupData = new FormData(signupForm); //첨부파일[대용량]시엔 필수
		console.log(signupData);

		//3.  Ajax 에게 첨부파일 전송하기
			//1. 첨부파일 없을때.
//		$.ajax({
//			url:"".
//			method:"",
//			data:"",
//			success:r=>{console.log(r)},
//			error:r=>{console.log(r)}
//
//
//		});
		//2. 첨부파일 있을때
		$.ajax({
			url:"/jspweb/MemberInfoController",
			method:"post",
			data:signupData,
			contentType:false,		//false: form객체 [대용량]전송타입/ true:문자열 전송타입
			processData:false,
			success:r=>{
				console.log("success :: "+r)
				if(r){
					alert('회원가입성공');
					location.href='/jspweb/member/login.jsp';

				}else{
					alert('회원가입실패[관리자문의]')
				}

			},
			error:e=>{console.log("error ::" + e)}


		});


	} else {
		alert('정상적으로 입력되지 않은 내용이 있습니다.');
	}
}

/* 유효성 검사없는 회원가입
function signup(){
	console.log('회원가입 등록');
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
		success: r=>{
			console.log('통신성공 : '+ r)
			midInput.value='';
			mpwdInput.value='';
			mpwdconfirmInput.value='';
			memailInput.value='';
			mfileInput.value=''

		},
		error:r=> {console.log ('통신실패 :' + r)}

	});

	//응답에 따른 제어

}*/

/*

setInterval() : 특정시간마다 함수를 실행 함수
	1. 정의
		let 변수명 = setInterval( functuon 함수명(){ } , 밀리초 )
		let 변수명 = setInterval( functuon (){ } , 밀리초 )
		let 변수명 = setInterval( 함수명() , 밀리초 )
		let 변수명 = setInterval( () => { } , 밀리초 )
	2. 종료
		clearInterval( setInterval변수명 )

*/