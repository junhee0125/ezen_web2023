package 복습.part1;

import java.util.Scanner;

public class 내일꺼연습 {

	public static void main(String[] args) {
	
		
		String[] 재고관리 = { "10,0,300,콜라","10,0,200,환타","10,0,100,사이다"  };
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------ㅡmenu----------------");
			System.out.println("1.콜라 2.환타 3.사이다 4.결제");
			System.out.print(">>>>선택");
			int ch = in.nextInt();
			
			if( ch==1 || ch==2 || ch ==3) {
				
								
				int stock = Integer.parseInt(재고관리[ch-1].split(",")[0]);
				int basket = Integer.parseInt(재고관리[ch-1].split(",")[1]);
				int price = Integer.parseInt(재고관리[ch-1].split(",")[2]);
				String  name= 재고관리[ch-1].split(",")[3];
				
				if(stock == 0) {System.out.println("재고부족");}
				else {
					
				
						stock --; basket++;
						System.out.println(ch + "번 상품을 바구니에 담았습니다. ");
					
					
				}
				
				재고관리[ch-1] = stock +","+ basket +","+ price+","+ name;
				
				
			} else if(ch == 4) {
				
				int total = 0;
				System.out.printf("\n%10s, %10s, %10s","제품명","수량","가격");
				
				for(int i = 0 ; i<재고관리.length ; i++) {
					
					int basket = Integer.parseInt(재고관리[i].split(",")[1]);
					int price = Integer.parseInt(재고관리[i].split(",")[2]);
					String  name= 재고관리[i].split(",")[3];
					
					if (basket > 0) {
						System.out.printf("\n%10s, %10s, %10s",name,basket,basket*price);
						total += basket*price;
					}
				
				}
				
				if(total > 0) {
					
					System.out.println("\n총 금액  : " + total +"원 입니다.");
					System.out.println("1: 결제 2: 취소");
					int pay = in.nextInt();
					
					if(pay == 1) {
						System.out.print("결제금액을 넣우주세요"); int inPrice = in.nextInt();
						if(inPrice >= total ) { 
							System.out.println("결제가 정상처리되었습니다.");
							
							for(int i = 0; i < 재고관리.length; i++) {
								int stock = Integer.parseInt(재고관리[i].split(",")[0]);
								int basket = Integer.parseInt(재고관리[i].split(",")[1]);
								int price = Integer.parseInt(재고관리[i].split(",")[2]);
								String  name= 재고관리[i].split(",")[3];
								if(basket > 0 ) {
									
									재고관리[i] = stock +","+"0"+","+ price+","+ name;
								}
								
							}
						} else {
							System.out.println("잔액이 부족하여 결제가 취소됩니다.");
							
							for(int i = 0; i < 재고관리.length; i++) {
								int stock = Integer.parseInt(재고관리[i].split(",")[0]);
								int basket = Integer.parseInt(재고관리[i].split(",")[1]);
								int price = Integer.parseInt(재고관리[i].split(",")[2]);
								String  name= 재고관리[i].split(",")[3];
								if(basket > 0 ) {
									
									재고관리[i] = stock+basket +","+"0"+","+ price+","+ name;
								}
								
							}
							
						}// 결제 end
						
					} else if(pay ==2) {
						System.out.println("결제취소를 선택하셨습니다.");
						for(int i = 0; i < 재고관리.length; i++) {
							int stock = Integer.parseInt(재고관리[i].split(",")[0]);
							int basket = Integer.parseInt(재고관리[i].split(",")[1]);
							int price = Integer.parseInt(재고관리[i].split(",")[2]);
							String  name= 재고관리[i].split(",")[3];
							if(basket > 0 ) {
								
								재고관리[i] = stock+basket +","+"0"+","+ price+","+ name;
							}
							
						}
						
					}
					
				
				}
				
			}
			
		}
				
		
	}
}
