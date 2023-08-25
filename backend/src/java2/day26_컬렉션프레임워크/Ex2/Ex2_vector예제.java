package java2.day26_컬렉션프레임워크.Ex2;

import java.nio.file.attribute.AclEntry;
import java.util.List;
import java.util.Vector;

import java2.day26_컬렉션프레임워크.Board;

public class Ex2_vector예제 {
	public static void main(String[] args) {
		
		// 1. vector 리스트 객체 생성
				//ArrayLsit 와 Vaector
					// 내부구조 동일하고 함수도 동일
					// 동기화 x vs 동기화 O
			List<Board> list = new Vector<>();
			
			
			//2작업스레드 A추가
			//Thread threadB = new Thread(){}
			Thread threadA = new Thread() {
				
				public void run() {
					
					for( int i = 1 ; i<=1000 ; i++) { 
						
						list.add(new Board ("제목"+i,"내용"+i,"글쓴이"+i));	
					}
					
				};
			};	//thread e
			
			//2작업스레드 ㅠ추가
			//Thread threadB = new Thread(){}
			Thread threadB = new Thread(){
				public void run() {
					for( int i = 1001 ; i<=2000 ; i++) { 
						list.add(new Board ("제목"+i,"내용"+i,"글쓴이"+i));	
					}
				}
			}; //thread e
			
			
			threadA.start();
			threadB.start();
			
			try {
				threadA.join();
				threadB.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int size = list.size();
			System.out.println("총 객체수" + size);
			System.out.println();
		
	}

	
	
}
