package java1.day10.Ex4;

public class Member {
	//필드
	//생성자
	//메소드
	
	//---------------------------------------선언--------------------------------------------//
	//리턴도 없도, 매개변수도 없는 함수
	void signup() {	}
	
	//리턴 없고, 매개변수 있고
	void login(String id, int pw){	}
	
	//리턴있고, 매개변수 없고.
	String findId() {	return "찾은아이디";	}

	//리턴있고 매개변수 있고
	String[]  findPw(String s1, String s2) { 
		String[] array  = {s1,s2};
		return array;
	}
	
	//리턴없고 매개변수가 가변길이를 갖는 함수
	// ... : 여러 매개변수들을 하나의 힘에 저장해서 힙주소 반환
		// 매개변수가 두개 이상인경우 가변길이 매개변수는 뒤에 위치하도록 
	// new : 클래스 기반으로 힙에 객체 생성하는 힙의 객체주소 반환 
	//오버로딩 : 타입이 다르거나 / 매개변수의 갯수가 다르거나 / 타입간의 순서가 다르면 OK~
	void delete(String ...strArray) {	}
	void delete(int num, String ...strArray) {	}
	
	//return문 : 호출했던 곳으로 돌려주는 것.
}	
/*
  메소드 : 객체이 동작 / 객체의 상호작용 / 서로다른 클래스간의 데이터이동(MVC2패턴)
	선언 : 리턴타입 메소드명 (매게변수1 , 매개변수2~) {실행코드 return}
	
 */