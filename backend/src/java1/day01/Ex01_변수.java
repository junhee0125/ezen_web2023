package java1.day01; //현재 클래스가 위한 폴더 경로

public class Ex01_변수 { //클래스 시작
	
	//main + ctrl+ space =  자동완성
	public static void main(String[] args) { // 메인함수 시작
		
		// [37p -1]
		
		// 변수선언
		int value1; //int 타입의 value라는 이름의 변수를 선언
		
		//int result = value1 + 10; // value 변수에 10을 더해서 result에 대입하라고..그런데..value 초기값이 없어..에러.
		/*
			Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
			The local variable value1 may not have been initialized

			at java1.day01.Ex01_변수.main(Ex01_변수.java:11)
		 */
		
		//System.out.println(result);
		
		
		// [37p -2]
		
		int hour = 3;
		int minute = 5;
		
		System.out.println("hour : " + hour + " / minute : "+ minute );
		
		
		int totalMinute = (hour*60) + minute ; //변수에 값이 있으면 연산이 가능 
		System.out.println("총 : " +totalMinute+ "분");
		

	}// 메인함수 끝

}//클래스 끝

/*
 * 변수 : 하나의 값을 저장할 수 있는 메모리 번지에 붙여진 이름
 * 변수의 형태 : 
 * 		자료형/타입  변수명;  			// 선언
 * 		자료형/타입  변수명 = 초기값 ;  	// 선언과 동시에 처음값 저장
 * 
 * 타입 : 미리 정해진 변수의 크기		
 * 변수명 : 메모리 번지 대신에 식별용으로 사용되는 메모리 이름  [카멜표기법 권장]
 * = : 오른쪽 데이터를 왼쪽에 대입
 * 
 * 
 * 문자열 처리가 : " "
 * 문자열 연결 : +
 *  
 * 
 * */
