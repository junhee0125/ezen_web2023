package 과제.과제11.model.dto;

public class BoardDto {
	//1. 필드
	private int bno;
	private String btitle;
	private String bcontent;
	private String bdate;
	private int bview;
	private int mno; // 작성자의 회원번호
	//화면에 작성자를 회원번호가 아닌 회원의 다른 정보 출력 : 예) 작성자에 회원번호대신, 아이디나 이름...
	//테이블을 나누는 이유는 중복을 제거하기 위해서
	private String mid; //회원번호를 이용한 회원테이블에서 조회가능 [테이블 합치기 join
	
	//쪽지용
	private int pno;
	private String pcontent;
	private int psender;	//보낸사람
	private int preciver;	//받는사람
	private String pdate;   //보낸날짜시간
	
	                                          
	// 2. 생성자
	//빈생서자
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	// 풀생성자
	
	//보드필드 풀생성자
	public BoardDto(int bno, String btitle, String bcontent, String bdate, int bview, int mno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.mid = mid;
	}
	
	// 기타 추가생성자 : 용도에 따라 만들면 된다는..
	// 글쓰기
	public BoardDto(String btitle, String bcontent, int mno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
	}
	
	//글수정용	
	public BoardDto(int bno, String btitle, String bcontent) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
	}
	
	// 쪽지보내기
	public BoardDto(int bno, int mno, String pcontent) {
	super();
	this.bno = bno;
	this.mno = mno;
	this.pcontent = pcontent;
}
	//쪽지가져오기
	public BoardDto(int bno, int pno, String pcontent, int psender, int preciver, String pdate) {
		super();
		this.bno = bno;
		this.pno = pno;
		this.pcontent = pcontent;
		this.psender = psender;
		this.preciver = preciver;
		this.pdate = pdate;
	}	
	
	// 3.  메소드
	public int getBno() {
		return bno;
	}	

	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getPsender() {
		return psender;
	}

	public void setPsender(int psender) {
		this.psender = psender;
	}

	public int getPreciver() {
		return preciver;
	}

	public void setPreciver(int preciver) {
		this.preciver = preciver;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bdate=" + bdate
				+ ", bview=" + bview + ", mno=" + mno + ", mid=" + mid + "]";
	}
	
	  
}
