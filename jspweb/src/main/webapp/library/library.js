/**
 *
 */
console.log("JS접속완료");

function chNum( num ){
   nowNum = num;
   document.querySelector('.ch_num').innerHTML = num;
}

/* 버튼 출력 함수 */
//read();
function read(){

   $.ajax({
      url : "/jspweb/Library" ,
      method : "get" ,
      data : "",
      success : r => {
         console.log('통신 성공');
         let html = ``;
         let readButton =  document.querySelector('.button_box');
         for(let i = 0; i < r.length; i++){
            if(r[i].lisuse == true)
               document.querySelector(`.button${i+1}`).style.backgroundColor = 'orange';
            else
               document.querySelector(`.button${i+1}`).style.backgroundColor = 'white';

         }
      },
      error : r => {
         console.log('통신 실패')

      }
    });
}

function setSeatno(seatno) {

	document.querySelector('.getIn').value = seatno;
	document.querySelector('.getOut').value = seatno;

	document.querySelector('.ch_num').innerHTML = seatno;
	console.log("seatno" + seatno);

	console.log("('.getIn').value  :" + document.querySelector('.getIn').value);

}





//입실정보등록
function checkIn(){
	let seatnoInput = document.querySelector('.ch_num');
	let nameInput = document.querySelector('.name');
	let phonenumberInput = document.querySelector('.phonenumber');

	console.log("seatno  :  " + seatnoInput.innerText);
	console.log("name  :  " + nameInput.value);
	console.log("phonenumberInput  :  " + phonenumberInput.value);
	//객체화
	let info = {
		type:"C",
		name: nameInput.value,
		phonenumber:phonenumberInput.value,
		seatno:seatnoInput.innerText
	}
	console.log("info >> "+info);
	$.ajax({
		url :"/jspweb/LibraryController",
		method : "POST",
		data : info,
		dataType: "text",
		success: r => {
			console.log('통신성공' + r)
			alert("입실정보가 정상등록되었습니다.")
			//초기화
			nameInput.value='';
			phonenumberInput.value ='';
			seatno:seatnoInput.innerText='';
			// read()
		;},
		error : r => {

			console.log('통신실패 : '+ r );
		}
	});
}

//퇴실정보등록 (입실정보수정)
function checkOut() {
	let seatnoInput = document.querySelector('.ch_num');
	let nameInput = document.querySelector('.name');
	let phonenumberInput = document.querySelector('.phonenumber');

	console.log("22 seatno  :  " + seatnoInput.innerText);
	console.log("222 name  :  " + nameInput.value);
	console.log("2222 phonenumberInput  :  " + phonenumberInput.value);

	let info = {
			type:"U",
			name: nameInput.value,
			phonenumber:phonenumberInput.value,
			seatno:seatnoInput.innerText
		}
		console.log("info >> "+JSON.stringify(info));

		$.ajax({
			url :"/jspweb/LibraryController",
			method : "POST",
			data : info, //보낼 데이터,
			dataType: "text",
			success: r => {
				console.log('통신성공' + r)
				alert("퇴실실정보가 정상등록되었습니다.")
				//초기화
				nameInput.value='';
				phonenumberInput.value ='';
				seatno:seatnoInput.innerText='';
				// read()
			;},
			error : r => {

				console.log('통신실패 : '+ r );
			}
		});
}

//좌석정보출력
function showSeat(){


}