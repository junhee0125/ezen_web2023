package java1.day08.Ex3;
// 현클래스의 사용목적
public class Ex3_예제 {
	//실행 목적의 클래스 이므로 클래스 멤버 (필드, 생성자, 메소드)구성 생략가능
	public static void main(String[] args) {
		// 1. 객체의 선언 : 클래스 변수명 = new  생성자명 (); 
			// * 만약에 생성자를 정의하지 않았으면 기본생성자();
		Car mycar = new Car(); 
			//mycar :  그메모리주소를 갖고 있는 지역변수
			// new  : 힙영역에 객체를 만들고 힙주소를 지역변수에게 반환
			//Car()생성자명 = 클래스명 동일하고 생성자는 1개도 선언하지 않았으면 기본생성자

		
		// 2. 객체의 필드호출
			// . 도트연산자 : 객체변수
		System.out.println("모 델 명 : "+mycar.model);  // 모 델 명 : null
		System.out.println("시동여부 : "+ mycar.start); //시동여부 : false
		System.out.println("현재속도 : " +mycar.speed); //현재속도 : 0
		/*


		 */
	}
}
