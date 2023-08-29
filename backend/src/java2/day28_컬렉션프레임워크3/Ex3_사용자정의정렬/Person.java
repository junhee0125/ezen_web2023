package java2.day28_컬렉션프레임워크3.Ex3_사용자정의정렬;
/*
  Comparable 인터페이스
  	1. Comparable implement받고
  	2. compareTo 메소드 구현

 * */
public class Person implements Comparable<Person> {

	//필드 673
	public String name;
	public int age;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	/* 나이기준으로 오름차순정렬
	 * 반환을  1 0 -1로 바꿔주면 내림차순으로 정렬됨
	 * */
	@Override
	public int compareTo(Person o) {
		if(age < o.age )return -1;
		else if(age == o.age) return 0;
		else return 1;

	}


}
