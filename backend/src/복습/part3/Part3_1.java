package 복습.part3;

import java.util.Scanner;

public class Part3_1 {
	public static void main(String[] args) {
		
	    String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};
	    Scanner sc = new Scanner(System.in);
	    
	    while(true ) {
	    	
	    	
	    	
	    	
	    	System.out.println("------------메뉴선택------------");
	    	System.out.println("1.콜라 2. 환타 3. 사이다  4 결제");
	    	System.out.println(">>>>>선택");
	    	int ch = sc.nextInt();
	    	
	    	
	    	if ( ch == 1 || ch==2 || ch==3) {
	    		
	    		int stock = Integer.parseInt(재고관리[ch-1].split(",")[0]);
		    	int basket = Integer.parseInt(재고관리[ch-1].split(",")[1]);
		    	int price = Integer.parseInt(재고관리[ch-1].split(",")[2]);
		    	String name = 재고관리[ch-1].split(",")[3];
	    		
		    	if(stock > 0  ) {
		    		stock --; basket++;
		    	} else {
		    		System.out.println("재고부족");
		    	}
		    	
		    	재고관리[ch-1] = stock +","+ basket +","+ price +","+ name;
	    		
	    	} else if (ch==4) {
	    		int total = 0;
	    		System.out.println("제품   수량   가격");
	    		for(int i = 0 ; i <재고관리.length; i++) {
	    			int stock = Integer.parseInt(재고관리[i].split(",")[0]);
			    	int basket = Integer.parseInt(재고관리[i].split(",")[1]);
			    	int price = Integer.parseInt(재고관리[i].split(",")[2]);
			    	String name = 재고관리[i].split(",")[3];
	    			
	    		
	    			
	    			if(basket > 0) {  System.out.println(name+"  "+basket +"  "+basket*price); total+=basket*price; }
	    		}
	    		
	    		if(total > 0) { System.out.println(" 총가격 : "+ total); }
	    	}
	    	
	    	
	    	
	    }
	}

}
