package java1.day15.Ex1_상속final;

public class Member {
	
	/*
	 	final: final(최종적) 뜻이므로 수정 불가능한 상태로 만드는 키워드
	 		- 필드
	 			final int 나이 = 30; 	: 수정 불가능한 필드
	 		- 클래스
	 			final class Member{}	:	해당 클래스는 상속 불가능 [* 상속 불가 클래스]
	 		- 메소드
	 			final void stop(){}		: 	자식클래스에서 오버라이딩 불가능
	  
	  	접근제한자
	  		public 						vs		private
	  		- 모든 클래스 범위						- 현 클래스 범위
	  		- 프로젝트 모든 곳에서 호출이 가능			- 현재 클래스에서만 호출
	  
	  		default)					vs		protected
	  		- 현재 클래스의 패키지내 					- 현재클래스의 패키지내
	  		- 모조건 동일 패키지태 / 하위패키지			- 동일패키지내/하위패키지
	  		- (생략 가능)							- 단!! 자식클래스가 다른 패키지에 있는 부모클래스를 호출 가능
	  
	  */
	
	public void stop() {}
	public void stop2() {}

}
