package java2.day25_제네릭2.Ex1;

public class Ex1_제한된타입파라미터 {
	//모든 타입을 허용할 수도 있지만.
	//특정 타입을 제한할 수도 있다.
		//<T extends Number> Number클래스를 포함하고, Number자손 클래스의 객체만 허용하겠다는 뜻!!
	public  static <T extends Number> boolean compare(T t1, T t2) {
		System.out.println(t1.getClass().getSimpleName());
		System.out.println(t2.getClass().getSimpleName());
		
		double v1 = t1.doubleValue();
		System.out.println("v1  :  "+v1);
		double v2 = t2.doubleValue();
		System.out.println("v2  :  "+v2);
		return (v1==v2);

		
	}
	public static void main(String[] args) {
		//제네릭 메소드 사용
		boolean result1= compare(10,20);
		System.out.println("result1 : "+result1);
		
		boolean result2 = compare(4.5, 4.5);
		System.out.println("result2 : "+result2);
		
		//String result3 = compare("안녕","하세요"); //오류
		//The method compare(T, T) in the type Ex1_제한된타입파라미터 is not applicable 
		// for the arguments (String, String)

		Integer i = 3; // Integer는 Number클래스의 자손
		Double d = 3.0;  // Double는 Number클래스의 자손
		String s = "assa";  // String는 Number클래스의 자손 아니다!
		
	}
}


