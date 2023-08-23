package java2.day24_제네릭.Ex4;

public class Ex4_제네릭 {

	public static <T> Box<T> boxing(T t){
	//public static <T> boolean boxing(T t){ 
		// 이렇게 스태틱 뒤의 T는 boxing 메소드 매개변수  T와 관계가 있는것임.
		//제네릭메소드 선언
			// 메소드 선언부 <제네릭타입> : 함수내에서도 제네릭타입 사용할 수 있다.
		Box<T> box = new Box<T>();
		box.setT(t);	//box 객체의 = 100
		return box;
	}
	
	//main 메소드
	public static void main(String[] args) {
		//1.Box 객체 t필드를  Integer타입으로 선정
		Box<Integer> box1 = boxing(100);
		int intValue = box1.getT();
		System.out.println("intValue : "+ intValue);
		
		
		Box<String> box2 = boxing("a hundred");
		String stringValue = box2.getT();
		System.out.println("stringValue : "+stringValue);
	}
	
}
