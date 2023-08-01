package 복습.part5;

import java.util.Arrays;
import java.util.Scanner;

public class Part5_01_MemberSystem {

	public static void main(String[] args) {
		
		Part5_01_Member[] memberList = new Part5_01_Member[100]; 
		Scanner in = new Scanner(System.in);
		 
		while(true) {
			
			System.out.println("----------회원시스템-----------");
			System.out.print("1. 회원가입 2. 로그인   선택>>");
			int ch= in.nextInt();
			if(ch ==1) {
				System.out.print("아이디  :");
				String inputId = in.next();
				System.out.print("비밀번호  :");
				String inputPw = in.next();
				System.out.print("이름  :");
				String inputName = in.next();
				System.out.print("전화번호  :");
				String inputPhone = in.next();
				System.out.print("나이 :");
				int inputAge = in.nextInt();
				
				Part5_01_Member member = new Part5_01_Member(inputId, inputPw, inputName, inputPhone, inputAge);
				
				for(int i= 0; i< memberList.length;i++) {
					
					if(memberList[i] == null) {
						memberList[i] =member;
						break;
					}
				}
				System.err.println(Arrays.toString(memberList));
				
			} else if (ch==2) {
				System.out.print("아이디  :");
				String inputId = in.next();
				System.out.print("비밀번호  :");
				String inputPw = in.next();
				
				int index = -1;
				for(int i= 0; i< memberList.length;i++) {
					System.out.println("i"+ i);
					
					if( memberList[i] != null){
						
						if(memberList[i].equals(inputId) && memberList[i].equals(inputPw)) {
							System.out.println("아이디 검토");
							index = i; 	
						}
						
					} else {
						System.out.println("등록된 회원 데이터가 없습니다.");
						
					}//if e
								
					
				}//f e
				 System.out.println(index);
				System.out.println( index >= 0 ? "로그인 성공 ": "로그인 실패");
			}
		}
	}
}

