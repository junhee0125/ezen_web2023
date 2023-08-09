package 과제.과제11.model.dao;

import java.sql.SQLException;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class MemberDao extends Dao {

	//싱글톤
	private static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() { return dao;}
	private MemberDao() {}
	
	
	//2. 회원가입
	
	public boolean signupLogic(MemberDto dto) {
		System.out.println("다오 회원가입로직");
		System.out.println(dto);
		
		//1. 회원가입에 필요한 SQL
		String sql =	"insert into member (mid,mpw,mname,mphone) values( ?, ? , ? ,?)";
		try {
		
			//2. 위에서 작성한  SQL를 DB연동객체에 대입
			//3. 대입된 SQL조작을 위해 반환된 PreparedStatement를  ps에 대입
			ps = conn.prepareStatement(sql);  
			//db연동객체. prepareStatement(조작할 SQL문자열) => preparedStatement를 반환
			
			//4.SQL에서 작성한 매개변수의 ? 자리에서 값 대입 [.setString(?순서번호, 값);]
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			
			//5. SQL실행
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.out.println("회원가입 실패(T^T)☞ 사유: "+ e);
		}
		return false;
		
	}
	//3. 로그인
	public int loginLogoc(String id, String pw) {
		System.out.println("다오 로그인로직");
		System.out.println(id);
		System.out.println(pw);
		 
		String sql =" select * from member where  mid = ? and  mpw =?";
		try {
			ps= conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			
			//실행결과를 rs에 담음. 왜냐믄 ps는 결과를 조작할 수 없는데 rs는 할수 있어서.
			/*insert/ delete/update = executeUpdate();*/
			rs = ps.executeQuery(); /* select*/
			//만약에 결과가
			if(rs.next()) { // 다음 넥스트 객체가 있으면  true, 없으면 false
					
				return rs.getInt(1); //회원번호 반환
				
			};  
			// 결과중에서 다음 레코드 객체를 호출
			/*
			 	만약 결과 레코드가 3개이면. 
			 	null  - 레코드객체1 - 레코드객체2 - 레코드 객체3 ( 첫번째 값이 깡통이라..)
			 	 	.next()		.next()		.next() 해서  
			 	- 결과 레코드 수만큼  next를 하니깐,
			 	만일 많은 양의 레코드를 읽어오려면 반복분이 필요함 	
			 		
			 */
			
			
		} catch (Exception e) {
			System.out.println("로그인 실패(T^T)☞ 사유: "+ e);
		} return 0; // 로그인 실패
			
	}	
	//4.아이디찾기
	public String findById(String name, String phone) {
		
		System.out.println(" name : " + name + " | phone : "+phone );
		String sql = "select  mid  from member where mname = ? and mphone =? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);

			
			rs= ps.executeQuery();
			if(rs.next()) {return rs.getString("mid"); };
		} catch(Exception e ) {
			System.out.println("검색실패 : " + e);
		}
		return null;
	}
	
	//5.비번찾기
	public String findByPwd(String id, String phone) {
		System.out.println(" id : " + id + " | phone : "+phone );
		
		try {
			String sql = "select mpw from member where mid= ? and mphone= ?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, phone);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("검색 실패  : "+ e);
		}
		return null;
	}
	
	// 6. 중복체크 (아이디 / 전화번호)
	public boolean infoCheck(String 검색할필드명, String 검색할값) { //검색할 필드명 , 검색할 값
		System.out.println("id  : " + 검색할값);
		
	
		// String sql = "select * from member where "+ 검색할필드명 +"= '"+ 검색할값+"'";	
		String sql = "select * from member where "+ 검색할필드명 +" = ?";	
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, 검색할값);
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			if (rs.next()) {return true;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	// 회원정보 Info()
	public MemberDto info(int mno) {
		//한명의 회원정보 (1개의 dto반환)
		System.out.println("mno  : " + mno);
		
		try {
			
			String sql = "select * from member where mno=?";
			ps = conn.prepareStatement(sql); // 2. sql조작할 객체
			ps.setInt(1, mno);				// 3. sql조작
			rs = ps.executeQuery();				//4.sql실행 ,  5sql결과 조작객체에 대입

			if(rs.next()) {
				MemberDto dto = new MemberDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), // 비밀번호는 개인정보보호를 위해 null로 하는것이
						rs.getString(4), 
						rs.getString(5));
				return dto;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
				
		
	}
	
	//infoUdate() 비밀번호수정
	public boolean infoUpdate(int loginSession, String newPw) {
		
		try {
			String sql = "update member set mpw = ? where mno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPw);
			ps.setInt(2, loginSession);
			int row = ps.executeUpdate();
			if(row ==1 ) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
	}
	
	// infoDelete: 회원탈퇴
	public boolean infoDelete(int mno) {
		
		try {
			String sql = "delete from member where mno =? ";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, mno);
			int row = ps.executeUpdate(); // 삭제된 레코드 수를 반환
			if(row ==1 ) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return false;
		
		
	}	
}
