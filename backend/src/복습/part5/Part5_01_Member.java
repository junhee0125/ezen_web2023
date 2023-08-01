package 복습.part5;

public class Part5_01_Member {
	//필드
	//아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장
	String id;
	String pw;
	String name;
	String phone;
	int age;
	
	
	//생성자
	
	public Part5_01_Member() {	}
	
	public Part5_01_Member(String id, String pw, String name, String phone, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	
	
	//메서드
	
	@Override
	public String toString() {
		return "Part5_01_Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age
				+ "]";
	}
	
}
