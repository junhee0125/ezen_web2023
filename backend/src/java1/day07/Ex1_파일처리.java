package java1.day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex1_파일처리 {
	public static void main(String[] args) throws IOException {
		
		/*
		- 스택영역 : 함수는 호출시 메모리가 할당되고, 종료시 메모리 초기화 * 지역변수
		- 힙영역 :  객체 / 배열은 참조하는 스택이 없으면 자동으로 초기화
		- RAM 주기억장치가 하는 역할은 :  현재 실행중인 처리된 명령어를 저장하는데
									 	전기공급이 중단되면, 저장안됨 >> 지워짐 (휘발성)
		
		영구저장할 때 사용하는 것
			보조기억창지 : 명렁어를 영구 저장 : 전기x  저장 됨  >> 비휘발성
		 					c:,. usb, cd등등
		 					
		 	Ex1_파일처리 .java파일의
		 		저장위치 : C: (내가 작성한 코드/문법등은)
		 		실행하면 : 실행중에 필요한 메모리(변수, 객체,. 배열 등등)- > 주기억장치
		 		실행중인 메모리를 다음에 또 사용하려면 주기억장치 메모리를 보조기억장치에 저장하고 불러오는 작업이 필요하다
		 		
		 		String a = scanner.next() ; --------------------> c:저장 [파일처리, 데이터 베이스]
		 		컴퓨터 종료후 다음날
		 		String b                 <------------------------c: 불러오기 [파일처리, 데이터베이스]
		 
		파일처리 라이브러리 (미리 만들어진 클래스 / 메소드 )
			* 스트림 : 자바와 자바외부의 것과 통신하는 통로 / 자바 외부의 프로그램과 통신할때 사용하는 통로 [* 바이트 단위로 ]
			* 	* 통신하다가 갑자기 오류 발생할 수도 있음 [* 필수 : 미리 예외처리 / 오류처리 ]
			* 	Scanner 클래스는 -- 자체 내부적으로  예외처리를 했음
			*   Buffer는 예외처리를 직접해야한다.
		 	1. FileOutputStream : 파일 내보내기. 저장 관련된 메소드 제공하는 클래스
		 		new FileOutputStream("파일경로"); : 해당파일과 연동 /연결 : 해당파일이 존재하지 않으면 해당파일을 생성
		 		new FileOutputStream("파일경로", true); : 해당파일과 연동 /연결 + 해당파일이 존재하지 않으면 생성하고 but 해당파일이 존재하면  이어쓰기 가능 Goooooood!!
		 		파일경로
		 			상대경로 : 프록젝트명 생략 -> ./src/패키지명/파일명
		 			절대경로 : C:Users\.....\src\java1\day07
		 	
		 	
		 	2. FileInputStream : 파일 불러오기 관련된 메소드를 제공하는 클래스
		 		 new FileInputStream("File Path"); 
		 		 
		 	3. File클래스	 : 파일의 정보/ 제어 관련 메소드 제공
		 		메소
		 			1. 존재여부 file.exists();
		 			2. 삭제 file.delete();
		 			3. 경로 file.getPath()
		 			4. 파일 용량 file.length()
		 	2. 제공하는 함수
		 		1. .write(바이트 배열 ): 해당 객체와 연결된 파일의 바이트 배열을 내보내기  1 -2 바이트 = 한글자  / 바이배열 : 여러글자
		 		2. .read(바이트 배열)  :	 해당 객체와 연결된 파일의 바이트 읽어오기
		 *
		 */
		
		//1. 파일처리 [저장]
		Scanner scanner = new Scanner(System.in); // 입력객체  = 입력한 값이 바이트로 들어옴
		String instr = scanner.nextLine(); // 객체로부터 입력받은 값의 바이트열을 문자열로 반환 		
		
		//1. 파일처리[저장]
			//1. 파일출력스트림 객체 선언 [파일경로] 
//		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex1_테스트.txt");
		FileOutputStream fileOutputStream = new FileOutputStream("./src/java1/day07/Ex1_테스트.txt", true);

		
		// 2. 파일출력스트림 객체를 이용한 내보내기 메소드 사용 [바이트 단위]
		byte[] outstrArray = instr.getBytes();  //문자열을 바이트배열로 변환후 바이트형 배열에 담아서
		//fileOutputStream.write("안녕하세요".getBytes()); 
		fileOutputStream.write(outstrArray); //instArray에  담긴것을  해당 파일에 쓴다는 것.
		
		//2. 파일처리 [파일 불러오기]
			//1. 파일입력스트림 객체 선언 [파일경로]
		FileInputStream fileInputStream = new FileInputStream("./src/java1/day07/Ex1_테스트.txt");
		
			// 2. 파일입력스트림 객체를 이용한 파일 내용 읽어오기 [바이트 단위ㅏ]
		byte[] instrArray = new byte[1000]; //: 파일의 바이트만큼 배열 선언 [* 정확한 파일의 용량을 알수 없어. 하지만 File클래스를 사용하면 가능]
		// 임의로 넣은 용량중 남는 만큼은  공백으로 채운다는것...
		fileInputStream.read(instrArray);

			//3. 바이트배열을 문자열로 변환
		String str = new String(instrArray);
		System.out.println("테스트.txt파일에서 가져온 내용 : "+str);
		
			//파일 입력스트림 객체에서
		//3. 외부파일 불러오기 []SV불러오기 ]
		FileInputStream 복권파일 = new FileInputStream("./src/java1/day07/로또.csv");
			//해당파일의 용량 알기
		File file = new File(".src/java1/day07/로또.csv");
			System.out.println("해당 파일 경로에 파일 존재여부 : "+file.exists()); //파일이 존재하는지.
			System.out.println("해당 파일 경로 : "+file.getPath()); //파일이 존재하는지.
			System.out.println("해당 파일 용량(바이트) : "+file.length()); //파일이 존재하는지.
		byte[] 복권파일바이트배열 = new byte[(int)file.length()]; // 용량만큼 배열선원
		
			//읽어오기
		복권파일.read(복권파일바이트배열);
		String 복권파일정보 = new String(복권파일바이트배열);
		System.out.println(복권파일정보);
		
		//4 외부파일 가져오기 [ csv불러오기]
		
		String path = "./src/java1/day07/전국관광지정보표준데이터.csv" ;
			//1, 파일 입력 객체 생성
		FileInputStream 관광지파일  = new FileInputStream(path);
		File file2 = new File(path);
		byte[] 관광지파일바이트배열 = new byte[(int)file2.length()];
		관광지파일.read(관광지파일바이트배열); //관광지 파일에 배열 읽어오기
		//String 관광지파일정보 =  new String(관광지파일바이트배열);
		String 관광지파일정보 =  new String(관광지파일바이트배열,"EUC-KR");
		//String 관광지파일정보 =  new String(관광지파일바이트배열,"UTF-8");
		//System.out.println(관광지파일정보);  //한글 인코딩(번역) 대표적인 방법 2가지 : utf-8 , euc-kr

		System.out.println(관광지파일정보.split("\n")[0]);
		
		
		
		
	}
}
