package java1.day13.Ex2.view;

import java.util.Scanner;

import java1.day13.Ex1.Board;
import java1.day13.Ex2.controller.BoardController;
import java1.day13.Ex2.model.dto.BoardDto;

public class MainPage {
	Scanner sc = new Scanner(System.in);
	//싱글톤 공유 O 
	/*
	 	싱글톤 만드는 방법
	 	1. 먼저 현재 클래스안에서 현재 클래스로 객체선언 해
	 		- 여기서 만든 객체를 외부로반환해줄라고.
	 	2. 외부에서 객체를 생성할 수 없도록 하기위해서 생성자를 private로 선언한다
	 	3. getter메소드 - 외부로 호출할 수 이도록
	 */
	private static MainPage mainPage = new MainPage(); //객체생성
	private MainPage() {} //외부접근을 막기위해 private 생성자 
	public static MainPage getInstance() {return mainPage;} //외부접근시 객체를 반환하는 정적메소드
	
	
	//메인페이지 입출력함수
	public void mainView() {
		while(true) {
			System.out.println("\n\n>>> 방문록 프로그램 <<<");
			System.out.print("1.글등록 | 2.글보기 | 3.글수정 | 4.글삭제 선택>>");
			int ch = sc.nextInt();
			if(ch == 1) { writeView(); }
			if(ch == 2) { printView(); }
			if(ch == 3) { updateView();}
			if(ch == 4) { deleteView();}
			
		}
	}
	
	// 글 등록페이지 입출력 함수
	public void writeView() {
		System.out.println("방문록 등록 페이지");
		//nextLine의 입력오류 방지를 위해
		sc.nextLine();
		//내용과 작성자를 입력받아 저장
		System.out.println("내용 >>");
		String content = sc.nextLine();
		System.out.print("작성자 >> "); 
		String writer = sc.next();
		
		//controller의 writeLogic메소드로 두개의 입력값을 전달하고  등록여부를 결과같으로 받아 저장		
		boolean result = BoardController.getInstance().writeLogic(writer,content);
		
		//결과값에 따라 제어
		if(result) { System.out.println("[안내] 글 등록 성공");}
		else { System.out.println("[안내] 글 등록 실패");}
	}
	
	// 글 출력페이지 입출력 함수
	public void printView() {
		System.out.println("방명록 List");
		System.out.println("출력할 게시물의 인덱스를 입력하세요");
		int index = sc.nextInt();
		BoardDto boardDto = BoardController.getInstance().printLogic(index);
		System.out.print("작성자 : "+ boardDto.getWriter()+ "\t|\t");
		System.out.print("내  용 :"+ boardDto.getContent()+ "\t|\t");
		System.out.println("조회수 :"+ boardDto.getView() );
		
		
	}
	
	
	// 글 수정페이지 입출력 함수
	public void updateView() {
		System.out.println(" 방명록 수정하기 ");
		//수정할 게시물의 인덱스와, 내용, 작성자명을 입력받아 저장
		System.out.println("수정할 게시물의 인덱스를 입력하세요");
		int index = sc.nextInt();
		
		sc.nextLine();
		System.out.println("내용 >>");
		String content = sc.nextLine();
		
		System.out.print("작성자 >> "); 
		String writer = sc.next();
		
		//controller updateLogic으로 3개의 매개변수를 전달하고 수정여부를 결과값으로 받아 저장한다.
		boolean result = BoardController.getInstance().updateLogic(index, writer,content);
		
		//결과값에 따라 제어
		if(result) { System.out.println("방명록이 수정되었습니다.");}
		else { System.out.println("방명록이 수정되지 않았습니다.");}
		
	}
	
	
	// 글 삭제페이지 입출력 함수
	public void deleteView() {
		System.out.println(" 방명록 삭제하기 ");
		//삭제할 게시물의 인덱스 입력받아 저장
		System.out.println("삭제할 게시물의 인덱스를 입력하세요");
		int index = sc.nextInt();
		//view에서 컨트롤러에게 입력받은 인덱스 전달보내고 삭제 결과 여부를 리턴받음
		boolean result = BoardController.getInstance().deleteLogic(index);
		//리턴 결과에 따른 제어
		if(result) {System.out.println(index + "데이터가 삭제되었습니다");}
		else{ System.out.println(index + "데이터가 삭제되지 않았습니다.");	}
	}
}
