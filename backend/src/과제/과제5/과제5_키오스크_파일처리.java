package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크_파일처리 {

	public static void main(String[] args) throws IOException {
		
		
		
		//String[] 재고관리 = new String[100];
		
		/* ----------- */
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in); //입력객체
			String filePath =  "./src/과제/과제5/재고파일.txt"; //파일경로
			FileOutputStream fileOutputStream = new FileOutputStream(filePath, true) ;//파일출력 
			FileInputStream fileInputStream = new FileInputStream(filePath); //파일입력
			File file = new File(filePath);
			
			/* --- 파일내 제품 정보 --> 배열로 옮기기---*/
			byte[] inByteArray = new byte[(int)file.length()];
			fileInputStream.read(inByteArray);
			String fileInfo = new String(inByteArray);
			//System.out.println(fileInfo);
			
			/*--- 파일의 제품 정보 문자열 >>> 배열로 저장-->*/
				//1. 하나 문자열로 모든 제품의 문자열을 각 제품별로 분리
			String[] product =  fileInfo.split("\n");
			System.out.println("제품분리  :: " + Arrays.toString(product));
				
				// 각 제품별로 각 필드/정보 분리
			
			
			
			
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.print("-1:제품등록 | 0:결제 | ");
				// 재고관리 배열에 있는 제품만 선택가능하도록 출력

			for(int i= 0 ;  i < product.length; i++) {
				if(!product[i].equals("")) {
					String name = product[i].split(",")[0];
					int stock = Integer.parseInt(product[i].split(",")[1]);
					int price = Integer.parseInt(product[i].split(",")[2]);
					//int basket = Integer.parseInt(product[i].split(",")[3]);
					
					// 재고유무에 따라 
					if(stock == 0 ) {
						System.out.print((i+1) + " : " + name + "[재고없음] | ");
					} else {
						System.out.print((i+1) + " : " + name +  "[" +price+"원] | ");
					}					
				}
				
				//System.out.println(name);
			}
			
			
			System.out.print("\n>>>>>> 선택 : "); int ch = scanner.nextInt();
			
			
			
			if (ch == -1) { //만약 -1이면 제품 등록
				System.out.print("제품명 : "); String name = scanner.next();
				System.out.print("재  고 : "); int stock = scanner.nextInt();
				System.out.print("가  격 : "); int price = scanner.nextInt();
											   int basket = 0;
											   
				//해당 데이터를 하나의 데이터로 구성
				String outStr = name +"," + stock +"," +price+"," +basket+"\n";
				
				//파일로 내보내기 
					// 파일출력스트림객체 > 문자열을 바이트배열로 변환 > 바이트배열 내보내기
				fileOutputStream.write(outStr.getBytes());
				
				System.out.println("안내 ) 제품 등록이 되었습니다.");
			}
			
			/*--------------------------선택한 제품을 바구니에 담기-------------------------*/
			else if(ch > 0 && ch < product.length+1 ) {
				System.out.println("제품");
				String name = product[ch-1].split(",")[0];
				int stock = Integer.parseInt(product[ch-1].split(",")[1]);
				int price = Integer.parseInt(product[ch-1].split(",")[2]);
				int basket = Integer.parseInt(product[ch-1].split(",")[3]);
				
				if( stock > 0 ) {
					  stock--; 
					  basket++;
					  System.out.println(name + "을 바구니에 담았읍니다 (^0^)");
				} else { 
					System.out.println(name + "제품의 제고가 부족합니다."); 
				} 
				
				//
				product[ch-1] = name +"," + stock +"," +price+"," +basket; //해당 인덱스의 데이터를 업데이트하고
				System.out.println(product[ch-1]);
				//System.out.println(product[ch-1].split(",")[0] +"을 선택하셨습니다"); // 재고
				//파일에 내보내기
				String outStr = "";
				for( int i = 0 ; i < product.length ; i++) {
					outStr +=  product[i].split(",")[0]+","+
							  product[i].split(",")[1]+","+
							  product[i].split(",")[2]+","+
							  product[i].split(",")[3]+"\n";
				} //for end
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath);
				fileOutputStream2.write(outStr.getBytes());
				
			}
			/* ----------- */
		 else if( ch == 0 ) {
			System.out.printf("%10s %10%s %10s \n", "제품명", "수량" , "가격");
			for(int i = 0 ; i <product.length ; i++ ) {
				int basket = Integer.parseInt( product[i].split(",")[1]);
				int price = Integer.parseInt( product[i].split(",")[2]);
				int name = Integer.parseInt( product[i].split(",")[3]);
			}
		}
		} // while end 
	} // main end 
} // class end 



