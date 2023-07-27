package 과제.과제10;

public class Member {

	//필드 : 객체의 데이터를 저장하는 곳
	//인스턴스 :  각각
	//static은 공통
	 String id; 
	 String pw;
	 String name;
	 String phone;
	 int age;
	
	 
	 
	 
	/**
	 * 생성자는는
	 * 빈생성자하나. 풀생성자 하나는 기본적으로 만드는 것이 좋음.
	 * 특정 갯수, 필드를 저장하는 생성자는  추후에 필요하면 선언하면됨
	 */
	public Member() { super();	}




	//생성자 : 객체의 초기화를 담당하는 역할
	Member(String id,String pw, String name, String phone, int age){
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}



	//메소드 : 객체의 행동을 담당 역할 - 인스턴스 vs 정적멤버
	
		// 1. setter or getter
		
		// 2. toString : 객체 호출시 객체의 주소가 아닌 필드의 값을 반환해주는 함수 [개발자의 검사용]
			//오른쪽마우스 클릭 > source > Generate toString() -> 모든 필드 체크후 생성
		
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}

	
	
}
/*
 	JVM : 자바 가상(논리적으로 만들어낸) 메모리
 	
 		Member.java----[클래스 로더]----> Member.class
 		
 		
 	this : 인스턴스멤버 : new 힙생성시 할당되고 힙초기화되면  (GC)
 			객체를 통해생성
 			static 키워드 없으면
 			
 	static : 정적멤버 : 프로그램 시작 할당되고 프로그램이 종료될때 [전역 / 공통 / 공용 / 공유]	
 			static있는
 			클래스
 			
 	final : 수정불가 : 초기할때 대입만 가능 수정은 불가능		
 	
 	static final : 상수  : 프로그램내에서 1개만 저장 (static) , 수정불가 (final) 불변의 전역변수
 */