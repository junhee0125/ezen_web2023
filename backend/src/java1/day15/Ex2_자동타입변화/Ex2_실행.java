package java1.day15.Ex2_자동타입변화;

public class Ex2_실행 {
	
	public static void main(String[] args) {
		
		//1. 부모객체 생성
		Parent parent =new Parent();  // 힙 : parent 객체 1
		
		//2. 자식객체생성
		Child child = new Child(); 		// 힙 parent 객채1,  Child객체 1
		
		//3 자식객체를 보모객체에 대입
		Parent parent2 = child; //부모객체에 자식 객체를 대입해서.. parent2는 child객체가 되었기 때문에
		parent2.method1();	//child 클래스의 method1이 호출됨
		parent2.method2();
		// parent2.method3();The method method3() is undefined for the type Parent
		
		
		
		//4.부모객체를 자식객체에 대입???
		//Child child2 = parent; 		//불가능 Type mismatch: cannot convert from Parent to Child
		
	//!!(강제타입) 캐스팅
//		Parent parent3 = new Parent(); //안됨
		Parent parent4 = new Child(); 
		Child child2 = (Child)parent4;
		child2.method1();
		child2.method2();
		child2.method3();
	}
	
	
		
}
