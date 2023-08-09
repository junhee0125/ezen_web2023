package 과제.과제11.controller;

import 과제.과제11.model.dao.MemberDao;
import 과제.과제11.model.dto.MemberDto;

public class MemberController {

	//싱글톤
	private static MemberController controller = new MemberController();
	public static MemberController getInstance() { return controller;}
	private MemberController() {}
	
	//2. 회원가입
	public int signupLogic(String id, String pw, String name, String phone) {
		System.out.println("컨트롤러 회원가입");
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(phone);
		//return : 1(성공) 2(DB오류실패) 3(아이디중복) 4(전화번호중복)
		// 1.아이디 중복체크
		if(MemberDao.getInstance().infoCheck( "mid", id )) {return 3;}
		else {System.out.println();}
		if(MemberDao.getInstance().infoCheck( "mphone", phone )) {return 4;}
		// 2.전화번호중복체크
		
		MemberDto dto = new MemberDto(0,id, pw, name, phone);
		
		//결과값을 전달받음
		boolean result = MemberDao.getInstance().signupLogic(dto);
		if(result) {return 1;}
		else {return 2;}
		
	}
	
	//0. 로그인된 회원의 번호를 저장하는 필드 = 웹섹션
	private int loginSession = 0 ; //로그인 했는지 않했는지. 0은 아닌한거 1: 로그인회원의 번호
	
	
	public int getLoginSession() {
		return loginSession;
	}
//	public void setLoginSession(int loginSession) {
//		this.loginSession = loginSession;
//	}
	//3-1. 로그인
	public boolean loginLogic(String id, String pw) {
		System.out.println("컨트롤러 로그인로직");
		System.out.println(id);
		System.out.println(pw);

		int result = MemberDao.getInstance().loginLogoc(id, pw);
		
		if(result >= 1) {
			this.loginSession = result; return true;
			}
		else {return false;}
	}
	
	//3-2 로그아웃
	public void logOut() {this.loginSession = 0;}
	
	//4.아이디찾기
	public String findById(String name, String phone) {
		
		System.out.println(" name : " + name + " | phone : "+phone );
		String result = MemberDao.getInstance().findById(name, phone);
		
		return result;
		
	}
	
	//5.비번찾기
	public String findByPwd(String id, String phone) {
		
		System.out.println(" id : " + id + " | phone : "+phone );
		String result = MemberDao.getInstance().findByPwd(id, phone);
		return result;
		
	}
	
	//6. info ()회원정보 
	public MemberDto info() {
		System.out.println("loginSession  : " + getLoginSession());
		//dao로  로그인세션 넘겨주고 select해오기
		//현재 로그인된 회원번호[loginsesstion]는view에서 전달받지 않고 
		
		return MemberDao.getInstance().info(this.loginSession);
	}
	
	//7. infoUdate() 비밀번호 수정
	public boolean infoUpdate(String newPw) {
		
		boolean result = MemberDao.getInstance().infoUpdate(this.loginSession ,newPw);
		return result;
		
	}
	// infoDelete: 회원탈퇴
	public boolean infoDelete() {
		boolean result = MemberDao.getInstance().infoDelete(this.loginSession);
		return result;
	}
		
}
