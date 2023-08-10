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
	public void boardUpdate() {
		
	}
	// 5. boardDelete
	public void boardDelete() {
		
	}
}
