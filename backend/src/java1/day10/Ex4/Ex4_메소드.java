package java1.day10.Ex4;

import java.util.Arrays;

public class Ex4_메소드 {
	public static void main(String[] args) {
		//--------------------메소드 사용- 호출--------------------------------/
		
		//객체필요
		Member m = new Member();
		
		// 도트(.)연산자를 이용한 메소드 호출
		m.signup();
		
		m.login("qwe", 1234);
		
		m.findId(); //리턴받은 값을 사용할 목적이 없어 저장하지 않음.
		//int result = m.findId();// 저장했지만 리턴받은 데이터의 타입과 달라서 에러 Type mismatch: cannot convert from String to int
		String result = m.findId();
		
		
		String[] resultArray = m.findPw("weq","1234");
		System.out.println(Arrays.toString(resultArray));
		
		
		m.delete("안녕","hi~");
		m.delete("안녕","hi~","방가요");
		m.delete(1,"안녕","hi~","고마오~");
	}

}
