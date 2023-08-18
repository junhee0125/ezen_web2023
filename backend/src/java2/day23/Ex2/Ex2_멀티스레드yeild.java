package java2.day23.Ex2;

import com.mysql.cj.protocol.a.NativePacketHeader;

public class Ex2_멀티스레드yeild {
	public static void main(String[] args) {
		
		//메인이 작업스레드 객체생성
		WorkThread threadA= new WorkThread("workThread  A");
		WorkThread threadB= new WorkThread("workThread  B");
	
		// 작업스레드 실행
		threadA.start(); //작업스레드 A실행
		threadB.start(); //작업스레드 B실행

		//메인스레드가 5초후에 A스레드를 일시정지 [A스레드가 다른스레드에게 양보]
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//a스레드의 work값을 false로 = 일시정지
		threadA.work = false;
		
		//메인이 a스레드를 10초후에 실행시킴
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadA.work = true;
	}
}
