/**
 * 
 */
console.log('연결');
let atState = false; //출근상태 기본값 
function changeState(){
	
	if(atState == false) {
		
		if(confirm('출근하시나요?')) {
			atState = true;
			document.querySelector('attendence').innerHTML = `<i class="fa-solid fa-arrow-right-from-bracket fa-rotate-180"></i>퇴 근`;
			alert('출근처리 되었습니다.');
			
		}
	} else if(atState == true) {
		if(confirm('퇴근하시나요?')) {
			atState = false;
			alert('퇴근처리 되었습니다.');
		}
	}
	
}

function onModal(){
	document.querySelector('.approv_modal').style.display = 'flex';
}