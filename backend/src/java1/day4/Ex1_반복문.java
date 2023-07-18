package java1.day4;

import java.util.Scanner;

public class Ex1_반복문 {
	public static void main(String[] args) {
		
		//[p.124]
		int sum = 0;
		sum = sum+1; sum+=2; sum+=3; sum+=4; sum+=5; sum+=6; sum+=7; sum+=9; sum+=10; 
		
		//1~10까지 누적합ㄴ계 (for 이용)
		int sum2 = 0;
		for (int i =1 ; i <=10; i++) {
			sum += i ;
		}
		
		//[p.125] 1부터 10까지 출력
		for(int i =1 ; i <=10 ; i++) {
			System.out.print(i+" ");
		}
		
		//[p.126]
		int sum3 = 0;
		for(int 반복변수 = 1 ; 반복변수 <=10; 반복변수 ++) {
			sum3 += 반복변수;
		}
		
		int sum4 = 0; int i;
		for(i =1 ; i <= 100; i++) { sum4 += i;	}
		System.out.println("1~"+(i-1)+ "합 : "+ sum4);
		
		
		//[p.127] // 실수 더블형도 초기값으로 가능
		for(float x = 0.1f ; x<=1.f ; x+=0.10f) { System.out.print(x); }		
		for(double x = 0.1 ; x<=1.0 ; x+=0.10) { System.out.print(x); }
		
		
		//[p.128]
		System.out.println("-------------------[p.128]------------------");
		for(int j = 2; j<=9 ; j++ ) {
			System.out.println("-----"+j+" 단-----");
			for(int k =1; k<=9 ; k++) {
				//System.out.println(j +" x "+k+" = "+j*k);
				System.out.printf("%2d X %2d = %2d \n", j , k , j*k);
			}
			
		}
		//[p.129]
		int a =1 ;
		while(a <=10) { System.out.println( a + "번째 출력");  a++;	}
		
		//[p.130] - 126p 비교
		int b=1;
		int sum5 = 0;
		while(b <=100) { sum5 +=b; b++;}
		System.out.println("1~100까지 더한 값의 결과 "+ sum5);
		//[p.131]
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		int speed = 0;
		
		while(run) {
			System.out.println("------------------------------------");
			System.out.println(" 1.  증속  |   2. 감소   |  3. 중지  ");
			System.out.println("------------------------------------");
			System.out.println("-선택 : ");
			
			String strNum = scanner.nextLine();
			
			
			if( strNum.equals("1")) {//만약 입력이 1이면
				speed++;
				System.out.println("현재 속도 : "+ speed);
				
				
			} else if( strNum.equals("2")) {//만약 입력이 2이면
				speed--;
				System.out.println("현재 속도 : "+ speed);
				
			} else if(strNum.equals("3")) {//만약 입력이 3이면
				speed = 0;
				run = false;
				/*
				 * 강제 종료하는 방법
				 * break 가장 가까운 반복문 종료 위치 1로
				 * return 현재 함수 강제 반환/종료 / main함수 밖으로 종료  System.out.println( "반복문 종료후 콛");실행x
				 * */
				System.out.println("정지");
			}
			
			
			
		} // while end
		//위치1
		System.out.println( "반복문 종료후 코드");
		
		
		//[p.135]
		/*
		 * 1. for 문에 식별이름 정의 : for이름 : for(){}
		 
			2. break 
				: 가장 가까운 반복문을 탈출, continue for이름
			2. break for이름 : 해당 for 탈출
			3. continue 
				: 해당 for반복문 증감식/조건식으로 이동
			3. continue for이름 : 해당 for반복문 증감식/조건식으로 이동
			
			공통점 break; continue아래 코드 실행 x
		*/ 
		대문자for :for(char upper='A' ; upper <='Z'; upper++) {
			
			System.out.print(upper+" ");
			
			소문자for:for(char lower='a' ; lower <='z'; lower++) {
				
				System.out.print("\t"+lower );
				/*
				 가장 가까운 반복문 탈출
				 if(lower == 'g') break;
				 
				 * */
				if(lower =='g') break 대문자for;
				
			} //A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
			
		} //A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
		
		//[p.137]
		for(int j =1 ; j <=10; j++) {
			
			if(j %2 !=0) { //홀수면
				
				continue; //스킵하고 포문으로 
			}
			System.out.println(j +" ");
		}
		//[p.124]
		//[p.124]
	}
}
/*
 	for
 		for(1.초기값 ; 2 조건식 ; 4 증감식){
 			3.실행문;
 		}
 	1. 초기값이 시행된다.
 	2. 조건식을 판단해서 true이면 {} 들어감 false {} 건너뜀. 종류
 	3. true면 실행문 실행
 	4. 초기값이 들어있는 변수에 증감식
 	5. 조건식 판단해서 234234 반복
 
 	while문
 		1.초기값
 		while(2.조건식){3.실행문 4증감식}
 		- 초기값과 증감식은 필수는 아님
 		- 조건식 판단해서 true이면  {} 들어감,  false{} 건너뜀 종료
 		- true이면 실행문 실행
 		
 		일반적으로 패턴이 있는 경우 for문 사용권장
 		
 		
 
 */