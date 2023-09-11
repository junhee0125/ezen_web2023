package controller.chatting;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/*
 	1. 서버 소켓 만들기
 		1. 클래스 선언
 		2. 클래스 위에 @ServerEndpoint("/서버소켓의URL정의") :  클라이언트소켓들이 접속하는 위치
 		3. 서버 웹소켓의 필수 메소드들...
 			@OnOpen		: 클라이언트 소켓이 서버소켓에  접속했을때 
 			@OnClose 	: 클라이언트소켓이 서버소켓과 연결이 닫혔을때
 			@OnMessage	: 클라이언트 소켓이 메세지를 보냈을 때
 			@OnError	: 클라이언트 소켓이 서버소켓과 연결에 에러가 발생했을때
 
 */
@ServerEndpoint("/ChattingSocket")
public class ChattingSocket {
	public static ArrayList<Session> 접속명단 = new ArrayList<>();
	// 1 . 클라이언트가 서버소켓의 접속했을때 맵핑 연결 (JS,에서 new WebSocket 객체 생성될때,  문제없이 접속되면)
	@OnOpen
	public void OnOpen( Session session) {
		
		
		// 클라이언트가 서버소켓에 접속했을때 매핑연결 (JS에서 new WebSocket
		System.out.println("session :: " + session);
		System.out.println("session.getid :: " + session.getId());
		System.out.println("session.getRequestURI:: " + session.getRequestURI());
		System.out.println("session.getContainer:: " + session.getContainer());
		/*
		 	session :: org.apache.tomcat.websocket.WsSession@52bf2998
			session.getid :: 1
			session.getRequestURI:: ws://localhost/jspweb/ChattingSocket
			session.getContainer:: org.apache.tomcat.websocket.server.WsServerContainer@22546de0	
		  
		 */
		접속명단.add(session);
		System.out.println("접속명단 : " + 접속명단);
	}

	

	
	// 2 . 클라이언트가 서버소켓의 닫혔을때 맵핑 연결 (JS,에서 new WebSocket 객체 초기화될때, 새로고침f5] ,페이지전환 등등])
	@OnClose
	public void OnClose( Session session) {
		접속명단.remove(session);
	}
	
	
	// 3 . 클라이언트가 서버소켓의 메세지를 보냈을때 연결/매핑
	@OnMessage
	public void OnMessage( Session session , String msg) {
		System.out.println("msg :: "+ msg);
		//현재 접속된 명단(클라이언트소켓)들에게 메세지 전달
		for(int i = 0; i <접속명단.size(); i++) {
			Session s = 접속명단.get(i);
			
		}
		for( Session s : 접속명단) {}
		접속명단.forEach(s ->{
			try {
				s.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}//클라이언트 소켓으로부터 메시지를 받았을 때
	
	// 4 . 
//	@OnError
//	public void OnError( Session session) {
//		
//	}
		
}
