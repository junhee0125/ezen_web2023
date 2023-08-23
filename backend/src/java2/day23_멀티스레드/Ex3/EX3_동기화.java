package java2.day23_멀티스레드.Ex3;

public class EX3_동기화 {
	public static void main(String[] args) {
		
		//1. 계산기 객체 생성
		
		Calculator calculator = new Calculator();
		
		
		//2. 작업스레드[유저1] 객체생성
		User1Thread user1 = new User1Thread();
		user1.setCalculator(calculator);
		user1.start();
		
		//3. 작업스레드[유저2] 객체생성
		
		User2Thread user2 = new User2Thread();
		user2.setCalculator(calculator);
		user2.start();
	
	}

}
/*
 	synchronized 전
 		[console 결과]
  			user1  : 2초후 저장된 메모리 : 50
			user2  : 2초후 저장된 메모리 : 50
	synchronized 후
 		[console 결과]
  			user1  : 2초후 저장된 메모리 : 100
			user2  : 2초후 저장된 메모리 : 50
		
  	//메소드 내 특정 블록에 동기화하는 방법
	public void setMemory2(int memory) { } 추가후에
		[console 결과]
		user1  : 2초후 저장된 메모리 : 100
		비동기화구역
		user1 : 접근
		user2  : 2초후 저장된 메모리 : 50
		비동기화구역
		user2 : 접근
		user1  : 2초후 저장된 메모리 : 200
		user2  : 2초후 저장된 메모리 : 150
  
 */
