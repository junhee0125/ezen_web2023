/**
 *
 */
console.log("1연결")
let isWheeling = false; //휠 이벤트가 있었는지여부
let currentPage = 1; // 현재 페이지 초기값 설정

function handleWheel(event) {
	const delta = Math.sign(event.deltaY); // 휠 이벤트의 deltaY 값의 부호를 얻음

	if (isWheeling) return; //isWheeling= true이면 함수종료
	//console.log("isWheeling1" +isWheeling);
	window.addEventListener("wheel", function(e){ //브라우저의 기본동작 막기
		e.preventDefault();
	},{passive : false});

	isWheeling = true;
	if(delta > 0 ){//아래로 스크롤되면
		if(currentPage < 4){ currentPage++; }
//		if(currentPage == ){
//			 document.querySelector('.stickbtn').style.opacity = 0;
//		}

	}else{ //위로 스크롤되면
		if( currentPage > 1){ currentPage--; }
		//첫페이지 돌아오면 라이더 모집 img는 보이게, 앱다운로드 버튼, 페이지네

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
