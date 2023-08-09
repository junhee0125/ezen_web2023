package java1.day20.Ex1;

public interface RemoteControl {
	//인터페이스  :  두 장치(객체)를 연결하는 접속기
	//구성멤버
		//1. public 상수필드 	[public static final] 생략가능
		int MAX_VOLUME = 10;
		public static final int MIN_VOLUME = 0;
		
		//2. 추상메소드				[public abstract]
		void turnOn();
		public abstract void turnOff();
		void setVolume( int volume);
		
		//3. 디폴트 메소드		[public default] : 선언부 + 실행부 = >구현객체 O
		default void setMute(boolean mute) {
			if(mute) {
				System.out.println("무음처리합니다.");
				setVolume(MIN_VOLUME);
			}
			
		}
		
		public  default void getMute() {System.out.println();}
		
		//4. 정적메소드 [public ]static : 선언부 + 실행부 =? 구현객체x
		static void changeBettery() {System.out.println("리모콘 건전지를 교환합니다.");}
		public static void checkBettery() {System.out.println("리모콘 건전지를 확인합니다.");}
		
		//---------> 자바 9버전 이상부터 
		//5. private 메소드
		//private void defaultCommon() { System.out.println("dafaultMethod"); }
		
		//6. private 정적메소드
		//private void staticCommon() { System.out.println("dafaultMethod"); }
		//                                                    <--------------------- //
/*
		  인스턴스 멤버	:  	객체 생성시 메모리 항당되는 필드, 메소드 (static이 없는)
		  정적멤버 	:	객체가 없어도 메모리 우선할당된 필드, 메소드 (static이 있는)
		  - 정적멤버는 인스턴스멤벙 접근할 수 없다. [p.249] 
 */
}
