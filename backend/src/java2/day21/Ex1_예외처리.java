package java2.day21;

public class Ex1_예외처리 {
	public static void printLength(String data) {
		try {
			int result = data.length(); 
			/*
			 	1. This is Java => 스트릴객체의 주소값
			 	2. null => 객체의 주소값 없음.
			 		= > java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
			 */
			System.out.println("문자 수"+ result);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			System.out.println("마무리실행");
		}
	}
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		printLength("This is Java");
		printLength(null); // 예외처리가 없으면  여기서 강제종료 : 실행예외는 
		System.out.println("프로그램 종료");
		
		//p.468 : 일반예외 : 실행전부터 컴파일러가 예외검사를 하기 때문에예외 필수
		try {
			Class.forName("java.lang.String");  //일반예외
			//ClassNotFindException : 만약에 클래스를 못찾았을때 예외처리 미리
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//p.468 : 일반예외 : 실행전부터 컴파일러가 예외검사를 하기 때문에예외 필수
		try {
			Class.forName("java.lang.String2");  //일반예외
			//ClassNotFindException : 만약에 클래스를 못찾았을때 예외처리 미리
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
/*
 	에러
 	예외 : 에러 이외
 		- 1. 일반예외 : 컴파일러가 예외 처리 코드 여부를 검사하는 예외
 			- 파일처리, JDBC(DAO), 네트워크, 입출력
 		- 2. 실행예외	: 컴파일러가 예외처리 코드 여부를 검사하지 않는 예외를 말함
  			- 알 수 없음. 개발자의 경험에 의존할 수 밖에...
  			- 타입오류, 배열인덱스, NULL(객체 없다.메소드 사용x)
  	예외처리
  		try{예외가 발생할 것같은 코드}
  		catch{예외가 발생하면 이곳으로 이동하고 예외 정보를 객체내 저장}
 */
