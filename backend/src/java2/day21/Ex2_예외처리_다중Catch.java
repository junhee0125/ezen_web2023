package java2.day21;

import java.text.NumberFormat;

public class Ex2_예외처리_다중Catch {
	public static void main(String[] args) {
		/* 다중 catch:
		 * 다양한 예외에 따른 서로 다른 흐름제어
		 * */
			String[] array = {"100","1oo"}; //"숫자 100" , "숫자1 + 알파벳 oo"
			
			for(int i= 0 ; i <= array.length ; i++ ) { // 인덱스는  0~1 , length()2 
				//i <= array.length => ArrayIndexOutOfBoundsException
				System.out.println(array[i]); 
				try {
					int value = Integer.parseInt(array[i]);
					//Exception in thread "main" 1oo : 	java.lang.NumberFormatException
				
					//예외클래스 catch 작성순서 : 하위 예외 클래스 블록 먼저 작성
				//} catch(Exception e){
				//Unreachable catch block for NumberFormatException. 
				//.It is already handled by the catch block for Exception	
					
				
				
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("숫자로 변환할 수 없는 데이터" + e);
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("배열 인덱스 초과 "+ e);
				} catch(NullPointerException | ClassCastException e) {
					System.out.println("널 또는  클래스 캐스팅 "+ e);
				}
			}
		
	}
}
