package java1.day14.Ex3_부모메소드호출;

public class SupersonicAirplane  extends Airplane{
	//필드
	//상수
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	//인스턴스 필드
	public int flyMode = NORMAL;
    
	//생성자
	//메서드
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행기입니더");
		} else {
			super.fly();
		}
		
	}
	
}
/*
				this			super
				현재클래스			부모클래스
 	필드			this.필드명		super.필드명
 	생성자		this();			super();
 	메소드		this.메소드명();	super.메소드명();
 	
 	오버로딩 :동일한 메소드명일때 매개변수에 따른 식별 가능
 	오버라이딩 : 부모클래스로 상속받은 메소드를 재정의 할때
 	
 	자식클랫명 extends 부모클래스
 */