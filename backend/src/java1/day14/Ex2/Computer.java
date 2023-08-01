package java1.day14.Ex2;

public class Computer extends Calculator {
	//필드
	//생성자
	//메소드
	
		//부모클래스 [Calculator]에게 생속받은 메소드를 재정의
		/* 오버라이딩: 자식클래스는 부모엑 물러받았기 때문에
		 * 	자식 클래스에서 부모클래스와 동일한 이름으로 메소드를 선언하는 것은 불가능하다
		 *  동일한 이름으로 선언하고 매개변수[개수, 타입, 순서] = > 오버로딩
		 *  동일한 이름으로 선언하고 매개변수까지 모두 동일하면 오버라이딩
		 
		 */
	@Override //생략가능
	public double areaCircle(double r) {
		// TODO Auto-generated method stub
		return Math.PI*r*r;
	}
}
