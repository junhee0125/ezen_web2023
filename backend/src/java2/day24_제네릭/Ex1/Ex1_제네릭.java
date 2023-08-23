package java2.day24_제네릭.Ex1;

import java1.day11.EX5디자인패턴2.model.dto.MemberDto;

public class Ex1_제네릭 {
	public static void main(String[] args) {
		// 목적 : 하나의 필드에 여러 타입의 데이터를 저장하고 싶을 때
		//1. [570] 제네릭을 사용하지 안을때
		
		Box2 box2 = new Box2();
		
		//1. 자식객체는 부모객로 대입[자동타입변환] : 무조건가능
		box2.content = 1;
		box2.content = "String";
		box2.content = new MemberDto();
		
		// ----------------------------------------- //
			//box2.content.getMpw();
		//2. 부모는 자식의 멤버를 사용할 수 없다.
		MemberDto dto = (MemberDto)box2.content;
		dto.getAge();
		
		if( box2.content instanceof MemberDto) {}
			//권장ㅎ자ㅣ 않는 방법
		
		
		//2. 572p 제네렉 사용법
		Box<String> box1 = new Box<>();
		box1.content = "안녕하세요";
		
		String str = box1.content;  //형변환이 필요없음
		System.out.println(str);
		
		Box<MemberDto> box3 = new Box<>();
		box3.content = new MemberDto(); // 어라.. 애러가 안나
		MemberDto dto2 = box3.content;
		System.out.println(dto2);
		
	}
	
	
}
