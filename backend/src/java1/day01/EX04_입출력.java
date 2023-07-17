package java1.day01;
import java.util.Scanner;


public class EX04_입출력 {
	public static void main(String[] args) {
		
		//1. 출력:syso
			// 1. System.out.print("출력하고 싶은 말" or 변수명); ==> 출력만
		System.out.print("출력문구1");
		System.out.print("출력문구2");
		
			// 2. System.out.println("출력하고 싶은 말" or 변수명); ==> 출력 + 줄바꿈
		System.out.println("출력문구3");
		System.out.println("출력문구4");
		
			// 3. System.out.printf("형식/포맷문자",값/변수); ==> 형식 문자열에 맞춫어 값 출력[p.69]
		// %d : 정수, %f실수 %s 문자열 %자릿수d (남은것 왼쪽 공백, 
		int value = 1233;
		System.out.printf("상품의 가격:%d원\n",value); //%d위치에 value변수 출력
		System.out.printf("상품의 가격:%6d원\n",value); // 6 정수 자리 칸에 변수 출력오른쪽 정렬
		System.out.printf("상품의 가격:%-6d원\n",value); // 6 정수 자리 칸에 변수 출력 왼쪽정렬( 공란은 오른쪽에)
		System.out.printf("상품의 가격:%06d원\n",value); // 6 정수 자리 칸에 변수 출력 오른쪽에 빈자리는 0왼쪽에으로 채움
		
		
		//.소수점자릿수f : 소수점자릿수 만큼 출력ddd
		System.out.printf("반지름 파이 %f \n",3.14); // 6 정수 자리 칸에 변수 출력 
		System.out.printf("반지름 파이 %.1f \n",3.14); // 6 정수 자리 칸에 변수 출력 
		
		System.out.printf("회원아이디 :%-10s \n","qwerqwer"); // 6 정수 자리 칸에 변수 출력 

		
		//2. 입력
			//1.입력 객체 생성한다.
			//Scan + 컨트롤 + 스페이스바 => Scanner 클래스 설계도e
			//띄어쓰기 컨트롤 + 스페이스바 = scanner 객체명
			//new 연산자: 객체에 메모리 할당 생성
			//Scanner() : 클래스의 생성자 (객체 생성시 초기값대입하는 메소드) = 클래스명 무조건 동일
		
		Scanner  scanner = new Scanner(System.in); //System.in 시스템 입력(키보드) <-> System.out (콘솔)
		
			//2. 입력 객체를 이용한 입력값 호출 가져오기
				//1. 입력받은 문자열 가져오기
		String 문자열 = scanner.next();				System.out.println("입력받은 문자열 : "+문자열);
		
		//띄어쓰기까지 저장
		String 문자열1 = scanner.nextLine();		    System.out.println("입력받은 문자열1 : "+문자열1);	
		
		boolean 논리 = scanner.nextBoolean();		System.out.println("입력받은 논리 : "+논리);	
		
		byte 바이트 = scanner.nextByte();			System.out.println("입력받은 바이트 : "+바이트);		
		
		int 인트 = scanner.nextInt();				System.out.println("입력받은 인트 : "+인트);
		
		short 쇼트= scanner.nextShort();				System.out.println("입력받은 쇼트 : "+쇼트);	
		
		long 롱 = scanner.nextLong(); 				System.out.println("입력받은 롱 : "+롱);	
		
		float 플롯 = scanner.nextFloat(); 			System.out.println("입력받은 플롯 : "+플롯);	
		
		double 더블 = scanner.nextDouble();			System.out.println("입력받은 더블 : "+더블);	
		
		//2. 입력
	}
}
