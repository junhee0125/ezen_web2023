package java1.day11.EX5디자인패턴2.view;

import java.util.Scanner;

import java1.day11.EX5디자인패턴2.controller.MamberController;
/**
 * VIEW
 * 
 *
 */
public class MainPage {
	// 0. 싱글톤 생성
			// 1. 현재 클래스로 에 static 객체 생성 , 필드는 무조건 잠금 
		private static MainPage mainPage = new MainPage();
			// 2. 외부 객체에서 해당 싱글톤 호출하기 위한 메소드 
		public static MainPage getInstance() { return mainPage; }
			// 3. 객체 외부에서 해당 클래스로 객체 생성 잠금 , 생성자를 private 
		private MainPage() { }
		
		// 1. 필드
		private Scanner sc = new Scanner(System.in); 
		
		// 2. 생성자
		
		// 3. 함수 
		public void mainPage() {
			while(true) { // 무한루프
				System.out.println("\n\n--------- 회원 시스템 ---------");
				System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾    선택> ");
				int ch = sc.nextInt();
				if( ch == 1 ) { singupPage(); }
				if( ch == 2 ) { loginPage(); }
				if( ch == 3 ) { findIdPage(); }
				if( ch == 4 ) { findPwPage(); }
			} // whine e 
		} // f end 
		
		void singupPage() {
			System.out.println("--------- 회원가입 ---------");
			System.out.print("아이디 : "); 	String id = sc.next();
			System.out.print("비밀번호 : ");	String pw = sc.next();
			System.out.print("이름 : ");		String name = sc.next();
			System.out.print("전화번호 : ");	String phone = sc.next();
			System.out.print("나이 :");		int age = sc.nextInt();
		
		
			//컨트롤러 서빙에게 전달 // 컨드롤 클래내 메소드 호출
			boolean result = MamberController.getInstance().signUpLogic(id,  pw, name, phone, age);
			
			if(result) System.out.println(" (안내) 회원가입 성공");
			else System.out.println(" (안내) 회원가입 실패");
		}
		
		
		void loginPage() {
			System.out.println(" 로 그 인");
			System.out.println("-------------------------");
			System.out.print("아이디를 입력하세요"); String id = sc.next();
			System.out.print("비밀번호를 입력하세요"); String pw = sc.next();
			
			//컨트롤러에게 전달 
			boolean result =  MamberController.getInstance().loginLogic(id, pw);
			
			if( result )  System.out.println("(안내) 로그인성공");  		
			else System.out.println(" (안내) 로그인실패");
		}
		
		
		void findIdPage() {
			System.out.println("아 이 디 찾 기");
			System.out.println("-------------------------");
			System.out.print("이름를 입력하세요>>"); String name = sc.next();
			System.out.print("전화번호를 입력하세요>>"); String phone = sc.next();
			
			String result = MamberController.getInstance().findIdLogic(name,phone );
			
			if(result != null ) System.out.println(name +"님의 아이디는 :: " +result+"입니다");
			else System.out.println(name +"님의 정보와 일치하는 데이터가 없습니다.");		
						
		}
		
		
		void findPwPage() {
			System.out.println(" 비 밀 번 호 찾 기");
			System.out.println("-------------------------");
			System.out.print("아이디를 입력하세요>>"); String id = sc.next();
			System.out.print("전화번호를 입력하세요>>"); String phone = sc.next();
			
			//컨트롤로러 요청
			String result = MamberController.getInstance().findPwLogic( id, phone);
			
			if(result !=null) System.out.println( "비밀번호가  "+  result + "으로 새롭게 설정됩니다." );
			else System.out.println("입력하신 정보와 일치하는 데이터가 없습니다.");		
			
		}
		
}
