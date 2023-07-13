package java1.day01;// 현재 패키지경로

public class Ex02_타입 { //클 시작
	
	public static void main(String[] args) { // 메인시작
		//1. [41p] 진수를 표현하는 방법
		
			/* 진수: 데이터를 표현한는 방식/ 현식
			*	 0,1 : 2진수,  0-7 : 8진수,  0-9 : 10진수 , 1-9abcdef : 16진수 (메모리주소는..보통16진수로)
			* 	기계어 표현을 극복하기 위해서...
			* 
			* 용량단위 : 
			* 	 1 bit : 0,1  -> 01010101(8자리) 8bit > 1byte 
			*    1byte -> 1024byte -> 1kbyte
			*    1kb - > 1024kb -> 1mb
			*    1mb - > 1024mb -> 1gb 
			*    
			*    처리최소단위  :비트, 저장최소단위 : 바이트
			*
			*/
		
		int var1 = 0b1011; // 데이터 앞에 0b : 2진수 표현
		System.out.println("var1 : " + var1); // int는 10진수로 표현하기 때문에.. 출력하면 11
		
		int var2 = 0206; // 데이터 앞에 0 : 8진수
		System.out.println("var2 : " + var2 ); //134
		
		int var3 = 365;
		System.out.println("var3 10진수 : " + var3); //365
		
		int var4 = 0xB3; // 데이터 앞에 0x : 16진수
		System.out.println("var4 16진수 : " + var4 ); //179
		
		// [42p] byte 타입
		byte  b1 = -128; System.out.println("b1 : " + b1);
		byte  b2 = 127; System.out.println("b2 : " + b2);
		//byte  b3 = 200; System.out.println("b3 : " + b3); //Type mismatch: cannot convert from int to byte
		//byte  b4 = -128; System.out.println("b1 : " + b1);
		
		//short타입 [] -32000~ 32000
		short  s1 = 32000;
		//short s2 = 50000; //Type mismatch: cannot convert from int to short
		
		//int타입 : 정수 기본자료형 :우리가 작성하는 숫자 = int
		int i1 = 2100000000; System.out.println("i1  :  " + i1);
		//int i2 = 3100000000; System.out.println("i2  :  " + i2); //The literal 3100000000 of type int is out of range  리터럴은 데이터(값) 그 자체를 뜻한다
		
		//long 타입 [21억 이상을 쓸때] 1000경까지 표현되지만. 그 이상을 표현할때는 "10000000000....000"
		long l1 = 10 ; System.out.println("l1  :  " + l1);
		//long l2 = 30000000000 ; System.out.println("l2  :  " + l2); //The literal 30000000000 of type int is out of range  우리가 입력한코드는  인트타입이기때문에...  에러
		long l3 = 30000000000L ; System.out.println("l3  :  " + l3); // 'L' 입력해주면 long타입으로 인식
		
		
		// [p43] char - 'a' 작은 따옴표 안에 문자1개
		char c1 = 'A'; 		System.out.println(" c1 " + c1 );
		char c2 = 65; 		System.out.println(" c2 " + c2 ); //A
		char c3 = '가'; 		System.out.println(" c3 " + c3 ); //A
		char c4 = 44633; 	System.out.println(" c4 " + c4 ); //A
		
		//[ p49] String 클래스 (타입이 아님) 
		String str = "안녕하세요"; System.out.println("  str " +  str ); //A
		
		//[45p] float타입 실수  (소수 8자리까지)데이터뒤에 
		float f1 = 0.12345678f; System.out.println(" f1 " + f1 );
		
		//더블타입
		double d1 = 0.123456789123456789123456; System.out.println("d1  :" + d1 );
		
		//boolean
		boolean bool1= true; System.out.println(" bool1 " + bool1 );
		
		//[p50] 제어 / 이스케이프(기능) 문자
		System.out.println("\" ");
		System.out.println("\' ");
		System.out.println("\\ ");
		System.out.println("\45 "); //유니코드
		System.out.println("\t\" ");
		System.out.println("\n ");
		System.out.println("\r캐리지 리턴 "); //커스를 맨앞으로
		//Enter = \n\r
	} //메인끝
	
	//자동줄정리 컨트롤 + 쉬프트 + f
} // 클 끝

/* [타입 / 자료형] : 데이터 저장할 때 사용되는 메모리 크기
 * 		1. 메모리 효율성 높일 수 있다.
 * 		2. 가독성 높음.
 * 								메모리크기				허용범위
 *  	논리타입   	
 *  			boolean			1bit					0 = false 1= true 
 *	
 * 	  	문자타입	
 *   			char			2byte					 유니코드 : 65만 / 전세계문자 / 
 *   			String			클래스					 무제한
 *   	문자열타입
 *   
 * 		정수형타입
 * 				byte			1바이트		-128/=127		
 * 				short			2바이트		-32,768 / + 327657
 * 				int				4바이트		대략 +-21억정도
 * 				long			8바이트		21억이상
 * 		실수타입
 * 				float			4바이트		ㅅㅅ 9
 * 				Double			8바이트		소수17자리
 * 
 * */
