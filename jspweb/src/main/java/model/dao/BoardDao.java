package model.dao;

import model.dto.BoardDto;

public class BoardDao extends Dao{

	//싱글톤
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() { }


	//1 .리스트 출력
	public void boardList() {
		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}

	}



	// 2. 글 등록
	public void boardSave(BoardDto boardDto) {
		try {
			
		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}

	}

	//3. 글 상세보기
	public void boardView() {
		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}

	}


	//4. 글 수정
	public void boardUpdate() {
		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}

	}


	//5. 글 삭제
	public void boardDelete() {
		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}

	}

	// 6.조회수 증가
	public void viewCount() {
		try {

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}

	}

}
