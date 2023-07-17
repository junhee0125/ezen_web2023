package 과제.과제2;
import java.util.Scanner;

public class 연산20문제 {
	
	public static void main(String[] args) {
		
		//------ 문제1 여기에 풀이-------//
		
		String dog = "\n|\\_/|\n"
			+ "|q p|   /}\r\n"
			+ "( 0 )\"\"\"\\\r\n"
			+ "|\"^\"`    |\r\n"
			+ "||_/=\\\\__|";		
				
		System.out.println(dog);
		
		//------ 문제2 여기에 풀이-------//
		//입력
		Scanner scanner = new Scanner(System.in); 
			int no = 1;
			System.out.println("작성자 : "); String writer = scanner.next();
			System.out.println("내용 : ");String contents = scanner.next();
			System.out.println("날짜 : ");String date = scanner.next();
			
			System.out.printf("--------------방문록--------------------\r\n");
			System.out.printf("|%4s|%5S|%12S|%4S|\n","순번 ","작성자 "," 내용      ","날짜 "	);			
			System.out.printf("|%5d|%5S|%10S|%4S|\n",no,writer, contents, date);

			
		//------ 문제3 여기에 풀이-------//
			//입력
			System.out.println(" 기본급 : "); int 기본급 = scanner.nextInt();
			System.out.println(" 수당 : "); int 수당 = scanner.nextInt();
			
			//계산
			long 수령액 = 기본급 + 수당 -  (long)(기본급*0.1);
			
			//출력
			System.out.println("실수령액 : "+수령액); 
		//------ 문제4 여기에 풀이-------//

			System.out.println("금액을 입력하세요 "); int cost = scanner.nextInt();
			int tm = cost/100000;
			int tt = cost/10000 - tm*10;
			int t = cost/1000-tm*100-tt*10;
			int h = cost/100 - tm*1000 - tt*100- t*10;
			
			System.out.println(" 십만원권 : "+ tm +"장" );
			System.out.println(" 만원권 : "+tt+"장");
			System.out.println(" 천원권: "+t+"장");
			System.out.println(" 백원: "+h+"장");
			
		
		//------ 문제5 여기에 풀이-------//
		System.out.println("-------------(문제 5)-------------");
		System.out.println(" 정수5를 입력하세요 "); int input = scanner.nextInt();
		System.out.println("문제 5 : 7의배수 여부");
		System.out.println(input%7 ==0? "O": "X");
		
		//------ 문제6 여기에 풀이-------//
		System.out.println("-------------(문제 6)-------------");
		System.out.println("문제 6 : 홀짝 여부");
		System.out.println(" 정수6를 입력하세요 "); int input6 = scanner.nextInt();
		System.out.println(input6%2 ==0? "O": "X");
		
		//------ 문제7 여기에 풀이-------//
		System.out.println("-------------(문제 7)-------------");
		System.out.println(" 정수7를 입력하세요 "); int input7 = scanner.nextInt();
		System.out.println("문제 7 : 7의 배수이면서 + 짝수 ?");
		System.out.println(input7%7 ==0 ? input7%2 == 0 ? "O": "X":"x");
		
		//------ 문제8 여기에 풀이-------//
		System.out.println("-------------(문제 8)-------------");
		System.out.println(" 정수8를 입력하세요 "); int input8 = scanner.nextInt();
		String result =(input8%7 == 0 && input8 %2 ==1)? "0" : "x";
		System.out.println("문제 8의 결과 : "+ result);
		
		//------ 문제9 여기에 풀이-------//
		System.out.println("-------------(문제 9)-------------");
		System.out.println(" 첫번째 수를 입력하세요 "); int input91 = scanner.nextInt();
		System.out.println(" 두번째 수를 입력하세요 "); int input92 = scanner.nextInt();
		int result9 =( input91 > input92)? input91 : input92;
		System.out.println("문제 9의 결과 : "+ result9);

		
		//------ 문제10 여기에 풀이-------//
		System.out.println("-------------(문제 10)-------------");
		System.out.println(" 반지름을 입력하세요 "); double input10 = scanner.nextDouble();
		double result10 = input10 * input10* 3.14;
		System.out.println("문제 10의 결과 : "+ result10);
		
		//------ 문제11 여기에 풀이-------//
		
		System.out.println("-------------(문제 11)-------------");
		System.out.println(" 첫번째 실수를 입력하세요 "); double input111 = scanner.nextDouble();
		System.out.println(" 두번째 실수를 입력하세요 "); double input112 = scanner.nextDouble();
		//double result11 = (input111 / input112)*100;
		System.out.printf("문제 11의 결과 : %.6f %% \n", (input111 / input112)*100.0);
		
		//------ 문제12 여기에 풀이-------//
		
		System.out.println("-------------(문제 12)-------------");
		System.out.println(" 윗변의 길이를 입력하세요 "); double input12_1 = scanner.nextDouble();
		System.out.println(" 아랫변의 길이를 입력하세요 "); double input12_2 = scanner.nextDouble();
		System.out.println(" 높이 입력하세요 "); double input12_3 = scanner.nextDouble();
		double result12 = (input12_1 +  input12_2) * input12_3 / 2;
		System.out.println("문제 12의 결과(사다리꼴 넓이 : "+ result12);

		//------ 문제13 여기에 풀이-------//
		System.out.println("-------------(문제 13)-------------");
		System.out.println(" 키를 입력하세요 "); double input13 = scanner.nextDouble();
		System.out.println("문제 13의 결과(표준체중 : "+ (input13-100) *0.9);
		
	
		//------ 문제14 여기에 풀이-------//
		System.out.println("-------------(문제 14)-------------");
		System.out.println(" 키를 입력하세요 "); double input14_1= scanner.nextDouble();
		System.out.println(" 몸무게를 입력하세요 "); double input14_2 = scanner.nextDouble();
		System.out.println("문제 13의 결과(BMI : "+ input14_2/((input14_1/100) *(input14_1/100)));

		
		//------ 문제15 여기에 풀이-------//
		System.out.println("-------------(문제 15)-------------");
		System.out.println(" cm로 변환할 길이를 입력하세요 "); double input15 = scanner.nextDouble();
		System.out.println("문제 15의 결과(cm <-Inch : "+ input15 *2.54 +"cm");

		
		//------ 문제16 여기에 풀이-------//
		System.out.println("-------------(문제 16)-------------");
		System.out.println(" 중간고사 점수를 입력하세요 "); double input16_1 = scanner.nextDouble();
		System.out.println(" 기말고사 점수를 입력하세요 "); double input16_2 = scanner.nextDouble();
		System.out.println(" 수행평가 점수를 입력하세요 "); double input16_3 = scanner.nextDouble();
		System.out.println("문제 16의 결과(비율반영후 점수) : "+ (input16_1*0.3 + input16_2*0.3 + input16_3*0.4) );
		
		
		//------ 문제17 여기에 풀이-------//
		System.out.println("-------------(문제 17)-------------");
		int x = 10;
		int y = x-- + 5 + --x; //10+ 5 - 8
		System.out.printf(" x의 값 : %d , y의값 :  %d \n ", x, y);
		
		//------ 문제18 여기에 풀이-------//
		System.out.println("-------------(문제 18)-------------");
		System.out.println(" 나이를 입력하세요 "); int input18 = scanner.nextInt();
		String result18 = input18 >= 10 && input18 < 20  ? "학생" : input18 >=20  && input18 < 40 ? "성인" : input18 >=40 ? "중년" : "other";
		System.out.println("문제 18의 결과 : "+ result18);
				
		
		//------ 문제19 여기에 풀이-------//
		System.out.println("-------------(문제 19)-------------");
		System.out.println(" 국어점수를 입력하세요 "); double input19_1 = scanner.nextDouble();
		System.out.println(" 영어점수를 입력하세요 "); double input19_2 = scanner.nextDouble();
		System.out.println(" 수학점수를 입력하세요 "); double input19_3 = scanner.nextDouble();
		double total = input19_1 + input19_2 + input19_3;
		System.out.printf("문제 18의 결과  총점 : %.1f \n", total );
		System.out.printf("문제 18의 결과  평균 : %.2f \n", total/3 );

		
		
		
		
		//------ 문제20 여기에 풀이-------//
		System.out.println("-------------(문제 20)-------------");
		System.out.println(" 아이디를 입력하세요 "); String id = scanner.next();
		System.out.println(" 비밀번호를 입력하세요 "); String pwd = scanner.next();
		System.out.println( id.equals("admin") && pwd.equals("1234") ? "로그인 성공" : "로그인 실패");

		
		
		
		//------ 문제21 여기에 풀이-------//
		System.out.println("-------------(문제 21)-------------");
		System.out.println(" 첫번째 수를 입력하세요 "); int a = scanner.nextInt();
		System.out.println(" 두번째 수를 입력하세요 "); int b = scanner.nextInt();
		System.out.println(" 세번째 수를 입력하세요 "); int c = scanner.nextInt();
		int max = a;
		max = (max < b) ? b  : max;
		max = (max < c) ? c : max;
		System.out.println("문제 21번 풀이 결과 : 세 수중 가장 큰수는 :  "+ max);
		
		
	}

}


/*

문제1 : 강아지 console 출력
	|\_/|
	|q p|   /}
	( 0 )"""\
	|"^"`    |
	||_/=\\__|

문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
