/**
 * 

 * 
 */

console.log('chatting JS 연결');

// * ajax(기본값 비동기통신) 가 응답의 결과를 가지고 오기전에 아래코드 실행. [ loginState 변경되기전에 실행되므로 문제발생 ]
// - 해결방안 ajax 동기화 통신 하자.. 
// 1. 비 로그인시 입장 불가능.. 
if( loginState == false ){ alert('회원전용 페이지입니다.'); location.href="/jspweb/member/login.jsp"; }

// 2. JS 클라이언트[유저] 소켓 만들기 
console.log( '채팅방에 입장한 아이디 : ' + loginMid );
let clientSocket = new WebSocket(`ws://192.168.17.148:80/jspweb/serversokcet/${loginMid}`);
	// - 클라이언트소켓이 생성되었을때 자동으로 서버소켓에 접속 ----> 서버소켓의 @OnOpen 으로 이동
	// - 서버소켓URL에 매개변수 전달하기 [- 주로 식별자 전달 ] 서버소켓URL/데이터1/데이터2/데이터3
//let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket')


//메소드 4가지 자동실행
	//자동실행 : 클라이언트 소켓이 정상적으로 서버소켓 접속했을때
	clientSocket.onopen = e => {
		console.log('서버와 접속성공' + e ); 
		//1-2 만약에 접속을 성공하면 알림메시지 전송
		let msg = { 
			type : 'alarm',
			content:`짜란~ ${loginMid}님이 입장했습니다.`}
			//clientSocket.send(msg);//문제발생
			clientSocket.send(JSON.stringify(msg));
		
	
	};
	//자동실행 : 클라이언트 소켓과 연결에서 오류가 발생했을때
	clientSocket.onerror = e => {console.log('서버와 오류발생' + e); };
	//자동실행 : 클라이언트 소켓이 연결이 끊겼을때
	clientSocket.onclose = e => {
		console.log('서버와 연결끊김' + e); 
		let msg = {
			type:'outalarm',
			content:`${loginMid}님이 채팅방에서 나가셨습니다.`
		}
		clientSocket.sent(JSON.stringify(msg));
	};
	//자동실행 : 클라이언트 소켓이 메시지를 받았을때
	clientSocket.onmessage = e => {onMsg(e);};



//3.  서버에게 메세지 전송
function onSend(){
	console.log('전송!');
	// 3-1입력값 호출
	let msgValue = document.querySelector('.msg').value;
	if(msgValue =='' || msgValue =='\n'){
		alert('내용을 입력하세요'); 
		document.querySelector('.msg').value = '';
		return;
	}
	
	//3-2
	let msg = {type:'message', content : msgValue}
	
	console.log("msg :: "+msg)
	clientSocket.send(JSON.stringify(msg)); //JSON타입(형식 포맷)은  JSON인데 문자열로 변환
	//console.log("result :: "+ clientSocket.send(msg));
	//클라이언트소켓과 연결된 서버소켓에게 메세지 전송 ===> 서버소켓의 @onMessage로 ㅇ이동
	//3-3
	//메시지 성공시 입력상자 초기화
	document.querySelector('.msg').value = '';
	
}

//4.  메시지를 받았을때 추후 행동(메소드) 선언
function onMsg(e){
	console.log("e  :: " + e) // 메시지 받을때 발생한 이벤트 정보가 들어있는 객체
	
	let msgbox = JSON.parse(e.data); //제이슨형식인지  object인지 확인할것.
	
	//JSON
	//1. 어디에 출력할지
	let chatcont = document.querySelector('.chatcont');
	let html ='';
	console.log(msgbox)
	//msg.split(`\n`)[0]
	//console.log(msg.msg.split(`\n`)[0])
	//msg.msg.replace('\n','<br/>');
	
	
	// 특정 문자열을 찾아서 1개치환 /바꾸기 교체
	//let content = msg.msg.replace('\n','<br/>')
	//console.log(content);
	
	// 특정문자열을 찾아서 찾은 문자열 모두 치환 /바꾸기.교체 =? 자바 replaceAll()"
	/*	-g(global) : 전역 검색
		-i(ignore) : 대소문자 무시
		-m(multiline) : 여러줄을 검사 
		' ' < -- 정규표현식 문자열처리 안함
	*/
	
	//let content = msgbox.msg.replace(/\n/g,'<br>');
	//msgbox.msg = JSON.parse(content);
	//console.log('msg.msg.type  :: '+msgbox.msg.type);
	
	msgbox.msg = JSON.parse(msgbox.msg)
	msgbox.msg.content = msgbox.msg.content.replace(/\n/g,'<br>');
	
	/*
	if(msg.msg.type == 'message') {
		content = msg.msg.content.replace(/\n/g,'<br>');
	} else if(msg.msg.type == 'emo'){
		content = `<img src="/jspweb/img/imoji/emo${Number(msg.msg.conetnt)}.gif"/>`
	}
	*/
	
	
	
	
	//타입이 알람이면.
	if(msgbox.msg.type == 'alarm'){
		
		html = `${typeHTML(msgbox.msg)}`
	
	} else if(msgbox.msg.type == 'outalarm'){
		
		html = `${typeHTML(msgbox.msg)}`
	
	} else if( msgbox.fromMid == loginMid){
		html = `<div class="rcont">
					<div class="subcont">
						<div class="date">${msgbox.date}</div>
						${typeHTML(msgbox.msg)}
					
					</div>
			
				</div>`;
	} else {
		html=`<div class="lcont">
				<img src="/jspweb/member/img/${msgbox.fromimg}">
				<div class="tocont">
					<div> ${msgbox.fromMid}</div>
					<div class="subcont"> 
						${typeHTML(msgbox.msg)}
						<div class="date">${msgbox.date}</div>
					
					</div>
				</div>
		
			</div>`
	}

	
	chatcont.innerHTML += html;
	
	// ---------------[스크롤 최하단으로 내리기 -스크롤 이벤트]-----------------//
	// 1.현재 스크롤의 상단 위치 좌표
	let topHeight = chatcont.scrollTop; //dom객체.scrollTop : 해당스크롤 상단위치
	console.log('topHeight :: '+topHeight);
	
	// 2.현재 dom객체의  전체높이 
	let scrollHeight = chatcont.scrollHeight // 상하회살표버튼사이의 길이
	console.log('scrollHeight :: '+scrollHeight);arguments
	
	//3. 
	 chatcont.scrollTop = chatcont.scrollHeight;
}


