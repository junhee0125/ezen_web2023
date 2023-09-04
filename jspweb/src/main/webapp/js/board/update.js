/**
 * 
 */ 

// 1. URL에 있는 매개변수(쿼리스트링) 가져오기
	// 1. 현재 주소(url)상 매개변수 가져오기 
let urlParams = new URL(location.href).searchParams
	console.log( urlParams );
let bno = urlParams.get("bno"); // rul주소에서 bno의 데이터 가져오기 
	// new URL(location.href).searchParams.get("매개변수명")
	console.log( "bno  >>"+ bno );
	
	
getBoard();
 function getBoard(){
	 console.log('update . getBoard()');

	 
	 $.ajax({
		url:"/jspweb/BoardInfoController",
		methode : "get",
		data : { type: 2 , bno : bno } , 
		success : r => {  console.log(r);
			document.querySelector('.bcno').value = `${r.bcno }`;
			document.querySelector('.btitle').value = `${r.btitle}`;
			document.querySelector('.bcontent').value = `${r.bcontent}`;
			document.querySelector('.oldfile').innerHTML = `${r.bfile}`;
			},
		error : e =>{ 	console.log(e);
		}
	});
}

function onUpdate(){
	console.log('onUpdate');
	let writeForm = document.querySelectorAll('.writeForm')[0]
	
	let writeData = new FormData(writeForm);
	console.log('writeData :: ' + writeData);
	//bno 추가해주기
		writeData.set("bno", bno);
	
	$.ajax({
		url:"/jspweb/BoardInfoController",
		method : "put",
		data :writeData, 
		contentType:false,
		processData:false,
		success : r => {  console.log(r);
			if(r) {
				alert(' 글등록 완료되었습니다.');
				location.href = `/jspweb/board/view.jsp?bno=${bno}`
			} else {
				alert('글 등록에 실패했습니다. [관리자문의바랍니다]');
				location.href = `/jspweb/board/view.jsp?bno=${bno}`
			}
		},
		error : e =>{ 	console.log(e);	}
	})
}
function onList(){
	location.href = '/jspweb/board/list.jsp';
}