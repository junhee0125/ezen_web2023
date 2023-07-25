package java1.day09.ex1;

public class Ex1_생성자 {
	
	public static void main(String[] args) {
		
		//1. 객체생성 : 클래스명, 객체변수명 = new 생성자명;
		
		
		/*
		 * Car myCar = new Car();
		
		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		The constructor Car() is undefined
		at java1.day09.Ex1_생성자.main(Ex1_생성자.java:9)

		 */
		 Car myCar = new Car();
		 Car myCar1 = new Car("그랜져", "검정", 20);
	}
	
	
	
	
	
}
