/**
 * 
 */

 //1. list.jsp 에서 클릭된 제목의 bno를 전달받아 게시물 1개 가져오기
 getBoard();
 function getBoard(){
	// 1. URL에 있는 매개변수(쿼리스트링) 가져오기
		// 1. 현재 주소(url)상 매개변수 가져오기 
	let urlParams = new URL(location.href).searchParams
		console.log( urlParams );
	let bno = urlParams.get("bno"); // rul주소에서 bno의 데이터 가져오기 
		// new URL(location.href).searchParams.get("매개변수명")
		console.log( bno );
	 
	 $.ajax({
		url:"/jspweb/BoardInfoController",
		methode : "get",
		data : { type: 2 , bno : bno } , 
		success : r => {  console.log(r);
			// 1. 
			let boardBox = document.querySelector('.boardBox')
			
			// 2. HTML 구성 
			let html = `부가정보 : <div> 
									${ r.bcname } , 
									${ r.bveiw } , 
									${ r.bdate } 
								 </div>
						부가정보2 : <div>  
									${ r.mid }  , 
									<img src="/jspweb/member/img/${ r.mfile }" width="50px" /> 
								</div>
						제목 : <div> ${ r.btitle } </div>
						내용 : <div> ${ r.bcontent } </div>
						첨부파일 : <div><a href="/jspweb/FileDownload?filename=${ r.bfile }">${ r.bfile }</a> </div>
						`;
			html += `<a href="list.jsp"><button type="button">목록보기</button></a>`;
			console.log('host  :  '+ r.host)
			if(r.host == true){
				html+= 	`<button onclick="onDelete(${r.bno})" type="button">삭제</button>
						<button onclick="onUpdate(${r.bno})" type="button">수정</button>`
			}
			// 3.
			boardBox.innerHTML = html;
			},
		error : e =>{
			console.log('error :: '+ e);
		}
	 });
	 
 }
 
 function onUpdate(bno){
	 
	 location.href = `/jspweb/board/update.jsp?bno=${ bno }`
 }
 
 
  function onDelete(bno){
	  console.log('bno :: '+bno)
	 $.ajax({
		url:"/jspweb/BoardInfoController",
		method : "delete",
		data : { bno : bno } , 
		success : r => {  
			console.log(r);
			if(r){
				alert('삭제되었습니다.')
				location.href=`/jspweb/board/list.jsp`
			} else {
				alert('삭제 실패')
			}
		},
		error : e =>{
			console.log('error :: '+ e);
		}
	 });
 }