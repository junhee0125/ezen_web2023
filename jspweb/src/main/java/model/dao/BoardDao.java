package model.dao;

import java.util.ArrayList;
import model.dto.BoardDto;

public class BoardDao extends Dao{

	//싱글톤
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {return boardDao;}
	private BoardDao() { }




	//1 .리스트 출력
		public ArrayList<BoardDto> boardList(int bcno, int listsize , int startrow) {
			// * 게시물 레코드 정보의 DTO를 여러개 저장하는 리스트 선언
			ArrayList<BoardDto> list = new ArrayList<>();
			try {
			String sql = " select b.* , m.mid , m.mfile , bc.bcname "
					+ " from board b "
					+ "		natural join bcategory bc "
					+ "		natural join member m ";
			if(bcno != 0 ) {
					sql += "where bcno = " + bcno;
			}
			
			// 공통
					sql+= " order by b.bdate desc "
			//게시물수 
					+ "		limit  ?, ?"; //시작번호부터 최대게시물수만큼 출력
			
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startrow);
			ps.setInt(2, listsize);
			rs = ps.executeQuery();
			
			System.out.println(" boardList SQL :: " + ps);
				while( rs.next() ) {
				BoardDto boardDto = new BoardDto(
						  rs.getInt("bcno")
						, rs.getString("bcname")
						, rs.getInt("bno")
						, rs.getString("btitle")
						, rs.getString("bcontent")
						, rs.getInt("mno")
						, rs.getInt("bview")
						, rs.getString("bfile")
						, rs.getString("bdate")
						, rs.getString("mid")
						, rs.getString("mfile"));
				list.add(boardDto);
			    }
			} catch (Exception e) {
				System.out.println("Exception :: "+ e);
			}
			return list;
		}

// 2. 글 등록
	public boolean boardSave(BoardDto boardDto) {
		try {
			String sql = "insert into board( btitle, bcontent, bfile, mno, bcno) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,boardDto.getBtitle());
			ps.setString(2,boardDto.getBcontent());
			ps.setString(3,boardDto.getBfile());
			ps.setInt(4,boardDto.getMno());
			ps.setInt(5,boardDto.getBcno());
			int rs = ps.executeUpdate();
			if(rs ==1 ) return true;

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}
		return false;
	}

	//3. 글 상세보기
	public BoardDto boardView(int bno) {
		//조회수 증가
		viewCount(bno);

		try {
			String sql = " select b.* , m.mid , m.mfile , bc.bcname "
					+ " from board b "
					+ "		natural join bcategory bc "
					+ "		natural join member m "
					+ " where bno = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			System.out.println(" boardView SQL :: " + ps);
			if( rs.next()) {
				BoardDto boardDto = new BoardDto(
						  rs.getInt("bcno")
						, rs.getString("bcname")
						, rs.getInt("bno")
						, rs.getString("btitle")
						, rs.getString("bcontent")
						, rs.getInt("mno")
						, rs.getInt("bview")
						, rs.getString("bfile")
						, rs.getString("bdate")
						, rs.getString("mid")
						, rs.getString("mfile"));

				return boardDto;
			}

		}catch (Exception e) {System.out.println(e);}
		return null;

	}


	//4. 글 수정
	public boolean boardUpdate(BoardDto dto) {
		try {

			String sql = "update board set "
					+ "	  		 btitle = ? "
					+ " 	   , bcontent = ?  "
					+ " 	   , bfile = ? "
					+ " 	   , bcno = ?"
					+ "   where  bno = ?" ;
			ps= conn.prepareStatement(sql);
			ps.setString(1,dto.getBtitle() );
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getBcno());
			ps.setInt(5, dto.getBno());
			int rs = ps.executeUpdate();

			System.out.println("boardUpdate _ SQL ::" + ps);
			if(rs ==1) return true;

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		}
		return false;

	}


	// 5. 글 삭제
	public boolean boardDelete(int bno) {
		try {
			String sql="delete from board where bno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int rs = ps.executeUpdate();
			if(rs == 1) { return true;}

		} catch (Exception e) {
			System.out.println("Exception :: "+ e);
		} return false;

	}


	// 6. 조회수 증가
		public boolean viewCount( int bno ) {
			try {
				String sql = "update board set bview = bview+1 where bno = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt( 1 , bno );
				int count = ps.executeUpdate();
				if( count == 1 ) return true;
			}catch (Exception e) {System.out.println(e);}
			return false;
		}
		
	// 7. 전체레코드 수
		public int getTotalCount (int bcno) {
			
			// 7-1 전체레코드수
			
			try {
				String sql = " select count(*)  from board ";
				if(bcno != 0) {
					sql += " where bcno = ? " + bcno;
				}
				ps= conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) return rs.getInt(1);
				
			} catch (Exception e) {
				// TODO: handle exception
			} return 0;
			
			
		}
		

}
