package java2.day27_컬렉션프레임워크2.Ex3_HashTable;

import java.util.Hashtable;
import java.util.Map;

public class Ex3_예제 {

	public static void main(String[] args) {


		// 1. HashTable 객체에  String Integer 2개 객체를 저장하는  map 객체 선언
		Map<String, Integer> map = new Hashtable<>();

		//2. 멀티스레드를 이용한 각 1000개씩 2000개를 동시저장

		Thread threadA = new Thread() {
			@Override
			public void run() {
				for(int i=0; i<=1000; i++) {
					map.put(String.valueOf(i), i);
				}
			};
		};

		Thread threadB = new Thread() {
			@Override
			public void run() {
				for(int i=1001; i<=2000; i++) {
					map.put(String.valueOf(i), i);
				}
			};
		};

		threadA.start();
		threadB.start();

		//main스레드는 다른 두 스레드가 작업이 끝날때까지 main스레드 잠시 대기
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main 객체수 : " + map.size());
		System.out.println("main 상태 : " + map);


	}
}
