package java1.day13.Ex2.model.dto;

public class BoardDto {
	//싱글톤(공유)x, 게시물\ 하나당 DTo 1개이기 때문ㅇ[
	
	//1. 필드
		//1. 작성자, 내용, 조회수
		//2. 객체내에서 필드로 직접접근하는 것을 막기 위해서 private으로 선언하는 것을 권장함
	private String  writer;
	private String content;
	private int view;
	
	
	//2. 생성자
		// 권장사항 - 빈생성자, 풀생성자 , 기타생성자(등록할때 필요한 생성자)
		// ctrl_space bar
	
		//(권장)빈생성자
	public BoardDto() {}
	
		//(권장)풀생성자
	public BoardDto(String writer, String content, int view) {
		super();
		this.writer = writer;
		this.content = content;
		this.view = view;
	}
	
		// (선택) 게시물 등록시 사용되는 생성자
	public BoardDto(String writer, String content) {
		super();
		this.writer = writer;
		this.content = content;
	}

	
	//3. 메소드
		//1. getter setter
			// get필드명(); 필드에 값 호출할 때 사용되는 메소드
			// set필드명(); 필드에 값 대입할 때 사용하는 메소드
		//2. toString() : 객체를 호출하면 주소값이 반환되는데 , 객체내 필드 값을 확인하고 싶을때 사용할
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "BoardDto [writer=" + writer + ", content=" + content + ", view=" + view + "]";
	}
	
	
}
