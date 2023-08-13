/**
 *
 */
console.log("JS연결");

let i = 1; // 현재 페이지 초기값 설정
let isWheeling = false;

function handleWheel(event) {
	if (isWheeling) return; //isWheeling= true이면 함수종료
	//console.log("isWheeling1" +isWheeling);
	window.addEventListener("wheel", function(e){ //브라우저의 기본동작 막기
		e.preventDefault();
	},{passive : false});

	isWheeling = true;
	//console.log("isWheeling2" +isWheeling);
	const delta = Math.sign(event.deltaY); // 휠 이벤트의 deltaY 값의 부호를 얻음

	if(delta > 0 ){
		if(i < 7){//아래로 스크롤되면
			i++;
		}
	}else{ //위로 스크롤되면
		if( i > 1){
			i--;
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
}

	// wheel 이벤트 리스너 등록
window.addEventListener('wheel', handleWheel);
