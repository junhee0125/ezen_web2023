package java1.day14.Ex1상속;

public class Ex1_실행 {
	public static void main(String[] args) {
		Phone phone = new Phone();
		
		System.out.println(phone.color);
		System.out.println(phone.model);
		
		phone.bell();
		phone.sendVoice("여보세요");
		phone.receiveVoice("안녕하세요 저는 길동홍입니더");
		phone.hangup();
		
		
		
		SmartPhone smartPhone = new SmartPhone("갤럭시", "은색");
		System.out.println(smartPhone.color);
		System.out.println(smartPhone.model);
		System.out.println(smartPhone.wifi);
				
				
		smartPhone.bell();
		smartPhone.sendVoice("여보세요");
		smartPhone.receiveVoice("안녕하세요 저는 길동홍입니더");
		smartPhone.hangup();
				
		smartPhone.setWifi(true);
		smartPhone.internet();
	}

}
