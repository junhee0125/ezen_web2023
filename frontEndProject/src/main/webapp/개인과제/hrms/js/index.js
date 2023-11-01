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

/*
	근태관리 : 캘린더
 */
//1. 현재 연도와 월 [ 초기값 ]
	// new Date (): 현재 날짜/ 시간
		//new Date().getFullYear() : 연도
		//new Date().getMonth() : 월
		//new Date().getDate() : 일
		//new Date().getDay() : 요일 (0~6)
	// new Date (연,월,일): 사용자가 지정한 연월일로 반환	
let year = new Date().getFullYear(); //현재연도
let month = new Date().getMonth()+1;  // 현재 월[0~11] +1 (7월)
let date = new Date().getDate();// 현재 날. (10일)
let day = new Date().getDay();// 현재 날. (10일)

calPrint();
function calPrint(){
	//1. 현재 연도와 월을 출력
	document.querySelector('.caldate').innerHTML = `${year}년 ${month}월`;
	console.log('현재 날짜의 getDate()  :  '+new Date().getDate());
	
	let now = new Date( year, month-1, 1); //month의 경우 +1했던 값이므로 원상태로 돌려줌. 2023년의 1일을 반환
	let prevdate = new Date(year,month-1,date-1).getDate()
	console.log("prevdate:::"+prevdate)
	console.log('현재 날짜의 now  :  '+now);
 	//2. 요일과 일 출력
 		//현재의 달이 시작되는 요일
 	let sWeek = now.getDay(); // 현재 월의 시작 요일/
	console.log('요일 :(0일요일~6토요일)  :'+sWeek)
	
		//현재달에 해당하는 마지막 날 구하기 ( 30? 28? 31 ? 29??)
	let now2= new Date(year, month, 0); //  현재달 +1 (8월)	,  이전달의  뒤로(0) 
	let eDay = now2.getDate();
	
   
    let blankDate = (sWeek+eDay >35)? 42-eDay-sWeek : 35-eDay-sWeek; 
    	
	let calendar = document.querySelector('.calDate');
	let html ='';

		
		for (let b = 1 ; b <= sWeek ; b++  ){ // 1일이 시작되는 요일이 되기 전까지 공란으로 만들어주기
			console.log("sWeek  :: "+sWeek);
			
			html +=`<div class="invalidDate"> ${prevdate-sWeek+b} </div>`;
		}		
		// 일 출력. 
		
		for(let i = 1 ; i <=eDay ;  i++){
			console.log('eDay :: '+ day);
			if(date == i) {
						
					html += 
					`<div class="today"> 	
						${i} 
						
					</div>`
				
				
			} else{ 
				
					html += `<div> ${i} </div>`;
				
			}
			//		
		}
		for (let b = 1 ; b <= blankDate ; b++  ){ // 1일이 시작되는 요일이 되기 전까지 공란으로 만들어주기
			console.log("blankDate  :: "+blankDate);
			html +=`<div class="invalidDate">${b}  </div>`;
		}			//
		
	calendar.innerHTML = html;
	
}

function onNext(check){
	console.log(check);
	if(check == 0){
		month--;
		//만약에 월을 차감했는데 1보다 작아지면 12월로 변경하되 연도 1 차람
		//23년도 1월	인데 1차감되면 2022년 12월로 
		if(month < 1 ){ month=12; year--;}

	} else {
		month ++;
		if(month>12){month=1; year++;}
	}
	calPrint();
}
