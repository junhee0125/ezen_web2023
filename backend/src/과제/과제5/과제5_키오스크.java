package 과제.과제5;

import java.util.Scanner;

public class 과제5_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */
		/*
		 * CSV : 필드 상태 속성 간의 구분은 ,  묶음 단위 \n 출력했을때 묶음 단위로 출력이 되서 읽기 편함 good!!
		 * 재고관리 = "10,0,300\n10,0,200\n10,0,100\n";
		 * 		재고관리.split("\n"); 으로 문자열 나누면 4개의 조각으로 나뉘어진다. (dataSet +1) 
		 * 		마지막\n의 다음 dataSet을 위한것이지만 데이가 없는 상태로 한 조각을 차지함. [0][1][2][3] <== 이렇게 존재함
		 * 문자열을 -> 숫자로 바꿀때.
		 * 		Integer.parseInt(str);
		 * 		Integer.valueOf(str);	
		 * 
 		 * */
		
		재고관리 = "10,0,300\n10,0,200\n10,0,100\n";
		/*
		 (재고관리.split("/")[0]).split(":")[0]  = 콜라 재고
		 (재고관리.split("/")[0]).split(":")[1]  = 콜라 바구니
		 (재고관리.split("/")[0]).split(":")[2]  = 콜라 가격		 
		 
		 (재고관리.split("/")[1]).split(":")[0]  = 환타 재고
		 (재고관리.split("/")[1]).split(":")[1]  = 환타 바구니
		 (재고관리.split("/")[1]).split(":")[2]  = 환타 가격
		 
		 (재고관리.split("/")[2]).split(":")[0]  = 사이다 재고
		 (재고관리.split("/")[2]).split(":")[1]  = 사이다 바구니
		 (재고관리.split("/")[3]).split(":")[2]  = 사이다가격
		 
		 System.out.println((재고관리.split("/")[0]).split(":")[0]);
		 System.out.println((재고관리.split("/")[0]).split(":")[1]);
		 System.out.println((재고관리.split("/")[0]).split(":")[2]);
		 System.out.println((재고관리.split("/")[1]).split(":")[0]);
		 System.out.println((재고관리.split("/")[1]).split(":")[1]);	
		 System.out.println((재고관리.split("/")[1]).split(":")[2]);
		 System.out.println((재고관리.split("/")[2]).split(":")[0]);
		 System.out.println((재고관리.split("/")[2]).split(":")[1]);
		 System.out.println((재고관리.split("/")[2]).split(":")[2]);

		*/

		/*
		
		 int 콜라재고 	= Integer.parseInt((재고관리.split("/")[0]).split(":")[0]);
		 int 콜라바구니 	= Integer.parseInt((재고관리.split("/")[0]).split(":")[1]);  
		 int 콜라가격 	= Integer.parseInt((재고관리.split("/")[0]).split(":")[2]);  		 
		 int 환타재고 	= Integer.parseInt((재고관리.split("/")[1]).split(":")[0]); 
		 int 환타바구니	= Integer.parseInt((재고관리.split("/")[1]).split(":")[1]);  
		 int 환타가격 	= Integer.parseInt((재고관리.split("/")[1]).split(":")[2]);  		 
		 int 사이다재고 	= Integer.parseInt((재고관리.split("/")[2]).split(":")[0]);  
		 int 사이다바구니= Integer.parseInt((재고관리.split("/")[2]).split(":")[1]);  
		 int 사이다가격 	= Integer.parseInt((재고관리.split("/")[2]).split(":")[2]);  
		
		*/
		/* ----------- */
		 while(true) {
			 
			
			 int 콜라재고	  = Integer.parseInt((재고관리.split("\n")[0]).split(",")[0]);
			 int 콜라바구니  = Integer.parseInt((재고관리.split("\n")[0]).split(",")[1]);  
			 int 콜라가격   = Integer.parseInt((재고관리.split("\n")[0]).split(",")[2]);  		 
			 int 환타재고 	  = Integer.parseInt((재고관리.split("\n")[1]).split(",")[0]); 
			 int 환타바구니 = Integer.parseInt((재고관리.split("\n")[1]).split(",")[1]);  
			 int 환타가격 	 = Integer.parseInt((재고관리.split("\n")[1]).split(",")[2]);  		 
			 int 사이다재고 = Integer.parseInt((재고관리.split("\n")[2]).split(",")[0]);  
			 int 사이다바구니= Integer.parseInt((재고관리.split("\n")[2]).split(",")[1]);  
			 int 사이다가격 = Integer.parseInt((재고관리.split("\n")[2]).split(",")[2]);  
			 
			 System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			 System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			 System.out.println( 콜라재고 + "\t|\t"+환타재고+"\t|\t"+사이다재고);
			 System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			 
			 
				/* 문제풀이 위치 */
				if(ch == 1) { //콜라선택
					
					if(콜라재고 == 0) {  System.out.println("콜라 재고부족"); }
					
					else {  
						콜라재고 --;  	
						콜라바구니 ++;
						//System.out.println("콜라재고 : "+ 콜라재고 +" | 콜라바구니 : "+콜라바구니);
					}
									
				} else if(ch == 2) { //환타선택
					
					if(환타재고 == 0) {  System.out.println(" 환타 재고부족"); }
					
					else {  환타재고 --;  	환타바구니 ++;}
					
				} else if(ch == 3) { //사이다 선택
					
					if(사이다재고 == 0) {  System.out.println(" 사이다재고부족"); }
					
					else {  사이다재고 --;  	사이다바구니 ++;}
					
				} else if(ch == 4) {
					
						System.out.println("현재 장바구니 현황 표시 목록 ");
						System.out.println("---------------------------------- ");
						System.out.println("제품명\t수량\t가격 ");
						int total = 0;
						if(콜라바구니 > 0) {	System.out.println("콜라\t"+콜라바구니 +"\t"+콜라가격*콜라바구니); 	total += 콜라가격*콜라바구니 ;}
						if(환타바구니 > 0) {	System.out.println("환타\t"+환타바구니 +"\t"+환타가격*환타바구니); 	total += 환타가격*환타바구니 ;}
						if(사이다바구니 > 0) {System.out.println("사이다\t"+사이다바구니 +"\t"+사이다가격*사이다바구니); 	total += 사이다가격*사이다바구니 ;}
						System.out.println("총가격 :  "+ total);
						System.out.println("결제는 1 취소는 2번을 입력해주세요."); int payYN = scanner.nextInt();
						
						if(payYN == 1) { // 결제하기
							System.out.println("투입할 금액을 입력하세요"); int price = scanner.nextInt();
							if(price >= total) {
								
								if(price > total ) {
									System.out.println(" 남은 잔돈을 반환합니다 " + (price- total) );
								}
								
								System.out.println(" 결제가 정상처리 되었습니다. ");
								//바구니 초기화
								콜라바구니 = 0;
								사이다바구니 = 0 ;
								환타바구니 = 0;
							
							} else {
								System.out.println(" 금액이 부족합니다. " );
								
								콜라재고 += 콜라바구니;
								사이다재고 += 사이다바구니;
								환타재고 += 환타바구니;
								
								콜라바구니 = 0;
								사이다바구니 = 0;
								환타바구니 = 0;
							}
							
							
						}else if (payYN == 2 || payYN > 2 || payYN < 1) { //취소하기
							
							if(payYN ==2) {
								System.err.println(" 결제취소합니다.  " );// 빠알강 메시지...
							} else {
								System.err.println(" 잘못입력하셨습니다. 장바구니가 비워집니다."); // 빠알강 메시지..
							}
							콜라재고 += 콜라바구니;
							사이다재고 += 사이다바구니;
							환타재고 += 환타바구니;
								
							콜라바구니 = 0;
							사이다바구니 = 0;
							환타바구니 = 0;
							
							
						}
						
				}
				
				/* ----------- */
				
				//while문안에서 재고관리 split했다면
				재고관리 = 콜라재고+","+콜라바구니+","+콜라가격+"\n"+환타재고+","+환타바구니+","+환타가격+"\n"+사이다재고+","+사이다바구니+","+사이다가격+"\n";
				//System.out.println(재고관리);
			} // while end 
		} // main end 
		
	} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







