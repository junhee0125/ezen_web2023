/**
 *
 */
console.log("JS연결");

let currentPage = 1; // 현재 페이지 초기값 설정
let sections= document.querySelectorAll('.section')
let visibleSection;
let isWheeling = false;

let bgimgList=['main_01.jpg','main_02.jpg','main_03.jpg','main_04.jpg','main_05.jpg'];
let bgtxtList=['main_text_01.png','main_text_02.png','main_text_03.png','main_text_04.png','main_text_05.png'];

// # 1 백그라운드 이미지 랜덤하게 가져오기
//let currentImg = 1 ; // 현재 보여지는 bgImg


let currentImg = document.querySelector('.intro');
let currentTxt = document.querySelector('.mtxt');
var pBtn = document.querySelectorAll('.pagination'); //

// # intro페이지의 backgroundImage,textImage 랜덤하게 가져오기
let rNum = Math.floor(Math.random() * 5); //0~4
//console.log("rNum : "+rNum);
currentImg.style.backgroundImage = `url(./images/${bgimgList[rNum]})`;
currentTxt.src = `./images/${bgtxtList[rNum]}`;

console.log(" currentPage  : "+currentPage)


//F5키를 누르면
document.addEventListener('keydown', function(event) {
	if (event.keyCode === 116) {
		event.preventDefault(); 	// 기본 동작막기
		window.scrollTo(0, 0); 		// 화면을 맨 위로 스크롤
		location.reload(); 			// 페이지 새로고침
	}
});



/*
	휠 이벤트의  deltaY(수직스크롤)값을 읽어와서
	값이 양의 값이면 스크롤이 아래방향으로 1개씩 증가하되
	(음의 값인경우  페이지는 1씩 감소해서 스크롤이 올라갈수 있게함)
	디바이스의 innerHeight 만큼
	부드럽게 스크롤되도록 하는 함수
	한번 휠을 작동하면 100ms뒤에 isWheeling을 false로 변경해서
	휠이 여러번 적용되더라도 한번으로 인식할 수 있도록 함
*/

// # 휠이벤트 : 마우스 휠이 아래 혹은 위쪽 방향으로 스크롤되면 디바이스 innerHeight만큼 이동
// : 휠이(드르륵) 여러번 움직여질 경우 처음의 움직임을 한번으로 카운트함.
// 스크롤이 될때 페이지에 따라 감추거나 나타나게 할 요소들 처리
function handleWheel(event) {
	if (isWheeling) return; //isWheeling= true이면 함수종료
	//console.log("isWheeling1" +isWheeling);
	window.addEventListener("wheel", function(e){ //브라우저의 기본동작 막기
		e.preventDefault();
	},{passive : false});

	isWheeling = true;
	//console.log("isWheeling2" +isWheeling);
	const delta = Math.sign(event.deltaY); // 휠 이벤트의 deltaY 값의 부호를 얻음
	const selectedImg = 'images/dotSelect.png';
	const scrolledImg = 'images/dotScroll.png'

	if(delta > 0 ){//아래로 스크롤되면
		 document.querySelector('.rider').style.opacity = 0;
		 document.querySelector('.stickbtn').style.opacity = 1;
		 document.querySelector('.pnav').style.opacity = 1;
		if(currentPage < 8){ currentPage++; }
		if(currentPage == 8){
			 document.querySelector('.stickbtn').style.opacity = 0;
		}

	}else{ //위로 스크롤되면
		if( currentPage > 1){ currentPage--; }
		//첫페이지 돌아오면 라이더 모집 img는 보이게, 앱다운로드 버튼, 페이지네
		if(currentPage == 1 ){
			document.querySelector('.rider').style.opacity = 1;
			document.querySelector('.stickbtn').style.opacity = 0;
			document.querySelector('.pnav').style.opacity = 0;
		}
 	}

	console.log("[s] currentPage  : "+currentPage)

	//2-7페이지 사이에 위치하면
	if( currentPage >= 2 && currentPage < 8) {
		aniworking(); //애니메이션 작동하도록 함수호출

		//pagination버튼 전체 기본 이미지로 바꿨다가 해당페이만 selec이미지로변경
		pBtn.forEach(function(btn) {
			btn.style.backgroundImage = 'url(images/dotScroll.png)';
		});
		pBtn[currentPage-2].style.backgroundImage = 'url(images/dotSelect.png)';
	}



	// 페이지의 높이만큼 스크롤 이동
	window.scrollTo({
	  top: window.innerHeight * (currentPage-1), // innerHeight의 높이만큼
	  behavior: 'smooth', // 스무스한 스크롤 이동을 위해
	});

	setTimeout(()=>{
		isWheeling = false;
	},100); //100ms후에 isWheeling을  false로 변경

}

window.addEventListener('wheel', handleWheel);



// 애니메이션이 종료되면 클래스제거
//aniBox.addEventListener('animationend', () => {
//  aniBox.classList.remove('move_');
//});


// # 페이지 네이션
// 페이지네이션의 버튼을 클릭하면 해당 페이지로 이동하기

	pBtn.forEach(function(button, index) {
	  button.addEventListener('click', function() {

		pBtn.forEach(function(btn) {
	      btn.style.backgroundImage = 'url(images/dotScroll.png)';
	    });
	    button.style.backgroundImage = 'url(images/dotSelect.png)';

	    console.log("index  : "+ index)

	    currentPage = index+2;
	    console.log("[p] currentPage  : "+currentPage)
	    //애니메이션
	    if( currentPage >= 2 && currentPage < 8) { aniworking(); }
	    window.scrollTo({
	      top: window.innerHeight * (index+1),
	      behavior: 'smooth'
	    });
	  });
	});



let aniBox =  document.querySelectorAll('.ani'); //all로 모두 가져와야 배열이되나봄
function aniworking(){
	//현재 페이지에 도달하면 move_00 클래스 추가
	/*
	 getClientRects()
	 요소의 크기와 위치 정보를 반환하는 메서드
	 이 메서드를 호출하면 해당 요소의 위치와 크기에 관한 정보를 담은 DOMRect 객체를 반환.

		DOMRect 객체는 다음과 같은 속성을 포함합니다:
		- top	: 요소의 위쪽 경계선의 위치
		- bottom: 요소의 아래쪽 경계선의 위치
		- left	: 요소의 왼쪽 경계선의 위치
		- right	: 요소의 오른쪽 경계선의 위치
		- width	: 요소의 너비
		- height: 요소의 높이
	 */
//	console.log("currentPage : "+currentPage);
//	console.log("aniBox : "+ aniBox[0]);
	const aniBoxPostion =  aniBox[currentPage-2].getClientRects(); //ani <div>의 위치정보
//	console.log("aniBox[currentPage-2].aniBoxPostion[0] "+ aniBoxPostion[0]);
//	console.log("aniBoxPostion[현재페이지의].top : " + aniBoxPostion[0].top);

	 if (aniBoxPostion[0].width > 0) {
		if(currentPage == 2){
			console.log("page 2");
			aniBox[currentPage-2].classList.add('move_down');
		} else if(currentPage == 3 || currentPage == 4 || currentPage == 5 || currentPage == 7){
			console.log("page 3/4/5/7");
			aniBox[currentPage-2].classList.add('move_up');

		} else if (currentPage == 6) {
			console.log("page 6");
			aniBox[currentPage-2].classList.add('move_left');

		}
  	 }
}

