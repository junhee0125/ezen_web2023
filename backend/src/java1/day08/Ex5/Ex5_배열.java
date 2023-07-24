package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;

//실행목적:
public class Ex5_배열 {
	
	public static void main(String[] args) {
		
		String[] memberList = new String[100]; //100개 문자열을 저장할 수 있는 배열 선언
		
		while(true) { //무한반복
			System.out.println(Arrays.toString(memberList));
			//무한출력
			System.out.print("1.회원가입: ");
			
			//무한입력
				//1.scanner 객체 : Scanner 객체 변수명 = new Scanner(System.in);
			
			Scanner sc = new Scanner(System.in);	
				//객체를 통한 메소드 호출
			int ch = sc.nextInt();
			if( ch == 1  ) {
				
				System.out.print("아이디 : "); String id = sc.next();
				System.out.print("비밀번호 : "); String pw = sc.next();
				System.out.println("이름 : "); String name = sc.next();
				//하나의 문자열로 합치기
				String member = id+","+pw+","+name;
				//빈 인덱스를 찾아서 대입
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = member;
						break;
					}
					
				}
				
			}
			
		}//무한루프 끝
		
	}

}
