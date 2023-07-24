package 복습.part1;

import java.util.Scanner;

public class part1 {
	public static void main(String[] args) {
		
		 int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
		 int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
		 int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
		 
		 Scanner in = new Scanner(System.in);
		
		 while(true) {
			 
			 
			System.out.println("--------------------- 메뉴--------------------");
			System.out.println("1.콜라[300] , 2.환타[200], 3사이다[100] 4. 결제" );
			System.out.println(">>>>>>선택"); 
			int ch = in.nextInt();

			 
			 if(ch ==1) {
				 if(콜라재고 == 0 ) { System.out.println("콜라재고가 없습니다.");}
				 else {
					 콜라재고--; 
					 콜라바구니++;
				 }
				 
				 
			 } else if (ch ==2) {
				 if(환타재고 == 0 ) { System.out.println("콜라재고가 없습니다.");}
				 else {
					 환타재고--; 
					 환타바구니++;
				 }
				 
			 } else if (ch ==3) {
				 if(사이다재고 == 0 ) { System.out.println("콜라재고가 없습니다.");}
				 else {
					 사이다재고--; 
					 사이다바구니++;
				 }
				 
			  }else if (ch ==4) {
				 System.out.println("제품명		수량		가격");
				 if(콜라바구니 >0 ) {  System.out.println("콜라\t"+콜라바구니+ "\t300원"); }
				 if(환타바구니 >0 ) {  System.out.println("환타\t"+환타바구니+ "\t200원"); }
				 if(사이다바구니 >0 ) {  System.out.println("사이다\t"+사이다바구니+"\t100원"); }
				 int total = 콜라바구니*300+ 환타바구니*200+사이다바구니*100;
				 System.out.println("총가격 : " + total); 
				 
				 System.out.println("1. 결제 2.취소"); int pay = in.nextInt();
				 if(pay ==1) {
					 System.out.println("결제하실 금액을 입력하세요"); int cost = in.nextInt();
					 if(cost >= total) {
						 System.out.println("결제되었습니다.");
					 }else {
						System.out.println("결제금액이 부족합니다.");
					 }
				 } else {
					 System.out.println("결제가 취소되었습니다.");
					 콜라재고 += 콜라바구니;
					 환타재고 += 환타바구니;
					 사이다재고 +=사이다바구니;
				 }
				  
			 }
			
			 
			 
		 }
		
		
	}
}
