package model.dao;

import java.time.LocalDateTime;

import model.dto.MemberDto;

public class MemberDao extends Dao {

	//싱글톤
	private static MemberDao memberDao = new MemberDao();
	public static  MemberDao getInstance() {return memberDao; }
	private MemberDao() {}


	//1회원가입
	public boolean signup(MemberDto dto) {

		try {
			String sql = " insert into member (mid, mpwd, memail , mfile) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,dto.getMid());
			ps.setString(2,dto.getMpwd());
			ps.setString(3,dto.getMpwd());
			ps.setString(4,dto.getMfile());

			int row = ps.executeUpdate();
			if(row == 1) {return true;}

		} catch (Exception e) {
			// TODO: handle exception
		} return false;
	}



	//2.로그인
	public boolean login(String mid, String mpwd) {
		try {
			String sql = "select * from member where mid=? and mpwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	// 3. 아이디찾기

	// 4. 비번찾기

	//5. 내정보호출
	public MemberDto info(String mid) {
		try {
			String sql = "select mno, mid, memail, mfile from member where mid= ?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			if(rs.next()) {
				MemberDto dto = new MemberDto(
						LocalDateTime.now().toString(),
						rs.getInt("mno"),
						rs.getString("mid"),
						rs.getString("memail"),
						rs.getString("mfile")
					);
				return dto;
			}

		} catch (Exception e) {
			System.out.println("예외발생 :: " + e);
		}
		return null;
	}

	//6. 아이디중복검사
	public boolean isExist(String type,String data) {
		System.out.println("data 다오 " + data);
		String sql;
		// type = memail/ mid
		try {

				sql = "select * from member where "+type+" = ?";


			ps= conn.prepareStatement(sql);

			ps.setString(1, data);
			System.out.println(ps);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.next());

				return true;}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	//7. 회원정보 수정
	public boolean mupdate(int mno, String mfile, String mpwd, String newpwd ) {
		System.out.println("mno :: "+mno );
		System.out.println("mfile :: "+mfile );

		try {
			String sql = "update member set mfile = ?, mpwd = ? where mno = ? and mpwd = ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mfile);
			ps.setString(2, newpwd);
			ps.setInt(3, mno);
			ps.setString(4, mpwd);
			int rs = ps.executeUpdate();
			System.out.println("DAO :: mupdate:: ps>>> "+ps);
			if(rs  == 1) {return true;}
		} catch (Exception e) {
			System.out.println(e);
		}

		return false;
	}

	//8. 회원탈퇴
	public boolean mdelete(int mno, String mpwd) {
		try {
			String sql = "delete from member where mno = ? and mpwd =? ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,mno);
			ps.setString(2, mpwd);
			int rs = ps.executeUpdate();
			System.out.println("ps :: "+ ps);
			System.out.println(" dao::mdelete ::rs :: "+ rs);
			if(rs == 1 ) {

				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return true;
	}



}
