package java2.day27_컬렉션프레임워크2.Ex1_HashSet;

public class Member {
	//필드

	public String name;
	public int age;


	//

	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
//----------------------해당 객체의 중복 기준만들기-------------------------//
	//Object의 메소드 재정의
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//자바 버전 javaSE-8이상
		if(obj instanceof Member) {
			Member target = (Member)obj;// 강제형변환
			//해당 객체의 이름과 나이가 일치하면 true (중복)
			return target.name.equals(name) && (target.age == age );
		} else {
			return false;
		}
	}
//----------------------------------------------------------------------------------//
}
