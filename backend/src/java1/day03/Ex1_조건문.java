package java1.day03;

import java.util.Random;

public class Ex1_조건문 {
	public static void main(String[] args) {
		
		//1. [p.111]
		int score = 93;
		//1
		if(score >= 90) System.out.println("합격1");
		
		//2
		if(score >= 90) 
			System.out.println("2점수가 90점 보다 큽니다.");
			System.out.println("등급은  A등급입니다.");
			
		//3
		if(score < 90) 
			System.out.println("2점수가 90점 보다 작습니다..");
			System.out.println("등급은  B등급입니다.");
		
		//2. [p.113]
		if(score >= 90) {
			System.out.println("3점수가 90점 보다 큽니다.");
			System.out.println("등급은  A등급입니다.");
		} else {			
			System.out.println("3점수가 90점 보다 작습니다..");
			System.out.println("등급은  B등급입니다.");
		}
		
		//3. [p.114]
		if(score >= 90) {
			System.out.println("4점수가100점~90점입니다..");
			System.out.println("등급은  A등급입니다.");
		} else if(score >= 80) {
			System.out.println("4점수가80점~89점입니다..");
			System.out.println("등급은  B등급입니다.");
		} else if(score >= 70) {
			System.out.println("4점수가 70점~79점입니다..");
			System.out.println("등급은  c등급입니다.");
		} else {
			System.out.println("4점수가 70미만 입니다.");
			System.out.println("등급은  d등급입니다.");
		}
		
		//4. [p.114]
		if(score >= 90) {
			System.out.println("4점수가100점~90점입니다..");
			System.out.println("등급은  A등급입니다.");
		} if(score >= 80) {
			System.out.println("4점수가80점~89점입니다..");
			System.out.println("등급은  B등급입니다.");
		} if(score >= 70) {
			System.out.println("4점수가 70점~79점입니다..");
			System.out.println("등급은  c등급입니다.");
		} if(score < 70)  {
			System.out.println("4점수가 70미만 입니다.");
			System.out.println("등급은  d등급입니다.");
		}
		
 		//[p.115] 난수
		System.out.println(Math.random()); // 0.0 <= 난수 < 1.0
		System.out.println(Math.random()*6); // 0.0~ <6.0
		System.out.println((int)(Math.random()*6));
		System.out.println((int)(Math.random()*6)+1);
		/*
		 * 정수 난수 공식 : (int)( Math.random()* n) +s '
		 * s: 시작하는 번호  . n은 갯수
		 * */
		System.out.println((int)(Math.random()*45)+1);
		
		/*
		 난수 생성 클래스  Random클래스
		 	1 . Random 객체 생성한다.
		 	 	Random random = new Random();
		 	2. 랜덤 값 호출
		 		random.next타입명 //형변환을 해줌
		 
		 */
		Random random = new Random();
		System.out.println(random.nextInt()); //-21억~ +21억
		System.out.println(random.nextInt(3)); //0~2 
		//random.nextInt(갯수) + 시작번호;
		System.out.println(random.nextInt(6)+1); //1번부터 시작 6개
		System.out.println(random.nextInt(45)+1); //1번부터 시작하고 45개 
		//int num = (int)(Math.random()*6)+1; //1~6
		int num2 = random.nextInt(6)+1; 
		
		
		int num = (int)(Math.random()*6)+1; //1~6
		if(num ==1) {System.out.println("1 나왔습니다.");}
		else if(num ==2) {System.out.println("2 나왔습니다.");}
		else if(num ==3) {System.out.println("3 나왔습니다.");}
		else if(num ==4) {System.out.println("4 나왔습니다.");}
		else if(num ==5) {System.out.println("5 나왔습니다.");}
		else  {System.out.println("6 나왔습니다.");}
		
		
		if(num2 ==1) {System.out.println("1 나왔습니다.");}
		else if(num2 ==2) {System.out.println("2 나왔습니다.");}
		else if(num2 ==3) {System.out.println("3 나왔습니다.");}
		else if(num2 ==4) {System.out.println("4 나왔습니다.");}
		else if(num2==5) {System.out.println("5 나왔습니다.");}
		else  {System.out.println("6 나왔습니다.");}
		
		//[p.119]
		System.out.println("--------------switch--------------.");
		switch(num) {
			case 1:
				System.out.println("1 나왔습니다.");
				break;
			case 2:
				System.out.println("2 나왔습니다.");
				break;
			case 3:
				System.out.println("3 나왔습니다.");
				break;
			case 4:
				System.out.println("4 나왔습니다.");
				break;
			case 5:
				System.out.println("5 나왔습니다.");
				break;
			default:
				System.out.println("6 나왔습니다.");
				//break; 생략
		
		
		}
		
		
		//[p.117]
		int score3 = (int)(Math.random()*20)+81; //81~100까지의 난수생성
		
		System.out.println("점수 : "+score3);
		
		String grade;
		if(score >=90 ) {
			
			if(score3 >=95) { grade = "A+"; }
			else { grade ="A"; }
			
		} else {
			
			if(score3 >=85) { grade = "B+"; }
			else { grade ="B"; }
		
		}
		System.out.println("grade : " + grade);
		
		//[p.121]
		char grade2 = 'B';
		
		switch(grade2) {
		case 'A':
		case 'a':
			System.out.println("우수회원입니다.");
			break;
		case 'B':
		case 'b':
			System.out.println("일반회원입니다.");
			break;
		default:
			System.out.println("손님입니다.");
		
		}
		
	}
}
/*
 * if : 만약에 조건이 충족하면 true / 충족하지 않으면 false ( 조건에 따른 흐름을 제어하기 위함)
 * 
 * 		형태 
 * 			1. if( 조건식 ) 실행문;
 * 			2. if( 조건식 ) { 실행문1;  실행문2; }
 * 			3. if( 조건식 ) { 참일경우 실행문 }
 * 			   else { 거짓일경우 실행문 }
 * 			4.	if(조건식1 ){ 	조건식1에 대해 참일경우 실행문1 }
 * 			 	else if(조건식2 ){ 	조건식2에 대해 참일경우 실행문2 }
 * 				else  if(조건식3 ){ 	조건식3에 대해 참일경우 실행문3 }
 * 				else {조건식 3에 대해서도 거짓일경우 실행문}
 * 			4.	if(조건식1 ){ 조건식1에 대해 참일경우 실행문1 }
 * 			  	if(조건식1 ){ 조건식1에 대해 참일경우 실행문1 }
 * 				if(조건식1 ){ 조건식1에 대해 참일경우 실행문1 }
 * 				if(조건식1 ){ 조건식1에 대해 참일경우 실행문1 }
 * 			
 * 			5. if(조건식 ) {
 * 				if(조건1-1){
 * 
 * 				}
 * 			} else if(조건2){
 * 
 * 			}
 * */

/*
 	switch(변수) {
 		case 값1 :
 			실행문1
 			break;
 		case 값2 :
 			실행문2
 			break;
 		case 값3 :
 			실행문3
 			break;
 		default:
 	}
 	
 	if = 조건에 따르 ㄴ true/false 실행 / 범위 논리가 필요한경우
 	switch = 변수 값에 따른 실행 
 		- 경우의 수에 따라 값이 정해진 경우.
 		- 비교연산 불가 / 범위논리 불가
 		- break : switch문 탈출
 
 
 */
 