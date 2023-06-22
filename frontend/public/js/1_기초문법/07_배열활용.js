/**
 * 변수 : 
 * 	지역변수 	: 지역 { } 에서 태어났으면 지역 밖으로 못나감
 * 				
 * 	전역변수  : 지역 { } 밖에서 태어났으면 자유롭게 이동가능
 * 
 * 문자열내 변수/배열/객체 포함하는 방밥 [JS안에서 HTML 작성시 문자처리]
 *	1. 작은 따옴표(연결연산자) = '<td>' +변수명 /배열명+'</td>' 
 *  2. 백틱(`${}`) = `${변수명/배열명}` (권장)
 */
//4. 배열 선언
let 방문록 = []; // 여러 함수에서 사용하기 때문에 함수 밖에서 선언한것  !!!
let 작성자 = [];
	//인덱스 = 배열내 저장된 순서번호
//1.이벤트 함수 만들기
function 등록(){ //f start
	
	//1. 함수 잘 작동하는 지 체크
	console.log( '등록함수 실행');
	
	//2. input 태그 호출
	let contentInput = document.querySelector('.content');
	console.log(contentInput); //호출되는지 확인 :<input type="text" class="content"/>
	
	//3 입력받은 값 호출
	let value= contentInput.value;
	console.log(value);
	let writer=document.querySelector('.writer').value //작성자  input값 가져오기
	//5 배열등록
	방문록.push(value);
	작성자.push(writer);
	console.log(방문록);
	
	//5 HTML에 배열 출력하기
	
	let contentTable = document.querySelector('.contentTable') //테이블 가져오기
	
	//배열내 존재하는 인덱스(legnth)까지만 출력하고싶음.
	// 반복문 이용한 0번 인덱스 부터 마지막 인덱스까지 출력
	// 반복문 0번부터 마지막 인덱스까지 1개씩 출력
	// 0번부터(초기값);마지막인덱스까지(조건);1개씩 (증감식)
	
	// 1, 2,3... 누적되는 문제
	let tableHTML = `<tr><th> 내용 </th> <th> 작성자 </th></tr>`
	for(let i = 0 ; i < 방문록.length; i++){
		/*tableHTML += '<tr><td></td><td></td></tr>'*/
		 tableHTML += `<tr><td>${방문록[i]}</td><td>${작성자[i]}</td></tr>`
	}
	
	//2 . 마지막 인덱스[최근에 등록된 요소]만 = 배열.length-1
	//let tableHTML = contentTable.innerHTML//테이블의 html 호출
	// tableHTML += `<tr><td>${방문록[i]}</td><td></td></tr>`
		
	console.log(tableHTML)
	// 추가된 HTML 내용 (=) 대입
	contentTable.innerHTML=tableHTML;
		
}//f end
 