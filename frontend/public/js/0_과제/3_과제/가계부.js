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
   날짜         	항목      금액        	  비고
   2023-06-06   콜라      300        	삭제버튼
   2023-06-05   노트북   1,200,000   	삭제버튼
   2023-06-03   교통비   1,750      	삭제버튼
      -총합계-         1,202,050      
 */
console.log('JS파일 연결 성공!!')
//1.변수선언 
let date =[];
let item =[];
let cost= [];
/*
	
 */
function save(){
	
	let sum = 0;

	let input_date = document.querySelector('.date').value;
	let input_item = document.querySelector('.item').value;
	let input_cost = document.querySelector('.cost').value
	// 공란체크; return;
	if(input_date =='') {alert('날짜를 입력하세요');return; }
	if(input_item =='') {alert('항목을 입력하세요');return; }
	if(input_cost =='') {alert('금액을 입력하세요');return; }
	
	//각각의 데이터를 배열에 저장
	date.push(document.querySelector('.date').value); //input박스(class = date)에서 입력받은 데이터 저장
	item.push(document.querySelector('.item').value); //input박스(class = item)에서 입력받은 데이터 저장
	cost.push(document.querySelector('.cost').value); //input박스(class = cost)에서 입력받은 데이터 저장
	
	//리스트로 출력하기
	list();
	
	//배열저장후 input박스를 공란으로 초기화해주기
	document.querySelector('.date').value = '';
	document.querySelector('.item').value = '';
	document.querySelector('.cost').value = '';
	
	console.log(date);
	console.log(item);
	console.log(cost);

}

function list(){
	let addItem=''
	
	addItem = `<tr>
				<th>날짜</th>
				<th>항목</th>
				<th>금액</th>
				<th>삭제</th>
			</tr>`
	document.querySelector('.account_list').innerHTML = addItem;		
	
	for(let i=0 ; i< cost.length ; i++){
		addItem +=
				`<tr>
					<th>${date[i]}</th>
					<th>${item[i]}</th>
					<th>${cost[i]}</th>
					<th>
						<button onclick = "del(${i})" type="button">삭제하기</button>
						<button onclick = "update_check(${i})" type="button">수정하기</button>
					</th>
				</tr>`
	
	}
	document.querySelector('.account_list').innerHTML = addItem;		
	// 저장된 배열만큼 리스트를 추가했으면. 총합계를 구하는 sum()함수를 호출해서 toLocaleString (천단위 쉼표)적용해서 저장함.
	sum();
		addItem += `<tr>
					<td colspan="2"> -총합계- </td>
					<td colspan="2">${sum()}</td>
				 </tr>`
	document.querySelector('.account_list').innerHTML = addItem;		
	
}

function sum(){
	let sum = 0 // 가계부 총합계 금액 담을 변수
	
	//배열의 갯수만큼 반복해서 더하면서 sum 값 구하기
	for(let i=0 ; i< cost.length ; i++){
		
		//cost배열에 저장된 데이터를 인덱스 0부터 꺼내서 Number로 형변환후 더해주기
		sum += Number(cost[i])
		
	}
	//
	sum = sum.toLocaleString()
	console.log('sum'+sum)
	//sum 함수를 호출하면 sum변수의 반값을  return;
	return sum;
}


function del(index){
	console.log(index);
	//인수로 가져온 index로 배열에서 삭제한다.
	
	date.splice(index,1);
	item.splice(index,1);
	cost.splice(index,1);
	
	//리스트를 다시 출력한다.(업데이트하기위해서)
	list();
	
}

//수정하기 버튼이 온클릭되면 해당 인덱스 가져온다.
//인덱스 해당 데이터를 input 박스 value데이터로 넣어준다.
//수정하기 버튼을 누르면 push해주고 리스트 함수를 호출한다.
function update_check(index){
	console.log(`수정할 인덱스 : ${index}`)	
//	let updateHtml 	= `날짜 : <input class="date" type="date" value=${date[index]}>
//						항목 : <input class="item" type="text" value=${item[index]}>
//						금액 : <input class="cost" type="text" value=${cost[index]}>
//						<button onclick="update()" type="button">수정하기</button>`
//					  
//	document.querySelector('.input_box').innerHTML = updateHtml;	
document.querySelector('.date').value = date[index];	
document.querySelector('.item').value = item[index];	
document.querySelector('.cost').value = cost[index];	
}