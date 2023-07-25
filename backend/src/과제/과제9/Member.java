package 과제.과제9;
//목적 : 설계도 객체의 모델
public class Member {
	

	//필드
	String id;
	String pwd;
	String name;
	String phone;
	int age;		
	

	public Member(String id, String pwd, int age) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.age = age;
	}
	//생성자
		//기본생성자가 자동으로 생성됨..
	public Member() {} //1. 매개변수 0개 생성자
	
	public Member(String id, String pwd, String name, String phone, int age ) {
		this.id = id;		
		this.pwd = pwd;  	
		this.name= name; 	
		this.phone = phone; 	
		this.age = age;
		
		
	} 	
	
	//1. 매개변수 5개 정의한 생성자
	public Member(String id, String pwd, String name, String phone) { } 			//2. 매개변수 4개 정의한 생성자
	public Member(String id, String pwd, String name) { }							//3. 매개변수 3개 정의한 생성자
	public Member(String id, String pwd) { } 										//4. 매개변수 2개 정의한 생성자
	public Member(String id) {}														//5. 매개변수 1개 정의한 생성자
	public Member(int age) {}														//6. 매개변수 1개 정의한 생성자
	//메소드
	
	
}


/*
 
 회원 : 				
	번호
	아이디
	비번
	이름
	
게시물 : 번호 / 제목 / 내용 / 작성자 /  보드no

	보드no / 보드명 / 보드타입
	
	 보드no / no / 작성자 /  
  
  
  
 */
 */