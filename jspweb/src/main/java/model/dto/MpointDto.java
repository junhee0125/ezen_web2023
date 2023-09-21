package model.dto;

public class MpointDto {

	// 필드
	String mpno;		//포인트식별번호 [UUID]
	int mno;			
	long mpamount;		// 포인트크기
	String mpcomment; 	// 포인트 지급사유
	String mpdate; 		// 포인트 지급날짜
	
	
	
	// 생성자
	public MpointDto() {
		// TODO Auto-generated constructor stub
	}

	

	public MpointDto(String mpno, int mno, long mpamount, String mpcomment) {
		super();
		this.mpno = mpno;
		this.mno = mno;
		this.mpamount = mpamount;
		this.mpcomment = mpcomment;
	}



	public MpointDto(String mpno, int mno, long mpamount, String mpcomment, String mpdate) {
		super();
		this.mpno = mpno;
		this.mno = mno;
		this.mpamount = mpamount;
		this.mpcomment = mpcomment;
		this.mpdate = mpdate;
	}


	// 메소드
	public String getMpno() {
		return mpno;
	}



	public void setMpno(String mpno) {
		this.mpno = mpno;
	}



	public int getMno() {
		return mno;
	}



	public void setMno(int mno) {
		this.mno = mno;
	}



	public long getMpamount() {
		return mpamount;
	}



	public void setMpamount(long mpamount) {
		this.mpamount = mpamount;
	}



	public String getMpcomment() {
		return mpcomment;
	}



	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}



	public String getMpdate() {
		return mpdate;
	}



	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}



	@Override
	public String toString() {
		return "MpointDto [mpno=" + mpno + ", mno=" + mno + ", mpamount=" + mpamount + ", mpcomment=" + mpcomment
				+ ", mpdate=" + mpdate + "]";
	}
	
	

	
}
