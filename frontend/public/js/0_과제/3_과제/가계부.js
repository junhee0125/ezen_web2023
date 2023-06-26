/**
 - 과제3 : 가계부 만들기 ( 과제3.HTML , 과제3.JS , 과제3.CSS )
[요구사항]
   - 1.배열 3개 사용 ( 날짜배열 , 항목배열 , 금액배열 ) / 객체X { }
   - 2.함수 3개 이상 정의해서 구현 
   - 3.총합계는 계산해서 테이블 가장 하단에 출력하시오.
   - 4. 해당 삭제 버튼 클릭시 해당 항목 제거 
   - 5. 출력시 숫자를 천단위 쉼표로 출력하시오. [ toLocaleString() 함수( 천단위쉼표가 있는 문자열로 변환)  ]
      - let 금액 = 1200000
      - 금액.toLocaleString( ) => '1,200,000'
   - 6. css 적절하게 적당히 꾸며서 제출해주세요.

ex) 입력 예시 [ input 3개 사용 ]
   날짜 : <input type="date" />
   항목 : <input type="text" />
   금액 : <input type="text" />

ex) 출력 예시 [ table 사용 ]
   날짜         항목      금액         비고
   2023-06-06   콜라      300         삭제버튼
   2023-06-05   노트북   1,200,000   삭제버튼
   2023-06-03   교통비   1,750      삭제버튼
      -총합계-         1,202,050      
 */

//1.변수선언 
let date =[];
let item =[];
let cost= [];
let tableHead =''
let addItem=''

function save(){
	
	let input_date = document.querySelector('.date').value;
	let input_item = document.querySelector('.item').value;
	let input_cost = document.querySelector('.cost').value
	// 입력받은 데이터에 값이 없는 경우 return;
	if(input_date =='') {alert('날짜를 입력하세요');return; }
	if(input_item =='') {alert('날짜를 입력하세요');return; }
	if(input_cost =='') {alert('날짜를 입력하세요');return; }
	
	//각각의 데이터를 배열에 저장
	date.push(document.querySelector('.date').value); //input박스(class = date)에서 입력받은 데이터 저장
	item.push(document.querySelector('.item').value); //input박스(class = item)에서 입력받은 데이터 저장
	cost.push(document.querySelector('.cost').value); //input박스(class = cost)에서 입력받은 데이터 저장
	
	
	console.log(date);
	console.log(item);
	console.log(cost);
	//list_add 함수호출
	list_add(input_date,input_item,input_cost);
	//첫번째 데이터가 저장되면 테이블의 헤드를 추가한다.
	if(date.length == 1){
		tableHead = `<table class="account_list">
						<tr>
							<th>날짜</th>
							<th>항목</th>
							<th>금액</th>
							<th>삭제</th>
						</tr>`
						
		document.querySelector('.table_head').innerHTML = tableHead;
	}
	
}

function list_add(d,i,c){
	
	console.log("date  : "+d);
	console.log("item  : "+i);
	console.log("cost  : "+c);
	
	
	//cost = > 천단위 쉼표 출력하기 toLocaleString()
	
	 //html추가
	 addItem += `<tr>
					<td>${d}</td>
					<td>${i}</td>
					<td>${parseInt(c).toLocaleString()}</td>
					<td><button onclick = "" type="button">삭제하기</button></td>
				 </tr>`
	document.querySelector('.account_list').innerHTML += addItem;
	
	//총합계 row 추가
	sum();
	
}

function sum(){
	let sum = 0 ;
	
	for(let i =0 ; i < cost.length ; i++) {
		sum += Number(cost[i])
		
	}
	addHtml = `<tr>
					<td colspan="2"> -총합계- </td>
					<td colspan="2">${sum.toLocaleString()}</td>
				 </tr>`
	document.querySelector('.table_head').innerHTML = addHtml;
}
