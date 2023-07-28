package 복습.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Part4_02 {
	public static void main(String[] args) throws IOException {
		
		while(true) {
			
			Scanner sc = new Scanner(System.in);
			String filePath = "./src/복습/part4/product2.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			
			String fileInfo = new String(inByteArray);			
			String[] product = fileInfo.split("\n");
			
			
			System.out.println("(메뉴션택)-------------------------");
			System.out.print("-1: 제품등록 0: 결제 ");
			
			for(int i = 0; i< product.length; i ++) {
				if(!product[i].equals("")) {
					
					String name = product[i].split(",")[0];
					int stock = Integer.parseInt(product[i].split(",")[1]);
					int price = Integer.parseInt(product[i].split(",")[2]);
					
					if(stock >0 ) {
						System.out.print((i+1) +":"+ name +"[ "+ price +"원 ]");
					}else {
						System.out.print((i+1) +": 재고가 없습니다." );
					}					
				}				
				
			}
			
			System.out.println("\n>>>> 선택");
			int ch = sc.nextInt();
		
			
			
			if( ch == -1 ) {
				System.out.println("제품명 : "); String name = sc.next();
				System.out.println("재고량 : "); int stock = sc.nextInt();
				System.out.println("가 격 : "); int price = sc.nextInt();
				int basket = 0;
				
				String outStr = name + "," + stock + "," +price +"," +basket ;
				
				fileOutputStream.write(outStr.getBytes());
				System.out.println("제품이 등록되었습니다.");
				
			} else if (ch >0 && ch <= product.length ) {
				
				
				
				
			} else if(ch == 0) {
				
				
				
			}
			
		}
		
		
		
	}
}
