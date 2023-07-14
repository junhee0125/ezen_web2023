package java1.day02;//현재 클래스의 패키지 경로

public class Ex2_연산자 { //class s
	
	public static void main(String[] args) {
		
		//[p.78] 연산자 
		int x = 10; 		
		int y = -10;
		
		System.out.println("x : "+ x );
		System.out.println("y : "+ y );
		
		//1. 산술연산자 [81]  연산후 반환 => 기본자료형 데이터
		System.out.println("x + y  = " + (x+y) );	// 더하기
		System.out.println("x - y  = " + (x-y) );	//빼기
		System.out.println("x * y  = " + (x*y) );	//곱하기
		System.out.println("x / 3  = " + (x/3) );	//나누기의 몫
		System.out.println("x / 3  = " + (x/3.0) );	//나누기의 몫

		System.out.println("x % 3  = " + (x%3) );	//나누기 후 나머지

		//2. 비교연산지 [p.88] : 연산후 반화 : boolean
		System.out.println("x == y  : " + (x == y) ); //==같다 (=== x
		System.out.println("x != y  : " + (x != y) ); //같지 않다.
		System.out.println("x > y  : " + (x > y ) ); //x는 y보다 크다
		System.out.println("x < y  : " + (x < y) );
		System.out.println("x >= y  : " + (x >= y) ); //x는 y보다 크거나 같다.
		System.out.println("x <= y  : " + (x <= y) ); //x는 y보다 작거나 같다.
		
		//if(true)  if(x==y)
		
		//3. 논리(관계)연산자 [p/91] : 연산후 반환 : boolean
		System.out.println("x >10 && y >=10  : " + (x >=10 && y >=10 ) ); //교집합, 논리곱
		System.out.println("x >10 || y >=10  : " + (x >=10 || y >=10 ) ); //합집합, 논리합
		System.out.println("부정 : " + (!true ) ); //교집합, 논리곱
		
		//4. 대입연산자[p.102]
		int a = 30; //대입연산자: 오른쪽데이를 왼쪽에 대입.저장
		a += x;
		System.out.println("a += x  : " + (a ) ); //교집합, 논리곱

		//5.삼항연산자 [p.103]
		//조건 ? 참: 거짓
		//조건? 조건 ? 참: 거짓 : 거짓
		//조건 ? 참: 조건 ? 참: 거짓
		String result= (x >= 20)? "합격" : "불합격";
		System.out.println("result  : " + result ); 

		String result2 = (x >= 10)? "1차합격" : (y >= 10)? "2차합격" : "최종탈락";
		System.out.println("result2  : " + result2 );
		
		
		
		//6. 증감연산자
		System.out.println("++x : "+  (++x) ); // 해당 명령어에서 1증가 최우선 [출력보다]
		System.out.println("x++ : "+  (x++));
		System.out.println("x : " +  x );// 해당 명령어에서 1증가 최우선 [출력보다]

		System.out.println("x-- : "+  (x--) ); // 해당 명령어에서 1증가 최우선 [출력보다]
		System.out.println("x-- : "+  (x--));
		System.out.println("x : " +  x );// 해당 명령어에서 1증가 최우선 [출력보다]
		
		//7. 연결연산자
		System.out.println(" 3+3  : "+  (3+3));
		System.out.println(" 연결 :  +3 +3  ==> "+  ( "연결 :"  +3 +3 ));

	}
} //class e
