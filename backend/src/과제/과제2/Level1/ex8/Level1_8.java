package 과제.과제2.Level1.ex8;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1_8 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level1_8 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		String header = "\n============방문록===============\n번호\t 작성자 \t 방문록\n";
		String boardlist = "";
		String footer = "================================\n";
		String output = "";
		
		/* 문제풀이 위치 */
		//첫번째 방문록
		int no = 1;
		String writer01 = scanner.nextLine();
		String contents01 = scanner.nextLine();
		
		//System.out.println(writer01);
		//System.out.println(contents01);
		
		boardlist =" "+ no+"\t "+writer01+"\t "+ contents01 +"\n";
		output = header + boardlist+footer;
		System.out.println(output);
		
		//두번째 방문록
		no++;
		String writer02 = scanner.nextLine();
		String contents02 = scanner.nextLine();
		String boardlist02 =" "+ no+"\t "+writer02+"\t "+ contents02 +"\n";
		
		output = header + boardlist +boardlist02 +footer;
		
		System.out.println(output);
		
		//세번째 방문록
		no++;
		String writer03 = scanner.nextLine();
		String contents03 = scanner.nextLine();
		String boardlist03 =" "+ no+"\t "+writer03+"\t "+ contents03 +"\n";
		
		output = header + boardlist +boardlist02 + boardlist03 +footer;
		
		System.out.println(output);	
		
		//네번째 방문록
		no++;
		String writer04 = scanner.nextLine();
		String contents04 = scanner.nextLine();
		String boardlist04 =" "+ no+"\t "+writer04+"\t "+ contents04 +"\n";
		
		output = header + boardlist +boardlist02 + boardlist03 + boardlist04 +footer;
		
		System.out.println(output);	
		
		//다섯번째 방문록
		no++;
		String writer05 = scanner.nextLine();
		String contents05 = scanner.nextLine();
		String boardlist05 =" "+ no+"\t "+writer05+"\t "+ contents05 +"\n";
		
		output = header + boardlist +boardlist02 + boardlist03 + boardlist04 + boardlist05 +footer;
		
		System.out.println(output);	
		/* ----------- */
	}
}
/* 
	[문제] 그림과 같이 기본자료형을 이용하여 변수 8개를 출력하시오.
	[조건] 
		1. 문제풀이 위치 외 코드는 수정 불가 합니다.
		2. 문자열클래스를 이용하여 그림과 같이 제목과 내용을 입력받습니다. [ 내용만 띄어쓰기가 가능하도록 입력받습니다 ]
		3. *반복문을 사용하지 않고 총 5개의 방문록이 작성 되도록 작성하시오.
		4. 방문록 1번 작성할때마다 방문록을 목록을 보여줍니다.
		5. 기존에 미리 작성된 변수를 최대한 활용합니다.
		
김현수
안녕하세요! 처음입니다.
*/
