package java1.day11.EX5디자인패턴2.model.dto;

public class MemberDto {
	
	//필드 : 객체의 데이터를 저장하는 곳
	 private String id; 
	 private String pw;
	 private String name;
	 private String phone;
	 private int age;
	
	 
	//생성자 
	//1.빈생성자 
	public MemberDto() { super();	}

	//2.풀생성자
	public MemberDto(String id,String pw, String name, String phone, int age){
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.age = age;
	}
	

	//메소드 : 객체의 행동을 담당 역할 - 인스턴스 vs 정적멤버
	// 1. toString : 객체 호출시 객체의 주소가 아닌 필드의 값을 반환해주는 함수 [개발자의 검사용]
		
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
	// 2. setter or getter


	public String getId() { 
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


}
