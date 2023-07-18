package 과제.과제3.Level2;
import java.util.Scanner;

public class If문제7문제 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		/* -------문제1----- */
		System.out.println( "------------ 문제 1 ------------"); 
		System.out.println("정수1을 입력하세요"); int a1 = in.nextInt();
		System.out.println("정수2을 입력하세요"); int a2 = in.nextInt();
		
		if (a1 > a2 ) System.out.println( "더 큰수는 "+ a1); 
		else if(a1 < a2)  System.out.println( "더 큰수는 "+ a2); 
		else System.out.println("두수의 크기는 같다.");
		
		
		/* -------문제2----- */
		System.out.println( "------------ 문제 2 ------------");
		System.out.println("정수1을 입력하세요"); int b1 = in.nextInt();
		System.out.println("정수2을 입력하세요"); int b2 = in.nextInt();
		System.out.println("정수3을 입력하세요"); int b3 = in.nextInt(); 
		int max = b1;
		
		
		if(max < b2 ) { max = b2;}
		if(max < b3) { 	max = b3;}
		System.out.println("세 수중 가장 큰 수는 " + max);
		
		
		/* -------문제3----- */
		 System.out.println( "------------ 문제 3 ------------");
		 System.out.println("정수1을 입력하세요"); int c1 = in.nextInt();
		 System.out.println("정수2을 입력하세요"); int c2 = in.nextInt();
		 System.out.println("정수3을 입력하세요"); int c3 = in.nextInt(); 
		 System.out.println("오름차순 정렬은 > / 내림차순 정렬은 < 입력해주세요 "); char orderby  =  in.next().charAt(0);
//		 int max3 = c1;
//		 int min = c1;
//		 int mid;
		 int tmp ;
		 // > 오름차순
		 
		 if (orderby == '>') {
			 if(c1 > c2) { tmp = c1; c1 = c2; c2 = tmp;}
			 if(c1 > c3) { tmp = c1; c1 = c3; c3 = tmp;}
			 if(c2 > c3) { tmp = c2; c2 = c3; c3 = tmp;}
			 
			 System.out.printf("문제3 : %3d %3d %3d \n", c1,  c2, c3 );
		 } else if(orderby == '<') {
			 if(c1 < c2) { tmp = c1; c1 = c2; c2 = tmp;}
			 if(c1 < c3) { tmp = c1; c1 = c3; c3 = tmp;}
			 if(c2 < c3) { tmp = c2; c2 = c3; c3 = tmp;}
			 
			 System.out.printf("문제3 : %3d %3d %3d \n", c1,  c2, c3 );
		 } else {
			 System.out.println( "잘못된 값을 입력하셨습니다.");
		 }
			 
			 //max 
		 
//		 if(max3 < c2 ) {
//				max3 = c2;
//				if(max3 < c3) { 	max3 = c3; 	}
//			} else if(max3 < c3) { max3 = c3;	}
//		 
//		 
//		 //min
//		 if(min > c2 ) {
//			 min = c2;
//				if(min > c3) { 	min = c3; 	}
//		} else if(min > c3) { min = c3;	}
//		 
//		 //mid
//		if(max3 == c1) {
//			if( min == c2) { mid = c3;} 
//			else { mid = c2; }
//		} else if (max3 == c2) {
//			if (min ==c1) {mid = c3;}
//			else { mid = c1;}
//		} else {
//			if(min == c1 ){ mid = c2; }
//			else {mid = c1;}
//		}
//		  
//		 if(orderby == '<') { //				
//			System.out.println("오름차순 정렬  :" + min +" "+ mid+" "+max3 );
//			
//			
//		 } else if (orderby == '>' ) {
//			 System.out.println("내림차순 정렬  :" + max3 +" "+ mid+" "+min );
//			 
//		 } else {
//			 System.out.println( "잘못입력하셨습니다.");
//		 }
//		 
//		 
	
		 
		/* -------문제4----- */
		 System.out.println( "------------ 문제 4 ------------");
		int score = in.nextInt();
		if(score >=90) {
			System.out.println("합격");
		} else {
			System.out.println("탈락");
		}
		
		
		/* -------문제5----- */
		 System.out.println( "------------ 문제 5 ------------");
		 int score5 = in.nextInt();
		 if(score5 >=90) {
				System.out.println("A등급");
			} else if(score5 >=80) {
				System.out.println("B등급");
			} else if(score5 >=70) {
				System.out.println("C등급");
			} else {
				System.out.println("재시험");
			}
			
		/* -------문제6----- */
		 System.out.println( "------------ 문제 6 ------------");
		 System.out.println("국어점수 : "); int kor = in.nextInt();
		 System.out.println("영어점수 : "); int eng = in.nextInt();
		 System.out.println("수학점수 : "); int mat = in.nextInt();
		 
		 double avg = (kor + eng + mat )/3.0;
		 
		 if(avg >=90 ) {
			 if (kor ==100) System.out.println("국어 우수");
			 if (eng == 100) System.out.println("영어 우수");
			 if (mat == 100) System.out.println("수학 우수");
			 
		 }else if (avg >=80){
			 if (kor >=90) System.out.println("국어 장려");
			 if (eng >=90) System.out.println("영어 장려");
			 if (mat >=90) System.out.println("수학 장려");
		 } else {
			 System.out.println("재시험");
		 }
		 
		 
		/* -------문제7----- */
		 System.out.println( "------------ 문제 7 ------------");
		 System.out.println("아이디를 입력하세요 : ");String id = in.next();
		 System.out.println("비밀번호를 입력하세요 : ");String pwd = in.next();
		 
//		 if(id.equals("admin")&& pwd.equals("1234")){ System.out.println("로그인성공");}
//		 else{ System.out.println("로그인실패"); }
		 
		 if( id.equals("admin")) {
			 if(pwd.equals("1234")) {
				 System.out.println("로그인성공");
			 }else {
				 System.out.println("[로그인실패] 패스워드가 일치하지 않습니다.");
			 }
			 
		 } else { 
			 System.out.println("[로그인 실패] 존재하지 않는 아이디입니다.");
		 }
		 
	}
	
}

/*
 	 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
 	 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
 	 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
 	 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
 	
 	 문제5 : 
			// 점수를 입력받아 점수가 90점 이상이면 A등급
			//				점수가 80점 이상이면 B등급
			//				점수가 70점 이상이면 C등급
			//				그외 재시험
	
	
 	 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점이상 이면 '국어장려' 출력
					영어점수 90점이상 이면 '영어정려' 출력
					수학점수 90점이상 이면 '수학장려' 출력
				그외 재시험 
		 
	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
 */
