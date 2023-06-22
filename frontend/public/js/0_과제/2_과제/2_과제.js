/**
 * - 파일명 : 과제2.html / 과제2.js / 과제2.css
-------------------------------------------------------------------
요구사항1 : 아이디와 비밀번호를 입력받아 회원가입을 진행하고 싶어요.
   [조건1]
      입력 <input> 사용 해서 아이디 입력받기
      입력 <input> 사용 해서 비밀번호 입력받기
   [조건2]
      * 1차원배열만 사용 [ 배열 변수 여러개 사용 가능 ]
   [조건3]
      <input type="button"> 사용해서 회원가입 이벤트 실행 [ 회원가입함수 구현하기 ]

-------------------------------------------------------------------
요구사항2 : 아이디와 비밀번호를 입력받아 로그인 을 진행하고 싶어요.
   [조건1]
      입력 <input> 사용 해서 아이디 입력받기
      입력 <input> 사용 해서 비밀번호 입력받기
   [조건2]
      만약에 배열에 존재하는 아이디,비밀번호가 일치한 데이터가 있을경우
      [ 로그인 성공 ] 아니면  [ 로그인 실패 ] alert 로 출력해주세요.
   [조건3]
      <input type="button"> 사용해서 로그인 이벤트 실행    [ 로그인함수 구현하기 ]
------------------------------------------------------------------------
요구사항3 : 유효성검사 진행해주세요.
   1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~       [ if( sno2Value == '' ) ]
   2. 회원가입 이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화 해주세요.   [ sno2.value = '' ]
   3. 입력상자[input]에 입력한 아이디 와 비밀번호 가 8자리가 이상일경우에만 회원가입하도록 해주세요.   [ sno2Value.length !=8  ]

요구사항4 : 기본적인 css 작업해주세요
   1. (필수) div 2개를 만들어서 [ 왼쪽은 회원가입 구역 ] [ 오른쪽은 로그인 구역 ]
   2. 그외 이쁘게 꾸며주세요.
 */

let arrId = []
let arrPwd = []

function signup() {
	//회원가입 화면 input 박스에 입력된 아이디와 비밀번호의  값을 각각  mem_id / mem_pwd에 저장
	let memId = document.querySelector('.s_id').value
	let memPwd = document.querySelector('.s_pwd').value

	if( memId =='' || memPwd =='' ) {
		if( memId =='') {//입력상자에 공란이면 alert메시지 띄우기
			alert('아이디를 입력하세요.');
		} else {
			alert('비밀번호를 입력하세요')
		}

	} else if ( memId.length < 8 || memPwd.length < 8 ) { //8자 미만이면  메시지
		if(memId.length < 8){
			alert('아이디는 8자 이상 입력해주세요.')
		} else {
			alert('아이디는 8자 이상 입력해주세요.')
		}

	} else { // 아이디가 공란이 없고, 8자 이상 입력한경우 저장
		//console.log('mem_id : ' +memId)
		//console.log('mem_pwd : '+memPwd)
		arrId.push(memId)
		arrPwd.push(memPwd)
		console.log(arrId)
		console.log(arrPwd)
		document.querySelector('.s_id').value =''
		document.querySelector('.s_pwd').value =''
	}
} //f end

function login() {
	let loginId = document.querySelector('.login .id').value
	let loginPwd = document.querySelector('.login .pwd').value

	let indexId = arrId.indexOf(loginId)
	let indexPwd = arrPwd.indexOf(loginPwd)
	
	if(indexId = ''){alert('아이디를 입력하세요')}
	if(indexPwd = ''){alert('비밀번호를 입력하세요')}

	if(indexId != -1  && indexPwd !=-1){ // 아이디와 패스워드의 인덱스가 모두 존재하면
		if(indexId == indexPwd) { //아이디와 패스워드의 인덱스가 일치하는지.
			alert('로그인 성공')
		} else {
			alert('로그인 실패')
		}
	} else if (indexId != -1 && indexPwd == -1) {
		alert('아이디와 패스워드가 일치하지 않습니다.')
	} else { alert('아이디가 존재하지 않습니다.')}

	document.querySelector('.login .id').value =''
	document.querySelector('.login .pwd').value =''
}

