package 과제.과제9;

import java.util.Arrays;
import java.util.Scanner;

//목적 : 실행
public class MemberSystem {
	public static void main(String[] args) {
		
		
		
		//0. 여러개의 Member객체릐 길이가 100개의 배열선언
		Member[] memberList = new Member[100]; 	// 스택 + 힙
		Scanner sc = new Scanner (System.in); // 스택 + 힙
		
		while(true) {
			System.out.println("\n\n-----------------(회원시스템)-----------------");
			System.out.println("1.회원가입 2. 로그인  >>>선택 ");
			int ch = sc.nextInt(); //기본타입 : 스택
			
			if(ch == 1 ){
				
				System.out.println("-----------------(회원시스템)-----------------"); 
				
				System.out.print("아이디  :"); 	String inputId =sc.next(); //기본타입 : 스택 힙
				System.out.print("비밀번호  :");  	String inputpPwd =sc.next(); //기본타입 : 스택 힙
				System.out.print("이름  :");  	String inputName =sc.next(); //기본타입 : 스택 힙
				System.out.print("전화번호  :");  String inputPhone =sc.next(); //기본타입 : 스택 힙
				System.out.print("나이  :");  	int inputAge =sc.nextInt(); //기본타입 : 스택
				
				//2. 5가지 데이터를 하나루 묶음.
				Member member = new Member( inputId, inputpPwd, inputName  ,inputPhone,inputAge); //객체생성 : 힙메모리 할당
				
				
						
						
				// 3. 여러개의 객체를 저장하기 위해 배열저장	
				
				for(int i =0 ; i < memberList.length; i++ ) {
					
					if (memberList[i] == null) {
						memberList[i]  = member ; 
						break;
					}
				}
				System.out.println(Arrays.toString(memberList));
				
			} else if(ch==2) {
								
				System.out.println("-----------------(로그인)-----------------");
				System.out.print("아이디  :"); 	String inputId =sc.next();
				System.out.print("비밀번호  :");  	String inputpPwd =sc.next();
				
				//** 
				int login = -1; //로그인 여부를 저장하는 변수 /-1 : 못찾았다. 0 이상이면 찾고자 하는 인덱스번호 저장 = 로그인 성공 
				
				for(int i = 0 ; i <memberList.length; i++) { 
					
					if(memberList[i] !=null && memberList[i].id.equals(inputId) && memberList[i].pwd.equals(inputpPwd)) {
						
						login = i;			
						
						break;
					}
				}//for end
				
				System.out.println(login >= 0 ? "로그인 성공" : "로그인실패");
			}
		}//w e
		
	}//m e
}//c e

/*
 * 주제: 회원제 시스템
 * 		0. 저장
 * 			아이디, 비밀번호, 이름, 전화번호 나이
 * 			*5가지 필드/변수/데이를 하나의 묶음 방법으로
 * 			-->> 문자열 이용 : "아이디,비밀번호,이름,전화번호": , 쉽표를 이용한 필드 구분
 * 			-->> 클래스 ( 필드 ) 이용:
 * 				1. 클래스 설계 = 새로운 클래스.java 파일 생성
 * 				2. 클래스 멤버 구성 : 필드, 생성자, 메소드
 * 			* 하나로 묶인 (기준동일=타입동일) 여러개 저장???????????
 *			--> 문자열 배열 : String[] 문자열배열 = new String[100];
 *			--> 클래스 배열 : Member[] 객체배열 = new Member[100];
 * 		1. 초기메뉴
 * 			1. 회원가입 2. 로그인 
 * 	
 * 		2. 조건기능
 * 			1.회원가입
 * 				1. 5가지 데이터 입력받아 저장
 * 				2.Member 겍체화
 * 			2.로그인
 * 				1. 아이디, 비밀번호 입력받아 저장
 * 				2. 배열내 입력받은 값과 동일한 값 찾기
 * 					- 만약 동일한 값이 있으면 성공.
 * 					- 아니면 로그인 실패
 * 
 * 
 * 
 * */
