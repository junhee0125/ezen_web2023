package java2.day23.Ex1;

public class Ex1_멀티스레드join {
	public static void main(String[] args) {
		//현재 스레드명
		System.out.println("현재스레드 : " + Thread.currentThread().getName());
		
		//메인이 작업스레드 객체생성
		SumThread sumThread = new SumThread();
		// 메인이 작업스레드 실행
		sumThread.start();
		//작업스레드의 객체필드 확인하지만....
		//작업스레드의 계산이 끝나기전에 main스레드가 결과를 먼저 출력해버려서..
		System.out.println("[join을 하기 전] 1-100까지 합" + sumThread.getSum());
		
		try {
			//join.(means... 합친다.) 작업스레드를 호출한 스레드(main Thread)가 일시정지된상태
			sumThread.join();
			// main Thread가  sumThread의 join() 메소드를 호출했기때문에 메인스레드 일시정지
			//sumThread가 종료되면 메인스레드 일시정지 해제~
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("[join을 하고난 후] 1-100까지 합" + sumThread.getSum());
	}
}
/*
	[console 결과]
	현재스레드 : main
	[join을 하기 전] 1-100까지 합0
	[join을 하고난 후] 1-100까지 합5050
 */