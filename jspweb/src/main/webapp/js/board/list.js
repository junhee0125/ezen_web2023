/**
 *
 */
function onWrite(){
	console.log('글쓰기 ');

	console.log("loginState:: "+loginState);
	if(loginState){
		//로그인이면 글쓰기 화면
		location.href="write.jsp";
	} else{ // 만약 비로그인이면 로그인페이지로 이동
		location.href="/jspweb/member/login.jsp"
	}


}

// 2. 모든 글 조회 [ js열렸을때 1회 자동실행 ]
getList();
function getList(){
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "get" ,
		data : { type : 1 } , 
		success : r => { console.log( r ); 
			// 1. 출력할 위치 
			let boardTable = document.querySelector('.listBox');
			// 2. 출력할 내용 구성
			let html = `` 
				// * 서블릿으로부터 전달받은 내용[배열] 반복해서 html 구성
				// 배열명.forEach( 반복변수명 => { 실행코드 } )			 // java ->  ,  js =>
				r.forEach( b => {
					console.log( b );
					html +=  `<ul class="listContent">
					            <li class="bno"> ${ b.bno } </li>
					            <li class="bcname">${ b.bcname }</li>
					            <li class="btitle"> <a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle }</a></li>
					            <li class="bwriter">${ b.mid } </li>
					            <li class="bview"> ${ b.bveiw }</li>
					            <li class="bdate"> ${ b.bdate }</li>
					          </ul>`;
					
					
				} ); // for end 
			// 3. 구성된 html내용을 출력 
			boardTable.innerHTML = html;
		}, 
		error : e => {}
	})
}

/*
	
	HTTP URL에 매개변수(파라미터) 전달 ( 쿼리[질의]스트링 방식 )
		- 정의 : 페이지 전환시 매개변수(PK,식별) 전달 
		- 형태 
			URL?변수명=데이터
			URL?변수명=데이터&변수명=데이터
			http://localhost:80/jspweb/board/view.jsp?bno=3
			href="/jspweb/board/view.jsp?bno=${ b.bno }
		
		- URL에서 매개변수 호출 
			new URL(location.href).searchParams.get("변수명")			
*/
