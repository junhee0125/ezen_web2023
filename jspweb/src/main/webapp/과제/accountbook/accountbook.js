/**
 * 
 */
console.log("연결");
/**
* 1. 등록 create
*/
function aWrite(){
	console.log("aWrite");
	// 1. html에서 입력받은 데이어를 가지고 온다.
	let atext = document.querySelector('.atext'); 
	console.log("atext" + atext.value );
	let anumber = document.querySelector('.anumber');
	console.log("anumber" + anumber.value);
	
	
	
	// 2. (선택) 데이터가 많으면 객체화
	let info = {
		atext : atext.value,
		anumber : anumber.value
	}
	console.log("info >> "+info);
	
	
	// 3.( 선택) 유효성검사
	
	// 4. Controller(서블릿 자바)에게 저장할 데이터 전달하고 결과 받기
	$.ajax({
		url : "/jspweb/Accountbook", //서블릿 실행시켰을때 주소창에 있는 값 복붙!! http://localhost/jspweb/VisitLogControlle
		method : "post",//"통신방법 : get,post, put, delete 선택",
		data:info,
		success: function 함수명(result){
			console.log("성공 \\(' ' ) : " + result);
			
			// 5. 성공하면 alert() input을 초기화  /  실패하면 alert()
				alert('등록완료!');
				atext.value = '';
				anumber.value = '';				
			
		aRead();		
		},
		error: function 함수명(result){console.log("실패  : " + result)}
	});
	
}

aRead();
/**
*  2. 출력 Read
*/
function aRead() {
	console.log('aRead');
	$.ajax({
		url : "/jspweb/Accountbook", //서블릿 실행시켰을때 주소창에 있는 값 복붙!! http://localhost/jspweb/VisitLogControlle
		method : "get",//"통신방법 : get,post, put, delete 선택",
		data:"",
		success: function 함수명(result){
			console.log("read 성공 \\(' ' ) : " + result);
			// 5. 성공하면 alert() input을 초기화  /  실패하면 alert()
			// - 응답 받은 객체를 HTML에 출력
			// 1.[어디에] 출력할 구역의 객체 호출
			let output = document.querySelector('.outputArea')
			// 2.[무엇을] 반복문을 이용한 데이터를 HTML 형식으로 만들기
			let html = ``; // 백틱
				// 리스트내 모든 데이터를
				for( let i = 0; i<result.length ; i++){
					// 객체를 HTML형식으로 누적더하기
					html += `<div class="rItems">
								<div class="rDate"> ${result[i].adate} </div>
								<div class="rCont">${result[i].atext}</div>
								<div class="rNum">${result[i].anumber}원</div>
								<div class="rEdit">
									<button onclick = "aUpdate(${result[i].ano})" type="button">수정</button>
									<button onclick = "aDelete(${result[i].ano})" type="button">삭제</button>
								</div>
							</div>`
				}
			// 3.[대입] 출력객체 HTML형식 대입
			output.innerHTML = html;
		
		},
		error: function 함수명(result){console.log("실패  : " + result)}
	});
}
	
/**
* 3. 수정 Update
*/
function aUpdate(ano) {

	console.log('aUpdate' + ano);
	//1. 수정할 내용	
	let atext = prompt('수정할 항목내용 :');
	//2. 비밀번호가 일치할 경우만 수정하므로 비밀번호 입력받기
	let anumber = prompt('금액 : ')
	//수정준비물 :vno(누구를) , vpwd(조건용:비밀번호일치여부)	
	
	$.ajax({
		url: "/jspweb/Accountbook",
		method:"put",
		data:{ano:ano, atext:atext, anumber:anumber},
		success:function f(result){
			console.log("aUpdate 통신성공"+ result)
			
			aRead(); //렌더링
		},
		error : function f(result){
			console.log(result)
			
		}
		
		
	});

}
	
/**
* 4.삭제 Delete
*/
function aDelete(ano) {
	console.log(' aDelete' +ano);
	$.ajax({
		url: "/jspweb/Accountbook",
		method:"delete",
		data:{ano:ano},
		success:function f(result){
			console.log("adelete통신성공"+ result)
			
			aRead(); //렌더링
		},
		error : function f(result){
			console.log(result)
			
		}
		
		
	});
	
}	