package 과제.과제2.Level1.ex7;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_7 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_7 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String output = "";
		
		/* 문제풀이 위치 */
		String  name = scanner.next();
		boolean stat =  scanner.nextBoolean();
		byte memberNo = scanner.nextByte();
		String gender = scanner.next();
		char sex = gender.charAt(0);
		short age = scanner.nextShort();
		int point = scanner.nextInt();
		long account = scanner.nextLong();
		float tall = scanner.nextFloat();
		double weight = scanner.nextDouble();
		
		
		output = "==========회원 개인정보============"
				+ "\n|        회원명 : "+name+"		|"
				+ "\n|        상태 : "+stat+"		|"
				+ "\n|        회원번호 : "+memberNo+"		|"
				+ "\n|        성별 : "+sex+"		|"
				+ "\n|        나이 : "+age+"		|"
				+ "\n|        포인트 : "+point+"		|"
				+ "\n|        예금액 : "+account+"	|"
				+ "\n|        평균 : "+tall+"		|"
				+ "\n|        평균 : "+weight+"		|"
				+"\n===================================";
				
		System.out.println(output);		

		/* ----------- */
	}
}
/* 
	[문제조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 기본 자료형8개 + 문자열클래스 변수 1개 를 이용한 9개변수를 입력 받습니다.
		3. 입력받은 9개 변수를 그림과 같이 출력합니다.
		4. 기존에 미리 작성된 변수를 최대한 활용합니다.
유재석
true
20
M
45
25000
5000000
78.2
88.59
*/
