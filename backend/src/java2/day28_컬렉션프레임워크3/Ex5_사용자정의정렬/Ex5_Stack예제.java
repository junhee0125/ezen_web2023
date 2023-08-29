package java2.day28_컬렉션프레임워크3.Ex5_사용자정의정렬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex5_Stack예제 {

	public static void main(String[] args) {

		// Stack컬렉션 생성 :스택 객체 선언(동전케이스)
		Stack<Coin> coincase = new Stack<Coin>();


		// 무작위로 동전 넣기
		coincase.push( new Coin(100) );
		coincase.push( new Coin(500) );
		coincase.push( new Coin(10) );
		coincase.push( new Coin(50) );

		System.out.println("스택 상태: "+ coincase);
		//스택 상태: [Coin [value=100], Coin [value=500], Coin [value=10], Coin [value=50]]


		//후입선출이므로 나중에 들어온 값이 먼저 삭제 :마지막
		coincase.pop();
		System.out.println("스택 상태: "+ coincase);
		//스택 상태: [Coin [value=100], Coin [value=500], Coin [value=10]]


		//-------------------------------------------------------------------//

		//1. Queue구현체[LinkedList<>]동저네이스 선언
		Queue<Coin> coincase2 = new LinkedList<>();

		// 무작위로 동전 넣기
		coincase2.offer( new Coin(100) );
		coincase2.offer( new Coin(500) );
		coincase2.offer( new Coin(10) );
		coincase2.offer( new Coin(50) );

		System.out.println("큐  상태: "+ coincase2);
		//큐  상태: [Coin [value=100], Coin [value=500], Coin [value=10], Coin [value=50]]


		//선입선출이므로 먼저 들어온 값이 먼저 삭제 : 100삭제
		coincase2.poll();

		System.out.println("큐 상태: "+ coincase2);
		//큐 상태: [Coin [value=500], Coin [value=10], Coin [value=50]]


	}


}
