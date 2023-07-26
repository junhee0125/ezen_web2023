package java1.day10.Ex3;

public class Ex3_return문 {
	public static void main(String[] args) {
		
		
		Car car = new Car();
		
		car.setGas(5);
		
		if (car.isLeftGas()) {
			System.out.println("출발합니다.");
			car.run();
		}
		System.out.println("가스를 주입하세요");
		
	}
}
