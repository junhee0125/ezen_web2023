package 과제.과제2.Level1.ex3;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_3 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_3 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		/* 문제풀이 위치 */
		boolean bl = scanner.nextBoolean();
		byte bt = scanner.nextByte();
		String st = scanner.next();
		char ch = st.charAt(0); 
		short sh = scanner.nextShort();
		int in =scanner.nextInt();
		long lo = scanner.nextLong();
		float fl = scanner.nextFloat();
		double dob =scanner.nextDouble(); 
		
		
		
		System.out.print("boolean : " + bl );
		System.out.print("byte : " + bt );
		System.out.print("char : " + ch );
		System.out.print("short : " + sh );
		System.out.print("int : " + in );
		System.out.print("long : " + lo );
		System.out.print("float : " + fl );
		System.out.print("double : " + dob );
		

		
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 모든 기본자료형 8개 사용
		2. print() 메소드 사용
		3. scanner 객체 사용하여 입력받기
*/
