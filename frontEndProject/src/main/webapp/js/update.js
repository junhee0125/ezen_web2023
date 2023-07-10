/**
 * 
 */
console.log('update.js파일에 연결 성공.')
//1. 썸모노트 실행할 때 사용되는 코드
$(document).ready(function() {
	$('#summernote').summernote({
	  lang: 'ko-kr', //한글적용 [한글.js cdn 필요]
	  height:500,
	  placeholder:'여기에 내용작성'	  
	 });
});

//로그인제 게시판 [로그인 했다는 가정하에 로그인된 아이디를 가정하에 변수에 저장]
let loginId = 'blue1234'
//세션 스토리지에 저장되어있는 no을 가져오기
let no = JSON.parse(sessionStorage.getItem('no'));
let boardList = JSON.parse(localStorage.getItem('boardList'))
console.log(' JSON.parse(sessionStorage.getItem(no)   :  '+no)
//1.등록함수[실행조건 : 등록버튼을 클릭했을 때]

onView();

function onView(){
	for(let i = 0 ; i < boardList.length ; i++) {
		let title = document.querySelector('.title');
		let content = document.querySelector('#summernote');
		if(boardList[i].no == no){
			console.log('찾았다. >> '+ no +'<< 게시물 데이터')
			// div와 같이 value속성이 없는 경우엔 innerHTML을 사용 ,
			// input textarea같은 경우는  value로 넣어준다.
			title.value = boardList[i].title; 
			content.value = boardList[i].content;
			break; //반복문 종료
		}
	}
}

function onUpdate(){
	
	for(let i = 0 ;i < boardList.length ; i++){
		if(boardList[i].no == no ){
			
			//입력받은 값을 가져온다.
			let title = document.querySelector('.title').value;
			let content = document.querySelector('#summernote').value;
			
			boardList[i].title = title;
			boardList[i].content = content;
			
			//쿠키 세션 사용중이라면. 쿠키 세션 어베이트 새롭게 대입
			localStorage.setItem('boardList', JSON.stringify(boardList));
			alert('수정했습니다.');
			location.href = 'view.jsp';
		}
	}
}
