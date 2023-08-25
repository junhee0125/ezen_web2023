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
		name: nameInput.value, 
		phonenumber:phonenumberInput.value, 
		seatno:seatnoInput.innerText 
	}
	console.log("info >> "+info);
	$.ajax({
		url :"/jspweb/LibraryController",
		method : "post",
		data : info,		
		success: r => {
			console.log('통신성공' + r)
			alert("입실정보가 정상등록되었습니다.")
			nameInput.value='';	
			phonenumberInput ='';	
			// read() 
		;},
		error : r => {
			
			console.log('통신실패 : '+ r );			
		}	
	});		
}

//퇴실정보등록 (입실정보수정)
function checkOut() {
	let seatnoInput = document.querySelector('.in');
	let nameInput = document.querySelector('.name');
	let phonenumberInput = document.querySelector('.phonenumber');
	console.log("seatno  :  " + seatnoInput.value);
	console.log("name  :  " + nameInput.value);
	console.log("seatno  :  " + phonenumberInput.value);
	
	//객체화
	let info = {
		name: nameInput.value, 
		phonenumber:phonenumberInput.value, 
		seatno:seatnoInput.value 
	}
	$.ajax({
		url :"/jspweb/LibraryController",
		method : "put",
		data : info,		
		success: r => {
			console.log('통신성공' + r)
			alert("입실정보가 정상등록되었습니다.")
			nameInput.value='';	
			phonenumberInput ='';	
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