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
					<td> ${boardList[i].title} </td> 
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