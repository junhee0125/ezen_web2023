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
	public int boardUpdate(BoardDto boardDto) {
			System.out.println("I am DAO  # bno: "+boardDto.getBno()+" | #title : "+boardDto.getBtitle()+" | # content :"+boardDto.getBcontent());
		try {
			
			String sql = "update board set btitle = ?, bcontent = ? where bno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3,boardDto.getMno());
			int row  = ps.executeUpdate();
			if(row == 1 ) {return 1;}
			/*
			 	update or delete를 실행할경우
				실패인 경우에도 성공 메시지를 반환함
				하지만 int row  = ps.executeUpdate(); ㅇ이렇게 받으면
				실패한 경우 row는  0 값을 갖는다.
				반대로 1개의 데이터를 삭제, 수정한경우 1의 값을 반환한다.
			*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;		
		
	}
	// 5. boardDelete
	public int boardDelete(int bno) {
		
		try {
			String sql = "delete  * from board  where bno = ?";
			ps= conn.prepareStatement(sql);
			ps.setInt(0, bno);
			int row = ps.executeUpdate();
			if(row == 1) {return 1;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 2;
		
	}

	
	//쪽지보내기
	public boolean sendPostMessage(BoardDto dto, int senderNo) {
		try {
			
			String sql = "insert into postmessage(psender, preciver,pcontent,bno) values (?,?,?,?) ";
			
			ps= conn.prepareStatement(sql);
			ps.setInt(1, senderNo);
			ps.setInt(2, dto.getMno());
			ps.setString(3, dto.getPcontent());
			ps.setInt(4, dto.getBno());
			
			int row = ps.executeUpdate();
			if(row ==1) { return true; }		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return false;
	}
	
	public ArrayList<BoardDto> checkPostMessage(int mno) {
		ArrayList<BoardDto> list = new ArrayList<>(); //여러개 BoardDto를 저장할 리스크 객체 선언

		try {
			
			String sql = "select bno, pno, pcontent, psender, preciver, pdate from postmessage where preciver = ? or psender = ?";
			ps= conn.prepareStatement(sql);
			ps.setInt(1,mno);
			ps.setInt(2, mno);
			rs = ps.executeQuery();
			//	public BoardDto(int bno, int pno, String pcontent, int psender, int preciver, String pdate) {
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
				list.add(dto);
			}
			//System.out.println("row : "+ rs.next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String FindOther(int mno) {
		try {
			String sql = "select mid from member where mno =?";
			ps=conn.prepareStatement(sql);
//			System.out.println("ps : "+ ps);
			ps.setInt(1, mno);
			rs = ps.executeQuery();
			//System.out.println("rs.getString(1); : "+ rs.getString(1));
			if(rs.next()) {return rs.getString(1);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
