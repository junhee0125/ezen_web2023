package java1.day18.Ex1;

public class Ex1_실행 {
	public static void main(String[] args) {
		//인터페이스타입의 객체
		// 인터페이스로 객체는 못만듬.  RemoteControl rc = new  RemoteControl
		RemoteControl rc ;
		
		rc = new Television(); //변수에 텔레비전 객체의 주소값을 대입 # 구현객체 
		// # 구현객체 : 해당 추상메소드가 존재하는 인터페이스를 구현해준 클래스로 객체 생성
		
		//인터페이스로 메소드 실행
		rc.turnOn();
		
		//rc = new Audio();
		//rc.turnOn();
		System.out.println("rc.MAX_VOLIM  :  "+rc.MAX_VOLIME);
		System.out.println("rc.MIN_VOLUME  :  "+rc.MIN_VOLUME);// s메소드 영역
		
		rc.setVolume(100);
	}
}
/*
 			인터페이스 			vs 		상속
 			implement				extends
			구현하다					연장하다
			여러개 구현					1개 상속
			추상메소드					메소드
			버전에 따라 다양한 메소드 제공
			목적 : 메소드 통합			빠른 개발 / 설계 / 모듈화[쪼개서] 
			오락실 개임패드				직급별사원
 */