package java1.day14.Ex3_부모메소드호출;

public class Airplane {

	
	//필드
	public String color = "red";
    
	
	//생성자
	public Airplane() {
		super(); //부모 생성자 호출
	}
	
	
	//메서드
	public void land() {
		
		System.out.println("착륙합니다.");
	}
	
	public void fly() {
		System.out.println("일반 비행합니다.");
	}
	
	public void takeoff() {
		System.out.println("이륙합니다.");
	}
}
