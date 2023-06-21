
//1.배열선언 : 학생리스트라는 배열명으로 비어있는 배열 선언.
//만일 학생리스트 배열변수를 함수안에 만든다면.. 호출때마다 초기화... 누계하기 위함이라면 함수밖에 만드는것이 맞다는거
let 학생리스트 = [] // 초기에 배열에는 아무것도 없다. 

//2. 이벤트 : 무엇인가가 실행된 , 일어났음
//onclick : 온클릭 이벤트  [클릭했을 때 이벤트 실행]
//이벤트 함수(코드들이 모여있는 주머니)
//함수 형태 : function 함수명(매개변수) {}
//함: 상자 , 수: 숫자 => 숫자들이 들어있는 상자 =>미리 정의된 수 > 미리 정의된 코드
function 추가함수(){
	
	//alert('함수 실행했네...');
	/*
	 *	1. input에서 입력받은 데이터를 가져오자.
	 *		document : HTML문서 (DOM객체)
	 *		query : 쿼리(질의, 요청)
	 *		Selector: 선택자 ( id:#, class:., 마크업 등)
	 */
	// 1. snameInput 변수에 document.querySelector(".sname") class sname의 input객체를 호출해서 담기
	let snameInput = document.querySelector(".sname")
	//2. 입력받은 데이터 가져오기
	let name = snameInput.value
	//3. 입력받은 데이터를 배열에 추가
	//4 배열명.push(데이터) : 해당 데이터를 배열에 추가 
	학생리스트.indexOf(name) == -1 ? 학생리스트.push(name) :alert("동일한 이름이 존재합니다. [추가불가]")
	
	//5.배열 출력
	//document.write(학생리스트)
	//1. ul객체 호출
	let slistUl = document.querySelector(".slist")
	
	//2, 해당 ul객체에 쓰기
	slistUl.innerHTML = '<li>'+학생리스트+'</li>'
	//innerHTML : <> (inner) </>
	snameInput.value = ''
}

function 삭제함수(){ //f start
	//입력받은 데이터 삭제
	//1. input 객체 호출
	let snameInput = document.querySelector('.sname')
	//2. input 객체의 value 의 속성 호출
	let name = snameInput.value
	
	//삭제할 인덱스 필요 >> 인데를 몰라? 인덱스를 찾자
	let index = 학생리스트.indexOf(name)
	//해당 데이터가 존재하면 번호를, 없으면  -1 을 반환
	// 4. 배열내 인덱스를 이용한 데이터 삭제
	//* 유효성 검사 : 데이터가 개발자가 원하는 데이터인지 검사하는 
	console.log(index)
	index !=-1? 학생리스트.splice(index,1):alert("삭제할 데이터가 없습니다.[삭제불가]")
	
	
	//결과물 출력 (배열출력
	
	document.querySelector('.slist').innerHTML = '<li>'+학생리스트+'</li>'
	snameInput.value = ''
	
}//f end

