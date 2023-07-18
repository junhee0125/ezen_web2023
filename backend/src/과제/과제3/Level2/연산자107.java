package 과제.과제3.Level2;

public class 연산자107 {
	public static void main(String[] args) {
		System.out.println("---------------------( 문제 1 )----------------------");
		int x = 10;
		int y = 20;
		int z = ++x + y-- ;  //11 + 20
		System.out.println("z  : "+ z);
		
		
		System.out.println("---------------------( 문제 2 )----------------------");
		int score = 85;
		String result = (!(score > 90))? "가" :"나" ;
		
		System.out.println("result : "+ result );
		
		
		System.out.println("---------------------( 문제 3 )----------------------");
		int pencils = 534;
		int students = 30;
		
		//학생 한 명이 가지는 연필수 
		int pencilsPerStudent = pencils/students;
		System.err.println("pencilsPerStudent : " + pencilsPerStudent);
		
		//남은 연필수 
		int pencilsLeft = pencils % students;
		System.out.println("pencilsLeft : "+ pencilsLeft);
		
		System.out.println("---------------------( 문제 4 )----------------------");
		int  value = 365;
		System.out.println();
		
		
		System.out.println("---------------------( 문제 5 )----------------------");
		int lengthTop= 5;
		int lengthBottom = 10;
		int height =7;
		double area = (lengthTop + lengthBottom) * height * 1.0/2;
		
		System.out.println("---------------------( 문제 6 )----------------------");
		
		int x1 = 10;
		int y1 = 5;
		System.out.println((x>7) && (y<=5));
		System.out.println((x%3==2)||(y%2 !=1));
		
		
		System.out.println("---------------------( 문제 7 )----------------------");
		double x3 = 5.0;
		double y3 = 0.0 ;
		double z3 = 5 % y;
		
		if( y3 == 0.0) {
			System.out.println("0.0으로 나눌 수 없습니다.");
		} else {
			double result1 = z3 + 10;
			System.err.println("결과 :" + result1);
		}
	}
}
