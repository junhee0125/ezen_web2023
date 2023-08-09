package 과제.과제11.view;

import java.util.Scanner;

import 과제.과제11.controller.MemberController;

public class MainPage {
	
	//싱글톤
	private static MainPage mainPage = new MainPage();
	public static MainPage getInstance() { return mainPage;}
	private MainPage() {}
	
	
	// 0입력객체
	private Scanner sc= new Scanner(System.in);
	
	// 1.메인메뉴
	public void mainView() {
		while(true) {
			System.out.println("\n\n-------회원제 커뮤니티--------");
			System.out.print("1.회원가입 | 2.로그인  | 3.아이디 찾기 | 4. 비밀번호 찾기[선택]>>");
			
			try {
				int  ch = sc.nextInt();
				
				if( ch == 1) {signupView(); }
				if( ch == 2) {loginView();}
				if( ch == 3) {findById();}
				if( ch == 4) {findByPwd();}
			
			} catch(Exception e) {
				System.out.println("경고 :  잘못입력하셨습니다.");
				//메모리를 새로 만들어주지 않으면  출력후 캐치문을 나가는데. 아직 메모리에 이전 값이 있어  예외구문이 무한실행된다.
				//sc=new Scanner(System.in);// 입력객체의 메모를 새롭게 만들어주기
			}
			
		}
	}
	//2. 회원가입
	public void signupView() {
		System.out.println("=======( 회 원 가 입 )=======");
		System.out.println("아이디를 입력하세요"); 	String id = sc.next();
		System.out.println("비밀번호를 입력하세요"); 	String pw = sc.next();
		System.out.println("이름을 입력하세요"); 	String name = sc.next();
		System.out.println("전화번호를 입력하세요"); 	String phone = sc.next();
		
		
		int result = MemberController.getInstance().signupLogic(id, pw, name, phone);
		
		if( result == 1) {System.out.println("가입성공 (^ㅁ^)");} 
		if( result == 2) {System.out.println("가입실패(T^T), 관리자에게 문의하세요~" );} 
		if( result == 3) {System.out.println("아이디중복 (T^T)");} 
		if( result == 4) {System.out.println("전화번호 중복(T^T)");} 
		
		//System.out.println(result ? "가입성공 (^ㅁ^)" : "가입실패((T^T)");
	}
	//3. 로그인
	public void loginView() {
		System.out.println("=======( 로 그 인 )=======");
		System.out.println("아이디를 입력하세요"); 	String id = sc.next();
		System.out.println("비밀번호를 입력하세요"); 	String pw = sc.next();
		
		
		boolean result= MemberController.getInstance().loginLogic(id,pw);
		System.out.println( result? "" : "(안내) 로그인 실패");
		if(result) {
			System.out.println("(안내) 로그인 성공");
			LoginPage.getInstance().loginMenu();
		
		}
		
	}
	
	//4.아이디찾기
	public void findById() {
		System.out.println("=======( 아이디 찾기 )=======");
		System.out.println("이름을 입력하세요"); 	String name = sc.next();
		System.out.println("전화번호를 입력하세요"); 	String phone = sc.next();
		
		String result = MemberController.getInstance().findById(name, phone);
		
		if(result !=null) {System.out.println("아이디 : "+ result); }
		else { System.out.println("입력하신 정보와 일치하는 아이디 정보가 없습니다.");}
	}
	
	//5.비번찾기
	public void findByPwd() {
		System.out.println("=======( 비밀번호 찾기 )=======");
		System.out.println("아이디를 입력하세요"); 	String id = sc.next();
		System.out.println("전화번호를 입력하세요"); 	String phone = sc.next();
		
		String result = MemberController.getInstance().findByPwd(id, phone);
		if(result != null) { System.out.println("비밀번호 : "+ result);}
		else { System.out.println("입력하신 정보와 일치하는 비밀번호 정보가 없습니다.");}
	}
	
	
		
	
}
