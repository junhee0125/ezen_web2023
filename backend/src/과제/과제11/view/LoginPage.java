package 과제.과제11.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제11.model.dto.BoardDto;
import 과제.과제11.controller.BoardController;
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
		
		boardprint(); //로그인하고 들어오면 글목록이 보이게끔!!	
			
		System.out.println("\n\n===== ===== ===== =====");
		System.out.println("1.로그아웃 |2.회원정보 | 3.글쓰기 | 4.글조회");
		
		try {
			int ch = sc.nextInt();
			if(ch == 1 ) {MemberController.getInstance().logOut();}
			if(ch == 2 ) {info();}
			if(ch == 3 ) {boardWrite();}
			if(ch == 4 ) {boardView();} 
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
		sc.nextLine();
		System.out.print("제목: "); 		String title = sc.nextLine();
		System.out.print("내용 : "); 	String content = sc.nextLine();
		
		boolean result =  BoardController.getInstance().boardWrite(title, content);
		if(result) {System.out.println("글쓰기 등록 성공");}
		else { System.out.println("글쓰기 등록 실패 :  제목 1-50자까지 가능합니다.");}
		
	}
	// 6. boardprint
	/*
	  	게시물1개 = 1개의  Dto = 1개의 레코드
	  	모든 게시물을 가져올땐
	  	여러개의 개시물, = 여러개의  dto = 여러개의  레코드를 가져와야..
	  	어떻게?? 배열로.. 그중에서도 ArrayList[]로
	 */
	public void boardprint() {
		
		System.out.println("--------글 목록-------");
		System.out.printf("%-3s %-4s %-19s %-10S  %-30s %-5s\n","no","view","date","mno","title","mid"); // -빼기넣으면 왼쪽 정렬
		ArrayList<과제.과제11.model.dto.BoardDto> result = BoardController.getInstance().boardprint();
		
		for(int i=0 ;i <result.size();i++) {
			BoardDto dto = result.get(i);
			System.out.printf("%-3s %-4s %-19s %-10S %-30s %"
					+ "-5s\n", 
								dto.getBno(), dto.getBview(),dto.getBdate(), dto.getMno(),dto.getBtitle(), dto.getMid());
		}
	}
	// 7. boardView
	public void boardView() {
		System.out.println("--------글 보 기-------");
		System.out.print("조회할 글의 번호를 입력하세요.>>");
		
		int bno = sc.nextInt();
		BoardDto result = BoardController.getInstance().boardView(bno);
		
		System.out.printf("bno: %3s | view: %3s  | mid : %10s  | date : %19s\n",
				result.getBno(),
				result.getBview(), 
				result.getMid(), 
				result.getBdate());
		System.out.printf("title : %s \n" ,result.getBtitle());
		System.out.printf("content :%s\n ", result.getBcontent());
		
		//추가메뉴
		System.out.print( "1. 뒤로 가기 | 2. 수정 | 3 삭제 선택>>"); int ch = sc.nextInt();
		if( ch == 1 ) {}
		if( ch == 2 ) {boardUpdate();}
		if( ch == 3 ) {boardDelete() ;}
	
	}
	// 8. boardUpdate
	public void boardUpdate() {
		
	}
	// 9. boardDelete
	public void boardDelete() {
		
	}
}

