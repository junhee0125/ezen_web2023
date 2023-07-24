package java1.day08.Ex5;

import java.util.Arrays;
import java.util.Scanner;

//실행목적 : 
public class Ex5_객체배열 {
	public static void main(String[] args) {

		Member[] memberList= new Member[100];
		while(true) {
			System.out.println(Arrays.toString(memberList));
			System.out.println("1.회원가입 :" );
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
				
				Member m = new Member();
				//하나의 문자열로 합치기
				m.id = id;
				m.pw = pw;
				m.name = name;
				
				//빈 인덱스를 찾아서 대입
				for(int i = 0 ; i < memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = m;
						break;
					}
					
				}
				
			}
				
			}//무한루프 끝

	}
}


/*
 
------------------------------------------------- 
| 	제품		|	재고		|	가격		| 	바구니	|   
------------------------------------------------
|	콜라		|	19		|	300		|	  3		|
------------------------------------------------
|	콜라		|	19		|	100		|	  3		|
------------------------------------------------
|	콜라		|	19		|	200		|	  3		|
------------------------------------------------
|	콜라		|	19		|	300		|	  3		|
------------------------------------------------
|	콜라		|	19		|	300		|	  3		|
------------------------------------------------
|	콜라		|	19		|	300		|	  3		|
------------------------------------------------
|	콜라		|	19		|	300		|	  3		|
------------------------------------------------
|	콜라		|	19		|	300		|	  3		|
 
 
 */