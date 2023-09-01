package java2.day28_컬렉션프레임워크3.Ex1_TreeSet;

import java.util.TreeSet;

/*
  	검색 기능을 강화시킨 컬렉션
  		- 컬렉션 안에 있는 데이터를 검색할 때 효율성 제공 [ 필수는 아님]
  		- 이진트리
  			- 노드를 갖음
  			= 각 노드는 최대 2개의 노드를 연결
  			- 부모 노드보다 작으면 왼쪽. 크면 오른쪽 노드에 위치
 */
public class Ex1_예제 {
	public static void main(String[] args) {


		// 1.TreeSet 객체색성
		TreeSet<Integer> scores = new TreeSet();

		// 2. 무작위로 숫자저장
		scores.add( 87 );
		scores.add( 75 );
		scores.add( 82 );
		scores.add( 91 );
		scores.add( 98 );
		scores.add( 67 );

		System.out.println("이진트리상태 " + scores);
		//이진트리상태 [67, 75, 82, 87, 91, 98]

		// 3.
		System.out.println("가장 왼쪽노드 " + scores.first()); //가장 왼쪽노드 67
		System.out.println("가장 오른쪽 노드 " + scores.last()); //가장 오른쪽 노드 98
		System.out.println("95점 아래 노드 " + scores.lower(95)); //95점 아래 노드 91
		System.out.println("95점 이상 노드 " + scores.higher(95)); //95점 이상 노드 98
		System.out.println("95점이거나 아래노드 " + scores.floor(95));//95점이거나 아래노드 91
		System.out.println("95점 이거나 위노드 " + scores.ceiling(95)); //95점 이거나 위노드 98

		// 4. 내림차순
		System.out.println("이진트리 내림차순 " + scores.descendingSet());
		//이진트리 내림차순 [98, 91, 87, 82, 75, 67]


		// 5. 범위검색 //tailSet( 숫자 , 옵션, [true(이상), false(초과])
		System.out.println("이진트리 80이상 " + scores.tailSet(80,true));
		//이진트리 80이상 [82, 87, 91, 98]

		// 5. 범위검색 //subSet( 시작숫자 , 옵션, [true(이상), false(초과])
		System.out.println("이진트리 80이상 90미만 " + scores.subSet(80,true, 90, false));
		//이진트리 80이상 90미만 [82, 87]

	}

}
