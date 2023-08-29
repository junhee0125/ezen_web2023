package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;

import java.util.TreeSet;
/*
  	Integer, String, Dpuble정렬기준이 명확함 ( 숫자, 문자 이므로)
  	사용자정의  클래스인 MemberDto(  여러개 필드) 정렬기준이 ?????명확하지 않을때?
  	compareTo메소드 : [Comparable 인터페이스로부터 구현] 이용한 정렬기준 만들기 
 */
public class Ex3_예제 {

	public static void main(String[] args) {
		
		//1.  Tree
		TreeSet<Person> treeSet = new TreeSet<>();
		
		//2. 무작위 person개체 대입
		treeSet.add( new  Person("홍길동", 45));
		treeSet.add( new  Person("김자바", 25));
		treeSet.add( new  Person("박지원", 31));
		treeSet.add( new  Person("유재석", 15));

		for(Person person :treeSet) {
			System.out.println("treeSet 출력 :  "+person.name +" / "+ person.age);
			/*  [console]
			 	treeSet 출력 :  유재석 / 15
				treeSet 출력 :  김자바 / 25
				treeSet 출력 :  박지원 / 31
				treeSet 출력 :  홍길동 / 45
			 * */
		}
		System.out.println( "이진트리 상태 " + treeSet );
		
		//이진트리 상태 [java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬.Person@7852e922, java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬.Person@4e25154f, java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬.Person@70dea4e, java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬.Person@5c647e05]

	}


}

