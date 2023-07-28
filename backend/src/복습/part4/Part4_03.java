package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part4_03  {
	public static void main(String[] args) throws IOException {
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			String filePath = "./src/복습/part4/Part4_03.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
			FileInputStream fileInputStream =new FileInputStream(filePath);
			File file= new File(filePath);
			
			
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			
			String[] product = fileInfo.split("\n");
			
			System.out.println("메뉴션택=============");
			System.out.print("-1: 제품등록   0: 결제 ");
			
			for( int i = 0; i <product.length; i++) {
				if(!product[i].equals("")) {
					
					String name = product[i].split(",")[0];
					int stock = Integer.parseInt(product[i].split(",")[1]);
					int price = Integer.parseInt(product[i].split(",")[2]);
					
					if(stock >0 ) {
						System.out.println( (i+1) +" : "+name +" [ "+price+" ] ");
					} else {
						System.out.println( (i+1) +" : ㅈㅔ고없음");
					}
			
					
				}
				
			} //for e
			
			System.out.println(">>>>"); int ch = sc.nextInt();
			
			if(ch == -1) {
				System.out.print("제품명  : "); String name = sc.next();
				System.out.print("재고량  : "); int stock = sc.nextInt();
				System.out.print("가  격  : "); int price = sc.nextInt();
				int basket = 0;
				
				String outStr = name+","+stock+","+price+","+basket+"\n";
				
				fileOutputStream.write(outStr.getBytes());
				System.out.println("제품이 등록되었습니다.");
				
				
			} else if (ch >0 && ch <=product.length) {
				
				String name = product[ch-1].split(",")[0];
				int stock = Integer.parseInt(product[ch-1].split(",")[1]);
				int price = Integer.parseInt(product[ch-1].split(",")[2]);
				int basket = Integer.parseInt(product[ch-1].split(",")[3]);
				
				
				if(stock > 0 ) {
					
					System.out.println( name + "제품을 선택하셨습니다.");
					stock --;
					basket ++;
					
					product[ch-1] = name+","+stock+","+price+","+basket;
				} else {
					System.out.println("재고가 없습니다.");
				}
				
				String outStr ="";
				
				for( int i = 0; i <product.length; i++) {
				
					outStr +=	product[i].split(",")[0] +
								product[i].split(",")[1] +
								product[i].split(",")[2] +
								product[i].split(",")[3] ;
					
				} 
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
				

				
			} else if (ch==0) {
				for( int i = 0; i <product.length; i++) {

				
				String name = product[i].split(",")[0];
				int stock = Integer.parseInt(product[i].split(",")[1]);
				int price = Integer.parseInt(product[i].split(",")[2]);
			}
		}
		
	}
}
