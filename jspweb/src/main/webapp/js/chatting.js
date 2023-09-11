/**
 * 
 * 
 * 
 * 
 * 
 */

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