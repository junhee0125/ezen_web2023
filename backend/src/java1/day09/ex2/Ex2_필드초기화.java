package java1.day09.ex2;

public class Ex2_필드초기화 {
	public static void main(String[] args) {
		
		
		/* 1. 객체 생성
				1. 기본생성자 : 객체 생성시 초기화
		*/	
		Korean k = new Korean();
			System.out.println(k.nation);
			System.out.println(k.name);
			
		
			//2. 정의한 생성자 : 객체 생성시 해당 매개변수를 초기화한다.
		Korean k1 = new Korean("박자바","011211-1234567"); //순서., 타입 지켜야
			System.out.println(k1.nation);
			System.out.println(k1.name);
		
			
		
			//3. 정의한 생성자 2: 
		Korean k2 = new Korean("김자바", "930525-1238521");
			System.out.println(k2.nation);
			System.out.println(k2.name);
			
			
		 Korean k3= new Korean(null, null, null);
		//
	} //main e

}
