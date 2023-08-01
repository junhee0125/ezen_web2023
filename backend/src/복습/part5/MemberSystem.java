package 복습.part5;

import java.util.Arrays;
import java.util.Scanner;

public class MemberSystem {
	public static void main(String[] args) {
		Member[] memberList = new Member[100]; 
		Scanner sc= new Scanner(System.in);
		
		
		
		while(true) {
			
			System.out.println("----------회원시스템-----------");
			System.out.print("1. 회원가입 2. 로그인   선택>");
			
			int ch = sc.nextInt();
			if(ch==1) {
				
				System.out.println("아이디 :"); String id = sc.next();
				System.out.println("비밀번호 : "); String pw = sc.next();
				System.out.println("이름  :"); String name = sc.next();
				System.out.println("전화번호  :"); String phone = sc.next();
				System.err.println("나이  :"); int age = sc.nextInt();
						
				Member member = new Member(id, pw, name, phone, age);
				
				for(int i=0 ; i <memberList.length; i++) {
					if(memberList[i] == null) {
						memberList[i] = member;
						break;
					}
				}System.out.println(Arrays.toString(memberList));
						
						
			}else if(ch == 2) {
				
				System.out.println("아이디 :"); String id = sc.next();
				System.out.println("비밀번호 : "); String pw = sc.next();
				
				int login = -1; 
				for(int i=0 ; i <memberList.length; i++) {
					if(memberList[i] != null && memberList[i].id.equals(id)&& memberList[i].pw.equals(pw)) {
						login = i;
						break;
					}
				}
				
				System.out.println(login >=0 ? "로그인 성공" : "로그인 실패");			
				
			}		
		}			
	}
}
