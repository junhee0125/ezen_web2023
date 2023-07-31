package java1.day13.Ex2.controller;

import java.util.ArrayList;

import java1.day13.Ex2.model.dao.BoardDao;
import java1.day13.Ex2.model.dto.BoardDto;

public class BoardController {
	
	//싱글톤 : 게시물마다가 아닌 모든 게시물이 하나의 
	private static BoardController boardController = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() {return boardController;}
	
	//글 등록 처리 기능함수 [C] -07/31 김준희 작업중
	public boolean writeLogic( String writer, String content) {
		
		// 1. 매개변수로부터 전달받은 content, writer를 하나의 객체로 선언
		BoardDto boardDto = new BoardDto( writer , content);
		//등록시 조회소 0으로 셋팅
		boardDto.setView(0);
		
		BoardDao.getInstance().boardDtoList.add(boardDto); //add()함수
		return true;
	}

	//글 1개 출력 처리 기능함수
	public BoardDto printLogic(int index) {
		BoardDto boardDto = BoardDao.getInstance().boardDtoList.get(index);
		
		//view를가져와서
		int view = boardDto.getView()+1;
		boardDto.setView(view);
		//BoardDao.getInstance().boardDtoList.getView();
		return boardDto;
		
	}
	//글 수정 처리 기능함수
	public boolean updateLogic(int index, String writer, String content) {
		BoardDto boardDto  = BoardDao.getInstance().boardDtoList.get(index);
		boardDto.setWriter(writer);
		boardDto.setContent(content);
		
		BoardDao.getInstance().boardDtoList.set(index, boardDto);
		return true;
		
	
	}
	//글 삭제 처리 기능함수
	public boolean deleteLogic(int index) {
		BoardDao.getInstance().boardDtoList.remove(index);
		return true;
		
	}
}
