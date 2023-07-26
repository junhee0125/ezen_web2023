package java1.day10.Ex2;

public class Computer {
	//1. 필드
	//2. 생성자
	
	//3.메소드
	
	/*
	 	1. 가변(정해져 있지 않는)길이 매개변수를 갖는 메소드 선언
	 	
	 	... 키워드를 이용한
	 	
	 	2. 가변길이와 일반매개변수가 있을 경우 : 가변길이매개변수를 가장 뒤에 선언해야.
	 	 예) sum(int ...values, String s) --  x
	 	 예) sum(String s, int ...values ) --  x
	 	 
	 	3. 여러개의 리터럴과 하나의 배열을 가변길이 매개변수로 전달받음 
	 	
	 */
	int sum(String s, int ...values) { 
		int sum= 0 ;
		for(int i=0; i < values.length ; i++) {
			sum += values[i]; //배열내 하나씩 누적합계
		
		}
		return sum;
	}
	
	/*
	 
	 
	 */
	int sum2(String s, int[] values) { //int타입의 배열로 매개변수를 받아야 함
		int sum= 0 ;
		for(int i=0; i < values.length ; i++) {
			sum += values[i]; //배열내 하나씩 누적합계
		
		}
		return sum;
	}
} //class e
