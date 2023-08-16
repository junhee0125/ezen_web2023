/**
 *
 */
console.log("JS연결");
/*
	휠 이벤트의  deltaY(수직스크롤)값을 읽어와서
	값이 양의 값이면 스크롤이 아래방향으로 1개씩 증가하되
	(음의 값인경우  페이지는 1씩 감소해서 스크롤이 올라갈수 있게함)
	디바이스의 innerHeight 만큼
	부드럽게 스크롤되도록 하는 함수
	한번 휠을 작동하면 100ms뒤에 isWheeling을 false로 변경해서
	휠이 여러번 적용되더라도 한번으로 인식할 수 있도록 함
 */
let i = 1; // 현재 페이지 초기값 설정
let isWheeling = false;
let bgimgList=['main_01.jpg','main_02.jpg','main_03.jpg','main_04.jpg','main_05.jpg'];
let bgtxtList=['main_text_01.png','main_text_02.png','main_text_03.png','main_text_04.png','main_text_05.png'];

// # 1 백그라운드 이미지 랜덤하게 가져오기
//let currentImg = 1 ; // 현재 보여지는 bgImg


	let currentImg = document.querySelector('.intro');
	let currentTxt = document.querySelector('.mtxt');

	let rNum = Math.floor(Math.random() * 5); //0~4
	//console.log("rNum : "+rNum);
	currentImg.style.backgroundImage = `url(./images/${bgimgList[rNum]})`;
	currentTxt.src = `./images/${bgtxtList[rNum]}`;
	//console.log("currentImg  :" + currentImg);
	//console.log("currentTxt  :" +currentTxt.src);



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
		 //setAtt(delta);
		if(i < 8){  i++; }
		if(i == 8){
			 document.querySelector('.stickbtn').style.opacity = 0;
		}
	}else{ //위로 스크롤되면
		if( i > 1){ i--; }
		//첫페이지 돌아오면 라이더 모집 img는 보이게, 앱다운로드 버튼, 페이지네
		if(i == 1 ){
			document.querySelector('.rider').style.opacity = 1;
			document.querySelector('.stickbtn').style.opacity = 0;
			document.querySelector('.pnav').style.opacity = 0;
		}
 	}


	  // 페이지의 높이만큼 스크롤 이동
	window.scrollTo({
	  top: window.innerHeight * (i-1), // innerHeight의 높이만큼
	  behavior: 'smooth', // 스무스한 스크롤 이동을 위해
	});

	setTimeout(()=>{
		isWheeling = false;
	},100); //100ms후에 isWheeling을  false로 변경


	//페이지네이션 이미지 변경
	let pnav = document.querySelector('.pnav');
	let ul = pnav.getElementsByTagName('ul')[0];
	let lis = ul.getElementsByTagName('li');


	console.log("i번째 li " + lis[i]);

	for( let j =0 ; lis.length; j++){

		if( i-2 == j){
			lis[j].getElementsByTagName('button')[0].style.backgroundImage =  `url(${selectedImg})`;
		} else {
			lis[j].getElementsByTagName('button')[0].style.backgroundImage =  `url(${scrolledImg})`;
		}
	}
}

	// wheel 이벤트 리스너 등록
window.addEventListener('wheel', handleWheel);

// # 페이지 네이션
function pageMove(page) {
  // innerHeight 값을 가져옵니다.
  const innerHeight = window.innerHeight;
  console.log("page : "+ page);

  // innerHeight 만큼 페이지를 이동합니다.
  window.scrollBy(0, innerHeight);
}

//let pbtn = document.querySelector('.pagination');
// pbtn.addEventListener('click', scrollPage(i));
/*
	1번째 0
	2번째 900 -- 현재 페에지
	3번째 1800
	4번째 2700 -- 클릭이벤트 발생페이지
 	5번째 3600
 	.
 	.
 	.
 	
	
	
 */



