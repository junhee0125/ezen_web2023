package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part4_04 {
	public static void main(String[] args) throws IOException {
		while(true) {
			Scanner in = new Scanner(System.in);
			String filePath= "./src/복습/part4/product4.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file =new File(filePath);
			
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			
			String[] product = fileInfo.split("\n");
			
			System.out.println("메뉴선택------------");
			System.out.println("-1: 제품등록  | 0: 결제 | ");
			
			
			for(int i = 0; i <= product.length; i++) {
								
				if(!product[i].equals("")) {
					
					String name = product[i].split(",")[0];
					int stock = Integer.parseInt(product[i].split(",")[1]);
					int price = Integer.parseInt(product[i].split(",")[2]);
					
					if(stock > 0 ) {						
						System.out.println((i+1) + name +" [" +price +"원 ]" );
					}else {
						System.out.println((i+1) + name +" :  재고없음" );
					}
					
				}else {
					System.out.println("등록된 제품 없음");
				}
			}
			
			
			System.out.print(">>>>>선택>"); 
			int ch = in.nextInt();
			
			if (ch ==-1 ) {
				System.out.print("제품명 ");
				String name = in.next();
				System.out.print("재고량 : ");
				int stock = in.nextInt();
				System.out.print("가격 : ");
				int price = in.nextInt();
				int basket = 0;

				String outStr = name +","+ stock +","+price+","+basket+"\n";
				
				fileOutputStream.write(outStr.getBytes());
				System.out.println("제품이 등록되었습니다.");
				
		
				
				
			} else if(ch >0 && ch <= product.length) {
				
				String name = product[ch-1].split(",")[0];
				int stock = Integer.parseInt(product[ch-1].split(",")[1]);
				int price = Integer.parseInt(product[ch-1].split(",")[2]);
				int basket = Integer.parseInt(product[ch-1].split(",")[2]);
				
				if(stock >0) {
					System.out.println(name + "제품을 담았습니다.");
					stock --;
					basket ++;
					
					product[ch-1] =  name +","+ stock +","+price+","+basket;
				}  else {
					System.out.println("재고부족");
				}
				
				String outStr = "";
				
				for(int i = 0; i <= product.length; i++) {
					
					outStr +=   product[i].split(",")[0]+","+
								product[i].split(",")[1]+","+
								product[i].split(",")[2]+","+
								product[i].split(",")[3]+"\n";
					
				}
					FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
					fileOutputStream2.write(outStr.getBytes());
				
				
			} else if (ch == 0) {
				for(int i = 0; i <= product.length; i++) {
					String name = product[i].split(",")[0];
					int stock = Integer.parseInt(product[i].split(",")[1]);
					int price = Integer.parseInt(product[i].split(",")[2]);
					int basket = Integer.parseInt(product[i].split(",")[2]);
					System.out.println(" 제품명\t수량\t가격 ");
					if(basket > 0) {
						System.out.println(name+"\t"+basket+"\t"+basket*price);
					}
				}
				
				
			}
			
			
		}
	}
}
