/**
 * 
 */
console.log('calendar.js 파일 연결')
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

let contents = [] //여러개의 일정을 저장하는 배열.

		
console.log( ' 현재 년도 : '  + year + ' / 현재 월 : '+month);
// 1. 현재 연도 / 월 기준으로 달력 생성하는 함수
calPrint();
function calPrint(){
	//1. 현재 연도와 월을 출력
	document.querySelector('.caldate').innerHTML = `${year}년 ${month}`;
	console.log('현재 날짜의 getDate()  :  '+new Date().getDate());
	
	let now = new Date( year, month-1, 1); //month의 경우 +1했던 값이므로 원상태로 돌려줌. 2023년의 1일을 반환
	console.log('현재 날짜의 now  :  '+now);
 	//2. 요일과 일 출력
 		//현재의 달이 시작되는 요일
 	let sWeek = now.getDay(); // 현재 월의 시작 요일/
	console.log('요일 :(0일요일~6토요일)  :'+sWeek)
	
		//현재달에 해당하는 마지막 날 구하기 ( 30? 28? 31 ? 29??)
	let now2= new Date(year, month, 0); //  현재달 +1 (8월)	,  이전달의  뒤로(0) 
	let eDay = now2.getDate();
    console.log('eDay'+eDay);
    
    	
	let calendar = document.querySelector('.calendar');
	let html ='';
		//1. 요일 출력
		html += `	<div class="week sunday"> 일 </div>
					<div class="week"> 월 </div>
					<div class="week"> 화 </div>
					<div class="week"> 수 </div>
					<div class="week"> 목 </div>
					<div class="week"> 금 </div>
					<div class="week"> 토 </div>	`
		// ** 현재 달력 1일의 요일까지 공백 출력
		
		for (let b = 1 ; b <= sWeek ; b++  ){ // 1일이 시작되는 요일이 되기 전까지 공란으로 만들어주기
			html +=`<div>  </div>`;
		}		
		// 일 출력. 
	
		for(let i = 1 ; i <=eDay ;  i++){
			
			if(date == i) {
				
				
				html += 
					`<div onclick="openModal(${i})" class="today"> 	
						${i} 	
						${contentPrint(`${year}-${month}-${i}`)} 
						
				
				
					</div>`
			} else{ html += 
					`<div onclick="openModal(${i})"> 
				  		${i} 
						${contentPrint(`${year}-${month}-${i}`)}
						
				
				
					</div>`;
			}
			//		
		}			
		
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

// 3. 모달열기
function openModal(day){
	
	document.querySelector('.modal_wrap').style.display = 'flex';
	// 선택한 날짜를 가져오기
		// 1-9월 인경우 앞에 0 문자 넣어주기
	//(month < 10 )? '0'+month : month;
	document.querySelector('.date').innerHTML = `${year}-${month}-${day}`
	
}

// 4. 모달닫기
function closeModal(){
	console.log('닫기 버튼 눌렀다요');
	document.querySelector('.modal_wrap').style.display = 'none';
	
}



//5. 일정 등록 버튼을 클릭했을 때
function onWrite(){
	//1.  받은 값 저장
	let color = document.querySelector('.color');
	let content = document.querySelector('.content');
	let date = document.querySelector('.date');
	
	//2. 가공( 1 유효성검사 ,. 2. 객체화)
	let object = {
		color : color.value,
		content : content.value,
		date : date.innerHTML
	} 
	
	console.log(object);
	//3. 저장
	contents.push(object);
	console.log('contents 배열 값  : '+ contents  );


	//input 박스 초기화시켜주기
	color.value = '';
	content.value = '';
	
	//모달닫기()
	closeModal();
	calPrint();//닫히고 나면 바로 리스트를 출력하게 다시 호출
}
// 6. 일정 출력함수 [만약에 현재 날짜와 동일한 일정 날짜 찾아서 출력]
function contentPrint(date){
	//console.log('contentPrint함수 인자값 : ' +date);
	
	let html = '';
	let cnt = 0;
	
	for(let i = 0 ; i < contents.length ; i++){
		if(contents[i].date == date){
			
			html += `<span class="todo" style="background-color:${contents[i].color};"> ${contents[i].content} </span>`
			cnt++;
			console.log(cnt);
//			if (cnt > 3){
//				html += `<span class="todo"><a href="#"> more </a></span>`;
//			}
		}
	}
	return html;
}

