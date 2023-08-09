package java1.day16.Ex1_필드의다형성;

public class HankookTire extends Tire{

	@Override //부모의 메소인데..
	public void roll() { //메소드 선언부는 그대로 사용하고..
		//여기부터 재정의 해서 쓰는걸  오버라이드
		System.out.println("한국Tire 회전!");		
	}
}
