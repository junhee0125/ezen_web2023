package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.dao.BoardDao;
import 과제.과제11.model.dto.BoardDto;

public class BoardController {
	
	//싱글톤
	private static BoardController boardController = new BoardController();
	public static BoardController getInstance() { return boardController; }
	private BoardController() {}
	
	//메소드
	// 1. boardWrite
	public boolean boardWrite(String title, String content) {
		
		 if(title.length() ==0 || title.length() > 50) {return false;}
		 BoardDto boardDto = new BoardDto(title, content, MemberController.getInstance().getLoginSession() );
		 return BoardDao.getInstance().boardWrite(boardDto);
		 
		
	}
	// 2. boardprint
	public ArrayList<BoardDto> boardprint() {
		
		return BoardDao.getInstance().boardprint();
	}
	// 3. boardView
	public BoardDto boardView(int bno) {
		return BoardDao.getInstance().boardView(bno);
	}
	
	// 4. boardUpdate
	public int boardUpdate(int bno, int mno, String title, String content ) {
		//System.out.println("I am CONTROL  # bno: "+bno+ " | #title : "+title+" | # content :"+content);
		
		if(title.length() ==0 || title.length() > 50) {return 4;}
		
		if(MemberController.getInstance().getLoginSession() != mno) {return 3;}
		else {
			return BoardDao.getInstance().boardUpdate(new BoardDto(bno,title, content));
		}
		
	}
	// 5. boardDelete
	public int boardDelete(int bno, int mno) {
		
		if(mno != MemberController.getInstance().getLoginSession()) return 3;
		return BoardDao.getInstance().boardDelete(bno);
		
	}
	
	// 쪽지 보내기
	public int sendPostMessage(int bno, int mno, String pcontent) {
		
		int psender = MemberController.getInstance().getLoginSession();
		if(psender <= 0) {return 4;}
		if(pcontent == ""|| pcontent == null) {return 3;}
		BoardDto dto = new BoardDto(bno, mno, pcontent);
		boolean result = BoardDao.getInstance().sendPostMessage(dto,psender);
		if(result) {return 1;} 
		else { return 2;}		
	}
	//
	public ArrayList<BoardDto> checkPostMessage(int mno) {
		return BoardDao.getInstance().checkPostMessage(mno);
	}
	
	public String FindOther(int mno) {
	//	System.out.println("나는 컨트롤 FindOther(int mno) " + mno);
		return BoardDao.getInstance().FindOther(mno);
	}
}
