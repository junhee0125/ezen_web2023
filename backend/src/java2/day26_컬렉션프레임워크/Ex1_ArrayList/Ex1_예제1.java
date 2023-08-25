package java2.day26_컬렉션프레임워크.Ex1_ArrayList;

import java.util.ArrayList;
import java.util.List;

import java2.day26_컬렉션프레임워크.Board;

public class Ex1_예제1 {
	
	public static void main(String[] args) {
		
		//1. ArrayList객체 생성
		//=  ArrayList<Board> list = new ArrayList<>();
		List<Board> list = new ArrayList<>();
		
		
		// 2. ArrayList 객체에 안에 객체 추가
			// 리스트 객체명.add(객체)	:	해당 객체를 리스트 끝에 추가
		// 리스트 객체명.add(인덱스,객체)	:	해당 객체를 리스트 내 인덱스 위치에 추가
		// 리스트 객체명.set(인덱스,객체)	:	해당 객체를 리스트 내 인덱스 위치에 변경
		System.out.println("---1---\n"+list.toString());
		list.add(new Board("제목1","내용1","글쓴이1"));
		list.add(new Board("제목2","내용2","글쓴이2"));
		list.add(new Board("제목3","내용3","글쓴이3"));
		list.add(new Board("제목4","내용4","글쓴이4"));
		list.add(new Board("제목5","내용5","글쓴이5"));
		
		list.add(0,new Board("제목6","내용6","글쓴이6")); //0번 인덱스에 객체를 추가하고 한칸씩 뒤로 물러남
		list.add(1,new Board("제목7","내용7","글쓴이7"));  // 인덱스 1번에 객체 사라지고 해당객체 추가
		System.out.println("---2 add---\n"+list.toString());
		
		//board는 객체 생성후 리스트 추구ㅏ
		Board board = new Board("제목8","내용8","글쓴이8");
		list.add(board);
		
		//객체생성후 리스트 추가 안함
		Board board2= new Board("제목8","내용8","글쓴이8");
		
		
		// 3.  ArrayList 객체 안에 객체의 총 개수
			// 리스트 객체명.size(객체)	:	리스트 내에 저장된 객체수 ;
		System.out.println("---3 size---\n"+list.size());
		
		
		// 4.  ArrayList 객체 안에 특정 객체 검색 수
			// 리스트 객체명.get(인덱스)		:	리스트내 해당 인덱스 위치에 객체 반환
			// 리스트 객체명.contains(객체)	:	리스트내 해당 객체 존재여부 반환
			// 리스트 객체명.isEmpty()	:	리스트내 해당 객체 존재여부 반환
		System.out.println("---4 get---\n"+list.get(2));
		System.out.println("---4 contains---\n"+list.contains(board));
		System.out.println("---4 contains---\n"+list.contains(board2));
		System.out.println("---4 isEmpty---\n"+list.isEmpty());
		
		// 리스트와 반복문 활용 : 여러개 데이터를 순차적으로 순회하는 방법
			//1. for문
			//cf 배열) for(int i = 0; i<list.length();i++) {
		System.out.println("---6 - 1. for문---");
		
		for(int i = 0; i<list.size();i++) { 
			System.out.println("index [ " +i+ " ]"+list.get(i))
			;
			
		}
			//2. 향상된 for문 : 인덱스를 사용하지 않음
		
		System.out.println("---6 - 2. 향상된 for문---");
		int index = 0 ; // 향상된 포문에선 인덱스를 사용하지 않지만 굳이 써야 된다면
		for(Board b : list) { //리스트내 객체를 자동으로 처음부터 끝까지 반복변수에 대입
			System.out.println(b);
			System.out.println("index [ " +index+ " ] "+b);
			index++;
			
		}
			//3. forEach() //사실,,이건 ,함수
				//리스트내 객체를 자동으로 처음부터 끝까지 매개변수 b에 하나씩 대입하고 {} 실행
		System.out.println("---6 - 2. forEach()---");
		list.forEach(b -> {System.out.println(b);}) ;
		//list.map(b ,i)-> {System.out.println(b, i);}) ;
		
		/*
			화살표함수를 
				자바는 ->  
					[매개변수 ->{실행코드}]
				자바스크립트 => 
					[매개변수 => {실행코드}]
			
			forEach(반복변수명 ->{ 실행코드 })
		*/
		
		// 5. ArrayList 객체 ㅏㅇㄴ에 특정객체 삭제
			// 리스트 객체명.remove(인덱스)		:	리스트내 해당 인덱스 위치의 객체 삭제
			// 리스트 객체명.remove(객체)		:	리스트내 객체존재하면 삭제
			// 리스트 객체명.clear()	:	리스트내 해당 객체 존재여부 반환
		list.remove(2); //리스트내 2번 인덱스 객체 삭제
		System.out.println("---5---remove(2)\n"+list.toString());
		list.remove(board);
		System.out.println("---5---remove(board)\n"+list.toString());
		list.clear();
		System.out.println("---5---clear()\n"+list.toString());
	}
}
