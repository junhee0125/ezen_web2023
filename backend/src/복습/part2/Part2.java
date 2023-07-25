package 복습.part2;

import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
	    String 재고관리 = "10,0,300\n3,0,200\n2,0,100\n"; 
	    
	    while(true) {
	    	
	    	int 콜라재고 = Integer.parseInt(((재고관리.split("\n")[0]).split(",")[0]));
	    	int 콜라바구니 = Integer.parseInt(((재고관리.split("\n")[0]).split(",")[1]));
	    	int 콜라가격 = Integer.parseInt(((재고관리.split("\n")[0]).split(",")[2]));
	    	
	    	int 환타재고 = Integer.parseInt(((재고관리.split("\n")[1]).split(",")[0]));
	    	int 환타바구니 = Integer.parseInt(((재고관리.split("\n")[1]).split(",")[1]));
	    	int 환타가격 = Integer.parseInt(((재고관리.split("\n")[1]).split(",")[2]));
	    	
	    	int 사이다재고 = Integer.parseInt(((재고관리.split("\n")[2]).split(",")[0]));
	    	int 사이다바구니 = Integer.parseInt(((재고관리.split("\n")[2]).split(",")[1]));
	    	int 사이다가격 = Integer.parseInt(((재고관리.split("\n")[2]).split(",")[2]));
	    	
	    	System.out.println("---------------메뉴선택----------------");
	    	System.out.println("1. 콜라 2.환타 3. 사이다. 4 결제");
	    	System.out.println(">>> 선택"); int ch = in.nextInt();
	    	
	    	
	    	if(ch == 1) {
	    		
	    		if( 콜라재고 == 0) { System.out.println("재고부족");}
	    		else{ 콜라재고--; 콜라바구니++;}
	    		
	    	} else if(ch == 2) {
	    		
	    		if( 환타재고 == 0) { System.out.println("재고부족");}
	    		else{ 환타재고--; 환타바구니++;}
	    		
	    	} else if(ch == 3) {
	    		
	    		if( 사이다재고 == 0) { System.out.println("재고부족");}
	    		else{ 사이다재고--; 사이다바구니++;}
	    		
	    	} else if(ch == 4) {
	    		
	    		int total =0;
	    		if(콜라바구니>0) { System.out.println("콜라  "+ 콜라바구니 +" "+ 콜라바구니 *콜라가격); total+=콜라바구니 *콜라가격;}
	    		if(환타바구니>0) { System.out.println("환타  "+ 환타바구니 +" "+ 환타바구니 *환타가격); total+=환타바구니 *환타가격;}
	    		if(사이다바구니>0) { System.out.println("사이다  "+ 사이다바구니 +" "+ 사이다바구니 *사이다가격); total+=사이다바구니 *사이다가격;}
	    		
	    		System.out.println("총가격 :  "+total);
	    		
	    		System.out.println("1: 결제 2: 취소"); int  pay = in.nextInt();
	    		if(pay == 1) {
	    			System.out.println("결제금액을 입력하세요");  int price = in.nextInt();
	    			if( price >= total ) {
	    				System.out.println("정상결제되었습니다.");
	    				콜라바구니 = 0;
	    				환타바구니 = 0;
	    				사이다바구니 = 0;
	    						
	    				
	    			} else {
	    				System.out.println("금액이 부족합니다.");
	    				
	    				콜라재고 += 콜라바구니;
	    				환타재고 += 환타바구니;
	    				사이다재고 += 사이다바구니;
	    				
	    				
	    				
	    				콜라바구니 = 0;
	    				환타바구니 = 0;
	    				사이다바구니 = 0;
	    			}
	    			
	    			
	    			
	    		} else if (pay ==2) {
	    			
	    			System.out.println("결제를 취소합니다.");
	    			콜라재고 += 콜라바구니;
    				환타재고 += 환타바구니;
    				사이다재고 += 사이다바구니;
    				
    				   				
    				콜라바구니 = 0;
    				환타바구니 = 0;
    				사이다바구니 = 0;
	    			
	    			
	    		}
	    	}
	    	
	    	
	    	재고관리 = 콜라재고 +","+ 콜라바구니 +","+ 콜라가격+"\n"+환타재고 +","+ 환타바구니 +","+ 환타가격+"\n"+사이다재고 +","+ 사이다바구니 +","+ 사이다가격+"\n";
	    	
	    	
	    	
	    	
	    	
	    	
	    }//w e
	    
	}
}
