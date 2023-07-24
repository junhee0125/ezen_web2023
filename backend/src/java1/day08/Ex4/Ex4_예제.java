package java1.day08.Ex4;
//실행목적 : 
public class Ex4_예제 {
	public static void main(String[] args) {
	
		//1.Car 객체 선언 :  클래스명  변수명 = new 생성자명();
		Car car = new Car();
		
		//2. 객체를 이용한 필드의 호출 [. 접근 연산자]
		System.out.println( "제작회사 : "+ car.company);
		System.out.println("모델명" + car.model);
		System.out.println("색상" + car.color);
		System.out.println("최고속도" + car.maxSpeed);
		System.out.println("현재속도" + car.speed);
		
		//3. 필드값 변경
		car.speed = 60;
		System.out.println("수정된 속도" + car.speed);
		
		
		 Car yourCar = new Car();
		 System.out.println("너차 속도 : " +yourCar.speed);
		 
		 car = yourCar;
		 System.out.println("내차 속도 : " +car.speed);
	}
}
