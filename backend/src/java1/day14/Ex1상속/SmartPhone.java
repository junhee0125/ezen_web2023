package java1.day14.Ex1상속;

public class SmartPhone extends Phone{
/*
 	자바는 100% 객체 지향언어 = 상속 문법 사용
 */	
	//필드
	public boolean wifi;
	
	//생성자 
	public SmartPhone(String model, String color) {
		this.model = model;
		this.color =color;
	}


	//method
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}

}
