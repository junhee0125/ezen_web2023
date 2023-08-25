/*
 	ArrayList vs LinkedList
 	사용방법은 동일하지만, 내부구조 설계가 다름
 	배열에 객체저장, 객체를 체인처럼 연결
 */
package java2.day26_컬렉션프레임워크.Ex3_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex3_LinkedListExample {
	public static void main(String[] args) {
		
		// ArrayLsit생성
		List<String> list1 = new ArrayList<String>();
		
		
		// Linkedlist생성
		List<String> list2 = new LinkedList<String>();
				
		//두 객체의 저장속도 체크
		long startTime; 	//시작시간
		long endTime;		//끝시간
		
		
		// 밀리초 (1/1000)초  나노초 (1/1000000000초)
		startTime = System.nanoTime(); //현재시간을 나노시간으로 호출 반환
		for(int i = 0; i<1000; i++) {
			list1.add( 0, String.valueOf(i)+" "); // 인덱스를 넣어주면 더 올래걸림.
		}
		endTime = System.nanoTime();
		
		System.out.println("arrayList1에 10000rodml 데이터 저장하는데 걸리는 시간" +endTime);
		
		
		startTime = System.nanoTime(); //현재시간을 나노시간으로 호출 반환
		for(int i = 0; i<1000; i++) {
			list2.add( 0, String.valueOf(i)+" "); //링크드는 인덱스를 넣어줘도 차이가 거의 없음.
		}
		endTime = System.nanoTime();
		
		System.out.println("LinkedList2에 10000rodml 데이터 저장하는데 걸리는 시간" +endTime);
		
	}
	
}
