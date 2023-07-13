package java1.day01;

public class EX03_타입변환 {
	public static void main(String[] args) {
		// 1. [p53] 자동 타입변환
				// byte -> short -> int ->long -> float -> double
				
				
		
		byte b1 = 10; 
				
		int i1 = b1; 
				//System.out.println("i1  : "+ i1 );
				
		char  c = '가' ; //0~6만5천 
		i1 = c;
				//System.out.println("i1  : "+ i1 );
				
		//2. [p55] 강제 타입 변환
		// byte <- short <- int <- long <- float <- double
		
		int i3 = 10; 	byte b2 = (byte)i3 ;
		long l3 = 300; 	int i4 = (int)l3;
		int i5 = 65;	char c2 = (char)i5;
		double d2 = 3.14;	int i6 = (int) d2;
				
	}		
		
		
		
}

/*
 * 타입/ 자료형 변환
 *
 * 1/ 자동타입변환 작은 타입 = > 큰 타입 [자동] - 큰 허용범위 타입 = 작은 허용범위 타입
 * 
 * 2. 강제타입변환 큰 타입 --> 작은 타입 [수동] * 주의 : 데이터 손실 발생할 수 있음 예) double 31.5 => int 31
 * - 작은 허용범위 타입 = ( 작은 허용범위타입) 큰 허용범위 타입 [캐스팅]
 * 
 * 3. 연산시 자동차입 변환
 * 	- 피연산자 중 큰 타입의 결과 타입변환
 * 
 * 		[정수]
 * 		1. int + byte or short = int
 * 		2. int + long = long
 * 		3. 
 * 		
 * 		[실수]
 * 		float + float = float
 * 		float + double = double
 * 
 * 4. 문자열 >>>>> 기본타입
 * 		- 외부에서 데이터가 문자로 들어오는 경우 다수 [JS >> JAVA]
 * 		- 기본형에는 기능이 없음.. (쓸수 있는 메소드가 없음)
 * 		- 기본타입클래스는 제공하는 메소드가 있다는.
 * 		Byte.parserByte()
 * 		Short.pasrShort()
 * 	    Integer.parseInt("10") >>>  10
 * 
 * 
 * 	  기본타입 >>>>>>> 문자열 
 * 			1. String.valueOf()
 * 				10  >>> "10"  String.valueOf();
 * 			
 * 			2. +""
 * 				10+"" =>> "10"
 */
