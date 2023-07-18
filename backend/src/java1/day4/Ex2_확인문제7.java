package java1.day4;

import java.util.Scanner;

public class Ex2_확인문제7 { // class s
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		

		
		int in = 0;
		int out = 0;
		int left = 0; 
		boolean run = true;
		
		while(run) {
			System.out.println("\n--------------------------------");
			System.out.println(" 1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
			System.out.println("---------------------------------");
			System.out.print("선택 > "); 
			String value = scanner.next();
			
			//입력값이 1 이면 예금액 입력
			if(value.equals("1")) {
				
				System.out.print("입금액 > "); in = scanner.nextInt();
				left += in;
				
			} else if(value.equals("2")) { //입력값이 2 이면 출금액 입력
				
				System.out.print("출금액 > "); out = scanner.nextInt();
				left -= out;
				
			} else if(value.equals("3")) {
				
				System.out.print("잔고 > "+ left); 
				
			} else if(value.equals("4")) {
				
				System.out.println("프로그램 종료");
				run = false;
				
			}
		
		}
		
		
	} // main e
} //class e
