package model.dto;

public class BoardDto {

	//필드
	private int bcno;
    private String bcname;
    private int bno;
    private String btitle;
    private String bcontent;
    private int mno;
    private int bveiw;
    private String bfile;
    private String bdate;

    private String mid;
    private String mfile;
    
    //조회댓ㅇ자와 게시물 작성 대상자 일치여부
    private boolean isHost; 

    //빈생성자
    public BoardDto() {
		// TODO Auto-generated constructor stub
	}

    //풀생성자
	public BoardDto(int bcno, String bcname, int bno, String btitle, String bcontent, int mno, int bveiw, String bfile,
			String bdate ,String mid,String mfile) {
		super();
		this.bcno = bcno;
		this.bcname = bcname;
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bveiw = bveiw;
		this.bfile = bfile;
		this.bdate = bdate;
		this.mid = mid;
		this.mfile = mfile;
	}

	// 글저장 생성자
	public BoardDto(int bcno, String btitle, String bcontent, int mno, String bfile) {
		super();
		this.bcno = bcno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bfile = bfile;
	}

	
	

	// 수정용 생성자
	public BoardDto(int bcno, int bno, String btitle, String bcontent, String bfile) {
		super();
		this.bcno = bcno;
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
	}

	public String getMfile() {
		return mfile;
	}

	public void setMfile(String mfile) {
		this.mfile = mfile;
	}

	public boolean isHost() {
		return isHost;
	}

	public void setHost(boolean isHost) {
		this.isHost = isHost;
	}

	public int getBcno() {
		return bcno;
	}

	public void setBcno(int bcno) {
		this.bcno = bcno;
	}

	public String getbcname() {
		return bcname;
	}

	public void setbcname(String bcname) {
		this.bcname = bcname;
	}

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

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getBveiw() {
		return bveiw;
	}

	public void setBveiw(int bveiw) {
		this.bveiw = bveiw;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "BoardDto [bcno=" + bcno + ", bcname=" + bcname + ", bno=" + bno + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", mno=" + mno + ", bveiw=" + bveiw + ", bfile=" + bfile + ", bdate=" + bdate + ", mid="
				+ mid + "]";
	}

	




}
