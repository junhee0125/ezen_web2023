package java1.day10.Ex1;
//p233
//싫행목적
public class Ex1_메소드선언호출 {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		cal.powerOn();
		
		int result = cal.plus(5,10);
		System.out.println(result);
		
		int x = 10;
		int y = 4;
		double result2 = cal.divide(x,y);
		System.out.println(result2);
		
		
		cal.powerOff();
	}
}
/*
 	메소드는 상호작용을 한다???
 	
 	사람이란 객체가  계산기의 더하기 기능을 이용하면 계산기는 그 결과를 리턴하는건. (상호작용)
 	main에서  calculator클래스의 plus()메소드를 호출하고  결과값을 리턴한다.
 	=> 서로 다른 클래스간의 데이터 전달이 가능
	=> 클래스의 역할을 구분해서 
	
	예) 손님  >  주문 > 웨이터 > 요리사 
	 	요리 < 웨이터 < 요리사
 */
