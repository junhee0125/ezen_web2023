package model.dao;

public class BoardDao extends Dao{

	//싱글톤
	private static BoardDao boardDao = new BoardDao();
	public BoardDao getInstance() {return boardDao;}
	private BoardDao() { }


	//1 .리스트 출력
	public void boardList() {

	}



	// 2. 글 등록
	public void boardSave() {

	}

	//3. 글 상세보기
	public void boardView() {

	}


	//4. 글 수정
	public void boardUpdate() {

	}


	//5. 글 삭제
	public void boardDelete() {

	}

	// 6.조회수 증가
	public void viewCount() {

	}

}
