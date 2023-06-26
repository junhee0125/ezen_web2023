/**
 * 주제 : 로또구매 프로그램
	요구사항
   1. 로또구매 버튼 클릭해서 실행
   2. 1~45개 버튼 화면에 표시 
   3. 6개 버튼 선택 ( 중복 불가능 ) / 구매취소 
   4. 6개 숫자 모두 선택시 추첨결과 버튼 활성화 / 유효성검사 
   5. 당첨번호 = 자동 난수(랜덤) 6개
   6. 선택한 6개 숫자와 당첨번호6개와 비교해서 결과
 */
console.log(Math.random())
console.log('JavaScript 실행');
let 선택한숫자들 = [];
// 1. 로또구매 함수 정의
 function 로또구매(){
	 console.log('로또구매() 실행');
	 let buttonHTML=''
	 for(let i =1; i <= 45 ;i++){
		
	 	buttonHTML += `<button onclick="숫자버튼(${i})">${i}</button>` ; // i 번째 버튼
	 	//인수 = i번째 출력된 버튼 클릭시 i 번째 출력된 숫자를 숫자버튼() 함수에게 전달
	 	//JS-> HTML생성 -> 클릭이벤트 실행
	 	
	 	if(i%5 == 0){
			 buttonHTML += '<br/>'
		 }
	 }
	 
	 //2. for문에서 생성된 버튼 45개를 해당 div에 대입
	 document.querySelector('.버튼목록구역').innerHTML=buttonHTML;
 }
 
 function 숫자버튼( 선택된버튼 ){
	 let buttonHTML01=''
	 console.log(선택된버튼+'숫자버튼을 클릭했군요.')
	 //선택한 숫자에 중복이 있는지 여부 체크
	 if(선택한숫자들.indexOf(선택된버튼) != -1){	 //중복이 있으면	 
		 let index_c = 선택한숫자들.indexOf(선택된버튼) // 취소될 버튼의 인덱스
		 선택한숫자들.splice(index_c, 1) //취소될 버튼의 인덱스로부터 1개를 삭제하기
		 alert(`${선택된버튼}은  선택이 취소되었습니다.`);
		 선택번호출력()
		 return; //함수강제 종료 //return 안했을 경우 아래로 실행
	 } 
	 
	 /*숫자 6개를 모두 선택했으면. 당첨번호 확인버튼 표시하기 */
	 if(선택한숫자들.length == 6 ){
		alert(`${선택한숫자들} \n 번호 6개를 모두 선택하셨습니다. \n 아래 당첨번호를 누르려서 당첨여부를 확인하세요.`)
		선택번호출력();
		buttonHTML01 += '<button onclick="당첨번호()">당첨번호를 확인하세요</botton>';
		document.querySelector('.당첨결과버튼구역').innerHTML = buttonHTML01;			 
	 } 
	 
	 
	 선택한숫자들.push(선택된버튼)
	 
	 선택번호출력(); 	 
	 	 
	 	
			  
		  	 
		  
	 
	 
 }
 //3. 선택된 번호들을 출력하는 함수 [실행조건 : 배열에 변화가 있으면 1.추가 / 2삭제 / 3 수정]
 function 선택번호출력(){
	 document.querySelector('.선택번호출력구역').innerHTML = 선택한숫자들;
	 if(선택한숫자들.length == 6 ) {
		  document.querySelector('.당첨결과버튼구역').innerHTML = '<button onclick="당첨번호()">당첨번호를 확인하세요</botton>';
	 } else {
		 document.querySelector('.당첨결과버튼구역').innerHTML = '';
	 }
	 
 }
 
 function 당첨번호(){
	 let min = 1;
	 let max = 45;
	 let 당첨번호목록 =[];
	 let won = 0;
	
	 /*1 난수생성 */
	 //console.log(Math.random())// 0~1 사이의 임의값
	 for(let i = 1 ;  i <= 6  ; i++){
		 let rNum = parseInt(Math.random() * max +1);
		 if(당첨번호목록.indexOf(rNum) == -1){ //랜덤 숫자가 중복이 아닐경우만 			 
			  당첨번호목록.push(rNum);
		 } else {
			 i--; // 중복된경우 i값을 차감시켜 다시한번 반복할 수 있게
		 }
		
	 }
	 //for(let i = 1; 선택한숫자들.length)
	 console.log(당첨번호목록);
	 //4 . 두 배열비교하기
	//방법 1 
	for(let i =0 ; i < 선택한숫자들.length ;i++  ){
		if(당첨번호목록.indexOf(선택한숫자들[i]) != -1 ){
			won ++;
		}
		
	}
	alert('당첨갯수 : '+won);
	won = 0;
	//방법2 향상된 for문 [ for (let 반복변수명 in  배열명)]
	/*
		- 배열의 length를 포함하는 
		- 초기화 변수 = 인덱스 
		for (let 변수명아무거나(인덱스) in 선택번호목록){ //자동으로 0번 인덱스부터 마지막 인덱스까지 반복변수대입
			console.log(변수명아무거나)  // 0 , 1,2,3,4,5
			if(당첨번호목록.indexOf(선택한숫자들[변수명아무거나]) != -1 ){
				won ++;
			}
		}
		alert('당첨갯수 : '+won);
		won = 0;
	
	 */
	//방법3 - 향상된 for문 [for (let 반복변수명 of 배열명)]
	/*
		for (let 데이터 in 선택번호목록){ //자동으로 0번 인덱스부터 마지막 인덱스까지 반복변수대입
			console.log(변수명아무거나)  // 0 , 1,2,3,4,5
			if(당첨번호목록.indexOf(데이터) != -1 ){
				won ++;
			}
		}
		alert('당첨갯수 : '+won);
		won = 0;
	
	 */
	//방법4 - for관련 함수 [배열명.forEach()vs 배열명.map() vs filter()]
	//배열명.forEach((데이터) =>{실행문})
	//배열명.forEach((데이터, 인덱스) => {실행문})
	/*
		선택번호목록.forEach();// 배열명.forEach((반복변수명)=>{실행문});
		선택번호목록.forEach(데이터, 인덱스)=>{
			console.log(데이터);
			console.log(인덱스);
			if(추첨번호목록.indexOf(데이터)!=-1) {won++}
		});
		 alert('당첨갯수 : '+won)
	 */
	
 
 }
 
	 