/**
 * 
 */
console.log('view.js 파일이 오픈됐다요.');
let no = sessionStorage.getItem('no');
let boardList= JSON.parse(localStorage.getItem('boardList'));
console.log('세션에서 가져온 게시물 번호  :  '+ no )
onview();
function onview(){
	
	let title = document.querySelector('.title')
	let writedate = document.querySelector('.writedate')
	let content = document.querySelector('.content')
	
	for(let i = 0 ; i < boardList.length ; i++ ){
		if (boardList[i].no == no){
			console.log('찾았다!!!' + boardList[i].no );
			console.log(boardList[i]);
			title.innerHTML=boardList[i].title;
			writedate.innerHTML = `작성자 : ${boardList[i].writer} / 작성일 : ${boardList[i].date}`
			content.innerHTML = boardList[i].content; 
			break; // 반복문 종료
			
		}
	}
}
function onDelete(){
	console.log('삭제버튼을 누름.')
	
	console.log('삭제할 게시물 번호 .' + no)
	for(let i = 0 ; i < boardList.length; i++){
		if(boardList[i].no == no) {
			
			console.log('삭제할 게시물번호 찾았다!!!' + boardList[i].no );
			alert('해당 게시물이 삭제되었습니다.')
			//localStorage.removeItem( `boardList[i].no`,no);
			boardList.splice(i, 1)
			localStorage.setItem('boardList',JSON.stringify(boardList));
		
			sessionStorage.removeItem('no')
			location.href = 'list.jsp';
			break;
		}	
		
	}
	console.log(boardList)
	//onMoveList();
}
function onMoveList(){
	location.href = 'list.jsp';
}