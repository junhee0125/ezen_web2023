package java1.day13.Ex2.model.dao;

import java.util.ArrayList;

import java1.day13.Ex2.model.dto.BoardDto;

public class BoardDao {
	//싱글톤 o 
	private static BoardDao boardDao = new BoardDao();
	private BoardDao(){}
	public static BoardDao getInstance() {return boardDao;}
		
	//게시물 여러개 저장하는 곳.
	/* 
	 * 1 배열
		public  BoardDto[] boarDtoArray = new BoardDto[100];
	*/
	//2 리스트 : 배열라이브러리. 배열을 쉽게 사용할 수 있도록 다양한 함수 제공
	 public ArrayList<BoardDto> boardDtoList = new ArrayList<>();
	/*
	  배열에서 
	  - 삭제하는 방법
	  		- 배열에서는 삭제못함 - 배열의 길이는 바꿀수가 없기때문 (고정길이)
	  		- 해당인덱스에 값을 null로 넣어주고.
	  		- 해당 인덱스 이후의 인덱스 값을 하나씩 당겨ㅛ
	  		
	  		
	  	리스트 선언하는 방법 :
	  	 ArrayList<BoardDto> boardDtoList = new ArrayLiust 	
	 	ArrayList : 배열처럼 사용가능한 클래스객체 선언
	 	<클래스명> : 리스트 ㅇㄴ에 여러개 객체를 저장할 객체의 타입
	 	//boardList : 리스트 변수명 
	 	
	 	
	 	리스트에 값 저장하는 방법 : 해당 객체를 리스트에 [마지막 인덱스 뒤로 객체 추가]
	 		리스트객체명.add(객체명)
	 	리스트에 값 호출하는 방법	: 해당 인덱스의 객체를 호출
	 		리스트객체명.get(인덱스)
	 	리스트의 값을 삭제하는 방법		: 해당 인덱스의 객체를 삭제[중각 객체 삭제해도 자동채움]
	 		리스트객체명.remove(인덱스)
	 		
	 	리스트의 길이
	 		리스트객체명.size();
	 	
	 	
	 			|		v-> c 매개변수		|	c -v에게 리턴해줄 값		|
	 	  --------------------------------------------------------
	 	  글등록	| String (작성자 , 글내용)	| boolean 등록여부			|
	 	  --------------------------------------------------------
	 	  글목록	| int 인덱스번호			| BoardDto 객체 			|
	 	  --------------------------------------------------------
	 	  글삭제	| int 인덱스번호			| boolean 삭제여부			|
	 	  --------------------------------------------------------
	 	  글수정	| int인덱스 String작성자,내용| boolean 수정여부 		|
	 	   
	 	  
	 */ 

}
