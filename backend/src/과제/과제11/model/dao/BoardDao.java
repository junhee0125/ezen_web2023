package 과제.과제11.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import 과제.과제11.model.dto.BoardDto;



public class BoardDao extends Dao {
	
	//싱글톤
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() {}
	
	//메소드
	// 1. boardWrite
	public boolean boardWrite(BoardDto boardDto) {
		try {
			String sql = " insert into board (btitle, bcontent, mno) "
						+ "values (?,?,?)";
			ps= conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3,boardDto.getMno());
			int row = ps.executeUpdate();;
			if (row == 1)			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
		
		
	}
	// 2. boardprint
	public ArrayList<BoardDto> boardprint() {
		ArrayList<BoardDto> list = new ArrayList<>(); //여러개 BoardDto를 저장할 리스크 객체 선언
		try {
			
			//String sql = "select * from board order by bdate desc"; //처음
			String sql ="select b.*, m.mid from member m natural join board b  order by b.bdate desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//여러개의 레코드 조회
			while(rs.next()) {
				//System.out.println(rs);
				//System.out.println(rs.getInt(1));
				BoardDto dto = new BoardDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6), 
						rs.getString(7));
				list.add(dto);
				
				//현제 레코드수는 3개..  next()도 3번 하게됨..: 
				// 다음 레코드로 이동하는 메소드로 다음 레코드로 이동하면 true 아님 false
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	// 3. boardView
	public BoardDto boardView(int bno) {
		
		try {
			String sql = "select b.*, m.mid from board b natural join member m where b.bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto  dto = new BoardDto(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
				boardViewCount(rs.getInt(1), rs.getInt(5));
			return dto;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return null;
	}
	
	//3-1 조회수 증가함수
	public boolean boardViewCount(int bno, int bview) {
		try {
			String sql = " update board set  bview = ? where bno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ++bview);
			ps.setInt(2, bno);
			int row = ps.executeUpdate();
			if(row ==1) {return true ;} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return false;
	}
	
	// 4. boardUpdate
	public void boardUpdate() {
		
	}
	// 5. boardDelete
	public void boardDelete() {
		
	}
}
