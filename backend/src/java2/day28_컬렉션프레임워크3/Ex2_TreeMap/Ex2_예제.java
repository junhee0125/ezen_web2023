package java2.day28_컬렉션프레임워크3.Ex2_TreeMap;

import java.util.TreeMap;

public class Ex2_예제 {
	public static void main(String[] args) {

		//1. TreeMap 객체 생성
		TreeMap<String, Integer > treeMap = new TreeMap<>();

		//2. 무작위 엔트리<키, 값> 저장
		treeMap.put("apple", 10);
		treeMap.put("forever", 60);
		treeMap.put("description", 40);
		treeMap.put("ever", 50);
		treeMap.put("zoo", 80);
		treeMap.put("base", 20);
		treeMap.put("guess", 70);
		treeMap.put("cherry", 30);

		System.out.println("이진 트리 맵 상태 : " + treeMap);
		//오름차순.: 낮은것부터 높은  1,2,3 ㄱ ㄴ ㄷ , a b c
		//이진 트리 맵 상태 : {apple=10, base=20, cherry=30, description=40, ever=50, forever=60, guess=70, zoo=80}


		// 3.
		System.out.println(" 가장 왼쪽노드/ 엔트리 " + treeMap.firstEntry());
		System.out.println(" 가장 오른쪽 노드 " + treeMap.lastEntry());
		System.out.println("ever 노드 왼쪽노드.엔트리" + treeMap.lowerEntry("ever"));
		System.out.println("ever 노드 왼쪽노드.엔트리 " + treeMap.higherEntry("eve"));
		System.out.println("ever 노드 이거나  왼쪽노드.엔트리 " + treeMap.floorEntry("ever"));
		System.out.println("ever 노드 이거나  오른쪽노드.엔트리 " + treeMap.ceilingEntry("ever"));
		/*
		  	가장 왼쪽노드/ 엔트리 apple=10
     		가장 오른쪽 노드 zoo=80
			ever 노드 왼쪽노드.엔트리description=40
			ever 노드 왼쪽노드.엔트리 ever=50
			ever 노드 이거나  왼쪽노드.엔트리 ever=50
			ever 노드 이거나  오른쪽노드.엔트리 ever=50
		 */

		// 4. 내림차순
		System.out.println("이진트리 map내림차순 " + treeMap.descendingMap());
		//이진트리 map내림차순 {zoo=80, guess=70, forever=60, ever=50, description=40, cherry=30, base=20, apple=10}


		// 5. 범위검색 //tailSet( 기준 옵션, [true(이상), false(초과])
		System.out.println("a-c까지 " + treeMap.headMap("c",true));
		System.out.println("C부터 끝까지 " + treeMap.tailMap("c",true));

		// 5. 범위검색 //subSet( 시작범위 , 옵션, [true(이상), false(초과], 끝범위 , 옵션)
		System.out.println("c이상 h미만" + treeMap.subMap("c",true, "h", false));

		/*
		 	a-c까지 {apple=10, base=20}
			C부터 끝까지 {cherry=30, description=40, ever=50, forever=60, guess=70, zoo=80}
			c이상 h미만{cherry=30, description=40, ever=50, forever=60, guess=70}
		 */
	}
}
