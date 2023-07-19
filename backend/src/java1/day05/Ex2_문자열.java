package java1.day05;

public class Ex2_문자열 {
	public static void main(String[] args) {
		
		//[153]
		String name1= "홍길동";  //문자열 리터럴 //10번지
		String name2= "홍길동";  //문자열 리터럴 //10번지
		/*
		 문자 리터럴은 상수라고 생각해서 같은 값의 경우 메모리를 하나만 만듬. 
		 * */
		
		System.out.println(name1== name2);  //true;
		
		String name3 = new String("홍길동"); 	//11번지
		String name4 = new String("홍길동");		//21번지
		System.out.println(name3== name4);  //false
		
		//[p.156]
		
		if(name1 == name2) {
			System.out.println("두 문자열은 같습니다.");
		} else {
			System.out.println("두 문자열은 다릅니다.");
		}
		
		if(name3 == name4) {
			System.out.println("두 문자열은 같습니다.");
		} else {
			System.out.println("두 문자열은 다릅니다.");
		}		
		
		String ssn = "9606241230123";
		char sex = ssn.charAt(6);
		if(sex == '1' || sex == '3') {System.out.println("남자입니다.");}
		else {System.out.println("여자입니다.");}
		
		//[p158]
		System.out.println("주민등록번호길이 : "+ ssn.length());
				
		//[p159]
		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은  String입니다.";
		oldStr.replace("자바", "JAVA");
		System.out.println(oldStr.replace("자바", "JAVA"));
		System.out.println(oldStr);

		
		//[160] 
		String ssn2 = "080214-3068912";
		String secondNuString= ssn2.substring(7);
		System.out.println(secondNuString);	 //인덱스까지 잘리고 나머지 반환
		
		String firstNum = ssn2.substring(0,6); //0번부터 인덱스 전(5)까지를 반환
		System.out.println(firstNum);
		
		System.out.println(ssn2.split(firstNum)); //힙주소 : @1175e2db
		System.out.println(ssn2.split("-")[0]); 
		System.out.println(ssn2.split("-")[1]);
		
		//[162]indexOf() : 문자찾기
		String subject = "자바 프로그래밍";
		int location = subject.indexOf("밍"); 
		if(location == -1 ) {
			System.out.println("프로그램 책이 아닙니다.");
		} else {
			System.out.println("프로그래밍 책입니다.  :  "+location);
		}
		
	}
}
/*
 자바 문자열 사용방법
 주소비교는 ==
 안의 데이터비교 = ㅇㅎㅁㅅㄷ
 1. String 변수명 : "문자열"
 2. String 변수명 : new STring("문자열");
 
 자바 문자열에서 제공해주는 라이브러리 = 미리 만들어진 함수들
 객체.메소드명
 1. 문자열객체1.equals(문자역객체2) : 두문자열객체내 문자열이 동일하면 true 아니면 false반환 (주소x)
 2. 문자열객체.charAt(인덱스) : 문자열 내 해당 인덱스의 문자1개 반환 [첫번째 글자 = 인덱스 0]
 3. 문자열객체.length()" : 문자열의 길이
 4. 문자열객체.replace("기존문자열","바꿀문자열")
 5. 문자열객체.substring(시작인덱스) : 시작인덱스부터 마지막 인덱스까지 반환
 	문자열객체.substring(시작인덱스, 마지막 인덱스) : 시작 인덱스부터 마지막 인덱스 전까지 추출
 	문자열객체.split("분리기준문자") => 분리해서 배열로 반환함 따라서 문자열객체.split("분리기준문자")[인덳스]
 6. 문자열객체.indexOf("찾고싶은 문자열") : 문자찾기 문자열내 찾을 문자열이 존재하면 인덱스를 반환/ 없으면 -1반환

 
" */
