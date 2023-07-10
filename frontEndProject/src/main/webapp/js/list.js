/**
 * 
 */
console.log('list.js 연결');

//1. 페이지가 열리면 배열호출
let boardList = JSON.parse(localStorage.getItem('boardList'));
/*
 	쿠키 세션에 저장된 객체 배열 호출시 : JSON.parse()
 	쿠키 세션에 저장된 객체 배열 저장시 JSON.stringify()
 
 */
if(boardList == null) boardList = [];
boardPrint();

function boardPrint(){
	//어디에
	let tcontent = document.querySelector('.tcontent');
	let total = document.querySelector('.total');
	let html = '';
	
	for(let i = 0 ; i < boardList.length ; i++){
		
		html +=	`<tr>
					<td> ${boardList[i].no} </td> 
					<td onclick="onviewLoad(${boardList[i].no})"> ${boardList[i].title} </td> 
					<td> ${boardList[i].writer} </td>
					<td> ${boardList[i].date} </td> 
					<td> ${boardList[i].view} </td> 
					<td> ${boardList[i].like} </td>
				</tr>`
	}	
	
	//무엇을
	tcontent.innerHTML = html;
	total.innerHTML = `<tr>
					      <td colspan="6">total : ${boardList.length}</td>
					   </tr>`
}
/*
	spa : single page application : react, 뷰
 */
//2. 상세페이지로 이동 [ 실행조건 : 클릭한 게시물 제목]
function onviewLoad(no){
	console.log('현재 클릭된 제목의 번호는??  :  '+ no)
	sessionStorage.setItem('no',no);
	//조회수 증가시켜주기
	increseView(no);
	
	location.href='view.jsp';
}

// 3. 조회수 증가함수 [실행조건] 제목클릭후 페이지 전환 전에
function increseView(no) {
	for(let i = 0 ; i < boardList.length ; i ++){
		if (boardList[i].no == no ){
			
			boardList[i].view++ ;
			localStorage.setItem('boardList',JSON.stringify(boardList))
			break;
		}
	}
	
}