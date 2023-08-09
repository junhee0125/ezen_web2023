package java1.day18.Ex1;
/*
 		JVM의 실행메모리
 		1. 메소드 영역			2. 스택영역				3. 힙영역
 			- 클래스정보			- 합수{}내 변수들		- 객체(인스턴스)
 			- 메소드										- 필드만 저장
 			- static정적
 			- interface정보							- 익명구현객체
 		class 사람 {				사람 유재석 = 101번지	유재석 객체 (나이 = 30)			
 			int 나이;				사람 강호동	 = 102번지	강호동 객체	(나이 40)
 			void 밥먹기 (){}
 		}
 		
 */
public interface RemoteControl {
	//멤버구성
		/*
		  	1. 상수필드 (일반 변수는 없음. must)
		  	2. 추상메소드
		 */
	public static final int MIN_VOLUME = 0;
	int MAX_VOLIME = 10; // # public static final 생략가능  (컴파일할때 자동적으로 붙기때문)
	
	//추상메소드 (선언만 하는)
	public void turnOn(); // //abstract 가 생략가능
	void turnOff();
	void volumeUp();
	void volumeDown();
	void setVolume(int volume); 
	
}
