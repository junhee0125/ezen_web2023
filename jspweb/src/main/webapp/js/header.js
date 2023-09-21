/**
 *
 */
// 1. 현재 로그인된 회원정보 요청

let loginState = false;
let loginMid ='';
getMemberInfo();
function getMemberInfo(){
	// 1, ajax 이용한 서블릿세션 정보 가져오기
	$.ajax({
		url:"/jspweb/MemberInfoController",
		method:"get",
		async: false,/* 동기화., 비동기화(기본값 = true) 설정하는 속성*/
		data:{type:"login"},
		success: r =>{
			console.log('getMemberInfo() - success :: '+ r );
			let submenu = document.querySelector('.submenu');
			let html = ``;
			if(r==null){
				loginState = false; 
				loginMid = '';
	            html +=` <li><a href="/jspweb/index.jsp">홈으로</a></li>
	            		 <li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
	            		 <li><a href="/jspweb/member/login.jsp"">로그인</a></li>

	            		`;
		
			}else {
				loginState = true;
				loginMid = r.mid;
				console.log("이미지" + r.mfile)
	           html += ` <li><a href="/jspweb/index.jsp">홈으로</a></li>
	        	   		 <li>${r.mid}님</li>
	        	   		 <li><img src="/jspweb/member/img/${r.mfile}" > </li>
	        	   		 <li><a href="/jspweb/member/payment.jsp">포인트</a></li>	        	   		 
	        	   		 <li><a href="/jspweb/product/wishlist.jsp">찜목록</a></li>
	        	   		 <li><a href="/jspweb/member/info.jsp">마이페이지</a></li>
	        	   		 <li><a onclick="logout()">로그아웃</a></li>
	        	   		`;

			}
			submenu.innerHTML = html;
		},
		error: e => {
			console.log('getMemberInfo() - error :: '+ e );
		}
	})
}

function logout(){
	// 1, ajax 이용한 서블릿세션 정보 가져오기
	$.ajax({
		url:"/jspweb/MemberInfoController",
		method:"get",
		data:{type:"logout"},
		success: r =>{
			console.log('getMemberInfo() - success :: '+ r );
			//alert('로그아웃되었습니다.');
			location.href="/jspweb/index.jsp"
		},
		error: e => {
			console.log('getMemberInfo() - error :: '+ e );
		}
	})
}