package 복습.part5;

public class Member {

	//필드
	
	String id;
	String pw;
	String name;
	String phone;
	int age;
	
	
	//생성자
	
	public Member() { 	}
	
	public Member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
	//메소드
	
}
