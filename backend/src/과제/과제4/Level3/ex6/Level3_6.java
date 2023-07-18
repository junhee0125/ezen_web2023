package 과제.과제4.Level3.ex6;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		String seat1 = "[ ]";
		String seat2 = "[ ]";
		String seat3 = "[ ]";
		String seat4 = "[ ]";
		String seat5 = "[ ]";
		String seat6 = "[ ]";
		boolean run = true;
		
		System.out.println("----------------------------------------------------");
		System.out.println("1. 예약하기 | 2.예약취소 | 3.예약현황 |4. 프로그램 종료");
		System.out.println("----------------------------------------------------");
		
		while(run) {
			
			System.out.println("메뉴를 선택하세요 : "); int ch = scanner.nextInt();
			
			if( ch == 1 ) {
				System.out.println("예약할 좌석을 선택하세요 1~6번 : "); int seatNo = scanner.nextInt();
				if(seatNo == 1) {
					if(seat1.equals("[ ]")) {	seat1 = "[예약]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "이미예약이 되었습니다.");}
				}
				
				if(seatNo == 2) {
					if(seat2.equals("[ ]")) {	seat2 = "[예약]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "이미예약이 되었습니다.");}
				}
				
				if(seatNo == 3) {
					if(seat3.equals("[ ]")) {	seat3 = "[예약]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "이미예약이 되었습니다.");}
				}
				
				if(seatNo == 4) {
					if(seat4.equals("[ ]")) {	seat4 = "[예약]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "이미예약이 되었습니다.");}
				}
				
				if(seatNo == 5) {
					if(seat5.equals("[ ]")) {	seat5 = "[예약]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "이미예약이 되었습니다.");}
				}
				
				if(seatNo == 6) {
					if(seat6.equals("[ ]")) {	seat6= "[예약]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "이미예약이 되었습니다.");}
				}
				
			} else if ( ch == 2 ) { //2. 예약취소 :취소할좌석번호를 선택 - 예약된어 있으면 값을 초기화하고 예약취소 메세지 / 공란이라면 예약정보가 없다는 메시지
				System.out.println("취소할 좌석을 선택하세요 1~6번 : "); int seatNo = scanner.nextInt();
				if(seatNo == 1) {
					if(seat1.equals("[예약]")) {	System.out.println("좌석번호 "+ seatNo+  ": 예약을 취소하였습니다."); seat1 = "[ ]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "예약정보가 없습니다..");}
				}
				if(seatNo == 2) {
					if(seat2.equals("[예약]")) {	System.out.println("좌석번호 "+ seatNo+  ": 예약을 취소하였습니다."); seat2 = "[ ]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "예약정보가 없습니다..");}
				}
				if(seatNo == 3) {
					if(seat3.equals("[예약]")) {	System.out.println("좌석번호 "+ seatNo+  ": 예약을 취소하였습니다."); seat3 = "[ ]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "예약정보가 없습니다..");}
				}
				if(seatNo == 4) {
					if(seat4.equals("[예약]")) {	System.out.println("좌석번호 "+ seatNo+  ": 예약을 취소하였습니다."); seat4 = "[ ]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "예약정보가 없습니다..");}
				}
				if(seatNo == 5) {
					if(seat5.equals("[예약]")) {	System.out.println("좌석번호 "+ seatNo+  ": 예약을 취소하였습니다."); seat5 = "[ ]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "예약정보가 없습니다..");}
				}
				if(seatNo == 6) {
					if(seat6.equals("[예약]")) {	System.out.println("좌석번호 "+ seatNo+  ": 예약을 취소하였습니다."); seat6 = "[ ]"; } 
					else { System.out.println("좌석번호 "+ seatNo+  "예약정보가 없습니다..");}
				}
				
			} else if ( ch == 3 ) {
				System.out.println( seat1 +" "+seat2 +" "+seat3 +"\n"+seat4 +" "+seat5 +" "+seat6 );
				
			} else if ( ch == 4 ) {
				System.out.println(" 프로그램을 종료합니다.");
				break;
				
			}
		}
		
		
		/* ----------- */

	}
}
/* 
	주제 : 예약 좌석 시스템
	실행결과는 제공하지 않습니다.
	
	- 변수 조건 
		1. 변수 : 6개의 좌석 은 변수를 이용합니다. [ 배열X ]
		2. 그외 자유롭게 사용. 배열/리스트 사용 금지 [ day1~day4 문법 이용 ]
	- 메뉴 조건
		0. 메뉴 : 1.예약하기 2.예약취소 3.예약현황 
	- 기능 조건 
	 	예약하기 출력예시 )
	 		1. 예약할 좌석을 선택한다.
	 		2. 만약에 비어 있으면 예약성공 아니면 예약 실패 
	 	예약취소 출력예시 )
	 		1. 예약할 취소할 좌석을 선택한다.
	 	예약현황 출력예시 )
	 		* 3개씩 2줄로 출력합니다.
			[ 예약 ]	[ ]	[ ]
			[ ] [예약] [ ]  
			- 예약이 되어 있는 좌석은 [예약] 예약이 없으면 [ ] 공란으로 출력합니다.
			
*/
