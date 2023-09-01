package model.dao;

import model.dto.LibraryDto;

public class LibraryDao extends Dao{

	//싱글톤
	private  static LibraryDao libraryDao = new LibraryDao();
	public static LibraryDao getInstance() {return libraryDao;}
	private LibraryDao() {}



	//입실정보등록
	public boolean checkIn(LibraryDto dto){

		String sql = "insert into library ( lname, lphone, lseatno ) values(?,?,?)";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, dto.getLname());
			ps.setString(2, dto.getLphone());
			ps.setInt(3, dto.getLseatno());

			int rs = ps.executeUpdate();
			// library 정보가 정상등록되면 seat테이블을 업데이트
			if(rs == 1 ) {
				System.out.println("library 등록 성공");

				sql = "update seat set  lisuse = ? where lseatno =? ";
				ps= conn.prepareStatement(sql);
				ps.setBoolean(1, dto.isLisuse());
				ps.setInt(2, dto.getLseatno());

				rs = ps.executeUpdate();
				if(rs == 1) {
					System.out.println("seat 등록 성공");
					System.out.println(" 입실등록이 정상처리되었습니다.");
					return true;
				} else {
					sql = "delete from library where lseatno = ? and lphone=?";
					ps= conn.prepareStatement(sql);
					ps.setInt(1, dto.getLseatno());
					ps.setString(2, dto.getLphone());
					rs = ps.executeUpdate();
					if(rs == 1 ) {
						System.out.println("seat 테이블 업데이트에 문제로 먼저 입력된 libary 정보가 삭제되어었습니다.");
						return false;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} return false;






	}

	//퇴실정보등록 (입실정보수정)
	public boolean checkOut(LibraryDto dto ) {

		String sql = "update library set loutdate = now() "
					+ "where lseatno = ? "
					+ " and lname = ? "
					+ " and lphone = ? ";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getLseatno());
			ps.setString(2, dto.getLname());
			ps.setString(3, dto.getLphone());
			System.out.println("ps1 : "+ps);
			int rs = ps.executeUpdate();
			if(rs == 1 ) {
				sql = "update seat set  lisuse = ? where lseatno = ? ";
				ps= conn.prepareStatement(sql);
				ps.setBoolean(1, dto.isLisuse());
				ps.setInt(2, dto.getLseatno());
				System.out.println("ps2 : "+ps);
				rs = ps.executeUpdate();
				if(rs == 1) {
					System.out.println(" 퇴실등록이 정상처리되었습니다.");
					return true;
				} else {
					sql = "update library set where loutdate = null "
							+ "lseatno = ? and lphone=?";
					ps= conn.prepareStatement(sql);
					ps.setInt(1, dto.getLseatno());
					ps.setString(2, dto.getLphone());
					rs = ps.executeUpdate();
					if(rs == 1 ) {
						System.out.println("seat 테이블 업데이트에 문제로 먼저 입력된 libary 퇴실시간정보가 삭제되어었습니다.");
						return false;
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;

	}

	//좌석정보출력
	public void showSeat(){


	}
}
