package java1.day09.ex2;

public class Korean {
	
	//필드
	String nation = "대한민국";	// 객체마가 동일한 값을 갖고 있다면. -  객체에 필드값을 미리 초기화 
	
	String name;				// 객체마다 다른 값을 가져야 한다. - 객체의 필드값 기본값 -> 생성자 이용 권장
	String ssn;
	
	//생성자
	
	public Korean() {}
	
	public Korean(String name) {}
		
	public Korean(String name, String ssn) {
		// this : 현재 클래스를 뜻함. [매개변수 : 외부로부터 들어온 변수명 동일할 때]
				// 해당함수.메소드, 생성자가 호출한 객체 = > 주체
		this.name = name;		this.ssn = ssn;
	}
	
		//3. 매개변수 3개인 생성자 : [매개변수 갯수가 다르거나]
	public Korean(String name, String ssn, String nation) {
		this(name,ssn);
		this.nation = nation;
	}
	
	
	
	
		//4. 매개변수 2개인 생성자 : [매개변수 타입 다르거나]
	public Korean(String name, int ssn) {}	

		//4. 매개변수 2개인 생성자 : [매개변수 순서가 다르거나]
	public Korean(int ssn,String name) {}	
	//메소드

}
/*
 	오버로딩 : 동일한 메소드명으로 어러개 선언 불가능!! 왜! 식별이 안되자너
 		해결책 : 매개변수의 개수, 타입 을 이용한 메소드 식별;
 
 */
