package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;
import 과제.과제11.model.dto.MemberDto;

public class LoginPage {
	
	//싱글톤
	private static LoginPage  loginPage = new LoginPage();
	private LoginPage() {}
	public static LoginPage getInstance() {return loginPage;}
	
	
	//0 입력객체
	Scanner sc = new Scanner(System.in);
	// 1. loginMenu : 로그인햇을 때 메뉴
	public void loginMenu() {
		while(MemberController.getInstance().getLoginSession() !=0) {
		System.out.println("\n\n===== ===== ===== =====");
		System.out.println("1.로그아웃 |2.회원정보 | 3.글쓰기");
		
		try {
			int ch = sc.nextInt();
			if(ch == 1 ) {MemberController.getInstance().logOut();}
			if(ch == 2 ) {info();}
			if(ch == 3 ) {boardWrite();}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("잘못된 입력입니다.");
			sc = new Scanner(System.in);
		} // catch e
		
		}//while e
	}
	
	// 2. info		: 회원정보 페이지
	public void info() {
		//1.컨트롤에서 회원정보 요청해서 1명의 DTo반환받기
		MemberDto result=  MemberController.getInstance().info();
		
		//2. 반환받은 회원정보객체[memberDto]의 각 필드 출력
		System.out.println("\n\n========if ========");
		System.out.println("아이디 : " + result.getMid());
		System.out.println("이름 : " + result.getMname());
		System.out.println("전화번호 : "+ result.getMphone());
		
		//서브메뉴
		System.out.print("1. 비밀번호수정 2.회원탈퇴 3.뒤로가기 선택>>");
		int ch = sc.nextInt();
		if( ch == 1 ) {infoUpdate();}
		if( ch == 2 ) {infoDelete();}
		if( ch == 3 ) {return;}
		
	}
	// 3. infoUpdate: 비밀번호 수정
	public void infoUpdate() {
		System.out.println("\n\n ======비번수정 ======");
		System.out.println("수정할 비밀번호를 입력하세요. >>");
		String newPw = sc.next();
		boolean result = MemberController.getInstance().infoUpdate(newPw);
		if(result) {
			System.out.println("비밀번호가 수정되어  로그아웃됩니다.");
			MemberController.getInstance().logOut();
		} else { System.out.println(" 비밀번호 수정실패 : 관리자에게 문의");}
	}
	// 4. infoDelete:
	public void infoDelete() {
		System.out.println("\n\n ======회원탈퇴 ======");
		System.out.println("정말 탈퇴하시겠습니까?? 1. 예 2.아니오");
		int ch = sc.nextInt();
		
		if(ch == 1) {
			boolean result = MemberController.getInstance().infoDelete();
			if(result) {
				System.out.println("회원탈퇴 되었습니다. 로그아웃 합니다.");
				MemberController.getInstance().logOut();
			}else {
				System.out.println("회원탈퇴 실패 : 관리자에게 문의바랍니다.");
			}
		}
		
	}	
	// 5. boardWrite
	public void boardWrite() {
		
	}
	// 6. boardprint
	public void boardprint() {
		
	}
	// 7. boardView
	public void boardView() {
	
	}
	// 8. boardUpdate
	public void boardUpdate() {
		
	}
	// 9. boardDelete
}

