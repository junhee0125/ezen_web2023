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
		},
		error: e => {
			console.log("error :: "+ e);
		}

	})

}