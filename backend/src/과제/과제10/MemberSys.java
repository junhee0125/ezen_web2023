package 과제.과제10;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MemberSys {
	
	static Member[] memberList = new Member[100];
	//입력객체의 시용 구역 범위를 생각해야
	static Scanner sc = new Scanner(System.in);
	static int login= -1; // 로그인 여부를 체크하기 위해서
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println(Arrays.toString(memberList));
			System.out.println("\n\n--------- 회원 시스템 ---------"); 
			System.out.print("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기    선택> ");
			int ch = sc.nextInt(); 
			
			if( ch == 1 ) { 회원가입 (); }
			else if( ch == 2 ) { 로그인 (); } 
			else if( ch == 3 ) { 아이디찾기 (); } 
			else if( ch == 4 ) { 비밀번호찾기 (); } 
			
			
		} // w e 
	}
	
	static void 회원가입 () {
		System.out.println(" 회 원 가 입 서");
		System.out.print("아이디를 입력하세요"); String id = sc.next();
		System.out.print("비밀번호를 입력하세요"); String pw = sc.next();
		System.out.print("이름을 입력하세요"); String name = sc.next();
		System.out.print("전화번호를 입력하세요"); String phone = sc.next();
		System.out.print("나이를 입력하세요"); int age = sc.nextInt();
		
		//Member객체생성
		Member m  = new Member(id, pw, name, phone, age);
		//빈 인덱스를 찾아 객체 저장
		for(int i = 0; i < memberList.length; i++) {
			
			if( memberList[i] == null) {
				
				memberList[i] = m;
				
				System.out.println("회원정보가 등록되었습니다.");
				
				break; //m 값을 저장하면 반복문을 종료
			}
			
		}
		
	}
	
	
	static void 로그인 () {
		System.out.println(" 로 그 인");
		System.out.println("-------------------------");
		System.out.print("아이디를 입력하세요"); String inputId = sc.next();
		System.out.print("비밀번호를 입력하세요"); String inputPw = sc.next();
		
		
		
		for(int i = 0; i < memberList.length; i++) {
			
			if( memberList[i] != null && memberList[i].id.equals(inputId)&& memberList[i].pw.equals(inputPw)) {
				
				//정적 멤버 변수에 로그인 성공한 인덱스를 넣어두기 >> 추후에 사용할 목적
				login = i;	 // 조건을 일치하는 데이터를 찾으면  인덱스를  login 변수에 대입 
			}			
		}		
		//System.out.println(Arrays.toString(memberList));
		
		if( login >= 0) { System.out.println("로그인성공"); } 		
		else {System.out.println("로그인실패");}
		
		
	}
	
	
	static void 아이디찾기 () {
		System.out.println("아 이 디 찾 기");
		System.out.println("-------------------------");
		System.out.print("이름를 입력하세요>>"); String inputName = sc.next();
		System.out.print("전화번호를 입력하세요>>"); String inputPhone = sc.next();
		
		for (int i = 0; i < memberList.length; i++) {
			
			if(memberList[i] != null && memberList[i].name.equals(inputName) &&  memberList[i].phone.equals(inputPhone)) {
				
				System.out.println(inputName +"님의 아이디는 :: " +memberList[i].id+"입니다");
				
				return;
				
			} 			
			
		}		
		
		
		System.out.println(inputName +"님의 정보와 일치하는 데이터가 없습니다.");		
	} 
	
	
	static void 비밀번호찾기 () {
		System.out.println(" 비 밀 번 호 찾 기");
		System.out.println("-------------------------");
		System.out.print("아이디를 입력하세요>>"); String inputId = sc.next();
		System.out.print("전화번호를 입력하세요>>"); String inputPhone = sc.next();
		
		int check = -1; // 비번불일치 check
		for (int i = 0; i < memberList.length; i++) {
			
			if(memberList[i] != null && memberList[i].id.equals(inputId) &&  memberList[i].phone.equals(inputPhone)) {
				
				System.out.println(inputId +"님의 비밀번호를 재설정합니다.");
				
				//난수만들기
				Random random = new Random();
				
				String newPw = ""; //난수로 새롭게 설정될 비밀번호
				
				for(int j =0 ; j < 6; j++) {
					
					String r = Integer.toString(random.nextInt(10)); //0~9에 사이의 난수
					
					newPw += r ;
				}
				
				System.out.println( "비밀번호가  "+  newPw + "으로 새롭게 설정됩니다." );
				
				memberList[i].pw = newPw; 
				
				return;
				
			} else {
				
				check = 0;
			}
		}
		
		if(check == 0 ) System.out.println(inputId +" 와"+ inputPhone +"의 일치하는 데이터가 없습니다.");
		
		
	}
	
	
}

/*
주제 : 회원제 시스템 1
	0. 회원클래스 설계 = Member
		아이디 , 비밀번호 , 이름 , 전화번호 , 나이
	0. Member 객체를 여러개 저장하는 배열 
		Member[] 객체배열 = new Member[100];
	
	1. 초기 메뉴 [ 24시간 ]
		1. 회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
		
	2. 조건 기능 
		1. 회원가입 메소드 
			1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이  각 입력받아 저장 
			2. Member 객체화
			3. 객체를 배열 저장 
			 
		2. 로그인 메소드
			1. 아이디 , 비밀번호 입력받아 저장 
			2. 입력받은 값과 배열내 동일한 값 찾기
				- 만약에 동일한 값 있으면 로그인 성공 
				- 아니면 실패
				 
		3. 아이디찾기 메소드
			1. 이름 , 전화번호 입력받아 저장
			2. 입력받은 값과 배열내 동일한 값 찾기
				- 만약에 동일한 값 있으면 찾은 아이디 출력 
				- 아니면 없다.
				 
		4. 비밀번호찾기 메소드 
			1. 아이디 , 전화번호 입력받아 저장
			2. 입력받은 값과 배열내 동일한 값 찾기
				- 만약에 동일한 값 있으면 *임시 비밀번호(문자4자리 난수생성 ) 업데이트후 출력 
				- 아니면 없다.
*/