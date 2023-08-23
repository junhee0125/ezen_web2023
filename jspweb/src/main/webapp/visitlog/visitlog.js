/**
 * 
 */
console.log("연결됨 ( ' _')/ HELLO-");
// 1. CREATE (저장) : 방문록 등록함수 = vwrite()
function vwrite(){
	// 1. html에서 입력받은 데이어를 가지고 온다.
	let vwriterInput = document.querySelector('.vwriter');
	let vpwdInput = document.querySelector('.vpwd');
	let vcontentInput = document.querySelector('.vcontent');
	
	console.log("vwriterInput : " + vwriterInput.value );
	console.log("vpwdInput  :  " + vpwdInput.value );
	console.log("vcontentInput : " + vcontentInput.value );

	
	// 2. (선택) 데이터가 많으면 객체화
	let info = {
		vwriter : vwriterInput.value,
		vpwd : vpwdInput.value,
		vcontent:  vcontentInput.value
	}
	console.log("info >> "+info);
	
	
	// 3.( 선택) 유효성검사
	
	// 4. Controller(서블릿 자바)에게 저장할 데이터 전달하고 결과 받기
	$.ajax({
		url : "/jspweb/VisitLogController", //서블릿 실행시켰을때 주소창에 있는 값 복붙!! http://localhost/jspweb/VisitLogControlle
		method : "post",//"통신방법 : get,post, put, delete 선택",
		data:info,
		success: function 함수명(result){
			console.log("성공 \\(' ' ) : " + result);
			
			// 5. 성공하면 alert() input을 초기화  /  실패하면 alert()
			
				vwriterInput.value = '';
				vpwdInput.value = '';
				vcontentInput.value = '';
			
			vread();
		
		},
		error: function 함수명(result){console.log("실패  : " + result)}
	});
	
}
vread();
// 1. Read(호출)
// 실행조건 : JS 열릴 최초 1 / 등록 성공했을 때 / 삭제 성공했을 때/수정 성공햇을때  
function vread(){
	$.ajax({
		url : "/jspweb/VisitLogController", //서블릿 실행시켰을때 주소창에 있는 값 복붙!! http://localhost/jspweb/VisitLogControlle
		method : "get",//"통신방법 : get,post, put, delete 선택",
		data:"",
		success: function 함수명(result){
			console.log("read 성공 \\(' ' ) : " + result);
			// 5. 성공하면 alert() input을 초기화  /  실패하면 alert()
			// - 응답 받은 객체를 HTML에 출력
			// 1.[어디에] 출력할 구역의 객체 호출
			let output = document.querySelector('.viewList')
			// 2.[무엇을] 반복문을 이용한 데이터를 HTML 형식으로 만들기
			let html = ``; // 백틱
				// 리스트내 모든 데이터를
				for( let i = 0; i<result.length ; i++){
					// 객체를 HTML형식으로 누적더하기
					html += `<div class="items"> <!-- 방문록 1개의 표시구역 -->
								<div class="header">
									<div class="writer"> ${ result[i].vwriter } </div>
									<div class="visitdate"> ${ result[i].vdatetime } </div>
								</div>
								<div class="conts"> ${ result[i].vcontent } </div>
								<div class="btn">
									<button onclick="vupdate(${result[i].vno})" type="button">수정</button>
									<button onclick="vdelete(${result[i].vno})" type="button">삭제</button>
								</div>
							</div>`
				}
			// 3.[대입] 출력객체 HTML형식 대입
			output.innerHTML = html;
		
		},
		error: function 함수명(result){console.log("실패  : " + result)}
	});
}
// 1. update(수정)
function vupdate(vno){
	
	console.log('vupdate' + vno);
	//1. 수정할 내용	
	let vcontent = prompt('수정할 내용을 입력하세요 :');
	//2. 비밀번호가 일치할 경우만 수정하므로 비밀번호 입력받기
	let vpwd = prompt('망문록비밀번호 : ')
	//수정준비물 :vno(누구를) , vpwd(조건용:비밀번호일치여부)	
	
	$.ajax({
		url: "/jspweb/VisitLogController",
		method:"put",
		data:{vno:vno, vcontent:vcontent, vpwd:vpwd},
		success:function f(result){
			console.log("vupdate 통신성공"+ result)
			if(result == 0 ){
				alert('비밀번호가 일치하지 않아 수정되지 않았다요.');
			} else if(result == 1){
				alert('수정 !!');
			}
			vread(); //렌더링
		},
		error : function f(result){
			console.log(result)
			
		}
		
		
	});
}


// 1. delete(삭제)
function vdelete(vno){
	console.log('vdelete'+vno);
	// 1. 비밀번호가 일치할 경우 수정하므로 확인용 비밀번호 입력받기
	let vpwd = prompt("방문록비밀번호 : ");
	
	//삭제준비물 :vno(누구를) , vpwd(조건용:비밀번호일치여부)	
	
	$.ajax({
		url: "/jspweb/VisitLogController",
		method:"delete",
		data:{vno:vno, vpwd:vpwd},
		success:function f(result){
			console.log("vdelete 통신성공"+ result);
			
			if(result == 0 ){
				alert('비밀번호가 일치하지 않아 삭제 되지 않았습니다.');
			} else if(result == 1){
				alert('삭제 !!');
			}
			vread(); //렌더링
		},
		error : function f(result){
			console.log(result)
			
			
			
		}
		
		
	});
}