//5. textarea 입력창에서 입력할때마다 이벤트 발생함수
 function onEnterKey(){

	let msgValue = document.querySelector('.msg').value;
	if(msgValue =='' || msgValue =='\n'){
		alert('내용을 입력하세요'); 
		document.querySelector('.msg').value = '';
		return;
	}
	 
	if(window.event.keyCode==13 && window.event.ctrlKey){
		document.querySelector('.msg').value +=`\n`; 
		return;
	}
 
	 // 1. 만약에  입력한 키가 엔터키이면 메시지 전송
	if(window.event.keyCode == 13){onSend(); return;} 
}	

// 6.이모티콘 출력하기
getEmo();
 function getEmo(){
	
	for(let i=1; i<= 43 ; i++){
		document.querySelector('.emolist').innerHTML
		+= `<img onclick="sendEmo(${i})" src="/jspweb/img/imoji/emo${i}.gif">`;
		
	} 
 }
 
 //7. 이모티콘 전송하기
 function sendEmo(i){ 
	 // type : msg [메시지] / emo [이모티콘] / img [사진]
	 // 1. msg 구성
	 let msg = {type: 'emo', content: i+""}// int 문자열로
	 
	 
	 // 2. 보내기
	 clientSocket.send(JSON.stringify(msg))
	  
	 
 }
 
 // 8 .msg 타입에 따른 HTML 함수
function typeHTML(msg){
	let html = ``;
	
	//1. 메시지 타입일때 div반
	if(msg.type == 'message'){
		html +=`<div class="content">${msg.content}</div>`
	} else if( msg.type=='emo'){
		html+=`<div ><img src="/jspweb/img/imoji/emo${msg.content}.gif"/></div>`
	} else if( msg.type=='alarm'){
		html+=`<div class="alram">${msg.content}</div>`
	} else if( msg.type=='outalarm'){
		html+=`<div class="alram">${msg.content}</div>`
	}
	return html;
}

/*
	JS[html 파일에 종속된 파일 -  따라서 html 안에서 실행되는 구조]
	코드는 1개이지만 클라이언트 (사용자)는 여려명..즉 실행은 다수라는것.
	# 소켓이란..
		통신의 종착점 [데이터 전달되는 위치]
	# 클라이언트PC: 데이터를 요청하는 pc
	# 서버PC : 데이터를 제공하는 pc	
		
		강호동이 신동엽에게 편지를 보낼때.
			강호동이 신동엽에게 보내는것이 아아미
			강호동이 - > 우체국 > 신동엽으로 전달된다는것
		
	
	# URL[주소]상의 매개변수 전달하는 방법
	1. 쿼리스트링 방식 : URL?매개변수1=데이터1&매개변2=데이터2&매개변수3=데이터3]
		
		
	# WebSocket 웹소켓 라이브러리
		- 소켓 관련된 함수들을 제공하는 클래스
		- new WebSocket('ws://localhost:80/jspweb/ChattingSocket')
		new WebSocket('ws://ip주소:포트번호/프로젝트명/서버경로')
	
	# 동기화 vs 비동기화
		사용자가 요청하면 서버는 응답하는  방식
		그런데 서버가 요청에 대한 응답을 위해 처리중인경우
		# 동기화는 요청1에 대한 응답1이 완료할 때까지 대기상태로 만들어서 요청2를 받지 않음
			* 결과에 따른 다음 요청이 필요할때. 
		# 비동기화는 요청1에 대한 응답에 대한 처리중에도 대기상태로 만들지 않기때문에 새로운 요청2를 받을 수 있다.
			* 다른 기능을 동시에 처리해야 할때 예) 동영상을 바이트로 코드로 변환하면서 댓글 등록하고, 검색하고 , 좋아요도
	# AJAX:기본값이 비동기화이므로 
 */


/*
 // 1.클라이언트 소켓 만들기
 	// 1. JS웹소켓 객체 [WebSocket 클래스]
 			//let 클라이언트소켓 = new WebSocket('ws://ip주소:포트번호/프로젝트명/서버소켓의URL');
 	let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket');
 	console.log(클라이언트소켓);
 	
 	// 2. onopen, onclose, send, onmessage
 	//내가 만든 함수를 클라이언트소켓 속성에 대입
 	클라이언트소켓.onmessage = (event) => onmsg(event)
 	
 	
 	
// 2. 연결된 서버소켓에게 메시지 보내기 	
function mesgsend(){
	 // 1.인풋박스의 입력값 가져오기
	 let msg = document.querySelector('.inputContent').value;
	 
	 //2. 클라이언트 소켓.send(msg); //입력받은 데이터 뵤내기
	클라이언트소켓.send(msg);
	
	//3. 
	document.querySelector('.inputContent').value = '';

}//f end

//3. 연결된 서버스켓으로부터 메시지를 바당ㅆ을때  
function onmsg(event){
	console.log(event);
	console.log(event.data);
	
	document.querySelector('.contentBox').innerHTML += `<div>${event.data}</div>`
}
*/