package java2.day24_제네릭.Ex3;

public class Ex3_제네릭 {
	public static void main(String[] args) {
		
		//1. 홈 렌탈 조작하는 구현체 [집렌탈 - 00지점]
		HomeAgency hAgency = new HomeAgency();
		Home home = new Home();	 // 해당대리점에서 새로운 홈객체생성
		home.turnOnLight();			// 렌탈한 홈 객체에서 메소드 실행
		
		Home 유재석집 = new Home();
		유재석집.turnOnLight(); 		//유재석잽의 집이 켜짐
		Home 강호동집 = new Home();
		
		
		//2. 자동차 렌탈 구현체	[카렌탈 -- 00지점]
		CarAgency cAgency = new CarAgency();
		Car car = new Car();
		car.run();
	}
}
