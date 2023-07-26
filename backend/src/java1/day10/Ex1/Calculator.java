package java1.day10.Ex1;
//p.231
//설계도 목적
public class Calculator {
	
	//필드
	
	//생성자
	
	
	//메소드 : 객체의 동작 [객체간의 상호작용]
	/*
	 	 1. 리턴타입 : 메소드 실행한 후 호출했던 곳으로 전달하는 값의 타입
	 	 2. 메소드명 : 소문자시작, 카멜표시법 
	 	 3. 매개변수 : 메소드 호출할 때 전달할 매개값
	 	 4. {} : 매소드 호출시 실행되는 구역 / 부분
	 
	  */
	
		//1. 리턴이 없는 메소드
	void powerOn() {
		System.out.println("전원을 켭니다");
	}
		//2. 리턴값이 없는 메소드
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	int plus(int x, int y) { // 리턴값이 있는 / int형으로  / 매개변수가 2개 
		return x+y ;
	}
	
	double divide(int x, int y) {
		double result = (double)x /(double)y;
		return result;
	}
}
