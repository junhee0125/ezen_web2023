package java1.day14.Ex3_부모메소드호출;

public class SupersonicAirplaneExample {
		
	public static void main(String[] args) {
		//필드
	    //생성자
		//메서드
		
		SupersonicAirplane sa = new SupersonicAirplane();
		System.out.println(sa.color); // 부모꺼
		sa.hashCode(); //오브젝트꺼 // 조상님
		sa.land();//본인꺼
		sa.fly(); //오버라이드
		sa.takeoff(); //부모꺼
		
	}
	
}
