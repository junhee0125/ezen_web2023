/**
 *
 */
function onList(){
	location.href="list.jsp";
}
function onWrite() {

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
			if(r) {
				alert(' 글등록 완료되었습니다.');
				location.href = '/jspweb/board/list.jsp'
			} else {
				alert('글 등록에 실패했습니다. [관리자문의바랍니다]');
				location.href = '/jspweb/board/list.jsp'
			}
		},
		error: e => {
			console.log("error :: "+ e);
		}

	})

}