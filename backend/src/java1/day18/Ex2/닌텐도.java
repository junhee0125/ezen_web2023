package java1.day18.Ex2;

import java.util.Scanner;

public class 닌텐도 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//1. 인터페이스 - 게임패드 생성
		
		게임패드 유재석패드;
		
		while(true) {
			System.out.println("1.동물의 숲  | 2.커비칩");
			int ch = sc.nextInt();
			
			if(ch == 1 ) {
				유재석패드 = new 동물의숲();
				System.out.println("동물의숲시작");
				
			}else if( ch == 2 ) {
				유재석패드 = new 커비칩();
				System.out.println("커비칩시작");
			}else {
				유재석패드 = new 동물의숲();
			}
			System.out.println("게임중");
			while(true) {
				
				 System.out.println("버튼입력>>>");
				String btn = sc.next();
				if(btn.equals("A")) 유재석패드.A버튼();
				if(btn.equals("B")) 유재석패드.B버튼();
				if(btn.equals("X")) 유재석패드.X버튼();
				if(btn.equals("Y")) 유재석패드.Y버튼();
				
				if(btn.equals("Q")) break;
			}
			
		}
	}

}
