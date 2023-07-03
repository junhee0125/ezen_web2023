/**
	이벤트 함수
	HTML 이벤트 적용방법
	1. <태그 이벤트속서염ㅇ = "함수명()" ></태그명>
	2. 
		1. document.addEventListener('이벤트명', 함수) // 기존 함수명 적묭
		2. document.addEventlistener('이벤트명', (인수)=>{ 	실행코드 })
		3. document.addEventListener('이벤트명', function(){})
		4. document.addEventListener('이벤트명', (e)=>{})
		
	3. 이벤트
 		이벤트명
		1. DOMContentLoaded : HTML이 완전히 열렸을때[모두 로드되었을때] 실행되는 이벤트
		2. window.onload	: 해당 객체가 호출 되었을때
		3. click			: 해당 객체를 클릭했을때
		4. keyup			: 해당 객체에서 키보드를 누르고 떼어있을때
		5. keydown			: 해당 겍체에서 키보드를 눌렀을때
			- e.keyCode		: 입력된 키코드번호 


 */
console.log('javascript linked')

//1. 
let text = document.querySelector('.textbox')
	text.addEventListener('keyup',()=>{
		console.log('키보드 입력하고 떼어있을 때 출력')
		
		let h3 = document.querySelector('.h3box')
		console.log(text.value.length);
		h3.innerHTML =`입력된 문자 길이 : ${text.value.length}`
});



//2. 
let moving = document.querySelector('.moving'); //버튼의 태그 호출
moving.style.position = `absolute`; // style속성 이용한  css추가

	//1.DOM객체명.style = `속성명 : 값, 속성명: 값`;
	//2.DOM객체명.style.css속성명 = `값`; 
	// **** css속성명 작성시 카멜표기법으로 사용 ex) background-color = > backgroundColor
	
	//버튼 위치의 초기값. x가로축, y세로축 block = 이동단위[30px씩 이동]
	let x = 8; 
	let y = 0;
	let block = 30;
	movingPrint();
	
	//1. 버튼 위치 출력함수
	function movingPrint(){
		moving.style.left = `${x * block}px`
		moving.style.top = `${y*block}px`
	}
	
	//2. 이동 이벤트 함수 [ 만약에 본문에서 키다운을 누르면 ]
	document.body.addEventListener('keydown', (e)=>{
		//e: keydown 이벤트 결과 정보 담고있는 객체
		//만약에 이동상태(control)이 true에만 가능
		//1. 만약에 key
		if( control == true) {
			
			let key = e.keyCode;
			console.log(key);
		
			//왼쪽 37 위쪽38 오른쪽39 아래쪽 40
			if(key == 37){	x --; }
			else if(key == 38){ y--; }
			else if(key == 39){ x++; }
			else if(key == 40){ y++; }
			
			//relandering
			movingPrint();
		}
		
			
	}) //f end
	
let control = true;  //버튼 이동상태 저장 변수 [ true = 이동. false = 이동불가 ]
moving.addEventListener('click', ()=>{
	console.log(control)
	control = !control;
	
	if(control) moving.innerHTML = '배치하기';
	else moving.innerHTML = '이동하기'
	
}) 