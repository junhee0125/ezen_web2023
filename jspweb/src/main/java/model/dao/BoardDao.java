package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao extends Dao{

	//싱글톤
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() { }



	// 1. 글 등록
	public boolean boardSave(BoardDto boardDto) {
		try {
			String sql = "INSERT INTO BOARD(BTITLE, BCONTENT, BFILE, MNO,BCNO) VALUE(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,boardDto.getBtitle());
			ps.setString(2,boardDto.getBcontent());
			ps.setString(3,boardDto.getBfile());
			ps.setInt(4,boardDto.getMno());
			ps.setInt(5,boardDto.getBcno());
			int rs = ps.executeUpdate();
			if(rs ==1) { return true; 	}
		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}
		return false;
	}

	//2 .리스트 출력
		public ArrayList<BoardDto> boardList(int bcno) {
			ArrayList<BoardDto> list = new ArrayList<>();
			try {
				String sql = " select a.*, " +
						"        b.mid as mid, " +
						"        b.mfile as mfile, " +
						"        c.bcname as bcname " +
						" from board a " +
						" natural join member b, bcategory c " +
						" where a.bcno = c.bcno " +
						" order by a.bdate desc";
				ps = conn.prepareStatement(sql);
//				ps.setInt(1, bcno);
				System.out.println(ps);
				rs = ps.executeQuery();
				while(rs.next()) {
					BoardDto boardDto = new BoardDto(
							rs.getInt("bcno"), 		rs.getString("bcname"),
							rs.getInt("bno"), 		rs.getString("btitle"),
							rs.getString("bcontent"), rs.getInt("mno"),
							rs.getInt("bview"), rs.getString("bfile"),
							rs.getString("bdate"), rs.getString("mid"),
							rs.getString("mfile"));
					list.add(boardDto);
				}

			} catch (Exception e) {
				System.out.println("Exception :: "+ e);
			}
			return list;
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
