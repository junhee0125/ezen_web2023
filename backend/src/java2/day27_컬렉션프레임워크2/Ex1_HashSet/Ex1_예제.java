package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1_예제 {
	public static void main(String[] args) {

		//1. set컬랙션의 HashSet 객체 선언
		Set<String> set = new HashSet<>();
		// set객체에 <String>객체 여러개 저장가능

		//2. set 객체에 String객체에 저장
		System.out.println("Set 상태  :  "+ set );
		set.add("Java");System.out.println("Set 상태  :  "+ set );
		set.add("JDBC");System.out.println("Set 상태  :  "+ set );
		set.add("JSP");System.out.println("Set 상태  :  "+ set );
		set.add("Java");System.out.println("Set 상태  :  "+ set );//중복발생
		set.add("Spring");System.out.println("Set 상태  :  "+ set );
		/*
		Set 상태  :  []
		Set 상태  :  [Java]
		Set 상태  :  [Java, JDBC]
		Set 상태  :  [Java, JSP, JDBC]
		Set 상태  :  [Java, JSP, JDBC] // JAVA 중복데이터라 저장안됨
		Set 상태  :  [Java, JSP, JDBC, Spring]

		 */

		//3. 데이터 갯수
		System.out.println("Set객체의 데이터 갯수  :  "+ set.size() );
		//Set객체의 데이터 갯수  :  4

		//4. set/list와 for문 과의 관계
			//1.for문 [list 인덱스사용해서 가능하지만. set은 인덱스가 없어 불가능]
			for(int i = 0 ; i< set.size(); i++) {}
			//2 향상된 for문 [list, set가능 - 인덱스를 사용하지 않기때문에]
			//for(반복변수 변수 : 컬렉션객체){}
			// 반복변수란: 컬렉션 객체의 차입 - 제네릭<String>
			for(String s: set) {System.out.println("For(){} set " + s);}
			/*
			 	For(){} set Java
				For(){} set JSP
				For(){} set JDBC
				For(){} set Spring
			 */
			//3. forEach()함수 를 이용한 ㄻ다식 표현 (화살표 함수 Java -> Js =>)
			set.forEach(s -> {System.out.println("forEach로 set "+ s);});
			/*
			 	forEach로 set Java
				forEach로 set JSP
				forEach로 set JDBC
				forEach로 set Spring
			 */

		//-------------------------------------------------------------------------------------//
		// 1. set 객체 선언
			Set <Member> set2 = new HashSet<>();

		// 2. set 객체에 멤버 객체 저장
			set2.add(new Member("홍길동", 30));
			set2.add(new Member("홍길동", 30)); //이름나이중복
			set2.add(new Member("강호동", 30)); //나이중복
			set2.add(new Member("홍길동", 40)); //이름중복
			set2.add(new Member("신동엽", 50)); //중복없음.

		//3.set 객체내 member객체수
			System.out.println("set객체내  member객체수  :" +set2 );
			/*
			 강호동", 30 / "홍길동", 30)			 */

		//4.iterator() 메소드 제공
				// set객체에서   iterator() 메소드 객체 얻기
			Iterator<Member> iterator  = set2.iterator();
				//iterator 객체를 이용한 반복
			while(iterator.hasNext()) { //rs.next()와 유사 다음 객체가 있으면 ㅅtrue없으면 false
				Member element = iterator.next(); // .next() : set객체(컬렉션) 내 객체 호출
				System.out.println( "element : "+element);
				if(element.name.equals("강호동")) { // 멤버 이름중 강호동과 일치하는 객체가 있으면
					iterator.remove(); //.remove() : set객체내 해당 객체 삭제
				}
			}

			System.out.println( "set 객체 내 member객체수 : "+ set2 );

			//5. iterator객체를 활용한 향상된 for문
			for(Member m : set2 ) {System.out.println( m );} //Good!!

			//forEach (iterator를 사용하는 컬렉션프레임
			set2.forEach( m ->{ System.out.println ( m );});
			//

	}

}
/*


 */