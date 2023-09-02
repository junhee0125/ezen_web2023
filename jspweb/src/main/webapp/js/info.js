/**
 *
 */
getInfo()
let mfile="";
//0. 회원정보호출
function getInfo(){
	$.ajax({
		url:"/jspweb/MemberInfoController",
		method:"get",
		data:{type:"login"},
		success:r=>{
			console.log(r)
			if(r == null){ //비로그인
				alert('회원전용페이지입니다. 로그인페이지로 이동합니다ㅏ')
				location.href='/jspweb/member/login.jsp';

			}else{ //로그인
				document.querySelector('.preimg').src=`/jspweb/member/img/${r.mfile}`
					console.log("mfile :: "+ r.mfile)
				document.querySelector('.mid').innerHTML=`${r.mid}`
				document.querySelector('.memail').innerHTML=`${r.memail}`

			}
		},
		error:r=>{console.log(r)}

	})
}


// 1. 수정
function mupdate(){
	let newfile = document.querySelector('.mfile').value;
	//폼 자체
	let signupForm = document.querySelectorAll('.signupForm')[0];
	//폼 객체화
	let signupData = new FormData(signupForm);



	$.ajax({
		url:"/jspweb/MemberInfoController",
		method:"put",
		data:signupData,
		contentType:false, // 폼전송시 타입 변경
		processData:false, // 폼전송시 타입 변경
		success : r => {
			console.log("success ::"+ r);
			if(r){
				alert('수정되어 다시 로그인합니다.');
				logout();
			} else {
				alert('수정실패');
			}
		},
		error: e => {console.log("error ::"+ e)}

	});

}
// 2. 탈퇴
function mdelete(){
	//1. 탈퇴여부 확인
	console.log("mdelete()")
	let dconfirm = confirm('정말 탈퇴하시겠습니까?');
	if(dconfirm == true){
		let mpwd = prompt('비밀번호 확인');
		console.log("mpwd  :: "+mpwd)

		$.ajax({
			url:"/jspweb/MemberInfoController",
			method:"delete",
			data:{ mpwd : mpwd },
			success:r=>{
				console.log(r)
				if(r == true){ //비로그인
					alert('회원탈퇴가 정상 처리되었습니다.')
					logout();

				}else{ //로그인
					alert('회원정보가 일치하지 않아 탈퇴 취소되었습니다..')
				}
			},
			error:e=>{console.log("error :: "+ e)}

		})

	}
}

/*
	HTTP 전송타입
		1. text/html 			: 문자타입 [ 기본값 ]
		2. application/json 	: json타입
		3. multipart/form-data	: 대용량 form 전송 타입
			contentType : false
			processData : false
*/