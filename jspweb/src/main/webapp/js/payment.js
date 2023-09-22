/**
 * 
 */
console.log("연결");

//setPoint(1000, '회원가입축하');
//setPoint(-500, '이모티콘 구매');
//getPoint();
//getPointList();
//1. 포인트 사용 함수[mno는 서블릿이(로그인 세션이ㅣ 알고 있다)]
function setPoint(mpamount, mpcomment){
	console.log("setPoint");
	
	//로그인 안한경우
	if( loginState == false ){
		alert('로그인후 가능한 기능입니다.'); 
		location.href='/jspweb/member/login.jsp' 
	}

	let returnData = false;
	$.ajax({
		url:"/jspweb/MpointController",
		method:"post",
		async:false,
		data: {mpamount:mpamount, mpcomment:mpcomment},
		success: r => {
			console.log( "서블릿결과" + r)
			returnData = r},
		error : e => {console.log( "에러" + e)} 
	});
	
	return returnData;
	
}
//2. 내 포인트 확인함수
function getPoint(mpamount, mpcomment){
	//로그인 안한경우
	if( loginState == false ){
		alert('로그인후 가능한 기능입니다.'); 
		location.href='/jspweb/member/login.jsp' 
	}
	
	$.ajax({
		url:"/jspweb/MpointController",
		method:"get",
		data: {type:'getPoint'},
		success: r => {console.log( "서블릿결과" + r)},
		error : e => {console.log( "에러" + e)} 
	});
	
	
}

//3. 내 포인트 내역 전체 출력 함수
function getPointList(mpamount, mpcomment){
	//로그인 안한경우
	if( loginState == false ){
		alert('로그인후 가능한 기능입니다.'); 
		location.href='/jspweb/member/login.jsp' 
	}
	
	$.ajax({
		url:"/jspweb/MpointController",
		method:"get",
		data: {type:'getList'},
		success: r => {console.log( r)},
		error : e => {console.log( "에러" + e)} 
	});
	
	
}
/*---------------------------------------------*/

IMP.init('imp72860305') // 예: 'imp00000000a'
	
	
let now  =new Date();
console.log("now : " +now) 
let time = now.getTime();
console.log("time :: "+time);//time :: 1695347681942
let merchant_uid = time+'-p-'+loginMid; 
console.log("merchant_uid :: "+merchant_uid);

//now : Fri Sep 22 2023 10:51:08 GMT+0900 (한국 표준시)
function requestPay() {
	//2-1 : 만약에 결제방식을 선택하지 않았으면.
	if(pay_method =='') {alert('결제방식을 선택해주세요'); return;}
	if(amount ==0) {alert('결제금액을 선택해주세요'); return;}
	//2-2: 주문번호 만들기
		/*고유성/중복X /pk
			1. 날짜+상품코드+회원번호 조합해서 설계
			2. 회사전화번호 + 사업자번호 
		*/

    IMP.request_pay({
      pg: "html5_inicis.INIBillTst",
      pay_method:  pay_method,
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "포인트결제",
      amount: amount,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "김현수",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
      	console.log(rsp);
      	
      	if(rsp.success){
			  
		
		} else  {
			alert('결제성공')
			setPoint(amount,"포인트결제");
			
		}
    });
  }
   
 let pay_method = ''; //결제방식
 function onPayMethod(method){pay_method = method}
 
 let amount = 0;
 function onAmount(value){amount = value;}
 