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
/*
	게시물 조회 조건 객체 생성
	type : 1.전체조회 / 2. 개별조회
	bcno : 조회할 카테고리 번호 [기본값은 전체보기]
	listSize : 하나의 페이지에 최대표시할 게시물수 [기본값은 10]
	page:  조회할 페이지 번호 [기본값은 1]
*/
let pageObject = {type : 1, bcno: 0 , listSize : 10, page:1 }
// 2. 모든 글 조회 [ js열렸을때 1회 자동실행 ]
getList(1);
function getList(page){
	 
	pageObject.page = page;
	$.ajax({
		url : "/jspweb/BoardInfoController" , 
		method : "get" ,
		data : pageObject , 
		success : r => { console.log( r ); 
		
		//---게시물출력--------------------------------------------------------------------//
			// 1. 출력할 위치 
			let boardTable = document.querySelector('.listBox');
			
			// 2. 출력할 내용 구성
			let html = `` 
				// * 서블릿으로부터 전달받은 내용[배열] 반복해서 html 구성
				// 배열명.forEach( 반복변수명 => { 실행코드 } )			 // java ->  ,  js =>
				r.boardList.forEach( b => {
					//console.log( b );
					html +=  `<ul class="listContent">
					            <li class="bno"> ${ b.bno } </li>
					            <li class="bcname">${ b.bcname }</li>
					            <li class="btitle"> <a href="/jspweb/board/view.jsp?bno=${ b.bno }"> ${ b.btitle }</a></li>
					            <li class="bwriter">${ b.mid }<img src="/jspweb/member/img/${b.mfile}" </li>
					            <li class="bview"> ${ b.bveiw }</li>
					            <li class="bdate"> ${ b.bdate }</li>
					          </ul>`;
					
					
				} ); // for end 
			// 3. 구성된 html내용을 출력 
			boardTable.innerHTML = html;
			
			//---페이지네이션 출력--------------------------------------------------------------------//
			html =``;
			let pageBox  = document.querySelector('.pageBox')
			// 이전버튼
			html += `<button onclick="getList(${page == 1 ? page: page-1 })" type="button"> < </button>`
			console.log('page :: '+ page);
			// 페이징 번호 버튼
			for(let i =1 ; i <= r.totalpage ; i++ ){
				
				html +=`<button onclick="getList(${i})" type="button" class="${page == i ? 'selectedPage' :''}"> ${i} </button>`
			}
			
			
			//다음버튼
			html += `<button onclick="getList(${ page >= r.totalpage ? page : page+1 })"type="button"> > </button>`
			
			pageBox.innerHTML = html;
			
			//총 게시룰 수
			let boardcount = document.querySelector('.boardcount')
			boardcount.innerHTML = `총 게시물 수 : ${r.totalsize}`
		}, 
		error : e => {}
	})
}



// 3.  카테고리 버튼을 클릭했을 때
function onCategory(bcno){
	console.log('클릭된 카테고리번호 :: ' +bcno);
	
	pageObject.bcno = bcno;
	getList(1)
	
}


// 4.하나의 페이지에 표시할   
function onListSize(){
	let listSize = document.querySelector('.listSize').value;
	pageObject.listSize = listSize;
	getList(1);
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
