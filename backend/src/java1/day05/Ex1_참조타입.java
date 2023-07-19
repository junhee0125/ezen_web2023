package java1.day05;

public class Ex1_참조타입 {
	public static void main(String[] args) {
		//[p.148]
		int[] arr1; // int형 타입의 배열변수 선언
		int[] arr2; // 스택영역에 메모리 할당
		int[] arr3;
		
		arr1 = new int[] {1,2,3};
		arr2 = new int[] {1,2,3};
		arr3 = arr2; //arr2의 주소값을 arr3에 저장
		System.out.println(arr1 == arr2); //(배열 값은 같지만. 각각의 배열은 주소값이 다르므로 )
		System.out.println(arr2 == arr3); // arr2의 주소를 arr3에 저장되었으므로  true
		
		
		//[p. 151]
		int[] intArray = null;	//스택영역에 변수가 메모리 할당, 하지만 아직 힙 영역은 만들어지지 않았음 즉, 참조중인 객체 번지가 없음
		/*intArray[0] = 10; //  배열은 힙에서 생성되는데 아직 배열이 힙에 생성되지 않았기 때문에;
		 
		 * System.out.println( intArray[0]);
		 * 
		 * Exception in thread "main" java.lang.NullPointerException: Cannot store to int array because "intArray" is null
			at java1.day05.Ex1_참조타입.main(Ex1_참조타입.java:19) 
		*/
		String str = null; //스택에 str을 생성되어 있는 상태지만 아직 힙 영역에 생성되지 않은 상태
		
		/*
			System.out.println(str.length());
			
			Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null
			at java1.day05.Ex1_참조타입.main(Ex1_참조타입.java:27)
		 */
		
		String hobby = "여행";
		/* 스틱 영역에 hobby 지역변수 선언 
		 * 힙 영역에 "여행" 문자열 객체 생성
		 * 생성된 힙영역에 여행 객체의 조소를 스택영역의 hobby에 지역변수에 대입 
		 *
		 * */
		hobby = null; // 스택 영역  hobby에 null 대입 (새로운 값으로 대체) -> hobby에 있던 여행을 참조한 메모리 주소가 사라짐.
		// 아무도 힙 영역에 있는 "여행" 문자열을 참조하지 않으면 GC	쓰레기 수집기가 자동으로 객체 삭제
		
		//[p.153]
		String kind1 = "자동차"; // 스택영역 Kind1[32번지]		힙영역 : 자동차객체 [32벉;]
		String kind2 = kind1; 	// 스택영역 Kind2[32번지]
		
		 kind1 = null;			// 스택영역 Kind1[null]	
		 						// 스택영역 Kind2[32번지]	
	}

}
/*
 	자바 데이터 타입:  변수 선언할 때 사용되는 타입
 		- 기본타입 : boolean byte short char int long float double  => 정해진 크기
 			- 변수에 갑 자체를 저장
 			- 소문자로 시작
 			
 		- 참조타입 : 배열, 열거, 클래스( String Scanner Random System 등) 인터페이스
 			- 변수의 힙 메모리에 생성된 메모리 주소.번지를 참조
 			- 대문자로 시작
 			
 		
 	JVM 메모리
 	
 		<스택영역>
 		모든 변수는 (스택 영역) 에서 선언되어진다.
 		스레드 마다 스택영영이 생성된다.
 		생성된 스택 영영안에는 함수마다 프레임이 만들어진다.
 		메소드 호출이 끝나면 (함수가 끝나면,{ } 끝나면 ) 자동제거된다. 
 		=> 스레드마다 스택이 생성되고 생성된 스택에 메소드마다 프레임이 만들어진다. 만들어진 프레임안에 변수가 선언되어진다.
 		
 		<힙영역>
 		- 객체가 생성되는 영역
 			- 스택영역이나 메소드 영역에 참조할 수 있다.
  			- 객체, 배열, 인터페이스 메모리 생성
  			new 연산자(가 힙 메모리를 만들때 쓰는것.) : 타입/클래스 기반으로 새로운 메모리생성후 주소 반환
  			
  			
 		스레드는  : 대략 프로세스의 흐름
 		
 		  	-----------------		------------------
 			|	 스택영역	|		|		힙		 |
 			-----------------		------------------
 			int a = 25
 			String a = 100번지------100번지 : 신용권
 
 			(== / !=) : 
 			
 			= 스택 영역의 값을 비교하는 것 / 참조 주소를 비교하는 것
 			그래서  String  변수의 값이 같은지 문자열 비교할때 .equals() 사용하는것.
 
 
 
 
 
 */