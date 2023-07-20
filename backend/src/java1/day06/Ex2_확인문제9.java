package java1.day06;

import java.util.Scanner;

public class Ex2_확인문제9 {
	public static void main(String[] args) {
		/*
		 1. 학생의 수를 입력받는다. /변수/ 학생수를 길이값으로 갖는 배열선언
		 2. 학생의 수만큼 점수를 입력받는다. 
		  	점수를 배열에 담는다. //학생의 수만큼 반복해서 받고. 입력받은 순서대로 배열에 대입한다.
		 3. 선언된 배열의 데이터를 출력한다.
		 4. 배열의 길이만큼 반복하며 최고점수를 구한다. /  반복문이 돌때  합계를 함께 구한다.
		 	평균점수를 구한다. /소숫점은 2자리로/
		 	점수와 평균점수를 출력하고
		 5. while문을 종료한다.		 \
		 
		 nextLine() 사용시 주의점
		 	- nextLine사용시 다른  next~~() 앞 뒤에 존재했을때 하나로 인식
		 	해결방법
		 		1. nextLine() 만 사용하고  필요한경우 형변화해서 쓴다.
		 		2. nextLine과  next~~() 사이에 scanner.nextLine();을 추가한다. (의미없는 넥스트라인)
		
		 		https://itbeginner2020.tistory.com/23
		 
		 */
		
		
		int student = 0;
		int[] scoreArray  = null;
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.학생수 | 2. 점수입력 | 3.점수리스트 | 4.분석 | 5.종료"  );
			System.out.println("------------------------------------------------------");
			
			System.out.println("기능의 번호를 입력하세요"); String ch = in.nextLine();
			
			
			if(ch.equals("1") ) {
				System.out.println("학생수를 입력하세요"); student = Integer.parseInt(in.nextLine());
				scoreArray = new int[student];
					
			} else if(ch.equals("2")) {
				
				
				
				for(int i = 0; i < student; i ++) {
				
					System.out.println("점수를 입력하세요"); int score = Integer.parseInt(in.nextLine());
				
					scoreArray[i] = score;
				
				}
				
			} else if(ch.equals("3")) {
				
				System.out.println("점수 리스트를 출력합니다.");
				
				if(scoreArray.length != 0) {
					
					System.out.print("총학생수 : "+ student +"\t| 점수 List : ");
					
					for(int i =0 ; i < scoreArray.length; i++) {
						
						System.out.print("  "+scoreArray[i]+" ");
					}
					
					System.out.println("\n");
					
				}  else {
					
					System.out.println("학생수  또는 점수의 데이터가 입력되지 않았습니다.");					
				}
				
			} else if(ch.equals("4")) {
			
				if(scoreArray.length != 0) {
					
					int max = 0;
					
					int sum = 0;
					
					for(int i =0 ; i < scoreArray.length; i++) {
						
						if (max < scoreArray[i]) max = scoreArray[i];
						
						sum += scoreArray[i];
						
					}
					
					System.out.println("최고점수 : "+ max );					
					System.out.printf("평균점수 : %.1f \n", sum/(double)student);
					
				} else {
					
					System.out.println("학생수  또는 점수의 데이터가 입력되지 않았습니다.");					
				}
				
				
			} else if(ch.equals("5")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
			//1번을 
			
		}
		
	}
}
