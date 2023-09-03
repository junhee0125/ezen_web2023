/**
 *
 */
function bList(){
	location.href="list.jsp";
}
function bWrite() {

	console.log(" bWrite() ");

	let writeForm = document.querySelectorAll('.writeForm')[0]

	let writeData = new FormData(writeForm);
	//selected된  옵션의 value가져오기
	//let bcno = bcno.options[bcno.selectedIndex].value;
	//writeData.append("bcno",bcno);
	//console.log('bcno :: ' + bcno);

	$.ajax({
		url:"/jspweb/BoardInfoController",
		method:"post",
		data:writeData,
		contentType:false,
		processData:false,
		success : r => {
			console.log("success :: "+ r);
			if(r){
				alert('글이 등록되었습니다.')
				location.href="/jspweb/board/list.jsp"
			} else {
				alert('글이 등록되지 않았습니다.[관리자에게 문의]')
				location.href="/jspweb/board/list.jsp"
			}
		},
		error: e => {
			console.log("error :: "+ e);
		}

	})

}