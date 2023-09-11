package controller.chatting;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MsgDto;

@ServerEndpoint("/serversokcet/{mid}") // 서버소켓 URL 
public class ServerSocket {
	// 0. 접속된 클라이언트소켓들의 저장소 [ 세션 , 아이디 저장 => ClientDto  ]
	public static List< ClientDto > clientList = new Vector<>();
	
	// 1. 클라이언트소켓으로부터 접속받았을때. 
	@OnOpen 
	public void onOpen( Session session , @PathParam("mid") String mid ) {
		System.out.println("클라이언트 소켓이 입장했습니다."+ session );
		System.out.println("접속한 회원아이디 "+ mid );
		// 1-1 : 접속된 클라이언소켓을 리스트에 저장하자.
		ClientDto clientDto = new ClientDto(session, mid);
		clientList.add( clientDto );
		System.out.println("접속된 클라이언트들 : " + clientDto );
	}
	// 2. 
	@OnMessage
	public void onMessage( Session session, String msg) throws IOException {
		
		System.out.println("보낸 클라이언트소켓 [누구]"+ session + "보낸내용 [무엇을] :: " + msg  );
		//2-2 메세지를 보낼 내용 구성, [보낸사람, 보낸내용]
		MsgDto msgDto = null ;
		for(ClientDto clientDto : clientList) {
			if(clientDto.getSession() == session) {
				System.out.println("clientDto.getMid() "+clientDto.getMid());
				msgDto = new MsgDto(clientDto.getMid(), msg);
				break;
			}
		}
		
		// - msgDto를 json사용할 수 있도록 형변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonMsg = mapper.writeValueAsString(msgDto);
		for(ClientDto clientDto : clientList) {
			clientDto.getSession().getBasicRemote().sendText(jsonMsg); //예외처리 필수
		}
	}
	
	//3 에러났을때
	//OnError로 annotate된 클래스 [controller.chatting.ServerSocket]의 메소드 [onError]에 Throwable 파라미터가 없습니다.
	// >>> Throwable throwable 파라미터 추가
	@OnError
	public void onError( Session session,Throwable throwable ) {
		
		
	}
	//4 클라이언트소켓과 서버소켓이 연결이 끊겼을때
	@OnClose
	public void onClose( Session session ) {
		//* 접속목록에서 세션을 제거해야 함

		for(ClientDto clientDto : clientList) {
			// 접속목록에서 연결이 끊긴 세션 찾기
			if(clientDto.getSession() == session) { //
				//클라이언트 소켓의세션과 연결이 끊긴 세션 제거
				clientList.remove(clientDto);
				break;
			}
		}
		
	}
	
}
/*
	* WebSocket 서버 소켓 라이브러리 제공
		1. 서버소켓 클래스 생성 
			- 클래스위에 서버소켓의 URL 만들기 
				@ServerEndpoint("/serversokcet")
			- 만약에 서버소켓의 URL 경로상의 매개변수를 받을때. 
				@ServerEndpoint("/serversokcet/{매개변수명1}/{매개변수명2}")
				
		2. 서버소켓 메소드 제공 
				- 메소드 매개변수의 규칙 존재 
				1. 클라이언트 소켓이 접속했을때 실행되는 자동실행되는 메소드
				@OnOpen
						public void onOpen( Session session ) { }
							- Session : 서버소켓의 접속된 클라이언트소켓 정보
						public void onOpen( Session session , @PathParam("매개변수명1") 타입 매개변수명 ) { }
				
				2.클라이언트 소켓이 접속했을때 실행되는 자동실행되는 메소드
				@OnClose
						public void onClose( Session session ) {}
				3. 클라이언트 소켓과 오류가 발생했을때. 자동실행되는 메소드	
				@OnError
						public void onError( Session session ) {}
						
				4. 클라이언트 소켓이 접속했을때 실행되는 자동실행되는 메소드		
				@OnMessage
					public void onnMessage( Session session, String msg) { }
					클라이언트소켓
 */