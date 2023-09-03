package model.dto;

public class BoardDto {

	//필드
	private int bcno;
    private String bcname;
    private int bno;
    private String btitle;
    private String bcontent;
    private int mno;
    private int bview;
    private String bfile;
    private String bdate;

    private String mid;
    private String mfile;


    //빈생성자
    public BoardDto() {
		// TODO Auto-generated constructor stub
	}

    //전체글 조회시
	public BoardDto(int bcno, String bcname, int bno, String btitle, String bcontent, int mno, int bview, String bfile,
			String bdate, String mid, String mfile) {
		super();
		this.bcno = bcno;
		this.bcname = bcname;
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bview = bview;
		this.bfile = bfile;
		this.bdate = bdate;
		this.mid = mid;
		this.mfile = mfile;
	}

	//글쓰기
	public BoardDto(int bcno, String btitle, String bcontent, int mno, String bfile) {
		super();
		this.bcno = bcno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mno = mno;
		this.bfile = bfile;
	}


	public int getBcno() {
		return bcno;
	}


	public void setBcno(int bcno) {
		this.bcno = bcno;
	}


	public String getBcname() {
		return bcname;
	}


	public void setBcname(String bcname) {
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
		return bview;
	}


	public void setBveiw(int bview) {
		this.bview = bview;
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


	public String getMfile() {
		return mfile;
	}


	public void setMfile(String mfile) {
		this.mfile = mfile;
	}


	@Override
	public String toString() {
		return "BoardDto [bcno=" + bcno + ", bcname=" + bcname + ", bno=" + bno + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", mno=" + mno + ", bview=" + bview + ", bfile=" + bfile + ", bdate=" + bdate + ", mid="
				+ mid + ", mfile=" + mfile + "]";
	}










}
