package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.management.openmbean.OpenMBeanAttributeInfoSupport;

public class par4_01  {
	public static void main(String[] args) throws IOException {
	
		while(true) {
			
			Scanner in  = new  Scanner(System.in);
			String filePath ="src/복습/part4/product.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
		
			
			int fileSize =(int) file.length(); // 파일의 길이르르구해서
			byte[] inByteArray = new byte[fileSize]; //파일의 길이대로 배열을 생성
			fileInputStream.read(inByteArray); 
			String fileInfo = new String(inByteArray); //바이트로 읽어온 정보를 스트링
			
			String[] product = fileInfo.split("\n"); //*
			
			System.out.println("--------( 메뉴선택 )-------");
			System.out.print("-1 제품등록  0 :결제 ");
			
			if(product.length > 0) {
				
				for(int i = 0; i < product.length ; i++ ) {
					
					if(!product[i].equals("")) {//*
					
						String name = product[i].split(",")[0];
						int stock = Integer.parseInt(product[i].split(",")[1]);
						int price = Integer.parseInt(product[i].split(",")[2]);				
						
						if(stock == 0) {
							System.out.print( (i+1)+ ": [재고없음]" );
						} else {
							System.out.print((i+1)+ ":"+ name + "[ "+ price+"원 ]");
						}
					}
				
				}
				
			}
			
			System.out.println(">>>> 선택");
			int ch = in.nextInt();
			
			if(ch == -1) {
				System.out.print("제품명 :"); String name = in.next();
				System.out.print("재고량 :"); int stock = in.nextInt();
				System.out.print("가 격 :"); int price = in.nextInt();
				int basket = 0;
				
				String outStr = name+","+ stock +","+ price+ ","+ basket+"\n";

				fileOutputStream.write(outStr.getBytes());
				System.out.println("제품이 등록되었습니다.");
				
			} else if ( ch >0 && ch <= product.length) {
				
				String name = product[ch-1].split(",")[0];
				int stock = Integer.parseInt(product[ch-1].split(",")[1]);
				int price = Integer.parseInt(product[ch-1].split(",")[2]);	
				int basket = Integer.parseInt(product[ch-1].split(",")[3]);		
				
				if(stock > 0) {
					stock-- ;
					basket ++;
					System.out.println(name+"을 바구니에 답았습니다.");
					
				} else {
					System.out.println(name + "재고가 없습니다.");
				}
				
				product[ch-1] = name +","+stock +","+ price +","+ basket;
				String outStr = "";
				for(int i = 0 ; i < product.length ; i++ ) {
					outStr += 	product[i].split(",")[0]+","+
								product[i].split(",")[1]+","+
								product[i].split(",")[2]+","+
								product[i].split(",")[3]+"\n";
				}
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
				
				
			} else if( ch == 0) { //제품선택이면
				System.out.printf("%10s %9s %10s \n", "제품명", "수량","가격");
 				for(int i = 0 ; i <product.length; i++) {
 					

 					String name = product[i].split(",")[0];
 					int stock = Integer.parseInt(product[i].split(",")[1]);
					int price = Integer.parseInt(product[i].split(",")[2]);	
					int basket = Integer.parseInt(product[i].split(",")[3]);
					if(basket >0 ) {
						System.out.printf("%10s %10s %10s \n", name, basket,price);
					}
					
					
 				}
				
			}
			
			
		}
	
	}
}
