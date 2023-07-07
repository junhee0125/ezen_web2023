/**
 * 
 */
console.log('write.js파일에 연결 성공.')
//1. 썸모노트 실행할 때 사용되는 코드
$(document).ready(function() {
	$('#summernote').summernote({
	  lang: 'ko-kr', //한글적용 [한글.js cdn 필요]
	  height:500,
	  placeholder:'여기에 내용작성'	  
	 });
});
//-----------------------------------//

/*
	JS에서  HTML에 포함된 문서
		- HTML 새로고침 or 페이지 전환되면 JS도 재호출되어 저장된 데이터는 모두 지워진다. -- 메모리 휘발성
		- 영구적인 저장  = > 서버담당 = DB
		- 브라우저 저장소 : 1 세션 , 2쿠키
			세선 : 모든 브라우저 꺼지면 초기화
			쿠키 : 모든 브라우저 /OS 꺼져도 유지 /쿠키삭제
		- 사용방법 : JS에서 객체 제공 = 키와 값으로 이루어진 객체
			sesstionStorage : 세션
				sesstionStorage.setItem('키',값) : 해당 값을 '키'이름으로 저장
				sesstionStorage.getItem('키')	: 해당 키를 호출하면 저장된 값을 호출
				sesstionStorage.clear()			: 세선 스토리지 삭제
			localStorage 	: 쿠키
				localStorage.setItem('키',값)		: 해당 값을 '키'이름으로 저장
				localStorage.getItem('키')		: 해당 키를 호출하면 저장된 값을 호출
				localStorage.clear()			: 로칼스토리지 삭제			
		- Json : Js객체 문법으로 구조화된 데이터를 표현하기 위한 문자 기분의 포멧 [형식/자료형/티입]
			- 구조(모양)는 객체/배열인데 포맷형식[자료형.타입]은 문자라는 것.. 생긴건.. 객체인데..그걸 문자로 
			- 	js : {id : 'dfadf', pwd : 'dfasdf'}
 				json : " {id : 'dfadf', pwd : 'dfasdf'} "
			- 사용방법 
 				JSON.parse()	 : 문자타입을 객체/배열로 변환
 				JSON.stringify() : 객체/배열을 문자타입으로 변환
*/

//로그인제 게시판 [로그인 했다는 가정하에 로그인된 아이디를 가정하에 변수에 저장]
let loginId = 'blue1234'

//1.등록함수[실행조건 : 등록버튼을 클릭했을 때]
function onWrite(){
	//입력받은 값을 가져온다.
	let title = document.querySelector('.title').value;
	console.log('title  :  '+title);
	let content = document.querySelector('#summernote').value;
	// 유효성검사는 한다.
	//1.  기존에 쿠키에서 게시물들이 저장된 게시물배열 호출한다.
	let boardList= JSON.parse(localStorage.getItem('boardList'));
	//2. 만약에 쿠키가 존재하지 않으면 [숫자가 없다는 걸 0 / 문자가 없다는 것은 공백 / 개체가 없다면 null로 표기함]
	if(boardList==null) boardList = []
	//2-1 게시물의 번호생성하기 // 게시물이 없다면 1. 아니면 배열의 길이 +1로 세팅
	console.log('boardList.length   :'+ boardList.length);
	let no  = boardList.length == 0 ? 1 : boardList[boardList.length-1].no +1;
	//2. 입력받은 값이 여러개이면 객체화
	let board ={
		
		title : title ,
		content : content,
		no:no,
		date : `${new Date().getFullYear()}-${new Date().getMonth()+1} -${new Date().getDate()}`,	//월은 0부터 시작이라서..
		view:0,
		like:0,
		writer:loginId,
		
	} 
	
	console.log(board);
	//3. 해당 객체. 변수를 배열에 저장한다.
	/*
		함수{} 안에서 선언된 배열: 지역변수
		함수{} 밖에서 선언된 배열 : 전역변수
		세션 : 서버pc / 쿠키 : 사용자 PC : JS외 저장 가능 ->JS새로고침해도 유지
	 */
	
//	sessionStorage.setItem('세션',1)
//	localStorage.setItem('쿠키', 2)
//	console.log(1)
//	console.log(sessionStorage.getItem('세션'))
//	console.log(localStorage.getItem('쿠키'))
	/* 	
		위의 세줄을 출력하면.. 1(파랑), 1(검정), 2(검정)가 저장되는데 색이 다름 , 파랑은 숫자.
		즉 세션이나 쿠키에 저장되는 것은 문자형태만 가능하기 때문에  => 숫자 안되고.. 배열도 안되고
		
	
	*/
	
	//3 위에서 생성된  board을 boardlist저장
	boardList.push(board);
	//4. boardList를 다시 쿠키에 저장한다.
	localStorage.setItem('boardList',JSON.stringify(boardList)); // 이렇게저장하면 ...Obejct / object로 저장된걸 확인할 수 있음.
	//5.확인
	console.log(JSON.parse(localStorage.getItem(boardList)));
	// 6.글쓰기 성공했으면.
	alert('글쓰기 성공!!!');
	location.href = 'list.jsp';
	
	
}
