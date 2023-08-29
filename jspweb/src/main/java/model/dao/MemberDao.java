package model.dao;

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



	//2.로그링ㄴ


	// 3. 아이디찾기

	// 4. 비번찾기

	//5. 내정보호출

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

	//8. 회원탈퇴



}
