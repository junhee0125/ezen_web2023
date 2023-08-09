package 복습.part6;

import java.util.Arrays;
import java.util.Scanner;


public class MemberSystem {
	static Member[] memberList = new Member[100];
	static Scanner sc = new Scanner(System.in);
	static int loginIndex = -1;
	
	public static void main(String[] args) {
		
		while(true) {
			
			System.out.println("====회원시스템====");
			System.out.print("1.회원가입 | 2. 로그인 | 3.아이디찾기 | 4.비밀번호찾기  선택>> ");
			int ch = sc.nextInt();
			
			if(ch == 1) {회원가입();}
			if(ch == 2) {로그인();}
			if(ch == 3) {아이디찾기();}
			if(ch == 4) {비번찾기();}			
			
			
		}
		
	}
	
	static void 회원가입() {
		
		System.out.println("아이디 입력하세요");		String id = sc.next();
		System.out.println("비번 입력하세요");		String pw = sc.next();
		System.out.println("이름 입력하세요");		String name =sc.next();
		System.out.println("전화번호 입력하세요");	String phone = sc.next();
		System.out.println("나이 입력하세요");		int age = sc.nextInt();
		
		Member member = new Member(id, pw, name, phone, age );
		
		for(int i = 0 ; i < memberList.length ; i++) {
			if(memberList[i] == null) {
				memberList[i] = member;
				break;
			}
			
		}System.out.println("회원등록 완료" + Arrays.toString(memberList));
		
	}
	
	
	static void 로그인() {
		
		System.out.println("아이디 입력하세요");		String id = sc.next();
		System.out.println("비번 입력하세요");		String pw = sc.next();
		
		for(int i = 0 ; i < memberList.length ; i++) {
			if(!memberList[i].equals("") && memberList[i].id.equals(id) && memberList[i].pw.equals(pw) ) {
				
				loginIndex = i;
			}
			
		}
		System.out.println(loginIndex > 0?  "로그인 성공" : "로그인 실패");
	}

	static void 아이디찾기() {
		System.out.println("이름 입력하세요");		String name =sc.next();
		System.out.println("전화번호 입력하세요");	String phone = sc.next();
		
		for(int i = 0 ; i < memberList.length ; i++) {
			if(!memberList[i].equals("") && memberList[i].name.equals(name) && memberList[i].phone.equals(phone) ) {
				
				System.out.println("요청하신 아이디 : "+ memberList[i].id);
				return;
			}
		}
		
		System.out.println("일치하는 데이터가 없습니다.");
		
	}
	static void 비번찾기() {
		System.out.println("아이디 입력하세요");		String id = sc.next();
		System.out.println("전화번호 입력하세요");	String phone = sc.next();
		
		for(int i = 0 ; i < memberList.length ; i++) {
			if(!memberList[i].equals("") && memberList[i].id.equals(id) && memberList[i].phone.equals(phone) ) {
				
				System.out.println("요청하신 아이디 : "+ memberList[i].pw);
				return;
			}
		}
		
		System.out.println("일치하는 데이터가 없습니다.");
		
	}
}


/*
	주제 : 회원제 시스템 [ 과제10 ]

0. 저장

Member 클래스 필드는  아이디 , 비밀번호 , 이름 , 전화번호 , 나이 5개 입니다.

여러개 Member객체를 저장하기 위한 Member[] 객체배열 = new Member[100]; 선언합니다.

2. 각 메소드 기능

0. main 메소드 : 초기 메뉴 [ 24시간 ]

    1.입력시 회원가입 메소드 호출 

    2. 입력시 로그인 메소드 호출

    3. 입력시 아이디찾기​ 메소드호출 

    4. 입력시 비밀번호찾기 메소드 호출

1. 회원가입 메소드 
    1. 아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장
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
        - 만약에 동일한 값 있으면 찾은 비밀번호 출력
        - 아니면 없다.
*/