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
// 헤더 js에서 받아야할  매개변수 (bcno)
let bcno = 1;
boardList(bcno);
function boardList(bcno){

	$.ajax({
		url:"/jspweb/BoardInfoController",
		method:"get",
		data:{bno:0, bcno:bcno},
		success : r => {
			console.log("success :: "+ r);
			let listBox = document.querySelector('.listBox');
			let html =``;
			r.forEach(b => {
				console.log(b.bveiw);
				html+=`
					<ul class="listContent">
			            <li class="bno">${b.bno}</li>
			            <li class="bcname">${b.bcname}</li>
			            <li class="btitle">${b.btitle}</li>
			            <li class="bwriter">${b.mid}<img src="/jspweb/member/img/${b.mfile}" hgight:30px></li>
			            <li class="bview">${b.bveiw}</li>
			            <li class="bdate">${b.bdate}</li>
			        </ul>`;
			});
			listBox.innerHTML = html;
		},
		error: e => {
			console.log("error :: "+ e);
		}
	});
}