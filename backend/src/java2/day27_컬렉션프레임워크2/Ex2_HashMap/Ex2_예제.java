package java2.day27_컬렉션프레임워크2.Ex2_HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Ex2_예제 {
	public static void main(String[] args) {

		// 1.map 컬렉션 객체 내 <String, Integer> 2개 객체를 저장할  HashMap
		Map<String , Integer> map = new HashMap<>();

		// 2. 객체저장 - 키는 중복불가/ 값은 중복가능
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); //홍길동 중복..그런데...90이 저장안됨(미리 담았던 객체에 덮어 쓴듯)

		System.out.println( "map 상태 : " + map);
		//map 상태 : {홍길동=95, 신용권=85, 동장군=80}

		// 4. map객체 내의 모든 키 호출
		System.out.println( "map 객체내 모든 키 :  " + map.keySet() );
		System.out.println( "map 객체내 모든 값 :  " + map.values() );

		//5. 향상된 for
		//map.keySet().iterator();
		for(String key: map.keySet()) {System.out.printf("Key : %s value: %d \n", key, map.get(key));}
		/*
		 	Key : 홍길동 value: 95
			Key : 신용권 value: 85
			Key : 동장군 value: 80
		 */
		map.keySet().forEach(key ->{System.out.printf("Key : %s value: %d \n", key, map.get(key));});

		//------------entry <key , value> call-----------------//
		for( Entry<String, Integer> entry : map.entrySet()) { // 엔트리자체 검색
			System.out.println("map.entrySet() : "+ entry);
			System.out.println("entry.getValue() : "+ entry.getValue());
			System.out.println("entry.getKey() : "+ entry.getKey());
		/*
		 	map.entrySet() : 홍길동=95
			entry.getValue() : 95
			entry.getKey() : 홍길동
			map.entrySet() : 신용권=85
			entry.getValue() : 85
			entry.getKey() : 신용권
			map.entrySet() : 동장군=80
			entry.getValue() : 80
			entry.getKey() : 동장군
		*/
		}
		map.entrySet().forEach( entry -> {
			System.out.println("map.entrySet() : "+ entry);
			System.out.println("entry.getValue() : "+ entry.getValue());
			System.out.println("entry.getKey() : "+ entry.getKey());
		});
		/* 출력 결과물 상동*/
	}
}
